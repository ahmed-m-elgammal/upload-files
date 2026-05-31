package net.time4j.scale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.base.UnixTime;

/* loaded from: classes7.dex */
public final class LeapSeconds implements Iterable<LeapSecondEvent>, Comparator<LeapSecondEvent> {
    private static final long MJD_OFFSET = 40587;
    private static final long UNIX_OFFSET = 63072000;
    private final List<ExtendedLSE> list;
    private final LeapSecondProvider provider;
    private final ExtendedLSE[] reverseFinal;
    private volatile ExtendedLSE[] reverseVolatile;
    private final boolean supportsNegativeLS;
    public static final boolean SUPPRESS_UTC_LEAPSECONDS = Boolean.getBoolean("net.time4j.scale.leapseconds.suppressed");
    public static final boolean FINAL_UTC_LEAPSECONDS = Boolean.getBoolean("net.time4j.scale.leapseconds.final");
    public static final String PATH_TO_LEAPSECONDS = System.getProperty("net.time4j.scale.leapseconds.path", "data/leapseconds.data");
    private static final ExtendedLSE[] EMPTY_ARRAY = new ExtendedLSE[0];
    private static final LeapSeconds INSTANCE = new LeapSeconds();

    private LeapSeconds() {
        LeapSecondProvider leapSecondProvider;
        int i;
        boolean z = false;
        if (SUPPRESS_UTC_LEAPSECONDS) {
            leapSecondProvider = null;
            i = 0;
        } else {
            leapSecondProvider = null;
            i = 0;
            for (LeapSecondProvider leapSecondProvider2 : ResourceLoader.getInstance().services(LeapSecondProvider.class)) {
                int size = leapSecondProvider2.getLeapSecondTable().size();
                if (size > i) {
                    leapSecondProvider = leapSecondProvider2;
                    i = size;
                }
            }
        }
        if (leapSecondProvider == null || i == 0) {
            this.provider = null;
            this.list = Collections.emptyList();
            ExtendedLSE[] extendedLSEArr = EMPTY_ARRAY;
            this.reverseFinal = extendedLSEArr;
            this.reverseVolatile = extendedLSEArr;
            this.supportsNegativeLS = false;
            return;
        }
        TreeSet treeSet = new TreeSet(this);
        for (Map.Entry<GregorianDate, Integer> entry : leapSecondProvider.getLeapSecondTable().entrySet()) {
            treeSet.add(new SimpleLeapSecondEvent(entry.getKey(), Long.MIN_VALUE, toPosix(r7) - 62985601, entry.getValue().intValue()));
        }
        extend(treeSet);
        boolean z2 = FINAL_UTC_LEAPSECONDS;
        if (z2) {
            this.list = Collections.unmodifiableList(new ArrayList(treeSet));
        } else {
            this.list = new CopyOnWriteArrayList(treeSet);
        }
        ExtendedLSE[] initReverse = initReverse();
        this.reverseFinal = initReverse;
        this.reverseVolatile = initReverse;
        this.provider = leapSecondProvider;
        if (z2) {
            boolean supportsNegativeLS = leapSecondProvider.supportsNegativeLS();
            if (supportsNegativeLS) {
                Iterator<ExtendedLSE> it = this.list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getShift() < 0) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                supportsNegativeLS = z;
            }
            this.supportsNegativeLS = supportsNegativeLS;
            return;
        }
        this.supportsNegativeLS = true;
    }

    public static LeapSeconds getInstance() {
        return INSTANCE;
    }

    public boolean isEnabled() {
        return !this.list.isEmpty();
    }

    public boolean isExtensible() {
        return !FINAL_UTC_LEAPSECONDS && isEnabled();
    }

    public int getCount() {
        return getEventsInDescendingOrder().length;
    }

    public int getCount(UnixTime unixTime) {
        long posixTime = unixTime.getPosixTime();
        return MathUtils.safeCast((enhance(posixTime) + UNIX_OFFSET) - posixTime);
    }

    public void registerPositiveLS(int i, int i2, int i3) {
        register(i, i2, i3, false);
    }

    public void registerNegativeLS(int i, int i2, int i3) {
        register(i, i2, i3, true);
    }

    public boolean supportsNegativeLS() {
        return this.supportsNegativeLS;
    }

    @Override // java.lang.Iterable
    public Iterator<LeapSecondEvent> iterator() {
        return Collections.unmodifiableList(Arrays.asList(getEventsInDescendingOrder())).iterator();
    }

    public int getShift(GregorianDate gregorianDate) {
        int year = gregorianDate.getYear();
        if (year >= 1972) {
            for (ExtendedLSE extendedLSE : getEventsInDescendingOrder()) {
                GregorianDate date = extendedLSE.getDate();
                if (year == date.getYear() && gregorianDate.getMonth() == date.getMonth() && gregorianDate.getDayOfMonth() == date.getDayOfMonth()) {
                    return extendedLSE.getShift();
                }
            }
        }
        return 0;
    }

    public int getShift(long j) {
        if (j <= 0) {
            return 0;
        }
        for (ExtendedLSE extendedLSE : getEventsInDescendingOrder()) {
            if (j > extendedLSE.utc()) {
                return 0;
            }
            long utc = extendedLSE.utc() - extendedLSE.getShift();
            if (j > utc) {
                return (int) (j - utc);
            }
        }
        return 0;
    }

    public LeapSecondEvent getNextEvent(long j) {
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        ExtendedLSE extendedLSE = null;
        int i = 0;
        while (i < eventsInDescendingOrder.length) {
            ExtendedLSE extendedLSE2 = eventsInDescendingOrder[i];
            if (j >= extendedLSE2.utc()) {
                break;
            }
            i++;
            extendedLSE = extendedLSE2;
        }
        return extendedLSE;
    }

    public long enhance(long j) {
        long j2 = j - UNIX_OFFSET;
        if (j <= 0) {
            return j2;
        }
        for (ExtendedLSE extendedLSE : getEventsInDescendingOrder()) {
            if (extendedLSE.raw() < j2) {
                return MathUtils.safeAdd(j2, extendedLSE.utc() - extendedLSE.raw());
            }
        }
        return j2;
    }

    public long strip(long j) {
        if (j <= 0) {
            return j + UNIX_OFFSET;
        }
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        boolean z = this.supportsNegativeLS;
        for (ExtendedLSE extendedLSE : eventsInDescendingOrder) {
            if (extendedLSE.utc() - extendedLSE.getShift() < j || (z && extendedLSE.getShift() < 0 && extendedLSE.utc() < j)) {
                j = MathUtils.safeAdd(j, extendedLSE.raw() - extendedLSE.utc());
                break;
            }
        }
        return j + UNIX_OFFSET;
    }

    public boolean isPositiveLS(long j) {
        if (j <= 0) {
            return false;
        }
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        for (int i = 0; i < eventsInDescendingOrder.length; i++) {
            long utc = eventsInDescendingOrder[i].utc();
            if (utc == j) {
                return eventsInDescendingOrder[i].getShift() == 1;
            }
            if (utc < j) {
                break;
            }
        }
        return false;
    }

    public GregorianDate getDateOfExpiration() {
        if (!isEnabled()) {
            throw new IllegalStateException("Leap seconds not activated.");
        }
        return this.provider.getDateOfExpiration();
    }

    @Override // java.util.Comparator
    public int compare(LeapSecondEvent leapSecondEvent, LeapSecondEvent leapSecondEvent2) {
        GregorianDate date = leapSecondEvent.getDate();
        GregorianDate date2 = leapSecondEvent2.getDate();
        int year = date.getYear();
        int year2 = date2.getYear();
        if (year < year2) {
            return -1;
        }
        if (year > year2) {
            return 1;
        }
        int month = date.getMonth();
        int month2 = date2.getMonth();
        if (month < month2) {
            return -1;
        }
        if (month > month2) {
            return 1;
        }
        int dayOfMonth = date.getDayOfMonth();
        int dayOfMonth2 = date2.getDayOfMonth();
        if (dayOfMonth < dayOfMonth2) {
            return -1;
        }
        return dayOfMonth == dayOfMonth2 ? 0 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(2048);
        sb.append("[PROVIDER=");
        sb.append(this.provider);
        if (this.provider != null) {
            sb.append(",EXPIRES=");
            sb.append(format(getDateOfExpiration()));
        }
        sb.append(",EVENTS=[");
        if (isEnabled()) {
            boolean z = true;
            for (ExtendedLSE extendedLSE : this.list) {
                if (z) {
                    z = false;
                } else {
                    sb.append('|');
                }
                sb.append(extendedLSE);
            }
        } else {
            sb.append("NOT SUPPORTED");
        }
        sb.append("]]");
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r7 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void register(int r4, int r5, int r6, boolean r7) {
        /*
            r3 = this;
            boolean r0 = net.time4j.scale.LeapSeconds.FINAL_UTC_LEAPSECONDS
            if (r0 != 0) goto L72
            boolean r0 = net.time4j.scale.LeapSeconds.SUPPRESS_UTC_LEAPSECONDS
            if (r0 != 0) goto L6a
            monitor-enter(r3)
            net.time4j.base.GregorianMath.checkDate(r4, r5, r6)     // Catch: java.lang.Throwable -> L67
            boolean r0 = r3.isEnabled()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L5f
            net.time4j.scale.ExtendedLSE[] r0 = r3.reverseVolatile     // Catch: java.lang.Throwable -> L67
            r1 = 0
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L67
            net.time4j.base.GregorianDate r1 = r0.getDate()     // Catch: java.lang.Throwable -> L67
            int r2 = r1.getYear()     // Catch: java.lang.Throwable -> L67
            if (r4 <= r2) goto L22
            goto L3b
        L22:
            int r2 = r1.getYear()     // Catch: java.lang.Throwable -> L67
            if (r4 != r2) goto L57
            int r2 = r1.getMonth()     // Catch: java.lang.Throwable -> L67
            if (r5 <= r2) goto L2f
            goto L3b
        L2f:
            int r2 = r1.getMonth()     // Catch: java.lang.Throwable -> L67
            if (r5 != r2) goto L57
            int r1 = r1.getDayOfMonth()     // Catch: java.lang.Throwable -> L67
            if (r6 <= r1) goto L57
        L3b:
            if (r7 == 0) goto L3f
            r7 = -1
            goto L40
        L3f:
            r7 = 1
        L40:
            net.time4j.scale.LeapSecondProvider r1 = r3.provider     // Catch: java.lang.Throwable -> L67
            net.time4j.base.GregorianDate r4 = r1.getDateOfEvent(r4, r5, r6)     // Catch: java.lang.Throwable -> L67
            java.util.List<net.time4j.scale.ExtendedLSE> r5 = r3.list     // Catch: java.lang.Throwable -> L67
            net.time4j.scale.ExtendedLSE r4 = createLSE(r4, r7, r0)     // Catch: java.lang.Throwable -> L67
            r5.add(r4)     // Catch: java.lang.Throwable -> L67
            net.time4j.scale.ExtendedLSE[] r4 = r3.initReverse()     // Catch: java.lang.Throwable -> L67
            r3.reverseVolatile = r4     // Catch: java.lang.Throwable -> L67
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L67
            return
        L57:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L67
            java.lang.String r5 = "New leap second must be after last leap second."
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L67
            throw r4     // Catch: java.lang.Throwable -> L67
        L5f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L67
            java.lang.String r5 = "Leap seconds not activated."
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L67
            throw r4     // Catch: java.lang.Throwable -> L67
        L67:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L67
            throw r4
        L6a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Leap seconds are not supported, change requires edit of system property \"time4j.utc.leapseconds.suppressed\" and reboot of JVM."
            r4.<init>(r5)
            throw r4
        L72:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Leap seconds are final, change requires edit of system property \"time4j.utc.leapseconds.final\" and reboot of JVM."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.scale.LeapSeconds.register(int, int, int, boolean):void");
    }

    private ExtendedLSE[] getEventsInDescendingOrder() {
        if (SUPPRESS_UTC_LEAPSECONDS || FINAL_UTC_LEAPSECONDS) {
            return this.reverseFinal;
        }
        return this.reverseVolatile;
    }

    private static void extend(SortedSet<ExtendedLSE> sortedSet) {
        ArrayList arrayList = new ArrayList(sortedSet.size());
        int i = 0;
        for (ExtendedLSE extendedLSE : sortedSet) {
            if (extendedLSE.utc() == Long.MIN_VALUE) {
                i += extendedLSE.getShift();
                arrayList.add(new SimpleLeapSecondEvent(extendedLSE, i));
            } else {
                arrayList.add(extendedLSE);
            }
        }
        sortedSet.clear();
        sortedSet.addAll(arrayList);
    }

    private static ExtendedLSE createLSE(GregorianDate gregorianDate, int i, ExtendedLSE extendedLSE) {
        long posix = toPosix(gregorianDate) - 62985601;
        return new SimpleLeapSecondEvent(gregorianDate, posix + ((int) ((extendedLSE.utc() - extendedLSE.raw()) + i)), posix, i);
    }

    private static long toPosix(GregorianDate gregorianDate) {
        return MathUtils.safeMultiply(MathUtils.safeSubtract(GregorianMath.toMJD(gregorianDate), MJD_OFFSET), 86400L);
    }

    private ExtendedLSE[] initReverse() {
        ArrayList arrayList = new ArrayList(this.list.size());
        arrayList.addAll(this.list);
        Collections.reverse(arrayList);
        return (ExtendedLSE[]) arrayList.toArray(new ExtendedLSE[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String format(GregorianDate gregorianDate) {
        return String.format("%1$04d-%2$02d-%3$02d", Integer.valueOf(gregorianDate.getYear()), Integer.valueOf(gregorianDate.getMonth()), Integer.valueOf(gregorianDate.getDayOfMonth()));
    }

    private static class SimpleLeapSecondEvent implements ExtendedLSE, Serializable {
        private static final long serialVersionUID = 5986185471610524587L;
        private final long _raw;
        private final long _utc;
        private final GregorianDate date;
        private final int shift;

        SimpleLeapSecondEvent(GregorianDate gregorianDate, long j, long j2, int i) {
            this.date = gregorianDate;
            this.shift = i;
            this._utc = j;
            this._raw = j2;
        }

        SimpleLeapSecondEvent(ExtendedLSE extendedLSE, int i) {
            this.date = extendedLSE.getDate();
            this.shift = extendedLSE.getShift();
            this._utc = extendedLSE.raw() + i;
            this._raw = extendedLSE.raw();
        }

        @Override // net.time4j.scale.LeapSecondEvent
        public GregorianDate getDate() {
            return this.date;
        }

        @Override // net.time4j.scale.LeapSecondEvent
        public int getShift() {
            return this.shift;
        }

        @Override // net.time4j.scale.ExtendedLSE
        public long utc() {
            return this._utc;
        }

        @Override // net.time4j.scale.ExtendedLSE
        public long raw() {
            return this._raw;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append(LeapSecondEvent.class.getName());
            sb.append('[');
            sb.append(LeapSeconds.format(this.date));
            sb.append(": utc=");
            sb.append(this._utc);
            sb.append(", raw=");
            sb.append(this._raw);
            sb.append(" (shift=");
            sb.append(this.shift);
            sb.append(")]");
            return sb.toString();
        }
    }
}

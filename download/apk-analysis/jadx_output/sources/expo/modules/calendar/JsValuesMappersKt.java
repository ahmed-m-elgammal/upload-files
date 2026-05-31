package expo.modules.calendar;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: JsValuesMappers.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a \u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0000\u001a \u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0000\u001a \u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0016\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0018"}, d2 = {"accessConstantMatchingString", "", "string", "", "accessStringMatchingConstant", RRWebVideoEvent.REPLAY_FRAME_RATE_TYPE_CONSTANT, "attendeeRelationshipConstantMatchingString", "attendeeRelationshipStringMatchingConstant", "attendeeStatusConstantMatchingString", "attendeeStatusStringMatchingConstant", "attendeeTypeConstantMatchingString", "attendeeTypeStringMatchingConstant", "availabilityConstantMatchingString", "availabilityStringMatchingConstant", "calAccessConstantMatchingString", "calAccessStringMatchingConstant", "calendarAllowedAttendeeTypesFromDBString", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dbString", "calendarAllowedAvailabilitiesFromDBString", "calendarAllowedRemindersFromDBString", "reminderConstantMatchingString", "reminderStringMatchingConstant", "expo-calendar_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JsValuesMappersKt {
    public static final String reminderStringMatchingConstant(int i) {
        if (i == 0) {
            return "default";
        }
        if (i == 1) {
            return "alert";
        }
        if (i == 2) {
            return "email";
        }
        if (i == 3) {
            return "sms";
        }
        if (i != 4) {
            return "default";
        }
        return NotificationCompat.CATEGORY_ALARM;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final int reminderConstantMatchingString(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case 114009:
                    if (str.equals("sms")) {
                        return 3;
                    }
                    break;
                case 92895825:
                    if (str.equals(NotificationCompat.CATEGORY_ALARM)) {
                        return 4;
                    }
                    break;
                case 92899676:
                    if (str.equals("alert")) {
                        return 1;
                    }
                    break;
                case 96619420:
                    if (str.equals("email")) {
                        return 2;
                    }
                    break;
            }
        }
        return 0;
    }

    public static final ArrayList<String> calendarAllowedRemindersFromDBString(String dbString) {
        Intrinsics.checkNotNullParameter(dbString, "dbString");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : (String[]) StringsKt.split$default((CharSequence) dbString, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0])) {
            try {
                arrayList.add(reminderStringMatchingConstant(Integer.parseInt(str)));
            } catch (NumberFormatException e) {
                Log.e(CalendarModule.INSTANCE.getTAG$expo_calendar_release(), "Couldn't convert reminder constant into an int.", e);
            }
        }
        return arrayList;
    }

    public static final ArrayList<String> calendarAllowedAvailabilitiesFromDBString(String dbString) {
        Intrinsics.checkNotNullParameter(dbString, "dbString");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : (String[]) StringsKt.split$default((CharSequence) dbString, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0])) {
            int parseInt = Integer.parseInt(str);
            if (parseInt == 0) {
                arrayList.add("busy");
            } else if (parseInt == 1) {
                arrayList.add("free");
            } else if (parseInt == 2) {
                arrayList.add("tentative");
            }
        }
        return arrayList;
    }

    public static final String availabilityStringMatchingConstant(int i) {
        if (i == 0) {
            return "busy";
        }
        if (i == 1) {
            return "free";
        }
        if (i != 2) {
            return "busy";
        }
        return "tentative";
    }

    public static final int availabilityConstantMatchingString(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (Intrinsics.areEqual(string, "free")) {
            return 1;
        }
        return Intrinsics.areEqual(string, "tentative") ? 2 : 0;
    }

    public static final String accessStringMatchingConstant(int i) {
        if (i == 0) {
            return "default";
        }
        if (i == 1) {
            return "confidential";
        }
        if (i == 2) {
            return "private";
        }
        if (i != 3) {
            return "default";
        }
        return "public";
    }

    public static final int accessConstantMatchingString(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        int hashCode = string.hashCode();
        if (hashCode != -1952990840) {
            if (hashCode != -977423767) {
                if (hashCode == -314497661 && string.equals("private")) {
                    return 2;
                }
            } else if (string.equals("public")) {
                return 3;
            }
        } else if (string.equals("confidential")) {
            return 1;
        }
        return 0;
    }

    public static final String calAccessStringMatchingConstant(int i) {
        if (i == 0) {
            return "none";
        }
        if (i == 100) {
            return "freebusy";
        }
        if (i == 200) {
            return "read";
        }
        if (i == 300) {
            return "respond";
        }
        if (i == 400) {
            return "override";
        }
        if (i == 500) {
            return "contributor";
        }
        if (i == 600) {
            return "editor";
        }
        if (i == 700) {
            return "owner";
        }
        if (i != 800) {
            return "none";
        }
        return CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int calAccessConstantMatchingString(java.lang.String r1) {
        /*
            java.lang.String r0 = "string"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            int r0 = r1.hashCode()
            switch(r0) {
                case -1895276325: goto L62;
                case -1537912219: goto L56;
                case -1307827859: goto L4a;
                case 3496342: goto L3e;
                case 3506402: goto L32;
                case 106164915: goto L26;
                case 529996748: goto L1a;
                case 1097400469: goto Le;
                default: goto Lc;
            }
        Lc:
            goto L6e
        Le:
            java.lang.String r0 = "respond"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L17
            goto L6e
        L17:
            r1 = 300(0x12c, float:4.2E-43)
            goto L6f
        L1a:
            java.lang.String r0 = "override"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L23
            goto L6e
        L23:
            r1 = 400(0x190, float:5.6E-43)
            goto L6f
        L26:
            java.lang.String r0 = "owner"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L2f
            goto L6e
        L2f:
            r1 = 700(0x2bc, float:9.81E-43)
            goto L6f
        L32:
            java.lang.String r0 = "root"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L3b
            goto L6e
        L3b:
            r1 = 800(0x320, float:1.121E-42)
            goto L6f
        L3e:
            java.lang.String r0 = "read"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L47
            goto L6e
        L47:
            r1 = 200(0xc8, float:2.8E-43)
            goto L6f
        L4a:
            java.lang.String r0 = "editor"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L53
            goto L6e
        L53:
            r1 = 600(0x258, float:8.41E-43)
            goto L6f
        L56:
            java.lang.String r0 = "freebusy"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L5f
            goto L6e
        L5f:
            r1 = 100
            goto L6f
        L62:
            java.lang.String r0 = "contributor"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L6b
            goto L6e
        L6b:
            r1 = 500(0x1f4, float:7.0E-43)
            goto L6f
        L6e:
            r1 = 0
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.calendar.JsValuesMappersKt.calAccessConstantMatchingString(java.lang.String):int");
    }

    public static final String attendeeRelationshipStringMatchingConstant(int i) {
        if (i == 0) {
            return "none";
        }
        if (i == 1) {
            return "attendee";
        }
        if (i == 2) {
            return "organizer";
        }
        if (i == 3) {
            return "performer";
        }
        if (i != 4) {
            return "none";
        }
        return "speaker";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int attendeeRelationshipConstantMatchingString(java.lang.String r1) {
        /*
            java.lang.String r0 = "string"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            int r0 = r1.hashCode()
            switch(r0) {
                case -2141605073: goto L2e;
                case -2008522753: goto L23;
                case 481140686: goto L18;
                case 542756026: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L39
        Ld:
            java.lang.String r0 = "attendee"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L16
            goto L39
        L16:
            r1 = 1
            goto L3a
        L18:
            java.lang.String r0 = "performer"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L21
            goto L39
        L21:
            r1 = 3
            goto L3a
        L23:
            java.lang.String r0 = "speaker"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L2c
            goto L39
        L2c:
            r1 = 4
            goto L3a
        L2e:
            java.lang.String r0 = "organizer"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L37
            goto L39
        L37:
            r1 = 2
            goto L3a
        L39:
            r1 = 0
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.calendar.JsValuesMappersKt.attendeeRelationshipConstantMatchingString(java.lang.String):int");
    }

    public static final String attendeeTypeStringMatchingConstant(int i) {
        if (i == 0) {
            return "none";
        }
        if (i == 1) {
            return "required";
        }
        if (i == 2) {
            return "optional";
        }
        if (i != 3) {
            return "none";
        }
        return "resource";
    }

    public static final int attendeeTypeConstantMatchingString(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        int hashCode = string.hashCode();
        if (hashCode != -393139297) {
            if (hashCode != -341064690) {
                if (hashCode == -79017120 && string.equals("optional")) {
                    return 2;
                }
            } else if (string.equals("resource")) {
                return 3;
            }
        } else if (string.equals("required")) {
            return 1;
        }
        return 0;
    }

    public static final ArrayList<String> calendarAllowedAttendeeTypesFromDBString(String dbString) {
        Intrinsics.checkNotNullParameter(dbString, "dbString");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : (String[]) StringsKt.split$default((CharSequence) dbString, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0])) {
            try {
                arrayList.add(attendeeTypeStringMatchingConstant(Integer.parseInt(str)));
            } catch (NumberFormatException e) {
                Log.e(CalendarModule.INSTANCE.getTAG$expo_calendar_release(), "Couldn't convert attendee constant into an int.", e);
            }
        }
        return arrayList;
    }

    public static final String attendeeStatusStringMatchingConstant(int i) {
        if (i == 0) {
            return "none";
        }
        if (i == 1) {
            return "accepted";
        }
        if (i == 2) {
            return "declined";
        }
        if (i == 3) {
            return "invited";
        }
        if (i != 4) {
            return "none";
        }
        return "tentative";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int attendeeStatusConstantMatchingString(java.lang.String r1) {
        /*
            java.lang.String r0 = "string"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            int r0 = r1.hashCode()
            switch(r0) {
                case -2146525273: goto L2e;
                case -1320822226: goto L23;
                case 568196142: goto L18;
                case 1960030843: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L39
        Ld:
            java.lang.String r0 = "invited"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L16
            goto L39
        L16:
            r1 = 3
            goto L3a
        L18:
            java.lang.String r0 = "declined"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L21
            goto L39
        L21:
            r1 = 2
            goto L3a
        L23:
            java.lang.String r0 = "tentative"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L2c
            goto L39
        L2c:
            r1 = 4
            goto L3a
        L2e:
            java.lang.String r0 = "accepted"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L37
            goto L39
        L37:
            r1 = 1
            goto L3a
        L39:
            r1 = 0
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.calendar.JsValuesMappersKt.attendeeStatusConstantMatchingString(java.lang.String):int");
    }
}

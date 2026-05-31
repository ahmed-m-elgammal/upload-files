package expo.modules.calendar;

import android.content.ContentValues;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.core.arguments.ReadableArguments;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalendarEventBuilder.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0002J\u001f\u0010\u000b\u001a\u00020\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\r\"\u00020\n¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0014J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ\u001e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J2\u0010\u0018\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00190\u001bJ\u0016\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ*\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140\u001bJ\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lexpo/modules/calendar/CalendarEventBuilder;", "", "eventDetails", "Lexpo/modules/core/arguments/ReadableArguments;", "(Lexpo/modules/core/arguments/ReadableArguments;)V", "eventValues", "Landroid/content/ContentValues;", "build", "checkDetailsContainsRequiredKey", SDKConstants.PARAM_KEY, "", "checkIfContainsRequiredKeys", "keys", "", "([Ljava/lang/String;)Lexpo/modules/calendar/CalendarEventBuilder;", "getAsLong", "", "put", "value", "", "", "putEventBoolean", "eventKey", "detailsKey", "putEventDetailsList", "OutputListItemType", "mappingMethod", "Lkotlin/Function1;", "putEventString", "mapper", "putEventTimeZone", "putNull", "expo-calendar_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CalendarEventBuilder {
    private final ReadableArguments eventDetails;
    private final ContentValues eventValues;

    public CalendarEventBuilder(ReadableArguments eventDetails) {
        Intrinsics.checkNotNullParameter(eventDetails, "eventDetails");
        this.eventDetails = eventDetails;
        this.eventValues = new ContentValues();
    }

    public final long getAsLong(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Long asLong = this.eventValues.getAsLong(key);
        Intrinsics.checkNotNullExpressionValue(asLong, "getAsLong(...)");
        return asLong.longValue();
    }

    public final CalendarEventBuilder put(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.eventValues.put(key, value);
        return this;
    }

    public final CalendarEventBuilder put(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.eventValues.put(key, Integer.valueOf(value));
        return this;
    }

    public final CalendarEventBuilder put(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.eventValues.put(key, Long.valueOf(value));
        return this;
    }

    public final CalendarEventBuilder put(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.eventValues.put(key, Boolean.valueOf(value));
        return this;
    }

    public final CalendarEventBuilder putNull(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.eventValues.putNull(key);
        return this;
    }

    public final CalendarEventBuilder checkIfContainsRequiredKeys(String... keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (String str : keys) {
            checkDetailsContainsRequiredKey(str);
        }
        return this;
    }

    public final CalendarEventBuilder putEventString(String eventKey, String detailsKey) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(detailsKey, "detailsKey");
        if (this.eventDetails.containsKey(detailsKey)) {
            this.eventValues.put(eventKey, this.eventDetails.getString(detailsKey));
        }
        return this;
    }

    public final CalendarEventBuilder putEventString(String eventKey, String detailsKey, Function1<? super String, Integer> mapper) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(detailsKey, "detailsKey");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        if (this.eventDetails.containsKey(detailsKey)) {
            ContentValues contentValues = this.eventValues;
            String string = this.eventDetails.getString(detailsKey);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            contentValues.put(eventKey, mapper.invoke(string));
        }
        return this;
    }

    public final CalendarEventBuilder putEventBoolean(String eventKey, String detailsKey) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(detailsKey, "detailsKey");
        if (this.eventDetails.containsKey(detailsKey)) {
            this.eventValues.put(eventKey, Integer.valueOf(this.eventDetails.getBoolean(detailsKey) ? 1 : 0));
        }
        return this;
    }

    public final CalendarEventBuilder putEventBoolean(String eventKey, String detailsKey, boolean value) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(detailsKey, "detailsKey");
        if (this.eventDetails.containsKey(detailsKey)) {
            this.eventValues.put(eventKey, Boolean.valueOf(value));
        }
        return this;
    }

    public final CalendarEventBuilder putEventTimeZone(String eventKey, String detailsKey) {
        String id;
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(detailsKey, "detailsKey");
        ContentValues contentValues = this.eventValues;
        if (this.eventDetails.containsKey(detailsKey)) {
            id = this.eventDetails.getString(detailsKey);
        } else {
            id = TimeZone.getDefault().getID();
        }
        contentValues.put(eventKey, id);
        return this;
    }

    public final <OutputListItemType> CalendarEventBuilder putEventDetailsList(String eventKey, String detailsKey, Function1<Object, ? extends OutputListItemType> mappingMethod) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(detailsKey, "detailsKey");
        Intrinsics.checkNotNullParameter(mappingMethod, "mappingMethod");
        if (this.eventDetails.containsKey(eventKey)) {
            List list = this.eventDetails.getList(eventKey);
            Intrinsics.checkNotNull(list);
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(mappingMethod.invoke(it.next()));
            }
            this.eventValues.put(detailsKey, TextUtils.join(",", arrayList));
        }
        return this;
    }

    private final CalendarEventBuilder checkDetailsContainsRequiredKey(String key) {
        if (this.eventDetails.containsKey(key)) {
            return this;
        }
        throw new Exception("new calendars require " + key);
    }

    /* renamed from: build, reason: from getter */
    public final ContentValues getEventValues() {
        return this.eventValues;
    }
}

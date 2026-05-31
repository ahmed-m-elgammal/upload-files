package expo.modules.calendar;

import android.content.ContentValues;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.core.arguments.ReadableArguments;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendeeBuilder.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u001d\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nJ\u001e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J9\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/calendar/AttendeeBuilder;", "", "attendeeDetails", "Lexpo/modules/core/arguments/ReadableArguments;", "(Lexpo/modules/core/arguments/ReadableArguments;)V", "attendeeValues", "Landroid/content/ContentValues;", "build", "put", SDKConstants.PARAM_KEY, "", "value", "", "(Ljava/lang/String;Ljava/lang/Integer;)Lexpo/modules/calendar/AttendeeBuilder;", "putString", "detailsKey", "detailsString", "isRequired", "", "mapper", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)Lexpo/modules/calendar/AttendeeBuilder;", "expo-calendar_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AttendeeBuilder {
    private final ReadableArguments attendeeDetails;
    private final ContentValues attendeeValues;

    public AttendeeBuilder(ReadableArguments attendeeDetails) {
        Intrinsics.checkNotNullParameter(attendeeDetails, "attendeeDetails");
        this.attendeeDetails = attendeeDetails;
        this.attendeeValues = new ContentValues();
    }

    public final AttendeeBuilder put(String key, Integer value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.attendeeValues.put(key, value);
        return this;
    }

    public final AttendeeBuilder putString(String detailsKey, String detailsString) {
        Intrinsics.checkNotNullParameter(detailsKey, "detailsKey");
        Intrinsics.checkNotNullParameter(detailsString, "detailsString");
        if (this.attendeeDetails.containsKey(detailsKey)) {
            this.attendeeValues.put(detailsString, this.attendeeDetails.getString(detailsKey));
        }
        return this;
    }

    public final AttendeeBuilder putString(String detailsKey, String detailsString, boolean isRequired) {
        Intrinsics.checkNotNullParameter(detailsKey, "detailsKey");
        Intrinsics.checkNotNullParameter(detailsString, "detailsString");
        if (this.attendeeDetails.containsKey(detailsKey)) {
            this.attendeeValues.put(detailsString, this.attendeeDetails.getString(detailsKey));
        } else if (isRequired) {
            throw new Exception("new attendees require `" + detailsKey + "`");
        }
        return this;
    }

    public final AttendeeBuilder putString(String detailsKey, String detailsString, Boolean isRequired, Function1<? super String, Integer> mapper) {
        Intrinsics.checkNotNullParameter(detailsKey, "detailsKey");
        Intrinsics.checkNotNullParameter(detailsString, "detailsString");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        if (this.attendeeDetails.containsKey(detailsKey)) {
            ContentValues contentValues = this.attendeeValues;
            String string = this.attendeeDetails.getString(detailsKey);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            contentValues.put(detailsString, mapper.invoke(string));
        } else if (Intrinsics.areEqual((Object) isRequired, (Object) true)) {
            throw new Exception("new attendees require `" + detailsKey + "`");
        }
        return this;
    }

    /* renamed from: build, reason: from getter */
    public final ContentValues getAttendeeValues() {
        return this.attendeeValues;
    }
}

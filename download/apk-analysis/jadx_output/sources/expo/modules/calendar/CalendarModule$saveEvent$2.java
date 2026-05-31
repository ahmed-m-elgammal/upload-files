package expo.modules.calendar;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalendarModule.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class CalendarModule$saveEvent$2 extends FunctionReferenceImpl implements Function1<String, Integer> {
    public static final CalendarModule$saveEvent$2 INSTANCE = new CalendarModule$saveEvent$2();

    CalendarModule$saveEvent$2() {
        super(1, JsValuesMappersKt.class, "accessConstantMatchingString", "accessConstantMatchingString(Ljava/lang/String;)I", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Integer.valueOf(JsValuesMappersKt.accessConstantMatchingString(p0));
    }
}

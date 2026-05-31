package com.microsoft.clarity.f;

import androidx.work.WorkInfo;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class I extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WorkInfo f108a;
    public final /* synthetic */ M b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(WorkInfo workInfo, M m) {
        super(0);
        this.f108a = workInfo;
        this.b = m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        WorkInfo workInfo = this.f108a;
        if ((workInfo != null ? workInfo.getState() : null) == WorkInfo.State.SUCCEEDED) {
            Function2<String, String, Unit> customSignalsCallback = this.b.b.getCustomSignalsCallback();
            Intrinsics.checkNotNull(customSignalsCallback);
            Map<String, Object> keyValueMap = this.f108a.getOutputData().getKeyValueMap();
            Intrinsics.checkNotNullExpressionValue(keyValueMap, "it.outputData.keyValueMap");
            for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                if (StringsKt.startsWith$default(key, "SIGNAL", false, 2, (Object) null)) {
                    if (value == null ? true : value instanceof String) {
                        customSignalsCallback.invoke(StringsKt.removePrefix(key, (CharSequence) "SIGNAL_"), value);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}

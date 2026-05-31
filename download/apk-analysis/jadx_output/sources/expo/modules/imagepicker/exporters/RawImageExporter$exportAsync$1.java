package expo.modules.imagepicker.exporters;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RawImageExporter.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagepicker.exporters.RawImageExporter", f = "RawImageExporter.kt", i = {0}, l = {16}, m = "exportAsync", n = {"output"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class RawImageExporter$exportAsync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RawImageExporter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RawImageExporter$exportAsync$1(RawImageExporter rawImageExporter, Continuation<? super RawImageExporter$exportAsync$1> continuation) {
        super(continuation);
        this.this$0 = rawImageExporter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.exportAsync(null, null, null, this);
    }
}

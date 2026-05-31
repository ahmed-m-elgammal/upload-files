package expo.modules.imagepicker;

import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ImagePickerModule.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule", f = "ImagePickerModule.kt", i = {0, 0, 0, 1, 1, 1, 2}, l = {206, 213, JfifUtil.MARKER_EOI}, m = "launchContract", n = {"this", "options", "result", "this", "options", "result", "this"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0"})
/* loaded from: classes5.dex */
final class ImagePickerModule$launchContract$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImagePickerModule$launchContract$1(ImagePickerModule imagePickerModule, Continuation<? super ImagePickerModule$launchContract$1> continuation) {
        super(continuation);
        this.this$0 = imagePickerModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object launchContract;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        launchContract = this.this$0.launchContract(null, null, this);
        return launchContract;
    }
}

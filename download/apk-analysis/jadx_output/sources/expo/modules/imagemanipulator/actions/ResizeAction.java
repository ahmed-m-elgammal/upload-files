package expo.modules.imagemanipulator.actions;

import android.graphics.Bitmap;
import expo.modules.imagemanipulator.ResizeOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResizeAction.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lexpo/modules/imagemanipulator/actions/ResizeAction;", "Lexpo/modules/imagemanipulator/actions/Action;", "resizeOptions", "Lexpo/modules/imagemanipulator/ResizeOptions;", "(Lexpo/modules/imagemanipulator/ResizeOptions;)V", "run", "Landroid/graphics/Bitmap;", "bitmap", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResizeAction implements Action {
    private final ResizeOptions resizeOptions;

    public ResizeAction(ResizeOptions resizeOptions) {
        Intrinsics.checkNotNullParameter(resizeOptions, "resizeOptions");
        this.resizeOptions = resizeOptions;
    }

    @Override // expo.modules.imagemanipulator.actions.Action
    public Bitmap run(Bitmap bitmap) {
        int doubleValue;
        int doubleValue2;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Double width = this.resizeOptions.getWidth();
        Integer valueOf = width != null ? Integer.valueOf((int) width.doubleValue()) : null;
        Double height = this.resizeOptions.getHeight();
        Integer valueOf2 = height != null ? Integer.valueOf((int) height.doubleValue()) : null;
        float width2 = bitmap.getWidth() / bitmap.getHeight();
        if (valueOf != null) {
            doubleValue = valueOf.intValue();
        } else {
            Double height2 = this.resizeOptions.getHeight();
            Intrinsics.checkNotNull(height2);
            doubleValue = (int) (height2.doubleValue() * width2);
        }
        if (valueOf2 != null) {
            doubleValue2 = valueOf2.intValue();
        } else {
            Double width3 = this.resizeOptions.getWidth();
            Intrinsics.checkNotNull(width3);
            doubleValue2 = (int) (width3.doubleValue() / width2);
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, doubleValue, doubleValue2, true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
        return createScaledBitmap;
    }
}

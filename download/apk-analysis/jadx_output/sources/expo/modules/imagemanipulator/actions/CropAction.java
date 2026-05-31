package expo.modules.imagemanipulator.actions;

import android.graphics.Bitmap;
import expo.modules.imagemanipulator.CropRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CropAction.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lexpo/modules/imagemanipulator/actions/CropAction;", "Lexpo/modules/imagemanipulator/actions/Action;", "rect", "Lexpo/modules/imagemanipulator/CropRect;", "(Lexpo/modules/imagemanipulator/CropRect;)V", "run", "Landroid/graphics/Bitmap;", "bitmap", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CropAction implements Action {
    private final CropRect rect;

    public CropAction(CropRect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rect = rect;
    }

    @Override // expo.modules.imagemanipulator.actions.Action
    public Bitmap run(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (this.rect.getOriginX() > bitmap.getWidth() || this.rect.getOriginY() > bitmap.getHeight() || this.rect.getWidth() > bitmap.getWidth() || this.rect.getHeight() > bitmap.getHeight()) {
            throw new IllegalArgumentException("Invalid crop options have been passed. Please make sure the requested crop rectangle is inside source image.".toString());
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (int) this.rect.getOriginX(), (int) this.rect.getOriginY(), (int) this.rect.getWidth(), (int) this.rect.getHeight());
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }
}

package expo.modules.imagemanipulator.actions;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import expo.modules.imagemanipulator.FlipType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlipAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lexpo/modules/imagemanipulator/actions/FlipAction;", "Lexpo/modules/imagemanipulator/actions/Action;", "flipType", "Lexpo/modules/imagemanipulator/FlipType;", "(Lexpo/modules/imagemanipulator/FlipType;)V", "rotationMatrix", "Landroid/graphics/Matrix;", "getRotationMatrix", "()Landroid/graphics/Matrix;", "run", "Landroid/graphics/Bitmap;", "bitmap", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlipAction implements Action {
    private final FlipType flipType;

    public FlipAction(FlipType flipType) {
        Intrinsics.checkNotNullParameter(flipType, "flipType");
        this.flipType = flipType;
    }

    @Override // expo.modules.imagemanipulator.actions.Action
    public Bitmap run(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), getRotationMatrix(), true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    private final Matrix getRotationMatrix() {
        Matrix matrix = new Matrix();
        if (this.flipType == FlipType.VERTICAL) {
            matrix.postScale(1.0f, -1.0f);
        } else {
            matrix.postScale(-1.0f, 1.0f);
        }
        return matrix;
    }
}

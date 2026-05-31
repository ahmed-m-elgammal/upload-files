package androidx.camera.core;

import android.graphics.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.core.util.Consumer;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface SurfaceOutput extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getFormat();

    Matrix getSensorToBufferTransform();

    Size getSize();

    Surface getSurface(Executor executor, Consumer<Event> consumer);

    int getTargets();

    void updateTransformMatrix(float[] fArr, float[] fArr2);

    /* renamed from: androidx.camera.core.SurfaceOutput$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getFormat(SurfaceOutput _this) {
            return 34;
        }

        public static Matrix $default$getSensorToBufferTransform(SurfaceOutput _this) {
            return new Matrix();
        }
    }

    public static abstract class Event {
        public static final int EVENT_REQUEST_CLOSE = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EventCode {
        }

        public abstract int getEventCode();

        public abstract SurfaceOutput getSurfaceOutput();

        Event() {
        }

        public static Event of(int i, SurfaceOutput surfaceOutput) {
            return new AutoValue_SurfaceOutput_Event(i, surfaceOutput);
        }
    }
}

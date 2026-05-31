package com.google.android.cameraview;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class SurfaceViewPreview extends PreviewImpl {
    final SurfaceView mSurfaceView;

    @Override // com.google.android.cameraview.PreviewImpl
    void setDisplayOrientation(int i) {
    }

    SurfaceViewPreview(Context context, ViewGroup viewGroup) {
        SurfaceView surfaceView = (SurfaceView) View.inflate(context, R.layout.surface_view, viewGroup).findViewById(R.id.surface_view);
        this.mSurfaceView = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new SurfaceHolder.Callback() { // from class: com.google.android.cameraview.SurfaceViewPreview.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                SurfaceViewPreview.this.setSize(i2, i3);
                if (ViewCompat.isInLayout(SurfaceViewPreview.this.mSurfaceView)) {
                    return;
                }
                SurfaceViewPreview.this.dispatchSurfaceChanged();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                SurfaceViewPreview.this.setSize(0, 0);
            }
        });
    }

    @Override // com.google.android.cameraview.PreviewImpl
    Surface getSurface() {
        return getSurfaceHolder().getSurface();
    }

    @Override // com.google.android.cameraview.PreviewImpl
    SurfaceHolder getSurfaceHolder() {
        return this.mSurfaceView.getHolder();
    }

    @Override // com.google.android.cameraview.PreviewImpl
    View getView() {
        return this.mSurfaceView;
    }

    @Override // com.google.android.cameraview.PreviewImpl
    Class getOutputClass() {
        return SurfaceHolder.class;
    }

    @Override // com.google.android.cameraview.PreviewImpl
    boolean isReady() {
        return (getWidth() == 0 || getHeight() == 0) ? false : true;
    }
}

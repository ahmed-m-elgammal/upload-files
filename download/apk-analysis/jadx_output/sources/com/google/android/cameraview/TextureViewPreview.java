package com.google.android.cameraview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.imagepipeline.common.RotationOptions;

/* loaded from: classes.dex */
class TextureViewPreview extends PreviewImpl {
    private int mDisplayOrientation;
    private final TextureView mTextureView;

    TextureViewPreview(Context context, ViewGroup viewGroup) {
        TextureView textureView = (TextureView) View.inflate(context, R.layout.texture_view, viewGroup).findViewById(R.id.texture_view);
        this.mTextureView = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.google.android.cameraview.TextureViewPreview.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TextureViewPreview.this.setSize(i, i2);
                TextureViewPreview.this.configureTransform();
                TextureViewPreview.this.dispatchSurfaceChanged();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                TextureViewPreview.this.setSize(i, i2);
                TextureViewPreview.this.configureTransform();
                TextureViewPreview.this.dispatchSurfaceChanged();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                TextureViewPreview.this.setSize(0, 0);
                TextureViewPreview.this.dispatchSurfaceDestroyed();
                return true;
            }
        });
    }

    @Override // com.google.android.cameraview.PreviewImpl
    void setBufferSize(int i, int i2) {
        this.mTextureView.getSurfaceTexture().setDefaultBufferSize(i, i2);
    }

    @Override // com.google.android.cameraview.PreviewImpl
    Surface getSurface() {
        return new Surface(this.mTextureView.getSurfaceTexture());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.PreviewImpl
    public SurfaceTexture getSurfaceTexture() {
        return this.mTextureView.getSurfaceTexture();
    }

    @Override // com.google.android.cameraview.PreviewImpl
    View getView() {
        return this.mTextureView;
    }

    @Override // com.google.android.cameraview.PreviewImpl
    Class getOutputClass() {
        return SurfaceTexture.class;
    }

    @Override // com.google.android.cameraview.PreviewImpl
    void setDisplayOrientation(int i) {
        this.mDisplayOrientation = i;
        configureTransform();
    }

    @Override // com.google.android.cameraview.PreviewImpl
    boolean isReady() {
        return this.mTextureView.getSurfaceTexture() != null;
    }

    void configureTransform() {
        Matrix matrix = new Matrix();
        int i = this.mDisplayOrientation;
        if (i % RotationOptions.ROTATE_180 == 90) {
            float width = getWidth();
            float height = getHeight();
            matrix.setPolyToPoly(new float[]{0.0f, 0.0f, width, 0.0f, 0.0f, height, width, height}, 0, this.mDisplayOrientation == 90 ? new float[]{0.0f, height, 0.0f, 0.0f, width, height, width, 0.0f} : new float[]{width, 0.0f, width, height, 0.0f, 0.0f, 0.0f, height}, 0, 4);
        } else if (i == 180) {
            matrix.postRotate(180.0f, getWidth() / 2, getHeight() / 2);
        }
        this.mTextureView.setTransform(matrix);
    }
}

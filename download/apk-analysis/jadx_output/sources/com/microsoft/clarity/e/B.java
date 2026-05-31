package com.microsoft.clarity.e;

import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.i.C0109c;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.common.ImageSize;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public final MaskingMode f58a;
    public final T b;
    public final Color4f c;

    public B(MaskingMode maskingMode) {
        Intrinsics.checkNotNullParameter(maskingMode, "maskingMode");
        this.f58a = maskingMode;
        this.b = new T();
        this.c = new Color4f(128.0f, 128.0f, 128.0f, 1.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x053f A[LOOP:7: B:136:0x053d->B:137:0x053f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x068a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.microsoft.clarity.models.observers.FramePicture r30, com.microsoft.clarity.models.display.DisplayFrame r31) {
        /*
            Method dump skipped, instructions count: 1819
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.e.B.a(com.microsoft.clarity.models.observers.FramePicture, com.microsoft.clarity.models.display.DisplayFrame):void");
    }

    public final void a(ImageShader imageShader, DisplayFrame displayFrame) {
        C0107a imageBytes;
        Integer imageIndex = imageShader.getImageIndex();
        Intrinsics.checkNotNull(imageIndex);
        int intValue = imageIndex.intValue();
        if (intValue < 0 || intValue >= displayFrame.getImages().size() || (imageBytes = displayFrame.getImages().get(intValue).getData()) == null || imageBytes.c == 0) {
            return;
        }
        Intrinsics.checkNotNullParameter(imageBytes, "imageBytes");
        byte[] bArr = imageBytes.f169a;
        int i = imageBytes.b;
        C0109c c0109c = new C0109c(bArr, i, imageBytes.c);
        c0109c.d = i + 16;
        ImageSize imageSize = new ImageSize(c0109c.a(), c0109c.a(), null);
        imageShader.setMaskedColor(this.c);
        imageShader.setMaskedWidth(Integer.valueOf(imageSize.getWidth()));
        imageShader.setMaskedHeight(Integer.valueOf(imageSize.getHeight()));
        imageShader.setImageIndex(null);
    }
}

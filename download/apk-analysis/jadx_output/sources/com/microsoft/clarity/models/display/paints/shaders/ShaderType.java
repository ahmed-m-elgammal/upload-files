package com.microsoft.clarity.models.display.paints.shaders;

import com.microsoft.clarity.protomodels.mutationpayload.a0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "", "<init>", "(Ljava/lang/String;I)V", "Lcom/microsoft/clarity/protomodels/mutationpayload/a0;", "toProtobufType", "()Lcom/microsoft/clarity/protomodels/mutationpayload/a0;", "ImageShader", "LinearGradientShader", "RadialGradientShader", "SweepGradientShader", "LocalMatrixShader", "Color4Shader", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum ShaderType {
    ImageShader,
    LinearGradientShader,
    RadialGradientShader,
    SweepGradientShader,
    LocalMatrixShader,
    Color4Shader;

    public final a0 toProtobufType() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return a0.ImageShader;
        }
        if (ordinal == 1) {
            return a0.LinearGradientShader;
        }
        if (ordinal == 2) {
            return a0.RadialGradientShader;
        }
        if (ordinal == 3) {
            return a0.SweepGradientShader;
        }
        if (ordinal == 4) {
            return a0.LocalMatrixShader;
        }
        if (ordinal != 5) {
            return null;
        }
        return a0.Color4Shader;
    }
}

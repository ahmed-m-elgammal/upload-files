package androidx.camera.core.processing;

/* loaded from: classes.dex */
public interface ShaderProvider {
    public static final ShaderProvider DEFAULT = new ShaderProvider() { // from class: androidx.camera.core.processing.ShaderProvider.1
        @Override // androidx.camera.core.processing.ShaderProvider
        public /* synthetic */ String createFragmentShader(String str, String str2) {
            return CC.$default$createFragmentShader(this, str, str2);
        }
    };

    /* renamed from: androidx.camera.core.processing.ShaderProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$createFragmentShader(ShaderProvider _this, String str, String str2) {
            return null;
        }
    }

    String createFragmentShader(String str, String str2);
}

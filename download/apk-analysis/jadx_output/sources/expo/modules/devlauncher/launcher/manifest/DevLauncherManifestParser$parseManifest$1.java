package expo.modules.devlauncher.launcher.manifest;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DevLauncherManifestParser.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.devlauncher.launcher.manifest.DevLauncherManifestParser", f = "DevLauncherManifestParser.kt", i = {}, l = {37}, m = "parseManifest", n = {}, s = {})
/* loaded from: classes5.dex */
final class DevLauncherManifestParser$parseManifest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DevLauncherManifestParser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DevLauncherManifestParser$parseManifest$1(DevLauncherManifestParser devLauncherManifestParser, Continuation<? super DevLauncherManifestParser$parseManifest$1> continuation) {
        super(continuation);
        this.this$0 = devLauncherManifestParser;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.parseManifest(this);
    }
}

package expo.modules.devmenu.extensions;

import expo.modules.devmenu.devtools.DevMenuDevToolsDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: DevMenuExtension.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class DevMenuExtension$devMenuItems$1$9$1 extends FunctionReferenceImpl implements Function0<Unit> {
    DevMenuExtension$devMenuItems$1$9$1(Object obj) {
        super(0, obj, DevMenuDevToolsDelegate.class, "openJSInspector", "openJSInspector()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((DevMenuDevToolsDelegate) this.receiver).openJSInspector();
    }
}

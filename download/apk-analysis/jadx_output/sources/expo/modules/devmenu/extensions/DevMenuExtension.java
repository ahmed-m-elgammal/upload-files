package expo.modules.devmenu.extensions;

import android.app.Activity;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.devsupport.DevMenuInternalSettingsWrapper;
import com.facebook.react.devsupport.HMRClient;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import expo.interfaces.devmenu.DevMenuExtensionInterface;
import expo.interfaces.devmenu.DevMenuExtensionSettingsInterface;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.interfaces.devmenu.items.DevMenuAction;
import expo.interfaces.devmenu.items.DevMenuDSLItemsContainerInterface;
import expo.interfaces.devmenu.items.DevMenuDataSourceInterface;
import expo.interfaces.devmenu.items.DevMenuItemImportance;
import expo.interfaces.devmenu.items.DevMenuItemsContainer;
import expo.interfaces.devmenu.items.DevMenuScreen;
import expo.interfaces.devmenu.items.KeyCommand;
import expo.modules.devmenu.DevMenuManager;
import expo.modules.devmenu.DevMenuUtilsKt;
import expo.modules.devmenu.devtools.DevMenuDevToolsDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuExtension.kt */
@ReactModule(name = "ExpoDevMenuExtensions")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lexpo/modules/devmenu/extensions/DevMenuExtension;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lexpo/interfaces/devmenu/DevMenuExtensionInterface;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "devMenuDataSources", "", "Lexpo/interfaces/devmenu/items/DevMenuDataSourceInterface;", "settings", "Lexpo/interfaces/devmenu/DevMenuExtensionSettingsInterface;", "devMenuItems", "Lexpo/interfaces/devmenu/items/DevMenuItemsContainer;", "devMenuScreens", "Lexpo/interfaces/devmenu/items/DevMenuScreen;", "getName", "", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuExtension extends ReactContextBaseJavaModule implements DevMenuExtensionInterface {
    @Override // expo.interfaces.devmenu.DevMenuExtensionInterface
    public List<DevMenuDataSourceInterface> devMenuDataSources(DevMenuExtensionSettingsInterface settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        return null;
    }

    @Override // expo.interfaces.devmenu.DevMenuExtensionInterface
    public List<DevMenuScreen> devMenuScreens(DevMenuExtensionSettingsInterface settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevMenuExtension(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        DevMenuManager.INSTANCE.registerExtensionInterface(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ExpoDevMenuExtensions";
    }

    @Override // expo.interfaces.devmenu.DevMenuExtensionInterface
    public DevMenuItemsContainer devMenuItems(final DevMenuExtensionSettingsInterface settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        return DevMenuItemsContainer.INSTANCE.export(new Function1<DevMenuDSLItemsContainerInterface, Unit>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DevMenuDSLItemsContainerInterface devMenuDSLItemsContainerInterface) {
                invoke2(devMenuDSLItemsContainerInterface);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DevMenuDSLItemsContainerInterface export) {
                Intrinsics.checkNotNullParameter(export, "$this$export");
                if (DevMenuExtensionSettingsInterface.this.wasRunOnDevelopmentBridge()) {
                    ReactHostWrapper reactHost = DevMenuManager.INSTANCE.getReactHost();
                    if (reactHost == null) {
                        Log.w(DevMenuUtilsKt.DEV_MENU_TAG, "Couldn't export dev-menu items, because the react instance isn't present.");
                        return;
                    }
                    final DevMenuDevToolsDelegate devMenuDevToolsDelegate = new DevMenuDevToolsDelegate(DevMenuExtensionSettingsInterface.this.getManager(), reactHost);
                    final DevSupportManager reactDevManager = devMenuDevToolsDelegate.getReactDevManager();
                    final DeveloperSettings devSettings = devMenuDevToolsDelegate.getDevSettings();
                    if (reactDevManager == null || devSettings == null) {
                        Log.w(DevMenuUtilsKt.DEV_MENU_TAG, "Couldn't export dev-menu items, because react-native bridge doesn't contain the dev support manager.");
                        return;
                    }
                    export.action("reload", new AnonymousClass1(devMenuDevToolsDelegate), new Function1<DevMenuAction, Unit>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DevMenuAction devMenuAction) {
                            invoke2(devMenuAction);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DevMenuAction action) {
                            Intrinsics.checkNotNullParameter(action, "$this$action");
                            action.setLabel(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.2.1
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Reload";
                                }
                            });
                            action.setGlyphName(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.2.2
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "reload";
                                }
                            });
                            action.setKeyCommand(new KeyCommand(46, false, 2, null));
                            action.setImportance(DevMenuItemImportance.HIGHEST.getValue());
                        }
                    });
                    final DevMenuExtension devMenuExtension = this;
                    export.action("performance-monitor", new Function0<Unit>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Activity currentActivity;
                            currentActivity = DevMenuExtension.this.getCurrentActivity();
                            if (currentActivity != null) {
                                devMenuDevToolsDelegate.togglePerformanceMonitor(currentActivity);
                            }
                        }
                    }, new Function1<DevMenuAction, Unit>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DevMenuAction devMenuAction) {
                            invoke2(devMenuAction);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final DevMenuAction action) {
                            Intrinsics.checkNotNullParameter(action, "$this$action");
                            final DeveloperSettings developerSettings = DeveloperSettings.this;
                            action.setEnabled(new Function0<Boolean>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.4.1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(DeveloperSettings.this.isFpsDebugEnabled());
                                }
                            });
                            action.setLabel(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.4.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return DevMenuAction.this.isEnabled().invoke().booleanValue() ? "Hide Performance Monitor" : "Show Performance Monitor";
                                }
                            });
                            action.setGlyphName(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.4.3
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "speedometer";
                                }
                            });
                            action.setKeyCommand(new KeyCommand(44, false, 2, null));
                            action.setImportance(DevMenuItemImportance.HIGH.getValue());
                        }
                    });
                    export.action("inspector", new AnonymousClass5(devMenuDevToolsDelegate), new Function1<DevMenuAction, Unit>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1.6
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DevMenuAction devMenuAction) {
                            invoke2(devMenuAction);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final DevMenuAction action) {
                            Intrinsics.checkNotNullParameter(action, "$this$action");
                            final DeveloperSettings developerSettings = DeveloperSettings.this;
                            action.setEnabled(new Function0<Boolean>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.6.1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(DeveloperSettings.this.isElementInspectorEnabled());
                                }
                            });
                            action.setLabel(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.6.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return DevMenuAction.this.isEnabled().invoke().booleanValue() ? "Hide Element Inspector" : "Show Element Inspector";
                                }
                            });
                            action.setGlyphName(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.6.3
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "border-style";
                                }
                            });
                            action.setKeyCommand(new KeyCommand(37, false, 2, null));
                            action.setImportance(DevMenuItemImportance.HIGH.getValue());
                        }
                    });
                    export.action("remote-debug", new AnonymousClass7(devMenuDevToolsDelegate), new Function1<DevMenuAction, Unit>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1.8
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DevMenuAction devMenuAction) {
                            invoke2(devMenuAction);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final DevMenuAction action) {
                            Intrinsics.checkNotNullParameter(action, "$this$action");
                            final DeveloperSettings developerSettings = DeveloperSettings.this;
                            action.setEnabled(new Function0<Boolean>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.8.1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(DeveloperSettings.this.isRemoteJSDebugEnabled());
                                }
                            });
                            action.setLabel(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.8.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return DevMenuAction.this.isEnabled().invoke().booleanValue() ? "Stop Remote Debugging" : "Debug Remote JS";
                                }
                            });
                            action.setGlyphName(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension.devMenuItems.1.8.3
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "remote-desktop";
                                }
                            });
                            action.setImportance(DevMenuItemImportance.LOW.getValue());
                        }
                    });
                    final DevMenuInternalSettingsWrapper devInternalSettings$expo_dev_menu_release = devMenuDevToolsDelegate.getDevInternalSettings$expo_dev_menu_release();
                    if (devInternalSettings$expo_dev_menu_release != null) {
                        final DevMenuExtension devMenuExtension2 = this;
                        export.action("js-inspector", new DevMenuExtension$devMenuItems$1$9$1(devMenuDevToolsDelegate), new Function1<DevMenuAction, Unit>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$9$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DevMenuAction devMenuAction) {
                                invoke2(devMenuAction);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DevMenuAction action) {
                                Intrinsics.checkNotNullParameter(action, "$this$action");
                                action.setLabel(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$9$2.1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Open JavaScript debugger";
                                    }
                                });
                                action.setGlyphName(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$9$2.2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "language-javascript";
                                    }
                                });
                                action.setImportance(DevMenuItemImportance.LOW.getValue());
                            }
                        });
                        export.action("fast-refresh", new Function0<Unit>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$9$fastRefreshAction$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                ReactApplicationContext reactApplicationContext;
                                ReactApplicationContext reactApplicationContext2;
                                ReactApplicationContext reactApplicationContext3;
                                boolean isHotModuleReplacementEnabled = DevMenuInternalSettingsWrapper.this.isHotModuleReplacementEnabled();
                                DevMenuInternalSettingsWrapper.this.setHotModuleReplacementEnabled(!isHotModuleReplacementEnabled);
                                reactApplicationContext = devMenuExtension2.getReactApplicationContext();
                                if (reactApplicationContext != null) {
                                    if (!isHotModuleReplacementEnabled) {
                                        reactApplicationContext3 = devMenuExtension2.getReactApplicationContext();
                                        ((HMRClient) reactApplicationContext3.getJSModule(HMRClient.class)).enable();
                                    } else {
                                        reactApplicationContext2 = devMenuExtension2.getReactApplicationContext();
                                        ((HMRClient) reactApplicationContext2.getJSModule(HMRClient.class)).disable();
                                    }
                                }
                                if (isHotModuleReplacementEnabled || DevMenuInternalSettingsWrapper.this.isJSDevModeEnabled()) {
                                    return;
                                }
                                DevMenuInternalSettingsWrapper.this.setJSDevModeEnabled(true);
                                reactDevManager.handleReloadJS();
                            }
                        }, new Function1<DevMenuAction, Unit>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$9$3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DevMenuAction devMenuAction) {
                                invoke2(devMenuAction);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(final DevMenuAction action) {
                                Intrinsics.checkNotNullParameter(action, "$this$action");
                                final DevMenuInternalSettingsWrapper devMenuInternalSettingsWrapper = DevMenuInternalSettingsWrapper.this;
                                action.setEnabled(new Function0<Boolean>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$9$3.1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        return Boolean.valueOf(DevMenuInternalSettingsWrapper.this.isHotModuleReplacementEnabled());
                                    }
                                });
                                action.setLabel(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$9$3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return DevMenuAction.this.isEnabled().invoke().booleanValue() ? "Disable Fast Refresh" : "Enable Fast Refresh";
                                    }
                                });
                                action.setGlyphName(new Function0<String>() { // from class: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$9$3.3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "run-fast";
                                    }
                                });
                                action.setImportance(DevMenuItemImportance.LOW.getValue());
                            }
                        });
                    }
                }
            }

            /* compiled from: DevMenuExtension.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$1, reason: invalid class name */
            /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                AnonymousClass1(Object obj) {
                    super(0, obj, DevMenuDevToolsDelegate.class, "reload", "reload()V", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((DevMenuDevToolsDelegate) this.receiver).reload();
                }
            }

            /* compiled from: DevMenuExtension.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$5, reason: invalid class name */
            /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function0<Unit> {
                AnonymousClass5(Object obj) {
                    super(0, obj, DevMenuDevToolsDelegate.class, "toggleElementInspector", "toggleElementInspector()V", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((DevMenuDevToolsDelegate) this.receiver).toggleElementInspector();
                }
            }

            /* compiled from: DevMenuExtension.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: expo.modules.devmenu.extensions.DevMenuExtension$devMenuItems$1$7, reason: invalid class name */
            /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function0<Unit> {
                AnonymousClass7(Object obj) {
                    super(0, obj, DevMenuDevToolsDelegate.class, "toggleRemoteDebugging", "toggleRemoteDebugging()V", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((DevMenuDevToolsDelegate) this.receiver).toggleRemoteDebugging();
                }
            }
        });
    }
}

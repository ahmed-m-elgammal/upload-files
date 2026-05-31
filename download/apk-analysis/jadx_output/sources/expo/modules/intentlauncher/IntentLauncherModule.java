package expo.modules.intentlauncher;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.tracing.Trace;
import expo.modules.intentlauncher.exceptions.ActivityAlreadyStartedException;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import io.sentry.SentryBaseEvent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: IntentLauncherModule.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/intentlauncher/IntentLauncherModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "pendingPromise", "Lexpo/modules/kotlin/Promise;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-intent-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IntentLauncherModule extends Module {
    private Promise pendingPromise;

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        Activity currentActivity = getAppContext().getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        IntentLauncherModule intentLauncherModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (intentLauncherModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(intentLauncherModule);
            moduleDefinitionBuilder.Name("ExpoIntentLauncher");
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("startActivity", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.intentlauncher.IntentLauncherModule$definition$lambda$11$$inlined$AsyncFunctionWithPromise$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(IntentLauncherParams.class), false, new Function0<KType>() { // from class: expo.modules.intentlauncher.IntentLauncherModule$definition$lambda$11$$inlined$AsyncFunctionWithPromise$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(IntentLauncherParams.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.intentlauncher.IntentLauncherModule$definition$lambda$11$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Promise promise2;
                    UnexpectedException unexpectedException;
                    Activity currentActivity;
                    Bundle bundle;
                    ComponentName componentName;
                    Context context;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    IntentLauncherParams intentLauncherParams = (IntentLauncherParams) objArr[1];
                    String str = (String) obj;
                    promise2 = IntentLauncherModule.this.pendingPromise;
                    if (promise2 != null) {
                        throw new ActivityAlreadyStartedException();
                    }
                    Intent intent = new Intent(str);
                    if (intentLauncherParams.getClassName() != null) {
                        if (intentLauncherParams.getPackageName() == null) {
                            context = IntentLauncherModule.this.getContext();
                            componentName = new ComponentName(context, intentLauncherParams.getClassName());
                        } else {
                            componentName = new ComponentName(intentLauncherParams.getPackageName(), intentLauncherParams.getClassName());
                        }
                        intent.setComponent(componentName);
                    }
                    if (intentLauncherParams.getData() != null && intentLauncherParams.getType() != null) {
                        intent.setDataAndType(Uri.parse(intentLauncherParams.getData()), intentLauncherParams.getType());
                    } else if (intentLauncherParams.getData() != null) {
                        intent.setData(Uri.parse(intentLauncherParams.getData()));
                    } else if (intentLauncherParams.getType() != null) {
                        intent.setType(intentLauncherParams.getType());
                    }
                    Map<String, Object> extra = intentLauncherParams.getExtra();
                    if (extra != null) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(extra.size()));
                        Iterator<T> it = extra.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            if (value instanceof Double) {
                                value = Integer.valueOf((int) ((Number) value).doubleValue());
                            }
                            linkedHashMap.put(key, value);
                        }
                        bundle = IntentLauncherModuleKt.toBundle(linkedHashMap);
                        intent.putExtras(bundle);
                    }
                    Integer flags = intentLauncherParams.getFlags();
                    if (flags != null) {
                        intent.addFlags(flags.intValue());
                    }
                    String category = intentLauncherParams.getCategory();
                    if (category != null) {
                        intent.addCategory(category);
                    }
                    try {
                        currentActivity = IntentLauncherModule.this.getCurrentActivity();
                        currentActivity.startActivityForResult(intent, 12);
                        IntentLauncherModule.this.pendingPromise = promise;
                    } catch (Throwable th) {
                        if (th instanceof CodedException) {
                            unexpectedException = (CodedException) th;
                        } else if (th instanceof expo.modules.core.errors.CodedException) {
                            String code = ((expo.modules.core.errors.CodedException) th).getCode();
                            Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                            unexpectedException = new CodedException(code, th.getMessage(), th.getCause());
                        } else {
                            unexpectedException = new UnexpectedException(th);
                        }
                        promise.reject(unexpectedException);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("startActivity", asyncFunctionWithPromiseComponent);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.intentlauncher.IntentLauncherModule$definition$lambda$11$$inlined$OnActivityResult$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
                    invoke2(activity, onActivityResultPayload);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Activity sender, OnActivityResultPayload payload) {
                    Promise promise;
                    Bundle extras;
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    if (payload.getRequestCode() != 12) {
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("resultCode", payload.getResultCode());
                    if (payload.getData() != null) {
                        Intent data = payload.getData();
                        if (data != null) {
                            bundle.putString("data", data.toString());
                        }
                        Intent data2 = payload.getData();
                        if (data2 != null && (extras = data2.getExtras()) != null) {
                            bundle.putBundle(SentryBaseEvent.JsonKeys.EXTRA, extras);
                        }
                    }
                    promise = IntentLauncherModule.this.pendingPromise;
                    if (promise != null) {
                        promise.resolve(bundle);
                    }
                    IntentLauncherModule.this.pendingPromise = null;
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}

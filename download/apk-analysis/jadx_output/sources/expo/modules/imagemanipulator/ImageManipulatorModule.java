package expo.modules.imagemanipulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.imagemanipulator.actions.Action;
import expo.modules.imagemanipulator.arguments.Actions;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: ImageManipulatorModule.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lexpo/modules/imagemanipulator/ImageManipulatorModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "runActions", "", "bitmap", "Landroid/graphics/Bitmap;", "actions", "Lexpo/modules/imagemanipulator/arguments/Actions;", "saveOptions", "Lexpo/modules/imagemanipulator/SaveOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageManipulatorModule extends Module {
    private final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        ImageManipulatorModule imageManipulatorModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (imageManipulatorModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(imageManipulatorModule);
            moduleDefinitionBuilder.Name("ExpoImageManipulator");
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("manipulateAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ManipulateAction.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SaveOptions.class), false, new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SaveOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$4
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    final SaveOptions saveOptions = (SaveOptions) objArr[2];
                    final String str = (String) obj;
                    final Actions fromArgument = Actions.INSTANCE.fromArgument((List) obj2);
                    ImageLoaderInterface imageLoader = ImageManipulatorModule.this.getAppContext().getImageLoader();
                    if (imageLoader != null) {
                        final ImageManipulatorModule imageManipulatorModule2 = ImageManipulatorModule.this;
                        imageLoader.loadImageForManipulationFromURL(str, new ImageLoaderInterface.ResultListener() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$1$1$1
                            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                            public void onSuccess(Bitmap bitmap) {
                                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                                ImageManipulatorModule.this.runActions(bitmap, fromArgument, saveOptions, promise);
                            }

                            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                            public void onFailure(Throwable cause) {
                                promise.reject(new ImageDecodeException(str, cause));
                            }
                        });
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("manipulateAsync", asyncFunctionWithPromiseComponent);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runActions(Bitmap bitmap, Actions actions, SaveOptions saveOptions, Promise promise) {
        String str;
        Iterator<T> it = actions.getActions().iterator();
        while (it.hasNext()) {
            bitmap = ((Action) it.next()).run(bitmap);
        }
        String generateRandomOutputPath = FileUtils.INSTANCE.generateRandomOutputPath(getContext(), saveOptions.getCompressFormat());
        int compress = (int) (saveOptions.getCompress() * 100);
        ByteArrayOutputStream fileOutputStream = new FileOutputStream(generateRandomOutputPath);
        try {
            bitmap.compress(saveOptions.getCompressFormat(), compress, fileOutputStream);
            if (saveOptions.getBase64()) {
                fileOutputStream = new ByteArrayOutputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = fileOutputStream;
                    bitmap.compress(saveOptions.getCompressFormat(), compress, byteArrayOutputStream);
                    str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                } finally {
                }
            } else {
                str = null;
            }
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            String uri = Uri.fromFile(new File(generateRandomOutputPath)).toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            promise.resolve(new ImageResult(uri, bitmap.getWidth(), bitmap.getHeight(), str));
        } finally {
        }
    }
}

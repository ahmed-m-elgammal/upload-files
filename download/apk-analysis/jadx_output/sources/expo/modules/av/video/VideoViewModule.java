package expo.modules.av.video;

import android.view.View;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.av.ViewUtils;
import expo.modules.av.video.scalablevideoview.ScalableType;
import expo.modules.core.arguments.MapArguments;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: VideoViewModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/av/video/VideoViewModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-av_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoViewModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        VideoViewModule videoViewModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (videoViewModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(videoViewModule);
            moduleDefinitionBuilder.Name("ExpoVideoView");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(VideoViewWrapper.class);
            if (moduleDefinitionBuilder.getViewManagerDefinition() != null) {
                throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
            }
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass, new LazyKType(Reflection.getOrCreateKotlinClass(VideoViewWrapper.class), false, new Function0<KType>() { // from class: expo.modules.av.video.VideoViewModule$definition$lambda$2$$inlined$View$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(VideoViewWrapper.class);
                }
            }, 2, null));
            final VideoViewModule$definition$1$1$1 videoViewModule$definition$1$1$1 = new Function1<VideoViewWrapper, Unit>() { // from class: expo.modules.av.video.VideoViewModule$definition$1$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(VideoViewWrapper videoViewWrapper) {
                    invoke2(videoViewWrapper);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(VideoViewWrapper view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getVideoViewInstance().onDropViewInstance();
                }
            };
            viewDefinitionBuilder.setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.av.video.VideoViewModule$definition$lambda$2$lambda$0$$inlined$OnViewDestroysGeneric$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function1.this.invoke((VideoViewWrapper) it);
                }
            });
            viewDefinitionBuilder.Events("onStatusUpdate", "onLoadStart", "onLoad", "onError", "onReadyForDisplay", "onFullscreenUpdate");
            viewDefinitionBuilder.getProps().put("status", new ConcreteViewProp("status", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableMap.class), false, new Function0<KType>() { // from class: expo.modules.av.video.VideoViewModule$definition$lambda$2$lambda$0$$inlined$Prop$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableMap.class);
                }
            })), new Function2<VideoViewWrapper, ReadableMap, Unit>() { // from class: expo.modules.av.video.VideoViewModule$definition$1$1$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(VideoViewWrapper videoViewWrapper, ReadableMap readableMap) {
                    invoke2(videoViewWrapper, readableMap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(VideoViewWrapper view, ReadableMap status) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(status, "status");
                    view.getVideoViewInstance().setStatus(new MapArguments(status.toHashMap()), null);
                }
            }));
            viewDefinitionBuilder.getProps().put("useNativeControls", new ConcreteViewProp("useNativeControls", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.av.video.VideoViewModule$definition$lambda$2$lambda$0$$inlined$Prop$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            })), new Function2<VideoViewWrapper, Boolean, Unit>() { // from class: expo.modules.av.video.VideoViewModule$definition$1$1$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(VideoViewWrapper videoViewWrapper, Boolean bool) {
                    invoke(videoViewWrapper, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(VideoViewWrapper view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getVideoViewInstance().setUseNativeControls(z);
                }
            }));
            viewDefinitionBuilder.getProps().put("source", new ConcreteViewProp("source", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableMap.class), false, new Function0<KType>() { // from class: expo.modules.av.video.VideoViewModule$definition$lambda$2$lambda$0$$inlined$Prop$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableMap.class);
                }
            })), new Function2<VideoViewWrapper, ReadableMap, Unit>() { // from class: expo.modules.av.video.VideoViewModule$definition$1$1$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(VideoViewWrapper videoViewWrapper, ReadableMap readableMap) {
                    invoke2(videoViewWrapper, readableMap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(VideoViewWrapper view, ReadableMap source) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(source, "source");
                    view.getVideoViewInstance().setSource(new MapArguments(source.toHashMap()));
                }
            }));
            viewDefinitionBuilder.getProps().put(ViewProps.RESIZE_MODE, new ConcreteViewProp(ViewProps.RESIZE_MODE, new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.av.video.VideoViewModule$definition$lambda$2$lambda$0$$inlined$Prop$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new Function2<VideoViewWrapper, String, Unit>() { // from class: expo.modules.av.video.VideoViewModule$definition$1$1$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(VideoViewWrapper videoViewWrapper, String str) {
                    invoke2(videoViewWrapper, str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(VideoViewWrapper view, String resizeModeOrdinalString) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(resizeModeOrdinalString, "resizeModeOrdinalString");
                    view.getVideoViewInstance().setResizeMode(ScalableType.values()[Integer.parseInt(resizeModeOrdinalString)]);
                }
            }));
            moduleDefinitionBuilder.setViewManagerDefinition(viewDefinitionBuilder.build());
            moduleDefinitionBuilder.Constants(TuplesKt.to("ScaleNone", String.valueOf(ScalableType.LEFT_TOP.ordinal())), TuplesKt.to("ScaleToFill", String.valueOf(ScalableType.FIT_XY.ordinal())), TuplesKt.to("ScaleAspectFit", String.valueOf(ScalableType.FIT_CENTER.ordinal())), TuplesKt.to("ScaleAspectFill", String.valueOf(ScalableType.CENTER_CROP.ordinal())));
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setFullscreen", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.video.VideoViewModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.av.video.VideoViewModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.video.VideoViewModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    final boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                    ViewUtils.INSTANCE.tryRunWithVideoView(VideoViewModule.this.getAppContext().getLegacyModuleRegistry(), ((Number) obj).intValue(), new ViewUtils.VideoViewCallback() { // from class: expo.modules.av.video.VideoViewModule$definition$1$2$1
                        @Override // expo.modules.av.ViewUtils.VideoViewCallback
                        public void runWithVideoView(final VideoView videoView) {
                            Intrinsics.checkNotNullParameter(videoView, "videoView");
                            final Promise promise2 = promise;
                            FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener = new FullscreenVideoPlayerPresentationChangeProgressListener() { // from class: expo.modules.av.video.VideoViewModule$definition$1$2$1$runWithVideoView$listener$1
                                @Override // expo.modules.av.video.FullscreenVideoPlayerPresentationChangeProgressListener, expo.modules.av.video.FullscreenVideoPlayerPresentationChangeListener
                                public void onFullscreenPlayerDidDismiss() {
                                    Promise.this.resolve(videoView.getStatus());
                                }

                                @Override // expo.modules.av.video.FullscreenVideoPlayerPresentationChangeProgressListener, expo.modules.av.video.FullscreenVideoPlayerPresentationChangeListener
                                public void onFullscreenPlayerDidPresent() {
                                    Promise.this.resolve(videoView.getStatus());
                                }

                                @Override // expo.modules.av.video.FullscreenVideoPlayerPresentationChangeProgressListener
                                protected void onFullscreenPlayerPresentationTriedToInterrupt() {
                                    Promise.this.reject("E_FULLSCREEN_VIDEO_PLAYER", "This presentation change tries to interrupt an older request. Await the old request and then try again.", null);
                                }

                                @Override // expo.modules.av.video.FullscreenVideoPlayerPresentationChangeProgressListener
                                protected void onFullscreenPlayerPresentationInterrupted() {
                                    Promise.this.reject("E_FULLSCREEN_VIDEO_PLAYER", "This presentation change has been interrupted by a newer change request.", null);
                                }

                                @Override // expo.modules.av.video.FullscreenVideoPlayerPresentationChangeProgressListener
                                protected void onFullscreenPlayerPresentationError(String errorMessage) {
                                    StringBuilder sb = new StringBuilder("This presentation change has been interrupted by an error.");
                                    if (errorMessage != null) {
                                        sb.append(" ");
                                        sb.append(errorMessage);
                                    }
                                    Promise.this.reject("E_FULLSCREEN_VIDEO_PLAYER", sb.toString(), null);
                                }
                            };
                            if (booleanValue) {
                                videoView.ensureFullscreenPlayerIsPresented(fullscreenVideoPlayerPresentationChangeProgressListener);
                            } else {
                                videoView.ensureFullscreenPlayerIsDismissed(fullscreenVideoPlayerPresentationChangeProgressListener);
                            }
                        }
                    }, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("setFullscreen", asyncFunctionWithPromiseComponent);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}

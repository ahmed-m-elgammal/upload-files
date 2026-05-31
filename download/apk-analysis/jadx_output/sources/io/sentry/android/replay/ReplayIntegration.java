package io.sentry.android.replay;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import io.sentry.Breadcrumb;
import io.sentry.DataCategory;
import io.sentry.Hint;
import io.sentry.IConnectionStatusProvider;
import io.sentry.IHub;
import io.sentry.IScope;
import io.sentry.ISentryExecutorService;
import io.sentry.Integration;
import io.sentry.NoOpReplayBreadcrumbConverter;
import io.sentry.ReplayBreadcrumbConverter;
import io.sentry.ReplayController;
import io.sentry.ScopeCallback;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayOptions;
import io.sentry.android.replay.ReplayCache;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.replay.ScreenshotRecorderConfig;
import io.sentry.android.replay.capture.BufferCaptureStrategy;
import io.sentry.android.replay.capture.CaptureStrategy;
import io.sentry.android.replay.capture.SessionCaptureStrategy;
import io.sentry.android.replay.gestures.GestureRecorder;
import io.sentry.android.replay.gestures.TouchRecorderCallback;
import io.sentry.android.replay.util.ContextKt;
import io.sentry.android.replay.util.ExecutorsKt;
import io.sentry.android.replay.util.MainLooperHandler;
import io.sentry.android.replay.util.SamplingKt;
import io.sentry.cache.PersistingScopeObserver;
import io.sentry.hints.Backfillable;
import io.sentry.protocol.SentryId;
import io.sentry.transport.ICurrentDateProvider;
import io.sentry.transport.RateLimiter;
import io.sentry.util.FileUtils;
import io.sentry.util.HintUtils;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Random;
import java.io.Closeable;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: ReplayIntegration.kt */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002vwB\u0017\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB¶\u0001\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012\u0012#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0012\u0012%\b\u0002\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000f¢\u0006\u0002\u0010#Bu\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012\u0012%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0012¢\u0006\u0002\u0010$J\u0017\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020LH\u0002J\u0012\u0010P\u001a\u00020L2\b\b\u0002\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020LH\u0016J\b\u0010T\u001a\u00020LH\u0002J\b\u0010U\u001a\u00020;H\u0016J\b\u0010V\u001a\u00020\u0019H\u0016J\b\u0010W\u001a\u00020\u0013H\u0016J\u0010\u0010X\u001a\u00020L2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020L2\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020LH\u0016J\u0010\u0010_\u001a\u00020L2\u0006\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020L2\u0006\u0010c\u001a\u00020dH\u0016J\u0018\u0010b\u001a\u00020L2\u0006\u0010e\u001a\u00020=2\u0006\u0010f\u001a\u00020gH\u0016J\u0010\u0010h\u001a\u00020L2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020LH\u0016J\b\u0010l\u001a\u00020LH\u0002J\u0018\u0010m\u001a\u00020L2\u0006\u0010'\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0016J\b\u0010n\u001a\u00020LH\u0002J\b\u0010o\u001a\u00020LH\u0016J\b\u0010p\u001a\u00020LH\u0002J\u0010\u0010q\u001a\u00020L2\u0006\u0010r\u001a\u00020;H\u0016J\b\u0010s\u001a\u00020LH\u0016J\b\u0010t\u001a\u00020LH\u0016J\b\u0010u\u001a\u00020LH\u0002R\u0010\u0010%\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u0010\u00109\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010<\u001a\u0004\u0018\u00010=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R+\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010@\u001a\n B*\u0004\u0018\u00010A0A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00108\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020G8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bJ\u00108\u001a\u0004\bH\u0010I¨\u0006x"}, d2 = {"Lio/sentry/android/replay/ReplayIntegration;", "Lio/sentry/Integration;", "Ljava/io/Closeable;", "Lio/sentry/android/replay/ScreenshotRecorderCallback;", "Lio/sentry/android/replay/gestures/TouchRecorderCallback;", "Lio/sentry/ReplayController;", "Landroid/content/ComponentCallbacks;", "Lio/sentry/IConnectionStatusProvider$IConnectionStatusObserver;", "Lio/sentry/transport/RateLimiter$IRateLimitObserver;", "context", "Landroid/content/Context;", "dateProvider", "Lio/sentry/transport/ICurrentDateProvider;", "(Landroid/content/Context;Lio/sentry/transport/ICurrentDateProvider;)V", "recorderProvider", "Lkotlin/Function0;", "Lio/sentry/android/replay/Recorder;", "recorderConfigProvider", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "configChanged", "Lio/sentry/android/replay/ScreenshotRecorderConfig;", "replayCacheProvider", "Lio/sentry/protocol/SentryId;", "replayId", "Lio/sentry/android/replay/ReplayCache;", "replayCaptureStrategyProvider", "isFullSession", "Lio/sentry/android/replay/capture/CaptureStrategy;", "mainLooperHandler", "Lio/sentry/android/replay/util/MainLooperHandler;", "gestureRecorderProvider", "Lio/sentry/android/replay/gestures/GestureRecorder;", "(Landroid/content/Context;Lio/sentry/transport/ICurrentDateProvider;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lio/sentry/android/replay/util/MainLooperHandler;Lkotlin/jvm/functions/Function0;)V", "(Landroid/content/Context;Lio/sentry/transport/ICurrentDateProvider;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "captureStrategy", "gestureRecorder", "hub", "Lio/sentry/IHub;", "isEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isEnabled$sentry_android_replay_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isManualPause", "isManualPause$sentry_android_replay_release", "lifecycle", "Lio/sentry/android/replay/ReplayLifecycle;", "options", "Lio/sentry/SentryOptions;", "random", "Lio/sentry/util/Random;", "getRandom", "()Lio/sentry/util/Random;", "random$delegate", "Lkotlin/Lazy;", "recorder", "replayBreadcrumbConverter", "Lio/sentry/ReplayBreadcrumbConverter;", "replayCacheDir", "Ljava/io/File;", "getReplayCacheDir", "()Ljava/io/File;", "replayExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "getReplayExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "replayExecutor$delegate", "rootViewsSpy", "Lio/sentry/android/replay/RootViewsSpy;", "getRootViewsSpy$sentry_android_replay_release", "()Lio/sentry/android/replay/RootViewsSpy;", "rootViewsSpy$delegate", "captureReplay", "", "isTerminating", "(Ljava/lang/Boolean;)V", "checkCanRecord", "cleanupReplays", "unfinishedReplayId", "", "close", "finalizePreviousReplay", "getBreadcrumbConverter", "getReplayId", "isRecording", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onConnectionStatusChanged", "status", "Lio/sentry/IConnectionStatusProvider$ConnectionStatus;", "onLowMemory", "onRateLimitChanged", "rateLimiter", "Lio/sentry/transport/RateLimiter;", "onScreenshotRecorded", "bitmap", "Landroid/graphics/Bitmap;", "screenshot", "frameTimestamp", "", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "pause", "pauseInternal", "register", "registerRootViewListeners", "resume", "resumeInternal", "setBreadcrumbConverter", "converter", "start", "stop", "unregisterRootViewListeners", "PreviousReplayHint", "ReplayExecutorServiceThreadFactory", "sentry-android-replay_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ReplayIntegration implements Integration, Closeable, ScreenshotRecorderCallback, TouchRecorderCallback, ReplayController, ComponentCallbacks, IConnectionStatusProvider.IConnectionStatusObserver, RateLimiter.IRateLimitObserver {
    public static final int $stable = 8;
    private CaptureStrategy captureStrategy;
    private final Context context;
    private final ICurrentDateProvider dateProvider;
    private GestureRecorder gestureRecorder;
    private Function0<GestureRecorder> gestureRecorderProvider;
    private IHub hub;
    private final AtomicBoolean isEnabled;
    private final AtomicBoolean isManualPause;
    private final ReplayLifecycle lifecycle;
    private MainLooperHandler mainLooperHandler;
    private SentryOptions options;

    /* renamed from: random$delegate, reason: from kotlin metadata */
    private final Lazy random;
    private Recorder recorder;
    private final Function1<Boolean, ScreenshotRecorderConfig> recorderConfigProvider;
    private final Function0<Recorder> recorderProvider;
    private ReplayBreadcrumbConverter replayBreadcrumbConverter;
    private final Function1<SentryId, ReplayCache> replayCacheProvider;
    private Function1<? super Boolean, ? extends CaptureStrategy> replayCaptureStrategyProvider;

    /* renamed from: replayExecutor$delegate, reason: from kotlin metadata */
    private final Lazy replayExecutor;

    /* renamed from: rootViewsSpy$delegate, reason: from kotlin metadata */
    private final Lazy rootViewsSpy;

    /* compiled from: ReplayIntegration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lio/sentry/android/replay/ReplayIntegration$PreviousReplayHint;", "Lio/sentry/hints/Backfillable;", "()V", "shouldEnrich", "", "sentry-android-replay_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PreviousReplayHint implements Backfillable {
        @Override // io.sentry.hints.Backfillable
        public boolean shouldEnrich() {
            return false;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReplayIntegration(Context context, ICurrentDateProvider dateProvider, Function0<? extends Recorder> function0, Function1<? super Boolean, ScreenshotRecorderConfig> function1, Function1<? super SentryId, ReplayCache> function12) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.context = context;
        this.dateProvider = dateProvider;
        this.recorderProvider = function0;
        this.recorderConfigProvider = function1;
        this.replayCacheProvider = function12;
        this.random = LazyKt.lazy(new Function0<Random>() { // from class: io.sentry.android.replay.ReplayIntegration$random$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Random invoke() {
                return new Random();
            }
        });
        this.rootViewsSpy = LazyKt.lazy(new Function0<RootViewsSpy>() { // from class: io.sentry.android.replay.ReplayIntegration$rootViewsSpy$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RootViewsSpy invoke() {
                return RootViewsSpy.INSTANCE.install();
            }
        });
        this.replayExecutor = LazyKt.lazy(new Function0<ScheduledExecutorService>() { // from class: io.sentry.android.replay.ReplayIntegration$replayExecutor$2
            @Override // kotlin.jvm.functions.Function0
            public final ScheduledExecutorService invoke() {
                return Executors.newSingleThreadScheduledExecutor(new ReplayIntegration.ReplayExecutorServiceThreadFactory());
            }
        });
        this.isEnabled = new AtomicBoolean(false);
        this.isManualPause = new AtomicBoolean(false);
        NoOpReplayBreadcrumbConverter noOpReplayBreadcrumbConverter = NoOpReplayBreadcrumbConverter.getInstance();
        Intrinsics.checkNotNullExpressionValue(noOpReplayBreadcrumbConverter, "getInstance()");
        this.replayBreadcrumbConverter = noOpReplayBreadcrumbConverter;
        this.mainLooperHandler = new MainLooperHandler(null, 1, null);
        this.lifecycle = new ReplayLifecycle();
    }

    public /* synthetic */ ReplayIntegration(Context context, ICurrentDateProvider iCurrentDateProvider, Function0 function0, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, iCurrentDateProvider, (i & 4) != 0 ? null : function0, (i & 8) != 0 ? null : function1, (i & 16) != 0 ? null : function12);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReplayIntegration(Context context, ICurrentDateProvider dateProvider) {
        this(ContextKt.appContext(context), dateProvider, null, null, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
    }

    public /* synthetic */ ReplayIntegration(Context context, ICurrentDateProvider iCurrentDateProvider, Function0 function0, Function1 function1, Function1 function12, Function1 function13, MainLooperHandler mainLooperHandler, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, iCurrentDateProvider, function0, function1, function12, (i & 32) != 0 ? null : function13, (i & 64) != 0 ? null : mainLooperHandler, (i & 128) != 0 ? null : function02);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReplayIntegration(Context context, ICurrentDateProvider dateProvider, Function0<? extends Recorder> function0, Function1<? super Boolean, ScreenshotRecorderConfig> function1, Function1<? super SentryId, ReplayCache> function12, Function1<? super Boolean, ? extends CaptureStrategy> function13, MainLooperHandler mainLooperHandler, Function0<GestureRecorder> function02) {
        this(ContextKt.appContext(context), dateProvider, function0, function1, function12);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.replayCaptureStrategyProvider = function13;
        this.mainLooperHandler = mainLooperHandler == null ? new MainLooperHandler(null, 1, null) : mainLooperHandler;
        this.gestureRecorderProvider = function02;
    }

    private final Random getRandom() {
        return (Random) this.random.getValue();
    }

    public final RootViewsSpy getRootViewsSpy$sentry_android_replay_release() {
        return (RootViewsSpy) this.rootViewsSpy.getValue();
    }

    private final ScheduledExecutorService getReplayExecutor() {
        return (ScheduledExecutorService) this.replayExecutor.getValue();
    }

    /* renamed from: isEnabled$sentry_android_replay_release, reason: from getter */
    public final AtomicBoolean getIsEnabled() {
        return this.isEnabled;
    }

    /* renamed from: isManualPause$sentry_android_replay_release, reason: from getter */
    public final AtomicBoolean getIsManualPause() {
        return this.isManualPause;
    }

    public final File getReplayCacheDir() {
        CaptureStrategy captureStrategy = this.captureStrategy;
        if (captureStrategy != null) {
            return captureStrategy.getReplayCacheDir();
        }
        return null;
    }

    @Override // io.sentry.Integration
    public void register(IHub hub, SentryOptions options) {
        WindowRecorder windowRecorder;
        GestureRecorder gestureRecorder;
        Intrinsics.checkNotNullParameter(hub, "hub");
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        if (Build.VERSION.SDK_INT < 26) {
            options.getLogger().log(SentryLevel.INFO, "Session replay is only supported on API 26 and above", new Object[0]);
            return;
        }
        if (!options.getSessionReplay().isSessionReplayEnabled() && !options.getSessionReplay().isSessionReplayForErrorsEnabled()) {
            options.getLogger().log(SentryLevel.INFO, "Session replay is disabled, no sample rate specified", new Object[0]);
            return;
        }
        this.hub = hub;
        Function0<Recorder> function0 = this.recorderProvider;
        if (function0 == null || (windowRecorder = function0.invoke()) == null) {
            MainLooperHandler mainLooperHandler = this.mainLooperHandler;
            ScheduledExecutorService replayExecutor = getReplayExecutor();
            Intrinsics.checkNotNullExpressionValue(replayExecutor, "replayExecutor");
            windowRecorder = new WindowRecorder(options, this, mainLooperHandler, replayExecutor);
        }
        this.recorder = windowRecorder;
        Function0<GestureRecorder> function02 = this.gestureRecorderProvider;
        if (function02 == null || (gestureRecorder = function02.invoke()) == null) {
            gestureRecorder = new GestureRecorder(options, this);
        }
        this.gestureRecorder = gestureRecorder;
        this.isEnabled.set(true);
        options.getConnectionStatusProvider().addConnectionStatusObserver(this);
        RateLimiter rateLimiter = hub.getRateLimiter();
        if (rateLimiter != null) {
            rateLimiter.addRateLimitObserver(this);
        }
        if (options.getSessionReplay().isTrackOrientationChange()) {
            try {
                this.context.registerComponentCallbacks(this);
            } catch (Throwable th) {
                options.getLogger().log(SentryLevel.INFO, "ComponentCallbacks is not available, orientation changes won't be handled by Session replay", th);
            }
        }
        IntegrationUtils.addIntegrationToSdkVersion("Replay");
        SentryIntegrationPackageStorage.getInstance().addPackage("maven:io.sentry:sentry-android-replay", "7.22.6");
        finalizePreviousReplay();
    }

    @Override // io.sentry.ReplayController
    public boolean isRecording() {
        return this.lifecycle.getCurrentState().compareTo(ReplayState.STARTED) >= 0 && this.lifecycle.getCurrentState().compareTo(ReplayState.STOPPED) < 0;
    }

    @Override // io.sentry.ReplayController
    public synchronized void start() {
        ScreenshotRecorderConfig from;
        BufferCaptureStrategy bufferCaptureStrategy;
        CaptureStrategy captureStrategy;
        if (this.isEnabled.get()) {
            SentryOptions sentryOptions = null;
            if (!this.lifecycle.isAllowed(ReplayState.STARTED)) {
                SentryOptions sentryOptions2 = this.options;
                if (sentryOptions2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                } else {
                    sentryOptions = sentryOptions2;
                }
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Session replay is already being recorded, not starting a new one", new Object[0]);
                return;
            }
            Random random = getRandom();
            SentryOptions sentryOptions3 = this.options;
            if (sentryOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("options");
                sentryOptions3 = null;
            }
            boolean sample = SamplingKt.sample(random, sentryOptions3.getSessionReplay().getSessionSampleRate());
            if (!sample) {
                SentryOptions sentryOptions4 = this.options;
                if (sentryOptions4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                    sentryOptions4 = null;
                }
                if (!sentryOptions4.getSessionReplay().isSessionReplayForErrorsEnabled()) {
                    SentryOptions sentryOptions5 = this.options;
                    if (sentryOptions5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("options");
                    } else {
                        sentryOptions = sentryOptions5;
                    }
                    sentryOptions.getLogger().log(SentryLevel.INFO, "Session replay is not started, full session was not sampled and onErrorSampleRate is not specified", new Object[0]);
                    return;
                }
            }
            Function1<Boolean, ScreenshotRecorderConfig> function1 = this.recorderConfigProvider;
            if (function1 == null || (from = function1.invoke(false)) == null) {
                ScreenshotRecorderConfig.Companion companion = ScreenshotRecorderConfig.INSTANCE;
                Context context = this.context;
                SentryOptions sentryOptions6 = this.options;
                if (sentryOptions6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                    sentryOptions6 = null;
                }
                SentryReplayOptions sessionReplay = sentryOptions6.getSessionReplay();
                Intrinsics.checkNotNullExpressionValue(sessionReplay, "options.sessionReplay");
                from = companion.from(context, sessionReplay);
            }
            Function1<? super Boolean, ? extends CaptureStrategy> function12 = this.replayCaptureStrategyProvider;
            if (function12 == null || (captureStrategy = function12.invoke(Boolean.valueOf(sample))) == null) {
                if (sample) {
                    SentryOptions sentryOptions7 = this.options;
                    if (sentryOptions7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("options");
                        sentryOptions7 = null;
                    }
                    IHub iHub = this.hub;
                    ICurrentDateProvider iCurrentDateProvider = this.dateProvider;
                    ScheduledExecutorService replayExecutor = getReplayExecutor();
                    Intrinsics.checkNotNullExpressionValue(replayExecutor, "replayExecutor");
                    bufferCaptureStrategy = new SessionCaptureStrategy(sentryOptions7, iHub, iCurrentDateProvider, replayExecutor, this.replayCacheProvider);
                } else {
                    SentryOptions sentryOptions8 = this.options;
                    if (sentryOptions8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("options");
                        sentryOptions8 = null;
                    }
                    IHub iHub2 = this.hub;
                    ICurrentDateProvider iCurrentDateProvider2 = this.dateProvider;
                    Random random2 = getRandom();
                    ScheduledExecutorService replayExecutor2 = getReplayExecutor();
                    Intrinsics.checkNotNullExpressionValue(replayExecutor2, "replayExecutor");
                    bufferCaptureStrategy = new BufferCaptureStrategy(sentryOptions8, iHub2, iCurrentDateProvider2, random2, replayExecutor2, this.replayCacheProvider);
                }
                captureStrategy = bufferCaptureStrategy;
            }
            this.captureStrategy = captureStrategy;
            if (captureStrategy != null) {
                CaptureStrategy.DefaultImpls.start$default(captureStrategy, from, 0, null, null, 14, null);
            }
            Recorder recorder = this.recorder;
            if (recorder != null) {
                recorder.start(from);
            }
            registerRootViewListeners();
            this.lifecycle.setCurrentState$sentry_android_replay_release(ReplayState.STARTED);
        }
    }

    @Override // io.sentry.ReplayController
    public void resume() {
        this.isManualPause.set(false);
        resumeInternal();
    }

    private final synchronized void resumeInternal() {
        IHub iHub;
        IHub iHub2;
        RateLimiter rateLimiter;
        RateLimiter rateLimiter2;
        if (this.isEnabled.get() && this.lifecycle.isAllowed(ReplayState.RESUMED)) {
            if (!this.isManualPause.get()) {
                SentryOptions sentryOptions = this.options;
                if (sentryOptions == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                    sentryOptions = null;
                }
                if (sentryOptions.getConnectionStatusProvider().getConnectionStatus() != IConnectionStatusProvider.ConnectionStatus.DISCONNECTED && (((iHub = this.hub) == null || (rateLimiter2 = iHub.getRateLimiter()) == null || !rateLimiter2.isActiveForCategory(DataCategory.All)) && ((iHub2 = this.hub) == null || (rateLimiter = iHub2.getRateLimiter()) == null || !rateLimiter.isActiveForCategory(DataCategory.Replay)))) {
                    CaptureStrategy captureStrategy = this.captureStrategy;
                    if (captureStrategy != null) {
                        captureStrategy.resume();
                    }
                    Recorder recorder = this.recorder;
                    if (recorder != null) {
                        recorder.resume();
                    }
                    this.lifecycle.setCurrentState$sentry_android_replay_release(ReplayState.RESUMED);
                }
            }
        }
    }

    @Override // io.sentry.ReplayController
    public synchronized void captureReplay(Boolean isTerminating) {
        if (this.isEnabled.get() && isRecording()) {
            SentryId sentryId = SentryId.EMPTY_ID;
            CaptureStrategy captureStrategy = this.captureStrategy;
            SentryOptions sentryOptions = null;
            if (sentryId.equals(captureStrategy != null ? captureStrategy.getCurrentReplayId() : null)) {
                SentryOptions sentryOptions2 = this.options;
                if (sentryOptions2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                } else {
                    sentryOptions = sentryOptions2;
                }
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Replay id is not set, not capturing for event", new Object[0]);
                return;
            }
            CaptureStrategy captureStrategy2 = this.captureStrategy;
            if (captureStrategy2 != null) {
                captureStrategy2.captureReplay(Intrinsics.areEqual((Object) isTerminating, (Object) true), new Function1<Date, Unit>() { // from class: io.sentry.android.replay.ReplayIntegration$captureReplay$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Date date) {
                        invoke2(date);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Date newTimestamp) {
                        CaptureStrategy captureStrategy3;
                        CaptureStrategy captureStrategy4;
                        CaptureStrategy captureStrategy5;
                        Intrinsics.checkNotNullParameter(newTimestamp, "newTimestamp");
                        captureStrategy3 = ReplayIntegration.this.captureStrategy;
                        if (captureStrategy3 != null) {
                            captureStrategy5 = ReplayIntegration.this.captureStrategy;
                            Integer valueOf = captureStrategy5 != null ? Integer.valueOf(captureStrategy5.getCurrentSegment()) : null;
                            Intrinsics.checkNotNull(valueOf);
                            captureStrategy3.setCurrentSegment(valueOf.intValue() + 1);
                        }
                        captureStrategy4 = ReplayIntegration.this.captureStrategy;
                        if (captureStrategy4 == null) {
                            return;
                        }
                        captureStrategy4.setSegmentTimestamp(newTimestamp);
                    }
                });
            }
            CaptureStrategy captureStrategy3 = this.captureStrategy;
            this.captureStrategy = captureStrategy3 != null ? captureStrategy3.convert() : null;
        }
    }

    @Override // io.sentry.ReplayController
    public SentryId getReplayId() {
        SentryId currentReplayId;
        CaptureStrategy captureStrategy = this.captureStrategy;
        if (captureStrategy != null && (currentReplayId = captureStrategy.getCurrentReplayId()) != null) {
            return currentReplayId;
        }
        SentryId EMPTY_ID = SentryId.EMPTY_ID;
        Intrinsics.checkNotNullExpressionValue(EMPTY_ID, "EMPTY_ID");
        return EMPTY_ID;
    }

    @Override // io.sentry.ReplayController
    public void setBreadcrumbConverter(ReplayBreadcrumbConverter converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.replayBreadcrumbConverter = converter;
    }

    @Override // io.sentry.ReplayController
    /* renamed from: getBreadcrumbConverter, reason: from getter */
    public ReplayBreadcrumbConverter getReplayBreadcrumbConverter() {
        return this.replayBreadcrumbConverter;
    }

    @Override // io.sentry.ReplayController
    public void pause() {
        this.isManualPause.set(true);
        pauseInternal();
    }

    private final synchronized void pauseInternal() {
        if (this.isEnabled.get() && this.lifecycle.isAllowed(ReplayState.PAUSED)) {
            Recorder recorder = this.recorder;
            if (recorder != null) {
                recorder.pause();
            }
            CaptureStrategy captureStrategy = this.captureStrategy;
            if (captureStrategy != null) {
                captureStrategy.pause();
            }
            this.lifecycle.setCurrentState$sentry_android_replay_release(ReplayState.PAUSED);
        }
    }

    @Override // io.sentry.ReplayController
    public synchronized void stop() {
        if (this.isEnabled.get() && this.lifecycle.isAllowed(ReplayState.STOPPED)) {
            unregisterRootViewListeners();
            Recorder recorder = this.recorder;
            if (recorder != null) {
                recorder.stop();
            }
            GestureRecorder gestureRecorder = this.gestureRecorder;
            if (gestureRecorder != null) {
                gestureRecorder.stop();
            }
            CaptureStrategy captureStrategy = this.captureStrategy;
            if (captureStrategy != null) {
                captureStrategy.stop();
            }
            this.captureStrategy = null;
            this.lifecycle.setCurrentState$sentry_android_replay_release(ReplayState.STOPPED);
        }
    }

    @Override // io.sentry.android.replay.ScreenshotRecorderCallback
    public void onScreenshotRecorded(final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        IHub iHub = this.hub;
        if (iHub != null) {
            iHub.configureScope(new ScopeCallback() { // from class: io.sentry.android.replay.ReplayIntegration$$ExternalSyntheticLambda1
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    ReplayIntegration.onScreenshotRecorded$lambda$0(Ref.ObjectRef.this, iScope);
                }
            });
        }
        CaptureStrategy captureStrategy = this.captureStrategy;
        if (captureStrategy != null) {
            captureStrategy.onScreenshotRecorded(bitmap, new Function2<ReplayCache, Long, Unit>() { // from class: io.sentry.android.replay.ReplayIntegration$onScreenshotRecorded$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ReplayCache replayCache, Long l) {
                    invoke(replayCache, l.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ReplayCache onScreenshotRecorded, long j) {
                    Intrinsics.checkNotNullParameter(onScreenshotRecorded, "$this$onScreenshotRecorded");
                    onScreenshotRecorded.addFrame$sentry_android_replay_release(bitmap, j, objectRef.element);
                    this.checkCanRecord();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onScreenshotRecorded$lambda$0(Ref.ObjectRef screen, IScope it) {
        Intrinsics.checkNotNullParameter(screen, "$screen");
        Intrinsics.checkNotNullParameter(it, "it");
        String screen2 = it.getScreen();
        screen.element = screen2 != null ? StringsKt.substringAfterLast$default(screen2, '.', (String) null, 2, (Object) null) : 0;
    }

    @Override // io.sentry.android.replay.ScreenshotRecorderCallback
    public void onScreenshotRecorded(final File screenshot, final long frameTimestamp) {
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        CaptureStrategy captureStrategy = this.captureStrategy;
        if (captureStrategy != null) {
            CaptureStrategy.DefaultImpls.onScreenshotRecorded$default(captureStrategy, null, new Function2<ReplayCache, Long, Unit>() { // from class: io.sentry.android.replay.ReplayIntegration$onScreenshotRecorded$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ReplayCache replayCache, Long l) {
                    invoke(replayCache, l.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ReplayCache onScreenshotRecorded, long j) {
                    Intrinsics.checkNotNullParameter(onScreenshotRecorded, "$this$onScreenshotRecorded");
                    ReplayCache.addFrame$default(onScreenshotRecorded, screenshot, frameTimestamp, null, 4, null);
                    this.checkCanRecord();
                }
            }, 1, null);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        RateLimiter rateLimiter;
        if (this.isEnabled.get() && this.lifecycle.isAllowed(ReplayState.CLOSED)) {
            SentryOptions sentryOptions = this.options;
            SentryOptions sentryOptions2 = null;
            if (sentryOptions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("options");
                sentryOptions = null;
            }
            sentryOptions.getConnectionStatusProvider().removeConnectionStatusObserver(this);
            IHub iHub = this.hub;
            if (iHub != null && (rateLimiter = iHub.getRateLimiter()) != null) {
                rateLimiter.removeRateLimitObserver(this);
            }
            SentryOptions sentryOptions3 = this.options;
            if (sentryOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("options");
                sentryOptions3 = null;
            }
            if (sentryOptions3.getSessionReplay().isTrackOrientationChange()) {
                try {
                    this.context.unregisterComponentCallbacks(this);
                } catch (Throwable unused) {
                }
            }
            stop();
            Recorder recorder = this.recorder;
            if (recorder != null) {
                recorder.close();
            }
            this.recorder = null;
            getRootViewsSpy$sentry_android_replay_release().close();
            ScheduledExecutorService replayExecutor = getReplayExecutor();
            Intrinsics.checkNotNullExpressionValue(replayExecutor, "replayExecutor");
            ScheduledExecutorService scheduledExecutorService = replayExecutor;
            SentryOptions sentryOptions4 = this.options;
            if (sentryOptions4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("options");
            } else {
                sentryOptions2 = sentryOptions4;
            }
            ExecutorsKt.gracefullyShutdown(scheduledExecutorService, sentryOptions2);
            this.lifecycle.setCurrentState$sentry_android_replay_release(ReplayState.CLOSED);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        ScreenshotRecorderConfig from;
        Recorder recorder;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (this.isEnabled.get() && isRecording()) {
            Recorder recorder2 = this.recorder;
            if (recorder2 != null) {
                recorder2.stop();
            }
            Function1<Boolean, ScreenshotRecorderConfig> function1 = this.recorderConfigProvider;
            if (function1 == null || (from = function1.invoke(true)) == null) {
                ScreenshotRecorderConfig.Companion companion = ScreenshotRecorderConfig.INSTANCE;
                Context context = this.context;
                SentryOptions sentryOptions = this.options;
                if (sentryOptions == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                    sentryOptions = null;
                }
                SentryReplayOptions sessionReplay = sentryOptions.getSessionReplay();
                Intrinsics.checkNotNullExpressionValue(sessionReplay, "options.sessionReplay");
                from = companion.from(context, sessionReplay);
            }
            CaptureStrategy captureStrategy = this.captureStrategy;
            if (captureStrategy != null) {
                captureStrategy.onConfigurationChanged(from);
            }
            Recorder recorder3 = this.recorder;
            if (recorder3 != null) {
                recorder3.start(from);
            }
            if (this.lifecycle.getCurrentState() != ReplayState.PAUSED || (recorder = this.recorder) == null) {
                return;
            }
            recorder.pause();
        }
    }

    @Override // io.sentry.IConnectionStatusProvider.IConnectionStatusObserver
    public void onConnectionStatusChanged(IConnectionStatusProvider.ConnectionStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (this.captureStrategy instanceof SessionCaptureStrategy) {
            if (status == IConnectionStatusProvider.ConnectionStatus.DISCONNECTED) {
                pauseInternal();
            } else {
                resumeInternal();
            }
        }
    }

    @Override // io.sentry.transport.RateLimiter.IRateLimitObserver
    public void onRateLimitChanged(RateLimiter rateLimiter) {
        Intrinsics.checkNotNullParameter(rateLimiter, "rateLimiter");
        if (this.captureStrategy instanceof SessionCaptureStrategy) {
            if (rateLimiter.isActiveForCategory(DataCategory.All) || rateLimiter.isActiveForCategory(DataCategory.Replay)) {
                pauseInternal();
            } else {
                resumeInternal();
            }
        }
    }

    @Override // io.sentry.android.replay.gestures.TouchRecorderCallback
    public void onTouchEvent(MotionEvent event) {
        CaptureStrategy captureStrategy;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isEnabled.get() && this.lifecycle.isTouchRecordingAllowed() && (captureStrategy = this.captureStrategy) != null) {
            captureStrategy.onTouchEvent(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkCanRecord() {
        IHub iHub;
        IHub iHub2;
        RateLimiter rateLimiter;
        RateLimiter rateLimiter2;
        if (this.captureStrategy instanceof SessionCaptureStrategy) {
            SentryOptions sentryOptions = this.options;
            if (sentryOptions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("options");
                sentryOptions = null;
            }
            if (sentryOptions.getConnectionStatusProvider().getConnectionStatus() == IConnectionStatusProvider.ConnectionStatus.DISCONNECTED || !(((iHub = this.hub) == null || (rateLimiter2 = iHub.getRateLimiter()) == null || !rateLimiter2.isActiveForCategory(DataCategory.All)) && ((iHub2 = this.hub) == null || (rateLimiter = iHub2.getRateLimiter()) == null || !rateLimiter.isActiveForCategory(DataCategory.Replay)))) {
                pauseInternal();
            }
        }
    }

    private final void registerRootViewListeners() {
        if (this.recorder instanceof OnRootViewsChangedListener) {
            CopyOnWriteArrayList<OnRootViewsChangedListener> listeners = getRootViewsSpy$sentry_android_replay_release().getListeners();
            Recorder recorder = this.recorder;
            Intrinsics.checkNotNull(recorder, "null cannot be cast to non-null type io.sentry.android.replay.OnRootViewsChangedListener");
            listeners.add((OnRootViewsChangedListener) recorder);
        }
        getRootViewsSpy$sentry_android_replay_release().getListeners().add(this.gestureRecorder);
    }

    private final void unregisterRootViewListeners() {
        if (this.recorder instanceof OnRootViewsChangedListener) {
            CopyOnWriteArrayList<OnRootViewsChangedListener> listeners = getRootViewsSpy$sentry_android_replay_release().getListeners();
            Recorder recorder = this.recorder;
            Intrinsics.checkNotNull(recorder, "null cannot be cast to non-null type io.sentry.android.replay.OnRootViewsChangedListener");
            listeners.remove((OnRootViewsChangedListener) recorder);
        }
        getRootViewsSpy$sentry_android_replay_release().getListeners().remove(this.gestureRecorder);
    }

    static /* synthetic */ void cleanupReplays$default(ReplayIntegration replayIntegration, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        replayIntegration.cleanupReplays(str);
    }

    private final void cleanupReplays(String unfinishedReplayId) {
        File[] listFiles;
        SentryOptions sentryOptions = this.options;
        if (sentryOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("options");
            sentryOptions = null;
        }
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath == null || (listFiles = new File(cacheDirPath).listFiles()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        for (File file : listFiles) {
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "name");
            if (StringsKt.startsWith$default(name, "replay_", false, 2, (Object) null)) {
                String str = name;
                String sentryId = getReplayId().toString();
                Intrinsics.checkNotNullExpressionValue(sentryId, "replayId.toString()");
                if (!StringsKt.contains$default((CharSequence) str, (CharSequence) sentryId, false, 2, (Object) null)) {
                    String str2 = unfinishedReplayId;
                    if (StringsKt.isBlank(str2) || !StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null)) {
                        FileUtils.deleteRecursively(file);
                    }
                }
            }
        }
    }

    private final void finalizePreviousReplay() {
        SentryOptions sentryOptions = this.options;
        SentryOptions sentryOptions2 = null;
        if (sentryOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("options");
            sentryOptions = null;
        }
        ISentryExecutorService executorService = sentryOptions.getExecutorService();
        Intrinsics.checkNotNullExpressionValue(executorService, "options.executorService");
        SentryOptions sentryOptions3 = this.options;
        if (sentryOptions3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("options");
        } else {
            sentryOptions2 = sentryOptions3;
        }
        ExecutorsKt.submitSafely(executorService, sentryOptions2, "ReplayIntegration.finalize_previous_replay", new Runnable() { // from class: io.sentry.android.replay.ReplayIntegration$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ReplayIntegration.finalizePreviousReplay$lambda$5(ReplayIntegration.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finalizePreviousReplay$lambda$5(ReplayIntegration this$0) {
        SentryOptions sentryOptions;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SentryOptions sentryOptions2 = this$0.options;
        if (sentryOptions2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("options");
            sentryOptions2 = null;
        }
        PersistingScopeObserver findPersistingScopeObserver = sentryOptions2.findPersistingScopeObserver();
        if (findPersistingScopeObserver != null) {
            SentryOptions sentryOptions3 = this$0.options;
            if (sentryOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("options");
                sentryOptions3 = null;
            }
            String str = (String) findPersistingScopeObserver.read(sentryOptions3, PersistingScopeObserver.REPLAY_FILENAME, String.class);
            if (str != null) {
                SentryId sentryId = new SentryId(str);
                if (Intrinsics.areEqual(sentryId, SentryId.EMPTY_ID)) {
                    cleanupReplays$default(this$0, null, 1, null);
                    return;
                }
                ReplayCache.Companion companion = ReplayCache.INSTANCE;
                SentryOptions sentryOptions4 = this$0.options;
                if (sentryOptions4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                    sentryOptions4 = null;
                }
                LastSegmentData fromDisk$sentry_android_replay_release = companion.fromDisk$sentry_android_replay_release(sentryOptions4, sentryId, this$0.replayCacheProvider);
                if (fromDisk$sentry_android_replay_release == null) {
                    cleanupReplays$default(this$0, null, 1, null);
                    return;
                }
                SentryOptions sentryOptions5 = this$0.options;
                if (sentryOptions5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                    sentryOptions5 = null;
                }
                Object read = findPersistingScopeObserver.read(sentryOptions5, PersistingScopeObserver.BREADCRUMBS_FILENAME, List.class);
                List<Breadcrumb> list = read instanceof List ? (List) read : null;
                CaptureStrategy.Companion companion2 = CaptureStrategy.INSTANCE;
                IHub iHub = this$0.hub;
                SentryOptions sentryOptions6 = this$0.options;
                if (sentryOptions6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                    sentryOptions = null;
                } else {
                    sentryOptions = sentryOptions6;
                }
                CaptureStrategy.ReplaySegment createSegment = companion2.createSegment(iHub, sentryOptions, fromDisk$sentry_android_replay_release.getDuration(), fromDisk$sentry_android_replay_release.getTimestamp(), sentryId, fromDisk$sentry_android_replay_release.getId(), fromDisk$sentry_android_replay_release.getRecorderConfig().getRecordingHeight(), fromDisk$sentry_android_replay_release.getRecorderConfig().getRecordingWidth(), fromDisk$sentry_android_replay_release.getReplayType(), fromDisk$sentry_android_replay_release.getCache(), fromDisk$sentry_android_replay_release.getRecorderConfig().getFrameRate(), fromDisk$sentry_android_replay_release.getRecorderConfig().getBitRate(), fromDisk$sentry_android_replay_release.getScreenAtStart(), list, new LinkedList(fromDisk$sentry_android_replay_release.getEvents()));
                if (createSegment instanceof CaptureStrategy.ReplaySegment.Created) {
                    Hint hint = HintUtils.createWithTypeCheckHint(new PreviousReplayHint());
                    IHub iHub2 = this$0.hub;
                    Intrinsics.checkNotNullExpressionValue(hint, "hint");
                    ((CaptureStrategy.ReplaySegment.Created) createSegment).capture(iHub2, hint);
                }
                this$0.cleanupReplays(str);
                return;
            }
        }
        cleanupReplays$default(this$0, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReplayIntegration.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/sentry/android/replay/ReplayIntegration$ReplayExecutorServiceThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "()V", "cnt", "", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "sentry-android-replay_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class ReplayExecutorServiceThreadFactory implements ThreadFactory {
        private int cnt;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Intrinsics.checkNotNullParameter(r, "r");
            StringBuilder sb = new StringBuilder("SentryReplayIntegration-");
            int i = this.cnt;
            this.cnt = i + 1;
            sb.append(i);
            Thread thread = new Thread(r, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }
}

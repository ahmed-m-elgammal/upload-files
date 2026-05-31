package com.reactnativeavoidsoftinput.listeners;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: WindowInsetsListenerImpl.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reactnativeavoidsoftinput/listeners/WindowInsetsListenerImpl;", "Lcom/reactnativeavoidsoftinput/listeners/WindowInsetsListener;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mDebounceHeightChangeJob", "Lkotlinx/coroutines/Job;", "mDebounceHideJob", "mDebounceShowJob", "mListener", "Lcom/reactnativeavoidsoftinput/listeners/SoftInputListener;", "mMinSoftInputHeightToDetect", "", "mPersistedFrom", "Ljava/lang/Integer;", "mPreviousHeight", "mPreviousScreenHeight", "onApplyWindowInsetsListener", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onHeightChange", Constants.MessagePayloadKeys.FROM, "to", "onHide", "onShow", "registerWindowInsetsListener", "setSoftInputListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterWindowInsetsListener", "Companion", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WindowInsetsListenerImpl implements WindowInsetsListener {
    private static final long DEBOUNCE_DELAY_IN_MS = 250;
    private Job mDebounceHeightChangeJob;
    private Job mDebounceHideJob;
    private Job mDebounceShowJob;
    private SoftInputListener mListener;
    private Integer mPersistedFrom;
    private int mPreviousHeight;
    private int mPreviousScreenHeight = DisplayMetricsHolder.getScreenDisplayMetrics().heightPixels;
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    private final int mMinSoftInputHeightToDetect = (int) PixelUtil.toPixelFromDIP(60.0f);

    private final void onShow(int from, int to) {
        Job launch$default;
        Job job = this.mDebounceShowJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.mDebounceHideJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new WindowInsetsListenerImpl$onShow$1(this, from, to, null), 3, null);
        this.mDebounceShowJob = launch$default;
    }

    private final void onHide(int from, int to) {
        Job launch$default;
        Job job = this.mDebounceHideJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.mDebounceShowJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new WindowInsetsListenerImpl$onHide$1(this, from, to, null), 3, null);
        this.mDebounceHideJob = launch$default;
    }

    private final void onHeightChange(int from, int to) {
        Job launch$default;
        Job job = this.mDebounceHeightChangeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new WindowInsetsListenerImpl$onHeightChange$1(this, from, to, null), 3, null);
        this.mDebounceHeightChangeJob = launch$default;
    }

    private final void onApplyWindowInsetsListener(View view) {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if (rootWindowInsets == null) {
            return;
        }
        Insets insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        Insets insets2 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        if (this.mPersistedFrom == null) {
            this.mPersistedFrom = Integer.valueOf(this.mPreviousHeight);
        }
        int max = Math.max(insets.bottom - insets2.bottom, 0);
        Integer num = this.mPersistedFrom;
        onHeightChange(num != null ? num.intValue() : this.mPreviousHeight, max);
        int i = this.mPreviousHeight;
        if (i != max && max > this.mMinSoftInputHeightToDetect) {
            onShow(i, max);
            return;
        }
        if (i != 0 && max <= this.mMinSoftInputHeightToDetect) {
            onHide(i, 0);
            return;
        }
        Job job = this.mDebounceHideJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.reactnativeavoidsoftinput.listeners.WindowInsetsListener
    public void setSoftInputListener(SoftInputListener listener) {
        this.mListener = listener;
    }

    @Override // com.reactnativeavoidsoftinput.listeners.WindowInsetsListener
    public void registerWindowInsetsListener(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.reactnativeavoidsoftinput.listeners.WindowInsetsListenerImpl$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat registerWindowInsetsListener$lambda$0;
                registerWindowInsetsListener$lambda$0 = WindowInsetsListenerImpl.registerWindowInsetsListener$lambda$0(WindowInsetsListenerImpl.this, view2, windowInsetsCompat);
                return registerWindowInsetsListener$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat registerWindowInsetsListener$lambda$0(WindowInsetsListenerImpl this$0, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        this$0.onApplyWindowInsetsListener(v);
        return insets;
    }

    @Override // com.reactnativeavoidsoftinput.listeners.WindowInsetsListener
    public void unregisterWindowInsetsListener(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewCompat.setOnApplyWindowInsetsListener(view, null);
    }
}

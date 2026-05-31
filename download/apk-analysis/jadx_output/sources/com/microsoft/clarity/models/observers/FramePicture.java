package com.microsoft.clarity.models.observers;

import android.graphics.Picture;
import android.view.Window;
import io.sentry.protocol.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a¢\u0006\u0002\u0010\u001dR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\"R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010)R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010$\"\u0004\b-\u0010)R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/microsoft/clarity/models/observers/FramePicture;", "Lcom/microsoft/clarity/models/observers/ObservedEvent;", "picture", "Landroid/graphics/Picture;", "viewHierarchy", "Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "isFullFrame", "", "isForceStartNewSessionFirstFrame", "forceStartNewSessionCallback", "Lkotlin/Function1;", "", "", "isNewPageFirstFrame", "timestamp", "", "screenMetadata", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "screenWidth", "", "screenHeight", "keyboardHeight", "systemBackgroundColor", "density", "", ViewHierarchy.JsonKeys.WINDOWS, "", "Ljava/lang/ref/WeakReference;", "Landroid/view/Window;", "(Landroid/graphics/Picture;Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;ZZLkotlin/jvm/functions/Function1;ZJLcom/microsoft/clarity/models/observers/ScreenMetadata;IIIIFLjava/util/List;)V", "getDensity", "()F", "getForceStartNewSessionCallback", "()Lkotlin/jvm/functions/Function1;", "()Z", "getKeyboardHeight", "()I", "getPicture", "()Landroid/graphics/Picture;", "getScreenHeight", "setScreenHeight", "(I)V", "getScreenMetadata", "()Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "getScreenWidth", "setScreenWidth", "getSystemBackgroundColor", "getViewHierarchy", "()Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "getWindows", "()Ljava/util/List;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FramePicture extends ObservedEvent {
    private final float density;
    private final Function1<String, Unit> forceStartNewSessionCallback;
    private final boolean isForceStartNewSessionFirstFrame;
    private final boolean isFullFrame;
    private final boolean isNewPageFirstFrame;
    private final int keyboardHeight;
    private final Picture picture;
    private int screenHeight;
    private final ScreenMetadata screenMetadata;
    private int screenWidth;
    private final int systemBackgroundColor;
    private final com.microsoft.clarity.models.viewhierarchy.ViewHierarchy viewHierarchy;
    private final List<WeakReference<Window>> windows;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FramePicture(Picture picture, com.microsoft.clarity.models.viewhierarchy.ViewHierarchy viewHierarchy, boolean z, boolean z2, Function1<? super String, Unit> function1, boolean z3, long j, ScreenMetadata screenMetadata, int i, int i2, int i3, int i4, float f, List<? extends WeakReference<Window>> windows) {
        super(j);
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(viewHierarchy, "viewHierarchy");
        Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
        Intrinsics.checkNotNullParameter(windows, "windows");
        this.picture = picture;
        this.viewHierarchy = viewHierarchy;
        this.isFullFrame = z;
        this.isForceStartNewSessionFirstFrame = z2;
        this.forceStartNewSessionCallback = function1;
        this.isNewPageFirstFrame = z3;
        this.screenMetadata = screenMetadata;
        this.screenWidth = i;
        this.screenHeight = i2;
        this.keyboardHeight = i3;
        this.systemBackgroundColor = i4;
        this.density = f;
        this.windows = windows;
    }

    public final float getDensity() {
        return this.density;
    }

    public final Function1<String, Unit> getForceStartNewSessionCallback() {
        return this.forceStartNewSessionCallback;
    }

    public final int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public final Picture getPicture() {
        return this.picture;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final ScreenMetadata getScreenMetadata() {
        return this.screenMetadata;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final int getSystemBackgroundColor() {
        return this.systemBackgroundColor;
    }

    public final com.microsoft.clarity.models.viewhierarchy.ViewHierarchy getViewHierarchy() {
        return this.viewHierarchy;
    }

    public final List<WeakReference<Window>> getWindows() {
        return this.windows;
    }

    /* renamed from: isForceStartNewSessionFirstFrame, reason: from getter */
    public final boolean getIsForceStartNewSessionFirstFrame() {
        return this.isForceStartNewSessionFirstFrame;
    }

    /* renamed from: isFullFrame, reason: from getter */
    public final boolean getIsFullFrame() {
        return this.isFullFrame;
    }

    /* renamed from: isNewPageFirstFrame, reason: from getter */
    public final boolean getIsNewPageFirstFrame() {
        return this.isNewPageFirstFrame;
    }

    public final void setScreenHeight(int i) {
        this.screenHeight = i;
    }

    public final void setScreenWidth(int i) {
        this.screenWidth = i;
    }
}

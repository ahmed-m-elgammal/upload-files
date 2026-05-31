package com.reactnativeavoidsoftinput.animations;

import android.animation.TimeInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.henninghall.date_picker.props.ModeProp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationInterpolator.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reactnativeavoidsoftinput/animations/AnimationInterpolator;", "Landroid/animation/TimeInterpolator;", "()V", "linearInterpolator", "Landroid/view/animation/LinearInterpolator;", "mMode", "Lcom/reactnativeavoidsoftinput/animations/AnimationInterpolator$Companion$MODE;", "newValue", ModeProp.name, "getMode", "()Lcom/reactnativeavoidsoftinput/animations/AnimationInterpolator$Companion$MODE;", "setMode", "(Lcom/reactnativeavoidsoftinput/animations/AnimationInterpolator$Companion$MODE;)V", "pathInterpolator", "Landroid/view/animation/PathInterpolator;", "getInterpolation", "", "input", "Companion", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimationInterpolator implements TimeInterpolator {
    private final LinearInterpolator linearInterpolator = new LinearInterpolator();
    private final PathInterpolator pathInterpolator = new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f);
    private Companion.MODE mMode = Companion.MODE.LINEAR;

    /* compiled from: AnimationInterpolator.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Companion.MODE.values().length];
            try {
                iArr[Companion.MODE.EASE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.MODE.EASE_IN_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Companion.MODE.EASE_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: getMode, reason: from getter */
    public final Companion.MODE getMMode() {
        return this.mMode;
    }

    public final void setMode(Companion.MODE newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        this.mMode = newValue;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        float f;
        float interpolation;
        int i = WhenMappings.$EnumSwitchMapping$0[this.mMode.ordinal()];
        if (i == 1) {
            return this.pathInterpolator.getInterpolation(input);
        }
        if (i != 2) {
            if (i == 3) {
                f = 1;
                interpolation = this.pathInterpolator.getInterpolation(f - input);
            } else {
                return this.linearInterpolator.getInterpolation(input);
            }
        } else {
            if (input < 0.5d) {
                float f2 = 2;
                return this.pathInterpolator.getInterpolation(input * f2) / f2;
            }
            f = 1;
            float f3 = 2;
            interpolation = this.pathInterpolator.getInterpolation((f - input) * f3) / f3;
        }
        return f - interpolation;
    }
}

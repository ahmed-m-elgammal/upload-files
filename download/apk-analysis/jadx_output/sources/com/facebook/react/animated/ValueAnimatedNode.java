package com.facebook.react.animated;

import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes3.dex */
class ValueAnimatedNode extends AnimatedNode {
    double mOffset;
    double mValue;
    private AnimatedNodeValueListener mValueListener;

    public Object getAnimatedObject() {
        return null;
    }

    public ValueAnimatedNode() {
        this.mValue = Double.NaN;
        this.mOffset = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public ValueAnimatedNode(ReadableMap readableMap) {
        this.mValue = Double.NaN;
        this.mOffset = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mValue = readableMap.getDouble("value");
        this.mOffset = readableMap.getDouble("offset");
    }

    public double getValue() {
        if (Double.isNaN(this.mOffset + this.mValue)) {
            update();
        }
        return this.mOffset + this.mValue;
    }

    public void flattenOffset() {
        this.mValue += this.mOffset;
        this.mOffset = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public void extractOffset() {
        this.mOffset += this.mValue;
        this.mValue = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public void onValueUpdate() {
        AnimatedNodeValueListener animatedNodeValueListener = this.mValueListener;
        if (animatedNodeValueListener == null) {
            return;
        }
        animatedNodeValueListener.onValueUpdate(getValue());
    }

    public void setValueListener(AnimatedNodeValueListener animatedNodeValueListener) {
        this.mValueListener = animatedNodeValueListener;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String prettyPrint() {
        return "ValueAnimatedNode[" + this.mTag + "]: value: " + this.mValue + " offset: " + this.mOffset;
    }
}

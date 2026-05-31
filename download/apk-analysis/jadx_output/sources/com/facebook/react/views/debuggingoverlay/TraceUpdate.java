package com.facebook.react.views.debuggingoverlay;

import android.graphics.RectF;

/* loaded from: classes3.dex */
public final class TraceUpdate {
    private final int mColor;
    private final int mId;
    private final RectF mRectangle;

    public TraceUpdate(int i, RectF rectF, int i2) {
        this.mId = i;
        this.mRectangle = rectF;
        this.mColor = i2;
    }

    public int getId() {
        return this.mId;
    }

    public int getColor() {
        return this.mColor;
    }

    public RectF getRectangle() {
        return this.mRectangle;
    }
}

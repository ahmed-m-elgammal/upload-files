package com.google.android.play.core.ktx;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: com.google.android.play:review-ktx@@2.0.0 */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.play.core.ktx.ReviewManagerKtxKt", f = "ReviewManagerKtx.kt", i = {}, l = {22}, m = "requestReview", n = {}, s = {})
/* loaded from: classes4.dex */
final class ReviewManagerKtxKt$requestReview$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    ReviewManagerKtxKt$requestReview$1(Continuation<? super ReviewManagerKtxKt$requestReview$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReviewManagerKtxKt.requestReview(null, this);
    }
}

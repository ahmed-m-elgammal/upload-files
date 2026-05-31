package com.microsoft.clarity.e;

import android.graphics.Point;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.microsoft.clarity.models.viewhierarchy.EditTextInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* renamed from: com.microsoft.clarity.e.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0068k extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0065h f87a;
    public final /* synthetic */ Window b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ r d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ View f;
    public final /* synthetic */ Ref.ObjectRef g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0068k(C0065h c0065h, Window window, Ref.ObjectRef objectRef, r rVar, boolean z, View view, Ref.ObjectRef objectRef2) {
        super(1);
        this.f87a = c0065h;
        this.b = window;
        this.c = objectRef;
        this.d = rVar;
        this.e = z;
        this.f = view;
        this.g = objectRef2;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.microsoft.clarity.models.viewhierarchy.ViewNode] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Point rootViewLocationOnScreen = (Point) obj;
        Intrinsics.checkNotNullParameter(rootViewLocationOnScreen, "rootViewLocationOnScreen");
        this.f87a.c.set(rootViewLocationOnScreen.x, rootViewLocationOnScreen.y);
        if (this.f87a.h == null) {
            View currentFocus = this.b.getCurrentFocus();
            EditText editText = currentFocus instanceof EditText ? (EditText) currentFocus : null;
            if (editText != null) {
                this.f87a.h = new EditTextInfo(editText.hashCode(), editText.length());
            }
        }
        Ref.ObjectRef objectRef = this.c;
        r rVar = this.d;
        View rootView = this.b.getDecorView().getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "window.decorView.rootView");
        objectRef.element = rVar.a(rootView, null, this.e, true, this.f87a);
        if (Intrinsics.areEqual(this.b.getDecorView().getRootView(), this.f)) {
            this.g.element = this.c.element;
        }
        return Unit.INSTANCE;
    }
}

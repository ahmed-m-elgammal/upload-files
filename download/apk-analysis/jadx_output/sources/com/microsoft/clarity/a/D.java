package com.microsoft.clarity.a;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class D extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f16a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(View view) {
        super(0);
        this.f16a = view;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Unit unit;
        Object obj = F.p;
        View view = this.f16a;
        synchronized (obj) {
            com.microsoft.clarity.f.s sVar = F.f18a;
            if (sVar != null) {
                sVar.b(view);
            } else {
                ArrayList arrayList = F.f;
                if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((WeakReference) it.next()).get(), view)) {
                            break;
                        }
                    }
                }
                F.f.add(new WeakReference(view));
            }
            unit = Unit.INSTANCE;
        }
        return unit;
    }
}

package com.microsoft.clarity.f;

import com.microsoft.clarity.models.observers.ErrorDisplayFrame;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class n extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f122a;
    public final /* synthetic */ Ref.ObjectRef b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(q qVar, Ref.ObjectRef objectRef) {
        super(1);
        this.f122a = qVar;
        this.b = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception it = (Exception) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        q.a(this.f122a, it, ErrorType.FramePictureCapture);
        LinkedBlockingQueue linkedBlockingQueue = this.f122a.o;
        long currentTimeMillis = System.currentTimeMillis();
        ScreenMetadata screenMetadata = (ScreenMetadata) this.b.element;
        String message = it.getMessage();
        if (message == null) {
            message = "";
        }
        linkedBlockingQueue.add(new ErrorDisplayFrame(currentTimeMillis, screenMetadata, message));
        return Unit.INSTANCE;
    }
}

package com.microsoft.clarity.f;

import com.microsoft.clarity.models.observers.ErrorDisplayFrame;
import com.microsoft.clarity.models.observers.FramePicture;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* renamed from: com.microsoft.clarity.f.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0091i extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f119a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Ref.ObjectRef c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0091i(q qVar, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        super(1);
        this.f119a = qVar;
        this.b = objectRef;
        this.c = objectRef2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception it = (Exception) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        q.a(this.f119a, it, (ErrorType) this.b.element);
        if (it instanceof com.microsoft.clarity.c.c) {
            this.f119a.y = true;
        } else {
            FramePicture framePicture = (FramePicture) this.c.element;
            if (framePicture != null) {
                q qVar = this.f119a;
                long timestamp = framePicture.getTimestamp();
                ScreenMetadata screenMetadata = framePicture.getScreenMetadata();
                String message = it.getMessage();
                if (message == null) {
                    message = "";
                }
                ErrorDisplayFrame errorDisplayFrame = new ErrorDisplayFrame(timestamp, screenMetadata, message);
                Iterator it2 = qVar.m.iterator();
                while (it2.hasNext()) {
                    r rVar = (r) it2.next();
                    rVar.getClass();
                    Intrinsics.checkNotNullParameter(errorDisplayFrame, "errorDisplayFrame");
                    rVar.f126a.b.a(errorDisplayFrame);
                }
            }
        }
        if (this.b.element == ErrorType.PictureProcessing) {
            this.f119a.a(true);
        }
        return Unit.INSTANCE;
    }
}

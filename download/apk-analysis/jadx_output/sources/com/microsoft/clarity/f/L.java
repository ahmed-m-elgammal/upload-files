package com.microsoft.clarity.f;

import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.SessionMetadata;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final /* synthetic */ class L extends FunctionReferenceImpl implements Function2 {
    public L(M m) {
        super(2, m, M.class, "processWebAsset", "processWebAsset(Ljava/lang/String;[B)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String identifier = (String) obj;
        byte[] p1 = (byte[]) obj2;
        Intrinsics.checkNotNullParameter(identifier, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        M m = (M) this.receiver;
        m.getClass();
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Received web asset " + identifier + '.');
        com.microsoft.clarity.j.b bVar = m.d;
        SessionMetadata sessionMetadata = m.n;
        Intrinsics.checkNotNull(sessionMetadata);
        String sessionId = sessionMetadata.getSessionId();
        AssetType type = AssetType.Web;
        Intrinsics.checkNotNullParameter(p1, "<this>");
        int length = p1.length;
        C0107a byteArrayWindow = new C0107a(p1, 0, length);
        com.microsoft.clarity.j.f fVar = (com.microsoft.clarity.j.f) bVar;
        fVar.getClass();
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(byteArrayWindow, "data");
        com.microsoft.clarity.m.h.b("Save session " + sessionId + " asset " + identifier);
        com.microsoft.clarity.l.c a2 = fVar.a(type);
        String filename = com.microsoft.clarity.j.f.a(sessionId, identifier);
        a2.getClass();
        Intrinsics.checkNotNullParameter(filename, "filename");
        if (!new File(a2.a(filename)).exists()) {
            com.microsoft.clarity.l.d mode = com.microsoft.clarity.l.d.OVERWRITE;
            Intrinsics.checkNotNullParameter(filename, "filename");
            Intrinsics.checkNotNullParameter(byteArrayWindow, "byteArrayWindow");
            Intrinsics.checkNotNullParameter(mode, "mode");
            a2.a(filename, p1, 0, length, mode);
        }
        return Unit.INSTANCE;
    }
}

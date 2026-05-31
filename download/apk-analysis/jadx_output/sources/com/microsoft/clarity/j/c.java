package com.microsoft.clarity.j;

import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.SessionMetadata;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c implements a {
    public static final Object b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.l.c f178a;

    public c(com.microsoft.clarity.l.c metadataStore) {
        Intrinsics.checkNotNullParameter(metadataStore, "metadataStore");
        this.f178a = metadataStore;
    }

    public final void a(String sessionId, SessionMetadata metadata) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        LogLevel logLevel = h.f192a;
        h.b("Setting session " + sessionId + " metadata.");
        String json = metadata.toJson();
        synchronized (b) {
            this.f178a.a(sessionId, json, com.microsoft.clarity.l.d.OVERWRITE);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final SessionMetadata a(String filename) {
        String b2;
        Intrinsics.checkNotNullParameter(filename, "sessionId");
        synchronized (b) {
            com.microsoft.clarity.l.c cVar = this.f178a;
            Intrinsics.checkNotNullParameter(filename, "filename");
            if (!new File(cVar.a(filename)).exists()) {
                filename = null;
            }
            b2 = filename != null ? this.f178a.b(filename) : null;
        }
        if (b2 != null) {
            return SessionMetadata.INSTANCE.fromJson(b2);
        }
        return null;
    }
}

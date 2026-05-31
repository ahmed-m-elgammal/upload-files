package com.microsoft.clarity.f;

import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.SessionMetadata;

/* loaded from: classes5.dex */
public abstract class t {
    public static String a(M m) {
        SessionMetadata sessionMetadata;
        PageMetadata c = m.c();
        if (c == null || (sessionMetadata = c.getSessionMetadata()) == null) {
            return null;
        }
        return sessionMetadata.getSessionId();
    }
}

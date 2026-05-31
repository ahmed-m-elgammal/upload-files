package com.microsoft.clarity.d;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes5.dex */
public final class l implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public int f56a = -1;
    public final HashMap b = new HashMap();
    public final g c;
    public Set d;

    public l(g gVar) {
        this.c = gVar;
    }

    public final synchronized i a(String str) {
        i iVar;
        iVar = (i) this.b.get(str);
        if (iVar != null && !iVar.d) {
            a(iVar);
        }
        return iVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.c.close();
    }

    public final void finalize() {
        super.finalize();
        this.c.close();
    }

    public final void a(i iVar) {
        synchronized (this.c) {
            long a2 = this.c.a();
            this.c.a(iVar.b);
            iVar.a(this, this.c);
            this.c.a(a2);
        }
    }
}

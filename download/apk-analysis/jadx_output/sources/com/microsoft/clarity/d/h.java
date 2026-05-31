package com.microsoft.clarity.d;

import java.util.Set;

/* loaded from: classes5.dex */
public final class h {
    public static l a(g gVar, Set set) {
        l lVar = new l(gVar);
        gVar.d();
        gVar.h();
        lVar.d = set;
        int h = gVar.h();
        gVar.h();
        gVar.h();
        gVar.h();
        for (int i = 0; i < h; i++) {
            String e = gVar.e();
            i cVar = e.equals("cmap") ? new c(lVar) : e.equals("maxp") ? new d(lVar) : new i(lVar);
            cVar.f54a = e;
            gVar.g();
            cVar.b = gVar.g();
            long g = gVar.g();
            cVar.c = g;
            if (g == 0 && !e.equals("glyf")) {
                cVar = null;
            }
            if (cVar != null) {
                if (cVar.b + cVar.c > lVar.c.b()) {
                    com.microsoft.clarity.m.h.e("Skip table '" + cVar.f54a + "' which goes past the file size; offset: " + cVar.b + ", size: " + cVar.c + ", font size: " + lVar.c.b());
                } else {
                    lVar.b.put(cVar.f54a, cVar);
                }
            }
        }
        return lVar;
    }
}

package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzfx {
    private static final zzfx zza = new zzfx();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzgi zzb = new zzfg();

    private zzfx() {
    }

    public static zzfx zza() {
        return zza;
    }

    public final zzgh zzb(Class cls) {
        zzem.zzc(cls, "messageType");
        zzgh zzghVar = (zzgh) this.zzc.get(cls);
        if (zzghVar == null) {
            zzghVar = this.zzb.zza(cls);
            zzem.zzc(cls, "messageType");
            zzem.zzc(zzghVar, "schema");
            zzgh zzghVar2 = (zzgh) this.zzc.putIfAbsent(cls, zzghVar);
            if (zzghVar2 != null) {
                return zzghVar2;
            }
        }
        return zzghVar;
    }
}

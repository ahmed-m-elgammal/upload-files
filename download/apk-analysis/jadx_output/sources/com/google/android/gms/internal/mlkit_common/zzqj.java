package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
final class zzqj extends LazyInstanceMap {
    private zzqj() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzpt zzptVar = (zzpt) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzpz(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzpu(MlKitContext.getInstance().getApplicationContext(), zzptVar), zzptVar.zzb());
    }

    /* synthetic */ zzqj(zzqi zzqiVar) {
    }
}

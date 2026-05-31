package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.core.content.PermissionChecker;

/* compiled from: com.google.mlkit:common@@18.9.0 */
/* loaded from: classes4.dex */
final class zze extends zzs {
    zze() {
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzs
    protected final int zza(Context context, zzr zzrVar, boolean z) {
        return (zzrVar.zza.getAuthority().lastIndexOf(64) < 0 || PermissionChecker.checkSelfPermission(context, "android.permission.INTERACT_ACROSS_USERS") != 0) ? 3 : 2;
    }
}

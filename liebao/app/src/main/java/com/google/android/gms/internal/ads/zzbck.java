package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbck extends zzbcc {
    @Override // com.google.android.gms.internal.ads.zzbcc
    public final zzbbz zza(Context context, zzbcs zzbcsVar, int i, boolean z, zzach zzachVar, zzbcp zzbcpVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || applicationInfo.targetSdkVersion >= 11) {
            zzbcr zzbcrVar = new zzbcr(context, zzbcsVar.zzacc(), zzbcsVar.getRequestId(), zzachVar, zzbcsVar.zzabw());
            if (i == 2) {
                return new zzbcv(context, zzbcrVar, zzbcsVar, z, zzb(zzbcsVar), zzbcpVar);
            }
            return new zzbbq(context, zzbcsVar, z, zzb(zzbcsVar), zzbcpVar, new zzbcr(context, zzbcsVar.zzacc(), zzbcsVar.getRequestId(), zzachVar, zzbcsVar.zzabw()));
        }
        return null;
    }
}

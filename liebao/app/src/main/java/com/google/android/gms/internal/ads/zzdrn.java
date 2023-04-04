package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdrn {
    private HashMap<zzdrf, zzdrm<? extends zzbpc>> zzhro = new HashMap<>();

    public final <AdT extends zzbpc> zzdrm<AdT> zza(zzdrf zzdrfVar, Context context, zzdqs zzdqsVar, zzdru<AdT> zzdruVar) {
        zzdrm<AdT> zzdrmVar = (zzdrm<AdT>) this.zzhro.get(zzdrfVar);
        if (zzdrmVar == null) {
            zzdqy zzdqyVar = new zzdqy(zzdrc.zza(zzdrfVar, context));
            zzdrm<AdT> zzdrmVar2 = new zzdrm<>(zzdqyVar, new zzdrr(zzdqyVar, zzdqsVar, zzdruVar));
            this.zzhro.put(zzdrfVar, zzdrmVar2);
            return zzdrmVar2;
        }
        return zzdrmVar;
    }
}

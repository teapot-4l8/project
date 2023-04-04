package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcpk implements zzcpp {
    private final zzebs zzgka;
    private final Map<String, zzesn<zzcpp>> zzgrq;
    private final zzbvh zzgrr;

    public zzcpk(Map<String, zzesn<zzcpp>> map, zzebs zzebsVar, zzbvh zzbvhVar) {
        this.zzgrq = map;
        this.zzgka = zzebsVar;
        this.zzgrr = zzbvhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcpp
    public final zzebt<zzdpi> zzh(zzauj zzaujVar) {
        this.zzgrr.zzd(zzaujVar);
        zzebt<zzdpi> immediateFailedFuture = zzebh.immediateFailedFuture(new zzcnp(zzdqj.NO_FILL));
        for (String str : ((String) zzww.zzra().zzd(zzabq.zzdav)).split(",")) {
            zzesn<zzcpp> zzesnVar = this.zzgrq.get(str.trim());
            if (zzesnVar != null) {
                immediateFailedFuture = zzebh.zzb(immediateFailedFuture, zzcnp.class, new zzear(zzesnVar, zzaujVar) { // from class: com.google.android.gms.internal.ads.zzcpn
                    private final zzauj zzgqg;
                    private final zzesn zzgrt;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgrt = zzesnVar;
                        this.zzgqg = zzaujVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzear
                    public final zzebt zzf(Object obj) {
                        zzesn zzesnVar2 = this.zzgrt;
                        zzcnp zzcnpVar = (zzcnp) obj;
                        return ((zzcpp) zzesnVar2.get()).zzh(this.zzgqg);
                    }
                }, this.zzgka);
            }
        }
        zzebh.zza(immediateFailedFuture, new zzcpm(this), zzbat.zzekj);
        return immediateFailedFuture;
    }
}

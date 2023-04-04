package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcyl<AdT> implements zzcsz<AdT> {
    private final zzdtg zzfzh;
    private final zzebs zzgzd;
    private final zzacm zzgzk;
    private final zzcym<AdT> zzgzt;

    public zzcyl(zzdtg zzdtgVar, zzebs zzebsVar, zzacm zzacmVar, zzcym<AdT> zzcymVar) {
        this.zzfzh = zzdtgVar;
        this.zzgzd = zzebsVar;
        this.zzgzk = zzacmVar;
        this.zzgzt = zzcymVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return (this.zzgzk == null || zzdotVar.zzhmh == null || zzdotVar.zzhmh.zzdui == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<AdT> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        zzbbe zzbbeVar = new zzbbe();
        zzcyt zzcytVar = new zzcyt();
        zzcytVar.zza(new zzcyn(this, zzbbeVar, zzdpiVar, zzdotVar, zzcytVar));
        return this.zzfzh.zzt(zzdth.CUSTOM_RENDER_SYN).zza(new zzdsq(this, new zzacj(zzcytVar, zzdotVar.zzhmh.zzdug, zzdotVar.zzhmh.zzdui)) { // from class: com.google.android.gms.internal.ads.zzcyk
            private final zzacj zzgzn;
            private final zzcyl zzgzs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgzs = this;
                this.zzgzn = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzdsq
            public final void run() {
                this.zzgzs.zzb(this.zzgzn);
            }
        }, this.zzgzd).zzv(zzdth.CUSTOM_RENDER_ACK).zze(zzbbeVar).zzayi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzacj zzacjVar) {
        this.zzgzk.zza(zzacjVar);
    }
}

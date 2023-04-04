package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqx implements zzbsz, zzbuj, zzbvm {
    private final zzdtw zzdjf;
    private final zzbac zzedz;
    private final zzdtx zzgsu;

    public zzcqx(zzdtx zzdtxVar, zzdtw zzdtwVar, zzbac zzbacVar) {
        this.zzgsu = zzdtxVar;
        this.zzdjf = zzdtwVar;
        this.zzedz = zzbacVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        this.zzdjf.zzb(this.zzgsu.zzw("action", "loaded"));
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzvh zzvhVar) {
        this.zzgsu.zzw("action", "ftl").zzw("ftl", String.valueOf(zzvhVar.errorCode)).zzw("ed", zzvhVar.zzcht);
        this.zzdjf.zzb(this.zzgsu);
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzauj zzaujVar) {
        this.zzgsu.zzq(zzaujVar.zzdys);
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzdpi zzdpiVar) {
        this.zzgsu.zza(zzdpiVar, this.zzedz);
    }
}

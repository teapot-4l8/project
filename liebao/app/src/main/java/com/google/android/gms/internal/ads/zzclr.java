package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzclr implements zzbsz, zzbuj, zzbvm {
    private final zzclz zzgoa;
    private final zzcmg zzgob;

    public zzclr(zzclz zzclzVar, zzcmg zzcmgVar) {
        this.zzgoa = zzclzVar;
        this.zzgob = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        this.zzgoa.zzsx().put("action", "loaded");
        this.zzgob.zzo(this.zzgoa.zzsx());
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzvh zzvhVar) {
        this.zzgoa.zzsx().put("action", "ftl");
        this.zzgoa.zzsx().put("ftl", String.valueOf(zzvhVar.errorCode));
        this.zzgoa.zzsx().put("ed", zzvhVar.zzcht);
        this.zzgob.zzo(this.zzgoa.zzsx());
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzauj zzaujVar) {
        this.zzgoa.zzi(zzaujVar.zzdys);
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzdpi zzdpiVar) {
        this.zzgoa.zze(zzdpiVar);
    }
}

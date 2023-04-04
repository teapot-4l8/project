package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcvl extends zzaps {
    private zzctb<zzaqa, zzcuv> zzgwo;

    private zzcvl(zzcvj zzcvjVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        this.zzgwo = zzctbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzvy() {
        this.zzgwo.zzgvk.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzdm(String str) {
        this.zzgwo.zzgvk.zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzg(zzvh zzvhVar) {
        this.zzgwo.zzgvk.zzc(zzvhVar);
    }
}

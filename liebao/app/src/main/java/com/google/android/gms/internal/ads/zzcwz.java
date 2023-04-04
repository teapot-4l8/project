package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcwz extends zzapy {
    private zzctb<zzaqa, zzcuv> zzgwo;

    private zzcwz(zzcwx zzcwxVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        this.zzgwo = zzctbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapz
    public final void zzvy() {
        this.zzgwo.zzgvk.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzapz
    public final void zzdm(String str) {
        this.zzgwo.zzgvk.zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzapz
    public final void zzg(zzvh zzvhVar) {
        this.zzgwo.zzgvk.zzc(zzvhVar);
    }
}

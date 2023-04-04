package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcvy extends zzapx {
    private zzctb<zzaqa, zzcuv> zzgwo;
    private final /* synthetic */ zzcvw zzgxt;

    private zzcvy(zzcvw zzcvwVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        this.zzgxt = zzcvwVar;
        this.zzgwo = zzctbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    public final void zza(zzaoh zzaohVar) {
        zzcvw.zza(this.zzgxt, zzaohVar);
        this.zzgwo.zzgvk.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    public final void zzdm(String str) {
        this.zzgwo.zzgvk.zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    public final void zzg(zzvh zzvhVar) {
        this.zzgwo.zzgvk.zzc(zzvhVar);
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcyb implements zzbuf {
    private final /* synthetic */ zzctb zzgyr;
    private boolean zzgzg = false;
    private final /* synthetic */ zzbbe zzgzh;
    private final /* synthetic */ zzcxw zzgzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcyb(zzcxw zzcxwVar, zzctb zzctbVar, zzbbe zzbbeVar) {
        this.zzgzi = zzcxwVar;
        this.zzgyr = zzctbVar;
        this.zzgzh = zzbbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void onAdFailedToLoad(int i) {
        if (this.zzgzg) {
            return;
        }
        zzm(new zzvh(i, zzcxw.zza(this.zzgyr.zzcja, i), AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final synchronized void zzf(int i, String str) {
        if (this.zzgzg) {
            return;
        }
        this.zzgzg = true;
        if (str == null) {
            str = zzcxw.zza(this.zzgyr.zzcja, i);
        }
        zzm(new zzvh(i, str, AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final synchronized void zzd(zzvh zzvhVar) {
        this.zzgzg = true;
        zzm(zzvhVar);
    }

    private final void zzm(zzvh zzvhVar) {
        zzdqj zzdqjVar = zzdqj.INTERNAL_ERROR;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxe)).booleanValue()) {
            zzdqjVar = zzdqj.NO_FILL;
        }
        this.zzgzh.setException(new zzctd(zzdqjVar, zzvhVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final synchronized void onAdLoaded() {
        this.zzgzh.set(null);
    }
}

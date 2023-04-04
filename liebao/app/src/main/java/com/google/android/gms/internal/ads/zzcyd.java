package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzcyd extends zzans {
    private final zzbui zzfyn;
    private final zzbty zzfzc;
    private final zzbtb zzgdp;
    private final zzbur zzgds;
    private final zzbtl zzgep;
    private final zzbst zzgeq;
    private final zzbxe zzglt;
    private final zzbwx zzgza;
    private final zzcaa zzgzl;

    public zzcyd(zzbst zzbstVar, zzbtl zzbtlVar, zzbty zzbtyVar, zzbui zzbuiVar, zzbxe zzbxeVar, zzbur zzburVar, zzcaa zzcaaVar, zzbwx zzbwxVar, zzbtb zzbtbVar) {
        this.zzgeq = zzbstVar;
        this.zzgep = zzbtlVar;
        this.zzfzc = zzbtyVar;
        this.zzfyn = zzbuiVar;
        this.zzglt = zzbxeVar;
        this.zzgds = zzburVar;
        this.zzgzl = zzcaaVar;
        this.zzgza = zzbwxVar;
        this.zzgdp = zzbtbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdFailedToLoad(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzafo zzafoVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzanz zzanzVar) {
    }

    public void zza(zzawa zzawaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzb(Bundle bundle) {
    }

    public void zzb(zzavy zzavyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzc(int i, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzc(zzvh zzvhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzdj(String str) {
    }

    public void zzvq() {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdClicked() {
        this.zzgeq.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdClosed() {
        this.zzgds.zza(com.google.android.gms.ads.internal.overlay.zzl.OTHER);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdLeftApplication() {
        this.zzfzc.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdOpened() {
        this.zzgds.zzvz();
        this.zzgza.zzama();
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAppEvent(String str, String str2) {
        this.zzglt.onAppEvent(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdLoaded() {
        this.zzfyn.onAdLoaded();
    }

    public void onAdImpression() {
        this.zzgep.onAdImpression();
        this.zzgza.zzaly();
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onVideoPause() {
        this.zzgzl.onVideoPause();
    }

    public void zzvp() {
        this.zzgzl.onVideoStart();
    }

    public void onVideoEnd() {
        this.zzgzl.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onVideoPlay() {
        this.zzgzl.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzant
    @Deprecated
    public final void zzde(int i) {
        zzf(new zzvh(i, "", AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzdk(String str) {
        zzf(new zzvh(0, str, AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzf(zzvh zzvhVar) {
        this.zzgdp.zzl(zzdqh.zza(zzdqj.MEDIATION_SHOW_ERROR, zzvhVar));
    }
}

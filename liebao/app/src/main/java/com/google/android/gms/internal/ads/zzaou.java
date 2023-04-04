package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaou extends zzans {
    private final zzavu zzdpa;
    private final Adapter zzdpj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaou(Adapter adapter, zzavu zzavuVar) {
        this.zzdpj = adapter;
        this.zzdpa = zzavuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdImpression() {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAppEvent(String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onVideoEnd() {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onVideoPause() {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onVideoPlay() {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzafo zzafoVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzanz zzanzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzb(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzb(zzavy zzavyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzc(int i, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzc(zzvh zzvhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzde(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzdj(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzdk(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzf(zzvh zzvhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdLoaded() {
        zzavu zzavuVar = this.zzdpa;
        if (zzavuVar != null) {
            zzavuVar.zzah(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdOpened() {
        zzavu zzavuVar = this.zzdpa;
        if (zzavuVar != null) {
            zzavuVar.zzai(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdClosed() {
        zzavu zzavuVar = this.zzdpa;
        if (zzavuVar != null) {
            zzavuVar.zzak(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzawa zzawaVar) {
        zzavu zzavuVar = this.zzdpa;
        if (zzavuVar != null) {
            zzavuVar.zza(ObjectWrapper.wrap(this.zzdpj), new zzavy(zzawaVar.getType(), zzawaVar.getAmount()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzvp() {
        zzavu zzavuVar = this.zzdpa;
        if (zzavuVar != null) {
            zzavuVar.zzaj(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzvq() {
        zzavu zzavuVar = this.zzdpa;
        if (zzavuVar != null) {
            zzavuVar.zzan(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdClicked() {
        zzavu zzavuVar = this.zzdpa;
        if (zzavuVar != null) {
            zzavuVar.zzal(ObjectWrapper.wrap(this.zzdpj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdFailedToLoad(int i) {
        zzavu zzavuVar = this.zzdpa;
        if (zzavuVar != null) {
            zzavuVar.zze(ObjectWrapper.wrap(this.zzdpj), i);
        }
    }
}

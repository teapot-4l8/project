package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcuv extends zzans implements zzbug {
    private zzant zzdou;
    private zzbuf zzgxb;

    public final synchronized void zzb(zzant zzantVar) {
        this.zzdou = zzantVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbug
    public final synchronized void zza(zzbuf zzbufVar) {
        this.zzgxb = zzbufVar;
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onAdClicked() {
        if (this.zzdou != null) {
            this.zzdou.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onAdClosed() {
        if (this.zzdou != null) {
            this.zzdou.onAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzdou != null) {
            this.zzdou.onAdFailedToLoad(i);
        }
        if (this.zzgxb != null) {
            this.zzgxb.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzc(int i, String str) {
        if (this.zzdou != null) {
            this.zzdou.zzc(i, str);
        }
        if (this.zzgxb != null) {
            this.zzgxb.zzf(i, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzc(zzvh zzvhVar) {
        if (this.zzdou != null) {
            this.zzdou.zzc(zzvhVar);
        }
        if (this.zzgxb != null) {
            this.zzgxb.zzd(zzvhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onAdLeftApplication() {
        if (this.zzdou != null) {
            this.zzdou.onAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onAdOpened() {
        if (this.zzdou != null) {
            this.zzdou.onAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onAdLoaded() {
        if (this.zzdou != null) {
            this.zzdou.onAdLoaded();
        }
        if (this.zzgxb != null) {
            this.zzgxb.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zza(zzanz zzanzVar) {
        if (this.zzdou != null) {
            this.zzdou.zza(zzanzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onAdImpression() {
        if (this.zzdou != null) {
            this.zzdou.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzdou != null) {
            this.zzdou.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zza(zzafo zzafoVar, String str) {
        if (this.zzdou != null) {
            this.zzdou.zza(zzafoVar, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onVideoEnd() {
        if (this.zzdou != null) {
            this.zzdou.onVideoEnd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzdj(String str) {
        if (this.zzdou != null) {
            this.zzdou.zzdj(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzvp() {
        if (this.zzdou != null) {
            this.zzdou.zzvp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onVideoPlay() {
        if (this.zzdou != null) {
            this.zzdou.onVideoPlay();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzb(zzavy zzavyVar) {
        if (this.zzdou != null) {
            this.zzdou.zzb(zzavyVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void onVideoPause() {
        if (this.zzdou != null) {
            this.zzdou.onVideoPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzb(Bundle bundle) {
        if (this.zzdou != null) {
            this.zzdou.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzvq() {
        if (this.zzdou != null) {
            this.zzdou.zzvq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzde(int i) {
        if (this.zzdou != null) {
            this.zzdou.zzde(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzdk(String str) {
        if (this.zzdou != null) {
            this.zzdou.zzdk(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zzf(zzvh zzvhVar) {
        if (this.zzdou != null) {
            this.zzdou.zzf(zzvhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final synchronized void zza(zzawa zzawaVar) {
        if (this.zzdou != null) {
            this.zzdou.zza(zzawaVar);
        }
    }
}

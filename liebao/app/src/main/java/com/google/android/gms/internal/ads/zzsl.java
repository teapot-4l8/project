package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzsl extends zzst {
    private final AppOpenAd.AppOpenAdLoadCallback zzbve;
    private final String zzbvf;

    public zzsl(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zzbve = appOpenAdLoadCallback;
        this.zzbvf = str;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void zza(zzsp zzspVar) {
        if (this.zzbve != null) {
            zzsn zzsnVar = new zzsn(zzspVar, this.zzbvf);
            this.zzbve.onAppOpenAdLoaded(zzsnVar);
            this.zzbve.onAdLoaded(zzsnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void onAppOpenAdFailedToLoad(int i) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbve;
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void zza(zzvh zzvhVar) {
        if (this.zzbve != null) {
            LoadAdError zzqi = zzvhVar.zzqi();
            this.zzbve.onAppOpenAdFailedToLoad(zzqi);
            this.zzbve.onAdFailedToLoad(zzqi);
        }
    }
}

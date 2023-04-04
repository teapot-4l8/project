package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaxd extends zzawm {
    private final RewardedInterstitialAdLoadCallback zzebe;
    private final zzaxc zzebf;

    public zzaxd(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzaxc zzaxcVar) {
        this.zzebe = rewardedInterstitialAdLoadCallback;
        this.zzebf = zzaxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawn
    public final void onRewardedAdLoaded() {
        zzaxc zzaxcVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzebe;
        if (rewardedInterstitialAdLoadCallback == null || (zzaxcVar = this.zzebf) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdLoaded(zzaxcVar);
        this.zzebe.onAdLoaded(this.zzebf);
    }

    @Override // com.google.android.gms.internal.ads.zzawn
    public final void onRewardedAdFailedToLoad(int i) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzebe;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawn
    public final void zzj(zzvh zzvhVar) {
        if (this.zzebe != null) {
            LoadAdError zzqi = zzvhVar.zzqi();
            this.zzebe.onRewardedInterstitialAdFailedToLoad(zzqi);
            this.zzebe.onAdFailedToLoad(zzqi);
        }
    }
}

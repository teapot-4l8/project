package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzawx extends zzawm {
    private final RewardedAdLoadCallback zzeba;
    private final RewardedAd zzebb;

    public zzawx(RewardedAdLoadCallback rewardedAdLoadCallback, RewardedAd rewardedAd) {
        this.zzeba = rewardedAdLoadCallback;
        this.zzebb = rewardedAd;
    }

    @Override // com.google.android.gms.internal.ads.zzawn
    public final void onRewardedAdLoaded() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzeba;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
            this.zzeba.onAdLoaded(this.zzebb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawn
    public final void onRewardedAdFailedToLoad(int i) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzeba;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawn
    public final void zzj(zzvh zzvhVar) {
        if (this.zzeba != null) {
            LoadAdError zzqi = zzvhVar.zzqi();
            this.zzeba.onRewardedAdFailedToLoad(zzqi);
            this.zzeba.onAdFailedToLoad(zzqi);
        }
    }
}

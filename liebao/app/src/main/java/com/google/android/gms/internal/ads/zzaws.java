package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaws extends zzawj {
    private FullScreenContentCallback zzbvj;
    private RewardedAdCallback zzeay;

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
    }

    public final void zza(RewardedAdCallback rewardedAdCallback) {
        this.zzeay = rewardedAdCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void zza(zzawa zzawaVar) {
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzawt(zzawaVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void zzi(zzvh zzvhVar) {
        AdError zzqh = zzvhVar.zzqh();
        RewardedAdCallback rewardedAdCallback = this.zzeay;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(zzqh);
        }
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzqh);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onAdImpression() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdImpression();
        }
    }
}

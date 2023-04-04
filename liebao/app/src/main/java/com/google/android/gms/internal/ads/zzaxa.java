package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaxa extends zzawj {
    private FullScreenContentCallback zzbvj;
    private OnUserEarnedRewardListener zzebc;

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onRewardedAdFailedToShow(int i) {
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
    }

    public final void zza(OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzebc = onUserEarnedRewardListener;
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onRewardedAdOpened() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onRewardedAdClosed() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void zzi(zzvh zzvhVar) {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvj;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzvhVar.zzqh());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void zza(zzawa zzawaVar) {
        OnUserEarnedRewardListener onUserEarnedRewardListener = this.zzebc;
        if (onUserEarnedRewardListener != null) {
            onUserEarnedRewardListener.onUserEarnedReward(new zzawt(zzawaVar));
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

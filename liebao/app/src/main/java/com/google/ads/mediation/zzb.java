package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzb extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter zzmn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzmn = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        InterstitialAd interstitialAd;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        InterstitialAd interstitialAd2;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener2;
        interstitialAd = this.zzmn.zzms;
        if (interstitialAd != null) {
            mediationRewardedVideoAdListener = this.zzmn.zzmt;
            if (mediationRewardedVideoAdListener != null) {
                interstitialAd2 = this.zzmn.zzms;
                Bundle adMetadata = interstitialAd2.getAdMetadata();
                mediationRewardedVideoAdListener2 = this.zzmn.zzmt;
                mediationRewardedVideoAdListener2.zzb(adMetadata);
            }
        }
    }
}

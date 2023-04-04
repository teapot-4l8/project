package com.google.ads.mediation;

import com.google.ads.AdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public interface MediationInterstitialListener {
    void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter);

    void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode);

    void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter);

    void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter);

    void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter);
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzaqs implements com.google.android.gms.ads.internal.overlay.zzp {
    private final /* synthetic */ zzaqt zzdqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqs(zzaqt zzaqtVar) {
        this.zzdqi = zzaqtVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onUserLeaveHint() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        MediationInterstitialListener mediationInterstitialListener;
        zzbao.zzdz("AdMobCustomTabsAdapter overlay is closed.");
        mediationInterstitialListener = this.zzdqi.zzdqk;
        mediationInterstitialListener.onAdClosed(this.zzdqi);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
        zzbao.zzdz("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
        zzbao.zzdz("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzvz() {
        MediationInterstitialListener mediationInterstitialListener;
        zzbao.zzdz("Opening AdMobCustomTabsAdapter overlay.");
        mediationInterstitialListener = this.zzdqi.zzdqk;
        mediationInterstitialListener.onAdOpened(this.zzdqi);
    }
}

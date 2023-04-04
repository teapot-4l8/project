package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzvj extends zzxb {
    private final AdListener zzchw;

    public zzvj(AdListener adListener) {
        this.zzchw = adListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdClosed() {
        this.zzchw.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdFailedToLoad(int i) {
        this.zzchw.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzc(zzvh zzvhVar) {
        this.zzchw.onAdFailedToLoad(zzvhVar.zzqi());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdLeftApplication() {
        this.zzchw.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdLoaded() {
        this.zzchw.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdOpened() {
        this.zzchw.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdClicked() {
        this.zzchw.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdImpression() {
        this.zzchw.onAdImpression();
    }

    public final AdListener getAdListener() {
        return this.zzchw;
    }
}

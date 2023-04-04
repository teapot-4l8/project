package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwy extends zzyf {
    private final FullScreenContentCallback zzbvg;

    public zzwy(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvg = fullScreenContentCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzb(zzvh zzvhVar) {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvg;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzvhVar.zzqh());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void onAdShowedFullScreenContent() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvg;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void onAdDismissedFullScreenContent() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvg;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void onAdImpression() {
        FullScreenContentCallback fullScreenContentCallback = this.zzbvg;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdImpression();
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzahl extends zzagq {
    private final UnifiedNativeAd.UnconfirmedClickListener zzdid;

    public zzahl(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzdid = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void onUnconfirmedClickReceived(String str) {
        this.zzdid.onUnconfirmedClickReceived(str);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void onUnconfirmedClickCancelled() {
        this.zzdid.onUnconfirmedClickCancelled();
    }
}

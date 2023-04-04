package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzarv extends zzagq {
    private final NativeAd.UnconfirmedClickListener zzdsg;

    public zzarv(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzdsg = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void onUnconfirmedClickReceived(String str) {
        this.zzdsg.onUnconfirmedClickReceived(str);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void onUnconfirmedClickCancelled() {
        this.zzdsg.onUnconfirmedClickCancelled();
    }
}

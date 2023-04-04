package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzvn extends zzxw {
    private final AdMetadataListener zzchz;

    public zzvn(AdMetadataListener adMetadataListener) {
        this.zzchz = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxt
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzchz;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}

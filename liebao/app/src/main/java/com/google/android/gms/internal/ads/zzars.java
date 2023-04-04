package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzars extends zzagk {
    private final NativeAd.OnNativeAdLoadedListener zzdsd;

    public zzars(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zzdsd = onNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagl
    public final void zza(zzags zzagsVar) {
        this.zzdsd.onNativeAdLoaded(new zzarm(zzagsVar));
    }
}

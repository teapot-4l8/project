package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzsk extends zzsu {
    private final AppOpenAdPresentationCallback zzbvd;

    public zzsk(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzbvd = appOpenAdPresentationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void onAppOpenAdClosed() {
        this.zzbvd.onAppOpenAdClosed();
    }
}

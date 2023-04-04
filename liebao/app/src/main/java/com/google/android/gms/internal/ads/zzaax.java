package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaax extends zzagp {
    private final ShouldDelayBannerRenderingListener zzcme;

    public zzaax(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zzcme = shouldDelayBannerRenderingListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagm
    public final boolean zzm(IObjectWrapper iObjectWrapper) {
        return this.zzcme.shouldDelayBannerRendering((Runnable) ObjectWrapper.unwrap(iObjectWrapper));
    }
}

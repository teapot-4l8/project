package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaos extends zzanx {
    private final MediationInterscrollerAd zzdpi;

    public zzaos(MediationInterscrollerAd mediationInterscrollerAd) {
        this.zzdpi = mediationInterscrollerAd;
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final IObjectWrapper zzve() {
        return ObjectWrapper.wrap(this.zzdpi.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final boolean shouldDelegateInterscrollerEffect() {
        return this.zzdpi.shouldDelegateInterscrollerEffect();
    }
}

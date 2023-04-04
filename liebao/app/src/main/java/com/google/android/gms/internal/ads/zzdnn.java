package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzdnn implements zzdma {
    static final zzdma zzhbd = new zzdnn();

    private zzdnn() {
    }

    @Override // com.google.android.gms.internal.ads.zzdma
    public final void zzp(Object obj) {
        ((AdMetadataListener) obj).onAdMetadataChanged();
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzbul implements zzbxs {
    static final zzbxs zzgbn = new zzbul();

    private zzbul() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxs
    public final void zzo(Object obj) {
        ((AdMetadataListener) obj).onAdMetadataChanged();
    }
}

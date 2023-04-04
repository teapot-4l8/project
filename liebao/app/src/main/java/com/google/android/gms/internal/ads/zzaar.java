package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaar extends zzyv {
    private final OnAdMetadataChangedListener zzcmd;

    public zzaar(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzcmd = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public final void onAdMetadataChanged() {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.zzcmd;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}

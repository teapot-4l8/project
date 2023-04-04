package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzvm<AdT> extends zzxg {
    private final AdLoadCallback<AdT> zzchx;
    private final AdT zzchy;

    public zzvm(AdLoadCallback<AdT> adLoadCallback, AdT adt) {
        this.zzchx = adLoadCallback;
        this.zzchy = adt;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void onAdLoaded() {
        AdT adt;
        AdLoadCallback<AdT> adLoadCallback = this.zzchx;
        if (adLoadCallback == null || (adt = this.zzchy) == null) {
            return;
        }
        adLoadCallback.onAdLoaded(adt);
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zzd(zzvh zzvhVar) {
        AdLoadCallback<AdT> adLoadCallback = this.zzchx;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zzvhVar.zzqi());
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzsy extends zzgw implements zzsw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void onAdShowedFullScreenContent() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void onAdDismissedFullScreenContent() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzb(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void onAdImpression() {
        zzb(4, zzdp());
    }
}

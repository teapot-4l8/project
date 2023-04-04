package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzyi extends zzgw implements zzyg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzb(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void onAdShowedFullScreenContent() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void onAdDismissedFullScreenContent() {
        zzb(3, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void onAdImpression() {
        zzb(4, zzdp());
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzxf extends zzgw implements zzxd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void onAdLoaded() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zzd(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(2, zzdp);
    }
}

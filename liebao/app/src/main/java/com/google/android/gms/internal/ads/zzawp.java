package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzawp extends zzgw implements zzawn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzawn
    public final void onRewardedAdLoaded() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzawn
    public final void onRewardedAdFailedToLoad(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawn
    public final void zzj(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(3, zzdp);
    }
}

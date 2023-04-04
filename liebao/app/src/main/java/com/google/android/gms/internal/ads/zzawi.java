package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzawi extends zzgw implements zzawg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onRewardedAdOpened() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onRewardedAdClosed() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void zza(zzawa zzawaVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzawaVar);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onRewardedAdFailedToShow(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(4, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void zzi(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawg
    public final void onAdImpression() {
        zzb(6, zzdp());
    }
}

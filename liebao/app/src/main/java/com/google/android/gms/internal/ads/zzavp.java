package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavp extends zzgw implements zzavn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzavn
    public final void onRewardedVideoAdLoaded() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzavn
    public final void onRewardedVideoAdOpened() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzavn
    public final void onRewardedVideoStarted() {
        zzb(3, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzavn
    public final void onRewardedVideoAdClosed() {
        zzb(4, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzavn
    public final void zza(zzavd zzavdVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzavdVar);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavn
    public final void onRewardedVideoAdLeftApplication() {
        zzb(6, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzavn
    public final void onRewardedVideoAdFailedToLoad(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavn
    public final void onRewardedVideoCompleted() {
        zzb(8, zzdp());
    }
}

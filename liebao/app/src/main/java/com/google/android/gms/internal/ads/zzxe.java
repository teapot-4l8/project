package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzxe extends zzgw implements zzxc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdClosed() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdFailedToLoad(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdLeftApplication() {
        zzb(3, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdLoaded() {
        zzb(4, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdOpened() {
        zzb(5, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdClicked() {
        zzb(6, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdImpression() {
        zzb(7, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzc(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(8, zzdp);
    }
}

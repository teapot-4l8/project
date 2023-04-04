package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzss extends zzgw implements zzsq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzss(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void zza(zzsp zzspVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzspVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void onAppOpenAdFailedToLoad(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void zza(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(3, zzdp);
    }
}

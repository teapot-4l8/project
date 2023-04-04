package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaki extends zzgw implements zzakg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaki(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zza(zzaka zzakaVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzakaVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void onInstreamAdFailedToLoad(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zze(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(3, zzdp);
    }
}

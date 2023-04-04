package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzapv extends zzgw implements zzapt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzvy() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzdm(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzg(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(4, zzdp);
    }
}

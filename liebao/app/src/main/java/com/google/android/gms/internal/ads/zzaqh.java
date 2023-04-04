package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaqh extends zzgw implements zzaqf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaqf
    public final void zzdo(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqf
    public final void onFailure(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqf
    public final void zzh(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(3, zzdp);
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzapw extends zzgw implements zzapu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    public final void zza(zzaoh zzaohVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaohVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    public final void zzdm(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    public final void zzg(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(3, zzdp);
    }
}

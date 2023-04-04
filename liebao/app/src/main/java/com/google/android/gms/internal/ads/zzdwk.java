package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdwk extends zzgw implements zzdwl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdwk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    public final zzdwj zza(zzdwh zzdwhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzdwhVar);
        Parcel zza = zza(1, zzdp);
        zzdwj zzdwjVar = (zzdwj) zzgx.zza(zza, zzdwj.CREATOR);
        zza.recycle();
        return zzdwjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    public final void zza(zzdwc zzdwcVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzdwcVar);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    public final zzdwt zza(zzdwr zzdwrVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzdwrVar);
        Parcel zza = zza(3, zzdp);
        zzdwt zzdwtVar = (zzdwt) zzgx.zza(zza, zzdwt.CREATOR);
        zza.recycle();
        return zzdwtVar;
    }
}

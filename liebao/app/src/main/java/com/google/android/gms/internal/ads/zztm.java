package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zztm extends zzgw implements zztn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zztm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final zzth zza(zzti zztiVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zztiVar);
        Parcel zza = zza(1, zzdp);
        zzth zzthVar = (zzth) zzgx.zza(zza, zzth.CREATOR);
        zza.recycle();
        return zzthVar;
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final zzth zzc(zzti zztiVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zztiVar);
        Parcel zza = zza(2, zzdp);
        zzth zzthVar = (zzth) zzgx.zza(zza, zzth.CREATOR);
        zza.recycle();
        return zzthVar;
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final long zzb(zzti zztiVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zztiVar);
        Parcel zza = zza(3, zzdp);
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }
}

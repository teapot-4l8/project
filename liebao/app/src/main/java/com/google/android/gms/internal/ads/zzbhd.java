package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbhd extends zzgw implements zzbhc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zza(IObjectWrapper iObjectWrapper, zzbha zzbhaVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzbhaVar);
        zzb(2, zzdp);
    }
}

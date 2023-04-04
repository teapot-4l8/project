package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzxu extends zzgw implements zzxr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final IBinder zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, String str, zzann zzannVar, int i, int i2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvtVar);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(204890000);
        zzdp.writeInt(i2);
        Parcel zza = zza(2, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}

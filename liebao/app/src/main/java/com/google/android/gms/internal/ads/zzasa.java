package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzasa extends zzgw implements zzarz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final zzaru zzc(IObjectWrapper iObjectWrapper, zzann zzannVar, int i) {
        zzaru zzarwVar;
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(204890000);
        Parcel zza = zza(1, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzarwVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
            if (queryLocalInterface instanceof zzaru) {
                zzarwVar = (zzaru) queryLocalInterface;
            } else {
                zzarwVar = new zzarw(readStrongBinder);
            }
        }
        zza.recycle();
        return zzarwVar;
    }
}

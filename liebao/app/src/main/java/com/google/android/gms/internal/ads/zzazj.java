package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzazj extends zzgw implements zzazh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzazh
    public final zzazc zze(IObjectWrapper iObjectWrapper, zzann zzannVar, int i) {
        zzazc zzazeVar;
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(204890000);
        Parcel zza = zza(2, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzazeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            if (queryLocalInterface instanceof zzazc) {
                zzazeVar = (zzazc) queryLocalInterface;
            } else {
                zzazeVar = new zzaze(readStrongBinder);
            }
        }
        zza.recycle();
        return zzazeVar;
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzanp extends zzgw implements zzann {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzano zzdd(String str) {
        zzano zzanqVar;
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        Parcel zza = zza(1, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzanqVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (queryLocalInterface instanceof zzano) {
                zzanqVar = (zzano) queryLocalInterface;
            } else {
                zzanqVar = new zzanq(readStrongBinder);
            }
        }
        zza.recycle();
        return zzanqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final boolean zzde(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        Parcel zza = zza(2, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaqa zzdi(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        Parcel zza = zza(3, zzdp);
        zzaqa zzag = zzaqd.zzag(zza.readStrongBinder());
        zza.recycle();
        return zzag;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final boolean zzdf(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        Parcel zza = zza(4, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }
}

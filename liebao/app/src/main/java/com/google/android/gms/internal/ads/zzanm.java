package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzanm extends zzgy implements zzann {
    public zzanm() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzann zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzann) {
            return (zzann) queryLocalInterface;
        }
        return new zzanp(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzano zzdd = zzdd(parcel.readString());
            parcel2.writeNoException();
            zzgx.zza(parcel2, zzdd);
        } else if (i == 2) {
            boolean zzde = zzde(parcel.readString());
            parcel2.writeNoException();
            zzgx.writeBoolean(parcel2, zzde);
        } else if (i == 3) {
            zzaqa zzdi = zzdi(parcel.readString());
            parcel2.writeNoException();
            zzgx.zza(parcel2, zzdi);
        } else if (i != 4) {
            return false;
        } else {
            boolean zzdf = zzdf(parcel.readString());
            parcel2.writeNoException();
            zzgx.writeBoolean(parcel2, zzdf);
        }
        return true;
    }
}

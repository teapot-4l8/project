package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzso extends zzgy implements zzsp {
    public zzso() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzsv zzsvVar = null;
        zzsw zzswVar = null;
        switch (i) {
            case 2:
                zzxq zzea = zzea();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzea);
                return true;
            case 3:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                    if (queryLocalInterface instanceof zzsv) {
                        zzsvVar = (zzsv) queryLocalInterface;
                    } else {
                        zzsvVar = new zzsx(readStrongBinder);
                    }
                }
                zza(zzsvVar);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                    if (queryLocalInterface2 instanceof zzsw) {
                        zzswVar = (zzsw) queryLocalInterface2;
                    } else {
                        zzswVar = new zzsy(readStrongBinder2);
                    }
                }
                zza(asInterface, zzswVar);
                parcel2.writeNoException();
                return true;
            case 5:
                zzzc zzkm = zzkm();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzkm);
                return true;
            case 6:
                setImmersiveMode(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 7:
                zza(zzza.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}

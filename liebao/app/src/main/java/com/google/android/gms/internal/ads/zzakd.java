package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzakd extends zzgy implements zzaka {
    public zzakd() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzakf zzakhVar;
        if (i == 3) {
            zzzd videoController = getVideoController();
            parcel2.writeNoException();
            zzgx.zza(parcel2, videoController);
            return true;
        } else if (i == 4) {
            destroy();
            parcel2.writeNoException();
            return true;
        } else if (i != 5) {
            if (i == 6) {
                zzr(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i != 7) {
                return false;
            } else {
                zzaer zzue = zzue();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzue);
                return true;
            }
        } else {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzakhVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                if (queryLocalInterface instanceof zzakf) {
                    zzakhVar = (zzakf) queryLocalInterface;
                } else {
                    zzakhVar = new zzakh(readStrongBinder);
                }
            }
            zza(asInterface, zzakhVar);
            parcel2.writeNoException();
            return true;
        }
    }
}

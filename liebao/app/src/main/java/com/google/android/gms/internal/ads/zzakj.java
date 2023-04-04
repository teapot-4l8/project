package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzakj extends zzgy implements zzakg {
    public zzakj() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    public static zzakg zzab(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
        if (queryLocalInterface instanceof zzakg) {
            return (zzakg) queryLocalInterface;
        }
        return new zzaki(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzaka zzakcVar;
        if (i == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzakcVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
                if (queryLocalInterface instanceof zzaka) {
                    zzakcVar = (zzaka) queryLocalInterface;
                } else {
                    zzakcVar = new zzakc(readStrongBinder);
                }
            }
            zza(zzakcVar);
        } else if (i == 2) {
            onInstreamAdFailedToLoad(parcel.readInt());
        } else if (i != 3) {
            return false;
        } else {
            zze((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}

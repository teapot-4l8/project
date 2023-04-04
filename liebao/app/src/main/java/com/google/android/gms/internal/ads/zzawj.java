package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzawj extends zzgy implements zzawg {
    public zzawj() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzawa zzawcVar;
        switch (i) {
            case 1:
                onRewardedAdOpened();
                break;
            case 2:
                onRewardedAdClosed();
                break;
            case 3:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzawcVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                    if (queryLocalInterface instanceof zzawa) {
                        zzawcVar = (zzawa) queryLocalInterface;
                    } else {
                        zzawcVar = new zzawc(readStrongBinder);
                    }
                }
                zza(zzawcVar);
                break;
            case 4:
                onRewardedAdFailedToShow(parcel.readInt());
                break;
            case 5:
                zzi((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
                break;
            case 6:
                onAdImpression();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}

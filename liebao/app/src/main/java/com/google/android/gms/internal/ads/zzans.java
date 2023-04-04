package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzans extends zzgy implements zzant {
    public zzans() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzant zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if (queryLocalInterface instanceof zzant) {
            return (zzant) queryLocalInterface;
        }
        return new zzanv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzanz zzanyVar;
        switch (i) {
            case 1:
                onAdClicked();
                break;
            case 2:
                onAdClosed();
                break;
            case 3:
                onAdFailedToLoad(parcel.readInt());
                break;
            case 4:
                onAdLeftApplication();
                break;
            case 5:
                onAdOpened();
                break;
            case 6:
                onAdLoaded();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzanyVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (queryLocalInterface instanceof zzanz) {
                        zzanyVar = (zzanz) queryLocalInterface;
                    } else {
                        zzanyVar = new zzany(readStrongBinder);
                    }
                }
                zza(zzanyVar);
                break;
            case 8:
                onAdImpression();
                break;
            case 9:
                onAppEvent(parcel.readString(), parcel.readString());
                break;
            case 10:
                zza(zzafr.zzr(parcel.readStrongBinder()), parcel.readString());
                break;
            case 11:
                onVideoEnd();
                break;
            case 12:
                zzdj(parcel.readString());
                break;
            case 13:
                zzvp();
                break;
            case 14:
                zzb((zzavy) zzgx.zza(parcel, zzavy.CREATOR));
                break;
            case 15:
                onVideoPause();
                break;
            case 16:
                zza(zzawd.zzar(parcel.readStrongBinder()));
                break;
            case 17:
                zzde(parcel.readInt());
                break;
            case 18:
                zzvq();
                break;
            case 19:
                zzb((Bundle) zzgx.zza(parcel, Bundle.CREATOR));
                break;
            case 20:
                onVideoPlay();
                break;
            case 21:
                zzdk(parcel.readString());
                break;
            case 22:
                zzc(parcel.readInt(), parcel.readString());
                break;
            case 23:
                zzc((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
                break;
            case 24:
                zzf((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}

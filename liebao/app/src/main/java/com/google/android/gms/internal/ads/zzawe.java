package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzawe extends zzgy implements zzawf {
    public zzawe() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzawf zzas(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (queryLocalInterface instanceof zzawf) {
            return (zzawf) queryLocalInterface;
        }
        return new zzawh(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzawn zzawnVar = null;
        zzawn zzawnVar2 = null;
        zzawo zzawoVar = null;
        zzawg zzawgVar = null;
        switch (i) {
            case 1:
                zzvq zzvqVar = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface instanceof zzawn) {
                        zzawnVar = (zzawn) queryLocalInterface;
                    } else {
                        zzawnVar = new zzawp(readStrongBinder);
                    }
                }
                zza(zzvqVar, zzawnVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    if (queryLocalInterface2 instanceof zzawg) {
                        zzawgVar = (zzawg) queryLocalInterface2;
                    } else {
                        zzawgVar = new zzawi(readStrongBinder2);
                    }
                }
                zza(zzawgVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isLoaded = isLoaded();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, isLoaded);
                return true;
            case 4:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 5:
                zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    if (queryLocalInterface3 instanceof zzawo) {
                        zzawoVar = (zzawo) queryLocalInterface3;
                    } else {
                        zzawoVar = new zzawr(readStrongBinder3);
                    }
                }
                zza(zzawoVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zza((zzaww) zzgx.zza(parcel, zzaww.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzyv.zzh(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, adMetadata);
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 11:
                zzawa zzsb = zzsb();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzsb);
                return true;
            case 12:
                zzzc zzkm = zzkm();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzkm);
                return true;
            case 13:
                zza(zzza.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                zzvq zzvqVar2 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface4 instanceof zzawn) {
                        zzawnVar2 = (zzawn) queryLocalInterface4;
                    } else {
                        zzawnVar2 = new zzawp(readStrongBinder4);
                    }
                }
                zzb(zzvqVar2, zzawnVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                setImmersiveMode(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}

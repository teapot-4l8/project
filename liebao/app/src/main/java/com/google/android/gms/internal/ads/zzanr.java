package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzanr extends zzgy implements zzano {
    public zzanr() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzant zzantVar = null;
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvt zzvtVar = (zzvt) zzgx.zza(parcel, zzvt.CREATOR);
                zzvq zzvqVar = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface instanceof zzant) {
                        zzantVar = (zzant) queryLocalInterface;
                    } else {
                        zzantVar = new zzanv(readStrongBinder);
                    }
                }
                zza(asInterface, zzvtVar, zzvqVar, readString, zzantVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper zzve = zzve();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzve);
                return true;
            case 3:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvq zzvqVar2 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface2 instanceof zzant) {
                        zzantVar = (zzant) queryLocalInterface2;
                    } else {
                        zzantVar = new zzanv(readStrongBinder2);
                    }
                }
                zza(asInterface2, zzvqVar2, readString2, zzantVar);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvt zzvtVar2 = (zzvt) zzgx.zza(parcel, zzvt.CREATOR);
                zzvq zzvqVar3 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface3 instanceof zzant) {
                        zzantVar = (zzant) queryLocalInterface3;
                    } else {
                        zzantVar = new zzanv(readStrongBinder3);
                    }
                }
                zza(asInterface3, zzvtVar2, zzvqVar3, readString3, readString4, zzantVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvq zzvqVar4 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface4 instanceof zzant) {
                        zzantVar = (zzant) queryLocalInterface4;
                    } else {
                        zzantVar = new zzanv(readStrongBinder4);
                    }
                }
                zza(asInterface4, zzvqVar4, readString5, readString6, zzantVar);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvq) zzgx.zza(parcel, zzvq.CREATOR), parcel.readString(), zzavx.zzaq(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza((zzvq) zzgx.zza(parcel, zzvq.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, isInitialized);
                return true;
            case 14:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvq zzvqVar5 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface5 instanceof zzant) {
                        zzantVar = (zzant) queryLocalInterface5;
                    } else {
                        zzantVar = new zzanv(readStrongBinder5);
                    }
                }
                zza(asInterface5, zzvqVar5, readString7, readString8, zzantVar, (zzaei) zzgx.zza(parcel, zzaei.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzaob zzvf = zzvf();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzvf);
                return true;
            case 16:
                zzaoc zzvg = zzvg();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzvg);
                return true;
            case 17:
                Bundle zzvh = zzvh();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzvh);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle zzvi = zzvi();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzvi);
                return true;
            case 20:
                zza((zzvq) zzgx.zza(parcel, zzvq.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                zzs(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zzvj = zzvj();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, zzvj);
                return true;
            case 23:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzavx.zzaq(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzafo zzvk = zzvk();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzvk);
                return true;
            case 25:
                setImmersiveMode(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzzd videoController = getVideoController();
                parcel2.writeNoException();
                zzgx.zza(parcel2, videoController);
                return true;
            case 27:
                zzaoh zzvl = zzvl();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzvl);
                return true;
            case 28:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvq zzvqVar6 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                String readString9 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface6 instanceof zzant) {
                        zzantVar = (zzant) queryLocalInterface6;
                    } else {
                        zzantVar = new zzanv(readStrongBinder6);
                    }
                }
                zzb(asInterface6, zzvqVar6, readString9, zzantVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                zzt(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzajr.zzz(parcel.readStrongBinder()), parcel.createTypedArrayList(zzajw.CREATOR));
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvq zzvqVar7 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                String readString10 = parcel.readString();
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface7 instanceof zzant) {
                        zzantVar = (zzant) queryLocalInterface7;
                    } else {
                        zzantVar = new zzanv(readStrongBinder7);
                    }
                }
                zzc(asInterface7, zzvqVar7, readString10, zzantVar);
                parcel2.writeNoException();
                return true;
            case 33:
                zzaqr zzvm = zzvm();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzvm);
                return true;
            case 34:
                zzaqr zzvn = zzvn();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzvn);
                return true;
            case 35:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvt zzvtVar3 = (zzvt) zzgx.zza(parcel, zzvt.CREATOR);
                zzvq zzvqVar8 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface8 instanceof zzant) {
                        zzantVar = (zzant) queryLocalInterface8;
                    } else {
                        zzantVar = new zzanv(readStrongBinder8);
                    }
                }
                zzb(asInterface8, zzvtVar3, zzvqVar8, readString11, readString12, zzantVar);
                parcel2.writeNoException();
                return true;
            case 36:
                zzanu zzvo = zzvo();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzvo);
                return true;
            case 37:
                zzu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}

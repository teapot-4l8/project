package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzxp extends zzgy implements zzxq {
    public zzxp() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzxq zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzxq) {
            return (zzxq) queryLocalInterface;
        }
        return new zzxs(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzxc zzxcVar = null;
        zzyg zzygVar = null;
        zzxd zzxdVar = null;
        zzyx zzyxVar = null;
        zzxt zzxtVar = null;
        zzye zzyeVar = null;
        zzwx zzwxVar = null;
        zzxy zzxyVar = null;
        switch (i) {
            case 1:
                IObjectWrapper zzki = zzki();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzki);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isReady = isReady();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, isReady);
                return true;
            case 4:
                boolean zza = zza((zzvq) zzgx.zza(parcel, zzvq.CREATOR));
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, zza);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzxc) {
                        zzxcVar = (zzxc) queryLocalInterface;
                    } else {
                        zzxcVar = new zzxe(readStrongBinder);
                    }
                }
                zza(zzxcVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (queryLocalInterface2 instanceof zzxy) {
                        zzxyVar = (zzxy) queryLocalInterface2;
                    } else {
                        zzxyVar = new zzya(readStrongBinder2);
                    }
                }
                zza(zzxyVar);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                return true;
            case 11:
                zzkj();
                parcel2.writeNoException();
                return true;
            case 12:
                zzvt zzkk = zzkk();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzkk);
                return true;
            case 13:
                zza((zzvt) zzgx.zza(parcel, zzvt.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzasq.zzak(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zza(zzasw.zzam(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                zza(zzacp.zzl(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (queryLocalInterface3 instanceof zzwx) {
                        zzwxVar = (zzwx) queryLocalInterface3;
                    } else {
                        zzwxVar = new zzwz(readStrongBinder3);
                    }
                }
                zza(zzwxVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface4 instanceof zzye) {
                        zzyeVar = (zzye) queryLocalInterface4;
                    } else {
                        zzyeVar = new zzyd(readStrongBinder4);
                    }
                }
                zza(zzyeVar);
                parcel2.writeNoException();
                return true;
            case 22:
                setManualImpressionsEnabled(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, isLoading);
                return true;
            case 24:
                zza(zzavm.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzzd videoController = getVideoController();
                parcel2.writeNoException();
                zzgx.zza(parcel2, videoController);
                return true;
            case 29:
                zza((zzaaz) zzgx.zza(parcel, zzaaz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                zza((zzzj) zzgx.zza(parcel, zzzj.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String adUnitId = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(adUnitId);
                return true;
            case 32:
                zzxy zzkn = zzkn();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzkn);
                return true;
            case 33:
                zzxc zzko = zzko();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzko);
                return true;
            case 34:
                setImmersiveMode(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String zzkl = zzkl();
                parcel2.writeNoException();
                parcel2.writeString(zzkl);
                return true;
            case 36:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (queryLocalInterface5 instanceof zzxt) {
                        zzxtVar = (zzxt) queryLocalInterface5;
                    } else {
                        zzxtVar = new zzxv(readStrongBinder5);
                    }
                }
                zza(zzxtVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, adMetadata);
                return true;
            case 38:
                zzbl(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 39:
                zza((zzwc) zzgx.zza(parcel, zzwc.CREATOR));
                parcel2.writeNoException();
                return true;
            case 40:
                zza(zzst.zzb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 41:
                zzzc zzkm = zzkm();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzkm);
                return true;
            case 42:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    if (queryLocalInterface6 instanceof zzyx) {
                        zzyxVar = (zzyx) queryLocalInterface6;
                    } else {
                        zzyxVar = new zzyz(readStrongBinder6);
                    }
                }
                zza(zzyxVar);
                parcel2.writeNoException();
                return true;
            case 43:
                zzvq zzvqVar = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback");
                    if (queryLocalInterface7 instanceof zzxd) {
                        zzxdVar = (zzxd) queryLocalInterface7;
                    } else {
                        zzxdVar = new zzxf(readStrongBinder7);
                    }
                }
                zza(zzvqVar, zzxdVar);
                parcel2.writeNoException();
                return true;
            case 44:
                zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 45:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                    if (queryLocalInterface8 instanceof zzyg) {
                        zzygVar = (zzyg) queryLocalInterface8;
                    } else {
                        zzygVar = new zzyi(readStrongBinder8);
                    }
                }
                zza(zzygVar);
                parcel2.writeNoException();
                return true;
        }
    }
}

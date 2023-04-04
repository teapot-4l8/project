package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzaqd extends zzgy implements zzaqa {
    public zzaqd() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzaqa zzag(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzaqa) {
            return (zzaqa) queryLocalInterface;
        }
        return new zzaqc(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzaqf zzaqhVar;
        zzaqf zzaqfVar;
        zzapo zzapoVar = null;
        zzapu zzapwVar = null;
        zzapo zzapqVar = null;
        zzapz zzaqbVar = null;
        zzapu zzapwVar2 = null;
        zzapz zzaqbVar2 = null;
        zzapt zzapvVar = null;
        if (i == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String readString = parcel.readString();
            Bundle bundle = (Bundle) zzgx.zza(parcel, Bundle.CREATOR);
            Bundle bundle2 = (Bundle) zzgx.zza(parcel, Bundle.CREATOR);
            zzvt zzvtVar = (zzvt) zzgx.zza(parcel, zzvt.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaqfVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                if (queryLocalInterface instanceof zzaqf) {
                    zzaqhVar = (zzaqf) queryLocalInterface;
                } else {
                    zzaqhVar = new zzaqh(readStrongBinder);
                }
                zzaqfVar = zzaqhVar;
            }
            zza(asInterface, readString, bundle, bundle2, zzvtVar, zzaqfVar);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzaqr zzvm = zzvm();
            parcel2.writeNoException();
            zzgx.zzb(parcel2, zzvm);
        } else if (i == 3) {
            zzaqr zzvn = zzvn();
            parcel2.writeNoException();
            zzgx.zzb(parcel2, zzvn);
        } else if (i == 5) {
            zzzd videoController = getVideoController();
            parcel2.writeNoException();
            zzgx.zza(parcel2, videoController);
        } else if (i == 10) {
            zzz(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i == 11) {
            zza(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
            parcel2.writeNoException();
        } else {
            switch (i) {
                case 13:
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    zzvq zzvqVar = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                    IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        if (queryLocalInterface2 instanceof zzapo) {
                            zzapoVar = (zzapo) queryLocalInterface2;
                        } else {
                            zzapoVar = new zzapq(readStrongBinder2);
                        }
                    }
                    zza(readString2, readString3, zzvqVar, asInterface2, zzapoVar, zzans.zzad(parcel.readStrongBinder()), (zzvt) zzgx.zza(parcel, zzvt.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 14:
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    zzvq zzvqVar2 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                    IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        if (queryLocalInterface3 instanceof zzapt) {
                            zzapvVar = (zzapt) queryLocalInterface3;
                        } else {
                            zzapvVar = new zzapv(readStrongBinder3);
                        }
                    }
                    zza(readString4, readString5, zzvqVar2, asInterface3, zzapvVar, zzans.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 15:
                    boolean zzaa = zzaa(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzgx.writeBoolean(parcel2, zzaa);
                    break;
                case 16:
                    String readString6 = parcel.readString();
                    String readString7 = parcel.readString();
                    zzvq zzvqVar3 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                    IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 != null) {
                        IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        if (queryLocalInterface4 instanceof zzapz) {
                            zzaqbVar2 = (zzapz) queryLocalInterface4;
                        } else {
                            zzaqbVar2 = new zzaqb(readStrongBinder4);
                        }
                    }
                    zza(readString6, readString7, zzvqVar3, asInterface4, zzaqbVar2, zzans.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 17:
                    boolean zzab = zzab(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzgx.writeBoolean(parcel2, zzab);
                    break;
                case 18:
                    String readString8 = parcel.readString();
                    String readString9 = parcel.readString();
                    zzvq zzvqVar4 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                    IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder5 = parcel.readStrongBinder();
                    if (readStrongBinder5 != null) {
                        IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        if (queryLocalInterface5 instanceof zzapu) {
                            zzapwVar2 = (zzapu) queryLocalInterface5;
                        } else {
                            zzapwVar2 = new zzapw(readStrongBinder5);
                        }
                    }
                    zza(readString8, readString9, zzvqVar4, asInterface5, zzapwVar2, zzans.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 19:
                    zzdn(parcel.readString());
                    parcel2.writeNoException();
                    break;
                case 20:
                    String readString10 = parcel.readString();
                    String readString11 = parcel.readString();
                    zzvq zzvqVar5 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                    IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder6 = parcel.readStrongBinder();
                    if (readStrongBinder6 != null) {
                        IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        if (queryLocalInterface6 instanceof zzapz) {
                            zzaqbVar = (zzapz) queryLocalInterface6;
                        } else {
                            zzaqbVar = new zzaqb(readStrongBinder6);
                        }
                    }
                    zzb(readString10, readString11, zzvqVar5, asInterface6, zzaqbVar, zzans.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 21:
                    String readString12 = parcel.readString();
                    String readString13 = parcel.readString();
                    zzvq zzvqVar6 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                    IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder7 = parcel.readStrongBinder();
                    if (readStrongBinder7 != null) {
                        IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        if (queryLocalInterface7 instanceof zzapo) {
                            zzapqVar = (zzapo) queryLocalInterface7;
                        } else {
                            zzapqVar = new zzapq(readStrongBinder7);
                        }
                    }
                    zzb(readString12, readString13, zzvqVar6, asInterface7, zzapqVar, zzans.zzad(parcel.readStrongBinder()), (zzvt) zzgx.zza(parcel, zzvt.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 22:
                    String readString14 = parcel.readString();
                    String readString15 = parcel.readString();
                    zzvq zzvqVar7 = (zzvq) zzgx.zza(parcel, zzvq.CREATOR);
                    IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder8 = parcel.readStrongBinder();
                    if (readStrongBinder8 != null) {
                        IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        if (queryLocalInterface8 instanceof zzapu) {
                            zzapwVar = (zzapu) queryLocalInterface8;
                        } else {
                            zzapwVar = new zzapw(readStrongBinder8);
                        }
                    }
                    zza(readString14, readString15, zzvqVar7, asInterface8, zzapwVar, zzans.zzad(parcel.readStrongBinder()), (zzaei) zzgx.zza(parcel, zzaei.CREATOR));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}

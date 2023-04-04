package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzatz extends zzgy implements zzatw {
    public zzatz() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            zzaub zzaubVar = null;
            zzaud zzaudVar = null;
            zzaud zzaudVar2 = null;
            zzaud zzaudVar3 = null;
            zzaud zzaudVar4 = null;
            if (i == 2) {
                zzatq zzatqVar = (zzatq) zzgx.zza(parcel, zzatq.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface instanceof zzaub) {
                        zzaubVar = (zzaub) queryLocalInterface;
                    } else {
                        zzaubVar = new zzaua(readStrongBinder);
                    }
                }
                zza(zzatqVar, zzaubVar);
                parcel2.writeNoException();
            } else if (i == 4) {
                zzauj zzaujVar = (zzauj) zzgx.zza(parcel, zzauj.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface2 instanceof zzaud) {
                        zzaudVar4 = (zzaud) queryLocalInterface2;
                    } else {
                        zzaudVar4 = new zzauf(readStrongBinder2);
                    }
                }
                zza(zzaujVar, zzaudVar4);
                parcel2.writeNoException();
            } else if (i == 5) {
                zzauj zzaujVar2 = (zzauj) zzgx.zza(parcel, zzauj.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface3 instanceof zzaud) {
                        zzaudVar3 = (zzaud) queryLocalInterface3;
                    } else {
                        zzaudVar3 = new zzauf(readStrongBinder3);
                    }
                }
                zzb(zzaujVar2, zzaudVar3);
                parcel2.writeNoException();
            } else if (i == 6) {
                zzauj zzaujVar3 = (zzauj) zzgx.zza(parcel, zzauj.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface4 instanceof zzaud) {
                        zzaudVar2 = (zzaud) queryLocalInterface4;
                    } else {
                        zzaudVar2 = new zzauf(readStrongBinder4);
                    }
                }
                zzc(zzaujVar3, zzaudVar2);
                parcel2.writeNoException();
            } else if (i != 7) {
                return false;
            } else {
                String readString = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface5 instanceof zzaud) {
                        zzaudVar = (zzaud) queryLocalInterface5;
                    } else {
                        zzaudVar = new zzauf(readStrongBinder5);
                    }
                }
                zza(readString, zzaudVar);
                parcel2.writeNoException();
            }
        } else {
            zzats zza = zza((zzatq) zzgx.zza(parcel, zzatq.CREATOR));
            parcel2.writeNoException();
            zzgx.zzb(parcel2, zza);
        }
        return true;
    }
}

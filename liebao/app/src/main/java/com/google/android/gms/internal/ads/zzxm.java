package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzxm extends zzgy implements zzxj {
    public zzxm() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzxc zzxcVar = null;
        zzye zzyeVar = null;
        switch (i) {
            case 1:
                zzxi zzrf = zzrf();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzrf);
                return true;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzxc) {
                        zzxcVar = (zzxc) queryLocalInterface;
                    } else {
                        zzxcVar = new zzxe(readStrongBinder);
                    }
                }
                zzb(zzxcVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zza(zzafv.zzs(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                zza(zzafw.zzt(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                zza(parcel.readString(), zzagc.zzv(parcel.readStrongBinder()), zzagb.zzu(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zza((zzaei) zzgx.zza(parcel, zzaei.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface2 instanceof zzye) {
                        zzyeVar = (zzye) queryLocalInterface2;
                    } else {
                        zzyeVar = new zzyd(readStrongBinder2);
                    }
                }
                zzb(zzyeVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzagj.zzw(parcel.readStrongBinder()), (zzvt) zzgx.zza(parcel, zzvt.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                zza((PublisherAdViewOptions) zzgx.zza(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                zza(zzagk.zzx(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zza((zzajy) zzgx.zza(parcel, zzajy.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzakj.zzab(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zza((AdManagerAdViewOptions) zzgx.zza(parcel, AdManagerAdViewOptions.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}

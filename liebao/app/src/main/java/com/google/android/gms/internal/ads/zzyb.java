package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzyb extends zzgw implements zzxz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxq zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, String str, zzann zzannVar, int i) {
        zzxq zzxsVar;
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvtVar);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(i);
        Parcel zza = zza(1, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxsVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxq) {
                zzxsVar = (zzxq) queryLocalInterface;
            } else {
                zzxsVar = new zzxs(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxq zzb(IObjectWrapper iObjectWrapper, zzvt zzvtVar, String str, zzann zzannVar, int i) {
        zzxq zzxsVar;
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvtVar);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(i);
        Parcel zza = zza(2, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxsVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxq) {
                zzxsVar = (zzxq) queryLocalInterface;
            } else {
                zzxsVar = new zzxs(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxj zza(IObjectWrapper iObjectWrapper, String str, zzann zzannVar, int i) {
        zzxj zzxlVar;
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(i);
        Parcel zza = zza(3, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxlVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzxj) {
                zzxlVar = (zzxj) queryLocalInterface;
            } else {
                zzxlVar = new zzxl(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzyh zzc(IObjectWrapper iObjectWrapper) {
        zzyh zzyjVar;
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        Parcel zza = zza(4, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzyjVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyh) {
                zzyjVar = (zzyh) queryLocalInterface;
            } else {
                zzyjVar = new zzyj(readStrongBinder);
            }
        }
        zza.recycle();
        return zzyjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzaew zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, iObjectWrapper2);
        Parcel zza = zza(5, zzdp);
        zzaew zzp = zzaez.zzp(zza.readStrongBinder());
        zza.recycle();
        return zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzavg zza(IObjectWrapper iObjectWrapper, zzann zzannVar, int i) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(i);
        Parcel zza = zza(6, zzdp);
        zzavg zzao = zzavj.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzass zzd(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        Parcel zza = zza(7, zzdp);
        zzass zzal = zzasv.zzal(zza.readStrongBinder());
        zza.recycle();
        return zzal;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzash zzb(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        Parcel zza = zza(8, zzdp);
        zzash zzaj = zzasg.zzaj(zza.readStrongBinder());
        zza.recycle();
        return zzaj;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzyh zza(IObjectWrapper iObjectWrapper, int i) {
        zzyh zzyjVar;
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeInt(i);
        Parcel zza = zza(9, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzyjVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyh) {
                zzyjVar = (zzyh) queryLocalInterface;
            } else {
                zzyjVar = new zzyj(readStrongBinder);
            }
        }
        zza.recycle();
        return zzyjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxq zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, String str, int i) {
        zzxq zzxsVar;
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvtVar);
        zzdp.writeString(str);
        zzdp.writeInt(i);
        Parcel zza = zza(10, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxsVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxq) {
                zzxsVar = (zzxq) queryLocalInterface;
            } else {
                zzxsVar = new zzxs(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzafd zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, iObjectWrapper2);
        zzgx.zza(zzdp, iObjectWrapper3);
        Parcel zza = zza(11, zzdp);
        zzafd zzq = zzafc.zzq(zza.readStrongBinder());
        zza.recycle();
        return zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzawf zzb(IObjectWrapper iObjectWrapper, String str, zzann zzannVar, int i) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(i);
        Parcel zza = zza(12, zzdp);
        zzawf zzas = zzawe.zzas(zza.readStrongBinder());
        zza.recycle();
        return zzas;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxq zzc(IObjectWrapper iObjectWrapper, zzvt zzvtVar, String str, zzann zzannVar, int i) {
        zzxq zzxsVar;
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvtVar);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(i);
        Parcel zza = zza(13, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxsVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxq) {
                zzxsVar = (zzxq) queryLocalInterface;
            } else {
                zzxsVar = new zzxs(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzazc zzb(IObjectWrapper iObjectWrapper, zzann zzannVar, int i) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(i);
        Parcel zza = zza(14, zzdp);
        zzazc zzat = zzazf.zzat(zza.readStrongBinder());
        zza.recycle();
        return zzat;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzaru zzc(IObjectWrapper iObjectWrapper, zzann zzannVar, int i) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzannVar);
        zzdp.writeInt(i);
        Parcel zza = zza(15, zzdp);
        zzaru zzah = zzarx.zzah(zza.readStrongBinder());
        zza.recycle();
        return zzah;
    }
}

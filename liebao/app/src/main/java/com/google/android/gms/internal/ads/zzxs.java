package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzxs extends zzgw implements zzxq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final IObjectWrapper zzki() {
        Parcel zza = zza(1, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void destroy() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean isReady() {
        Parcel zza = zza(3, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean zza(zzvq zzvqVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvqVar);
        Parcel zza = zza(4, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void pause() {
        zzb(5, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void resume() {
        zzb(6, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxc zzxcVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzxcVar);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxy zzxyVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzxyVar);
        zzb(8, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void showInterstitial() {
        zzb(9, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void stopLoading() {
        zzb(10, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzkj() {
        zzb(11, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzvt zzkk() {
        Parcel zza = zza(12, zzdp());
        zzvt zzvtVar = (zzvt) zzgx.zza(zza, zzvt.CREATOR);
        zza.recycle();
        return zzvtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzvt zzvtVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvtVar);
        zzb(13, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasr zzasrVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzasrVar);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasx zzasxVar, String str) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzasxVar);
        zzdp.writeString(str);
        zzb(15, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final String getMediationAdapterClassName() {
        Parcel zza = zza(18, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzacm zzacmVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzacmVar);
        zzb(19, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwx zzwxVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzwxVar);
        zzb(20, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzye zzyeVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzyeVar);
        zzb(21, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setManualImpressionsEnabled(boolean z) {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(22, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean isLoading() {
        Parcel zza = zza(23, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzavn zzavnVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzavnVar);
        zzb(24, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setUserId(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(25, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzzd getVideoController() {
        zzzd zzzfVar;
        Parcel zza = zza(26, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzzfVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            if (queryLocalInterface instanceof zzzd) {
                zzzfVar = (zzzd) queryLocalInterface;
            } else {
                zzzfVar = new zzzf(readStrongBinder);
            }
        }
        zza.recycle();
        return zzzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzaaz zzaazVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaazVar);
        zzb(29, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzzj zzzjVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzzjVar);
        zzb(30, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final String getAdUnitId() {
        Parcel zza = zza(31, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxy zzkn() {
        zzxy zzyaVar;
        Parcel zza = zza(32, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzyaVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            if (queryLocalInterface instanceof zzxy) {
                zzyaVar = (zzxy) queryLocalInterface;
            } else {
                zzyaVar = new zzya(readStrongBinder);
            }
        }
        zza.recycle();
        return zzyaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxc zzko() {
        zzxc zzxeVar;
        Parcel zza = zza(33, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            if (queryLocalInterface instanceof zzxc) {
                zzxeVar = (zzxc) queryLocalInterface;
            } else {
                zzxeVar = new zzxe(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setImmersiveMode(boolean z) {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(34, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final String zzkl() {
        Parcel zza = zza(35, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxt zzxtVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzxtVar);
        zzb(36, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final Bundle getAdMetadata() {
        Parcel zza = zza(37, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzbl(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(38, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwc zzwcVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzwcVar);
        zzb(39, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzsq zzsqVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzsqVar);
        zzb(40, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzzc zzkm() {
        zzzc zzzeVar;
        Parcel zza = zza(41, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzzeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzzc) {
                zzzeVar = (zzzc) queryLocalInterface;
            } else {
                zzzeVar = new zzze(readStrongBinder);
            }
        }
        zza.recycle();
        return zzzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyx zzyxVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzyxVar);
        zzb(42, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzvq zzvqVar, zzxd zzxdVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, zzxdVar);
        zzb(43, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zze(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(44, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyg zzygVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzygVar);
        zzb(45, zzdp);
    }
}

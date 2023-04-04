package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzawh extends zzgw implements zzawf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzvq zzvqVar, zzawn zzawnVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, zzawnVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzawg zzawgVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzawgVar);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final boolean isLoaded() {
        Parcel zza = zza(3, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final String getMediationAdapterClassName() {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zze(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzawo zzawoVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzawoVar);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzaww zzawwVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzawwVar);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzyw zzywVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzywVar);
        zzb(8, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final Bundle getAdMetadata() {
        Parcel zza = zza(9, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.writeBoolean(zzdp, z);
        zzb(10, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final zzawa zzsb() {
        zzawa zzawcVar;
        Parcel zza = zza(11, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
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
        zza.recycle();
        return zzawcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final zzzc zzkm() {
        Parcel zza = zza(12, zzdp());
        zzzc zzj = zzzb.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzyx zzyxVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzyxVar);
        zzb(13, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zzb(zzvq zzvqVar, zzawn zzawnVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, zzawnVar);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void setImmersiveMode(boolean z) {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(15, zzdp);
    }
}

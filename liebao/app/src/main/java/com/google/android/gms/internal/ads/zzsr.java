package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzsr extends zzgw implements zzsp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final zzxq zzea() {
        Parcel zza = zza(2, zzdp());
        zzxq zzc = zzxp.zzc(zza.readStrongBinder());
        zza.recycle();
        return zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(zzsv zzsvVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzsvVar);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(IObjectWrapper iObjectWrapper, zzsw zzswVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzswVar);
        zzb(4, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final zzzc zzkm() {
        Parcel zza = zza(5, zzdp());
        zzzc zzj = zzzb.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void setImmersiveMode(boolean z) {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(zzyx zzyxVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzyxVar);
        zzb(7, zzdp);
    }
}

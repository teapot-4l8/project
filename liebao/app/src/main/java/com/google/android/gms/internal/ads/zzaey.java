package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaey extends zzgw implements zzaew {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaey(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zzb(String str, IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzco(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        Parcel zza = zza(2, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void destroy() {
        zzb(4, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zzc(IObjectWrapper iObjectWrapper, int i) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeInt(i);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zzf(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zzg(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzaer zzaerVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaerVar);
        zzb(8, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zzh(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(9, zzdp);
    }
}

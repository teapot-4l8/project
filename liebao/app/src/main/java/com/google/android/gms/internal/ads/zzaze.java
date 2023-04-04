package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaze extends zzgw implements zzazc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zza(IObjectWrapper iObjectWrapper, zzazi zzaziVar, zzazb zzazbVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzaziVar);
        zzgx.zza(zzdp, zzazbVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zzao(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, iObjectWrapper2);
        Parcel zza = zza(3, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final IObjectWrapper zzap(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        Parcel zza = zza(4, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasyVar) {
        Parcel zzdp = zzdp();
        zzdp.writeTypedList(list);
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzasyVar);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasyVar) {
        Parcel zzdp = zzdp();
        zzdp.writeTypedList(list);
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzasyVar);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zza(zzatj zzatjVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzatjVar);
        zzb(7, zzdp);
    }
}

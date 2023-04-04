package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzakc extends zzgw implements zzaka {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final zzzd getVideoController() {
        Parcel zza = zza(3, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void destroy() {
        zzb(4, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(IObjectWrapper iObjectWrapper, zzakf zzakfVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzakfVar);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zzr(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final zzaer zzue() {
        Parcel zza = zza(7, zzdp());
        zzaer zzn = zzaeq.zzn(zza.readStrongBinder());
        zza.recycle();
        return zzn;
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaff extends zzgw implements zzafd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaff(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzafd
    public final void zza(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzafd
    public final void unregisterNativeAd() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzafd
    public final void zzf(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(3, zzdp);
    }
}

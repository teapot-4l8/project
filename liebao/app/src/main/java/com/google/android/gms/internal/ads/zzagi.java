package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzagi extends zzgw implements zzagg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(zzxq zzxqVar, IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzxqVar);
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(1, zzdp);
    }
}

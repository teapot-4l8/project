package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzapq extends zzgw implements zzapo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void zzy(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void zzdm(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void zzg(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void zza(zzanu zzanuVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzanuVar);
        zzb(4, zzdp);
    }
}

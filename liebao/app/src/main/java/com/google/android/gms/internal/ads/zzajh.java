package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzajh extends zzgw implements zzaje {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzaiy zzaiyVar, zzajc zzajcVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaiyVar);
        zzgx.zza(zzdp, zzajcVar);
        zzc(2, zzdp);
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzawr extends zzgw implements zzawo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzawo
    public final void zza(zzawa zzawaVar, String str, String str2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzawaVar);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(2, zzdp);
    }
}

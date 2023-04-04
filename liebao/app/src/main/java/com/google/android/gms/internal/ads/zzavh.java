package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavh extends zzgw implements zzave {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zza(zzavd zzavdVar, String str, String str2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzavdVar);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(2, zzdp);
    }
}

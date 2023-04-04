package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzazm implements zzazo {
    @Override // com.google.android.gms.internal.ads.zzazo
    public final zzebt<String> zza(String str, PackageInfo packageInfo, int i) {
        return zzebh.zzag(str);
    }

    @Override // com.google.android.gms.internal.ads.zzazo
    public final zzebt<AdvertisingIdClient.Info> zza(Context context, int i) {
        zzbbe zzbbeVar = new zzbbe();
        zzww.zzqw();
        if (zzbae.zzbr(context)) {
            zzbat.zzeke.execute(new zzazp(this, context, zzbbeVar));
        }
        return zzbbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazo
    public final zzebt<String> zzb(Context context, int i) {
        return zzebh.zzag(null);
    }
}

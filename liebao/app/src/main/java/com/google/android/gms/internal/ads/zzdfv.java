package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfv implements zzesa<zzdfw> {
    private final zzesn<PackageInfo> zzgay;
    private final zzesn<ApplicationInfo> zzgqp;

    private zzdfv(zzesn<ApplicationInfo> zzesnVar, zzesn<PackageInfo> zzesnVar2) {
        this.zzgqp = zzesnVar;
        this.zzgay = zzesnVar2;
    }

    public static zzdfv zzay(zzesn<ApplicationInfo> zzesnVar, zzesn<PackageInfo> zzesnVar2) {
        return new zzdfv(zzesnVar, zzesnVar2);
    }

    public static zzdfw zza(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzdfw(applicationInfo, packageInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzgqp.get(), this.zzgay.get());
    }
}

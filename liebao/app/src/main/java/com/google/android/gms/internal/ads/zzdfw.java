package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfw implements zzdhb<Bundle>, zzdhe<zzdhb<Bundle>> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdvo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfw(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo;
        this.zzdvo = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhb<Bundle>> zzatu() {
        return zzebh.zzag(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdvo;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle2.putString("pn", str);
        if (valueOf != null) {
            bundle2.putInt("vc", valueOf.intValue());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyc)).booleanValue()) {
            PackageInfo packageInfo2 = this.zzdvo;
            String str2 = packageInfo2 != null ? packageInfo2.versionName : null;
            if (str2 != null) {
                bundle2.putString("vnm", str2);
            }
        }
    }
}

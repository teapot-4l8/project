package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.ak;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhl implements zzdhb<Bundle> {
    private final String zzdza;
    private final int zzdzl;
    private final int zzdzm;
    private final int zzdzn;
    private final boolean zzdzs;
    private final int zzdzt;

    public zzdhl(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zzdza = str;
        this.zzdzl = i;
        this.zzdzm = i2;
        this.zzdzn = i3;
        this.zzdzs = z;
        this.zzdzt = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.zzdza;
        zzdpw.zza(bundle2, ak.P, str, !TextUtils.isEmpty(str));
        zzdpw.zza(bundle2, "cnt", Integer.valueOf(this.zzdzl), this.zzdzl != -2);
        bundle2.putInt("gnt", this.zzdzm);
        bundle2.putInt("pt", this.zzdzn);
        Bundle zza = zzdpw.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        Bundle zza2 = zzdpw.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.zzdzt);
        zza2.putBoolean("active_network_metered", this.zzdzs);
    }
}

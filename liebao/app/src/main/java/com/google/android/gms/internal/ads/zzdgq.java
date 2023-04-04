package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgq implements zzdhb<Bundle> {
    private final String zzbrz;
    private final int zzdwe;
    private final boolean zzdxa;
    private final boolean zzekd;
    private final boolean zzhga;
    private final int zzhgb;
    private final int zzhgc;

    public zzdgq(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.zzhga = z;
        this.zzekd = z2;
        this.zzbrz = str;
        this.zzdxa = z3;
        this.zzdwe = i;
        this.zzhgb = i2;
        this.zzhgc = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("js", this.zzbrz);
        bundle2.putBoolean("is_nonagon", true);
        bundle2.putString("extra_caps", (String) zzww.zzra().zzd(zzabq.zzctn));
        bundle2.putInt("target_api", this.zzdwe);
        bundle2.putInt("dv", this.zzhgb);
        bundle2.putInt("lv", this.zzhgc);
        Bundle zza = zzdpw.zza(bundle2, "sdk_env");
        zza.putBoolean("mf", zzadn.zzdff.get().booleanValue());
        zza.putBoolean("instant_app", this.zzhga);
        zza.putBoolean("lite", this.zzekd);
        zza.putBoolean("is_privileged_process", this.zzdxa);
        bundle2.putBundle("sdk_env", zza);
        Bundle zza2 = zzdpw.zza(zza, "build_meta");
        zza2.putString("cl", "360757573");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}

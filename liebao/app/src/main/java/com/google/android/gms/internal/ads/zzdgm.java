package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgm implements zzdhb<Bundle> {
    private final String zzecy;
    private final String zzhfv;
    private final String zzhfw;
    private final String zzhfx;
    private final Long zzhfy;

    public zzdgm(String str, String str2, String str3, String str4, Long l) {
        this.zzecy = str;
        this.zzhfv = str2;
        this.zzhfw = str3;
        this.zzhfx = str4;
        this.zzhfy = l;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdpw.zza(bundle2, "gmp_app_id", this.zzecy);
        zzdpw.zza(bundle2, "fbs_aiid", this.zzhfv);
        zzdpw.zza(bundle2, "fbs_aeid", this.zzhfw);
        zzdpw.zza(bundle2, "apm_id_origin", this.zzhfx);
        Long l = this.zzhfy;
        if (l != null) {
            bundle2.putLong("sai_timeout", l.longValue());
        }
    }
}

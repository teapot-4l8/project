package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdel implements zzdhb<Bundle> {
    private final String zzdxc;
    private final String zzhev;
    private final Bundle zzhew;

    private zzdel(String str, String str2, Bundle bundle) {
        this.zzdxc = str;
        this.zzhev = str2;
        this.zzhew = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("consent_string", this.zzdxc);
        bundle2.putString("fc_consent", this.zzhev);
        bundle2.putBundle("iab_consent_info", this.zzhew);
    }
}

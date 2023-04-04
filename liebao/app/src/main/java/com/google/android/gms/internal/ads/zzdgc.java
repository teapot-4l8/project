package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgc implements zzdhb<Bundle> {
    private String zzdvx;
    private final String zzhfn;

    public zzdgc(String str, String str2) {
        this.zzdvx = str;
        this.zzhfn = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczz)).booleanValue()) {
            bundle2.putString("request_id", this.zzhfn);
        } else {
            bundle2.putString("request_id", this.zzdvx);
        }
    }
}

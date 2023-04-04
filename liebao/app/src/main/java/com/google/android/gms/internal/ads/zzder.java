package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzder implements zzdhb<Bundle> {
    private final String zzdwm;
    private final boolean zzdwo;

    public zzder(String str, boolean z) {
        this.zzdwm = str;
        this.zzdwo = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("gct", this.zzdwm);
        if (this.zzdwo) {
            bundle2.putString("de", "1");
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfd implements zzdhb<Bundle> {
    private final zzdor zzfti;

    public zzdfd(zzdor zzdorVar) {
        this.zzfti = zzdorVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdor zzdorVar = this.zzfti;
        if (zzdorVar != null) {
            bundle2.putBoolean("render_in_browser", zzdorVar.zzavw());
            bundle2.putBoolean("disable_ml", this.zzfti.zzavx());
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfy implements zzdhb<Bundle> {
    private final Bundle zzgbd;

    public zzdfy(Bundle bundle) {
        this.zzgbd = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundle3 = this.zzgbd;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
    }
}

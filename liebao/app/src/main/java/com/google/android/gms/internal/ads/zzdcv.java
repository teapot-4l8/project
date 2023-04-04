package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcv implements zzdhb<Bundle> {
    private final Bundle zzhds;

    private zzdcv(Bundle bundle) {
        this.zzhds = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (this.zzhds.isEmpty()) {
            return;
        }
        bundle2.putBundle("installed_adapter_data", this.zzhds);
    }
}

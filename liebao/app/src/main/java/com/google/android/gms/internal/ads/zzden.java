package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzden implements zzdhb<Bundle> {
    private final Bundle zzhex;

    public zzden(Bundle bundle) {
        this.zzhex = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        bundle.putBundle("content_info", this.zzhex);
    }
}

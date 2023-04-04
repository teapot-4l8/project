package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgd implements zzdhb<Bundle> {
    private final String zzhfo;

    public zzdgd(String str) {
        this.zzhfo = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        bundle.putString("rtb", this.zzhfo);
    }
}

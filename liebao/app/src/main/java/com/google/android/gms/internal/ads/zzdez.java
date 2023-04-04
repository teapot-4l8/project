package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdez implements zzdhb<Bundle> {
    private final Bundle zzdwl;

    public zzdez(Bundle bundle) {
        this.zzdwl = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzdpw.zza(bundle2, "device");
        zza.putBundle("android_mem_info", this.zzdwl);
        bundle2.putBundle("device", zza);
    }
}

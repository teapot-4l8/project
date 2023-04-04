package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.umeng.analytics.pro.ak;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddu implements zzdhb<Bundle> {
    private final double zzdzq;
    private final boolean zzdzr;

    public zzddu(double d2, boolean z) {
        this.zzdzq = d2;
        this.zzdzr = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzdpw.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        Bundle zza2 = zzdpw.zza(zza, ak.Z);
        zza.putBundle(ak.Z, zza2);
        zza2.putBoolean("is_charging", this.zzdzr);
        zza2.putDouble("battery_level", this.zzdzq);
    }
}

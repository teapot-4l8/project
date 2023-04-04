package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzuz implements zzeni<Integer, zzuh.zzc.zza> {
    @Override // com.google.android.gms.internal.ads.zzeni
    public final /* synthetic */ zzuh.zzc.zza convert(Integer num) {
        zzuh.zzc.zza zzce = zzuh.zzc.zza.zzce(num.intValue());
        return zzce == null ? zzuh.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzce;
    }
}

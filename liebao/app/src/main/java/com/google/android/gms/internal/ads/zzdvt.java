package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvq;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdvt implements zzeni<Integer, zzdvq.zza> {
    @Override // com.google.android.gms.internal.ads.zzeni
    public final /* synthetic */ zzdvq.zza convert(Integer num) {
        zzdvq.zza zzep = zzdvq.zza.zzep(num.intValue());
        return zzep == null ? zzdvq.zza.BLOCKED_REASON_UNKNOWN : zzep;
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyp implements zzesa<zzcwk> {
    private final zzesn<zzcwm> zzfcp;
    private final zzesn<zzctc> zzfcq;
    private final zzesn<Clock> zzfvh;
    private final zzbxr zzgdc;

    private zzbyp(zzbxr zzbxrVar, zzesn<Clock> zzesnVar, zzesn<zzcwm> zzesnVar2, zzesn<zzctc> zzesnVar3) {
        this.zzgdc = zzbxrVar;
        this.zzfvh = zzesnVar;
        this.zzfcp = zzesnVar2;
        this.zzfcq = zzesnVar3;
    }

    public static zzbyp zza(zzbxr zzbxrVar, zzesn<Clock> zzesnVar, zzesn<zzcwm> zzesnVar2, zzesn<zzctc> zzesnVar3) {
        return new zzbyp(zzbxrVar, zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzcwk) zzesg.zzbd(this.zzgdc.zza(this.zzfvh.get(), this.zzfcp.get(), this.zzfcq.get()));
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdef implements zzesa<zzddz<zzddu>> {
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzddt> zzhes;

    public zzdef(zzesn<zzddt> zzesnVar, zzesn<Clock> zzesnVar2) {
        this.zzhes = zzesnVar;
        this.zzfvh = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzddz) zzesg.zzbd(new zzddz(this.zzhes.get(), 10000L, this.zzfvh.get()));
    }
}

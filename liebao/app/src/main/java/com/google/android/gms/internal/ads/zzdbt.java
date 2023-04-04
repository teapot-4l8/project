package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdbt implements zzesa<zzdbf> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzei> zzfuc;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<zzdqc<zzchu>> zzgxr;
    private final zzesn<zzbhh> zzhcv;

    public zzdbt(zzesn<zzbhh> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzei> zzesnVar3, zzesn<zzbar> zzesnVar4, zzesn<zzdqc<zzchu>> zzesnVar5, zzesn<zzebs> zzesnVar6, zzesn<ScheduledExecutorService> zzesnVar7) {
        this.zzhcv = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzfuc = zzesnVar3;
        this.zzfvj = zzesnVar4;
        this.zzgxr = zzesnVar5;
        this.zzeyl = zzesnVar6;
        this.zzfty = zzesnVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdbf(this.zzhcv.get(), this.zzeyq.get(), this.zzfuc.get(), this.zzfvj.get(), this.zzgxr.get(), this.zzeyl.get(), this.zzfty.get());
    }
}

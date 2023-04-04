package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbry implements zzesa<zzbrx> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbtl> zzgam;
    private final zzesn<zzdot> zzgan;
    private final zzesn<ScheduledExecutorService> zzgao;

    private zzbry(zzesn<zzbtl> zzesnVar, zzesn<zzdot> zzesnVar2, zzesn<ScheduledExecutorService> zzesnVar3, zzesn<Executor> zzesnVar4) {
        this.zzgam = zzesnVar;
        this.zzgan = zzesnVar2;
        this.zzgao = zzesnVar3;
        this.zzeyl = zzesnVar4;
    }

    public static zzbry zzb(zzesn<zzbtl> zzesnVar, zzesn<zzdot> zzesnVar2, zzesn<ScheduledExecutorService> zzesnVar3, zzesn<Executor> zzesnVar4) {
        return new zzbry(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbrx(this.zzgam.get(), this.zzgan.get(), this.zzgao.get(), this.zzeyl.get());
    }
}

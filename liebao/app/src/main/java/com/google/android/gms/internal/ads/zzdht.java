package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdht implements zzesa<zzdhs> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzazo> zzfad;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<Integer> zzhgz;

    public zzdht(zzesn<zzazo> zzesnVar, zzesn<Context> zzesnVar2, zzesn<ScheduledExecutorService> zzesnVar3, zzesn<Executor> zzesnVar4, zzesn<Integer> zzesnVar5) {
        this.zzfad = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzfty = zzesnVar3;
        this.zzeyl = zzesnVar4;
        this.zzhgz = zzesnVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdhs(this.zzfad.get(), this.zzeyq.get(), this.zzfty.get(), this.zzeyl.get(), this.zzhgz.get().intValue());
    }
}

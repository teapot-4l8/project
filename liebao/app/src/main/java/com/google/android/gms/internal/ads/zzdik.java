package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdik implements zzesa<zzdig> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzazo> zzfad;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzazs> zzhdo;
    private final zzesn<Integer> zzhgz;

    public zzdik(zzesn<zzazo> zzesnVar, zzesn<Integer> zzesnVar2, zzesn<Context> zzesnVar3, zzesn<zzazs> zzesnVar4, zzesn<ScheduledExecutorService> zzesnVar5, zzesn<Executor> zzesnVar6) {
        this.zzfad = zzesnVar;
        this.zzhgz = zzesnVar2;
        this.zzeyq = zzesnVar3;
        this.zzhdo = zzesnVar4;
        this.zzfty = zzesnVar5;
        this.zzeyl = zzesnVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdig(this.zzfad.get(), this.zzhgz.get().intValue(), this.zzeyq.get(), this.zzhdo.get(), this.zzfty.get(), this.zzeyl.get());
    }
}

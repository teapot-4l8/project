package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbln implements zzesa<zzbli> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzamx> zzfve;
    private final zzesn<zzblg> zzfvf;
    private final zzesn<zzbld> zzfvg;
    private final zzesn<Clock> zzfvh;

    private zzbln(zzesn<zzamx> zzesnVar, zzesn<zzblg> zzesnVar2, zzesn<Executor> zzesnVar3, zzesn<zzbld> zzesnVar4, zzesn<Clock> zzesnVar5) {
        this.zzfve = zzesnVar;
        this.zzfvf = zzesnVar2;
        this.zzeyl = zzesnVar3;
        this.zzfvg = zzesnVar4;
        this.zzfvh = zzesnVar5;
    }

    public static zzbln zza(zzesn<zzamx> zzesnVar, zzesn<zzblg> zzesnVar2, zzesn<Executor> zzesnVar3, zzesn<zzbld> zzesnVar4, zzesn<Clock> zzesnVar5) {
        return new zzbln(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbli(this.zzfve.get(), this.zzfvf.get(), this.zzeyl.get(), this.zzfvg.get(), this.zzfvh.get());
    }
}

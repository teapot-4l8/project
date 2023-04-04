package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzblm implements zzesa<zzbld> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzqt> zzfvc;
    private final zzesn<zzamx> zzfvd;

    private zzblm(zzesn<zzqt> zzesnVar, zzesn<zzamx> zzesnVar2, zzesn<Executor> zzesnVar3) {
        this.zzfvc = zzesnVar;
        this.zzfvd = zzesnVar2;
        this.zzeyl = zzesnVar3;
    }

    public static zzblm zza(zzesn<zzqt> zzesnVar, zzesn<zzamx> zzesnVar2, zzesn<Executor> zzesnVar3) {
        return new zzblm(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbld) zzesg.zzbd(new zzbld(this.zzfvc.get().getUniqueId(), this.zzfvd.get(), this.zzeyl.get()));
    }
}

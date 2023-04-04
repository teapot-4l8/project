package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbtj implements zzesa<zzbtb> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbtf> zzfkd;
    private final zzesn<Set<zzbzl<zzbtc>>> zzfxl;

    private zzbtj(zzesn<zzbtf> zzesnVar, zzesn<Set<zzbzl<zzbtc>>> zzesnVar2, zzesn<Executor> zzesnVar3) {
        this.zzfkd = zzesnVar;
        this.zzfxl = zzesnVar2;
        this.zzeyl = zzesnVar3;
    }

    public static zzbtj zzn(zzesn<zzbtf> zzesnVar, zzesn<Set<zzbzl<zzbtc>>> zzesnVar2, zzesn<Executor> zzesnVar3) {
        return new zzbtj(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbtb(this.zzfkd.get(), this.zzfxl.get(), this.zzeyl.get());
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbot implements zzesa<zzbok> {
    private final zzesn<zzagm> zzeyk;
    private final zzesn<zzbpf> zzfkj;
    private final zzesn<Runnable> zzfqg;
    private final zzesn<Executor> zzfxf;

    public zzbot(zzesn<zzbpf> zzesnVar, zzesn<zzagm> zzesnVar2, zzesn<Runnable> zzesnVar3, zzesn<Executor> zzesnVar4) {
        this.zzfkj = zzesnVar;
        this.zzeyk = zzesnVar2;
        this.zzfqg = zzesnVar3;
        this.zzfxf = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbok(this.zzfkj.get(), this.zzeyk.get(), this.zzfqg.get(), this.zzfxf.get());
    }
}

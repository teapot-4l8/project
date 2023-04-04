package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcos implements zzesa<zzcoo> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzcrr> zzfci;
    private final zzesn<zzcno> zzfgi;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzdpm> zzfxn;

    private zzcos(zzesn<zzdpm> zzesnVar, zzesn<zzcno> zzesnVar2, zzesn<zzebs> zzesnVar3, zzesn<ScheduledExecutorService> zzesnVar4, zzesn<zzcrr> zzesnVar5) {
        this.zzfxn = zzesnVar;
        this.zzfgi = zzesnVar2;
        this.zzeyl = zzesnVar3;
        this.zzfty = zzesnVar4;
        this.zzfci = zzesnVar5;
    }

    public static zzcos zzf(zzesn<zzdpm> zzesnVar, zzesn<zzcno> zzesnVar2, zzesn<zzebs> zzesnVar3, zzesn<ScheduledExecutorService> zzesnVar4, zzesn<zzcrr> zzesnVar5) {
        return new zzcos(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcoo(this.zzfxn.get(), this.zzfgi.get(), this.zzeyl.get(), this.zzfty.get(), this.zzfci.get());
    }
}

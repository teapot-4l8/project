package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcop implements zzesa<zzcon> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzcpd> zzgqi;
    private final zzesn<zzcqb> zzgqj;

    public zzcop(zzesn<ScheduledExecutorService> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<zzcpd> zzesnVar3, zzesn<zzcqb> zzesnVar4) {
        this.zzfty = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzgqi = zzesnVar3;
        this.zzgqj = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcon(this.zzfty.get(), this.zzeyl.get(), this.zzgqi.get(), zzesb.zzat(this.zzgqj));
    }
}

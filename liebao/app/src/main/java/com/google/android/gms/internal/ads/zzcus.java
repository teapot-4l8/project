package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcus implements zzesa<zzcuo> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzboa> zzfpn;
    private final zzesn<zzcts> zzfpr;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzbsx> zzgwy;

    public zzcus(zzesn<zzboa> zzesnVar, zzesn<zzcts> zzesnVar2, zzesn<zzbsx> zzesnVar3, zzesn<ScheduledExecutorService> zzesnVar4, zzesn<zzebs> zzesnVar5) {
        this.zzfpn = zzesnVar;
        this.zzfpr = zzesnVar2;
        this.zzgwy = zzesnVar3;
        this.zzfty = zzesnVar4;
        this.zzeyl = zzesnVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcuo(this.zzfpn.get(), this.zzfpr.get(), this.zzgwy.get(), this.zzfty.get(), this.zzeyl.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdjc implements zzesa<zzdja> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzasp> zzfad;
    private final zzesn<ScheduledExecutorService> zzfty;

    public zzdjc(zzesn<zzasp> zzesnVar, zzesn<ScheduledExecutorService> zzesnVar2, zzesn<Context> zzesnVar3) {
        this.zzfad = zzesnVar;
        this.zzfty = zzesnVar2;
        this.zzeyq = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdja(this.zzfad.get(), this.zzfty.get(), this.zzeyq.get());
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbnf implements zzesa<zzbve> {
    private final zzesn<Clock> zzfvh;
    private final zzesn<ScheduledExecutorService> zzfwv;

    public zzbnf(zzesn<ScheduledExecutorService> zzesnVar, zzesn<Clock> zzesnVar2) {
        this.zzfwv = zzesnVar;
        this.zzfvh = zzesnVar2;
    }

    public static zzbve zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbve) zzesg.zzbd(new zzbve(scheduledExecutorService, clock));
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzfwv.get(), this.zzfvh.get());
    }
}

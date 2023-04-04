package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzebw extends zzebx implements zzebs, ScheduledExecutorService {
    private final ScheduledExecutorService zzidx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebw(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.zzidx = (ScheduledExecutorService) zzdyi.checkNotNull(scheduledExecutorService);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzeby zzebyVar = new zzeby(runnable);
        return new zzebz(zzebyVar, this.zzidx.scheduleWithFixedDelay(zzebyVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzeby zzebyVar = new zzeby(runnable);
        return new zzebz(zzebyVar, this.zzidx.scheduleAtFixedRate(zzebyVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzece zzf = zzece.zzf(callable);
        return new zzebz(zzf, this.zzidx.schedule(zzf, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzece zza = zzece.zza(runnable, (Object) null);
        return new zzebz(zza, this.zzidx.schedule(zza, j, timeUnit));
    }
}

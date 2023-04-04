package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
class zzebx extends zzeai {
    private final ExecutorService zzidy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebx(ExecutorService executorService) {
        this.zzidy = (ExecutorService) zzdyi.checkNotNull(executorService);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.zzidy.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.zzidy.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.zzidy.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.zzidy.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.zzidy.shutdownNow();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zzidy.execute(runnable);
    }
}

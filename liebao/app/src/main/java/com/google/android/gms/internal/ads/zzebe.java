package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzebe<V> extends zzebc<V> {
    private final zzebt<V> zzidn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebe(zzebt<V> zzebtVar) {
        this.zzidn = (zzebt) zzdyi.checkNotNull(zzebtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeah, com.google.android.gms.internal.ads.zzebt
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzidn.addListener(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzeah, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zzidn.cancel(z);
    }

    @Override // com.google.android.gms.internal.ads.zzeah, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzidn.isCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzeah, java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzidn.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzeah, java.util.concurrent.Future
    public final V get() {
        return this.zzidn.get();
    }

    @Override // com.google.android.gms.internal.ads.zzeah, java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) {
        return this.zzidn.get(j, timeUnit);
    }

    @Override // com.google.android.gms.internal.ads.zzeah
    public final String toString() {
        return this.zzidn.toString();
    }
}

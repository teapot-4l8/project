package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzebd<V> extends zzdyt implements Future<V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdyt
    /* renamed from: zzbbc */
    public abstract Future<? extends V> zzbae();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return zzbae().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return zzbae().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return zzbae().isDone();
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return zzbae().get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        return zzbae().get(j, timeUnit);
    }
}

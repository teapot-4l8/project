package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbbe<T> implements zzebt<T> {
    private final zzecb<T> zzekp = zzecb.zzbbf();

    public final boolean set(T t) {
        return zzaw(this.zzekp.set(t));
    }

    public final boolean setException(Throwable th) {
        return zzaw(this.zzekp.setException(th));
    }

    private static boolean zzaw(boolean z) {
        if (!z) {
            com.google.android.gms.ads.internal.zzr.zzkz().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzebt
    public void addListener(Runnable runnable, Executor executor) {
        this.zzekp.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.zzekp.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.zzekp.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.zzekp.isDone();
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return this.zzekp.get();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return this.zzekp.get(j, timeUnit);
    }
}

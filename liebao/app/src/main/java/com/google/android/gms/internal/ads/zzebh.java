package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebn;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzebh extends zzebo {
    public static <V> zzebt<V> zzag(@NullableDecl V v) {
        if (v == null) {
            return (zzebt<V>) zzebn.zzidr;
        }
        return new zzebn(v);
    }

    public static <V> zzebt<V> immediateFailedFuture(Throwable th) {
        zzdyi.checkNotNull(th);
        return new zzebn.zza(th);
    }

    public static <O> zzebt<O> zza(Callable<O> callable, Executor executor) {
        zzece zzf = zzece.zzf(callable);
        executor.execute(zzf);
        return zzf;
    }

    public static <O> zzebt<O> zza(zzeas<O> zzeasVar, Executor executor) {
        zzece zzeceVar = new zzece(zzeasVar);
        executor.execute(zzeceVar);
        return zzeceVar;
    }

    public static <V, X extends Throwable> zzebt<V> zzb(zzebt<? extends V> zzebtVar, Class<X> cls, zzear<? super X, ? extends V> zzearVar, Executor executor) {
        return zzead.zza(zzebtVar, cls, zzearVar, executor);
    }

    public static <V> zzebt<V> zza(zzebt<V> zzebtVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzebtVar.isDone() ? zzebtVar : zzeca.zzb(zzebtVar, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzebt<O> zzb(zzebt<I> zzebtVar, zzear<? super I, ? extends O> zzearVar, Executor executor) {
        return zzeak.zza(zzebtVar, zzearVar, executor);
    }

    public static <I, O> zzebt<O> zzb(zzebt<I> zzebtVar, zzdxw<? super I, ? extends O> zzdxwVar, Executor executor) {
        return zzeak.zza(zzebtVar, zzdxwVar, executor);
    }

    public static <V> zzebt<List<V>> zzi(Iterable<? extends zzebt<? extends V>> iterable) {
        return new zzeat(zzdza.zzh(iterable), true);
    }

    @SafeVarargs
    public static <V> zzebm<V> zza(zzebt<? extends V>... zzebtVarArr) {
        return new zzebm<>(false, zzdza.zzb(zzebtVarArr), null);
    }

    public static <V> zzebm<V> zzj(Iterable<? extends zzebt<? extends V>> iterable) {
        return new zzebm<>(false, zzdza.zzh(iterable), null);
    }

    @SafeVarargs
    public static <V> zzebm<V> zzb(zzebt<? extends V>... zzebtVarArr) {
        return new zzebm<>(true, zzdza.zzb(zzebtVarArr), null);
    }

    public static <V> zzebm<V> zzk(Iterable<? extends zzebt<? extends V>> iterable) {
        return new zzebm<>(true, zzdza.zzh(iterable), null);
    }

    public static <V> void zza(zzebt<V> zzebtVar, zzebi<? super V> zzebiVar, Executor executor) {
        zzdyi.checkNotNull(zzebiVar);
        zzebtVar.addListener(new zzebj(zzebtVar, zzebiVar), executor);
    }

    public static <V> V zza(Future<V> future) {
        if (!future.isDone()) {
            throw new IllegalStateException(zzdyq.zzb("Future was expected to be done: %s", future));
        }
        return (V) zzeci.getUninterruptibly(future);
    }

    public static <V> V zzb(Future<V> future) {
        zzdyi.checkNotNull(future);
        try {
            return (V) zzeci.getUninterruptibly(future);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new zzeaz((Error) cause);
            }
            throw new zzecj(cause);
        }
    }
}

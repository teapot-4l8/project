package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzebc<V> extends zzebl<V> {
    public static <V> zzebc<V> zzg(zzebt<V> zzebtVar) {
        if (zzebtVar instanceof zzebc) {
            return (zzebc) zzebtVar;
        }
        return new zzebe(zzebtVar);
    }

    public final <X extends Throwable> zzebc<V> zza(Class<X> cls, zzdxw<? super X, ? extends V> zzdxwVar, Executor executor) {
        zzeaf zzeafVar = new zzeaf(this, cls, zzdxwVar);
        addListener(zzeafVar, zzebv.zza(executor, zzeafVar));
        return zzeafVar;
    }

    public final <X extends Throwable> zzebc<V> zza(Class<X> cls, zzear<? super X, ? extends V> zzearVar, Executor executor) {
        zzeag zzeagVar = new zzeag(this, cls, zzearVar);
        addListener(zzeagVar, zzebv.zza(executor, zzeagVar));
        return zzeagVar;
    }

    public final zzebc<V> zza(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (zzebc) zzebh.zza(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> zzebc<T> zzb(zzear<? super V, T> zzearVar, Executor executor) {
        zzdyi.checkNotNull(executor);
        zzeaj zzeajVar = new zzeaj(this, zzearVar);
        addListener(zzeajVar, zzebv.zza(executor, zzeajVar));
        return zzeajVar;
    }

    public final <T> zzebc<T> zza(zzdxw<? super V, T> zzdxwVar, Executor executor) {
        zzdyi.checkNotNull(zzdxwVar);
        zzeam zzeamVar = new zzeam(this, zzdxwVar);
        addListener(zzeamVar, zzebv.zza(executor, zzeamVar));
        return zzeamVar;
    }
}

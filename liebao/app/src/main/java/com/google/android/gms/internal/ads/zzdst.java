package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdst<E, V> implements zzebt<V> {
    private final E zzhsw;
    private final String zzhsx;
    private final zzebt<V> zzhsy;

    public zzdst(E e2, String str, zzebt<V> zzebtVar) {
        this.zzhsw = e2;
        this.zzhsx = str;
        this.zzhsy = zzebtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebt
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhsy.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zzhsy.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        return this.zzhsy.get();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) {
        return this.zzhsy.get(j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzhsy.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzhsy.isDone();
    }

    public final E zzayg() {
        return this.zzhsw;
    }

    public final String zzayh() {
        return this.zzhsx;
    }

    public final String toString() {
        String str = this.zzhsx;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }
}

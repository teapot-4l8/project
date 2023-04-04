package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbzl<T> {
    public Executor executor;
    public T zzgdh;

    public static <T> zzbzl<T> zzb(T t, Executor executor) {
        return new zzbzl<>(t, executor);
    }

    public zzbzl(T t, Executor executor) {
        this.zzgdh = t;
        this.executor = executor;
    }
}

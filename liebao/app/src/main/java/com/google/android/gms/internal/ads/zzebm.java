package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzebm<V> {
    private final boolean zzicu;
    private final zzdza<zzebt<? extends V>> zzidq;

    private zzebm(boolean z, zzdza<zzebt<? extends V>> zzdzaVar) {
        this.zzicu = z;
        this.zzidq = zzdzaVar;
    }

    public final <C> zzebt<C> zzb(Callable<C> callable, Executor executor) {
        return new zzeav(this.zzidq, this.zzicu, executor, callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzebm(boolean z, zzdza zzdzaVar, zzebk zzebkVar) {
        this(z, zzdzaVar);
    }
}

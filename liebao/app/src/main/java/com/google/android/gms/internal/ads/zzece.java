package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzece<V> extends zzebb<V> implements RunnableFuture<V> {
    private volatile zzebp<?> zziee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> zzece<V> zzf(Callable<V> callable) {
        return new zzece<>(callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> zzece<V> zza(Runnable runnable, @NullableDecl V v) {
        return new zzece<>(Executors.callable(runnable, v));
    }

    private zzece(Callable<V> callable) {
        this.zziee = new zzecg(this, callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzece(zzeas<V> zzeasVar) {
        this.zziee = new zzech(this, zzeasVar);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzebp<?> zzebpVar = this.zziee;
        if (zzebpVar != null) {
            zzebpVar.run();
        }
        this.zziee = null;
    }

    @Override // com.google.android.gms.internal.ads.zzeah
    protected final void afterDone() {
        zzebp<?> zzebpVar;
        super.afterDone();
        if (wasInterrupted() && (zzebpVar = this.zziee) != null) {
            zzebpVar.interruptTask();
        }
        this.zziee = null;
    }

    @Override // com.google.android.gms.internal.ads.zzeah
    protected final String pendingToString() {
        zzebp<?> zzebpVar = this.zziee;
        if (zzebpVar != null) {
            String valueOf = String.valueOf(zzebpVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
            sb.append("task=[");
            sb.append(valueOf);
            sb.append("]");
            return sb.toString();
        }
        return super.pendingToString();
    }
}

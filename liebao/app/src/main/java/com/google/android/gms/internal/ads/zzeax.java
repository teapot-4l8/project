package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzeax<T> extends zzebp<T> {
    private final Executor zzidi;
    private final /* synthetic */ zzeav zzidj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeax(zzeav zzeavVar, Executor executor) {
        this.zzidj = zzeavVar;
        this.zzidi = (Executor) zzdyi.checkNotNull(executor);
    }

    abstract void setValue(T t);

    @Override // com.google.android.gms.internal.ads.zzebp
    final boolean isDone() {
        return this.zzidj.isDone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void execute() {
        try {
            this.zzidi.execute(this);
        } catch (RejectedExecutionException e2) {
            this.zzidj.setException(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebp
    final void zzb(T t, Throwable th) {
        this.zzidj.zzidh = null;
        if (th != null) {
            if (th instanceof ExecutionException) {
                this.zzidj.setException(th.getCause());
                return;
            } else if (th instanceof CancellationException) {
                this.zzidj.cancel(false);
                return;
            } else {
                this.zzidj.setException(th);
                return;
            }
        }
        setValue(t);
    }
}

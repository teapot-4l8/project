package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzebu implements Executor {
    private final /* synthetic */ Executor zzidv;
    private final /* synthetic */ zzeah zzidw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebu(Executor executor, zzeah zzeahVar) {
        this.zzidv = executor;
        this.zzidw = zzeahVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zzidv.execute(runnable);
        } catch (RejectedExecutionException e2) {
            this.zzidw.setException(e2);
        }
    }
}

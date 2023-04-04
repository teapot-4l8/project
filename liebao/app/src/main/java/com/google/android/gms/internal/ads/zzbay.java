package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbay implements Executor {
    private final Handler zzekm = new com.google.android.gms.ads.internal.util.zzg(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzr.zzkv();
                com.google.android.gms.ads.internal.util.zzj.zza(com.google.android.gms.ads.internal.zzr.zzkz().getApplicationContext(), th);
                throw th;
            }
        }
        this.zzekm.post(runnable);
    }
}

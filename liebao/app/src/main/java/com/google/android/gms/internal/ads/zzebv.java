package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzebv {
    public static Executor zzbbe() {
        return zzeba.INSTANCE;
    }

    public static zzebs zza(ExecutorService executorService) {
        if (executorService instanceof zzebs) {
            return (zzebs) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new zzebw((ScheduledExecutorService) executorService);
        }
        return new zzebx(executorService);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor zza(Executor executor, zzeah<?> zzeahVar) {
        zzdyi.checkNotNull(executor);
        zzdyi.checkNotNull(zzeahVar);
        return executor == zzeba.INSTANCE ? executor : new zzebu(executor, zzeahVar);
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbat {
    public static final zzebs zzeke;
    public static final zzebs zzekf;
    public static final zzebs zzekg;
    public static final ScheduledExecutorService zzekh;
    public static final zzebs zzeki;
    public static final zzebs zzekj;

    private static ThreadFactory zzfc(String str) {
        return new zzbav(str);
    }

    private static zzebs zza(Executor executor) {
        return new zzbax(executor, null);
    }

    static {
        ExecutorService threadPoolExecutor;
        ExecutorService threadPoolExecutor2;
        ExecutorService threadPoolExecutor3;
        if (ClientLibraryUtils.isPackageSide()) {
            threadPoolExecutor = zzdxa.zzazw().zza(zzfc("Default"), zzdxj.zzhyj);
        } else {
            threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), zzfc("Default"));
        }
        zzeke = zza(threadPoolExecutor);
        if (ClientLibraryUtils.isPackageSide()) {
            threadPoolExecutor2 = zzdxa.zzazw().zza(5, zzfc("Loader"), zzdxj.zzhyi);
        } else {
            threadPoolExecutor2 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfc("Loader"));
            ((ThreadPoolExecutor) threadPoolExecutor2).allowCoreThreadTimeOut(true);
        }
        zzekf = zza(threadPoolExecutor2);
        if (ClientLibraryUtils.isPackageSide()) {
            threadPoolExecutor3 = zzdxa.zzazw().zzb(zzfc("Activeview"), zzdxj.zzhyi);
        } else {
            threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfc("Activeview"));
            ((ThreadPoolExecutor) threadPoolExecutor3).allowCoreThreadTimeOut(true);
        }
        zzekg = zza(threadPoolExecutor3);
        zzekh = new zzbaw(3, zzfc("Schedule"));
        zzeki = zza(new zzbay());
        zzekj = zza(zzebv.zzbbe());
    }
}

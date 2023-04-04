package cn.jiguang.ba;

import cn.jiguang.an.d;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, ExecutorService> f4039a = new HashMap<>();

    private static ExecutorService a(String str) {
        ExecutorService executorService;
        ExecutorService executorService2 = f4039a.get(str);
        if (executorService2 == null || executorService2.isShutdown()) {
            synchronized (a.class) {
                executorService = f4039a.get(str);
                if (executorService == null || executorService.isShutdown()) {
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case -1649445006:
                            if (str.equals("TCP_REPORT")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -1642909390:
                            if (str.equals("UPLOAD_REPORT")) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case -788009879:
                            if (str.equals("REPORT_HISTORY")) {
                                c2 = '\b';
                                break;
                            }
                            break;
                        case -501390267:
                            if (str.equals("BUILD_REPORT")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 62589532:
                            if (str.equals("ASYNC")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1082250773:
                            if (str.equals("SDK_INIT")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1082357438:
                            if (str.equals("SDK_MAIN")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 1350548607:
                            if (str.equals("SDK_SERVICE_INIT")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 1925345846:
                            if (str.equals("ACTION")) {
                                c2 = 5;
                                break;
                            }
                            break;
                    }
                    executorService = c2 != 0 ? c2 != 1 ? Executors.newSingleThreadExecutor() : Executors.newFixedThreadPool(3) : Executors.newFixedThreadPool(15);
                    f4039a.put(str, executorService);
                }
            }
            return executorService;
        }
        return executorService2;
    }

    public static void a(String str, Runnable runnable) {
        ExecutorService executorService;
        try {
            executorService = a(str);
        } catch (Throwable th) {
            th = th;
            executorService = null;
        }
        try {
            executorService.execute(runnable);
        } catch (Throwable th2) {
            th = th2;
            d.h("SDKWorker_XExecutor", "execute failed, try again e:" + th);
            if (executorService != null) {
                try {
                    executorService.shutdown();
                    if (!executorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
                        executorService.shutdownNow();
                        if (!executorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
                            d.a("SDKWorker_XExecutor", "executor did not terminate");
                        }
                    }
                } catch (InterruptedException unused) {
                    executorService.shutdownNow();
                    d.a("SDKWorker_XExecutor", "current thread is interrupted by self");
                    Thread.currentThread().interrupt();
                } catch (Throwable th3) {
                    d.f("SDKWorker_XExecutor", "shutDown e:" + th3);
                }
            }
            try {
                a(str).execute(runnable);
            } catch (Throwable unused2) {
                d.h("SDKWorker_XExecutor", "execute e:" + th);
                if (runnable != null) {
                    try {
                        if (str.equals("BUILD_REPORT")) {
                            new Thread(runnable).start();
                        }
                    } catch (Throwable th4) {
                        d.c("SDKWorker_XExecutor", "execute BUILD_REPORT last error", th4);
                    }
                }
            }
        }
    }
}

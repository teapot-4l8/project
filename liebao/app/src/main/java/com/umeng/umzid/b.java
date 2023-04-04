package com.umeng.umzid;

import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f6980a;

    /* renamed from: b  reason: collision with root package name */
    public static ThreadFactory f6981b = new a();

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public AtomicInteger f6982a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f6982a.addAndGet(1));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f6980a == null) {
            synchronized (b.class) {
                if (f6980a == null) {
                    f6980a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f6981b);
                }
            }
        }
        return f6980a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable unused) {
            Log.e("com.umeng.umzid.b", "UmengThreadPoolExecutorFactory execute exception");
        }
    }
}

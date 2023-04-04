package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f6262a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static w f6263b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledExecutorService f6264c;

    protected w() {
        this.f6264c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory(this) { // from class: com.tencent.bugly.proguard.w.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + w.f6262a.getAndIncrement());
                return thread;
            }
        });
        this.f6264c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            x.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (f6263b == null) {
                f6263b = new w();
            }
            wVar = f6263b;
        }
        return wVar;
    }

    public final synchronized boolean a(Runnable runnable, long j) {
        if (!c()) {
            x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            if (j <= 0) {
                j = 0;
            }
            x.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
            this.f6264c.schedule(runnable, j, TimeUnit.MILLISECONDS);
            return true;
        }
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            x.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            this.f6264c.execute(runnable);
            return true;
        }
    }

    public final synchronized void b() {
        if (this.f6264c != null && !this.f6264c.isShutdown()) {
            x.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f6264c.shutdownNow();
        }
    }

    public final synchronized boolean c() {
        boolean z;
        if (this.f6264c != null) {
            z = this.f6264c.isShutdown() ? false : true;
        }
        return z;
    }
}

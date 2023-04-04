package com.bumptech.glide.c.b.c;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
public final class a implements ExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private static final long f4752a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f4753b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f4754c;

    /* compiled from: GlideExecutor.java */
    /* loaded from: classes.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f4760a = new b() { // from class: com.bumptech.glide.c.b.c.a.b.1
            @Override // com.bumptech.glide.c.b.c.a.b
            public void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final b f4761b = new b() { // from class: com.bumptech.glide.c.b.c.a.b.2
            @Override // com.bumptech.glide.c.b.c.a.b
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        public static final b f4762c = new b() { // from class: com.bumptech.glide.c.b.c.a.b.3
            @Override // com.bumptech.glide.c.b.c.a.b
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public static final b f4763d = f4761b;

        void a(Throwable th);
    }

    public static a a() {
        return a(1, "disk-cache", b.f4763d);
    }

    public static a a(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0087a(str, bVar, true)));
    }

    public static a b() {
        return b(e(), "source", b.f4763d);
    }

    public static a b(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0087a(str, bVar, false)));
    }

    public static a c() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f4752a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0087a("source-unlimited", b.f4763d, false)));
    }

    public static a d() {
        return a(e() >= 4 ? 2 : 1, b.f4763d);
    }

    public static a a(int i, b bVar) {
        return new a(new ThreadPoolExecutor(0, i, f4752a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0087a("animation", bVar, true)));
    }

    a(ExecutorService executorService) {
        this.f4754c = executorService;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4754c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f4754c.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f4754c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.f4754c.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f4754c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return (T) this.f4754c.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f4754c.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f4754c.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f4754c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f4754c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f4754c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f4754c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f4754c.awaitTermination(j, timeUnit);
    }

    public String toString() {
        return this.f4754c.toString();
    }

    public static int e() {
        if (f4753b == 0) {
            f4753b = Math.min(4, com.bumptech.glide.c.b.c.b.a());
        }
        return f4753b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.c.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class ThreadFactoryC0087a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final b f4755a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f4756b;

        /* renamed from: c  reason: collision with root package name */
        private final String f4757c;

        /* renamed from: d  reason: collision with root package name */
        private int f4758d;

        ThreadFactoryC0087a(String str, b bVar, boolean z) {
            this.f4757c = str;
            this.f4755a = bVar;
            this.f4756b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-" + this.f4757c + "-thread-" + this.f4758d) { // from class: com.bumptech.glide.c.b.c.a.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(9);
                    if (ThreadFactoryC0087a.this.f4756b) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        ThreadFactoryC0087a.this.f4755a.a(th);
                    }
                }
            };
            this.f4758d = this.f4758d + 1;
            return thread;
        }
    }
}

package androidx.loader.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ModernAsyncTask.java */
/* loaded from: classes.dex */
abstract class d<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadFactory f2072a = new ThreadFactory() { // from class: androidx.loader.b.d.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f2077a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f2077a.getAndIncrement());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f2073b = new LinkedBlockingQueue(10);

    /* renamed from: c  reason: collision with root package name */
    public static final Executor f2074c;
    private static b f;
    private static volatile Executor g;
    private volatile c j = c.PENDING;

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f2075d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f2076e = new AtomicBoolean();
    private final AbstractCallableC0051d<Params, Result> h = new AbstractCallableC0051d<Params, Result>() { // from class: androidx.loader.b.d.2
        @Override // java.util.concurrent.Callable
        public Result call() {
            d.this.f2076e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) d.this.a((Object[]) this.f2087b);
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    };
    private final FutureTask<Result> i = new FutureTask<Result>(this.h) { // from class: androidx.loader.b.d.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                d.this.c(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException unused) {
                d.this.c(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public enum c {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result a(Params... paramsArr);

    protected void a() {
    }

    protected void a(Result result) {
    }

    protected void b() {
    }

    protected void b(Progress... progressArr) {
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, f2073b, f2072a);
        f2074c = threadPoolExecutor;
        g = threadPoolExecutor;
    }

    private static Handler d() {
        b bVar;
        synchronized (d.class) {
            if (f == null) {
                f = new b();
            }
            bVar = f;
        }
        return bVar;
    }

    void c(Result result) {
        if (this.f2076e.get()) {
            return;
        }
        d(result);
    }

    Result d(Result result) {
        d().obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    protected void b(Result result) {
        b();
    }

    public final boolean c() {
        return this.f2075d.get();
    }

    public final boolean a(boolean z) {
        this.f2075d.set(true);
        return this.i.cancel(z);
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: androidx.loader.b.d$4  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2080a;

        static {
            int[] iArr = new int[c.values().length];
            f2080a = iArr;
            try {
                iArr[c.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2080a[c.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final d<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.j != c.PENDING) {
            int i = AnonymousClass4.f2080a[this.j.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
                throw new IllegalStateException("We should never reach this state");
            }
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        this.j = c.RUNNING;
        a();
        this.h.f2087b = paramsArr;
        executor.execute(this.i);
        return this;
    }

    void e(Result result) {
        if (c()) {
            b((d<Params, Progress, Result>) result);
        } else {
            a((d<Params, Progress, Result>) result);
        }
        this.j = c.FINISHED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public static class b extends Handler {
        b() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.f2081a.e(aVar.f2082b[0]);
            } else if (i != 2) {
            } else {
                aVar.f2081a.b((Object[]) aVar.f2082b);
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: androidx.loader.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static abstract class AbstractCallableC0051d<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        Params[] f2087b;

        AbstractCallableC0051d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        final d f2081a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f2082b;

        a(d dVar, Data... dataArr) {
            this.f2081a = dVar;
            this.f2082b = dataArr;
        }
    }
}

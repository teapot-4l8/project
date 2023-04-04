package androidx.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f486a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f487b = Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: androidx.a.a.a.b.1

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f490b = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f490b.getAndIncrement())));
            return thread;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f488c;

    @Override // androidx.a.a.a.c
    public void a(Runnable runnable) {
        this.f487b.execute(runnable);
    }

    @Override // androidx.a.a.a.c
    public void b(Runnable runnable) {
        if (this.f488c == null) {
            synchronized (this.f486a) {
                if (this.f488c == null) {
                    this.f488c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f488c.post(runnable);
    }

    @Override // androidx.a.a.a.c
    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}

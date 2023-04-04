package androidx.work.impl.background.systemalarm;

import androidx.work.h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: WorkTimer.java */
/* loaded from: classes.dex */
class g {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2935d = h.a("WorkTimer");

    /* renamed from: e  reason: collision with root package name */
    private final ThreadFactory f2939e = new ThreadFactory() { // from class: androidx.work.impl.background.systemalarm.g.1

        /* renamed from: b  reason: collision with root package name */
        private int f2941b = 0;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.f2941b);
            this.f2941b = this.f2941b + 1;
            return newThread;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final Map<String, b> f2936a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<String, a> f2937b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Object f2938c = new Object();
    private final ScheduledExecutorService f = Executors.newSingleThreadScheduledExecutor(this.f2939e);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WorkTimer.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, long j, a aVar) {
        synchronized (this.f2938c) {
            h.a().b(f2935d, String.format("Starting timer for %s", str), new Throwable[0]);
            a(str);
            b bVar = new b(this, str);
            this.f2936a.put(str, bVar);
            this.f2937b.put(str, aVar);
            this.f.schedule(bVar, j, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        synchronized (this.f2938c) {
            if (this.f2936a.remove(str) != null) {
                h.a().b(f2935d, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f2937b.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f.isShutdown()) {
            return;
        }
        this.f.shutdownNow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WorkTimer.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final g f2942a;

        /* renamed from: b  reason: collision with root package name */
        private final String f2943b;

        b(g gVar, String str) {
            this.f2942a = gVar;
            this.f2943b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f2942a.f2938c) {
                if (this.f2942a.f2936a.remove(this.f2943b) != null) {
                    a remove = this.f2942a.f2937b.remove(this.f2943b);
                    if (remove != null) {
                        remove.a(this.f2943b);
                    }
                } else {
                    h.a().b("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f2943b), new Throwable[0]);
                }
            }
        }
    }
}

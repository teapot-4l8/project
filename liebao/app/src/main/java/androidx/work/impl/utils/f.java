package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: SerialExecutor.java */
/* loaded from: classes.dex */
public class f implements Executor {

    /* renamed from: b  reason: collision with root package name */
    private final Executor f3046b;

    /* renamed from: d  reason: collision with root package name */
    private volatile Runnable f3048d;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<a> f3045a = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final Object f3047c = new Object();

    public f(Executor executor) {
        this.f3046b = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.f3047c) {
            this.f3045a.add(new a(this, runnable));
            if (this.f3048d == null) {
                a();
            }
        }
    }

    void a() {
        synchronized (this.f3047c) {
            a poll = this.f3045a.poll();
            this.f3048d = poll;
            if (poll != null) {
                this.f3046b.execute(this.f3048d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SerialExecutor.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final f f3049a;

        /* renamed from: b  reason: collision with root package name */
        final Runnable f3050b;

        a(f fVar, Runnable runnable) {
            this.f3049a = fVar;
            this.f3050b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f3050b.run();
            } finally {
                this.f3049a.a();
            }
        }
    }
}

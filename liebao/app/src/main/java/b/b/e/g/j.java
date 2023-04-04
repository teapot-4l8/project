package b.b.e.g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ScheduledRunnable.java */
/* loaded from: classes.dex */
public final class j extends AtomicReferenceArray<Object> implements b.b.b.b, Runnable, Callable<Object> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f3449b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final Object f3450c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final Object f3451d = new Object();

    /* renamed from: e  reason: collision with root package name */
    static final Object f3452e = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Runnable f3453a;

    public j(Runnable runnable, b.b.e.a.a aVar) {
        super(3);
        this.f3453a = runnable;
        lazySet(0, aVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.f3453a.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != f3449b) {
                    ((b.b.e.a.a) obj4).c(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != f3450c) {
                        return;
                    }
                    return;
                } while (!compareAndSet(1, obj5, f3452e));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != f3449b && compareAndSet(0, obj4, f3452e) && obj4 != null) {
            ((b.b.e.a.a) obj4).c(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != f3450c || obj5 == f3451d) {
                return;
            }
        } while (!compareAndSet(1, obj5, f3452e));
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f3452e) {
                return;
            }
            if (obj == f3450c) {
                future.cancel(false);
                return;
            } else if (obj == f3451d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // b.b.b.b
    public void a() {
        Object obj;
        Object obj2;
        while (true) {
            Object obj3 = get(1);
            if (obj3 == f3452e || obj3 == f3450c || obj3 == f3451d) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (compareAndSet(1, obj3, z ? f3451d : f3450c)) {
                if (obj3 != null) {
                    ((Future) obj3).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f3452e || obj == (obj2 = f3449b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((b.b.e.a.a) obj).c(this);
    }
}

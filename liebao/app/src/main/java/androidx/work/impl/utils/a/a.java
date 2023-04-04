package androidx.work.impl.utils.a;

import com.google.common.util.concurrent.ListenableFuture;
import com.tencent.bugly.Bugly;
import com.umeng.analytics.pro.ak;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: AbstractFuture.java */
/* loaded from: classes.dex */
public abstract class a<V> implements ListenableFuture<V> {

    /* renamed from: b  reason: collision with root package name */
    static final AbstractC0062a f3006b;
    private static final Object g;

    /* renamed from: c  reason: collision with root package name */
    volatile Object f3007c;

    /* renamed from: d  reason: collision with root package name */
    volatile d f3008d;

    /* renamed from: e  reason: collision with root package name */
    volatile h f3009e;

    /* renamed from: a  reason: collision with root package name */
    static final boolean f3005a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", Bugly.SDK_IS_DEV));
    private static final Logger f = Logger.getLogger(a.class.getName());

    protected void a() {
    }

    protected void b() {
    }

    static {
        AbstractC0062a gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, ak.aF), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "e"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "d"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, ak.aF));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f3006b = gVar;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        g = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        static final h f3027a = new h(false);

        /* renamed from: b  reason: collision with root package name */
        volatile Thread f3028b;

        /* renamed from: c  reason: collision with root package name */
        volatile h f3029c;

        h(boolean z) {
        }

        h() {
            a.f3006b.a(this, Thread.currentThread());
        }

        void a(h hVar) {
            a.f3006b.a(this, hVar);
        }

        void a() {
            Thread thread = this.f3028b;
            if (thread != null) {
                this.f3028b = null;
                LockSupport.unpark(thread);
            }
        }
    }

    private void a(h hVar) {
        hVar.f3028b = null;
        while (true) {
            h hVar2 = this.f3009e;
            if (hVar2 == h.f3027a) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f3029c;
                if (hVar2.f3028b != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f3029c = hVar4;
                    if (hVar3.f3028b == null) {
                        break;
                    }
                } else if (!f3006b.a((a<?>) this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final d f3016a = new d(null, null);

        /* renamed from: b  reason: collision with root package name */
        final Runnable f3017b;

        /* renamed from: c  reason: collision with root package name */
        final Executor f3018c;

        /* renamed from: d  reason: collision with root package name */
        d f3019d;

        d(Runnable runnable, Executor executor) {
            this.f3017b = runnable;
            this.f3018c = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final c f3014a = new c(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.a.a.c.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: b  reason: collision with root package name */
        final Throwable f3015b;

        c(Throwable th) {
            this.f3015b = (Throwable) a.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final b f3010a;

        /* renamed from: b  reason: collision with root package name */
        static final b f3011b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f3012c;

        /* renamed from: d  reason: collision with root package name */
        final Throwable f3013d;

        static {
            if (a.f3005a) {
                f3011b = null;
                f3010a = null;
                return;
            }
            f3011b = new b(false, null);
            f3010a = new b(true, null);
        }

        b(boolean z, Throwable th) {
            this.f3012c = z;
            this.f3013d = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class f<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final a<V> f3025a;

        /* renamed from: b  reason: collision with root package name */
        final ListenableFuture<? extends V> f3026b;

        f(a<V> aVar, ListenableFuture<? extends V> listenableFuture) {
            this.f3025a = aVar;
            this.f3026b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3025a.f3007c != this) {
                return;
            }
            if (a.f3006b.a((a<?>) this.f3025a, (Object) this, a.b((ListenableFuture<?>) this.f3026b))) {
                a.a((a<?>) this.f3025a);
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f3007c;
        if ((obj != null) & (!(obj instanceof f))) {
            return c(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f3009e;
            if (hVar != h.f3027a) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f3006b.a((a<?>) this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                a(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f3007c;
                            if ((obj2 != null) & (!(obj2 instanceof f))) {
                                return c(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        a(hVar2);
                    } else {
                        hVar = this.f3009e;
                    }
                } while (hVar != h.f3027a);
                return c(this.f3007c);
            }
            return c(this.f3007c);
        }
        while (nanos > 0) {
            Object obj3 = this.f3007c;
            if ((obj3 != null) & (!(obj3 instanceof f))) {
                return c(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + aVar);
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f3007c;
        if ((obj2 != null) & (!(obj2 instanceof f))) {
            return c(obj2);
        }
        h hVar = this.f3009e;
        if (hVar != h.f3027a) {
            h hVar2 = new h();
            do {
                hVar2.a(hVar);
                if (f3006b.a((a<?>) this, hVar, hVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            a(hVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f3007c;
                    } while (!((obj != null) & (!(obj instanceof f))));
                    return c(obj);
                }
                hVar = this.f3009e;
            } while (hVar != h.f3027a);
            return c(this.f3007c);
        }
        return c(this.f3007c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V c(Object obj) {
        if (obj instanceof b) {
            throw a("Task was cancelled.", ((b) obj).f3013d);
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f3015b);
        }
        if (obj == g) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f3007c;
        return (!(obj instanceof f)) & (obj != null);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f3007c instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.f3007c;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        b bVar = f3005a ? new b(z, new CancellationException("Future.cancel() was called.")) : z ? b.f3010a : b.f3011b;
        boolean z2 = false;
        a<V> aVar = this;
        while (true) {
            if (f3006b.a((a<?>) aVar, obj, (Object) bVar)) {
                if (z) {
                    aVar.a();
                }
                a((a<?>) aVar);
                if (!(obj instanceof f)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((f) obj).f3026b;
                if (listenableFuture instanceof a) {
                    aVar = (a) listenableFuture;
                    obj = aVar.f3007c;
                    if (!(obj == null) && !(obj instanceof f)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj = aVar.f3007c;
                if (!(obj instanceof f)) {
                    return z2;
                }
            }
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        b(runnable);
        b(executor);
        d dVar = this.f3008d;
        if (dVar != d.f3016a) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f3019d = dVar;
                if (f3006b.a((a<?>) this, dVar, dVar2)) {
                    return;
                }
                dVar = this.f3008d;
            } while (dVar != d.f3016a);
            a(runnable, executor);
        }
        a(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(V v) {
        if (v == null) {
            v = (V) g;
        }
        if (f3006b.a((a<?>) this, (Object) null, (Object) v)) {
            a((a<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Throwable th) {
        if (f3006b.a((a<?>) this, (Object) null, (Object) new c((Throwable) b(th)))) {
            a((a<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ListenableFuture<? extends V> listenableFuture) {
        c cVar;
        b(listenableFuture);
        Object obj = this.f3007c;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (f3006b.a((a<?>) this, (Object) null, b((ListenableFuture<?>) listenableFuture))) {
                    a((a<?>) this);
                    return true;
                }
                return false;
            }
            f fVar = new f(this, listenableFuture);
            if (f3006b.a((a<?>) this, (Object) null, (Object) fVar)) {
                try {
                    listenableFuture.addListener(fVar, androidx.work.impl.utils.a.b.INSTANCE);
                } catch (Throwable th) {
                    try {
                        cVar = new c(th);
                    } catch (Throwable unused) {
                        cVar = c.f3014a;
                    }
                    f3006b.a((a<?>) this, (Object) fVar, (Object) cVar);
                }
                return true;
            }
            obj = this.f3007c;
        }
        if (obj instanceof b) {
            listenableFuture.cancel(((b) obj).f3012c);
        }
        return false;
    }

    static Object b(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof a) {
            Object obj = ((a) listenableFuture).f3007c;
            if (obj instanceof b) {
                b bVar = (b) obj;
                return bVar.f3012c ? bVar.f3013d != null ? new b(false, bVar.f3013d) : b.f3011b : obj;
            }
            return obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f3005a) & isCancelled) {
            return b.f3011b;
        }
        try {
            Object a2 = a((Future<Object>) listenableFuture);
            return a2 == null ? g : a2;
        } catch (CancellationException e2) {
            if (!isCancelled) {
                return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e2));
            }
            return new b(false, e2);
        } catch (ExecutionException e3) {
            return new c(e3.getCause());
        } catch (Throwable th) {
            return new c(th);
        }
    }

    private static <V> V a(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.work.impl.utils.a.a$a] */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.work.impl.utils.a.a<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.work.impl.utils.a.a] */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.work.impl.utils.a.a, androidx.work.impl.utils.a.a<V>] */
    static void a(a<?> aVar) {
        d dVar = null;
        while (true) {
            aVar.d();
            aVar.b();
            d a2 = aVar.a(dVar);
            while (a2 != null) {
                dVar = a2.f3019d;
                Runnable runnable = a2.f3017b;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    aVar = fVar.f3025a;
                    if (aVar.f3007c == fVar) {
                        if (f3006b.a(aVar, fVar, b((ListenableFuture<?>) fVar.f3026b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    a(runnable, a2.f3018c);
                }
                a2 = dVar;
            }
            return;
        }
    }

    private void d() {
        h hVar;
        do {
            hVar = this.f3009e;
        } while (!f3006b.a((a<?>) this, hVar, h.f3027a));
        while (hVar != null) {
            hVar.a();
            hVar = hVar.f3029c;
        }
    }

    private d a(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f3008d;
        } while (!f3006b.a((a<?>) this, dVar2, d.f3016a));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f3019d;
            dVar4.f3019d = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = c();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected String c() {
        Object obj = this.f3007c;
        if (obj instanceof f) {
            return "setFuture=[" + d(((f) obj).f3026b) + "]";
        } else if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        } else {
            return null;
        }
    }

    private void a(StringBuilder sb) {
        try {
            Object a2 = a((Future<Object>) this);
            sb.append("SUCCESS, result=[");
            sb.append(d(a2));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private String d(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    private static void a(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* renamed from: androidx.work.impl.utils.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0062a {
        abstract void a(h hVar, h hVar2);

        abstract void a(h hVar, Thread thread);

        abstract boolean a(a<?> aVar, d dVar, d dVar2);

        abstract boolean a(a<?> aVar, h hVar, h hVar2);

        abstract boolean a(a<?> aVar, Object obj, Object obj2);

        private AbstractC0062a() {
        }
    }

    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    private static final class e extends AbstractC0062a {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, Thread> f3020a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, h> f3021b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, h> f3022c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, d> f3023d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f3024e;

        e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f3020a = atomicReferenceFieldUpdater;
            this.f3021b = atomicReferenceFieldUpdater2;
            this.f3022c = atomicReferenceFieldUpdater3;
            this.f3023d = atomicReferenceFieldUpdater4;
            this.f3024e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        void a(h hVar, Thread thread) {
            this.f3020a.lazySet(hVar, thread);
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        void a(h hVar, h hVar2) {
            this.f3021b.lazySet(hVar, hVar2);
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        boolean a(a<?> aVar, h hVar, h hVar2) {
            return this.f3022c.compareAndSet(aVar, hVar, hVar2);
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        boolean a(a<?> aVar, d dVar, d dVar2) {
            return this.f3023d.compareAndSet(aVar, dVar, dVar2);
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        boolean a(a<?> aVar, Object obj, Object obj2) {
            return this.f3024e.compareAndSet(aVar, obj, obj2);
        }
    }

    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    private static final class g extends AbstractC0062a {
        g() {
            super();
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        void a(h hVar, Thread thread) {
            hVar.f3028b = thread;
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        void a(h hVar, h hVar2) {
            hVar.f3029c = hVar2;
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        boolean a(a<?> aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                if (aVar.f3009e == hVar) {
                    aVar.f3009e = hVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        boolean a(a<?> aVar, d dVar, d dVar2) {
            synchronized (aVar) {
                if (aVar.f3008d == dVar) {
                    aVar.f3008d = dVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0062a
        boolean a(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f3007c == obj) {
                    aVar.f3007c = obj2;
                    return true;
                }
                return false;
            }
        }
    }

    private static CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T b(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }
}

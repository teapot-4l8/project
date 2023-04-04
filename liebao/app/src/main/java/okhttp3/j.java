package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.b.g;

/* compiled from: ConnectionPool.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f7669c = !j.class.desiredAssertionStatus();

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f7670d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    final okhttp3.internal.b.d f7671a;

    /* renamed from: b  reason: collision with root package name */
    boolean f7672b;

    /* renamed from: e  reason: collision with root package name */
    private final int f7673e;
    private final long f;
    private final Runnable g;
    private final Deque<okhttp3.internal.b.c> h;

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public j(int i, long j, TimeUnit timeUnit) {
        this.g = new Runnable() { // from class: okhttp3.j.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long a2 = j.this.a(System.nanoTime());
                    if (a2 == -1) {
                        return;
                    }
                    if (a2 > 0) {
                        long j2 = a2 / 1000000;
                        long j3 = a2 - (1000000 * j2);
                        synchronized (j.this) {
                            try {
                                j.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.h = new ArrayDeque();
        this.f7671a = new okhttp3.internal.b.d();
        this.f7673e = i;
        this.f = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public okhttp3.internal.b.c a(a aVar, okhttp3.internal.b.g gVar, ae aeVar) {
        if (f7669c || Thread.holdsLock(this)) {
            for (okhttp3.internal.b.c cVar : this.h) {
                if (cVar.a(aVar, aeVar)) {
                    gVar.a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Socket a(a aVar, okhttp3.internal.b.g gVar) {
        if (f7669c || Thread.holdsLock(this)) {
            for (okhttp3.internal.b.c cVar : this.h) {
                if (cVar.a(aVar, null) && cVar.f() && cVar != gVar.c()) {
                    return gVar.a(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(okhttp3.internal.b.c cVar) {
        if (!f7669c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f7672b) {
            this.f7672b = true;
            f7670d.execute(this.g);
        }
        this.h.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(okhttp3.internal.b.c cVar) {
        if (f7669c || Thread.holdsLock(this)) {
            if (cVar.f7443a || this.f7673e == 0) {
                this.h.remove(cVar);
                return true;
            }
            notifyAll();
            return false;
        }
        throw new AssertionError();
    }

    long a(long j) {
        synchronized (this) {
            okhttp3.internal.b.c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (okhttp3.internal.b.c cVar2 : this.h) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.f7447e;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f && i <= this.f7673e) {
                if (i > 0) {
                    return this.f - j2;
                } else if (i2 > 0) {
                    return this.f;
                } else {
                    this.f7672b = false;
                    return -1L;
                }
            }
            this.h.remove(cVar);
            okhttp3.internal.c.a(cVar.d());
            return 0L;
        }
    }

    private int a(okhttp3.internal.b.c cVar, long j) {
        List<Reference<okhttp3.internal.b.g>> list = cVar.f7446d;
        int i = 0;
        while (i < list.size()) {
            Reference<okhttp3.internal.b.g> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                okhttp3.internal.g.f.c().a("A connection to " + cVar.b().a().a() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f7463a);
                list.remove(i);
                cVar.f7443a = true;
                if (list.isEmpty()) {
                    cVar.f7447e = j - this.f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}

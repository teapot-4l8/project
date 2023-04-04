package c;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: AsyncTimeout.java */
/* loaded from: classes.dex */
public class a extends t {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    static a f3531b;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3533e;
    @Nullable
    private a f;
    private long g;

    /* renamed from: a  reason: collision with root package name */
    private static final long f3530a = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: d  reason: collision with root package name */
    private static final long f3532d = TimeUnit.MILLISECONDS.toNanos(f3530a);

    protected void a() {
    }

    public final void c() {
        if (this.f3533e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long q_ = q_();
        boolean o_ = o_();
        if (q_ != 0 || o_) {
            this.f3533e = true;
            a(this, q_, o_);
        }
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (f3531b == null) {
                f3531b = new a();
                new C0077a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.g = Math.min(j, aVar.d() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.g = j + nanoTime;
            } else if (z) {
                aVar.g = aVar.d();
            } else {
                throw new AssertionError();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = f3531b;
            while (aVar2.f != null && b2 >= aVar2.f.b(nanoTime)) {
                aVar2 = aVar2.f;
            }
            aVar.f = aVar2.f;
            aVar2.f = aVar;
            if (aVar2 == f3531b) {
                a.class.notify();
            }
        }
    }

    public final boolean n_() {
        if (this.f3533e) {
            this.f3533e = false;
            return a(this);
        }
        return false;
    }

    private static synchronized boolean a(a aVar) {
        synchronized (a.class) {
            for (a aVar2 = f3531b; aVar2 != null; aVar2 = aVar2.f) {
                if (aVar2.f == aVar) {
                    aVar2.f = aVar.f;
                    aVar.f = null;
                    return false;
                }
            }
            return true;
        }
    }

    private long b(long j) {
        return this.g - j;
    }

    public final r a(final r rVar) {
        return new r() { // from class: c.a.1
            @Override // c.r
            public void a_(c cVar, long j) {
                u.a(cVar.f3542b, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    o oVar = cVar.f3541a;
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += oVar.f3577c - oVar.f3576b;
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        oVar = oVar.f;
                    }
                    a.this.c();
                    try {
                        try {
                            rVar.a_(cVar, j2);
                            j -= j2;
                            a.this.a(true);
                        } catch (IOException e2) {
                            throw a.this.b(e2);
                        }
                    } catch (Throwable th) {
                        a.this.a(false);
                        throw th;
                    }
                }
            }

            @Override // c.r, java.io.Flushable
            public void flush() {
                a.this.c();
                try {
                    try {
                        rVar.flush();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.b(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                a.this.c();
                try {
                    try {
                        rVar.close();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.b(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // c.r
            public t a() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + rVar + ")";
            }
        };
    }

    public final s a(final s sVar) {
        return new s() { // from class: c.a.2
            @Override // c.s
            public long a(c cVar, long j) {
                a.this.c();
                try {
                    try {
                        long a2 = sVar.a(cVar, j);
                        a.this.a(true);
                        return a2;
                    } catch (IOException e2) {
                        throw a.this.b(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    try {
                        sVar.close();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.b(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // c.s
            public t a() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + sVar + ")";
            }
        };
    }

    final void a(boolean z) {
        if (n_() && z) {
            throw a((IOException) null);
        }
    }

    final IOException b(IOException iOException) {
        return !n_() ? iOException : a(iOException);
    }

    protected IOException a(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.java */
    /* renamed from: c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0077a extends Thread {
        C0077a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.a();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (a.class) {
                    try {
                        a e2 = a.e();
                        if (e2 != null) {
                            if (e2 == a.f3531b) {
                                a.f3531b = null;
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    @Nullable
    static a e() {
        a aVar = f3531b.f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f3530a);
            if (f3531b.f != null || System.nanoTime() - nanoTime < f3532d) {
                return null;
            }
            return f3531b;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j = b2 / 1000000;
            a.class.wait(j, (int) (b2 - (1000000 * j)));
            return null;
        }
        f3531b.f = aVar.f;
        aVar.f = null;
        return aVar;
    }
}

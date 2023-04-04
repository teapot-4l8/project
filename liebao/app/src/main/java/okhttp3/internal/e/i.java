package okhttp3.internal.e;

import c.r;
import c.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.e.c;
import okhttp3.s;

/* compiled from: Http2Stream.java */
/* loaded from: classes.dex */
public final class i {
    static final /* synthetic */ boolean i = !i.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    long f7602b;

    /* renamed from: c  reason: collision with root package name */
    final int f7603c;

    /* renamed from: d  reason: collision with root package name */
    final g f7604d;

    /* renamed from: e  reason: collision with root package name */
    final a f7605e;
    private c.a k;
    private boolean l;
    private final b m;

    /* renamed from: a  reason: collision with root package name */
    long f7601a = 0;
    private final Deque<s> j = new ArrayDeque();
    final c f = new c();
    final c g = new c();
    okhttp3.internal.e.b h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i2, g gVar, boolean z, boolean z2, @Nullable s sVar) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.f7603c = i2;
        this.f7604d = gVar;
        this.f7602b = gVar.l.d();
        this.m = new b(gVar.k.d());
        this.f7605e = new a();
        this.m.f7613b = z2;
        this.f7605e.f7608b = z;
        if (sVar != null) {
            this.j.add(sVar);
        }
        if (c() && sVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!c() && sVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public int a() {
        return this.f7603c;
    }

    public synchronized boolean b() {
        if (this.h != null) {
            return false;
        }
        if ((this.m.f7613b || this.m.f7612a) && (this.f7605e.f7608b || this.f7605e.f7607a)) {
            if (this.l) {
                return false;
            }
        }
        return true;
    }

    public boolean c() {
        return this.f7604d.f7549a == ((this.f7603c & 1) == 1);
    }

    public synchronized s d() {
        this.f.c();
        while (this.j.isEmpty() && this.h == null) {
            l();
        }
        this.f.b();
        if (!this.j.isEmpty()) {
        } else {
            throw new n(this.h);
        }
        return this.j.removeFirst();
    }

    public t e() {
        return this.f;
    }

    public t f() {
        return this.g;
    }

    public c.s g() {
        return this.m;
    }

    public r h() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f7605e;
    }

    public void a(okhttp3.internal.e.b bVar) {
        if (d(bVar)) {
            this.f7604d.b(this.f7603c, bVar);
        }
    }

    public void b(okhttp3.internal.e.b bVar) {
        if (d(bVar)) {
            this.f7604d.a(this.f7603c, bVar);
        }
    }

    private boolean d(okhttp3.internal.e.b bVar) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.h != null) {
                    return false;
                }
                if (this.m.f7613b && this.f7605e.f7608b) {
                    return false;
                }
                this.h = bVar;
                notifyAll();
                this.f7604d.b(this.f7603c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<okhttp3.internal.e.c> list) {
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.l = true;
            this.j.add(okhttp3.internal.c.b(list));
            b2 = b();
            notifyAll();
        }
        if (b2) {
            return;
        }
        this.f7604d.b(this.f7603c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c.e eVar, int i2) {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.a(eVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.m.f7613b = true;
            b2 = b();
            notifyAll();
        }
        if (b2) {
            return;
        }
        this.f7604d.b(this.f7603c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(okhttp3.internal.e.b bVar) {
        if (this.h == null) {
            this.h = bVar;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes2.dex */
    public final class b implements c.s {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f7611c = !i.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        boolean f7612a;

        /* renamed from: b  reason: collision with root package name */
        boolean f7613b;

        /* renamed from: e  reason: collision with root package name */
        private final c.c f7615e = new c.c();
        private final c.c f = new c.c();
        private final long g;

        b(long j) {
            this.g = j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
            if (r11 == (-1)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00cd, code lost:
            a(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d0, code lost:
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d1, code lost:
            if (r0 != null) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d3, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00d9, code lost:
            throw new okhttp3.internal.e.n(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00e1, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // c.s
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long a(c.c cVar, long j) {
            long a2;
            s sVar;
            c.a aVar;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            while (true) {
                synchronized (i.this) {
                    i.this.f.c();
                    okhttp3.internal.e.b bVar = i.this.h != null ? i.this.h : null;
                    if (this.f7612a) {
                        break;
                    }
                    if (!i.this.j.isEmpty() && i.this.k != null) {
                        sVar = (s) i.this.j.removeFirst();
                        aVar = i.this.k;
                        a2 = -1;
                    } else {
                        if (this.f.b() > 0) {
                            a2 = this.f.a(cVar, Math.min(j, this.f.b()));
                            i.this.f7601a += a2;
                            if (bVar == null && i.this.f7601a >= i.this.f7604d.k.d() / 2) {
                                i.this.f7604d.a(i.this.f7603c, i.this.f7601a);
                                i.this.f7601a = 0L;
                            }
                        } else if (this.f7613b || bVar != null) {
                            a2 = -1;
                        } else {
                            i.this.l();
                            i.this.f.b();
                        }
                        sVar = null;
                        aVar = null;
                    }
                    i.this.f.b();
                    if (sVar == null || aVar == null) {
                        break;
                    }
                    aVar.a(sVar);
                }
            }
        }

        private void a(long j) {
            if (!f7611c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            i.this.f7604d.a(j);
        }

        void a(c.e eVar, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            if (!f7611c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (i.this) {
                    z = this.f7613b;
                    z2 = true;
                    z3 = this.f.b() + j > this.g;
                }
                if (z3) {
                    eVar.i(j);
                    i.this.b(okhttp3.internal.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.i(j);
                    return;
                } else {
                    long a2 = eVar.a(this.f7615e, j);
                    if (a2 == -1) {
                        throw new EOFException();
                    }
                    j -= a2;
                    synchronized (i.this) {
                        if (this.f.b() != 0) {
                            z2 = false;
                        }
                        this.f.a((c.s) this.f7615e);
                        if (z2) {
                            i.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // c.s
        public t a() {
            return i.this.f;
        }

        @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long b2;
            c.a aVar;
            ArrayList<s> arrayList;
            synchronized (i.this) {
                this.f7612a = true;
                b2 = this.f.b();
                this.f.u();
                aVar = null;
                if (i.this.j.isEmpty() || i.this.k == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(i.this.j);
                    i.this.j.clear();
                    aVar = i.this.k;
                    arrayList = arrayList2;
                }
                i.this.notifyAll();
            }
            if (b2 > 0) {
                a(b2);
            }
            i.this.j();
            if (aVar != null) {
                for (s sVar : arrayList) {
                    aVar.a(sVar);
                }
            }
        }
    }

    void j() {
        boolean z;
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.m.f7613b && this.m.f7612a && (this.f7605e.f7608b || this.f7605e.f7607a);
            b2 = b();
        }
        if (z) {
            a(okhttp3.internal.e.b.CANCEL);
        } else if (b2) {
        } else {
            this.f7604d.b(this.f7603c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes2.dex */
    public final class a implements r {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f7606c = !i.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        boolean f7607a;

        /* renamed from: b  reason: collision with root package name */
        boolean f7608b;

        /* renamed from: e  reason: collision with root package name */
        private final c.c f7610e = new c.c();

        a() {
        }

        @Override // c.r
        public void a_(c.c cVar, long j) {
            if (!f7606c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.f7610e.a_(cVar, j);
            while (this.f7610e.b() >= 16384) {
                a(false);
            }
        }

        private void a(boolean z) {
            long min;
            synchronized (i.this) {
                i.this.g.c();
                while (i.this.f7602b <= 0 && !this.f7608b && !this.f7607a && i.this.h == null) {
                    i.this.l();
                }
                i.this.g.b();
                i.this.k();
                min = Math.min(i.this.f7602b, this.f7610e.b());
                i.this.f7602b -= min;
            }
            i.this.g.c();
            try {
                i.this.f7604d.a(i.this.f7603c, z && min == this.f7610e.b(), this.f7610e, min);
            } finally {
                i.this.g.b();
            }
        }

        @Override // c.r, java.io.Flushable
        public void flush() {
            if (!f7606c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.k();
            }
            while (this.f7610e.b() > 0) {
                a(false);
                i.this.f7604d.b();
            }
        }

        @Override // c.r
        public t a() {
            return i.this.g;
        }

        @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!f7606c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.f7607a) {
                    return;
                }
                if (!i.this.f7605e.f7608b) {
                    if (this.f7610e.b() > 0) {
                        while (this.f7610e.b() > 0) {
                            a(true);
                        }
                    } else {
                        i.this.f7604d.a(i.this.f7603c, true, (c.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.f7607a = true;
                }
                i.this.f7604d.b();
                i.this.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f7602b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void k() {
        if (this.f7605e.f7607a) {
            throw new IOException("stream closed");
        }
        if (this.f7605e.f7608b) {
            throw new IOException("stream finished");
        }
        if (this.h != null) {
            throw new n(this.h);
        }
    }

    void l() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes2.dex */
    public class c extends c.a {
        c() {
        }

        @Override // c.a
        protected void a() {
            i.this.b(okhttp3.internal.e.b.CANCEL);
        }

        @Override // c.a
        protected IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void b() {
            if (n_()) {
                throw a((IOException) null);
            }
        }
    }
}

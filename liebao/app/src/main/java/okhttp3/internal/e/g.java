package okhttp3.internal.e;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.e.h;

/* compiled from: Http2Connection.java */
/* loaded from: classes2.dex */
public final class g implements Closeable {
    static final /* synthetic */ boolean r = !g.class.desiredAssertionStatus();
    private static final ExecutorService s = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp Http2Connection", true));

    /* renamed from: a  reason: collision with root package name */
    final boolean f7549a;

    /* renamed from: b  reason: collision with root package name */
    final b f7550b;

    /* renamed from: d  reason: collision with root package name */
    final String f7552d;

    /* renamed from: e  reason: collision with root package name */
    int f7553e;
    int f;
    boolean g;
    final l h;
    long j;
    final Socket n;
    final j o;
    final d p;
    private final ScheduledExecutorService t;
    private final ExecutorService u;
    private boolean v;

    /* renamed from: c  reason: collision with root package name */
    final Map<Integer, i> f7551c = new LinkedHashMap();
    long i = 0;
    m k = new m();
    final m l = new m();
    boolean m = false;

    /* renamed from: q  reason: collision with root package name */
    final Set<Integer> f7554q = new LinkedHashSet();

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public static final b f = new b() { // from class: okhttp3.internal.e.g.b.1
            @Override // okhttp3.internal.e.g.b
            public void a(i iVar) {
                iVar.a(okhttp3.internal.e.b.REFUSED_STREAM);
            }
        };

        public void a(g gVar) {
        }

        public abstract void a(i iVar);
    }

    boolean c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    g(a aVar) {
        this.h = aVar.f;
        this.f7549a = aVar.g;
        this.f7550b = aVar.f7579e;
        this.f = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.f += 2;
        }
        if (aVar.g) {
            this.k.a(7, 16777216);
        }
        this.f7552d = aVar.f7576b;
        this.t = new ScheduledThreadPoolExecutor(1, okhttp3.internal.c.a(okhttp3.internal.c.a("OkHttp %s Writer", this.f7552d), false));
        if (aVar.h != 0) {
            this.t.scheduleAtFixedRate(new c(false, 0, 0), aVar.h, aVar.h, TimeUnit.MILLISECONDS);
        }
        this.u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.c.a(okhttp3.internal.c.a("OkHttp %s Push Observer", this.f7552d), true));
        this.l.a(7, 65535);
        this.l.a(5, 16384);
        this.j = this.l.d();
        this.n = aVar.f7575a;
        this.o = new j(aVar.f7578d, this.f7549a);
        this.p = new d(new h(aVar.f7577c, this.f7549a));
    }

    synchronized i a(int i) {
        return this.f7551c.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized i b(int i) {
        i remove;
        remove = this.f7551c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public synchronized int a() {
        return this.l.c(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(long j) {
        long j2 = this.i + j;
        this.i = j2;
        if (j2 >= this.k.d() / 2) {
            a(0, this.i);
            this.i = 0L;
        }
    }

    public i a(List<okhttp3.internal.e.c> list, boolean z) {
        return b(0, list, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x0075, TryCatch #1 {, blocks: (B:4:0x0006, B:24:0x004f, B:28:0x005e, B:25:0x0055, B:27:0x0059, B:32:0x0067, B:33:0x006e, B:5:0x0007, B:7:0x000e, B:8:0x0013, B:10:0x0017, B:12:0x002b, B:14:0x0033, B:19:0x003d, B:21:0x0043, B:22:0x004c, B:34:0x006f, B:35:0x0074), top: B:42:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private i b(int i, List<okhttp3.internal.e.c> list, boolean z) {
        int i2;
        i iVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.o) {
            synchronized (this) {
                if (this.f > 1073741823) {
                    a(okhttp3.internal.e.b.REFUSED_STREAM);
                }
                if (this.g) {
                    throw new okhttp3.internal.e.a();
                }
                i2 = this.f;
                this.f += 2;
                iVar = new i(i2, this, z3, false, null);
                if (z && this.j != 0 && iVar.f7602b != 0) {
                    z2 = false;
                    if (iVar.b()) {
                        this.f7551c.put(Integer.valueOf(i2), iVar);
                    }
                }
                z2 = true;
                if (iVar.b()) {
                }
            }
            if (i == 0) {
                this.o.a(z3, i2, i, list);
            } else if (this.f7549a) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.o.a(i, i2, list);
            }
        }
        if (z2) {
            this.o.b();
        }
        return iVar;
    }

    public void a(int i, boolean z, c.c cVar, long j) {
        int min;
        long j2;
        if (j == 0) {
            this.o.a(z, i, cVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.j <= 0) {
                    try {
                        if (!this.f7551c.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.j), this.o.c());
                j2 = min;
                this.j -= j2;
            }
            j -= j2;
            this.o.a(z && j == 0, i, cVar, min);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final okhttp3.internal.e.b bVar) {
        try {
            this.t.execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[]{this.f7552d, Integer.valueOf(i)}) { // from class: okhttp3.internal.e.g.1
                @Override // okhttp3.internal.b
                public void c() {
                    try {
                        g.this.b(i, bVar);
                    } catch (IOException unused) {
                        g.this.f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, okhttp3.internal.e.b bVar) {
        this.o.a(i, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j) {
        try {
            this.t.execute(new okhttp3.internal.b("OkHttp Window Update %s stream %d", new Object[]{this.f7552d, Integer.valueOf(i)}) { // from class: okhttp3.internal.e.g.2
                @Override // okhttp3.internal.b
                public void c() {
                    try {
                        g.this.o.a(i, j);
                    } catch (IOException unused) {
                        g.this.f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    final class c extends okhttp3.internal.b {

        /* renamed from: a  reason: collision with root package name */
        final boolean f7580a;

        /* renamed from: b  reason: collision with root package name */
        final int f7581b;

        /* renamed from: d  reason: collision with root package name */
        final int f7582d;

        c(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", g.this.f7552d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f7580a = z;
            this.f7581b = i;
            this.f7582d = i2;
        }

        @Override // okhttp3.internal.b
        public void c() {
            g.this.a(this.f7580a, this.f7581b, this.f7582d);
        }
    }

    void a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.v;
                this.v = true;
            }
            if (z2) {
                f();
                return;
            }
        }
        try {
            this.o.a(z, i, i2);
        } catch (IOException unused) {
            f();
        }
    }

    public void b() {
        this.o.b();
    }

    public void a(okhttp3.internal.e.b bVar) {
        synchronized (this.o) {
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                this.o.a(this.f7553e, bVar, okhttp3.internal.c.f7464a);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(okhttp3.internal.e.b.NO_ERROR, okhttp3.internal.e.b.CANCEL);
    }

    void a(okhttp3.internal.e.b bVar, okhttp3.internal.e.b bVar2) {
        if (!r && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        i[] iVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.f7551c.isEmpty()) {
                iVarArr = (i[]) this.f7551c.values().toArray(new i[this.f7551c.size()]);
                this.f7551c.clear();
            }
        }
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.o.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.n.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.t.shutdown();
        this.u.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            a(okhttp3.internal.e.b.PROTOCOL_ERROR, okhttp3.internal.e.b.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    public void c() {
        a(true);
    }

    void a(boolean z) {
        if (z) {
            this.o.a();
            this.o.b(this.k);
            int d2 = this.k.d();
            if (d2 != 65535) {
                this.o.a(0, d2 - 65535);
            }
        }
        new Thread(this.p).start();
    }

    public synchronized boolean d() {
        return this.g;
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Socket f7575a;

        /* renamed from: b  reason: collision with root package name */
        String f7576b;

        /* renamed from: c  reason: collision with root package name */
        c.e f7577c;

        /* renamed from: d  reason: collision with root package name */
        c.d f7578d;

        /* renamed from: e  reason: collision with root package name */
        b f7579e = b.f;
        l f = l.f7629a;
        boolean g;
        int h;

        public a(boolean z) {
            this.g = z;
        }

        public a a(Socket socket, String str, c.e eVar, c.d dVar) {
            this.f7575a = socket;
            this.f7576b = str;
            this.f7577c = eVar;
            this.f7578d = dVar;
            return this;
        }

        public a a(b bVar) {
            this.f7579e = bVar;
            return this;
        }

        public a a(int i) {
            this.h = i;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    public class d extends okhttp3.internal.b implements h.b {

        /* renamed from: a  reason: collision with root package name */
        final h f7584a;

        @Override // okhttp3.internal.e.h.b
        public void a() {
        }

        @Override // okhttp3.internal.e.h.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        d(h hVar) {
            super("OkHttp %s", g.this.f7552d);
            this.f7584a = hVar;
        }

        @Override // okhttp3.internal.b
        protected void c() {
            g gVar;
            okhttp3.internal.e.b bVar = okhttp3.internal.e.b.INTERNAL_ERROR;
            okhttp3.internal.e.b bVar2 = okhttp3.internal.e.b.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f7584a.a(this);
                        while (this.f7584a.a(false, (h.b) this)) {
                        }
                        bVar = okhttp3.internal.e.b.NO_ERROR;
                        bVar2 = okhttp3.internal.e.b.CANCEL;
                        gVar = g.this;
                    } catch (IOException unused) {
                        bVar = okhttp3.internal.e.b.PROTOCOL_ERROR;
                        bVar2 = okhttp3.internal.e.b.PROTOCOL_ERROR;
                        gVar = g.this;
                    }
                    gVar.a(bVar, bVar2);
                } catch (IOException unused2) {
                }
                okhttp3.internal.c.a(this.f7584a);
            } catch (Throwable th) {
                try {
                    g.this.a(bVar, bVar2);
                } catch (IOException unused3) {
                }
                okhttp3.internal.c.a(this.f7584a);
                throw th;
            }
        }

        @Override // okhttp3.internal.e.h.b
        public void a(boolean z, int i, c.e eVar, int i2) {
            if (g.this.c(i)) {
                g.this.a(i, eVar, i2, z);
                return;
            }
            i a2 = g.this.a(i);
            if (a2 == null) {
                g.this.a(i, okhttp3.internal.e.b.PROTOCOL_ERROR);
                long j = i2;
                g.this.a(j);
                eVar.i(j);
                return;
            }
            a2.a(eVar, i2);
            if (z) {
                a2.i();
            }
        }

        @Override // okhttp3.internal.e.h.b
        public void a(boolean z, int i, int i2, List<okhttp3.internal.e.c> list) {
            if (g.this.c(i)) {
                g.this.a(i, list, z);
                return;
            }
            synchronized (g.this) {
                i a2 = g.this.a(i);
                if (a2 == null) {
                    if (g.this.g) {
                        return;
                    }
                    if (i <= g.this.f7553e) {
                        return;
                    }
                    if (i % 2 == g.this.f % 2) {
                        return;
                    }
                    final i iVar = new i(i, g.this, false, z, okhttp3.internal.c.b(list));
                    g.this.f7553e = i;
                    g.this.f7551c.put(Integer.valueOf(i), iVar);
                    g.s.execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[]{g.this.f7552d, Integer.valueOf(i)}) { // from class: okhttp3.internal.e.g.d.1
                        @Override // okhttp3.internal.b
                        public void c() {
                            try {
                                g.this.f7550b.a(iVar);
                            } catch (IOException e2) {
                                okhttp3.internal.g.f c2 = okhttp3.internal.g.f.c();
                                c2.a(4, "Http2Connection.Listener failure for " + g.this.f7552d, e2);
                                try {
                                    iVar.a(okhttp3.internal.e.b.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                a2.a(list);
                if (z) {
                    a2.i();
                }
            }
        }

        @Override // okhttp3.internal.e.h.b
        public void a(int i, okhttp3.internal.e.b bVar) {
            if (g.this.c(i)) {
                g.this.c(i, bVar);
                return;
            }
            i b2 = g.this.b(i);
            if (b2 != null) {
                b2.c(bVar);
            }
        }

        @Override // okhttp3.internal.e.h.b
        public void a(boolean z, m mVar) {
            i[] iVarArr;
            long j;
            int i;
            synchronized (g.this) {
                int d2 = g.this.l.d();
                if (z) {
                    g.this.l.a();
                }
                g.this.l.a(mVar);
                a(mVar);
                int d3 = g.this.l.d();
                iVarArr = null;
                if (d3 == -1 || d3 == d2) {
                    j = 0;
                } else {
                    j = d3 - d2;
                    if (!g.this.m) {
                        g.this.m = true;
                    }
                    if (!g.this.f7551c.isEmpty()) {
                        iVarArr = (i[]) g.this.f7551c.values().toArray(new i[g.this.f7551c.size()]);
                    }
                }
                g.s.execute(new okhttp3.internal.b("OkHttp %s settings", g.this.f7552d) { // from class: okhttp3.internal.e.g.d.2
                    @Override // okhttp3.internal.b
                    public void c() {
                        g.this.f7550b.a(g.this);
                    }
                });
            }
            if (iVarArr == null || j == 0) {
                return;
            }
            for (i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.a(j);
                }
            }
        }

        private void a(final m mVar) {
            try {
                g.this.t.execute(new okhttp3.internal.b("OkHttp %s ACK Settings", new Object[]{g.this.f7552d}) { // from class: okhttp3.internal.e.g.d.3
                    @Override // okhttp3.internal.b
                    public void c() {
                        try {
                            g.this.o.a(mVar);
                        } catch (IOException unused) {
                            g.this.f();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.e.h.b
        public void a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    g.this.t.execute(new c(true, i, i2));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (g.this) {
                g.this.v = false;
                g.this.notifyAll();
            }
        }

        @Override // okhttp3.internal.e.h.b
        public void a(int i, okhttp3.internal.e.b bVar, c.f fVar) {
            i[] iVarArr;
            fVar.h();
            synchronized (g.this) {
                iVarArr = (i[]) g.this.f7551c.values().toArray(new i[g.this.f7551c.size()]);
                g.this.g = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.a() > i && iVar.c()) {
                    iVar.c(okhttp3.internal.e.b.REFUSED_STREAM);
                    g.this.b(iVar.a());
                }
            }
        }

        @Override // okhttp3.internal.e.h.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (g.this) {
                    g.this.j += j;
                    g.this.notifyAll();
                }
                return;
            }
            i a2 = g.this.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // okhttp3.internal.e.h.b
        public void a(int i, int i2, List<okhttp3.internal.e.c> list) {
            g.this.a(i2, list);
        }
    }

    void a(final int i, final List<okhttp3.internal.e.c> list) {
        synchronized (this) {
            if (this.f7554q.contains(Integer.valueOf(i))) {
                a(i, okhttp3.internal.e.b.PROTOCOL_ERROR);
                return;
            }
            this.f7554q.add(Integer.valueOf(i));
            try {
                a(new okhttp3.internal.b("OkHttp %s Push Request[%s]", new Object[]{this.f7552d, Integer.valueOf(i)}) { // from class: okhttp3.internal.e.g.3
                    @Override // okhttp3.internal.b
                    public void c() {
                        if (g.this.h.a(i, list)) {
                            try {
                                g.this.o.a(i, okhttp3.internal.e.b.CANCEL);
                                synchronized (g.this) {
                                    g.this.f7554q.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(final int i, final List<okhttp3.internal.e.c> list, final boolean z) {
        try {
            a(new okhttp3.internal.b("OkHttp %s Push Headers[%s]", new Object[]{this.f7552d, Integer.valueOf(i)}) { // from class: okhttp3.internal.e.g.4
                @Override // okhttp3.internal.b
                public void c() {
                    boolean a2 = g.this.h.a(i, list, z);
                    if (a2) {
                        try {
                            g.this.o.a(i, okhttp3.internal.e.b.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (a2 || z) {
                        synchronized (g.this) {
                            g.this.f7554q.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(final int i, c.e eVar, final int i2, final boolean z) {
        final c.c cVar = new c.c();
        long j = i2;
        eVar.a(j);
        eVar.a(cVar, j);
        if (cVar.b() != j) {
            throw new IOException(cVar.b() + " != " + i2);
        }
        a(new okhttp3.internal.b("OkHttp %s Push Data[%s]", new Object[]{this.f7552d, Integer.valueOf(i)}) { // from class: okhttp3.internal.e.g.5
            @Override // okhttp3.internal.b
            public void c() {
                try {
                    boolean a2 = g.this.h.a(i, cVar, i2, z);
                    if (a2) {
                        g.this.o.a(i, okhttp3.internal.e.b.CANCEL);
                    }
                    if (a2 || z) {
                        synchronized (g.this) {
                            g.this.f7554q.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    void c(final int i, final okhttp3.internal.e.b bVar) {
        a(new okhttp3.internal.b("OkHttp %s Push Reset[%s]", new Object[]{this.f7552d, Integer.valueOf(i)}) { // from class: okhttp3.internal.e.g.6
            @Override // okhttp3.internal.b
            public void c() {
                g.this.h.a(i, bVar);
                synchronized (g.this) {
                    g.this.f7554q.remove(Integer.valueOf(i));
                }
            }
        });
    }

    private synchronized void a(okhttp3.internal.b bVar) {
        if (!d()) {
            this.u.execute(bVar);
        }
    }
}

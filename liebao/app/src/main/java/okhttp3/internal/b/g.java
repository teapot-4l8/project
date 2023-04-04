package okhttp3.internal.b;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.ae;
import okhttp3.internal.b.f;
import okhttp3.internal.e.n;
import okhttp3.j;
import okhttp3.p;
import okhttp3.u;
import okhttp3.x;

/* compiled from: StreamAllocation.java */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f7458d = !g.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public final okhttp3.a f7459a;

    /* renamed from: b  reason: collision with root package name */
    public final okhttp3.e f7460b;

    /* renamed from: c  reason: collision with root package name */
    public final p f7461c;

    /* renamed from: e  reason: collision with root package name */
    private f.a f7462e;
    private ae f;
    private final j g;
    private final Object h;
    private final f i;
    private int j;
    private c k;
    private boolean l;
    private boolean m;
    private boolean n;
    private okhttp3.internal.c.c o;

    public g(j jVar, okhttp3.a aVar, okhttp3.e eVar, p pVar, Object obj) {
        this.g = jVar;
        this.f7459a = aVar;
        this.f7460b = eVar;
        this.f7461c = pVar;
        this.i = new f(aVar, i(), eVar, pVar);
        this.h = obj;
    }

    public okhttp3.internal.c.c a(x xVar, u.a aVar, boolean z) {
        try {
            okhttp3.internal.c.c a2 = a(aVar.c(), aVar.d(), aVar.e(), xVar.e(), xVar.t(), z).a(xVar, aVar, this);
            synchronized (this.g) {
                this.o = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    private c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        while (true) {
            c a2 = a(i, i2, i3, i4, z);
            synchronized (this.g) {
                if (a2.f7444b == 0) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                e();
            }
        }
    }

    private c a(int i, int i2, int i3, int i4, boolean z) {
        Socket h;
        Socket socket;
        c cVar;
        c cVar2;
        ae aeVar;
        boolean z2;
        boolean z3;
        f.a aVar;
        synchronized (this.g) {
            if (this.m) {
                throw new IllegalStateException("released");
            }
            if (this.o != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.n) {
                throw new IOException("Canceled");
            }
            c cVar3 = this.k;
            h = h();
            socket = null;
            if (this.k != null) {
                cVar2 = this.k;
                cVar = null;
            } else {
                cVar = cVar3;
                cVar2 = null;
            }
            if (!this.l) {
                cVar = null;
            }
            if (cVar2 == null) {
                okhttp3.internal.a.f7398a.a(this.g, this.f7459a, this, null);
                if (this.k != null) {
                    cVar2 = this.k;
                    aeVar = null;
                    z2 = true;
                } else {
                    aeVar = this.f;
                }
            } else {
                aeVar = null;
            }
            z2 = false;
        }
        okhttp3.internal.c.a(h);
        if (cVar != null) {
            this.f7461c.b(this.f7460b, cVar);
        }
        if (z2) {
            this.f7461c.a(this.f7460b, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (aeVar != null || ((aVar = this.f7462e) != null && aVar.a())) {
            z3 = false;
        } else {
            this.f7462e = this.i.b();
            z3 = true;
        }
        synchronized (this.g) {
            if (this.n) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<ae> c2 = this.f7462e.c();
                int size = c2.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    ae aeVar2 = c2.get(i5);
                    okhttp3.internal.a.f7398a.a(this.g, this.f7459a, this, aeVar2);
                    if (this.k != null) {
                        cVar2 = this.k;
                        this.f = aeVar2;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (aeVar == null) {
                    aeVar = this.f7462e.b();
                }
                this.f = aeVar;
                this.j = 0;
                cVar2 = new c(this.g, aeVar);
                a(cVar2, false);
            }
        }
        if (z2) {
            this.f7461c.a(this.f7460b, cVar2);
            return cVar2;
        }
        cVar2.a(i, i2, i3, i4, z, this.f7460b, this.f7461c);
        i().b(cVar2.b());
        synchronized (this.g) {
            this.l = true;
            okhttp3.internal.a.f7398a.b(this.g, cVar2);
            if (cVar2.f()) {
                socket = okhttp3.internal.a.f7398a.a(this.g, this.f7459a, this);
                cVar2 = this.k;
            }
        }
        okhttp3.internal.c.a(socket);
        this.f7461c.a(this.f7460b, cVar2);
        return cVar2;
    }

    private Socket h() {
        if (f7458d || Thread.holdsLock(this.g)) {
            c cVar = this.k;
            if (cVar == null || !cVar.f7443a) {
                return null;
            }
            return a(false, false, true);
        }
        throw new AssertionError();
    }

    public void a(boolean z, okhttp3.internal.c.c cVar, long j, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        this.f7461c.b(this.f7460b, j);
        synchronized (this.g) {
            if (cVar != null) {
                if (cVar == this.o) {
                    if (!z) {
                        this.k.f7444b++;
                    }
                    cVar2 = this.k;
                    a2 = a(z, false, true);
                    if (this.k != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.o + " but was " + cVar);
        }
        okhttp3.internal.c.a(a2);
        if (cVar2 != null) {
            this.f7461c.b(this.f7460b, cVar2);
        }
        if (iOException != null) {
            this.f7461c.a(this.f7460b, okhttp3.internal.a.f7398a.a(this.f7460b, iOException));
        } else if (z2) {
            okhttp3.internal.a.f7398a.a(this.f7460b, (IOException) null);
            this.f7461c.g(this.f7460b);
        }
    }

    public okhttp3.internal.c.c a() {
        okhttp3.internal.c.c cVar;
        synchronized (this.g) {
            cVar = this.o;
        }
        return cVar;
    }

    private d i() {
        return okhttp3.internal.a.f7398a.a(this.g);
    }

    public ae b() {
        return this.f;
    }

    public synchronized c c() {
        return this.k;
    }

    public void d() {
        c cVar;
        Socket a2;
        synchronized (this.g) {
            cVar = this.k;
            a2 = a(false, true, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        okhttp3.internal.c.a(a2);
        if (cVar != null) {
            okhttp3.internal.a.f7398a.a(this.f7460b, (IOException) null);
            this.f7461c.b(this.f7460b, cVar);
            this.f7461c.g(this.f7460b);
        }
    }

    public void e() {
        c cVar;
        Socket a2;
        synchronized (this.g) {
            cVar = this.k;
            a2 = a(true, false, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        okhttp3.internal.c.a(a2);
        if (cVar != null) {
            this.f7461c.b(this.f7460b, cVar);
        }
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f7458d || Thread.holdsLock(this.g)) {
            if (z3) {
                this.o = null;
            }
            if (z2) {
                this.m = true;
            }
            c cVar = this.k;
            if (cVar != null) {
                if (z) {
                    cVar.f7443a = true;
                }
                if (this.o == null) {
                    if (this.m || this.k.f7443a) {
                        b(this.k);
                        if (this.k.f7446d.isEmpty()) {
                            this.k.f7447e = System.nanoTime();
                            if (okhttp3.internal.a.f7398a.a(this.g, this.k)) {
                                socket = this.k.d();
                                this.k = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.k = null;
                        return socket;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        throw new AssertionError();
    }

    public void f() {
        okhttp3.internal.c.c cVar;
        c cVar2;
        synchronized (this.g) {
            this.n = true;
            cVar = this.o;
            cVar2 = this.k;
        }
        if (cVar != null) {
            cVar.c();
        } else if (cVar2 != null) {
            cVar2.c();
        }
    }

    public void a(IOException iOException) {
        c cVar;
        boolean z;
        Socket a2;
        synchronized (this.g) {
            cVar = null;
            if (iOException instanceof n) {
                okhttp3.internal.e.b bVar = ((n) iOException).f7632a;
                if (bVar == okhttp3.internal.e.b.REFUSED_STREAM) {
                    int i = this.j + 1;
                    this.j = i;
                    if (i > 1) {
                        this.f = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (bVar != okhttp3.internal.e.b.CANCEL) {
                        this.f = null;
                        z = true;
                    }
                    z = false;
                }
            } else {
                if (this.k != null && (!this.k.f() || (iOException instanceof okhttp3.internal.e.a))) {
                    if (this.k.f7444b == 0) {
                        if (this.f != null && iOException != null) {
                            this.i.a(this.f, iOException);
                        }
                        this.f = null;
                    }
                    z = true;
                }
                z = false;
            }
            c cVar2 = this.k;
            a2 = a(z, false, true);
            if (this.k == null && this.l) {
                cVar = cVar2;
            }
        }
        okhttp3.internal.c.a(a2);
        if (cVar != null) {
            this.f7461c.b(this.f7460b, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!f7458d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.k != null) {
            throw new IllegalStateException();
        }
        this.k = cVar;
        this.l = z;
        cVar.f7446d.add(new a(this, this.h));
    }

    private void b(c cVar) {
        int size = cVar.f7446d.size();
        for (int i = 0; i < size; i++) {
            if (cVar.f7446d.get(i).get() == this) {
                cVar.f7446d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket a(c cVar) {
        if (f7458d || Thread.holdsLock(this.g)) {
            if (this.o != null || this.k.f7446d.size() != 1) {
                throw new IllegalStateException();
            }
            Socket a2 = a(true, false, false);
            this.k = cVar;
            cVar.f7446d.add(this.k.f7446d.get(0));
            return a2;
        }
        throw new AssertionError();
    }

    public boolean g() {
        f.a aVar;
        return this.f != null || ((aVar = this.f7462e) != null && aVar.a()) || this.i.a();
    }

    public String toString() {
        c c2 = c();
        return c2 != null ? c2.toString() : this.f7459a.toString();
    }

    /* compiled from: StreamAllocation.java */
    /* loaded from: classes2.dex */
    public static final class a extends WeakReference<g> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f7463a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f7463a = obj;
        }
    }
}

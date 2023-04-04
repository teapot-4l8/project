package okhttp3;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.ac;
import okhttp3.e;
import okhttp3.p;
import okhttp3.s;

/* compiled from: OkHttpClient.java */
/* loaded from: classes.dex */
public class x implements Cloneable, e.a {

    /* renamed from: a  reason: collision with root package name */
    static final List<y> f7735a = okhttp3.internal.c.a(y.HTTP_2, y.HTTP_1_1);

    /* renamed from: b  reason: collision with root package name */
    static final List<k> f7736b = okhttp3.internal.c.a(k.f7676b, k.f7678d);
    final int A;
    final int B;
    final int C;
    final int D;

    /* renamed from: c  reason: collision with root package name */
    final n f7737c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    final Proxy f7738d;

    /* renamed from: e  reason: collision with root package name */
    final List<y> f7739e;
    final List<k> f;
    final List<u> g;
    final List<u> h;
    final p.a i;
    final ProxySelector j;
    final m k;
    @Nullable
    final c l;
    @Nullable
    final okhttp3.internal.a.f m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final okhttp3.internal.i.c p;

    /* renamed from: q  reason: collision with root package name */
    final HostnameVerifier f7740q;
    final g r;
    final b s;
    final b t;
    final j u;
    final o v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        okhttp3.internal.a.f7398a = new okhttp3.internal.a() { // from class: okhttp3.x.1
            @Override // okhttp3.internal.a
            public void a(s.a aVar, String str) {
                aVar.a(str);
            }

            @Override // okhttp3.internal.a
            public void a(s.a aVar, String str, String str2) {
                aVar.b(str, str2);
            }

            @Override // okhttp3.internal.a
            public boolean a(j jVar, okhttp3.internal.b.c cVar) {
                return jVar.b(cVar);
            }

            @Override // okhttp3.internal.a
            public okhttp3.internal.b.c a(j jVar, okhttp3.a aVar, okhttp3.internal.b.g gVar, ae aeVar) {
                return jVar.a(aVar, gVar, aeVar);
            }

            @Override // okhttp3.internal.a
            public boolean a(okhttp3.a aVar, okhttp3.a aVar2) {
                return aVar.a(aVar2);
            }

            @Override // okhttp3.internal.a
            public Socket a(j jVar, okhttp3.a aVar, okhttp3.internal.b.g gVar) {
                return jVar.a(aVar, gVar);
            }

            @Override // okhttp3.internal.a
            public void b(j jVar, okhttp3.internal.b.c cVar) {
                jVar.a(cVar);
            }

            @Override // okhttp3.internal.a
            public okhttp3.internal.b.d a(j jVar) {
                return jVar.f7671a;
            }

            @Override // okhttp3.internal.a
            public int a(ac.a aVar) {
                return aVar.f7329c;
            }

            @Override // okhttp3.internal.a
            public void a(k kVar, SSLSocket sSLSocket, boolean z) {
                kVar.a(sSLSocket, z);
            }

            @Override // okhttp3.internal.a
            @Nullable
            public IOException a(e eVar, @Nullable IOException iOException) {
                return ((z) eVar).a(iOException);
            }
        };
    }

    public x() {
        this(new a());
    }

    x(a aVar) {
        boolean z;
        this.f7737c = aVar.f7741a;
        this.f7738d = aVar.f7742b;
        this.f7739e = aVar.f7743c;
        this.f = aVar.f7744d;
        this.g = okhttp3.internal.c.a(aVar.f7745e);
        this.h = okhttp3.internal.c.a(aVar.f);
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        loop0: while (true) {
            for (k kVar : this.f) {
                z = z || kVar.a();
            }
        }
        if (aVar.m != null || !z) {
            this.o = aVar.m;
            this.p = aVar.n;
        } else {
            X509TrustManager a2 = okhttp3.internal.c.a();
            this.o = a(a2);
            this.p = okhttp3.internal.i.c.a(a2);
        }
        if (this.o != null) {
            okhttp3.internal.g.f.c().a(this.o);
        }
        this.f7740q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.f7746q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        this.D = aVar.B;
        if (this.g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.g);
        } else if (this.h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.h);
        }
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext b2 = okhttp3.internal.g.f.c().b();
            b2.init(null, new TrustManager[]{x509TrustManager}, null);
            return b2.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw okhttp3.internal.c.a("No System TLS", (Exception) e2);
        }
    }

    public int a() {
        return this.z;
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public int d() {
        return this.C;
    }

    public int e() {
        return this.D;
    }

    @Nullable
    public Proxy f() {
        return this.f7738d;
    }

    public ProxySelector g() {
        return this.j;
    }

    public m h() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public okhttp3.internal.a.f i() {
        c cVar = this.l;
        return cVar != null ? cVar.f7349a : this.m;
    }

    public o j() {
        return this.v;
    }

    public SocketFactory k() {
        return this.n;
    }

    public SSLSocketFactory l() {
        return this.o;
    }

    public HostnameVerifier m() {
        return this.f7740q;
    }

    public g n() {
        return this.r;
    }

    public b o() {
        return this.t;
    }

    public b p() {
        return this.s;
    }

    public j q() {
        return this.u;
    }

    public boolean r() {
        return this.w;
    }

    public boolean s() {
        return this.x;
    }

    public boolean t() {
        return this.y;
    }

    public n u() {
        return this.f7737c;
    }

    public List<y> v() {
        return this.f7739e;
    }

    public List<k> w() {
        return this.f;
    }

    public List<u> x() {
        return this.g;
    }

    public List<u> y() {
        return this.h;
    }

    public p.a z() {
        return this.i;
    }

    @Override // okhttp3.e.a
    public e a(aa aaVar) {
        return z.a(this, aaVar, false);
    }

    public a A() {
        return new a(this);
    }

    /* compiled from: OkHttpClient.java */
    /* loaded from: classes.dex */
    public static final class a {
        int A;
        int B;

        /* renamed from: a  reason: collision with root package name */
        n f7741a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        Proxy f7742b;

        /* renamed from: c  reason: collision with root package name */
        List<y> f7743c;

        /* renamed from: d  reason: collision with root package name */
        List<k> f7744d;

        /* renamed from: e  reason: collision with root package name */
        final List<u> f7745e;
        final List<u> f;
        p.a g;
        ProxySelector h;
        m i;
        @Nullable
        c j;
        @Nullable
        okhttp3.internal.a.f k;
        SocketFactory l;
        @Nullable
        SSLSocketFactory m;
        @Nullable
        okhttp3.internal.i.c n;
        HostnameVerifier o;
        g p;

        /* renamed from: q  reason: collision with root package name */
        b f7746q;
        b r;
        j s;
        o t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.f7745e = new ArrayList();
            this.f = new ArrayList();
            this.f7741a = new n();
            this.f7743c = x.f7735a;
            this.f7744d = x.f7736b;
            this.g = p.a(p.f7696a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new okhttp3.internal.h.a();
            }
            this.i = m.f7689a;
            this.l = SocketFactory.getDefault();
            this.o = okhttp3.internal.i.d.f7663a;
            this.p = g.f7384a;
            this.f7746q = b.f7348a;
            this.r = b.f7348a;
            this.s = new j();
            this.t = o.f7695a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        a(x xVar) {
            this.f7745e = new ArrayList();
            this.f = new ArrayList();
            this.f7741a = xVar.f7737c;
            this.f7742b = xVar.f7738d;
            this.f7743c = xVar.f7739e;
            this.f7744d = xVar.f;
            this.f7745e.addAll(xVar.g);
            this.f.addAll(xVar.h);
            this.g = xVar.i;
            this.h = xVar.j;
            this.i = xVar.k;
            this.k = xVar.m;
            this.j = xVar.l;
            this.l = xVar.n;
            this.m = xVar.o;
            this.n = xVar.p;
            this.o = xVar.f7740q;
            this.p = xVar.r;
            this.f7746q = xVar.s;
            this.r = xVar.t;
            this.s = xVar.u;
            this.t = xVar.v;
            this.u = xVar.w;
            this.v = xVar.x;
            this.w = xVar.y;
            this.x = xVar.z;
            this.y = xVar.A;
            this.z = xVar.B;
            this.A = xVar.C;
            this.B = xVar.D;
        }

        public a a(long j, TimeUnit timeUnit) {
            this.y = okhttp3.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public a b(long j, TimeUnit timeUnit) {
            this.z = okhttp3.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public a c(long j, TimeUnit timeUnit) {
            this.A = okhttp3.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public a a(@Nullable c cVar) {
            this.j = cVar;
            this.k = null;
            return this;
        }

        public a a(boolean z) {
            this.w = z;
            return this;
        }

        public a a(u uVar) {
            if (uVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f7745e.add(uVar);
            return this;
        }

        public x a() {
            return new x(this);
        }
    }
}

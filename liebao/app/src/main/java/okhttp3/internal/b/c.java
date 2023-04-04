package okhttp3.internal.b;

import c.l;
import c.s;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ae;
import okhttp3.i;
import okhttp3.internal.e.g;
import okhttp3.j;
import okhttp3.k;
import okhttp3.p;
import okhttp3.r;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.y;

/* compiled from: RealConnection.java */
/* loaded from: classes.dex */
public final class c extends g.b implements i {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7443a;

    /* renamed from: b  reason: collision with root package name */
    public int f7444b;

    /* renamed from: c  reason: collision with root package name */
    public int f7445c = 1;

    /* renamed from: d  reason: collision with root package name */
    public final List<Reference<g>> f7446d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public long f7447e = Long.MAX_VALUE;
    private final j g;
    private final ae h;
    private Socket i;
    private Socket j;
    private r k;
    private y l;
    private okhttp3.internal.e.g m;
    private c.e n;
    private c.d o;

    public c(j jVar, ae aeVar) {
        this.g = jVar;
        this.h = aeVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0090 A[Catch: IOException -> 0x00f9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00f9, blocks: (B:18:0x0088, B:20:0x0090), top: B:67:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0142 A[EDGE_INSN: B:77:0x0142->B:61:0x0142 ?: BREAK  ] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, int i2, int i3, int i4, boolean z, okhttp3.e eVar, p pVar) {
        if (this.l != null) {
            throw new IllegalStateException("already connected");
        }
        List<k> f = this.h.a().f();
        b bVar = new b(f);
        if (this.h.a().i() == null) {
            if (!f.contains(k.f7678d)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String f2 = this.h.a().a().f();
            if (!okhttp3.internal.g.f.c().b(f2)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication to " + f2 + " not permitted by network security policy"));
            }
        } else if (this.h.a().e().contains(y.H2_PRIOR_KNOWLEDGE)) {
            throw new e(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        e eVar2 = null;
        do {
            try {
                try {
                    if (this.h.d()) {
                        a(i, i2, i3, eVar, pVar);
                        if (this.i == null) {
                            if (!this.h.d() && this.i == null) {
                                throw new e(new ProtocolException("Too many tunnel connections attempted: 21"));
                            }
                            if (this.m == null) {
                                synchronized (this.g) {
                                    this.f7445c = this.m.a();
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        try {
                            a(i, i2, eVar, pVar);
                        } catch (IOException e2) {
                            e = e2;
                            okhttp3.internal.c.a(this.j);
                            okhttp3.internal.c.a(this.i);
                            this.j = null;
                            this.i = null;
                            this.n = null;
                            this.o = null;
                            this.k = null;
                            this.l = null;
                            this.m = null;
                            pVar.a(eVar, this.h.c(), this.h.b(), null, e);
                            if (eVar2 != null) {
                                eVar2 = new e(e);
                            } else {
                                eVar2.a(e);
                            }
                            if (!z || bVar.a(e)) {
                                throw eVar2;
                            }
                            do {
                                if (this.h.d()) {
                                }
                                a(bVar, i4, eVar, pVar);
                                pVar.a(eVar, this.h.c(), this.h.b(), this.l);
                                if (!this.h.d()) {
                                }
                                if (this.m == null) {
                                }
                            } while (bVar.a(e));
                            throw eVar2;
                        }
                    }
                    a(bVar, i4, eVar, pVar);
                    pVar.a(eVar, this.h.c(), this.h.b(), this.l);
                    if (!this.h.d()) {
                    }
                    if (this.m == null) {
                    }
                } catch (IOException e3) {
                    e = e3;
                    okhttp3.internal.c.a(this.j);
                    okhttp3.internal.c.a(this.i);
                    this.j = null;
                    this.i = null;
                    this.n = null;
                    this.o = null;
                    this.k = null;
                    this.l = null;
                    this.m = null;
                    pVar.a(eVar, this.h.c(), this.h.b(), null, e);
                    if (eVar2 != null) {
                    }
                    if (!z || bVar.a(e)) {
                    }
                    do {
                        if (this.h.d()) {
                        }
                        a(bVar, i4, eVar, pVar);
                        pVar.a(eVar, this.h.c(), this.h.b(), this.l);
                        if (!this.h.d()) {
                        }
                        if (this.m == null) {
                        }
                    } while (bVar.a(e));
                    throw eVar2;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } while (bVar.a(e));
        throw eVar2;
    }

    private void a(int i, int i2, int i3, okhttp3.e eVar, p pVar) {
        aa g = g();
        t a2 = g.a();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, eVar, pVar);
            g = a(i2, i3, g, a2);
            if (g == null) {
                return;
            }
            okhttp3.internal.c.a(this.i);
            this.i = null;
            this.o = null;
            this.n = null;
            pVar.a(eVar, this.h.c(), this.h.b(), null);
        }
    }

    private void a(int i, int i2, okhttp3.e eVar, p pVar) {
        Socket createSocket;
        Proxy b2 = this.h.b();
        okhttp3.a a2 = this.h.a();
        if (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) {
            createSocket = a2.c().createSocket();
        } else {
            createSocket = new Socket(b2);
        }
        this.i = createSocket;
        pVar.a(eVar, this.h.c(), b2);
        this.i.setSoTimeout(i2);
        try {
            okhttp3.internal.g.f.c().a(this.i, this.h.c(), i);
            try {
                this.n = l.a(l.b(this.i));
                this.o = l.a(l.a(this.i));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.h.c());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(b bVar, int i, okhttp3.e eVar, p pVar) {
        if (this.h.a().i() == null) {
            if (this.h.a().e().contains(y.H2_PRIOR_KNOWLEDGE)) {
                this.j = this.i;
                this.l = y.H2_PRIOR_KNOWLEDGE;
                a(i);
                return;
            }
            this.j = this.i;
            this.l = y.HTTP_1_1;
            return;
        }
        pVar.b(eVar);
        a(bVar);
        pVar.a(eVar, this.k);
        if (this.l == y.HTTP_2) {
            a(i);
        }
    }

    private void a(int i) {
        this.j.setSoTimeout(0);
        okhttp3.internal.e.g a2 = new g.a(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a(i).a();
        this.m = a2;
        a2.c();
    }

    private void a(b bVar) {
        y yVar;
        okhttp3.a a2 = this.h.a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) a2.i().createSocket(this.i, a2.a().f(), a2.a().g(), true);
                try {
                    k a3 = bVar.a(sSLSocket2);
                    if (a3.d()) {
                        okhttp3.internal.g.f.c().a(sSLSocket2, a2.a().f(), a2.e());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    r a4 = r.a(session);
                    if (!a2.j().verify(a2.a().f(), session)) {
                        X509Certificate x509Certificate = (X509Certificate) a4.c().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + a2.a().f() + " not verified:\n    certificate: " + okhttp3.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + okhttp3.internal.i.d.a(x509Certificate));
                    }
                    a2.k().a(a2.a().f(), a4.c());
                    String a5 = a3.d() ? okhttp3.internal.g.f.c().a(sSLSocket2) : null;
                    this.j = sSLSocket2;
                    this.n = l.a(l.b(sSLSocket2));
                    this.o = l.a(l.a(this.j));
                    this.k = a4;
                    if (a5 != null) {
                        yVar = y.a(a5);
                    } else {
                        yVar = y.HTTP_1_1;
                    }
                    this.l = yVar;
                    if (sSLSocket2 != null) {
                        okhttp3.internal.g.f.c().b(sSLSocket2);
                    }
                } catch (AssertionError e2) {
                    e = e2;
                    if (!okhttp3.internal.c.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        okhttp3.internal.g.f.c().b(sSLSocket);
                    }
                    okhttp3.internal.c.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e3) {
            e = e3;
        }
    }

    private aa a(int i, int i2, aa aaVar, t tVar) {
        String str = "CONNECT " + okhttp3.internal.c.a(tVar, true) + " HTTP/1.1";
        while (true) {
            okhttp3.internal.d.a aVar = new okhttp3.internal.d.a(null, null, this.n, this.o);
            this.n.a().a(i, TimeUnit.MILLISECONDS);
            this.o.a().a(i2, TimeUnit.MILLISECONDS);
            aVar.a(aaVar.c(), str);
            aVar.b();
            ac a2 = aVar.a(false).a(aaVar).a();
            long a3 = okhttp3.internal.c.e.a(a2);
            if (a3 == -1) {
                a3 = 0;
            }
            s b2 = aVar.b(a3);
            okhttp3.internal.c.b(b2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b2.close();
            int c2 = a2.c();
            if (c2 == 200) {
                if (this.n.c().f() && this.o.c().f()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (c2 == 407) {
                aa a4 = this.h.a().d().a(this.h, a2);
                if (a4 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(a2.a("Connection"))) {
                    return a4;
                }
                aaVar = a4;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a2.c());
            }
        }
    }

    private aa g() {
        aa a2 = new aa.a().a(this.h.a().a()).a("CONNECT", (ab) null).a("Host", okhttp3.internal.c.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", okhttp3.internal.d.a()).a();
        aa a3 = this.h.a().d().a(this.h, new ac.a().a(a2).a(y.HTTP_1_1).a(407).a("Preemptive Authenticate").a(okhttp3.internal.c.f7466c).a(-1L).b(-1L).a("Proxy-Authenticate", "OkHttp-Preemptive").a());
        return a3 != null ? a3 : a2;
    }

    public boolean a(okhttp3.a aVar, @Nullable ae aeVar) {
        if (this.f7446d.size() >= this.f7445c || this.f7443a || !okhttp3.internal.a.f7398a.a(this.h.a(), aVar)) {
            return false;
        }
        if (aVar.a().f().equals(b().a().a().f())) {
            return true;
        }
        if (this.m != null && aeVar != null && aeVar.b().type() == Proxy.Type.DIRECT && this.h.b().type() == Proxy.Type.DIRECT && this.h.c().equals(aeVar.c()) && aeVar.a().j() == okhttp3.internal.i.d.f7663a && a(aVar.a())) {
            try {
                aVar.k().a(aVar.a().f(), e().c());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean a(t tVar) {
        if (tVar.g() != this.h.a().a().g()) {
            return false;
        }
        if (tVar.f().equals(this.h.a().a().f())) {
            return true;
        }
        return this.k != null && okhttp3.internal.i.d.f7663a.a(tVar.f(), (X509Certificate) this.k.c().get(0));
    }

    public okhttp3.internal.c.c a(x xVar, u.a aVar, g gVar) {
        okhttp3.internal.e.g gVar2 = this.m;
        if (gVar2 != null) {
            return new okhttp3.internal.e.f(xVar, aVar, gVar, gVar2);
        }
        this.j.setSoTimeout(aVar.d());
        this.n.a().a(aVar.d(), TimeUnit.MILLISECONDS);
        this.o.a().a(aVar.e(), TimeUnit.MILLISECONDS);
        return new okhttp3.internal.d.a(xVar, gVar, this.n, this.o);
    }

    public ae b() {
        return this.h;
    }

    public void c() {
        okhttp3.internal.c.a(this.i);
    }

    public Socket d() {
        return this.j;
    }

    public boolean a(boolean z) {
        if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
            return false;
        }
        okhttp3.internal.e.g gVar = this.m;
        if (gVar != null) {
            return !gVar.d();
        }
        if (z) {
            try {
                int soTimeout = this.j.getSoTimeout();
                try {
                    this.j.setSoTimeout(1);
                    return !this.n.f();
                } finally {
                    this.j.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // okhttp3.internal.e.g.b
    public void a(okhttp3.internal.e.i iVar) {
        iVar.a(okhttp3.internal.e.b.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.e.g.b
    public void a(okhttp3.internal.e.g gVar) {
        synchronized (this.g) {
            this.f7445c = gVar.a();
        }
    }

    public r e() {
        return this.k;
    }

    public boolean f() {
        return this.m != null;
    }

    @Override // okhttp3.i
    public y a() {
        return this.l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.h.a().a().f());
        sb.append(":");
        sb.append(this.h.a().a().g());
        sb.append(", proxy=");
        sb.append(this.h.b());
        sb.append(" hostAddress=");
        sb.append(this.h.c());
        sb.append(" cipherSuite=");
        r rVar = this.k;
        sb.append(rVar != null ? rVar.b() : "none");
        sb.append(" protocol=");
        sb.append(this.l);
        sb.append('}');
        return sb.toString();
    }
}

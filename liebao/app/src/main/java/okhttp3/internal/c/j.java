package okhttp3.internal.c;

import com.just.agentweb.AgentWebPermissions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.p;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;

/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: classes2.dex */
public final class j implements u {

    /* renamed from: a  reason: collision with root package name */
    private final x f7488a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7489b;

    /* renamed from: c  reason: collision with root package name */
    private volatile okhttp3.internal.b.g f7490c;

    /* renamed from: d  reason: collision with root package name */
    private Object f7491d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f7492e;

    public j(x xVar, boolean z) {
        this.f7488a = xVar;
        this.f7489b = z;
    }

    public void a() {
        this.f7492e = true;
        okhttp3.internal.b.g gVar = this.f7490c;
        if (gVar != null) {
            gVar.f();
        }
    }

    public boolean b() {
        return this.f7492e;
    }

    public void a(Object obj) {
        this.f7491d = obj;
    }

    @Override // okhttp3.u
    public ac a(u.a aVar) {
        ac a2;
        aa a3 = aVar.a();
        g gVar = (g) aVar;
        okhttp3.e h = gVar.h();
        p i = gVar.i();
        okhttp3.internal.b.g gVar2 = new okhttp3.internal.b.g(this.f7488a.q(), a(a3.a()), h, i, this.f7491d);
        this.f7490c = gVar2;
        ac acVar = null;
        int i2 = 0;
        while (!this.f7492e) {
            try {
                try {
                    a2 = gVar.a(a3, gVar2, null, null);
                    if (acVar != null) {
                        a2 = a2.i().c(acVar.i().a((ad) null).a()).a();
                    }
                } catch (IOException e2) {
                    if (!a(e2, gVar2, !(e2 instanceof okhttp3.internal.e.a), a3)) {
                        throw e2;
                    }
                } catch (okhttp3.internal.b.e e3) {
                    if (!a(e3.b(), gVar2, false, a3)) {
                        throw e3.a();
                    }
                }
                try {
                    aa a4 = a(a2, gVar2.b());
                    if (a4 == null) {
                        gVar2.d();
                        return a2;
                    }
                    okhttp3.internal.c.a(a2.h());
                    int i3 = i2 + 1;
                    if (i3 > 20) {
                        gVar2.d();
                        throw new ProtocolException("Too many follow-up requests: " + i3);
                    } else if (a4.d() instanceof l) {
                        gVar2.d();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", a2.c());
                    } else {
                        if (!a(a2, a4.a())) {
                            gVar2.d();
                            gVar2 = new okhttp3.internal.b.g(this.f7488a.q(), a(a4.a()), h, i, this.f7491d);
                            this.f7490c = gVar2;
                        } else if (gVar2.a() != null) {
                            throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                        }
                        acVar = a2;
                        a3 = a4;
                        i2 = i3;
                    }
                } catch (IOException e4) {
                    gVar2.d();
                    throw e4;
                }
            } catch (Throwable th) {
                gVar2.a((IOException) null);
                gVar2.d();
                throw th;
            }
        }
        gVar2.d();
        throw new IOException("Canceled");
    }

    private okhttp3.a a(t tVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        okhttp3.g gVar;
        if (tVar.c()) {
            SSLSocketFactory l = this.f7488a.l();
            hostnameVerifier = this.f7488a.m();
            sSLSocketFactory = l;
            gVar = this.f7488a.n();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new okhttp3.a(tVar.f(), tVar.g(), this.f7488a.j(), this.f7488a.k(), sSLSocketFactory, hostnameVerifier, gVar, this.f7488a.p(), this.f7488a.f(), this.f7488a.v(), this.f7488a.w(), this.f7488a.g());
    }

    private boolean a(IOException iOException, okhttp3.internal.b.g gVar, boolean z, aa aaVar) {
        gVar.a(iOException);
        if (this.f7488a.t()) {
            return !(z && (aaVar.d() instanceof l)) && a(iOException, z) && gVar.g();
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private aa a(ac acVar, ae aeVar) {
        String a2;
        t c2;
        Proxy f;
        if (acVar == null) {
            throw new IllegalStateException();
        }
        int c3 = acVar.c();
        String b2 = acVar.a().b();
        if (c3 == 307 || c3 == 308) {
            if (!b2.equals("GET") && !b2.equals("HEAD")) {
                return null;
            }
        } else if (c3 != 401) {
            if (c3 == 503) {
                if ((acVar.k() == null || acVar.k().c() != 503) && a(acVar, Integer.MAX_VALUE) == 0) {
                    return acVar.a();
                }
                return null;
            } else if (c3 == 407) {
                if (aeVar != null) {
                    f = aeVar.b();
                } else {
                    f = this.f7488a.f();
                }
                if (f.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f7488a.p().a(aeVar, acVar);
            } else if (c3 == 408) {
                if (this.f7488a.t() && !(acVar.a().d() instanceof l)) {
                    if ((acVar.k() == null || acVar.k().c() != 408) && a(acVar, 0) <= 0) {
                        return acVar.a();
                    }
                    return null;
                }
                return null;
            } else {
                switch (c3) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
        } else {
            return this.f7488a.o().a(aeVar, acVar);
        }
        if (!this.f7488a.s() || (a2 = acVar.a(AgentWebPermissions.ACTION_LOCATION)) == null || (c2 = acVar.a().a().c(a2)) == null) {
            return null;
        }
        if (c2.b().equals(acVar.a().a().b()) || this.f7488a.r()) {
            aa.a e2 = acVar.a().e();
            if (f.c(b2)) {
                boolean d2 = f.d(b2);
                if (f.e(b2)) {
                    e2.a("GET", (ab) null);
                } else {
                    e2.a(b2, d2 ? acVar.a().d() : null);
                }
                if (!d2) {
                    e2.b("Transfer-Encoding");
                    e2.b("Content-Length");
                    e2.b("Content-Type");
                }
            }
            if (!a(acVar, c2)) {
                e2.b("Authorization");
            }
            return e2.a(c2).a();
        }
        return null;
    }

    private int a(ac acVar, int i) {
        String a2 = acVar.a("Retry-After");
        if (a2 == null) {
            return i;
        }
        if (a2.matches("\\d+")) {
            return Integer.valueOf(a2).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean a(ac acVar, t tVar) {
        t a2 = acVar.a().a();
        return a2.f().equals(tVar.f()) && a2.g() == tVar.g() && a2.b().equals(tVar.b());
    }
}

package okhttp3.internal.c;

import c.r;
import java.net.ProtocolException;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.u;

/* compiled from: CallServerInterceptor.java */
/* loaded from: classes2.dex */
public final class b implements u {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f7473a;

    public b(boolean z) {
        this.f7473a = z;
    }

    @Override // okhttp3.u
    public ac a(u.a aVar) {
        ac a2;
        g gVar = (g) aVar;
        c g = gVar.g();
        okhttp3.internal.b.g f = gVar.f();
        okhttp3.internal.b.c cVar = (okhttp3.internal.b.c) gVar.b();
        aa a3 = gVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.i().c(gVar.h());
        g.a(a3);
        gVar.i().a(gVar.h(), a3);
        ac.a aVar2 = null;
        if (f.c(a3.b()) && a3.d() != null) {
            if ("100-continue".equalsIgnoreCase(a3.a("Expect"))) {
                g.a();
                gVar.i().e(gVar.h());
                aVar2 = g.a(true);
            }
            if (aVar2 == null) {
                gVar.i().d(gVar.h());
                a aVar3 = new a(g.a(a3, a3.d().c()));
                c.d a4 = c.l.a(aVar3);
                a3.d().a(a4);
                a4.close();
                gVar.i().a(gVar.h(), aVar3.f7474a);
            } else if (!cVar.f()) {
                f.e();
            }
        }
        g.b();
        if (aVar2 == null) {
            gVar.i().e(gVar.h());
            aVar2 = g.a(false);
        }
        ac a5 = aVar2.a(a3).a(f.c().e()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
        int c2 = a5.c();
        if (c2 == 100) {
            a5 = g.a(false).a(a3).a(f.c().e()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
            c2 = a5.c();
        }
        gVar.i().a(gVar.h(), a5);
        if (this.f7473a && c2 == 101) {
            a2 = a5.i().a(okhttp3.internal.c.f7466c).a();
        } else {
            a2 = a5.i().a(g.a(a5)).a();
        }
        if ("close".equalsIgnoreCase(a2.a().a("Connection")) || "close".equalsIgnoreCase(a2.a("Connection"))) {
            f.e();
        }
        if ((c2 == 204 || c2 == 205) && a2.h().b() > 0) {
            throw new ProtocolException("HTTP " + c2 + " had non-zero Content-Length: " + a2.h().b());
        }
        return a2;
    }

    /* compiled from: CallServerInterceptor.java */
    /* loaded from: classes2.dex */
    static final class a extends c.g {

        /* renamed from: a  reason: collision with root package name */
        long f7474a;

        a(r rVar) {
            super(rVar);
        }

        @Override // c.g, c.r
        public void a_(c.c cVar, long j) {
            super.a_(cVar, j);
            this.f7474a += j;
        }
    }
}

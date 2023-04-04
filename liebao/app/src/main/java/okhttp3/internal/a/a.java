package okhttp3.internal.a;

import c.l;
import c.r;
import c.s;
import c.t;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.internal.a.c;
import okhttp3.internal.c.h;
import okhttp3.s;
import okhttp3.u;
import okhttp3.y;

/* compiled from: CacheInterceptor.java */
/* loaded from: classes2.dex */
public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    final f f7399a;

    public a(f fVar) {
        this.f7399a = fVar;
    }

    @Override // okhttp3.u
    public ac a(u.a aVar) {
        f fVar = this.f7399a;
        ac a2 = fVar != null ? fVar.a(aVar.a()) : null;
        c a3 = new c.a(System.currentTimeMillis(), aVar.a(), a2).a();
        aa aaVar = a3.f7405a;
        ac acVar = a3.f7406b;
        f fVar2 = this.f7399a;
        if (fVar2 != null) {
            fVar2.a(a3);
        }
        if (a2 != null && acVar == null) {
            okhttp3.internal.c.a(a2.h());
        }
        if (aaVar == null && acVar == null) {
            return new ac.a().a(aVar.a()).a(y.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(okhttp3.internal.c.f7466c).a(-1L).b(System.currentTimeMillis()).a();
        }
        if (aaVar == null) {
            return acVar.i().b(a(acVar)).a();
        }
        try {
            ac a4 = aVar.a(aaVar);
            if (a4 == null && a2 != null) {
            }
            if (acVar != null) {
                if (a4.c() == 304) {
                    ac a5 = acVar.i().a(a(acVar.g(), a4.g())).a(a4.m()).b(a4.n()).b(a(acVar)).a(a(a4)).a();
                    a4.h().close();
                    this.f7399a.a();
                    this.f7399a.a(acVar, a5);
                    return a5;
                }
                okhttp3.internal.c.a(acVar.h());
            }
            ac a6 = a4.i().b(a(acVar)).a(a(a4)).a();
            if (this.f7399a != null) {
                if (okhttp3.internal.c.e.d(a6) && c.a(a6, aaVar)) {
                    return a(this.f7399a.a(a6), a6);
                }
                if (okhttp3.internal.c.f.a(aaVar.b())) {
                    try {
                        this.f7399a.b(aaVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a6;
        } finally {
            if (a2 != null) {
                okhttp3.internal.c.a(a2.h());
            }
        }
    }

    private static ac a(ac acVar) {
        return (acVar == null || acVar.h() == null) ? acVar : acVar.i().a((ad) null).a();
    }

    private ac a(final b bVar, ac acVar) {
        r b2;
        if (bVar == null || (b2 = bVar.b()) == null) {
            return acVar;
        }
        final c.e c2 = acVar.h().c();
        final c.d a2 = l.a(b2);
        return acVar.i().a(new h(acVar.a("Content-Type"), acVar.h().b(), l.a(new s() { // from class: okhttp3.internal.a.a.1

            /* renamed from: a  reason: collision with root package name */
            boolean f7400a;

            @Override // c.s
            public long a(c.c cVar, long j) {
                try {
                    long a3 = c2.a(cVar, j);
                    if (a3 == -1) {
                        if (!this.f7400a) {
                            this.f7400a = true;
                            a2.close();
                        }
                        return -1L;
                    }
                    cVar.a(a2.c(), cVar.b() - a3, a3);
                    a2.x();
                    return a3;
                } catch (IOException e2) {
                    if (!this.f7400a) {
                        this.f7400a = true;
                        bVar.a();
                    }
                    throw e2;
                }
            }

            @Override // c.s
            public t a() {
                return c2.a();
            }

            @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (!this.f7400a && !okhttp3.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f7400a = true;
                    bVar.a();
                }
                c2.close();
            }
        }))).a();
    }

    private static okhttp3.s a(okhttp3.s sVar, okhttp3.s sVar2) {
        s.a aVar = new s.a();
        int a2 = sVar.a();
        for (int i = 0; i < a2; i++) {
            String a3 = sVar.a(i);
            String b2 = sVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a3) || !b2.startsWith("1")) && (b(a3) || !a(a3) || sVar2.a(a3) == null)) {
                okhttp3.internal.a.f7398a.a(aVar, a3, b2);
            }
        }
        int a4 = sVar2.a();
        for (int i2 = 0; i2 < a4; i2++) {
            String a5 = sVar2.a(i2);
            if (!b(a5) && a(a5)) {
                okhttp3.internal.a.f7398a.a(aVar, a5, sVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    static boolean b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}

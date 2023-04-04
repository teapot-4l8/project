package okhttp3.internal.e;

import c.r;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.s;
import okhttp3.u;
import okhttp3.x;
import okhttp3.y;

/* compiled from: Http2Codec.java */
/* loaded from: classes2.dex */
public final class f implements okhttp3.internal.c.c {

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f7541b = okhttp3.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f7542c = okhttp3.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    final okhttp3.internal.b.g f7543a;

    /* renamed from: d  reason: collision with root package name */
    private final u.a f7544d;

    /* renamed from: e  reason: collision with root package name */
    private final g f7545e;
    private i f;
    private final y g;

    public f(x xVar, u.a aVar, okhttp3.internal.b.g gVar, g gVar2) {
        y yVar;
        this.f7544d = aVar;
        this.f7543a = gVar;
        this.f7545e = gVar2;
        if (xVar.v().contains(y.H2_PRIOR_KNOWLEDGE)) {
            yVar = y.H2_PRIOR_KNOWLEDGE;
        } else {
            yVar = y.HTTP_2;
        }
        this.g = yVar;
    }

    @Override // okhttp3.internal.c.c
    public r a(aa aaVar, long j) {
        return this.f.h();
    }

    @Override // okhttp3.internal.c.c
    public void a(aa aaVar) {
        if (this.f != null) {
            return;
        }
        i a2 = this.f7545e.a(b(aaVar), aaVar.d() != null);
        this.f = a2;
        a2.e().a(this.f7544d.d(), TimeUnit.MILLISECONDS);
        this.f.f().a(this.f7544d.e(), TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.internal.c.c
    public void a() {
        this.f7545e.b();
    }

    @Override // okhttp3.internal.c.c
    public void b() {
        this.f.h().close();
    }

    @Override // okhttp3.internal.c.c
    public ac.a a(boolean z) {
        ac.a a2 = a(this.f.d(), this.g);
        if (z && okhttp3.internal.a.f7398a.a(a2) == 100) {
            return null;
        }
        return a2;
    }

    public static List<c> b(aa aaVar) {
        s c2 = aaVar.c();
        ArrayList arrayList = new ArrayList(c2.a() + 4);
        arrayList.add(new c(c.f7522c, aaVar.b()));
        arrayList.add(new c(c.f7523d, okhttp3.internal.c.i.a(aaVar.a())));
        String a2 = aaVar.a("Host");
        if (a2 != null) {
            arrayList.add(new c(c.f, a2));
        }
        arrayList.add(new c(c.f7524e, aaVar.a().b()));
        int a3 = c2.a();
        for (int i = 0; i < a3; i++) {
            c.f a4 = c.f.a(c2.a(i).toLowerCase(Locale.US));
            if (!f7541b.contains(a4.a())) {
                arrayList.add(new c(a4, c2.b(i)));
            }
        }
        return arrayList;
    }

    public static ac.a a(s sVar, y yVar) {
        s.a aVar = new s.a();
        int a2 = sVar.a();
        okhttp3.internal.c.k kVar = null;
        for (int i = 0; i < a2; i++) {
            String a3 = sVar.a(i);
            String b2 = sVar.b(i);
            if (a3.equals(":status")) {
                kVar = okhttp3.internal.c.k.a("HTTP/1.1 " + b2);
            } else if (!f7542c.contains(a3)) {
                okhttp3.internal.a.f7398a.a(aVar, a3, b2);
            }
        }
        if (kVar == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new ac.a().a(yVar).a(kVar.f7494b).a(kVar.f7495c).a(aVar.a());
    }

    @Override // okhttp3.internal.c.c
    public ad a(ac acVar) {
        this.f7543a.f7461c.f(this.f7543a.f7460b);
        return new okhttp3.internal.c.h(acVar.a("Content-Type"), okhttp3.internal.c.e.a(acVar), c.l.a(new a(this.f.g())));
    }

    @Override // okhttp3.internal.c.c
    public void c() {
        i iVar = this.f;
        if (iVar != null) {
            iVar.b(b.CANCEL);
        }
    }

    /* compiled from: Http2Codec.java */
    /* loaded from: classes2.dex */
    class a extends c.h {

        /* renamed from: a  reason: collision with root package name */
        boolean f7546a;

        /* renamed from: b  reason: collision with root package name */
        long f7547b;

        a(c.s sVar) {
            super(sVar);
            this.f7546a = false;
            this.f7547b = 0L;
        }

        @Override // c.h, c.s
        public long a(c.c cVar, long j) {
            try {
                long a2 = b().a(cVar, j);
                if (a2 > 0) {
                    this.f7547b += a2;
                }
                return a2;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }

        @Override // c.h, c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            a(null);
        }

        private void a(IOException iOException) {
            if (this.f7546a) {
                return;
            }
            this.f7546a = true;
            f.this.f7543a.a(false, f.this, this.f7547b, iOException);
        }
    }
}

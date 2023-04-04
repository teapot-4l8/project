package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.internal.a.d;
import okhttp3.s;

/* compiled from: Cache.java */
/* loaded from: classes.dex */
public final class c implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    final okhttp3.internal.a.f f7349a;

    /* renamed from: b  reason: collision with root package name */
    final okhttp3.internal.a.d f7350b;

    /* renamed from: c  reason: collision with root package name */
    int f7351c;

    /* renamed from: d  reason: collision with root package name */
    int f7352d;

    /* renamed from: e  reason: collision with root package name */
    private int f7353e;
    private int f;
    private int g;

    public c(File file, long j) {
        this(file, j, okhttp3.internal.f.a.f7633a);
    }

    c(File file, long j, okhttp3.internal.f.a aVar) {
        this.f7349a = new okhttp3.internal.a.f() { // from class: okhttp3.c.1
            @Override // okhttp3.internal.a.f
            public ac a(aa aaVar) {
                return c.this.a(aaVar);
            }

            @Override // okhttp3.internal.a.f
            public okhttp3.internal.a.b a(ac acVar) {
                return c.this.a(acVar);
            }

            @Override // okhttp3.internal.a.f
            public void b(aa aaVar) {
                c.this.b(aaVar);
            }

            @Override // okhttp3.internal.a.f
            public void a(ac acVar, ac acVar2) {
                c.this.a(acVar, acVar2);
            }

            @Override // okhttp3.internal.a.f
            public void a() {
                c.this.a();
            }

            @Override // okhttp3.internal.a.f
            public void a(okhttp3.internal.a.c cVar) {
                c.this.a(cVar);
            }
        };
        this.f7350b = okhttp3.internal.a.d.a(aVar, file, 201105, 2, j);
    }

    public static String a(t tVar) {
        return c.f.a(tVar.toString()).c().f();
    }

    @Nullable
    ac a(aa aaVar) {
        try {
            d.c a2 = this.f7350b.a(a(aaVar.a()));
            if (a2 == null) {
                return null;
            }
            try {
                C0185c c0185c = new C0185c(a2.a(0));
                ac a3 = c0185c.a(a2);
                if (c0185c.a(aaVar, a3)) {
                    return a3;
                }
                okhttp3.internal.c.a(a3.h());
                return null;
            } catch (IOException unused) {
                okhttp3.internal.c.a(a2);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    @Nullable
    okhttp3.internal.a.b a(ac acVar) {
        d.a aVar;
        String b2 = acVar.a().b();
        if (okhttp3.internal.c.f.a(acVar.a().b())) {
            try {
                b(acVar.a());
            } catch (IOException unused) {
            }
            return null;
        } else if (!b2.equals("GET") || okhttp3.internal.c.e.b(acVar)) {
            return null;
        } else {
            C0185c c0185c = new C0185c(acVar);
            try {
                aVar = this.f7350b.b(a(acVar.a().a()));
                if (aVar == null) {
                    return null;
                }
                try {
                    c0185c.a(aVar);
                    return new a(aVar);
                } catch (IOException unused2) {
                    a(aVar);
                    return null;
                }
            } catch (IOException unused3) {
                aVar = null;
            }
        }
    }

    void b(aa aaVar) {
        this.f7350b.c(a(aaVar.a()));
    }

    void a(ac acVar, ac acVar2) {
        d.a aVar;
        C0185c c0185c = new C0185c(acVar2);
        try {
            aVar = ((b) acVar.h()).f7363a.a();
            if (aVar != null) {
                try {
                    c0185c.a(aVar);
                    aVar.b();
                } catch (IOException unused) {
                    a(aVar);
                }
            }
        } catch (IOException unused2) {
            aVar = null;
        }
    }

    private void a(@Nullable d.a aVar) {
        if (aVar != null) {
            try {
                aVar.c();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Flushable
    public void flush() {
        this.f7350b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7350b.close();
    }

    synchronized void a(okhttp3.internal.a.c cVar) {
        this.g++;
        if (cVar.f7405a != null) {
            this.f7353e++;
        } else if (cVar.f7406b != null) {
            this.f++;
        }
    }

    synchronized void a() {
        this.f++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* loaded from: classes2.dex */
    public final class a implements okhttp3.internal.a.b {

        /* renamed from: a  reason: collision with root package name */
        boolean f7355a;

        /* renamed from: c  reason: collision with root package name */
        private final d.a f7357c;

        /* renamed from: d  reason: collision with root package name */
        private c.r f7358d;

        /* renamed from: e  reason: collision with root package name */
        private c.r f7359e;

        a(final d.a aVar) {
            this.f7357c = aVar;
            c.r a2 = aVar.a(1);
            this.f7358d = a2;
            this.f7359e = new c.g(a2) { // from class: okhttp3.c.a.1
                @Override // c.g, c.r, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (c.this) {
                        if (a.this.f7355a) {
                            return;
                        }
                        a.this.f7355a = true;
                        c.this.f7351c++;
                        super.close();
                        aVar.b();
                    }
                }
            };
        }

        @Override // okhttp3.internal.a.b
        public void a() {
            synchronized (c.this) {
                if (this.f7355a) {
                    return;
                }
                this.f7355a = true;
                c.this.f7352d++;
                okhttp3.internal.c.a(this.f7358d);
                try {
                    this.f7357c.c();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.a.b
        public c.r b() {
            return this.f7359e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* renamed from: okhttp3.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0185c {

        /* renamed from: a  reason: collision with root package name */
        private static final String f7369a = okhttp3.internal.g.f.c().d() + "-Sent-Millis";

        /* renamed from: b  reason: collision with root package name */
        private static final String f7370b = okhttp3.internal.g.f.c().d() + "-Received-Millis";

        /* renamed from: c  reason: collision with root package name */
        private final String f7371c;

        /* renamed from: d  reason: collision with root package name */
        private final s f7372d;

        /* renamed from: e  reason: collision with root package name */
        private final String f7373e;
        private final y f;
        private final int g;
        private final String h;
        private final s i;
        @Nullable
        private final r j;
        private final long k;
        private final long l;

        C0185c(c.s sVar) {
            af afVar;
            try {
                c.e a2 = c.l.a(sVar);
                this.f7371c = a2.r();
                this.f7373e = a2.r();
                s.a aVar = new s.a();
                int a3 = c.a(a2);
                for (int i = 0; i < a3; i++) {
                    aVar.a(a2.r());
                }
                this.f7372d = aVar.a();
                okhttp3.internal.c.k a4 = okhttp3.internal.c.k.a(a2.r());
                this.f = a4.f7493a;
                this.g = a4.f7494b;
                this.h = a4.f7495c;
                s.a aVar2 = new s.a();
                int a5 = c.a(a2);
                for (int i2 = 0; i2 < a5; i2++) {
                    aVar2.a(a2.r());
                }
                String c2 = aVar2.c(f7369a);
                String c3 = aVar2.c(f7370b);
                aVar2.b(f7369a);
                aVar2.b(f7370b);
                this.k = c2 != null ? Long.parseLong(c2) : 0L;
                this.l = c3 != null ? Long.parseLong(c3) : 0L;
                this.i = aVar2.a();
                if (a()) {
                    String r = a2.r();
                    if (r.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + r + "\"");
                    }
                    h a6 = h.a(a2.r());
                    List<Certificate> a7 = a(a2);
                    List<Certificate> a8 = a(a2);
                    if (!a2.f()) {
                        afVar = af.a(a2.r());
                    } else {
                        afVar = af.SSL_3_0;
                    }
                    this.j = r.a(afVar, a6, a7, a8);
                } else {
                    this.j = null;
                }
            } finally {
                sVar.close();
            }
        }

        C0185c(ac acVar) {
            this.f7371c = acVar.a().a().toString();
            this.f7372d = okhttp3.internal.c.e.c(acVar);
            this.f7373e = acVar.a().b();
            this.f = acVar.b();
            this.g = acVar.c();
            this.h = acVar.e();
            this.i = acVar.g();
            this.j = acVar.f();
            this.k = acVar.m();
            this.l = acVar.n();
        }

        public void a(d.a aVar) {
            c.d a2 = c.l.a(aVar.a(0));
            a2.b(this.f7371c).i(10);
            a2.b(this.f7373e).i(10);
            a2.m(this.f7372d.a()).i(10);
            int a3 = this.f7372d.a();
            for (int i = 0; i < a3; i++) {
                a2.b(this.f7372d.a(i)).b(": ").b(this.f7372d.b(i)).i(10);
            }
            a2.b(new okhttp3.internal.c.k(this.f, this.g, this.h).toString()).i(10);
            a2.m(this.i.a() + 2).i(10);
            int a4 = this.i.a();
            for (int i2 = 0; i2 < a4; i2++) {
                a2.b(this.i.a(i2)).b(": ").b(this.i.b(i2)).i(10);
            }
            a2.b(f7369a).b(": ").m(this.k).i(10);
            a2.b(f7370b).b(": ").m(this.l).i(10);
            if (a()) {
                a2.i(10);
                a2.b(this.j.b().a()).i(10);
                a(a2, this.j.c());
                a(a2, this.j.d());
                a2.b(this.j.a().a()).i(10);
            }
            a2.close();
        }

        private boolean a() {
            return this.f7371c.startsWith("https://");
        }

        private List<Certificate> a(c.e eVar) {
            int a2 = c.a(eVar);
            if (a2 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a2);
                for (int i = 0; i < a2; i++) {
                    String r = eVar.r();
                    c.c cVar = new c.c();
                    cVar.b(c.f.b(r));
                    arrayList.add(certificateFactory.generateCertificate(cVar.g()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void a(c.d dVar, List<Certificate> list) {
            try {
                dVar.m(list.size()).i(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dVar.b(c.f.a(list.get(i).getEncoded()).b()).i(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public boolean a(aa aaVar, ac acVar) {
            return this.f7371c.equals(aaVar.a().toString()) && this.f7373e.equals(aaVar.b()) && okhttp3.internal.c.e.a(acVar, this.f7372d, aaVar);
        }

        public ac a(d.c cVar) {
            String a2 = this.i.a("Content-Type");
            String a3 = this.i.a("Content-Length");
            return new ac.a().a(new aa.a().a(this.f7371c).a(this.f7373e, (ab) null).a(this.f7372d).a()).a(this.f).a(this.g).a(this.h).a(this.i).a(new b(cVar, a2, a3)).a(this.j).a(this.k).b(this.l).a();
        }
    }

    static int a(c.e eVar) {
        try {
            long n = eVar.n();
            String r = eVar.r();
            if (n < 0 || n > 2147483647L || !r.isEmpty()) {
                throw new IOException("expected an int but was \"" + n + r + "\"");
            }
            return (int) n;
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* loaded from: classes.dex */
    public static class b extends ad {

        /* renamed from: a  reason: collision with root package name */
        final d.c f7363a;

        /* renamed from: b  reason: collision with root package name */
        private final c.e f7364b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final String f7365c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final String f7366d;

        b(final d.c cVar, String str, String str2) {
            this.f7363a = cVar;
            this.f7365c = str;
            this.f7366d = str2;
            this.f7364b = c.l.a(new c.h(cVar.a(1)) { // from class: okhttp3.c.b.1
                @Override // c.h, c.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    cVar.close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ad
        public v a() {
            String str = this.f7365c;
            if (str != null) {
                return v.b(str);
            }
            return null;
        }

        @Override // okhttp3.ad
        public long b() {
            try {
                if (this.f7366d != null) {
                    return Long.parseLong(this.f7366d);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.ad
        public c.e c() {
            return this.f7364b;
        }
    }
}

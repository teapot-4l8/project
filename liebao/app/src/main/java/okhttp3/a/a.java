package okhttp3.a;

import c.c;
import c.j;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.i;
import okhttp3.internal.c.e;
import okhttp3.internal.g.f;
import okhttp3.s;
import okhttp3.u;
import okhttp3.v;

/* compiled from: HttpLoggingInterceptor.java */
/* loaded from: classes2.dex */
public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f7294a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private final b f7295b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Set<String> f7296c;

    /* renamed from: d  reason: collision with root package name */
    private volatile EnumC0184a f7297d;

    /* compiled from: HttpLoggingInterceptor.java */
    /* renamed from: okhttp3.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0184a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.java */
    /* loaded from: classes2.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f7303a = new b() { // from class: okhttp3.a.a.b.1
            @Override // okhttp3.a.a.b
            public void a(String str) {
                f.c().a(4, str, (Throwable) null);
            }
        };

        void a(String str);
    }

    public a() {
        this(b.f7303a);
    }

    public a(b bVar) {
        this.f7296c = Collections.emptySet();
        this.f7297d = EnumC0184a.NONE;
        this.f7295b = bVar;
    }

    public a a(EnumC0184a enumC0184a) {
        if (enumC0184a == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.f7297d = enumC0184a;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.Long] */
    @Override // okhttp3.u
    public ac a(u.a aVar) {
        long j;
        char c2;
        String sb;
        j jVar;
        EnumC0184a enumC0184a = this.f7297d;
        aa a2 = aVar.a();
        if (enumC0184a == EnumC0184a.NONE) {
            return aVar.a(a2);
        }
        boolean z = enumC0184a == EnumC0184a.BODY;
        boolean z2 = z || enumC0184a == EnumC0184a.HEADERS;
        ab d2 = a2.d();
        boolean z3 = d2 != null;
        i b2 = aVar.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(a2.b());
        sb2.append(' ');
        sb2.append(a2.a());
        sb2.append(b2 != null ? " " + b2.a() : "");
        String sb3 = sb2.toString();
        if (!z2 && z3) {
            sb3 = sb3 + " (" + d2.c() + "-byte body)";
        }
        this.f7295b.a(sb3);
        if (z2) {
            if (z3) {
                if (d2.b() != null) {
                    this.f7295b.a("Content-Type: " + d2.b());
                }
                if (d2.c() != -1) {
                    this.f7295b.a("Content-Length: " + d2.c());
                }
            }
            s c3 = a2.c();
            int a3 = c3.a();
            for (int i = 0; i < a3; i++) {
                String a4 = c3.a(i);
                if (!"Content-Type".equalsIgnoreCase(a4) && !"Content-Length".equalsIgnoreCase(a4)) {
                    a(c3, i);
                }
            }
            if (!z || !z3) {
                this.f7295b.a("--> END " + a2.b());
            } else if (a(a2.c())) {
                this.f7295b.a("--> END " + a2.b() + " (encoded body omitted)");
            } else {
                c cVar = new c();
                d2.a(cVar);
                Charset charset = f7294a;
                v b3 = d2.b();
                if (b3 != null) {
                    charset = b3.a(f7294a);
                }
                this.f7295b.a("");
                if (a(cVar)) {
                    this.f7295b.a(cVar.a(charset));
                    this.f7295b.a("--> END " + a2.b() + " (" + d2.c() + "-byte body)");
                } else {
                    this.f7295b.a("--> END " + a2.b() + " (binary " + d2.c() + "-byte body omitted)");
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            ac a5 = aVar.a(a2);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ad h = a5.h();
            long b4 = h.b();
            String str = b4 != -1 ? b4 + "-byte" : "unknown-length";
            b bVar = this.f7295b;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("<-- ");
            sb4.append(a5.c());
            if (a5.e().isEmpty()) {
                sb = "";
                j = b4;
                c2 = ' ';
            } else {
                StringBuilder sb5 = new StringBuilder();
                j = b4;
                c2 = ' ';
                sb5.append(' ');
                sb5.append(a5.e());
                sb = sb5.toString();
            }
            sb4.append(sb);
            sb4.append(c2);
            sb4.append(a5.a().a());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append("ms");
            sb4.append(z2 ? "" : ", " + str + " body");
            sb4.append(')');
            bVar.a(sb4.toString());
            if (z2) {
                s g = a5.g();
                int a6 = g.a();
                for (int i2 = 0; i2 < a6; i2++) {
                    a(g, i2);
                }
                if (!z || !e.d(a5)) {
                    this.f7295b.a("<-- END HTTP");
                } else if (a(a5.g())) {
                    this.f7295b.a("<-- END HTTP (encoded body omitted)");
                } else {
                    c.e c4 = h.c();
                    c4.b(Long.MAX_VALUE);
                    c c5 = c4.c();
                    j jVar2 = null;
                    if ("gzip".equalsIgnoreCase(g.a("Content-Encoding"))) {
                        ?? valueOf = Long.valueOf(c5.b());
                        try {
                            jVar = new j(c5.clone());
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            c5 = new c();
                            c5.a(jVar);
                            jVar.close();
                            jVar2 = valueOf;
                        } catch (Throwable th2) {
                            th = th2;
                            jVar2 = jVar;
                            if (jVar2 != null) {
                                jVar2.close();
                            }
                            throw th;
                        }
                    }
                    Charset charset2 = f7294a;
                    v a7 = h.a();
                    if (a7 != null) {
                        charset2 = a7.a(f7294a);
                    }
                    if (!a(c5)) {
                        this.f7295b.a("");
                        this.f7295b.a("<-- END HTTP (binary " + c5.b() + "-byte body omitted)");
                        return a5;
                    }
                    if (j != 0) {
                        this.f7295b.a("");
                        this.f7295b.a(c5.clone().a(charset2));
                    }
                    if (jVar2 != null) {
                        this.f7295b.a("<-- END HTTP (" + c5.b() + "-byte, " + jVar2 + "-gzipped-byte body)");
                    } else {
                        this.f7295b.a("<-- END HTTP (" + c5.b() + "-byte body)");
                    }
                }
            }
            return a5;
        } catch (Exception e2) {
            this.f7295b.a("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    private void a(s sVar, int i) {
        String b2 = this.f7296c.contains(sVar.a(i)) ? "██" : sVar.b(i);
        b bVar = this.f7295b;
        bVar.a(sVar.a(i) + ": " + b2);
    }

    static boolean a(c cVar) {
        try {
            c cVar2 = new c();
            cVar.a(cVar2, 0L, cVar.b() < 64 ? cVar.b() : 64L);
            for (int i = 0; i < 16; i++) {
                if (cVar2.f()) {
                    return true;
                }
                int s = cVar2.s();
                if (Character.isISOControl(s) && !Character.isWhitespace(s)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private static boolean a(s sVar) {
        String a2 = sVar.a("Content-Encoding");
        return (a2 == null || a2.equalsIgnoreCase("identity") || a2.equalsIgnoreCase("gzip")) ? false : true;
    }
}

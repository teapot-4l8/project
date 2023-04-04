package okhttp3.internal.d;

import c.l;
import c.r;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.internal.b.g;
import okhttp3.internal.c.h;
import okhttp3.internal.c.i;
import okhttp3.internal.c.k;
import okhttp3.s;
import okhttp3.t;
import okhttp3.x;

/* compiled from: Http1Codec.java */
/* loaded from: classes2.dex */
public final class a implements okhttp3.internal.c.c {

    /* renamed from: a  reason: collision with root package name */
    final x f7496a;

    /* renamed from: b  reason: collision with root package name */
    final g f7497b;

    /* renamed from: c  reason: collision with root package name */
    final c.e f7498c;

    /* renamed from: d  reason: collision with root package name */
    final c.d f7499d;

    /* renamed from: e  reason: collision with root package name */
    int f7500e = 0;
    private long f = 262144;

    public a(x xVar, g gVar, c.e eVar, c.d dVar) {
        this.f7496a = xVar;
        this.f7497b = gVar;
        this.f7498c = eVar;
        this.f7499d = dVar;
    }

    @Override // okhttp3.internal.c.c
    public r a(aa aaVar, long j) {
        if ("chunked".equalsIgnoreCase(aaVar.a("Transfer-Encoding"))) {
            return e();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.c.c
    public void c() {
        okhttp3.internal.b.c c2 = this.f7497b.c();
        if (c2 != null) {
            c2.c();
        }
    }

    @Override // okhttp3.internal.c.c
    public void a(aa aaVar) {
        a(aaVar.c(), i.a(aaVar, this.f7497b.c().b().b().type()));
    }

    @Override // okhttp3.internal.c.c
    public ad a(ac acVar) {
        this.f7497b.f7461c.f(this.f7497b.f7460b);
        String a2 = acVar.a("Content-Type");
        if (!okhttp3.internal.c.e.d(acVar)) {
            return new h(a2, 0L, l.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(acVar.a("Transfer-Encoding"))) {
            return new h(a2, -1L, l.a(a(acVar.a().a())));
        }
        long a3 = okhttp3.internal.c.e.a(acVar);
        if (a3 != -1) {
            return new h(a2, a3, l.a(b(a3)));
        }
        return new h(a2, -1L, l.a(f()));
    }

    @Override // okhttp3.internal.c.c
    public void a() {
        this.f7499d.flush();
    }

    @Override // okhttp3.internal.c.c
    public void b() {
        this.f7499d.flush();
    }

    public void a(s sVar, String str) {
        if (this.f7500e != 0) {
            throw new IllegalStateException("state: " + this.f7500e);
        }
        this.f7499d.b(str).b("\r\n");
        int a2 = sVar.a();
        for (int i = 0; i < a2; i++) {
            this.f7499d.b(sVar.a(i)).b(": ").b(sVar.b(i)).b("\r\n");
        }
        this.f7499d.b("\r\n");
        this.f7500e = 1;
    }

    @Override // okhttp3.internal.c.c
    public ac.a a(boolean z) {
        int i = this.f7500e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f7500e);
        }
        try {
            k a2 = k.a(g());
            ac.a a3 = new ac.a().a(a2.f7493a).a(a2.f7494b).a(a2.f7495c).a(d());
            if (z && a2.f7494b == 100) {
                return null;
            }
            if (a2.f7494b == 100) {
                this.f7500e = 3;
                return a3;
            }
            this.f7500e = 4;
            return a3;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f7497b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    private String g() {
        String f2 = this.f7498c.f(this.f);
        this.f -= f2.length();
        return f2;
    }

    public s d() {
        s.a aVar = new s.a();
        while (true) {
            String g = g();
            if (g.length() != 0) {
                okhttp3.internal.a.f7398a.a(aVar, g);
            } else {
                return aVar.a();
            }
        }
    }

    public r e() {
        if (this.f7500e != 1) {
            throw new IllegalStateException("state: " + this.f7500e);
        }
        this.f7500e = 2;
        return new b();
    }

    public r a(long j) {
        if (this.f7500e != 1) {
            throw new IllegalStateException("state: " + this.f7500e);
        }
        this.f7500e = 2;
        return new d(j);
    }

    public c.s b(long j) {
        if (this.f7500e != 4) {
            throw new IllegalStateException("state: " + this.f7500e);
        }
        this.f7500e = 5;
        return new e(j);
    }

    public c.s a(t tVar) {
        if (this.f7500e != 4) {
            throw new IllegalStateException("state: " + this.f7500e);
        }
        this.f7500e = 5;
        return new c(tVar);
    }

    public c.s f() {
        if (this.f7500e != 4) {
            throw new IllegalStateException("state: " + this.f7500e);
        }
        g gVar = this.f7497b;
        if (gVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f7500e = 5;
        gVar.e();
        return new f();
    }

    void a(c.i iVar) {
        c.t a2 = iVar.a();
        iVar.a(c.t.f3582c);
        a2.f();
        a2.p_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public final class d implements r {

        /* renamed from: b  reason: collision with root package name */
        private final c.i f7510b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7511c;

        /* renamed from: d  reason: collision with root package name */
        private long f7512d;

        d(long j) {
            this.f7510b = new c.i(a.this.f7499d.a());
            this.f7512d = j;
        }

        @Override // c.r
        public c.t a() {
            return this.f7510b;
        }

        @Override // c.r
        public void a_(c.c cVar, long j) {
            if (this.f7511c) {
                throw new IllegalStateException("closed");
            }
            okhttp3.internal.c.a(cVar.b(), 0L, j);
            if (j > this.f7512d) {
                throw new ProtocolException("expected " + this.f7512d + " bytes but received " + j);
            }
            a.this.f7499d.a_(cVar, j);
            this.f7512d -= j;
        }

        @Override // c.r, java.io.Flushable
        public void flush() {
            if (this.f7511c) {
                return;
            }
            a.this.f7499d.flush();
        }

        @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f7511c) {
                return;
            }
            this.f7511c = true;
            if (this.f7512d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.a(this.f7510b);
            a.this.f7500e = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public final class b implements r {

        /* renamed from: b  reason: collision with root package name */
        private final c.i f7506b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7507c;

        b() {
            this.f7506b = new c.i(a.this.f7499d.a());
        }

        @Override // c.r
        public c.t a() {
            return this.f7506b;
        }

        @Override // c.r
        public void a_(c.c cVar, long j) {
            if (this.f7507c) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.f7499d.l(j);
            a.this.f7499d.b("\r\n");
            a.this.f7499d.a_(cVar, j);
            a.this.f7499d.b("\r\n");
        }

        @Override // c.r, java.io.Flushable
        public synchronized void flush() {
            if (this.f7507c) {
                return;
            }
            a.this.f7499d.flush();
        }

        @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f7507c) {
                return;
            }
            this.f7507c = true;
            a.this.f7499d.b("0\r\n\r\n");
            a.this.a(this.f7506b);
            a.this.f7500e = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: okhttp3.internal.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public abstract class AbstractC0186a implements c.s {

        /* renamed from: a  reason: collision with root package name */
        protected final c.i f7501a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f7502b;

        /* renamed from: c  reason: collision with root package name */
        protected long f7503c;

        private AbstractC0186a() {
            this.f7501a = new c.i(a.this.f7498c.a());
            this.f7503c = 0L;
        }

        @Override // c.s
        public c.t a() {
            return this.f7501a;
        }

        @Override // c.s
        public long a(c.c cVar, long j) {
            try {
                long a2 = a.this.f7498c.a(cVar, j);
                if (a2 > 0) {
                    this.f7503c += a2;
                }
                return a2;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        protected final void a(boolean z, IOException iOException) {
            if (a.this.f7500e == 6) {
                return;
            }
            if (a.this.f7500e != 5) {
                throw new IllegalStateException("state: " + a.this.f7500e);
            }
            a.this.a(this.f7501a);
            a.this.f7500e = 6;
            if (a.this.f7497b != null) {
                a.this.f7497b.a(!z, a.this, this.f7503c, iOException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public class e extends AbstractC0186a {
        private long f;

        e(long j) {
            super();
            this.f = j;
            if (j == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // okhttp3.internal.d.a.AbstractC0186a, c.s
        public long a(c.c cVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f7502b) {
                throw new IllegalStateException("closed");
            } else {
                long j2 = this.f;
                if (j2 == 0) {
                    return -1L;
                }
                long a2 = super.a(cVar, Math.min(j2, j));
                if (a2 == -1) {
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, (IOException) protocolException);
                    throw protocolException;
                }
                long j3 = this.f - a2;
                this.f = j3;
                if (j3 == 0) {
                    a(true, (IOException) null);
                }
                return a2;
            }
        }

        @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f7502b) {
                return;
            }
            if (this.f != 0 && !okhttp3.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f7502b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public class c extends AbstractC0186a {
        private final t f;
        private long g;
        private boolean h;

        c(t tVar) {
            super();
            this.g = -1L;
            this.h = true;
            this.f = tVar;
        }

        @Override // okhttp3.internal.d.a.AbstractC0186a, c.s
        public long a(c.c cVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f7502b) {
                throw new IllegalStateException("closed");
            } else {
                if (this.h) {
                    long j2 = this.g;
                    if (j2 == 0 || j2 == -1) {
                        b();
                        if (!this.h) {
                            return -1L;
                        }
                    }
                    long a2 = super.a(cVar, Math.min(j, this.g));
                    if (a2 == -1) {
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        a(false, (IOException) protocolException);
                        throw protocolException;
                    }
                    this.g -= a2;
                    return a2;
                }
                return -1L;
            }
        }

        private void b() {
            if (this.g != -1) {
                a.this.f7498c.r();
            }
            try {
                this.g = a.this.f7498c.o();
                String trim = a.this.f7498c.r().trim();
                if (this.g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                } else if (this.g == 0) {
                    this.h = false;
                    okhttp3.internal.c.e.a(a.this.f7496a.h(), this.f, a.this.d());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f7502b) {
                return;
            }
            if (this.h && !okhttp3.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f7502b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public class f extends AbstractC0186a {
        private boolean f;

        f() {
            super();
        }

        @Override // okhttp3.internal.d.a.AbstractC0186a, c.s
        public long a(c.c cVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f7502b) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f) {
                    return -1L;
                }
                long a2 = super.a(cVar, j);
                if (a2 == -1) {
                    this.f = true;
                    a(true, (IOException) null);
                    return -1L;
                }
                return a2;
            }
        }

        @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f7502b) {
                return;
            }
            if (!this.f) {
                a(false, (IOException) null);
            }
            this.f7502b = true;
        }
    }
}

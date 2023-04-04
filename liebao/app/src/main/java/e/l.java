package e;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.e;
import okhttp3.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpCall.java */
/* loaded from: classes.dex */
public final class l<T> implements e.b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final q f7056a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f7057b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f7058c;

    /* renamed from: d  reason: collision with root package name */
    private final f<ad, T> f7059d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f7060e;
    @Nullable
    private okhttp3.e f;
    @Nullable
    private Throwable g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(q qVar, Object[] objArr, e.a aVar, f<ad, T> fVar) {
        this.f7056a = qVar;
        this.f7057b = objArr;
        this.f7058c = aVar;
        this.f7059d = fVar;
    }

    @Override // e.b
    /* renamed from: e */
    public l<T> d() {
        return new l<>(this.f7056a, this.f7057b, this.f7058c, this.f7059d);
    }

    @Override // e.b
    public void a(final d<T> dVar) {
        okhttp3.e eVar;
        Throwable th;
        u.a(dVar, "callback == null");
        synchronized (this) {
            if (this.h) {
                throw new IllegalStateException("Already executed.");
            }
            this.h = true;
            eVar = this.f;
            th = this.g;
            if (eVar == null && th == null) {
                okhttp3.e f = f();
                this.f = f;
                eVar = f;
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.f7060e) {
            eVar.b();
        }
        eVar.a(new okhttp3.f() { // from class: e.l.1
            @Override // okhttp3.f
            public void a(okhttp3.e eVar2, ac acVar) {
                try {
                    try {
                        dVar.a(l.this, l.this.a(acVar));
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                } catch (Throwable th3) {
                    u.a(th3);
                    a(th3);
                }
            }

            @Override // okhttp3.f
            public void a(okhttp3.e eVar2, IOException iOException) {
                a(iOException);
            }

            private void a(Throwable th2) {
                try {
                    dVar.a(l.this, th2);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        });
    }

    @Override // e.b
    public r<T> a() {
        okhttp3.e eVar;
        synchronized (this) {
            if (this.h) {
                throw new IllegalStateException("Already executed.");
            }
            this.h = true;
            if (this.g != null) {
                if (this.g instanceof IOException) {
                    throw ((IOException) this.g);
                }
                if (this.g instanceof RuntimeException) {
                    throw ((RuntimeException) this.g);
                }
                throw ((Error) this.g);
            }
            eVar = this.f;
            if (eVar == null) {
                try {
                    eVar = f();
                    this.f = eVar;
                } catch (IOException | Error | RuntimeException e2) {
                    u.a(e2);
                    this.g = e2;
                    throw e2;
                }
            }
        }
        if (this.f7060e) {
            eVar.b();
        }
        return a(eVar.a());
    }

    private okhttp3.e f() {
        okhttp3.e a2 = this.f7058c.a(this.f7056a.a(this.f7057b));
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    r<T> a(ac acVar) {
        ad h = acVar.h();
        ac a2 = acVar.i().a(new b(h.a(), h.b())).a();
        int c2 = a2.c();
        if (c2 < 200 || c2 >= 300) {
            try {
                return r.a(u.a(h), a2);
            } finally {
                h.close();
            }
        } else if (c2 == 204 || c2 == 205) {
            h.close();
            return r.a((Object) null, a2);
        } else {
            a aVar = new a(h);
            try {
                return r.a(this.f7059d.a(aVar), a2);
            } catch (RuntimeException e2) {
                aVar.f();
                throw e2;
            }
        }
    }

    @Override // e.b
    public void b() {
        okhttp3.e eVar;
        this.f7060e = true;
        synchronized (this) {
            eVar = this.f;
        }
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // e.b
    public boolean c() {
        boolean z = true;
        if (this.f7060e) {
            return true;
        }
        synchronized (this) {
            if (this.f == null || !this.f.c()) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpCall.java */
    /* loaded from: classes.dex */
    public static final class b extends ad {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final v f7066a;

        /* renamed from: b  reason: collision with root package name */
        private final long f7067b;

        b(@Nullable v vVar, long j) {
            this.f7066a = vVar;
            this.f7067b = j;
        }

        @Override // okhttp3.ad
        public v a() {
            return this.f7066a;
        }

        @Override // okhttp3.ad
        public long b() {
            return this.f7067b;
        }

        @Override // okhttp3.ad
        public c.e c() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpCall.java */
    /* loaded from: classes.dex */
    public static final class a extends ad {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        IOException f7063a;

        /* renamed from: b  reason: collision with root package name */
        private final ad f7064b;

        a(ad adVar) {
            this.f7064b = adVar;
        }

        @Override // okhttp3.ad
        public v a() {
            return this.f7064b.a();
        }

        @Override // okhttp3.ad
        public long b() {
            return this.f7064b.b();
        }

        @Override // okhttp3.ad
        public c.e c() {
            return c.l.a(new c.h(this.f7064b.c()) { // from class: e.l.a.1
                @Override // c.h, c.s
                public long a(c.c cVar, long j) {
                    try {
                        return super.a(cVar, j);
                    } catch (IOException e2) {
                        a.this.f7063a = e2;
                        throw e2;
                    }
                }
            });
        }

        @Override // okhttp3.ad, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f7064b.close();
        }

        void f() {
            IOException iOException = this.f7063a;
            if (iOException != null) {
                throw iOException;
            }
        }
    }
}

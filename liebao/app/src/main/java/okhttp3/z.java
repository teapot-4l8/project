package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealCall.java */
/* loaded from: classes.dex */
public final class z implements e {

    /* renamed from: a  reason: collision with root package name */
    final x f7752a;

    /* renamed from: b  reason: collision with root package name */
    final okhttp3.internal.c.j f7753b;

    /* renamed from: c  reason: collision with root package name */
    final c.a f7754c;

    /* renamed from: d  reason: collision with root package name */
    final aa f7755d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f7756e;
    @Nullable
    private p f;
    private boolean g;

    private z(x xVar, aa aaVar, boolean z) {
        this.f7752a = xVar;
        this.f7755d = aaVar;
        this.f7756e = z;
        this.f7753b = new okhttp3.internal.c.j(xVar, z);
        c.a aVar = new c.a() { // from class: okhttp3.z.1
            @Override // c.a
            protected void a() {
                z.this.b();
            }
        };
        this.f7754c = aVar;
        aVar.a(xVar.a(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z a(x xVar, aa aaVar, boolean z) {
        z zVar = new z(xVar, aaVar, z);
        zVar.f = xVar.z().a(zVar);
        return zVar;
    }

    @Override // okhttp3.e
    public ac a() {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        h();
        this.f7754c.c();
        this.f.a(this);
        try {
            try {
                this.f7752a.u().a(this);
                ac g = g();
                if (g != null) {
                    return g;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                IOException a2 = a(e2);
                this.f.a(this, a2);
                throw a2;
            }
        } finally {
            this.f7752a.u().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IOException a(@Nullable IOException iOException) {
        if (this.f7754c.n_()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
            return interruptedIOException;
        }
        return iOException;
    }

    private void h() {
        this.f7753b.a(okhttp3.internal.g.f.c().a("response.body().close()"));
    }

    @Override // okhttp3.e
    public void a(f fVar) {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        h();
        this.f.a(this);
        this.f7752a.u().a(new a(fVar));
    }

    @Override // okhttp3.e
    public void b() {
        this.f7753b.a();
    }

    @Override // okhttp3.e
    public boolean c() {
        return this.f7753b.b();
    }

    /* renamed from: d */
    public z clone() {
        return a(this.f7752a, this.f7755d, this.f7756e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RealCall.java */
    /* loaded from: classes2.dex */
    public final class a extends okhttp3.internal.b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f7758a = !z.class.desiredAssertionStatus();

        /* renamed from: d  reason: collision with root package name */
        private final f f7760d;

        a(f fVar) {
            super("OkHttp %s", z.this.f());
            this.f7760d = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return z.this.f7755d.a().f();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public z b() {
            return z.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ExecutorService executorService) {
            if (!f7758a && Thread.holdsLock(z.this.f7752a.u())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    z.this.f.a(z.this, interruptedIOException);
                    this.f7760d.a(z.this, interruptedIOException);
                    z.this.f7752a.u().b(this);
                }
            } catch (Throwable th) {
                z.this.f7752a.u().b(this);
                throw th;
            }
        }

        @Override // okhttp3.internal.b
        protected void c() {
            IOException e2;
            z.this.f7754c.c();
            boolean z = true;
            try {
                try {
                    ac g = z.this.g();
                    try {
                        if (z.this.f7753b.b()) {
                            this.f7760d.a(z.this, new IOException("Canceled"));
                        } else {
                            this.f7760d.a(z.this, g);
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        IOException a2 = z.this.a(e2);
                        if (!z) {
                            z.this.f.a(z.this, a2);
                            this.f7760d.a(z.this, a2);
                        } else {
                            okhttp3.internal.g.f c2 = okhttp3.internal.g.f.c();
                            c2.a(4, "Callback failure for " + z.this.e(), a2);
                        }
                    }
                } finally {
                    z.this.f7752a.u().b(this);
                }
            } catch (IOException e4) {
                e2 = e4;
                z = false;
            }
        }
    }

    String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(c() ? "canceled " : "");
        sb.append(this.f7756e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(f());
        return sb.toString();
    }

    String f() {
        return this.f7755d.a().o();
    }

    ac g() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f7752a.x());
        arrayList.add(this.f7753b);
        arrayList.add(new okhttp3.internal.c.a(this.f7752a.h()));
        arrayList.add(new okhttp3.internal.a.a(this.f7752a.i()));
        arrayList.add(new okhttp3.internal.b.a(this.f7752a));
        if (!this.f7756e) {
            arrayList.addAll(this.f7752a.y());
        }
        arrayList.add(new okhttp3.internal.c.b(this.f7756e));
        return new okhttp3.internal.c.g(arrayList, null, null, null, 0, this.f7755d, this, this.f, this.f7752a.b(), this.f7752a.c(), this.f7752a.d()).a(this.f7755d);
    }
}

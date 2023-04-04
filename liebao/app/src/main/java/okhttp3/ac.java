package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.s;

/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class ac implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final aa f7322a;

    /* renamed from: b  reason: collision with root package name */
    final y f7323b;

    /* renamed from: c  reason: collision with root package name */
    final int f7324c;

    /* renamed from: d  reason: collision with root package name */
    final String f7325d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    final r f7326e;
    final s f;
    @Nullable
    final ad g;
    @Nullable
    final ac h;
    @Nullable
    final ac i;
    @Nullable
    final ac j;
    final long k;
    final long l;
    @Nullable
    private volatile d m;

    ac(a aVar) {
        this.f7322a = aVar.f7327a;
        this.f7323b = aVar.f7328b;
        this.f7324c = aVar.f7329c;
        this.f7325d = aVar.f7330d;
        this.f7326e = aVar.f7331e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public aa a() {
        return this.f7322a;
    }

    public y b() {
        return this.f7323b;
    }

    public int c() {
        return this.f7324c;
    }

    public boolean d() {
        int i = this.f7324c;
        return i >= 200 && i < 300;
    }

    public String e() {
        return this.f7325d;
    }

    @Nullable
    public r f() {
        return this.f7326e;
    }

    @Nullable
    public String a(String str) {
        return a(str, null);
    }

    @Nullable
    public String a(String str, @Nullable String str2) {
        String a2 = this.f.a(str);
        return a2 != null ? a2 : str2;
    }

    public s g() {
        return this.f;
    }

    public ad a(long j) {
        c.e c2 = this.g.c();
        c2.b(j);
        c.c clone = c2.c().clone();
        if (clone.b() > j) {
            c.c cVar = new c.c();
            cVar.a_(clone, j);
            clone.u();
            clone = cVar;
        }
        return ad.a(this.g.a(), clone.b(), clone);
    }

    @Nullable
    public ad h() {
        return this.g;
    }

    public a i() {
        return new a(this);
    }

    @Nullable
    public ac j() {
        return this.h;
    }

    @Nullable
    public ac k() {
        return this.j;
    }

    public d l() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f);
        this.m = a2;
        return a2;
    }

    public long m() {
        return this.k;
    }

    public long n() {
        return this.l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ad adVar = this.g;
        if (adVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        adVar.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f7323b + ", code=" + this.f7324c + ", message=" + this.f7325d + ", url=" + this.f7322a.a() + '}';
    }

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public static class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        aa f7327a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        y f7328b;

        /* renamed from: c  reason: collision with root package name */
        int f7329c;

        /* renamed from: d  reason: collision with root package name */
        String f7330d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        r f7331e;
        s.a f;
        @Nullable
        ad g;
        @Nullable
        ac h;
        @Nullable
        ac i;
        @Nullable
        ac j;
        long k;
        long l;

        public a() {
            this.f7329c = -1;
            this.f = new s.a();
        }

        a(ac acVar) {
            this.f7329c = -1;
            this.f7327a = acVar.f7322a;
            this.f7328b = acVar.f7323b;
            this.f7329c = acVar.f7324c;
            this.f7330d = acVar.f7325d;
            this.f7331e = acVar.f7326e;
            this.f = acVar.f.c();
            this.g = acVar.g;
            this.h = acVar.h;
            this.i = acVar.i;
            this.j = acVar.j;
            this.k = acVar.k;
            this.l = acVar.l;
        }

        public a a(aa aaVar) {
            this.f7327a = aaVar;
            return this;
        }

        public a a(y yVar) {
            this.f7328b = yVar;
            return this;
        }

        public a a(int i) {
            this.f7329c = i;
            return this;
        }

        public a a(String str) {
            this.f7330d = str;
            return this;
        }

        public a a(@Nullable r rVar) {
            this.f7331e = rVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f.c(str, str2);
            return this;
        }

        public a b(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a a(s sVar) {
            this.f = sVar.c();
            return this;
        }

        public a a(@Nullable ad adVar) {
            this.g = adVar;
            return this;
        }

        public a a(@Nullable ac acVar) {
            if (acVar != null) {
                a("networkResponse", acVar);
            }
            this.h = acVar;
            return this;
        }

        public a b(@Nullable ac acVar) {
            if (acVar != null) {
                a("cacheResponse", acVar);
            }
            this.i = acVar;
            return this;
        }

        private void a(String str, ac acVar) {
            if (acVar.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (acVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (acVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (acVar.j == null) {
            } else {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a c(@Nullable ac acVar) {
            if (acVar != null) {
                d(acVar);
            }
            this.j = acVar;
            return this;
        }

        private void d(ac acVar) {
            if (acVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(long j) {
            this.k = j;
            return this;
        }

        public a b(long j) {
            this.l = j;
            return this;
        }

        public ac a() {
            if (this.f7327a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f7328b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f7329c < 0) {
                throw new IllegalStateException("code < 0: " + this.f7329c);
            } else if (this.f7330d == null) {
                throw new IllegalStateException("message == null");
            } else {
                return new ac(this);
            }
        }
    }
}

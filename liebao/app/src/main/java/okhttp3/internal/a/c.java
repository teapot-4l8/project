package okhttp3.internal.a;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.s;

/* compiled from: CacheStrategy.java */
/* loaded from: classes.dex */
public final class c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final aa f7405a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final ac f7406b;

    c(aa aaVar, ac acVar) {
        this.f7405a = aaVar;
        this.f7406b = acVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r3.l().d() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(ac acVar, aa aaVar) {
        int c2 = acVar.c();
        if (c2 != 200 && c2 != 410 && c2 != 414 && c2 != 501 && c2 != 203 && c2 != 204) {
            if (c2 != 307) {
                if (c2 != 308 && c2 != 404 && c2 != 405) {
                    switch (c2) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (acVar.a("Expires") == null) {
                if (acVar.l().c() == -1) {
                    if (!acVar.l().e()) {
                    }
                }
            }
        }
        return (acVar.l().b() || aaVar.f().b()) ? false : true;
    }

    /* compiled from: CacheStrategy.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f7407a;

        /* renamed from: b  reason: collision with root package name */
        final aa f7408b;

        /* renamed from: c  reason: collision with root package name */
        final ac f7409c;

        /* renamed from: d  reason: collision with root package name */
        private Date f7410d;

        /* renamed from: e  reason: collision with root package name */
        private String f7411e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, aa aaVar, ac acVar) {
            this.l = -1;
            this.f7407a = j;
            this.f7408b = aaVar;
            this.f7409c = acVar;
            if (acVar != null) {
                this.i = acVar.m();
                this.j = acVar.n();
                s g = acVar.g();
                int a2 = g.a();
                for (int i = 0; i < a2; i++) {
                    String a3 = g.a(i);
                    String b2 = g.b(i);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.f7410d = okhttp3.internal.c.d.a(b2);
                        this.f7411e = b2;
                    } else if ("Expires".equalsIgnoreCase(a3)) {
                        this.h = okhttp3.internal.c.d.a(b2);
                    } else if ("Last-Modified".equalsIgnoreCase(a3)) {
                        this.f = okhttp3.internal.c.d.a(b2);
                        this.g = b2;
                    } else if ("ETag".equalsIgnoreCase(a3)) {
                        this.k = b2;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.l = okhttp3.internal.c.e.b(b2, -1);
                    }
                }
            }
        }

        public c a() {
            c b2 = b();
            return (b2.f7405a == null || !this.f7408b.f().i()) ? b2 : new c(null, null);
        }

        private c b() {
            if (this.f7409c == null) {
                return new c(this.f7408b, null);
            }
            if (this.f7408b.g() && this.f7409c.f() == null) {
                return new c(this.f7408b, null);
            }
            if (!c.a(this.f7409c, this.f7408b)) {
                return new c(this.f7408b, null);
            }
            okhttp3.d f = this.f7408b.f();
            if (f.a() || a(this.f7408b)) {
                return new c(this.f7408b, null);
            }
            okhttp3.d l = this.f7409c.l();
            long d2 = d();
            long c2 = c();
            if (f.c() != -1) {
                c2 = Math.min(c2, TimeUnit.SECONDS.toMillis(f.c()));
            }
            long j = 0;
            long millis = f.h() != -1 ? TimeUnit.SECONDS.toMillis(f.h()) : 0L;
            if (!l.f() && f.g() != -1) {
                j = TimeUnit.SECONDS.toMillis(f.g());
            }
            if (!l.a()) {
                long j2 = millis + d2;
                if (j2 < j + c2) {
                    ac.a i = this.f7409c.i();
                    if (j2 >= c2) {
                        i.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (d2 > 86400000 && e()) {
                        i.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, i.a());
                }
            }
            String str = this.k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f != null) {
                str = this.g;
            } else if (this.f7410d != null) {
                str = this.f7411e;
            } else {
                return new c(this.f7408b, null);
            }
            s.a c3 = this.f7408b.c().c();
            okhttp3.internal.a.f7398a.a(c3, str2, str);
            return new c(this.f7408b.e().a(c3.a()).a(), this.f7409c);
        }

        private long c() {
            long j;
            long j2;
            okhttp3.d l = this.f7409c.l();
            if (l.c() != -1) {
                return TimeUnit.SECONDS.toMillis(l.c());
            }
            if (this.h != null) {
                Date date = this.f7410d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.j;
                }
                long time = this.h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f == null || this.f7409c.a().a().l() != null) {
                return 0L;
            } else {
                Date date2 = this.f7410d;
                if (date2 != null) {
                    j = date2.getTime();
                } else {
                    j = this.i;
                }
                long time2 = j - this.f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        private long d() {
            Date date = this.f7410d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            if (this.l != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(this.l));
            }
            long j = this.j;
            return max + (j - this.i) + (this.f7407a - j);
        }

        private boolean e() {
            return this.f7409c.l().c() == -1 && this.h == null;
        }

        private static boolean a(aa aaVar) {
            return (aaVar.a("If-Modified-Since") == null && aaVar.a("If-None-Match") == null) ? false : true;
        }
    }
}

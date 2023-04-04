package com.a.a;

import com.a.a.a;
import java.util.List;
import java.util.Map;

/* compiled from: Logger.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private com.a.a.a f4545a;

    /* renamed from: b  reason: collision with root package name */
    private com.a.a.d.b f4546b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.a.a.a aVar, com.a.a.d.b bVar) {
        this.f4545a = aVar;
        this.f4546b = bVar;
    }

    c(a aVar) {
        a.C0082a c0082a = new a.C0082a(d.f4557a);
        if (aVar.f4548a != 0) {
            c0082a.a(aVar.f4548a);
        }
        if (aVar.f4549b != null) {
            c0082a.a(aVar.f4549b);
        }
        if (aVar.f4551d) {
            if (aVar.f4550c) {
                c0082a.a();
            } else {
                c0082a.b();
            }
        }
        if (aVar.h) {
            if (!aVar.f4552e) {
                c0082a.c();
            } else {
                c0082a.a(aVar.f, aVar.g);
            }
        }
        if (aVar.j) {
            if (aVar.i) {
                c0082a.d();
            } else {
                c0082a.e();
            }
        }
        if (aVar.k != null) {
            c0082a.a(aVar.k);
        }
        if (aVar.l != null) {
            c0082a.a(aVar.l);
        }
        if (aVar.m != null) {
            c0082a.a(aVar.m);
        }
        if (aVar.n != null) {
            c0082a.a(aVar.n);
        }
        if (aVar.o != null) {
            c0082a.a(aVar.o);
        }
        if (aVar.p != null) {
            c0082a.a(aVar.p);
        }
        if (aVar.f4553q != null) {
            c0082a.a(aVar.f4553q);
        }
        if (aVar.r != null) {
            c0082a.a(aVar.r);
        }
        this.f4545a = c0082a.f();
        if (aVar.s == null) {
            this.f4546b = d.f4558b;
        } else {
            this.f4546b = aVar.s;
        }
    }

    public void a(String str) {
        a(3, str);
    }

    public void a(String str, Throwable th) {
        a(3, str, th);
    }

    public void b(String str) {
        a(4, str);
    }

    public void c(String str) {
        if (3 < this.f4545a.f4530a) {
            return;
        }
        b(3, this.f4545a.h.a(str));
    }

    void a(int i, String str) {
        if (i < this.f4545a.f4530a) {
            return;
        }
        b(i, str);
    }

    private void a(int i, String str, Throwable th) {
        String str2;
        if (i < this.f4545a.f4530a) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (str == null || str.length() == 0) {
            str2 = "";
        } else {
            str2 = str + com.a.a.c.c.f4556a;
        }
        sb.append(str2);
        sb.append(this.f4545a.j.a(th));
        b(i, sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i, String str) {
        String sb;
        String str2 = this.f4545a.f4531b;
        String a2 = this.f4545a.f4532c ? this.f4545a.k.a(Thread.currentThread()) : null;
        String a3 = this.f4545a.f4533d ? this.f4545a.l.a(com.a.a.c.a.b.a(new Throwable().getStackTrace(), this.f4545a.f4534e, this.f4545a.f)) : null;
        if (this.f4545a.n != null) {
            b bVar = new b(i, str2, a2, a3, str);
            for (com.a.a.b.a aVar : this.f4545a.n) {
                bVar = aVar.a(bVar);
                if (bVar == null) {
                    return;
                }
                if (bVar.f4541b == null || bVar.f4542c == null) {
                    throw new IllegalStateException("Interceptor " + aVar + " should not remove the tag or message of a log, if you don't want to print this log, just return a null when intercept.");
                }
                while (r8.hasNext()) {
                }
            }
            i = bVar.f4540a;
            str2 = bVar.f4541b;
            a2 = bVar.f4543d;
            a3 = bVar.f4544e;
            str = bVar.f4542c;
        }
        com.a.a.d.b bVar2 = this.f4546b;
        if (this.f4545a.g) {
            sb = this.f4545a.m.a(new String[]{a2, a3, str});
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a2 != null ? a2 + com.a.a.c.c.f4556a : "");
            sb2.append(a3 != null ? a3 + com.a.a.c.c.f4556a : "");
            sb2.append(str);
            sb = sb2.toString();
        }
        bVar2.a(i, str2, sb);
    }

    /* compiled from: Logger.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f4548a;

        /* renamed from: b  reason: collision with root package name */
        private String f4549b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4550c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4551d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4552e;
        private String f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private com.a.a.a.b.a.b k;
        private com.a.a.a.b.d.b l;
        private com.a.a.a.b.c.b m;
        private com.a.a.a.d.b n;
        private com.a.a.a.c.b o;
        private com.a.a.a.a.a p;

        /* renamed from: q  reason: collision with root package name */
        private Map<Class<?>, com.a.a.a.b.b.c<?>> f4553q;
        private List<com.a.a.b.a> r;
        private com.a.a.d.b s;

        public a() {
            d.a();
        }

        public a a(String str) {
            this.f4549b = str;
            return this;
        }

        public void b(String str) {
            a().a(str);
        }

        public c a() {
            return new c(this);
        }
    }
}

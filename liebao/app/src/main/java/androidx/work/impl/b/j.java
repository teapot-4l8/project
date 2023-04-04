package androidx.work.impl.b;

import androidx.work.m;
import java.util.List;

/* compiled from: WorkSpec.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f2864a;

    /* renamed from: b  reason: collision with root package name */
    public m.a f2865b;

    /* renamed from: c  reason: collision with root package name */
    public String f2866c;

    /* renamed from: d  reason: collision with root package name */
    public String f2867d;

    /* renamed from: e  reason: collision with root package name */
    public androidx.work.e f2868e;
    public androidx.work.e f;
    public long g;
    public long h;
    public long i;
    public androidx.work.c j;
    public int k;
    public androidx.work.a l;
    public long m;
    public long n;
    public long o;
    public long p;
    private static final String r = androidx.work.h.a("WorkSpec");

    /* renamed from: q  reason: collision with root package name */
    public static final androidx.a.a.c.a<List<Object>, List<androidx.work.m>> f2863q = new androidx.a.a.c.a<List<Object>, List<androidx.work.m>>() { // from class: androidx.work.impl.b.j.1
    };

    public j(String str, String str2) {
        this.f2865b = m.a.ENQUEUED;
        this.f2868e = androidx.work.e.f2787a;
        this.f = androidx.work.e.f2787a;
        this.j = androidx.work.c.f2774a;
        this.l = androidx.work.a.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.f2864a = str;
        this.f2866c = str2;
    }

    public j(j jVar) {
        this.f2865b = m.a.ENQUEUED;
        this.f2868e = androidx.work.e.f2787a;
        this.f = androidx.work.e.f2787a;
        this.j = androidx.work.c.f2774a;
        this.l = androidx.work.a.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.f2864a = jVar.f2864a;
        this.f2866c = jVar.f2866c;
        this.f2865b = jVar.f2865b;
        this.f2867d = jVar.f2867d;
        this.f2868e = new androidx.work.e(jVar.f2868e);
        this.f = new androidx.work.e(jVar.f);
        this.g = jVar.g;
        this.h = jVar.h;
        this.i = jVar.i;
        this.j = new androidx.work.c(jVar.j);
        this.k = jVar.k;
        this.l = jVar.l;
        this.m = jVar.m;
        this.n = jVar.n;
        this.o = jVar.o;
        this.p = jVar.p;
    }

    public boolean a() {
        return this.h != 0;
    }

    public boolean b() {
        return this.f2865b == m.a.ENQUEUED && this.k > 0;
    }

    public long c() {
        long scalb;
        if (b()) {
            if (this.l == androidx.work.a.LINEAR) {
                scalb = this.m * this.k;
            } else {
                scalb = Math.scalb((float) this.m, this.k - 1);
            }
            return this.n + Math.min(18000000L, scalb);
        }
        if (a()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.n;
            if (j == 0) {
                j = this.g + currentTimeMillis;
            }
            if (this.i != this.h) {
                return j + this.h + (this.n == 0 ? this.i * (-1) : 0L);
            }
            return j + (this.n != 0 ? this.h : 0L);
        }
        long j2 = this.n;
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
        }
        return j2 + this.g;
    }

    public boolean d() {
        return !androidx.work.c.f2774a.equals(this.j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.g == jVar.g && this.h == jVar.h && this.i == jVar.i && this.k == jVar.k && this.m == jVar.m && this.n == jVar.n && this.o == jVar.o && this.p == jVar.p && this.f2864a.equals(jVar.f2864a) && this.f2865b == jVar.f2865b && this.f2866c.equals(jVar.f2866c)) {
            String str = this.f2867d;
            if (str == null ? jVar.f2867d == null : str.equals(jVar.f2867d)) {
                return this.f2868e.equals(jVar.f2868e) && this.f.equals(jVar.f) && this.j.equals(jVar.j) && this.l == jVar.l;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f2864a.hashCode() * 31) + this.f2865b.hashCode()) * 31) + this.f2866c.hashCode()) * 31;
        String str = this.f2867d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j = this.g;
        long j2 = this.h;
        long j3 = this.i;
        long j4 = this.m;
        long j5 = this.n;
        long j6 = this.o;
        long j7 = this.p;
        return ((((((((((((((((((((((((hashCode + hashCode2) * 31) + this.f2868e.hashCode()) * 31) + this.f.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.j.hashCode()) * 31) + this.k) * 31) + this.l.hashCode()) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)));
    }

    public String toString() {
        return "{WorkSpec: " + this.f2864a + "}";
    }

    /* compiled from: WorkSpec.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2869a;

        /* renamed from: b  reason: collision with root package name */
        public m.a f2870b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f2870b != aVar.f2870b) {
                return false;
            }
            return this.f2869a.equals(aVar.f2869a);
        }

        public int hashCode() {
            return (this.f2869a.hashCode() * 31) + this.f2870b.hashCode();
        }
    }
}

package androidx.work;

import android.os.Build;

/* compiled from: Constraints.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f2774a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    private i f2775b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2776c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2777d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2778e;
    private boolean f;
    private long g;
    private long h;
    private d i;

    public c() {
        this.f2775b = i.NOT_REQUIRED;
        this.g = -1L;
        this.h = -1L;
        this.i = new d();
    }

    c(a aVar) {
        this.f2775b = i.NOT_REQUIRED;
        this.g = -1L;
        this.h = -1L;
        this.i = new d();
        this.f2776c = aVar.f2779a;
        this.f2777d = Build.VERSION.SDK_INT >= 23 && aVar.f2780b;
        this.f2775b = aVar.f2781c;
        this.f2778e = aVar.f2782d;
        this.f = aVar.f2783e;
        if (Build.VERSION.SDK_INT >= 24) {
            this.i = aVar.h;
            this.g = aVar.f;
            this.h = aVar.g;
        }
    }

    public c(c cVar) {
        this.f2775b = i.NOT_REQUIRED;
        this.g = -1L;
        this.h = -1L;
        this.i = new d();
        this.f2776c = cVar.f2776c;
        this.f2777d = cVar.f2777d;
        this.f2775b = cVar.f2775b;
        this.f2778e = cVar.f2778e;
        this.f = cVar.f;
        this.i = cVar.i;
    }

    public i a() {
        return this.f2775b;
    }

    public void a(i iVar) {
        this.f2775b = iVar;
    }

    public boolean b() {
        return this.f2776c;
    }

    public void a(boolean z) {
        this.f2776c = z;
    }

    public boolean c() {
        return this.f2777d;
    }

    public void b(boolean z) {
        this.f2777d = z;
    }

    public boolean d() {
        return this.f2778e;
    }

    public void c(boolean z) {
        this.f2778e = z;
    }

    public boolean e() {
        return this.f;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public long f() {
        return this.g;
    }

    public void a(long j) {
        this.g = j;
    }

    public long g() {
        return this.h;
    }

    public void b(long j) {
        this.h = j;
    }

    public void a(d dVar) {
        this.i = dVar;
    }

    public d h() {
        return this.i;
    }

    public boolean i() {
        return this.i.b() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f2776c == cVar.f2776c && this.f2777d == cVar.f2777d && this.f2778e == cVar.f2778e && this.f == cVar.f && this.g == cVar.g && this.h == cVar.h && this.f2775b == cVar.f2775b) {
            return this.i.equals(cVar.i);
        }
        return false;
    }

    public int hashCode() {
        long j = this.g;
        long j2 = this.h;
        return (((((((((((((this.f2775b.hashCode() * 31) + (this.f2776c ? 1 : 0)) * 31) + (this.f2777d ? 1 : 0)) * 31) + (this.f2778e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.i.hashCode();
    }

    /* compiled from: Constraints.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f2779a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f2780b = false;

        /* renamed from: c  reason: collision with root package name */
        i f2781c = i.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        boolean f2782d = false;

        /* renamed from: e  reason: collision with root package name */
        boolean f2783e = false;
        long f = -1;
        long g = -1;
        d h = new d();

        public a a(i iVar) {
            this.f2781c = iVar;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}

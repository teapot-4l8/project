package androidx.work.impl.a;

/* compiled from: NetworkState.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2814a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2815b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2816c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2817d;

    public b(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f2814a = z;
        this.f2815b = z2;
        this.f2816c = z3;
        this.f2817d = z4;
    }

    public boolean a() {
        return this.f2814a;
    }

    public boolean b() {
        return this.f2815b;
    }

    public boolean c() {
        return this.f2816c;
    }

    public boolean d() {
        return this.f2817d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2814a == bVar.f2814a && this.f2815b == bVar.f2815b && this.f2816c == bVar.f2816c && this.f2817d == bVar.f2817d;
    }

    public int hashCode() {
        int i = this.f2814a ? 1 : 0;
        if (this.f2815b) {
            i += 16;
        }
        if (this.f2816c) {
            i += 256;
        }
        return this.f2817d ? i + 4096 : i;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.f2814a), Boolean.valueOf(this.f2815b), Boolean.valueOf(this.f2816c), Boolean.valueOf(this.f2817d));
    }
}

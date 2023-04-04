package kotlin;

import java.io.Serializable;

/* compiled from: Tuples.kt */
/* loaded from: classes2.dex */
public final class f<A, B> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final A f7169a;

    /* renamed from: b  reason: collision with root package name */
    private final B f7170b;

    public final A c() {
        return this.f7169a;
    }

    public final B d() {
        return this.f7170b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                return kotlin.d.b.i.a(this.f7169a, fVar.f7169a) && kotlin.d.b.i.a(this.f7170b, fVar.f7170b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f7169a;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.f7170b;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public f(A a2, B b2) {
        this.f7169a = a2;
        this.f7170b = b2;
    }

    public final A a() {
        return this.f7169a;
    }

    public final B b() {
        return this.f7170b;
    }

    public String toString() {
        return '(' + this.f7169a + ", " + this.f7170b + ')';
    }
}

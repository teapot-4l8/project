package com.c.a.a;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
final class d<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final A f5273a;

    /* renamed from: b  reason: collision with root package name */
    private final B f5274b;

    private d(A a2, B b2) {
        this.f5273a = a2;
        this.f5274b = b2;
    }

    public static <A, B> d<A, B> a(A a2, B b2) {
        return new d<>(a2, b2);
    }

    public A a() {
        return this.f5273a;
    }

    public int hashCode() {
        A a2 = this.f5273a;
        int hashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
        B b2 = this.f5274b;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            A a2 = this.f5273a;
            if (a2 == null) {
                if (dVar.f5273a != null) {
                    return false;
                }
            } else if (!a2.equals(dVar.f5273a)) {
                return false;
            }
            B b2 = this.f5274b;
            if (b2 == null) {
                if (dVar.f5274b != null) {
                    return false;
                }
            } else if (!b2.equals(dVar.f5274b)) {
                return false;
            }
            return true;
        }
        return false;
    }
}

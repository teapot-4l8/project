package com.bumptech.glide.i;

/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f5255a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f5256b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f5257c;

    public h() {
    }

    public h(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }

    public h(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(Class<?> cls, Class<?> cls2) {
        a(cls, cls2, null);
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f5255a = cls;
        this.f5256b = cls2;
        this.f5257c = cls3;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f5255a + ", second=" + this.f5256b + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f5255a.equals(hVar.f5255a) && this.f5256b.equals(hVar.f5256b) && j.a(this.f5257c, hVar.f5257c);
    }

    public int hashCode() {
        int hashCode = ((this.f5255a.hashCode() * 31) + this.f5256b.hashCode()) * 31;
        Class<?> cls = this.f5257c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }
}

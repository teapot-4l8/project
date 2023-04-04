package com.bumptech.glide.c.d;

import com.bumptech.glide.c.b.u;
import com.bumptech.glide.i.i;

/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class a<T> implements u<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f4983a;

    @Override // com.bumptech.glide.c.b.u
    public final int e() {
        return 1;
    }

    @Override // com.bumptech.glide.c.b.u
    public void f() {
    }

    public a(T t) {
        this.f4983a = (T) i.a(t);
    }

    @Override // com.bumptech.glide.c.b.u
    public Class<T> c() {
        return (Class<T>) this.f4983a.getClass();
    }

    @Override // com.bumptech.glide.c.b.u
    public final T d() {
        return this.f4983a;
    }
}

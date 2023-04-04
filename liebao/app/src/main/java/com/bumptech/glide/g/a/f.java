package com.bumptech.glide.g.a;

import com.bumptech.glide.i.j;

/* compiled from: SimpleTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class f<Z> extends a<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final int f5182a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5183b;

    @Override // com.bumptech.glide.g.a.h
    public void b(g gVar) {
    }

    public f() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public f(int i, int i2) {
        this.f5182a = i;
        this.f5183b = i2;
    }

    @Override // com.bumptech.glide.g.a.h
    public final void a(g gVar) {
        if (!j.a(this.f5182a, this.f5183b)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f5182a + " and height: " + this.f5183b + ", either provide dimensions in the constructor or call override()");
        }
        gVar.a(this.f5182a, this.f5183b);
    }
}

package com.bumptech.glide.c.d.e;

import com.bumptech.glide.c.b.q;

/* compiled from: GifDrawableResource.java */
/* loaded from: classes.dex */
public class e extends com.bumptech.glide.c.d.c.b<c> implements q {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.c.b.u
    public Class<c> c() {
        return c.class;
    }

    @Override // com.bumptech.glide.c.b.u
    public int e() {
        return ((c) this.f5052a).a();
    }

    @Override // com.bumptech.glide.c.b.u
    public void f() {
        ((c) this.f5052a).stop();
        ((c) this.f5052a).g();
    }

    @Override // com.bumptech.glide.c.d.c.b, com.bumptech.glide.c.b.q
    public void a() {
        ((c) this.f5052a).b().prepareToDraw();
    }
}

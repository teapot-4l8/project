package com.bumptech.glide.c.b.b;

import com.bumptech.glide.c.b.b.h;
import com.bumptech.glide.c.b.u;

/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class g extends com.bumptech.glide.i.f<com.bumptech.glide.c.h, u<?>> implements h {

    /* renamed from: a  reason: collision with root package name */
    private h.a f4734a;

    @Override // com.bumptech.glide.c.b.b.h
    public /* synthetic */ u a(com.bumptech.glide.c.h hVar) {
        return (u) super.c(hVar);
    }

    @Override // com.bumptech.glide.c.b.b.h
    public /* bridge */ /* synthetic */ u b(com.bumptech.glide.c.h hVar, u uVar) {
        return (u) super.b((g) hVar, (com.bumptech.glide.c.h) uVar);
    }

    public g(long j) {
        super(j);
    }

    @Override // com.bumptech.glide.c.b.b.h
    public void a(h.a aVar) {
        this.f4734a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.i.f
    public void a(com.bumptech.glide.c.h hVar, u<?> uVar) {
        h.a aVar = this.f4734a;
        if (aVar == null || uVar == null) {
            return;
        }
        aVar.b(uVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.i.f
    public int a(u<?> uVar) {
        if (uVar == null) {
            return super.a((g) null);
        }
        return uVar.e();
    }

    @Override // com.bumptech.glide.c.b.b.h
    public void a(int i) {
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }
}

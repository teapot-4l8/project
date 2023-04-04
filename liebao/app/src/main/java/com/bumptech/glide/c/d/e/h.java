package com.bumptech.glide.c.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.k;

/* compiled from: GifFrameResourceDecoder.java */
/* loaded from: classes.dex */
public final class h implements k<com.bumptech.glide.b.a, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.e f5079a;

    @Override // com.bumptech.glide.c.k
    public boolean a(com.bumptech.glide.b.a aVar, com.bumptech.glide.c.j jVar) {
        return true;
    }

    public h(com.bumptech.glide.c.b.a.e eVar) {
        this.f5079a = eVar;
    }

    @Override // com.bumptech.glide.c.k
    public u<Bitmap> a(com.bumptech.glide.b.a aVar, int i, int i2, com.bumptech.glide.c.j jVar) {
        return com.bumptech.glide.c.d.a.d.a(aVar.h(), this.f5079a);
    }
}

package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;

/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class d implements com.bumptech.glide.c.b.q, com.bumptech.glide.c.b.u<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f4991a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.e f4992b;

    public static d a(Bitmap bitmap, com.bumptech.glide.c.b.a.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, eVar);
    }

    public d(Bitmap bitmap, com.bumptech.glide.c.b.a.e eVar) {
        this.f4991a = (Bitmap) com.bumptech.glide.i.i.a(bitmap, "Bitmap must not be null");
        this.f4992b = (com.bumptech.glide.c.b.a.e) com.bumptech.glide.i.i.a(eVar, "BitmapPool must not be null");
    }

    @Override // com.bumptech.glide.c.b.u
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.c.b.u
    /* renamed from: b */
    public Bitmap d() {
        return this.f4991a;
    }

    @Override // com.bumptech.glide.c.b.u
    public int e() {
        return com.bumptech.glide.i.j.a(this.f4991a);
    }

    @Override // com.bumptech.glide.c.b.u
    public void f() {
        this.f4992b.a(this.f4991a);
    }

    @Override // com.bumptech.glide.c.b.q
    public void a() {
        this.f4991a.prepareToDraw();
    }
}

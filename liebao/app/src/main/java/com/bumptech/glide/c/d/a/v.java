package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;

/* compiled from: UnitBitmapDecoder.java */
/* loaded from: classes.dex */
public final class v implements com.bumptech.glide.c.k<Bitmap, Bitmap> {
    @Override // com.bumptech.glide.c.k
    public boolean a(Bitmap bitmap, com.bumptech.glide.c.j jVar) {
        return true;
    }

    @Override // com.bumptech.glide.c.k
    public com.bumptech.glide.c.b.u<Bitmap> a(Bitmap bitmap, int i, int i2, com.bumptech.glide.c.j jVar) {
        return new a(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnitBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static final class a implements com.bumptech.glide.c.b.u<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f5040a;

        @Override // com.bumptech.glide.c.b.u
        public void f() {
        }

        a(Bitmap bitmap) {
            this.f5040a = bitmap;
        }

        @Override // com.bumptech.glide.c.b.u
        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.c.b.u
        /* renamed from: a */
        public Bitmap d() {
            return this.f5040a;
        }

        @Override // com.bumptech.glide.c.b.u
        public int e() {
            return com.bumptech.glide.i.j.a(this.f5040a);
        }
    }
}

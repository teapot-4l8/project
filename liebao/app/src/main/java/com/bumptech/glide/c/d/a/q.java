package com.bumptech.glide.c.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* compiled from: LazyBitmapDrawableResource.java */
/* loaded from: classes.dex */
public final class q implements com.bumptech.glide.c.b.q, com.bumptech.glide.c.b.u<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f5022a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.c.b.u<Bitmap> f5023b;

    public static com.bumptech.glide.c.b.u<BitmapDrawable> a(Resources resources, com.bumptech.glide.c.b.u<Bitmap> uVar) {
        if (uVar == null) {
            return null;
        }
        return new q(resources, uVar);
    }

    private q(Resources resources, com.bumptech.glide.c.b.u<Bitmap> uVar) {
        this.f5022a = (Resources) com.bumptech.glide.i.i.a(resources);
        this.f5023b = (com.bumptech.glide.c.b.u) com.bumptech.glide.i.i.a(uVar);
    }

    @Override // com.bumptech.glide.c.b.u
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.c.b.u
    /* renamed from: b */
    public BitmapDrawable d() {
        return new BitmapDrawable(this.f5022a, this.f5023b.d());
    }

    @Override // com.bumptech.glide.c.b.u
    public int e() {
        return this.f5023b.e();
    }

    @Override // com.bumptech.glide.c.b.u
    public void f() {
        this.f5023b.f();
    }

    @Override // com.bumptech.glide.c.b.q
    public void a() {
        com.bumptech.glide.c.b.u<Bitmap> uVar = this.f5023b;
        if (uVar instanceof com.bumptech.glide.c.b.q) {
            ((com.bumptech.glide.c.b.q) uVar).a();
        }
    }
}

package com.bumptech.glide.c.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.m;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class f implements m<c> {

    /* renamed from: b  reason: collision with root package name */
    private final m<Bitmap> f5068b;

    public f(m<Bitmap> mVar) {
        this.f5068b = (m) com.bumptech.glide.i.i.a(mVar);
    }

    @Override // com.bumptech.glide.c.m
    public u<c> a(Context context, u<c> uVar, int i, int i2) {
        c d2 = uVar.d();
        u<Bitmap> dVar = new com.bumptech.glide.c.d.a.d(d2.b(), com.bumptech.glide.c.a(context).a());
        u<Bitmap> a2 = this.f5068b.a(context, dVar, i, i2);
        if (!dVar.equals(a2)) {
            dVar.f();
        }
        d2.a(this.f5068b, a2.d());
        return uVar;
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f5068b.equals(((f) obj).f5068b);
        }
        return false;
    }

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        return this.f5068b.hashCode();
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        this.f5068b.a(messageDigest);
    }
}

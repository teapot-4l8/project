package com.bumptech.glide.c.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation.java */
/* loaded from: classes.dex */
public class m implements com.bumptech.glide.c.m<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.c.m<Bitmap> f5015b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5016c;

    public com.bumptech.glide.c.m<BitmapDrawable> a() {
        return this;
    }

    public m(com.bumptech.glide.c.m<Bitmap> mVar, boolean z) {
        this.f5015b = mVar;
        this.f5016c = z;
    }

    @Override // com.bumptech.glide.c.m
    public com.bumptech.glide.c.b.u<Drawable> a(Context context, com.bumptech.glide.c.b.u<Drawable> uVar, int i, int i2) {
        com.bumptech.glide.c.b.a.e a2 = com.bumptech.glide.c.a(context).a();
        Drawable d2 = uVar.d();
        com.bumptech.glide.c.b.u<Bitmap> a3 = l.a(a2, d2, i, i2);
        if (a3 == null) {
            if (this.f5016c) {
                throw new IllegalArgumentException("Unable to convert " + d2 + " to a Bitmap");
            }
            return uVar;
        }
        com.bumptech.glide.c.b.u<Bitmap> a4 = this.f5015b.a(context, a3, i, i2);
        if (a4.equals(a3)) {
            a4.f();
            return uVar;
        }
        return a(context, a4);
    }

    private com.bumptech.glide.c.b.u<Drawable> a(Context context, com.bumptech.glide.c.b.u<Bitmap> uVar) {
        return q.a(context.getResources(), uVar);
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f5015b.equals(((m) obj).f5015b);
        }
        return false;
    }

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        return this.f5015b.hashCode();
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        this.f5015b.a(messageDigest);
    }
}

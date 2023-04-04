package com.bumptech.glide.c.d.a;

import android.content.Context;
import android.graphics.Bitmap;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class e implements com.bumptech.glide.c.m<Bitmap> {
    protected abstract Bitmap a(com.bumptech.glide.c.b.a.e eVar, Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.c.m
    public final com.bumptech.glide.c.b.u<Bitmap> a(Context context, com.bumptech.glide.c.b.u<Bitmap> uVar, int i, int i2) {
        if (!com.bumptech.glide.i.j.a(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.bumptech.glide.c.b.a.e a2 = com.bumptech.glide.c.a(context).a();
        Bitmap d2 = uVar.d();
        if (i == Integer.MIN_VALUE) {
            i = d2.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = d2.getHeight();
        }
        Bitmap a3 = a(a2, d2, i, i2);
        return d2.equals(a3) ? uVar : d.a(a3, a2);
    }
}

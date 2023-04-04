package com.bumptech.glide.c.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* compiled from: BitmapDrawableDecoder.java */
/* loaded from: classes.dex */
public class a<DataType> implements com.bumptech.glide.c.k<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.c.k<DataType, Bitmap> f4984a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f4985b;

    public a(Resources resources, com.bumptech.glide.c.k<DataType, Bitmap> kVar) {
        this.f4985b = (Resources) com.bumptech.glide.i.i.a(resources);
        this.f4984a = (com.bumptech.glide.c.k) com.bumptech.glide.i.i.a(kVar);
    }

    @Override // com.bumptech.glide.c.k
    public boolean a(DataType datatype, com.bumptech.glide.c.j jVar) {
        return this.f4984a.a(datatype, jVar);
    }

    @Override // com.bumptech.glide.c.k
    public com.bumptech.glide.c.b.u<BitmapDrawable> a(DataType datatype, int i, int i2, com.bumptech.glide.c.j jVar) {
        return q.a(this.f4985b, this.f4984a.a(datatype, i, i2, jVar));
    }
}

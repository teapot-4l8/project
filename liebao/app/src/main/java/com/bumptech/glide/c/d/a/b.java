package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.File;

/* compiled from: BitmapDrawableEncoder.java */
/* loaded from: classes.dex */
public class b implements com.bumptech.glide.c.l<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.e f4986a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.c.l<Bitmap> f4987b;

    public b(com.bumptech.glide.c.b.a.e eVar, com.bumptech.glide.c.l<Bitmap> lVar) {
        this.f4986a = eVar;
        this.f4987b = lVar;
    }

    @Override // com.bumptech.glide.c.d
    public boolean a(com.bumptech.glide.c.b.u<BitmapDrawable> uVar, File file, com.bumptech.glide.c.j jVar) {
        return this.f4987b.a(new d(uVar.d().getBitmap(), this.f4986a), file, jVar);
    }

    @Override // com.bumptech.glide.c.l
    public com.bumptech.glide.c.c a(com.bumptech.glide.c.j jVar) {
        return this.f4987b.a(jVar);
    }
}

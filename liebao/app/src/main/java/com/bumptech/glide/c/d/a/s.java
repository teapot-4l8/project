package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/* compiled from: ResourceBitmapDecoder.java */
/* loaded from: classes.dex */
public class s implements com.bumptech.glide.c.k<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.c.d.c.d f5029a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.e f5030b;

    public s(com.bumptech.glide.c.d.c.d dVar, com.bumptech.glide.c.b.a.e eVar) {
        this.f5029a = dVar;
        this.f5030b = eVar;
    }

    @Override // com.bumptech.glide.c.k
    public boolean a(Uri uri, com.bumptech.glide.c.j jVar) {
        return "android.resource".equals(uri.getScheme());
    }

    @Override // com.bumptech.glide.c.k
    public com.bumptech.glide.c.b.u<Bitmap> a(Uri uri, int i, int i2, com.bumptech.glide.c.j jVar) {
        com.bumptech.glide.c.b.u<Drawable> a2 = this.f5029a.a(uri, i, i2, jVar);
        if (a2 == null) {
            return null;
        }
        return l.a(this.f5030b, a2.d(), i, i2);
    }
}

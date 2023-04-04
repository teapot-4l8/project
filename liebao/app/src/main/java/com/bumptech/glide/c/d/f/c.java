package com.bumptech.glide.c.d.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;

/* compiled from: DrawableBytesTranscoder.java */
/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.e f5088a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f5089b;

    /* renamed from: c  reason: collision with root package name */
    private final e<com.bumptech.glide.c.d.e.c, byte[]> f5090c;

    /* JADX WARN: Multi-variable type inference failed */
    private static u<com.bumptech.glide.c.d.e.c> a(u<Drawable> uVar) {
        return uVar;
    }

    public c(com.bumptech.glide.c.b.a.e eVar, e<Bitmap, byte[]> eVar2, e<com.bumptech.glide.c.d.e.c, byte[]> eVar3) {
        this.f5088a = eVar;
        this.f5089b = eVar2;
        this.f5090c = eVar3;
    }

    @Override // com.bumptech.glide.c.d.f.e
    public u<byte[]> a(u<Drawable> uVar, j jVar) {
        Drawable d2 = uVar.d();
        if (d2 instanceof BitmapDrawable) {
            return this.f5089b.a(com.bumptech.glide.c.d.a.d.a(((BitmapDrawable) d2).getBitmap(), this.f5088a), jVar);
        }
        if (d2 instanceof com.bumptech.glide.c.d.e.c) {
            return this.f5090c.a(a(uVar), jVar);
        }
        return null;
    }
}

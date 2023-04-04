package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.c.k<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final k f4993a;

    public f(k kVar) {
        this.f4993a = kVar;
    }

    @Override // com.bumptech.glide.c.k
    public boolean a(ByteBuffer byteBuffer, com.bumptech.glide.c.j jVar) {
        return this.f4993a.a(byteBuffer);
    }

    @Override // com.bumptech.glide.c.k
    public com.bumptech.glide.c.b.u<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.c.j jVar) {
        return this.f4993a.a(com.bumptech.glide.i.a.b(byteBuffer), i, i2, jVar);
    }
}

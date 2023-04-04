package com.bumptech.glide.c.d.f;

import android.graphics.Bitmap;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder.java */
/* loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f5085a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5086b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(Bitmap.CompressFormat compressFormat, int i) {
        this.f5085a = compressFormat;
        this.f5086b = i;
    }

    @Override // com.bumptech.glide.c.d.f.e
    public u<byte[]> a(u<Bitmap> uVar, j jVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        uVar.d().compress(this.f5085a, this.f5086b, byteArrayOutputStream);
        uVar.f();
        return new com.bumptech.glide.c.d.b.b(byteArrayOutputStream.toByteArray());
    }
}

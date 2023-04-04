package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* compiled from: CenterInside.java */
/* loaded from: classes.dex */
public class h extends e {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f4995b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(f5102a);

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        return -670243078;
    }

    @Override // com.bumptech.glide.c.d.a.e
    protected Bitmap a(com.bumptech.glide.c.b.a.e eVar, Bitmap bitmap, int i, int i2) {
        return u.c(eVar, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        messageDigest.update(f4995b);
    }
}

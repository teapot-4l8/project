package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* compiled from: CenterCrop.java */
/* loaded from: classes.dex */
public class g extends e {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f4994b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(f5102a);

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        return -599754482;
    }

    @Override // com.bumptech.glide.c.d.a.e
    protected Bitmap a(com.bumptech.glide.c.b.a.e eVar, Bitmap bitmap, int i, int i2) {
        return u.a(eVar, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        return obj instanceof g;
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        messageDigest.update(f4994b);
    }
}

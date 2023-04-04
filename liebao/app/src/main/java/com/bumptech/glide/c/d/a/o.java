package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* compiled from: FitCenter.java */
/* loaded from: classes.dex */
public class o extends e {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f5017b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(f5102a);

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        return 1572326941;
    }

    @Override // com.bumptech.glide.c.d.a.e
    protected Bitmap a(com.bumptech.glide.c.b.a.e eVar, Bitmap bitmap, int i, int i2) {
        return u.b(eVar, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        return obj instanceof o;
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        messageDigest.update(f5017b);
    }
}

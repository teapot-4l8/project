package com.bumptech.glide.c.b;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey.java */
/* loaded from: classes.dex */
final class w implements com.bumptech.glide.c.h {

    /* renamed from: b  reason: collision with root package name */
    private static final com.bumptech.glide.i.f<Class<?>, byte[]> f4871b = new com.bumptech.glide.i.f<>(50);

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.b f4872c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.c.h f4873d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.c.h f4874e;
    private final int f;
    private final int g;
    private final Class<?> h;
    private final com.bumptech.glide.c.j i;
    private final com.bumptech.glide.c.m<?> j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(com.bumptech.glide.c.b.a.b bVar, com.bumptech.glide.c.h hVar, com.bumptech.glide.c.h hVar2, int i, int i2, com.bumptech.glide.c.m<?> mVar, Class<?> cls, com.bumptech.glide.c.j jVar) {
        this.f4872c = bVar;
        this.f4873d = hVar;
        this.f4874e = hVar2;
        this.f = i;
        this.g = i2;
        this.j = mVar;
        this.h = cls;
        this.i = jVar;
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            return this.g == wVar.g && this.f == wVar.f && com.bumptech.glide.i.j.a(this.j, wVar.j) && this.h.equals(wVar.h) && this.f4873d.equals(wVar.f4873d) && this.f4874e.equals(wVar.f4874e) && this.i.equals(wVar.i);
        }
        return false;
    }

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        int hashCode = (((((this.f4873d.hashCode() * 31) + this.f4874e.hashCode()) * 31) + this.f) * 31) + this.g;
        com.bumptech.glide.c.m<?> mVar = this.j;
        if (mVar != null) {
            hashCode = (hashCode * 31) + mVar.hashCode();
        }
        return (((hashCode * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f4872c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f).putInt(this.g).array();
        this.f4874e.a(messageDigest);
        this.f4873d.a(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.c.m<?> mVar = this.j;
        if (mVar != null) {
            mVar.a(messageDigest);
        }
        this.i.a(messageDigest);
        messageDigest.update(a());
        this.f4872c.a((com.bumptech.glide.c.b.a.b) bArr);
    }

    private byte[] a() {
        byte[] b2 = f4871b.b(this.h);
        if (b2 == null) {
            byte[] bytes = this.h.getName().getBytes(f5102a);
            f4871b.b(this.h, bytes);
            return bytes;
        }
        return b2;
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f4873d + ", signature=" + this.f4874e + ", width=" + this.f + ", height=" + this.g + ", decodedResourceClass=" + this.h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}

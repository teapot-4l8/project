package com.bumptech.glide.c.b;

import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
class m implements com.bumptech.glide.c.h {

    /* renamed from: b  reason: collision with root package name */
    private final Object f4839b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4840c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4841d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f4842e;
    private final Class<?> f;
    private final com.bumptech.glide.c.h g;
    private final Map<Class<?>, com.bumptech.glide.c.m<?>> h;
    private final com.bumptech.glide.c.j i;
    private int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Object obj, com.bumptech.glide.c.h hVar, int i, int i2, Map<Class<?>, com.bumptech.glide.c.m<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.c.j jVar) {
        this.f4839b = com.bumptech.glide.i.i.a(obj);
        this.g = (com.bumptech.glide.c.h) com.bumptech.glide.i.i.a(hVar, "Signature must not be null");
        this.f4840c = i;
        this.f4841d = i2;
        this.h = (Map) com.bumptech.glide.i.i.a(map);
        this.f4842e = (Class) com.bumptech.glide.i.i.a(cls, "Resource class must not be null");
        this.f = (Class) com.bumptech.glide.i.i.a(cls2, "Transcode class must not be null");
        this.i = (com.bumptech.glide.c.j) com.bumptech.glide.i.i.a(jVar);
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            return this.f4839b.equals(mVar.f4839b) && this.g.equals(mVar.g) && this.f4841d == mVar.f4841d && this.f4840c == mVar.f4840c && this.h.equals(mVar.h) && this.f4842e.equals(mVar.f4842e) && this.f.equals(mVar.f) && this.i.equals(mVar.i);
        }
        return false;
    }

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.f4839b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.g.hashCode();
            this.j = hashCode2;
            int i = (hashCode2 * 31) + this.f4840c;
            this.j = i;
            int i2 = (i * 31) + this.f4841d;
            this.j = i2;
            int hashCode3 = (i2 * 31) + this.h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f4842e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f4839b + ", width=" + this.f4840c + ", height=" + this.f4841d + ", resourceClass=" + this.f4842e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}

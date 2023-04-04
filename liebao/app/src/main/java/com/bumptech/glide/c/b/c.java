package com.bumptech.glide.c.b;

import java.security.MessageDigest;

/* compiled from: DataCacheKey.java */
/* loaded from: classes.dex */
final class c implements com.bumptech.glide.c.h {

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.c.h f4750b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.c.h f4751c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.bumptech.glide.c.h hVar, com.bumptech.glide.c.h hVar2) {
        this.f4750b = hVar;
        this.f4751c = hVar2;
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f4750b.equals(cVar.f4750b) && this.f4751c.equals(cVar.f4751c);
        }
        return false;
    }

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        return (this.f4750b.hashCode() * 31) + this.f4751c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f4750b + ", signature=" + this.f4751c + '}';
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        this.f4750b.a(messageDigest);
        this.f4751c.a(messageDigest);
    }
}

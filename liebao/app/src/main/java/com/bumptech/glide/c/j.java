package com.bumptech.glide.c;

import java.security.MessageDigest;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: b  reason: collision with root package name */
    private final androidx.b.a<i<?>, Object> f5108b = new com.bumptech.glide.i.b();

    public void a(j jVar) {
        this.f5108b.a((androidx.b.g<? extends i<?>, ? extends Object>) jVar.f5108b);
    }

    public <T> j a(i<T> iVar, T t) {
        this.f5108b.put(iVar, t);
        return this;
    }

    public <T> T a(i<T> iVar) {
        return this.f5108b.containsKey(iVar) ? (T) this.f5108b.get(iVar) : iVar.a();
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f5108b.equals(((j) obj).f5108b);
        }
        return false;
    }

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        return this.f5108b.hashCode();
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        for (int i = 0; i < this.f5108b.size(); i++) {
            a(this.f5108b.b(i), this.f5108b.c(i), messageDigest);
        }
    }

    public String toString() {
        return "Options{values=" + this.f5108b + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(i<T> iVar, Object obj, MessageDigest messageDigest) {
        iVar.a((i<T>) obj, messageDigest);
    }
}

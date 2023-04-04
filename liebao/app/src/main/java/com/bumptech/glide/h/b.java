package com.bumptech.glide.h;

import com.bumptech.glide.c.h;
import com.bumptech.glide.i.i;
import java.security.MessageDigest;

/* compiled from: ObjectKey.java */
/* loaded from: classes.dex */
public final class b implements h {

    /* renamed from: b  reason: collision with root package name */
    private final Object f5224b;

    public b(Object obj) {
        this.f5224b = i.a(obj);
    }

    public String toString() {
        return "ObjectKey{object=" + this.f5224b + '}';
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f5224b.equals(((b) obj).f5224b);
        }
        return false;
    }

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        return this.f5224b.hashCode();
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.f5224b.toString().getBytes(f5102a));
    }
}

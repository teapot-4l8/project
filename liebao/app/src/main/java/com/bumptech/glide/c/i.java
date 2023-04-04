package com.bumptech.glide.c;

import java.security.MessageDigest;

/* compiled from: Option.java */
/* loaded from: classes.dex */
public final class i<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final a<Object> f5103a = new a<Object>() { // from class: com.bumptech.glide.c.i.1
        @Override // com.bumptech.glide.c.i.a
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final T f5104b;

    /* renamed from: c  reason: collision with root package name */
    private final a<T> f5105c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5106d;

    /* renamed from: e  reason: collision with root package name */
    private volatile byte[] f5107e;

    /* compiled from: Option.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public static <T> i<T> a(String str) {
        return new i<>(str, null, c());
    }

    public static <T> i<T> a(String str, T t) {
        return new i<>(str, t, c());
    }

    public static <T> i<T> a(String str, T t, a<T> aVar) {
        return new i<>(str, t, aVar);
    }

    private i(String str, T t, a<T> aVar) {
        this.f5106d = com.bumptech.glide.i.i.a(str);
        this.f5104b = t;
        this.f5105c = (a) com.bumptech.glide.i.i.a(aVar);
    }

    public T a() {
        return this.f5104b;
    }

    public void a(T t, MessageDigest messageDigest) {
        this.f5105c.a(b(), t, messageDigest);
    }

    private byte[] b() {
        if (this.f5107e == null) {
            this.f5107e = this.f5106d.getBytes(h.f5102a);
        }
        return this.f5107e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f5106d.equals(((i) obj).f5106d);
        }
        return false;
    }

    public int hashCode() {
        return this.f5106d.hashCode();
    }

    private static <T> a<T> c() {
        return (a<T>) f5103a;
    }

    public String toString() {
        return "Option{key='" + this.f5106d + "'}";
    }
}

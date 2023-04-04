package com.facebook.crypto;

import java.nio.charset.Charset;

/* compiled from: Entity.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f5326a = Charset.forName("UTF-16");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f5327b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private byte[] f5328c;

    private g(byte[] bArr) {
        this.f5328c = bArr;
    }

    public byte[] a() {
        return this.f5328c;
    }

    public static g a(String str) {
        return new g(str.getBytes(f5327b));
    }
}

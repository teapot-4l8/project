package com.bumptech.glide.c.d.b;

import com.bumptech.glide.c.b.u;
import com.bumptech.glide.i.i;

/* compiled from: BytesResource.java */
/* loaded from: classes.dex */
public class b implements u<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5050a;

    @Override // com.bumptech.glide.c.b.u
    public void f() {
    }

    public b(byte[] bArr) {
        this.f5050a = (byte[]) i.a(bArr);
    }

    @Override // com.bumptech.glide.c.b.u
    public Class<byte[]> c() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.c.b.u
    /* renamed from: a */
    public byte[] d() {
        return this.f5050a;
    }

    @Override // com.bumptech.glide.c.b.u
    public int e() {
        return this.f5050a.length;
    }
}

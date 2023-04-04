package com.bumptech.glide.c.b.a;

/* compiled from: ByteArrayAdapter.java */
/* loaded from: classes.dex */
public final class g implements a<byte[]> {
    @Override // com.bumptech.glide.c.b.a.a
    public String a() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.c.b.a.a
    public int b() {
        return 1;
    }

    @Override // com.bumptech.glide.c.b.a.a
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.c.b.a.a
    /* renamed from: b */
    public byte[] a(int i) {
        return new byte[i];
    }
}

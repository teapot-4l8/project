package com.bumptech.glide.c.b.a;

/* compiled from: IntegerArrayAdapter.java */
/* loaded from: classes.dex */
public final class i implements a<int[]> {
    @Override // com.bumptech.glide.c.b.a.a
    public String a() {
        return "IntegerArrayPool";
    }

    @Override // com.bumptech.glide.c.b.a.a
    public int b() {
        return 4;
    }

    @Override // com.bumptech.glide.c.b.a.a
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.c.b.a.a
    /* renamed from: b */
    public int[] a(int i) {
        return new int[i];
    }
}

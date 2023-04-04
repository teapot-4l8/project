package com.bumptech.glide.c.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.b.a;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public final class b implements a.InterfaceC0084a {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.e f5060a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.b f5061b;

    public b(com.bumptech.glide.c.b.a.e eVar, com.bumptech.glide.c.b.a.b bVar) {
        this.f5060a = eVar;
        this.f5061b = bVar;
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0084a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f5060a.b(i, i2, config);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0084a
    public void a(Bitmap bitmap) {
        this.f5060a.a(bitmap);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0084a
    public byte[] a(int i) {
        com.bumptech.glide.c.b.a.b bVar = this.f5061b;
        if (bVar == null) {
            return new byte[i];
        }
        return (byte[]) bVar.a(i, byte[].class);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0084a
    public void a(byte[] bArr) {
        com.bumptech.glide.c.b.a.b bVar = this.f5061b;
        if (bVar == null) {
            return;
        }
        bVar.a((com.bumptech.glide.c.b.a.b) bArr);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0084a
    public int[] b(int i) {
        com.bumptech.glide.c.b.a.b bVar = this.f5061b;
        if (bVar == null) {
            return new int[i];
        }
        return (int[]) bVar.a(i, int[].class);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0084a
    public void a(int[] iArr) {
        com.bumptech.glide.c.b.a.b bVar = this.f5061b;
        if (bVar == null) {
            return;
        }
        bVar.a((com.bumptech.glide.c.b.a.b) iArr);
    }
}

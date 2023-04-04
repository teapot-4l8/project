package com.bumptech.glide.c.a;

import java.io.OutputStream;

/* compiled from: BufferedOutputStream.java */
/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f4643a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f4644b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.c.b.a.b f4645c;

    /* renamed from: d  reason: collision with root package name */
    private int f4646d;

    public c(OutputStream outputStream, com.bumptech.glide.c.b.a.b bVar) {
        this(outputStream, bVar, 65536);
    }

    c(OutputStream outputStream, com.bumptech.glide.c.b.a.b bVar, int i) {
        this.f4643a = outputStream;
        this.f4645c = bVar;
        this.f4644b = (byte[]) bVar.a(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.f4644b;
        int i2 = this.f4646d;
        this.f4646d = i2 + 1;
        bArr[i2] = (byte) i;
        b();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.f4646d == 0 && i4 >= this.f4644b.length) {
                this.f4643a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f4644b.length - this.f4646d);
            System.arraycopy(bArr, i5, this.f4644b, this.f4646d, min);
            this.f4646d += min;
            i3 += min;
            b();
        } while (i3 < i2);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f4643a.flush();
    }

    private void a() {
        int i = this.f4646d;
        if (i > 0) {
            this.f4643a.write(this.f4644b, 0, i);
            this.f4646d = 0;
        }
    }

    private void b() {
        if (this.f4646d == this.f4644b.length) {
            a();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f4643a.close();
            c();
        } catch (Throwable th) {
            this.f4643a.close();
            throw th;
        }
    }

    private void c() {
        byte[] bArr = this.f4644b;
        if (bArr != null) {
            this.f4645c.a((com.bumptech.glide.c.b.a.b) bArr);
            this.f4644b = null;
        }
    }
}

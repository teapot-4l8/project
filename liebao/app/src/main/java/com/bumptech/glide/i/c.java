package com.bumptech.glide.i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f5244a;

    /* renamed from: b  reason: collision with root package name */
    private int f5245b;

    public static InputStream a(InputStream inputStream, long j) {
        return new c(inputStream, j);
    }

    private c(InputStream inputStream, long j) {
        super(inputStream);
        this.f5244a = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f5244a - this.f5245b, this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        return a(super.read(bArr, i, i2));
    }

    private int a(int i) {
        if (i >= 0) {
            this.f5245b += i;
        } else if (this.f5244a - this.f5245b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f5244a + ", but read: " + this.f5245b);
        }
        return i;
    }
}

package com.bumptech.glide.c.a;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: ExifOrientationStream.java */
/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f4650a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f4651b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4652c;

    /* renamed from: d  reason: collision with root package name */
    private final byte f4653d;

    /* renamed from: e  reason: collision with root package name */
    private int f4654e;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f4650a = bArr;
        int length = bArr.length;
        f4651b = length;
        f4652c = length + 2;
    }

    public g(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.f4653d = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read;
        int i;
        int i2 = this.f4654e;
        if (i2 < 2 || i2 > (i = f4652c)) {
            read = super.read();
        } else if (i2 == i) {
            read = this.f4653d;
        } else {
            read = f4650a[i2 - 2] & 255;
        }
        if (read != -1) {
            this.f4654e++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.f4654e;
        int i5 = f4652c;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f4653d;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(f4650a, this.f4654e - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.f4654e += i3;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f4654e = (int) (this.f4654e + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }
}

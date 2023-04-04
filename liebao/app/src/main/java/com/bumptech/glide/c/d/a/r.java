package com.bumptech.glide.c.d.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RecyclableBufferedInputStream.java */
/* loaded from: classes.dex */
public class r extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f5024a;

    /* renamed from: b  reason: collision with root package name */
    private int f5025b;

    /* renamed from: c  reason: collision with root package name */
    private int f5026c;

    /* renamed from: d  reason: collision with root package name */
    private int f5027d;

    /* renamed from: e  reason: collision with root package name */
    private int f5028e;
    private final com.bumptech.glide.c.b.a.b f;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public r(InputStream inputStream, com.bumptech.glide.c.b.a.b bVar) {
        this(inputStream, bVar, 65536);
    }

    r(InputStream inputStream, com.bumptech.glide.c.b.a.b bVar, int i) {
        super(inputStream);
        this.f5027d = -1;
        this.f = bVar;
        this.f5024a = (byte[]) bVar.a(i, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f5024a == null || inputStream == null) {
            throw c();
        }
        return (this.f5025b - this.f5028e) + inputStream.available();
    }

    private static IOException c() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f5026c = this.f5024a.length;
    }

    public synchronized void b() {
        if (this.f5024a != null) {
            this.f.a((com.bumptech.glide.c.b.a.b) this.f5024a);
            this.f5024a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f5024a != null) {
            this.f.a((com.bumptech.glide.c.b.a.b) this.f5024a);
            this.f5024a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int a(InputStream inputStream, byte[] bArr) {
        int i = this.f5027d;
        if (i != -1) {
            int i2 = this.f5028e - i;
            int i3 = this.f5026c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f5025b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f.a(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f5024a = bArr2;
                    this.f.a((com.bumptech.glide.c.b.a.b) bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.f5027d;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                int i5 = this.f5028e - this.f5027d;
                this.f5028e = i5;
                this.f5027d = 0;
                this.f5025b = 0;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.f5028e;
                if (read > 0) {
                    i6 += read;
                }
                this.f5025b = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f5027d = -1;
            this.f5028e = 0;
            this.f5025b = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f5026c = Math.max(this.f5026c, i);
        this.f5027d = this.f5028e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f5024a;
        InputStream inputStream = this.in;
        if (bArr == null || inputStream == null) {
            throw c();
        }
        if (this.f5028e < this.f5025b || a(inputStream, bArr) != -1) {
            if (bArr != this.f5024a && (bArr = this.f5024a) == null) {
                throw c();
            }
            if (this.f5025b - this.f5028e > 0) {
                int i = this.f5028e;
                this.f5028e = i + 1;
                return bArr[i] & 255;
            }
            return -1;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.f5024a;
        if (bArr2 == null) {
            throw c();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw c();
        }
        if (this.f5028e < this.f5025b) {
            int i5 = this.f5025b - this.f5028e >= i2 ? i2 : this.f5025b - this.f5028e;
            System.arraycopy(bArr2, this.f5028e, bArr, i, i5);
            this.f5028e += i5;
            if (i5 == i2 || inputStream.available() == 0) {
                return i5;
            }
            i += i5;
            i3 = i2 - i5;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.f5027d == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else if (a(inputStream, bArr2) == -1) {
                return i3 != i2 ? i2 - i3 : -1;
            } else {
                if (bArr2 != this.f5024a && (bArr2 = this.f5024a) == null) {
                    throw c();
                }
                i4 = this.f5025b - this.f5028e >= i3 ? i3 : this.f5025b - this.f5028e;
                System.arraycopy(bArr2, this.f5028e, bArr, i, i4);
                this.f5028e += i4;
            }
            i3 -= i4;
            if (i3 == 0) {
                return i2;
            }
            if (inputStream.available() == 0) {
                return i2 - i3;
            }
            i += i4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f5024a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f5027d) {
            throw new a("Mark has been invalidated, pos: " + this.f5028e + " markLimit: " + this.f5026c);
        }
        this.f5028e = this.f5027d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f5024a;
        if (bArr == null) {
            throw c();
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw c();
        }
        if (this.f5025b - this.f5028e >= j) {
            this.f5028e = (int) (this.f5028e + j);
            return j;
        }
        long j2 = this.f5025b - this.f5028e;
        this.f5028e = this.f5025b;
        if (this.f5027d != -1 && j <= this.f5026c) {
            if (a(inputStream, bArr) == -1) {
                return j2;
            }
            if (this.f5025b - this.f5028e >= j - j2) {
                this.f5028e = (int) ((this.f5028e + j) - j2);
                return j;
            }
            long j3 = (j2 + this.f5025b) - this.f5028e;
            this.f5028e = this.f5025b;
            return j3;
        }
        return j2 + inputStream.skip(j - j2);
    }

    /* compiled from: RecyclableBufferedInputStream.java */
    /* loaded from: classes.dex */
    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }
}

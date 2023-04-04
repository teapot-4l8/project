package com.bumptech.glide.i;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: classes.dex */
public class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f5254a;

    public g(InputStream inputStream) {
        super(inputStream);
        this.f5254a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f5254a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int a2 = (int) a(i2);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a2);
        b(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f5254a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long a2 = a(j);
        if (a2 == -1) {
            return 0L;
        }
        long skip = super.skip(a2);
        b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i = this.f5254a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    private long a(long j) {
        int i = this.f5254a;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    private void b(long j) {
        int i = this.f5254a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f5254a = (int) (i - j);
    }
}

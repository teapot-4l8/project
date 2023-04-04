package com.facebook.crypto.d;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.InputStream;

/* compiled from: NativeGCMCipherInputStream.java */
/* loaded from: classes.dex */
public class b extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final d f5301a;

    /* renamed from: b  reason: collision with root package name */
    private final NativeGCMCipher f5302b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f5303c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5304d = false;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public b(InputStream inputStream, NativeGCMCipher nativeGCMCipher, int i) {
        this.f5301a = new d(inputStream, i);
        this.f5302b = nativeGCMCipher;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f5301a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            a();
        } finally {
            this.f5301a.close();
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        if (bArr.length < i3) {
            throw new ArrayIndexOutOfBoundsException(i3);
        }
        int read = this.f5301a.read(bArr, i, i2);
        if (read == -1) {
            a();
            return -1;
        }
        return this.f5302b.a(bArr, i, read, bArr, i);
    }

    private void a() {
        if (this.f5304d) {
            return;
        }
        this.f5304d = true;
        try {
            byte[] a2 = this.f5301a.a();
            this.f5302b.c(a2, a2.length);
        } finally {
            this.f5302b.a();
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        if (this.f5303c == null) {
            this.f5303c = new byte[256];
        }
        long j2 = 0;
        while (j > 0) {
            int read = read(this.f5303c, 0, (int) Math.min(j, 256L));
            if (read < 0) {
                break;
            }
            long j3 = read;
            j2 += j3;
            j -= j3;
        }
        if (j2 == 0) {
            return -1L;
        }
        return j2;
    }
}

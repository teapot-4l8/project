package com.facebook.crypto.d;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.OutputStream;

/* compiled from: NativeGCMCipherOutputStream.java */
/* loaded from: classes.dex */
public class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f5305a;

    /* renamed from: b  reason: collision with root package name */
    private final NativeGCMCipher f5306b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5307c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f5308d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f5309e;
    private boolean f = false;

    public c(OutputStream outputStream, NativeGCMCipher nativeGCMCipher, byte[] bArr, int i) {
        this.f5305a = outputStream;
        this.f5306b = nativeGCMCipher;
        this.f5309e = new byte[i];
        int b2 = nativeGCMCipher.b();
        if (bArr == null) {
            bArr = new byte[b2 + 256];
        } else {
            int i2 = b2 + 1;
            if (bArr.length < i2) {
                throw new IllegalArgumentException("encryptBuffer cannot be smaller than " + i2 + "B");
            }
        }
        this.f5307c = bArr.length - b2;
        this.f5308d = bArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            a();
        } finally {
            this.f5305a.close();
        }
    }

    private void a() {
        if (this.f) {
            return;
        }
        this.f = true;
        try {
            this.f5306b.b(this.f5309e, this.f5309e.length);
            this.f5305a.write(this.f5309e);
        } finally {
            this.f5306b.a();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f5305a.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        if (bArr.length < i3) {
            throw new ArrayIndexOutOfBoundsException(i3);
        }
        int i4 = this.f5307c;
        int i5 = i2 / i4;
        int i6 = i2 % i4;
        int i7 = i;
        for (int i8 = 0; i8 < i5; i8++) {
            this.f5305a.write(this.f5308d, 0, this.f5306b.a(bArr, i7, this.f5307c, this.f5308d, 0));
            i7 += this.f5307c;
        }
        if (i6 > 0) {
            this.f5305a.write(this.f5308d, 0, this.f5306b.a(bArr, i7, i6, this.f5308d, 0));
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }
}

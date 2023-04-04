package com.facebook.crypto.d;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TailInputStream.java */
/* loaded from: classes.dex */
public class d extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5310a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5311b;

    /* renamed from: c  reason: collision with root package name */
    private int f5312c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5313d;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(InputStream inputStream, int i) {
        super(inputStream);
        this.f5310a = new byte[i];
        this.f5311b = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        while (read == 0) {
            read = read(bArr, 0, 1);
        }
        if (read == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.f5313d) {
            return -1;
        }
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i3 == 0) {
            i3 = a(bArr, i, i2);
        }
        return i3;
    }

    private int a(byte[] bArr, int i, int i2) {
        int i3 = this.f5312c;
        int i4 = 0;
        if (i2 >= i3) {
            int read = this.in.read(bArr, this.f5312c + i, i2 - i3);
            if (read == -1) {
                this.f5313d = true;
                return -1;
            }
            int i5 = this.f5312c;
            if (i5 > 0) {
                System.arraycopy(this.f5310a, 0, bArr, i, i5);
            }
            int i6 = this.f5312c + read;
            int read2 = this.in.read(this.f5310a, 0, this.f5311b);
            if (read2 == -1) {
                this.f5313d = true;
            } else {
                i4 = read2;
            }
            return a(bArr, i6, i4, i);
        }
        int i7 = i3 - i2;
        System.arraycopy(this.f5310a, 0, bArr, i, i2);
        byte[] bArr2 = this.f5310a;
        System.arraycopy(bArr2, i2, bArr2, 0, i7);
        int read3 = this.in.read(this.f5310a, i7, this.f5311b - i7);
        if (read3 == -1) {
            byte[] bArr3 = this.f5310a;
            System.arraycopy(bArr3, 0, bArr3, i2, i7);
            System.arraycopy(bArr, i, this.f5310a, 0, i2);
            this.f5313d = true;
            return -1;
        }
        return a(bArr, i2, read3 + i7, i);
    }

    private int a(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.f5311b - i2;
        int max = Math.max(0, i - i4) + i3;
        int min = Math.min(i4, i);
        if (min > 0) {
            if (i2 > 0) {
                byte[] bArr2 = this.f5310a;
                System.arraycopy(bArr2, 0, bArr2, min, i2);
            }
            System.arraycopy(bArr, max, this.f5310a, 0, min);
        }
        this.f5312c = min + i2;
        return max - i3;
    }

    public byte[] a() {
        if (this.f5312c != this.f5311b) {
            throw new IOException("Not enough tail data");
        }
        return this.f5310a;
    }
}

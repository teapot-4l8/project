package cn.jiguang.ay;

import cn.jiguang.f.i;
import java.math.BigInteger;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: d  reason: collision with root package name */
    private static final BigInteger f4018d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a  reason: collision with root package name */
    private byte[] f4019a;

    /* renamed from: b  reason: collision with root package name */
    private int f4020b;

    /* renamed from: c  reason: collision with root package name */
    private int f4021c;

    public b() {
        this(32);
    }

    public b(int i) {
        this.f4019a = new byte[i];
        this.f4020b = 0;
        this.f4021c = -1;
    }

    private static void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            cn.jiguang.an.d.f("Outputer", j + " out of range for " + i + " bit value max:" + j2);
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        c(i2);
        System.arraycopy(bArr, 0, this.f4019a, this.f4020b, i2);
        this.f4020b += i2;
    }

    private void c(int i) {
        byte[] bArr = this.f4019a;
        int length = bArr.length;
        int i2 = this.f4020b;
        if (length - i2 >= i) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i2 + i) {
            length2 = i2 + i;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(this.f4019a, 0, bArr2, 0, this.f4020b);
        this.f4019a = bArr2;
    }

    public final int a() {
        return this.f4020b;
    }

    public final void a(int i) {
        a(i, 8);
        c(1);
        byte[] bArr = this.f4019a;
        int i2 = this.f4020b;
        this.f4020b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public final void a(int i, int i2) {
        a(i, 8);
        if (4 > this.f4020b - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.f4019a[4] = (byte) (i & 255);
    }

    public final void a(long j) {
        a(j, 32);
        c(4);
        byte[] bArr = this.f4019a;
        int i = this.f4020b;
        int i2 = i + 1;
        this.f4020b = i2;
        bArr[i] = (byte) ((j >>> 24) & 255);
        int i3 = i2 + 1;
        this.f4020b = i3;
        bArr[i2] = (byte) ((j >>> 16) & 255);
        int i4 = i3 + 1;
        this.f4020b = i4;
        bArr[i3] = (byte) ((j >>> 8) & 255);
        this.f4020b = i4 + 1;
        bArr[i4] = (byte) (j & 255);
    }

    public final void a(String str) {
        byte[] j = i.j(str);
        b(j.length);
        a(j, 0, j.length);
    }

    public final void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public final void b(int i) {
        a(i, 16);
        c(2);
        byte[] bArr = this.f4019a;
        int i2 = this.f4020b;
        int i3 = i2 + 1;
        this.f4020b = i3;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        this.f4020b = i3 + 1;
        bArr[i3] = (byte) (i & 255);
    }

    public final void b(int i, int i2) {
        a(i, 16);
        if (this.f4020b - 2 < 0) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f4019a;
        bArr[0] = (byte) ((i >>> 8) & 255);
        bArr[1] = (byte) (i & 255);
    }

    public final void b(long j) {
        c(8);
        byte[] bArr = this.f4019a;
        int i = this.f4020b;
        int i2 = i + 1;
        this.f4020b = i2;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        this.f4020b = i3;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        this.f4020b = i4;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        this.f4020b = i5;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        this.f4020b = i6;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        this.f4020b = i7;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        this.f4020b = i8;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        this.f4020b = i8 + 1;
        bArr[i8] = (byte) (j & 255);
    }

    public final byte[] b() {
        int i = this.f4020b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f4019a, 0, bArr, 0, i);
        return bArr;
    }
}

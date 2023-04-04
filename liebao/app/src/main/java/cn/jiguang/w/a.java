package cn.jiguang.w;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static final BigInteger f4243d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a  reason: collision with root package name */
    private byte[] f4244a;

    /* renamed from: b  reason: collision with root package name */
    private int f4245b;

    /* renamed from: c  reason: collision with root package name */
    private int f4246c;

    public a() {
        this(32);
    }

    public a(int i) {
        this.f4244a = new byte[i];
        this.f4245b = 0;
        this.f4246c = -1;
    }

    private void b(int i) {
        byte[] bArr = this.f4244a;
        int length = bArr.length;
        int i2 = this.f4245b;
        if (length - i2 >= i) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i2 + i) {
            length2 = i2 + i;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(this.f4244a, 0, bArr2, 0, this.f4245b);
        this.f4244a = bArr2;
    }

    public final void a(int i) {
        long j = i;
        if (j < 0 || j > 65536) {
            cn.jiguang.ad.a.d("JCommonPackager", j + " out of range for 16 bit value max:65536");
        }
        b(2);
        byte[] bArr = this.f4244a;
        int i2 = this.f4245b;
        int i3 = i2 + 1;
        this.f4245b = i3;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        this.f4245b = i3 + 1;
        bArr[i3] = (byte) (i & 255);
    }

    public final void a(long j) {
        b(8);
        byte[] bArr = this.f4244a;
        int i = this.f4245b;
        int i2 = i + 1;
        this.f4245b = i2;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        this.f4245b = i3;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        this.f4245b = i4;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        this.f4245b = i5;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        this.f4245b = i6;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        this.f4245b = i7;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        this.f4245b = i8;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        this.f4245b = i8 + 1;
        bArr[i8] = (byte) (j & 255);
    }

    public final void a(byte[] bArr, int i, int i2) {
        b(i2);
        System.arraycopy(bArr, 0, this.f4244a, this.f4245b, i2);
        this.f4245b += i2;
    }

    public final byte[] a() {
        int i = this.f4245b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f4244a, 0, bArr, 0, i);
        return bArr;
    }
}

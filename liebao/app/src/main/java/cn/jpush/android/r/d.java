package cn.jpush.android.r;

import cn.jpush.android.helper.Logger;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    private static final BigInteger f4443d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a  reason: collision with root package name */
    private byte[] f4444a;

    /* renamed from: b  reason: collision with root package name */
    private int f4445b;

    /* renamed from: c  reason: collision with root package name */
    private int f4446c;

    public d() {
        this(32);
    }

    public d(int i) {
        this.f4444a = new byte[i];
        this.f4445b = 0;
        this.f4446c = -1;
    }

    private void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            Logger.w("OutputDataUtil", j + " out of range for " + i + " bit value max:" + j2);
        }
    }

    private void c(int i) {
        byte[] bArr = this.f4444a;
        int length = bArr.length;
        int i2 = this.f4445b;
        if (length - i2 >= i) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i2 + i) {
            length2 = i2 + i;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(this.f4444a, 0, bArr2, 0, this.f4445b);
        this.f4444a = bArr2;
    }

    public void a(int i) {
        a(i, 8);
        c(1);
        byte[] bArr = this.f4444a;
        int i2 = this.f4445b;
        this.f4445b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void a(long j) {
        c(8);
        byte[] bArr = this.f4444a;
        int i = this.f4445b;
        int i2 = i + 1;
        this.f4445b = i2;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        this.f4445b = i3;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        this.f4445b = i4;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        this.f4445b = i5;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        this.f4445b = i6;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        this.f4445b = i7;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        this.f4445b = i8;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        this.f4445b = i8 + 1;
        bArr[i8] = (byte) (j & 255);
    }

    public void a(byte[] bArr) {
        b(bArr.length);
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i, int i2) {
        c(i2);
        System.arraycopy(bArr, i, this.f4444a, this.f4445b, i2);
        this.f4445b += i2;
    }

    public byte[] a() {
        int i = this.f4445b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f4444a, 0, bArr, 0, i);
        return bArr;
    }

    public void b(int i) {
        a(i, 16);
        c(2);
        byte[] bArr = this.f4444a;
        int i2 = this.f4445b;
        int i3 = i2 + 1;
        this.f4445b = i3;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        this.f4445b = i3 + 1;
        bArr[i3] = (byte) (i & 255);
    }
}

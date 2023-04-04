package cn.jiguang.as;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3877a;

    /* renamed from: b  reason: collision with root package name */
    private int f3878b;

    /* renamed from: c  reason: collision with root package name */
    private int f3879c;

    public d() {
        this(32);
    }

    private d(int i) {
        this.f3877a = new byte[32];
        this.f3878b = 0;
        this.f3879c = -1;
    }

    private static void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            throw new IllegalArgumentException(j + " out of range for " + i + " bit value");
        }
    }

    private void d(int i) {
        byte[] bArr = this.f3877a;
        int length = bArr.length;
        int i2 = this.f3878b;
        if (length - i2 >= i) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i2 + i) {
            length2 = i2 + i;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(this.f3877a, 0, bArr2, 0, this.f3878b);
        this.f3877a = bArr2;
    }

    public final int a() {
        return this.f3878b;
    }

    public final void a(int i) {
        if (i > this.f3878b) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.f3878b = i;
    }

    public final void a(int i, int i2) {
        a(i, 16);
        if (i2 > this.f3878b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f3877a;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
    }

    public final void a(long j) {
        a(j, 32);
        d(4);
        byte[] bArr = this.f3877a;
        int i = this.f3878b;
        int i2 = i + 1;
        this.f3878b = i2;
        bArr[i] = (byte) ((j >>> 24) & 255);
        int i3 = i2 + 1;
        this.f3878b = i3;
        bArr[i2] = (byte) ((j >>> 16) & 255);
        int i4 = i3 + 1;
        this.f3878b = i4;
        bArr[i3] = (byte) ((j >>> 8) & 255);
        this.f3878b = i4 + 1;
        bArr[i4] = (byte) (j & 255);
    }

    public final void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public final void a(byte[] bArr, int i, int i2) {
        d(i2);
        System.arraycopy(bArr, i, this.f3877a, this.f3878b, i2);
        this.f3878b += i2;
    }

    public final void b(int i) {
        a(0L, 8);
        d(1);
        byte[] bArr = this.f3877a;
        int i2 = this.f3878b;
        this.f3878b = i2 + 1;
        bArr[i2] = 0;
    }

    public final byte[] b() {
        int i = this.f3878b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f3877a, 0, bArr, 0, i);
        return bArr;
    }

    public final void c(int i) {
        a(i, 16);
        d(2);
        byte[] bArr = this.f3877a;
        int i2 = this.f3878b;
        int i3 = i2 + 1;
        this.f3878b = i3;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        this.f3878b = i3 + 1;
        bArr[i3] = (byte) (i & 255);
    }
}

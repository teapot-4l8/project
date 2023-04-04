package com.umeng.analytics.pro;

/* compiled from: TMemoryInputTransport.java */
/* loaded from: classes2.dex */
public final class cf extends cg {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f6488a;

    /* renamed from: b  reason: collision with root package name */
    private int f6489b;

    /* renamed from: c  reason: collision with root package name */
    private int f6490c;

    @Override // com.umeng.analytics.pro.cg
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cg
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cg
    public void c() {
    }

    public cf() {
    }

    public cf(byte[] bArr) {
        a(bArr);
    }

    public cf(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    public void c(byte[] bArr, int i, int i2) {
        this.f6488a = bArr;
        this.f6489b = i;
        this.f6490c = i + i2;
    }

    public void e() {
        this.f6488a = null;
    }

    @Override // com.umeng.analytics.pro.cg
    public int a(byte[] bArr, int i, int i2) {
        int h = h();
        if (i2 > h) {
            i2 = h;
        }
        if (i2 > 0) {
            System.arraycopy(this.f6488a, this.f6489b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.umeng.analytics.pro.cg
    public void b(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.cg
    public byte[] f() {
        return this.f6488a;
    }

    @Override // com.umeng.analytics.pro.cg
    public int g() {
        return this.f6489b;
    }

    @Override // com.umeng.analytics.pro.cg
    public int h() {
        return this.f6490c - this.f6489b;
    }

    @Override // com.umeng.analytics.pro.cg
    public void a(int i) {
        this.f6489b += i;
    }
}

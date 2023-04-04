package com.umeng.analytics.pro;

/* compiled from: ShortStack.java */
/* loaded from: classes2.dex */
public class ar {

    /* renamed from: a  reason: collision with root package name */
    private short[] f6397a;

    /* renamed from: b  reason: collision with root package name */
    private int f6398b = -1;

    public ar(int i) {
        this.f6397a = new short[i];
    }

    public short a() {
        short[] sArr = this.f6397a;
        int i = this.f6398b;
        this.f6398b = i - 1;
        return sArr[i];
    }

    public void a(short s) {
        if (this.f6397a.length == this.f6398b + 1) {
            d();
        }
        short[] sArr = this.f6397a;
        int i = this.f6398b + 1;
        this.f6398b = i;
        sArr[i] = s;
    }

    private void d() {
        short[] sArr = this.f6397a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f6397a = sArr2;
    }

    public short b() {
        return this.f6397a[this.f6398b];
    }

    public void c() {
        this.f6398b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f6397a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.f6398b) {
                sb.append(">>");
            }
            sb.append((int) this.f6397a[i]);
            if (i == this.f6398b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }
}

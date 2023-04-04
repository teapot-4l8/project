package com.umeng.analytics.pro;

/* compiled from: TApplicationException.java */
/* loaded from: classes2.dex */
public class as extends az {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6399a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6400b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6401c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6402d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6403e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final bx j = new bx("TApplicationException");
    private static final bn k = new bn("message", (byte) 11, 1);
    private static final bn l = new bn(d.y, (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public as() {
        this.i = 0;
    }

    public as(int i) {
        this.i = 0;
        this.i = i;
    }

    public as(int i, String str) {
        super(str);
        this.i = 0;
        this.i = i;
    }

    public as(String str) {
        super(str);
        this.i = 0;
    }

    public int a() {
        return this.i;
    }

    public static as a(bs bsVar) {
        bsVar.j();
        String str = null;
        int i = 0;
        while (true) {
            bn l2 = bsVar.l();
            if (l2.f6457b != 0) {
                short s = l2.f6458c;
                if (s != 1) {
                    if (s == 2) {
                        if (l2.f6457b == 8) {
                            i = bsVar.w();
                        } else {
                            bv.a(bsVar, l2.f6457b);
                        }
                    } else {
                        bv.a(bsVar, l2.f6457b);
                    }
                } else if (l2.f6457b == 11) {
                    str = bsVar.z();
                } else {
                    bv.a(bsVar, l2.f6457b);
                }
                bsVar.m();
            } else {
                bsVar.k();
                return new as(i, str);
            }
        }
    }

    public void b(bs bsVar) {
        bsVar.a(j);
        if (getMessage() != null) {
            bsVar.a(k);
            bsVar.a(getMessage());
            bsVar.c();
        }
        bsVar.a(l);
        bsVar.a(this.i);
        bsVar.c();
        bsVar.d();
        bsVar.b();
    }
}

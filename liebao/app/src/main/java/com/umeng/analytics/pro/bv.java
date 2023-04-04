package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bm;

/* compiled from: TProtocolUtil.java */
/* loaded from: classes2.dex */
public class bv {

    /* renamed from: a  reason: collision with root package name */
    private static int f6476a = Integer.MAX_VALUE;

    public static void a(int i) {
        f6476a = i;
    }

    public static void a(bs bsVar, byte b2) {
        a(bsVar, b2, f6476a);
    }

    public static void a(bs bsVar, byte b2, int i) {
        if (i <= 0) {
            throw new az("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b2) {
            case 2:
                bsVar.t();
                return;
            case 3:
                bsVar.u();
                return;
            case 4:
                bsVar.y();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                bsVar.v();
                return;
            case 8:
                bsVar.w();
                return;
            case 10:
                bsVar.x();
                return;
            case 11:
                bsVar.A();
                return;
            case 12:
                bsVar.j();
                while (true) {
                    bn l = bsVar.l();
                    if (l.f6457b != 0) {
                        a(bsVar, l.f6457b, i - 1);
                        bsVar.m();
                    } else {
                        bsVar.k();
                        return;
                    }
                }
            case 13:
                bp n = bsVar.n();
                while (i2 < n.f6463c) {
                    int i3 = i - 1;
                    a(bsVar, n.f6461a, i3);
                    a(bsVar, n.f6462b, i3);
                    i2++;
                }
                bsVar.o();
                return;
            case 14:
                bw r = bsVar.r();
                while (i2 < r.f6478b) {
                    a(bsVar, r.f6477a, i - 1);
                    i2++;
                }
                bsVar.s();
                return;
            case 15:
                bo p = bsVar.p();
                while (i2 < p.f6460b) {
                    a(bsVar, p.f6459a, i - 1);
                    i2++;
                }
                bsVar.q();
                return;
        }
    }

    public static bu a(byte[] bArr, bu buVar) {
        if (bArr[0] > 16) {
            return new bm.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? buVar : new bm.a();
    }
}

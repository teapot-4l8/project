package a.a.a.d;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;

/* compiled from: TSIG.java */
/* loaded from: classes.dex */
public class ct {

    /* renamed from: a  reason: collision with root package name */
    public static final bj f251a;

    /* renamed from: b  reason: collision with root package name */
    public static final bj f252b;

    /* renamed from: c  reason: collision with root package name */
    public static final bj f253c;

    /* renamed from: d  reason: collision with root package name */
    public static final bj f254d;

    /* renamed from: e  reason: collision with root package name */
    public static final bj f255e;
    public static final bj f;
    public static final bj g;
    private static Map h;
    private bj i;
    private bj j;
    private Mac k;

    static {
        bj b2 = bj.b("HMAC-MD5.SIG-ALG.REG.INT.");
        f251a = b2;
        f252b = b2;
        f253c = bj.b("hmac-sha1.");
        f254d = bj.b("hmac-sha224.");
        f255e = bj.b("hmac-sha256.");
        f = bj.b("hmac-sha384.");
        g = bj.b("hmac-sha512.");
        HashMap hashMap = new HashMap();
        hashMap.put(f251a, "HmacMD5");
        hashMap.put(f253c, "HmacSHA1");
        hashMap.put(f254d, "HmacSHA224");
        hashMap.put(f255e, "HmacSHA256");
        hashMap.put(f, "HmacSHA384");
        hashMap.put(g, "HmacSHA512");
        h = Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Mac mac, byte[] bArr) {
        return a(mac, bArr, false);
    }

    private static boolean a(Mac mac, byte[] bArr, boolean z) {
        byte[] doFinal = mac.doFinal();
        if (z && bArr.length < doFinal.length) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(doFinal, 0, bArr2, 0, length);
            doFinal = bArr2;
        }
        return Arrays.equals(bArr, doFinal);
    }

    public cu a(ax axVar, byte[] bArr, int i, cu cuVar) {
        Date f2;
        boolean z;
        byte[] bArr2;
        if (i != 18) {
            f2 = new Date();
        } else {
            f2 = cuVar.f();
        }
        Date date = f2;
        if (i == 0 || i == 18) {
            z = true;
            this.k.reset();
        } else {
            z = false;
        }
        int d2 = bo.d("tsigfudge");
        int i2 = (d2 < 0 || d2 > 32767) ? 300 : d2;
        if (cuVar != null) {
            v vVar = new v();
            vVar.c(cuVar.o().length);
            if (z) {
                this.k.update(vVar.b());
                this.k.update(cuVar.o());
            }
        }
        if (z) {
            this.k.update(bArr);
        }
        v vVar2 = new v();
        this.i.a(vVar2);
        vVar2.c(255);
        vVar2.a(0L);
        this.j.a(vVar2);
        long time = date.getTime() / 1000;
        vVar2.c((int) (time >> 32));
        vVar2.a(time & 4294967295L);
        vVar2.c(i2);
        vVar2.c(i);
        vVar2.c(0);
        if (z) {
            this.k.update(vVar2.b());
        }
        byte[] doFinal = z ? this.k.doFinal() : new byte[0];
        if (i == 18) {
            v vVar3 = new v();
            long time2 = new Date().getTime() / 1000;
            vVar3.c((int) (time2 >> 32));
            vVar3.a(time2 & 4294967295L);
            bArr2 = vVar3.b();
        } else {
            bArr2 = null;
        }
        return new cu(this.i, 255, 0L, this.j, date, i2, doFinal, axVar.a().b(), i, bArr2);
    }

    public void a(ax axVar, int i, cu cuVar) {
        axVar.a(a(axVar, axVar.h(), i, cuVar), 3);
        axVar.f148b = 3;
    }

    public void a(ax axVar, cu cuVar) {
        a(axVar, 0, cuVar);
    }

    public byte b(ax axVar, byte[] bArr, int i, cu cuVar) {
        axVar.f148b = 4;
        cu c2 = axVar.c();
        this.k.reset();
        if (c2 == null) {
            return (byte) 1;
        }
        if (!c2.j().equals(this.i) || !c2.e().equals(this.j)) {
            if (bo.b("verbose")) {
                System.err.println("BADKEY failure");
            }
            return (byte) 17;
        }
        if (Math.abs(System.currentTimeMillis() - c2.f().getTime()) > c2.g() * 1000) {
            if (bo.b("verbose")) {
                System.err.println("BADTIME failure");
                return (byte) 18;
            }
            return (byte) 18;
        }
        if (cuVar != null && c2.p() != 17 && c2.p() != 16) {
            v vVar = new v();
            vVar.c(cuVar.o().length);
            this.k.update(vVar.b());
            this.k.update(cuVar.o());
        }
        axVar.a().f(3);
        byte[] a2 = axVar.a().a();
        axVar.a().e(3);
        this.k.update(a2);
        this.k.update(bArr, a2.length, axVar.f147a - a2.length);
        v vVar2 = new v();
        c2.j().a(vVar2);
        vVar2.c(c2.i);
        vVar2.a(c2.j);
        c2.e().a(vVar2);
        long time = c2.f().getTime() / 1000;
        vVar2.c((int) (time >> 32));
        vVar2.a(time & 4294967295L);
        vVar2.c(c2.g());
        vVar2.c(c2.p());
        if (c2.q() != null) {
            vVar2.c(c2.q().length);
            vVar2.a(c2.q());
        } else {
            vVar2.c(0);
        }
        this.k.update(vVar2.b());
        byte[] o = c2.o();
        int macLength = this.k.getMacLength();
        int i2 = this.k.getAlgorithm().toLowerCase().contains("md5") ? 10 : macLength / 2;
        if (o.length > macLength) {
            if (bo.b("verbose")) {
                System.err.println("BADSIG: signature too long");
            }
            return com.umeng.analytics.pro.bz.n;
        } else if (o.length < i2) {
            if (bo.b("verbose")) {
                System.err.println("BADSIG: signature too short");
            }
            return com.umeng.analytics.pro.bz.n;
        } else if (!a(this.k, o, true)) {
            if (bo.b("verbose")) {
                System.err.println("BADSIG: signature verification");
            }
            return com.umeng.analytics.pro.bz.n;
        } else {
            axVar.f148b = 1;
            return (byte) 0;
        }
    }

    public int a(ax axVar, byte[] bArr, cu cuVar) {
        return b(axVar, bArr, bArr.length, cuVar);
    }

    public int a() {
        return this.i.b() + 10 + this.j.b() + 8 + 18 + 4 + 8;
    }

    /* compiled from: TSIG.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private ct f256a;

        /* renamed from: b  reason: collision with root package name */
        private Mac f257b;

        /* renamed from: c  reason: collision with root package name */
        private int f258c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f259d;

        /* renamed from: e  reason: collision with root package name */
        private cu f260e;

        public a(ct ctVar, cu cuVar) {
            this.f256a = ctVar;
            this.f257b = ctVar.k;
            this.f260e = cuVar;
        }

        public int a(ax axVar, byte[] bArr) {
            int i;
            int length;
            cu c2 = axVar.c();
            int i2 = this.f258c + 1;
            this.f258c = i2;
            if (i2 == 1) {
                int a2 = this.f256a.a(axVar, bArr, this.f260e);
                if (a2 == 0) {
                    byte[] o = c2.o();
                    v vVar = new v();
                    vVar.c(o.length);
                    this.f257b.update(vVar.b());
                    this.f257b.update(o);
                }
                this.f260e = c2;
                return a2;
            }
            if (c2 != null) {
                axVar.a().f(3);
            }
            byte[] a3 = axVar.a().a();
            if (c2 != null) {
                axVar.a().e(3);
            }
            this.f257b.update(a3);
            if (c2 == null) {
                i = bArr.length;
                length = a3.length;
            } else {
                i = axVar.f147a;
                length = a3.length;
            }
            this.f257b.update(bArr, a3.length, i - length);
            if (c2 != null) {
                this.f259d = this.f258c;
                this.f260e = c2;
                if (!c2.j().equals(this.f256a.i) || !c2.e().equals(this.f256a.j)) {
                    if (bo.b("verbose")) {
                        System.err.println("BADKEY failure");
                    }
                    axVar.f148b = 4;
                    return 17;
                }
                v vVar2 = new v();
                long time = c2.f().getTime() / 1000;
                vVar2.c((int) (time >> 32));
                vVar2.a(time & 4294967295L);
                vVar2.c(c2.g());
                this.f257b.update(vVar2.b());
                if (!ct.b(this.f257b, c2.o())) {
                    if (bo.b("verbose")) {
                        System.err.println("BADSIG failure");
                    }
                    axVar.f148b = 4;
                    return 16;
                }
                this.f257b.reset();
                v vVar3 = new v();
                vVar3.c(c2.o().length);
                this.f257b.update(vVar3.b());
                this.f257b.update(c2.o());
                axVar.f148b = 1;
                return 0;
            }
            if (this.f258c - this.f259d >= 100) {
                axVar.f148b = 4;
                return 1;
            }
            axVar.f148b = 2;
            return 0;
        }
    }
}

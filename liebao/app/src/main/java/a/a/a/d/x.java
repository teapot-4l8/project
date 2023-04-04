package a.a.a.d;

import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.Arrays;

/* compiled from: EDNSOption.java */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    private final int f347a;

    abstract String a();

    abstract void a(t tVar);

    abstract void a(v vVar);

    /* compiled from: EDNSOption.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static ay f348a;

        static {
            ay ayVar = new ay("EDNS Option Codes", 2);
            f348a = ayVar;
            ayVar.b(65535);
            f348a.a("CODE");
            f348a.a(true);
            f348a.a(3, "NSID");
            f348a.a(8, "CLIENT_SUBNET");
        }

        public static String a(int i) {
            return f348a.c(i);
        }
    }

    public x(int i) {
        this.f347a = bx.a(JThirdPlatFormInterface.KEY_CODE, i);
    }

    public String toString() {
        return "{" + a.a(this.f347a) + ": " + a() + "}";
    }

    byte[] b() {
        v vVar = new v();
        a(vVar);
        return vVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x b(t tVar) {
        x bfVar;
        int h = tVar.h();
        int h2 = tVar.h();
        if (tVar.b() < h2) {
            throw new dg("truncated option");
        }
        int d2 = tVar.d();
        tVar.a(h2);
        if (h == 3) {
            bfVar = new bf();
        } else if (h == 8) {
            bfVar = new n();
        } else {
            bfVar = new ad(h);
        }
        bfVar.a(tVar);
        tVar.b(d2);
        return bfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(v vVar) {
        vVar.c(this.f347a);
        int a2 = vVar.a();
        vVar.c(0);
        a(vVar);
        vVar.a((vVar.a() - a2) - 2, a2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f347a != xVar.f347a) {
                return false;
            }
            return Arrays.equals(b(), xVar.b());
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        for (byte b2 : b()) {
            i += (i << 3) + (b2 & 255);
        }
        return i;
    }
}

package a.a.a.d;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

/* compiled from: Record.java */
/* loaded from: classes.dex */
public abstract class bx implements Serializable, Cloneable, Comparable<bx> {

    /* renamed from: a  reason: collision with root package name */
    private static final DecimalFormat f198a;
    protected bj g;
    protected int h;
    protected int i;
    protected long j;

    abstract bx a();

    abstract void a(t tVar);

    abstract void a(v vVar, o oVar, boolean z);

    abstract String b();

    public bj c() {
        return null;
    }

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f198a = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bx() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bj bjVar, int i, int i2, long j) {
        if (!bjVar.a()) {
            throw new by(bjVar);
        }
        cz.a(i);
        p.a(i2);
        cv.a(j);
        this.g = bjVar;
        this.h = i;
        this.i = i2;
        this.j = j;
    }

    private static bx a(bj bjVar, int i, int i2, long j, boolean z) {
        bx yVar;
        if (z) {
            bx c2 = cz.c(i);
            if (c2 != null) {
                yVar = c2.a();
            } else {
                yVar = new dd();
            }
        } else {
            yVar = new y();
        }
        yVar.g = bjVar;
        yVar.h = i;
        yVar.i = i2;
        yVar.j = j;
        return yVar;
    }

    private static bx a(bj bjVar, int i, int i2, long j, int i3, t tVar) {
        bx a2 = a(bjVar, i, i2, j, tVar != null);
        if (tVar != null) {
            if (tVar.b() < i3) {
                throw new dg("truncated record");
            }
            tVar.a(i3);
            a2.a(tVar);
            if (tVar.b() > 0) {
                throw new dg("invalid record length");
            }
            tVar.c();
        }
        return a2;
    }

    public static bx a(bj bjVar, int i, int i2, long j) {
        if (!bjVar.a()) {
            throw new by(bjVar);
        }
        cz.a(i);
        p.a(i2);
        cv.a(j);
        return a(bjVar, i, i2, j, false);
    }

    public static bx a(bj bjVar, int i, int i2) {
        return a(bjVar, i, i2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bx a(t tVar, int i, boolean z) {
        bj bjVar = new bj(tVar);
        int h = tVar.h();
        int h2 = tVar.h();
        if (i == 0) {
            return a(bjVar, h, h2);
        }
        long i2 = tVar.i();
        int h3 = tVar.h();
        if (h3 == 0 && z && (i == 1 || i == 2)) {
            return a(bjVar, h, h2, i2);
        }
        return a(bjVar, h, h2, i2, h3, tVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, int i, o oVar) {
        this.g.a(vVar, oVar);
        vVar.c(this.h);
        vVar.c(this.i);
        if (i == 0) {
            return;
        }
        vVar.a(this.j);
        int a2 = vVar.a();
        vVar.c(0);
        a(vVar, oVar, false);
        vVar.a((vVar.a() - a2) - 2, a2);
    }

    public byte[] a(int i) {
        v vVar = new v();
        a(vVar, i, (o) null);
        return vVar.b();
    }

    private void a(v vVar, boolean z) {
        this.g.a(vVar);
        vVar.c(this.h);
        vVar.c(this.i);
        if (z) {
            vVar.a(0L);
        } else {
            vVar.a(this.j);
        }
        int a2 = vVar.a();
        vVar.c(0);
        a(vVar, (o) null, true);
        vVar.a((vVar.a() - a2) - 2, a2);
    }

    private byte[] a(boolean z) {
        v vVar = new v();
        a(vVar, z);
        return vVar.b();
    }

    public byte[] h() {
        v vVar = new v();
        a(vVar, (o) null, true);
        return vVar.b();
    }

    public String i() {
        return b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.g);
        if (sb.length() < 8) {
            sb.append("\t");
        }
        if (sb.length() < 16) {
            sb.append("\t");
        }
        sb.append("\t");
        if (bo.b("BINDTTL")) {
            sb.append(cv.b(this.j));
        } else {
            sb.append(this.j);
        }
        sb.append("\t");
        if (this.i != 1 || !bo.b("noPrintIN")) {
            sb.append(p.b(this.i));
            sb.append("\t");
        }
        sb.append(cz.b(this.h));
        String b2 = b();
        if (!b2.equals("")) {
            sb.append("\t");
            sb.append(b2);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(byte[] bArr, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('\"');
        }
        for (byte b2 : bArr) {
            int i = b2 & 255;
            if (i < 32 || i >= 127) {
                sb.append('\\');
                sb.append(f198a.format(i));
            } else if (i == 34 || i == 92) {
                sb.append('\\');
                sb.append((char) i);
            } else {
                sb.append((char) i);
            }
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(byte[] bArr) {
        return "\\# " + bArr.length + " " + a.a.a.d.a.a.a(bArr);
    }

    public bj j() {
        return this.g;
    }

    public int k() {
        return this.h;
    }

    public int l_() {
        return this.h;
    }

    public int l() {
        return this.i;
    }

    public long m() {
        return this.j;
    }

    public boolean a(bx bxVar) {
        return l_() == bxVar.l_() && this.i == bxVar.i && this.g.equals(bxVar.g);
    }

    public boolean equals(Object obj) {
        if (obj instanceof bx) {
            bx bxVar = (bx) obj;
            if (this.h == bxVar.h && this.i == bxVar.i && this.g.equals(bxVar.g)) {
                return Arrays.equals(h(), bxVar.h());
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        for (byte b2 : a(true)) {
            i += (i << 3) + (b2 & 255);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx n() {
        try {
            return (bx) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.j = j;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(bx bxVar) {
        if (this == bxVar) {
            return 0;
        }
        int compareTo = this.g.compareTo(bxVar.g);
        if (compareTo != 0) {
            return compareTo;
        }
        int i = this.i - bxVar.i;
        if (i != 0) {
            return i;
        }
        int i2 = this.h - bxVar.h;
        if (i2 != 0) {
            return i2;
        }
        byte[] h = h();
        byte[] h2 = bxVar.h();
        for (int i3 = 0; i3 < h.length && i3 < h2.length; i3++) {
            int i4 = (h[i3] & 255) - (h2[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
        }
        return h.length - h2.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("\"" + str + "\" " + i + " must be an unsigned 16 bit value");
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(String str, long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("\"" + str + "\" " + j + " must be an unsigned 32 bit value");
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bj a(String str, bj bjVar) {
        if (bjVar.a()) {
            return bjVar;
        }
        throw new by("'" + bjVar + "' on field " + str + " is not an absolute name");
    }
}

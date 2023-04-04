package a.a.a.d;

import java.util.Random;

/* compiled from: Header.java */
/* loaded from: classes.dex */
public class af implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static Random f118d = new Random();

    /* renamed from: a  reason: collision with root package name */
    private int f119a;

    /* renamed from: b  reason: collision with root package name */
    private int f120b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f121c;

    private void g() {
        this.f121c = new int[4];
        this.f120b = 0;
        this.f119a = -1;
    }

    public af(int i) {
        g();
        c(i);
    }

    public af() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(t tVar) {
        this(tVar.h());
        this.f120b = tVar.h();
        int i = 0;
        while (true) {
            int[] iArr = this.f121c;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = tVar.h();
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar) {
        vVar.c(b());
        vVar.c(this.f120b);
        for (int i : this.f121c) {
            vVar.c(i);
        }
    }

    public byte[] a() {
        v vVar = new v();
        a(vVar);
        return vVar.b();
    }

    private static boolean i(int i) {
        return i >= 0 && i <= 15 && aa.b(i);
    }

    private static void j(int i) {
        if (i(i)) {
            return;
        }
        throw new IllegalArgumentException("invalid flag bit " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, int i2, boolean z) {
        j(i2);
        return z ? i | (1 << (15 - i2)) : i & ((1 << (15 - i2)) ^ (-1));
    }

    public void a(int i) {
        j(i);
        this.f120b = a(this.f120b, i, true);
    }

    public boolean b(int i) {
        j(i);
        return ((1 << (15 - i)) & this.f120b) != 0;
    }

    public int b() {
        int i;
        int i2 = this.f119a;
        if (i2 >= 0) {
            return i2;
        }
        synchronized (this) {
            if (this.f119a < 0) {
                this.f119a = f118d.nextInt(65535);
            }
            i = this.f119a;
        }
        return i;
    }

    public void c(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
        }
        this.f119a = i;
    }

    public int c() {
        return this.f120b & 15;
    }

    public void d(int i) {
        if (i < 0 || i > 15) {
            throw new IllegalArgumentException("DNS Opcode " + i + "is out of range");
        }
        int i2 = this.f120b & 34815;
        this.f120b = i2;
        this.f120b = (i << 11) | i2;
    }

    public int d() {
        return (this.f120b >> 11) & 15;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        int[] iArr = this.f121c;
        if (iArr[i] == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i] = iArr[i] + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i) {
        int[] iArr = this.f121c;
        if (iArr[i] == 0) {
            throw new IllegalStateException("DNS section count cannot be decremented");
        }
        iArr[i] = iArr[i] - 1;
    }

    public int g(int i) {
        return this.f121c[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f120b;
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if (i(i) && b(i)) {
                sb.append(aa.a(i));
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(";; ->>HEADER<<- ");
        sb.append("opcode: ");
        sb.append(bn.a(d()));
        sb.append(", status: ");
        sb.append(bw.a(i));
        sb.append(", id: ");
        sb.append(b());
        sb.append("\n");
        sb.append(";; flags: ");
        sb.append(f());
        sb.append("; ");
        for (int i2 = 0; i2 < 4; i2++) {
            sb.append(ck.a(i2));
            sb.append(": ");
            sb.append(g(i2));
            sb.append(" ");
        }
        return sb.toString();
    }

    public String toString() {
        return h(c());
    }

    public Object clone() {
        af afVar = new af();
        afVar.f119a = this.f119a;
        afVar.f120b = this.f120b;
        int[] iArr = this.f121c;
        System.arraycopy(iArr, 0, afVar.f121c, 0, iArr.length);
        return afVar;
    }
}

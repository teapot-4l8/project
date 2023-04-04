package a.a.a.d;

import java.io.PrintStream;
import java.io.Serializable;
import java.text.DecimalFormat;

/* compiled from: Name.java */
/* loaded from: classes.dex */
public class bj implements Serializable, Comparable {

    /* renamed from: a  reason: collision with root package name */
    public static final bj f178a;

    /* renamed from: b  reason: collision with root package name */
    public static final bj f179b;
    private static final byte[] f = {0};
    private static final byte[] g = {1, 42};
    private static final DecimalFormat h;
    private static final byte[] i;
    private static final bj j;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f180c;

    /* renamed from: d  reason: collision with root package name */
    private long f181d;

    /* renamed from: e  reason: collision with root package name */
    private int f182e;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        h = decimalFormat;
        i = new byte[256];
        decimalFormat.setMinimumIntegerDigits(3);
        int i2 = 0;
        while (true) {
            byte[] bArr = i;
            if (i2 >= bArr.length) {
                bj bjVar = new bj();
                f178a = bjVar;
                bjVar.b(f, 0, 1);
                bj bjVar2 = new bj();
                f179b = bjVar2;
                bjVar2.f180c = new byte[0];
                bj bjVar3 = new bj();
                j = bjVar3;
                bjVar3.b(g, 0, 1);
                return;
            }
            if (i2 < 65 || i2 > 90) {
                i[i2] = (byte) i2;
            } else {
                bArr[i2] = (byte) ((i2 - 65) + 97);
            }
            i2++;
        }
    }

    private bj() {
    }

    private void a(int i2, int i3) {
        if (i2 >= 7) {
            return;
        }
        int i4 = (7 - i2) * 8;
        long j2 = this.f181d & ((255 << i4) ^ (-1));
        this.f181d = j2;
        this.f181d = (i3 << i4) | j2;
    }

    private int a(int i2) {
        if (i2 == 0 && e() == 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= e()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i2 < 7) {
            return ((int) (this.f181d >>> ((7 - i2) * 8))) & 255;
        }
        int a2 = a(6);
        for (int i3 = 6; i3 < i2; i3++) {
            a2 += this.f180c[a2] + 1;
        }
        return a2;
    }

    private void b(int i2) {
        long j2 = this.f181d & (-256);
        this.f181d = j2;
        this.f181d = j2 | i2;
    }

    private int e() {
        return (int) (this.f181d & 255);
    }

    private static void b(bj bjVar, bj bjVar2) {
        if (bjVar.a(0) == 0) {
            bjVar2.f180c = bjVar.f180c;
            bjVar2.f181d = bjVar.f181d;
            return;
        }
        int a2 = bjVar.a(0);
        int length = bjVar.f180c.length - a2;
        int c2 = bjVar.c();
        byte[] bArr = new byte[length];
        bjVar2.f180c = bArr;
        System.arraycopy(bjVar.f180c, a2, bArr, 0, length);
        for (int i2 = 0; i2 < c2 && i2 < 7; i2++) {
            bjVar2.a(i2, bjVar.a(i2) - a2);
        }
        bjVar2.b(c2);
    }

    private void a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.f180c;
        int length = bArr2 == null ? 0 : bArr2.length - a(0);
        int i4 = i2;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = bArr[i4];
            if (i7 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i8 = i7 + 1;
            i4 += i8;
            i5 += i8;
        }
        int i9 = length + i5;
        if (i9 > 255) {
            throw new bk();
        }
        int e2 = e();
        int i10 = e2 + i3;
        if (i10 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr3 = new byte[i9];
        if (length != 0) {
            System.arraycopy(this.f180c, a(0), bArr3, 0, length);
        }
        System.arraycopy(bArr, i2, bArr3, length, i5);
        this.f180c = bArr3;
        for (int i11 = 0; i11 < i3; i11++) {
            a(e2 + i11, length);
            length += bArr3[length] + 1;
        }
        b(i10);
    }

    private static cy a(String str, String str2) {
        return new cy("'" + str + "': " + str2);
    }

    private void a(String str, byte[] bArr, int i2, int i3) {
        try {
            a(bArr, i2, i3);
        } catch (bk unused) {
            throw a(str, "Name too long");
        }
    }

    private void b(byte[] bArr, int i2, int i3) {
        try {
            a(bArr, i2, i3);
        } catch (bk unused) {
        }
    }

    public bj(String str, bj bjVar) {
        char c2;
        int i2;
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == 0) {
            if (str.equals("")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 46) {
            if (hashCode == 64 && str.equals("@")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals(".")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            throw a(str, "empty name");
        }
        if (c2 == 1) {
            if (bjVar == null) {
                b(f179b, this);
            } else {
                b(bjVar, this);
            }
        } else if (c2 == 2) {
            b(f178a, this);
        } else {
            byte[] bArr = new byte[64];
            int i3 = 0;
            boolean z2 = false;
            int i4 = -1;
            int i5 = 1;
            int i6 = 0;
            for (int i7 = 0; i7 < str.length(); i7++) {
                byte charAt = (byte) str.charAt(i7);
                if (z2) {
                    if (charAt >= 48 && charAt <= 57 && i3 < 3) {
                        i3++;
                        i6 = (i6 * 10) + (charAt - 48);
                        if (i6 > 255) {
                            throw a(str, "bad escape");
                        }
                        if (i3 >= 3) {
                            charAt = (byte) i6;
                        }
                    } else if (i3 > 0 && i3 < 3) {
                        throw a(str, "bad escape");
                    }
                    if (i5 > 63) {
                        throw a(str, "label too long");
                    }
                    bArr[i5] = charAt;
                    i4 = i5;
                    z2 = false;
                    i5++;
                } else if (charAt == 92) {
                    i3 = 0;
                    z2 = true;
                    i6 = 0;
                } else if (charAt != 46) {
                    i4 = i4 == -1 ? i7 : i4;
                    if (i5 > 63) {
                        throw a(str, "label too long");
                    }
                    bArr[i5] = charAt;
                    i5++;
                } else if (i4 == -1) {
                    throw a(str, "invalid empty label");
                } else {
                    bArr[0] = (byte) (i5 - 1);
                    a(str, bArr, 0, 1);
                    i4 = -1;
                    i5 = 1;
                }
            }
            if (i3 > 0 && i3 < 3) {
                throw a(str, "bad escape");
            }
            if (z2) {
                throw a(str, "bad escape");
            }
            if (i4 == -1) {
                i2 = 0;
                a(str, f, 0, 1);
                z = true;
            } else {
                i2 = 0;
                bArr[0] = (byte) (i5 - 1);
                a(str, bArr, 0, 1);
                z = false;
            }
            if (bjVar == null || z) {
                return;
            }
            a(str, bjVar.f180c, bjVar.a(i2), bjVar.e());
        }
    }

    public static bj a(String str, bj bjVar) {
        if (!str.equals("@") || bjVar == null) {
            if (str.equals(".")) {
                return f178a;
            }
            return new bj(str, bjVar);
        }
        return bjVar;
    }

    public static bj a(String str) {
        return a(str, (bj) null);
    }

    public static bj b(String str) {
        try {
            return a(str, (bj) null);
        } catch (cy unused) {
            throw new IllegalArgumentException("Invalid name '" + str + "'");
        }
    }

    public bj(t tVar) {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int g2 = tVar.g();
            int i2 = g2 & 192;
            if (i2 != 0) {
                if (i2 == 192) {
                    int g3 = tVar.g() + ((g2 & (-193)) << 8);
                    if (bo.b("verbosecompression")) {
                        PrintStream printStream = System.err;
                        printStream.println("currently " + tVar.a() + ", pointer to " + g3);
                    }
                    if (g3 >= tVar.a() - 2) {
                        throw new dg("bad compression");
                    }
                    if (!z2) {
                        tVar.e();
                        z2 = true;
                    }
                    tVar.c(g3);
                    if (bo.b("verbosecompression")) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("current name '" + this + "', seeking to " + g3);
                    }
                } else {
                    throw new dg("bad label type");
                }
            } else if (e() >= 128) {
                throw new dg("too many labels");
            } else {
                if (g2 == 0) {
                    a(f, 0, 1);
                    z = true;
                } else {
                    bArr[0] = (byte) g2;
                    tVar.a(bArr, 1, g2);
                    a(bArr, 0, 1);
                }
            }
        }
        if (z2) {
            tVar.f();
        }
    }

    public bj(bj bjVar, int i2) {
        int c2 = bjVar.c();
        if (i2 > c2) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        this.f180c = bjVar.f180c;
        int i3 = c2 - i2;
        b(i3);
        for (int i4 = 0; i4 < 7 && i4 < i3; i4++) {
            a(i4, bjVar.a(i4 + i2));
        }
    }

    public static bj a(bj bjVar, bj bjVar2) {
        if (bjVar.a()) {
            return bjVar;
        }
        bj bjVar3 = new bj();
        b(bjVar, bjVar3);
        bjVar3.a(bjVar2.f180c, bjVar2.a(0), bjVar2.e());
        return bjVar3;
    }

    public bj a(s sVar) {
        bj j2 = sVar.j();
        bj j_ = sVar.j_();
        if (a(j2)) {
            int c2 = c() - j2.c();
            int b2 = b() - j2.b();
            int a2 = a(0);
            int c3 = j_.c();
            short b3 = j_.b();
            int i2 = b2 + b3;
            if (i2 > 255) {
                throw new bk();
            }
            bj bjVar = new bj();
            int i3 = c2 + c3;
            bjVar.b(i3);
            byte[] bArr = new byte[i2];
            bjVar.f180c = bArr;
            System.arraycopy(this.f180c, a2, bArr, 0, b2);
            System.arraycopy(j_.f180c, 0, bjVar.f180c, b2, b3);
            int i4 = 0;
            for (int i5 = 0; i5 < 7 && i5 < i3; i5++) {
                bjVar.a(i5, i4);
                i4 += bjVar.f180c[i4] + 1;
            }
            return bjVar;
        }
        return null;
    }

    public boolean a() {
        int c2 = c();
        return c2 != 0 && this.f180c[a(c2 - 1)] == 0;
    }

    public short b() {
        if (e() == 0) {
            return (short) 0;
        }
        return (short) (this.f180c.length - a(0));
    }

    public int c() {
        return e();
    }

    public boolean a(bj bjVar) {
        int c2 = c();
        int c3 = bjVar.c();
        if (c3 > c2) {
            return false;
        }
        if (c3 == c2) {
            return equals(bjVar);
        }
        return bjVar.b(this.f180c, a(c2 - c3));
    }

    private String a(byte[] bArr, int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = i2 + 1;
        int i4 = bArr[i2];
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            int i6 = bArr[i5] & 255;
            if (i6 <= 32 || i6 >= 127) {
                sb.append('\\');
                sb.append(h.format(i6));
            } else if (i6 == 34 || i6 == 40 || i6 == 41 || i6 == 46 || i6 == 59 || i6 == 92 || i6 == 64 || i6 == 36) {
                sb.append('\\');
                sb.append((char) i6);
            } else {
                sb.append((char) i6);
            }
        }
        return sb.toString();
    }

    public String a(boolean z) {
        int c2 = c();
        if (c2 == 0) {
            return "@";
        }
        int i2 = 0;
        if (c2 == 1 && this.f180c[a(0)] == 0) {
            return ".";
        }
        StringBuilder sb = new StringBuilder();
        int a2 = a(0);
        while (true) {
            if (i2 >= c2) {
                break;
            }
            byte b2 = this.f180c[a2];
            if (b2 > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b2 != 0) {
                if (i2 > 0) {
                    sb.append('.');
                }
                sb.append(a(this.f180c, a2));
                a2 += b2 + 1;
                i2++;
            } else if (!z) {
                sb.append('.');
            }
        }
        return sb.toString();
    }

    public String toString() {
        return a(false);
    }

    public void a(v vVar, o oVar) {
        if (!a()) {
            throw new IllegalArgumentException("toWire() called on non-absolute name");
        }
        int c2 = c();
        int i2 = 0;
        while (i2 < c2 - 1) {
            bj bjVar = i2 == 0 ? this : new bj(this, i2);
            int a2 = oVar != null ? oVar.a(bjVar) : -1;
            if (a2 >= 0) {
                vVar.c(49152 | a2);
                return;
            }
            if (oVar != null) {
                oVar.a(vVar.a(), bjVar);
            }
            int a3 = a(i2);
            byte[] bArr = this.f180c;
            vVar.a(bArr, a3, bArr[a3] + 1);
            i2++;
        }
        vVar.b(0);
    }

    public void a(v vVar) {
        vVar.a(d());
    }

    public byte[] d() {
        int c2 = c();
        if (c2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.f180c.length - a(0)];
        int a2 = a(0);
        int i2 = 0;
        for (int i3 = 0; i3 < c2; i3++) {
            byte[] bArr2 = this.f180c;
            byte b2 = bArr2[a2];
            if (b2 > 63) {
                throw new IllegalStateException("invalid label");
            }
            bArr[i2] = bArr2[a2];
            i2++;
            a2++;
            int i4 = 0;
            while (i4 < b2) {
                bArr[i2] = i[this.f180c[a2] & 255];
                i4++;
                i2++;
                a2++;
            }
        }
        return bArr;
    }

    public void a(v vVar, o oVar, boolean z) {
        if (z) {
            a(vVar);
        } else {
            a(vVar, oVar);
        }
    }

    private boolean b(byte[] bArr, int i2) {
        int c2 = c();
        int a2 = a(0);
        int i3 = 0;
        while (i3 < c2) {
            byte[] bArr2 = this.f180c;
            if (bArr2[a2] != bArr[i2]) {
                return false;
            }
            int i4 = a2 + 1;
            byte b2 = bArr2[a2];
            i2++;
            if (b2 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i5 = 0;
            while (i5 < b2) {
                byte[] bArr3 = i;
                int i6 = i4 + 1;
                int i7 = i2 + 1;
                if (bArr3[this.f180c[i4] & 255] != bArr3[bArr[i2] & 255]) {
                    return false;
                }
                i5++;
                i2 = i7;
                i4 = i6;
            }
            i3++;
            a2 = i4;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bj) {
            bj bjVar = (bj) obj;
            if (bjVar.f182e == 0) {
                bjVar.hashCode();
            }
            if (this.f182e == 0) {
                hashCode();
            }
            if (bjVar.f182e == this.f182e && bjVar.c() == c()) {
                return b(bjVar.f180c, bjVar.a(0));
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f182e;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        int a2 = a(0);
        while (true) {
            byte[] bArr = this.f180c;
            if (a2 < bArr.length) {
                i3 += (i3 << 3) + i[bArr[a2] & 255];
                a2++;
            } else {
                this.f182e = i3;
                return i3;
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        bj bjVar = (bj) obj;
        if (this == bjVar) {
            return 0;
        }
        int c2 = c();
        int c3 = bjVar.c();
        int i2 = c2 > c3 ? c3 : c2;
        for (int i3 = 1; i3 <= i2; i3++) {
            int a2 = a(c2 - i3);
            int a3 = bjVar.a(c3 - i3);
            byte b2 = this.f180c[a2];
            byte b3 = bjVar.f180c[a3];
            for (int i4 = 0; i4 < b2 && i4 < b3; i4++) {
                byte[] bArr = i;
                int i5 = bArr[this.f180c[(i4 + a2) + 1] & 255] - bArr[bjVar.f180c[(i4 + a3) + 1] & 255];
                if (i5 != 0) {
                    return i5;
                }
            }
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return c2 - c3;
    }
}

package c;

import com.umeng.analytics.pro.bz;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: ByteString.java */
/* loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f3545a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final f f3546b = a(new byte[0]);

    /* renamed from: c  reason: collision with root package name */
    final byte[] f3547c;

    /* renamed from: d  reason: collision with root package name */
    transient int f3548d;

    /* renamed from: e  reason: collision with root package name */
    transient String f3549e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(byte[] bArr) {
        this.f3547c = bArr;
    }

    public static f a(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new f((byte[]) bArr.clone());
    }

    public static f a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(u.f3586a));
        fVar.f3549e = str;
        return fVar;
    }

    public String a() {
        String str = this.f3549e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f3547c, u.f3586a);
        this.f3549e = str2;
        return str2;
    }

    public String b() {
        return b.a(this.f3547c);
    }

    public f c() {
        return d("MD5");
    }

    public f d() {
        return d("SHA-1");
    }

    public f e() {
        return d("SHA-256");
    }

    private f d(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f3547c));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    @Nullable
    public static f b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a2 = b.a(str);
        if (a2 != null) {
            return new f(a2);
        }
        return null;
    }

    public String f() {
        byte[] bArr = this.f3547c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f3545a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & bz.m];
        }
        return new String(cArr);
    }

    public static f c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
        }
        return a(bArr);
    }

    private static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c2);
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public f g() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f3547c;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
            i++;
        }
    }

    public f a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f3547c;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f3547c.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(this.f3547c, i, bArr2, 0, i3);
        return new f(bArr2);
    }

    public byte a(int i) {
        return this.f3547c[i];
    }

    public int h() {
        return this.f3547c.length;
    }

    public byte[] i() {
        return (byte[]) this.f3547c.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        byte[] bArr = this.f3547c;
        cVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        return fVar.a(i2, this.f3547c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f3547c;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && u.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(f fVar) {
        return a(0, fVar, 0, fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int h = fVar.h();
            byte[] bArr = this.f3547c;
            if (h == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.f3548d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f3547c);
        this.f3548d = hashCode;
        return hashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(f fVar) {
        int h = h();
        int h2 = fVar.h();
        int min = Math.min(h, h2);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & 255;
            int a3 = fVar.a(i) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (h == h2) {
            return 0;
        }
        return h < h2 ? -1 : 1;
    }

    public String toString() {
        if (this.f3547c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int a3 = a(a2, 64);
        if (a3 == -1) {
            if (this.f3547c.length <= 64) {
                return "[hex=" + f() + "]";
            }
            return "[size=" + this.f3547c.length + " hex=" + a(0, 64).f() + "…]";
        }
        String replace = a2.substring(0, a3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a3 < a2.length()) {
            return "[size=" + this.f3547c.length + " text=" + replace + "…]";
        }
        return "[text=" + replace + "]";
    }

    static int a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
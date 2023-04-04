package c;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentedByteString.java */
/* loaded from: classes.dex */
public final class q extends f {
    final transient byte[][] f;
    final transient int[] g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar, int i) {
        super(null);
        u.a(cVar.f3542b, 0L, i);
        o oVar = cVar.f3541a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (oVar.f3577c == oVar.f3576b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += oVar.f3577c - oVar.f3576b;
            i4++;
            oVar = oVar.f;
        }
        this.f = new byte[i4];
        this.g = new int[i4 * 2];
        o oVar2 = cVar.f3541a;
        int i5 = 0;
        while (i2 < i) {
            this.f[i5] = oVar2.f3575a;
            i2 += oVar2.f3577c - oVar2.f3576b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.g;
            iArr[i5] = i2;
            iArr[this.f.length + i5] = oVar2.f3576b;
            oVar2.f3578d = true;
            i5++;
            oVar2 = oVar2.f;
        }
    }

    @Override // c.f
    public String a() {
        return j().a();
    }

    @Override // c.f
    public String b() {
        return j().b();
    }

    @Override // c.f
    public String f() {
        return j().f();
    }

    @Override // c.f
    public f g() {
        return j().g();
    }

    @Override // c.f
    public f c() {
        return j().c();
    }

    @Override // c.f
    public f d() {
        return j().d();
    }

    @Override // c.f
    public f e() {
        return j().e();
    }

    @Override // c.f
    public f a(int i, int i2) {
        return j().a(i, i2);
    }

    @Override // c.f
    public byte a(int i) {
        u.a(this.g[this.f.length - 1], i, 1L);
        int b2 = b(i);
        int i2 = b2 == 0 ? 0 : this.g[b2 - 1];
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        return bArr[b2][(i - i2) + iArr[bArr.length + b2]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // c.f
    public int h() {
        return this.g[this.f.length - 1];
    }

    @Override // c.f
    public byte[] i() {
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f
    public void a(c cVar) {
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            o oVar = new o(this.f[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.f3541a == null) {
                oVar.g = oVar;
                oVar.f = oVar;
                cVar.f3541a = oVar;
            } else {
                cVar.f3541a.g.a(oVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f3542b += i2;
    }

    @Override // c.f
    public boolean a(int i, f fVar, int i2, int i3) {
        if (i < 0 || i > h() - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            int i4 = b2 == 0 ? 0 : this.g[b2 - 1];
            int min = Math.min(i3, ((this.g[b2] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr = this.f;
            if (!fVar.a(i2, bArr[b2], (i - i4) + iArr[bArr.length + b2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    @Override // c.f
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > h() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            int i4 = b2 == 0 ? 0 : this.g[b2 - 1];
            int min = Math.min(i3, ((this.g[b2] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr2 = this.f;
            if (!u.a(bArr2[b2], (i - i4) + iArr[bArr2.length + b2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    private f j() {
        return new f(i());
    }

    @Override // c.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.h() == h() && a(0, fVar, 0, h())) {
                return true;
            }
        }
        return false;
    }

    @Override // c.f
    public int hashCode() {
        int i = this.f3548d;
        if (i != 0) {
            return i;
        }
        int length = this.f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f[i2];
            int[] iArr = this.g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.f3548d = i4;
        return i4;
    }

    @Override // c.f
    public String toString() {
        return j().toString();
    }
}

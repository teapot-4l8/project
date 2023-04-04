package cn.jiguang.as;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class j implements Serializable, Cloneable, Comparable {

    /* renamed from: e  reason: collision with root package name */
    private static final DecimalFormat f3902e;

    /* renamed from: a  reason: collision with root package name */
    protected h f3903a;

    /* renamed from: b  reason: collision with root package name */
    protected int f3904b;

    /* renamed from: c  reason: collision with root package name */
    protected int f3905c;

    /* renamed from: d  reason: collision with root package name */
    protected long f3906d;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f3902e = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(c cVar, int i) {
        h hVar = new h(cVar);
        int g = cVar.g();
        int g2 = cVar.g();
        if (i == 0) {
            return a(hVar, g, g2);
        }
        long h = cVar.h();
        int g3 = cVar.g();
        j a2 = a(hVar, g, g2, h);
        if (cVar != null) {
            if (cVar.b() < g3) {
                throw new IOException("truncated record");
            }
            cVar.a(g3);
            a2.a(cVar);
            if (cVar.b() > 0) {
                throw new IOException("invalid record length");
            }
            cVar.c();
        }
        return a2;
    }

    public static j a(h hVar, int i, int i2) {
        if (hVar.a()) {
            return a(hVar, i, i2, 0L);
        }
        throw new k(hVar);
    }

    private static final j a(h hVar, int i, int i2, long j) {
        o oVar = new o();
        oVar.f3903a = hVar;
        oVar.f3904b = i;
        oVar.f3905c = i2;
        oVar.f3906d = j;
        return oVar;
    }

    private byte[] h() {
        d dVar = new d();
        a(dVar, true);
        return dVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j) {
        this.f3906d = j;
    }

    abstract void a(c cVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(d dVar, a aVar) {
        this.f3903a.a(dVar, aVar);
        dVar.c(this.f3904b);
        dVar.c(this.f3905c);
    }

    abstract void a(d dVar, boolean z);

    public final boolean a(j jVar) {
        return this.f3904b == jVar.f3904b && this.f3905c == jVar.f3905c && this.f3903a.equals(jVar.f3903a);
    }

    public final h b() {
        return this.f3903a;
    }

    public final int c() {
        return this.f3904b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        j jVar = (j) obj;
        if (this == jVar) {
            return 0;
        }
        int compareTo = this.f3903a.compareTo(jVar.f3903a);
        if (compareTo != 0) {
            return compareTo;
        }
        int i = this.f3905c - jVar.f3905c;
        if (i != 0) {
            return i;
        }
        int i2 = this.f3904b - jVar.f3904b;
        if (i2 != 0) {
            return i2;
        }
        byte[] h = h();
        byte[] h2 = jVar.h();
        for (int i3 = 0; i3 < h.length && i3 < h2.length; i3++) {
            int i4 = (h[i3] & 255) - (h2[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
        }
        return h.length - h2.length;
    }

    public final int d() {
        return this.f3904b;
    }

    public final int e() {
        return this.f3905c;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof j)) {
            j jVar = (j) obj;
            if (this.f3904b == jVar.f3904b && this.f3905c == jVar.f3905c && this.f3903a.equals(jVar.f3903a)) {
                return Arrays.equals(h(), jVar.h());
            }
        }
        return false;
    }

    public final long f() {
        return this.f3906d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j g() {
        try {
            return (j) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public int hashCode() {
        d dVar = new d();
        this.f3903a.a(dVar);
        dVar.c(this.f3904b);
        dVar.c(this.f3905c);
        dVar.a(0L);
        int a2 = dVar.a();
        dVar.c(0);
        a(dVar, true);
        dVar.a((dVar.a() - a2) - 2, a2);
        int i = 0;
        for (byte b2 : dVar.b()) {
            i += (i << 3) + (b2 & 255);
        }
        return i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f3903a);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String a2 = a();
        if (!a2.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(a2);
        }
        return stringBuffer.toString();
    }
}

package a.a.a.d;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: APLRecord.java */
/* loaded from: classes.dex */
public class d extends bx {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f269a;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(int i, int i2) {
        if (i2 < 0 || i2 >= 256) {
            return false;
        }
        if (i != 1 || i2 <= 32) {
            return i != 2 || i2 <= 128;
        }
        return false;
    }

    /* compiled from: APLRecord.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f270a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f271b;

        /* renamed from: c  reason: collision with root package name */
        public final int f272c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f273d;

        private a(int i, boolean z, Object obj, int i2) {
            this.f270a = i;
            this.f271b = z;
            this.f273d = obj;
            this.f272c = i2;
            if (!d.b(i, i2)) {
                throw new IllegalArgumentException("invalid prefix length");
            }
        }

        public a(boolean z, InetAddress inetAddress, int i) {
            this(f.a(inetAddress), z, inetAddress, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f271b) {
                sb.append("!");
            }
            sb.append(this.f270a);
            sb.append(":");
            int i = this.f270a;
            if (i == 1 || i == 2) {
                sb.append(((InetAddress) this.f273d).getHostAddress());
            } else {
                sb.append(a.a.a.d.a.a.a((byte[]) this.f273d));
            }
            sb.append("/");
            sb.append(this.f272c);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f270a == aVar.f270a && this.f271b == aVar.f271b && this.f272c == aVar.f272c && this.f273d.equals(aVar.f273d);
            }
            return false;
        }

        public int hashCode() {
            return this.f273d.hashCode() + this.f272c + (this.f271b ? 1 : 0);
        }
    }

    @Override // a.a.a.d.bx
    bx a() {
        return new d();
    }

    private static byte[] a(byte[] bArr, int i) {
        if (bArr.length > i) {
            throw new dg("invalid address length");
        }
        if (bArr.length == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        a aVar;
        this.f269a = new ArrayList(1);
        while (tVar.b() != 0) {
            int h = tVar.h();
            int g = tVar.g();
            int g2 = tVar.g();
            boolean z = (g2 & 128) != 0;
            byte[] d2 = tVar.d(g2 & (-129));
            if (!b(h, g)) {
                throw new dg("invalid prefix length");
            }
            if (h == 1 || h == 2) {
                aVar = new a(z, InetAddress.getByAddress(a(d2, f.a(h))), g);
            } else {
                aVar = new a(h, z, d2, g);
            }
            this.f269a.add(aVar);
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        Iterator<a> it = this.f269a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static int b(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] != 0) {
                return length + 1;
            }
        }
        return 0;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        byte[] address;
        int b2;
        for (a aVar : this.f269a) {
            if (aVar.f270a == 1 || aVar.f270a == 2) {
                address = ((InetAddress) aVar.f273d).getAddress();
                b2 = b(address);
            } else {
                address = (byte[]) aVar.f273d;
                b2 = address.length;
            }
            int i = aVar.f271b ? b2 | 128 : b2;
            vVar.c(aVar.f270a);
            vVar.b(aVar.f272c);
            vVar.b(i);
            vVar.a(address, 0, b2);
        }
    }
}

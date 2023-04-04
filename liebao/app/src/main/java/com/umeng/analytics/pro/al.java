package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: UMEnvelope.java */
/* loaded from: classes2.dex */
public class al implements at<al, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, bf> k;
    private static final long l = 420342210744516016L;
    private static final bx m = new bx("UMEnvelope");
    private static final bn n = new bn("version", (byte) 11, 1);
    private static final bn o = new bn("address", (byte) 11, 2);
    private static final bn p = new bn("signature", (byte) 11, 3);

    /* renamed from: q  reason: collision with root package name */
    private static final bn f6371q = new bn("serial_num", (byte) 8, 4);
    private static final bn r = new bn("ts_secs", (byte) 8, 5);
    private static final bn s = new bn("length", (byte) 8, 6);
    private static final bn t = new bn("entity", (byte) 11, 7);
    private static final bn u = new bn("guid", (byte) 11, 8);
    private static final bn v = new bn("checksum", (byte) 11, 9);
    private static final bn w = new bn("codex", (byte) 8, 10);
    private static final Map<Class<? extends ca>, cb> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a  reason: collision with root package name */
    public String f6372a;

    /* renamed from: b  reason: collision with root package name */
    public String f6373b;

    /* renamed from: c  reason: collision with root package name */
    public String f6374c;

    /* renamed from: d  reason: collision with root package name */
    public int f6375d;

    /* renamed from: e  reason: collision with root package name */
    public int f6376e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    static {
        HashMap hashMap = new HashMap();
        x = hashMap;
        hashMap.put(cc.class, new b());
        x.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new bf("version", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new bf("address", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new bf("signature", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new bf("serial_num", (byte) 1, new bg((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new bf("ts_secs", (byte) 1, new bg((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new bf("length", (byte) 1, new bg((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new bf("entity", (byte) 1, new bg((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new bf("guid", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bf("checksum", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new bf("codex", (byte) 2, new bg((byte) 8)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        k = unmodifiableMap;
        bf.a(al.class, unmodifiableMap);
    }

    /* compiled from: UMEnvelope.java */
    /* loaded from: classes2.dex */
    public enum e implements ba {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        
        private static final Map<String, e> k = new HashMap();
        private final short l;
        private final String m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                k.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return k.get(str);
        }

        e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.l;
        }

        @Override // com.umeng.analytics.pro.ba
        public String b() {
            return this.m;
        }
    }

    public al() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public al(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f6372a = str;
        this.f6373b = str2;
        this.f6374c = str3;
        this.f6375d = i;
        d(true);
        this.f6376e = i2;
        e(true);
        this.f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    public al(al alVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = alVar.C;
        if (alVar.d()) {
            this.f6372a = alVar.f6372a;
        }
        if (alVar.g()) {
            this.f6373b = alVar.f6373b;
        }
        if (alVar.j()) {
            this.f6374c = alVar.f6374c;
        }
        this.f6375d = alVar.f6375d;
        this.f6376e = alVar.f6376e;
        this.f = alVar.f;
        if (alVar.w()) {
            this.g = au.d(alVar.g);
        }
        if (alVar.z()) {
            this.h = alVar.h;
        }
        if (alVar.C()) {
            this.i = alVar.i;
        }
        this.j = alVar.j;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a */
    public al deepCopy() {
        return new al(this);
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        this.f6372a = null;
        this.f6373b = null;
        this.f6374c = null;
        d(false);
        this.f6375d = 0;
        e(false);
        this.f6376e = 0;
        f(false);
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public String b() {
        return this.f6372a;
    }

    public al a(String str) {
        this.f6372a = str;
        return this;
    }

    public void c() {
        this.f6372a = null;
    }

    public boolean d() {
        return this.f6372a != null;
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.f6372a = null;
    }

    public String e() {
        return this.f6373b;
    }

    public al b(String str) {
        this.f6373b = str;
        return this;
    }

    public void f() {
        this.f6373b = null;
    }

    public boolean g() {
        return this.f6373b != null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.f6373b = null;
    }

    public String h() {
        return this.f6374c;
    }

    public al c(String str) {
        this.f6374c = str;
        return this;
    }

    public void i() {
        this.f6374c = null;
    }

    public boolean j() {
        return this.f6374c != null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f6374c = null;
    }

    public int k() {
        return this.f6375d;
    }

    public al a(int i) {
        this.f6375d = i;
        d(true);
        return this;
    }

    public void l() {
        this.C = aq.b(this.C, 0);
    }

    public boolean m() {
        return aq.a(this.C, 0);
    }

    public void d(boolean z2) {
        this.C = aq.a(this.C, 0, z2);
    }

    public int n() {
        return this.f6376e;
    }

    public al b(int i) {
        this.f6376e = i;
        e(true);
        return this;
    }

    public void o() {
        this.C = aq.b(this.C, 1);
    }

    public boolean p() {
        return aq.a(this.C, 1);
    }

    public void e(boolean z2) {
        this.C = aq.a(this.C, 1, z2);
    }

    public int q() {
        return this.f;
    }

    public al c(int i) {
        this.f = i;
        f(true);
        return this;
    }

    public void r() {
        this.C = aq.b(this.C, 2);
    }

    public boolean s() {
        return aq.a(this.C, 2);
    }

    public void f(boolean z2) {
        this.C = aq.a(this.C, 2, z2);
    }

    public byte[] t() {
        a(au.c(this.g));
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public ByteBuffer u() {
        return this.g;
    }

    public al a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public al a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    public void v() {
        this.g = null;
    }

    public boolean w() {
        return this.g != null;
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.g = null;
    }

    public String x() {
        return this.h;
    }

    public al d(String str) {
        this.h = str;
        return this;
    }

    public void y() {
        this.h = null;
    }

    public boolean z() {
        return this.h != null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.h = null;
    }

    public String A() {
        return this.i;
    }

    public al e(String str) {
        this.i = str;
        return this;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.i = null;
    }

    public int D() {
        return this.j;
    }

    public al d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    public void E() {
        this.C = aq.b(this.C, 3);
    }

    public boolean F() {
        return aq.a(this.C, 3);
    }

    public void j(boolean z2) {
        this.C = aq.a(this.C, 3, z2);
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: e */
    public e fieldForId(int i) {
        return e.a(i);
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        x.get(bsVar.D()).b().b(bsVar, this);
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        x.get(bsVar.D()).b().a(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f6372a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f6373b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f6374c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f6375d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f6376e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            au.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public void G() {
        if (this.f6372a == null) {
            throw new bt("Required field 'version' was not present! Struct: " + toString());
        } else if (this.f6373b == null) {
            throw new bt("Required field 'address' was not present! Struct: " + toString());
        } else if (this.f6374c == null) {
            throw new bt("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new bt("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.h == null) {
            throw new bt("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.i != null) {
        } else {
            throw new bt("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new bm(new ce(objectOutputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.C = (byte) 0;
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: UMEnvelope.java */
    /* loaded from: classes2.dex */
    private static class b implements cb {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMEnvelope.java */
    /* loaded from: classes2.dex */
    public static class a extends cc<al> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a */
        public void b(bs bsVar, al alVar) {
            bsVar.j();
            while (true) {
                bn l = bsVar.l();
                if (l.f6457b != 0) {
                    switch (l.f6458c) {
                        case 1:
                            if (l.f6457b == 11) {
                                alVar.f6372a = bsVar.z();
                                alVar.a(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        case 2:
                            if (l.f6457b == 11) {
                                alVar.f6373b = bsVar.z();
                                alVar.b(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        case 3:
                            if (l.f6457b == 11) {
                                alVar.f6374c = bsVar.z();
                                alVar.c(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        case 4:
                            if (l.f6457b == 8) {
                                alVar.f6375d = bsVar.w();
                                alVar.d(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        case 5:
                            if (l.f6457b == 8) {
                                alVar.f6376e = bsVar.w();
                                alVar.e(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        case 6:
                            if (l.f6457b == 8) {
                                alVar.f = bsVar.w();
                                alVar.f(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        case 7:
                            if (l.f6457b == 11) {
                                alVar.g = bsVar.A();
                                alVar.g(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        case 8:
                            if (l.f6457b == 11) {
                                alVar.h = bsVar.z();
                                alVar.h(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        case 9:
                            if (l.f6457b == 11) {
                                alVar.i = bsVar.z();
                                alVar.i(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        case 10:
                            if (l.f6457b == 8) {
                                alVar.j = bsVar.w();
                                alVar.j(true);
                                break;
                            } else {
                                bv.a(bsVar, l.f6457b);
                                break;
                            }
                        default:
                            bv.a(bsVar, l.f6457b);
                            break;
                    }
                    bsVar.m();
                } else {
                    bsVar.k();
                    if (!alVar.m()) {
                        throw new bt("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    } else if (!alVar.p()) {
                        throw new bt("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    } else if (!alVar.s()) {
                        throw new bt("Required field 'length' was not found in serialized data! Struct: " + toString());
                    } else {
                        alVar.G();
                        return;
                    }
                }
            }
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b */
        public void a(bs bsVar, al alVar) {
            alVar.G();
            bsVar.a(al.m);
            if (alVar.f6372a != null) {
                bsVar.a(al.n);
                bsVar.a(alVar.f6372a);
                bsVar.c();
            }
            if (alVar.f6373b != null) {
                bsVar.a(al.o);
                bsVar.a(alVar.f6373b);
                bsVar.c();
            }
            if (alVar.f6374c != null) {
                bsVar.a(al.p);
                bsVar.a(alVar.f6374c);
                bsVar.c();
            }
            bsVar.a(al.f6371q);
            bsVar.a(alVar.f6375d);
            bsVar.c();
            bsVar.a(al.r);
            bsVar.a(alVar.f6376e);
            bsVar.c();
            bsVar.a(al.s);
            bsVar.a(alVar.f);
            bsVar.c();
            if (alVar.g != null) {
                bsVar.a(al.t);
                bsVar.a(alVar.g);
                bsVar.c();
            }
            if (alVar.h != null) {
                bsVar.a(al.u);
                bsVar.a(alVar.h);
                bsVar.c();
            }
            if (alVar.i != null) {
                bsVar.a(al.v);
                bsVar.a(alVar.i);
                bsVar.c();
            }
            if (alVar.F()) {
                bsVar.a(al.w);
                bsVar.a(alVar.j);
                bsVar.c();
            }
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: UMEnvelope.java */
    /* loaded from: classes2.dex */
    private static class d implements cb {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMEnvelope.java */
    /* loaded from: classes2.dex */
    public static class c extends cd<al> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, al alVar) {
            by byVar = (by) bsVar;
            byVar.a(alVar.f6372a);
            byVar.a(alVar.f6373b);
            byVar.a(alVar.f6374c);
            byVar.a(alVar.f6375d);
            byVar.a(alVar.f6376e);
            byVar.a(alVar.f);
            byVar.a(alVar.g);
            byVar.a(alVar.h);
            byVar.a(alVar.i);
            BitSet bitSet = new BitSet();
            if (alVar.F()) {
                bitSet.set(0);
            }
            byVar.a(bitSet, 1);
            if (alVar.F()) {
                byVar.a(alVar.j);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, al alVar) {
            by byVar = (by) bsVar;
            alVar.f6372a = byVar.z();
            alVar.a(true);
            alVar.f6373b = byVar.z();
            alVar.b(true);
            alVar.f6374c = byVar.z();
            alVar.c(true);
            alVar.f6375d = byVar.w();
            alVar.d(true);
            alVar.f6376e = byVar.w();
            alVar.e(true);
            alVar.f = byVar.w();
            alVar.f(true);
            alVar.g = byVar.A();
            alVar.g(true);
            alVar.h = byVar.z();
            alVar.h(true);
            alVar.i = byVar.z();
            alVar.i(true);
            if (byVar.b(1).get(0)) {
                alVar.j = byVar.w();
                alVar.j(true);
            }
        }
    }
}

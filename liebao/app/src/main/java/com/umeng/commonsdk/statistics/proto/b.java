package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bg;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bs;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IdSnapshot.java */
/* loaded from: classes2.dex */
public class b implements at<b, e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<e, bf> f6908d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f6909e = -6496538196005191531L;
    private static final bx f = new bx("IdSnapshot");
    private static final bn g = new bn("identity", (byte) 11, 1);
    private static final bn h = new bn("ts", (byte) 10, 2);
    private static final bn i = new bn("version", (byte) 8, 3);
    private static final Map<Class<? extends ca>, cb> j;
    private static final int k = 0;
    private static final int l = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f6910a;

    /* renamed from: b  reason: collision with root package name */
    public long f6911b;

    /* renamed from: c  reason: collision with root package name */
    public int f6912c;
    private byte m;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cc.class, new C0172b());
        j.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new bf("identity", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bf("ts", (byte) 1, new bg((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new bf("version", (byte) 1, new bg((byte) 8)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f6908d = unmodifiableMap;
        bf.a(b.class, unmodifiableMap);
    }

    /* compiled from: IdSnapshot.java */
    /* loaded from: classes2.dex */
    public enum e implements ba {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f6916d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final short f6917e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f6916d.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return VERSION;
                }
                return TS;
            }
            return IDENTITY;
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return f6916d.get(str);
        }

        e(short s, String str) {
            this.f6917e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.f6917e;
        }

        @Override // com.umeng.analytics.pro.ba
        public String b() {
            return this.f;
        }
    }

    public b() {
        this.m = (byte) 0;
    }

    public b(String str, long j2, int i2) {
        this();
        this.f6910a = str;
        this.f6911b = j2;
        b(true);
        this.f6912c = i2;
        c(true);
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.f6910a = bVar.f6910a;
        }
        this.f6911b = bVar.f6911b;
        this.f6912c = bVar.f6912c;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        this.f6910a = null;
        b(false);
        this.f6911b = 0L;
        c(false);
        this.f6912c = 0;
    }

    public String b() {
        return this.f6910a;
    }

    public b a(String str) {
        this.f6910a = str;
        return this;
    }

    public void c() {
        this.f6910a = null;
    }

    public boolean d() {
        return this.f6910a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f6910a = null;
    }

    public long e() {
        return this.f6911b;
    }

    public b a(long j2) {
        this.f6911b = j2;
        b(true);
        return this;
    }

    public void f() {
        this.m = aq.b(this.m, 0);
    }

    public boolean g() {
        return aq.a(this.m, 0);
    }

    public void b(boolean z) {
        this.m = aq.a(this.m, 0, z);
    }

    public int h() {
        return this.f6912c;
    }

    public b a(int i2) {
        this.f6912c = i2;
        c(true);
        return this;
    }

    public void i() {
        this.m = aq.b(this.m, 1);
    }

    public boolean j() {
        return aq.a(this.m, 1);
    }

    public void c(boolean z) {
        this.m = aq.a(this.m, 1, z);
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        j.get(bsVar.D()).b().b(bsVar, this);
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        j.get(bsVar.D()).b().a(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f6910a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f6911b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f6912c);
        sb.append(")");
        return sb.toString();
    }

    public void k() {
        if (this.f6910a != null) {
            return;
        }
        throw new bt("Required field 'identity' was not present! Struct: " + toString());
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
            this.m = (byte) 0;
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0172b implements cb {
        private C0172b() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdSnapshot.java */
    /* loaded from: classes2.dex */
    public static class a extends cc<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a */
        public void b(bs bsVar, b bVar) {
            bsVar.j();
            while (true) {
                bn l = bsVar.l();
                if (l.f6457b == 0) {
                    break;
                }
                short s = l.f6458c;
                if (s != 1) {
                    if (s != 2) {
                        if (s == 3) {
                            if (l.f6457b == 8) {
                                bVar.f6912c = bsVar.w();
                                bVar.c(true);
                            } else {
                                bv.a(bsVar, l.f6457b);
                            }
                        } else {
                            bv.a(bsVar, l.f6457b);
                        }
                    } else if (l.f6457b == 10) {
                        bVar.f6911b = bsVar.x();
                        bVar.b(true);
                    } else {
                        bv.a(bsVar, l.f6457b);
                    }
                } else if (l.f6457b == 11) {
                    bVar.f6910a = bsVar.z();
                    bVar.a(true);
                } else {
                    bv.a(bsVar, l.f6457b);
                }
                bsVar.m();
            }
            bsVar.k();
            if (!bVar.g()) {
                throw new bt("Required field 'ts' was not found in serialized data! Struct: " + toString());
            } else if (!bVar.j()) {
                throw new bt("Required field 'version' was not found in serialized data! Struct: " + toString());
            } else {
                bVar.k();
            }
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b */
        public void a(bs bsVar, b bVar) {
            bVar.k();
            bsVar.a(b.f);
            if (bVar.f6910a != null) {
                bsVar.a(b.g);
                bsVar.a(bVar.f6910a);
                bsVar.c();
            }
            bsVar.a(b.h);
            bsVar.a(bVar.f6911b);
            bsVar.c();
            bsVar.a(b.i);
            bsVar.a(bVar.f6912c);
            bsVar.c();
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: IdSnapshot.java */
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
    /* compiled from: IdSnapshot.java */
    /* loaded from: classes2.dex */
    public static class c extends cd<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, b bVar) {
            by byVar = (by) bsVar;
            byVar.a(bVar.f6910a);
            byVar.a(bVar.f6911b);
            byVar.a(bVar.f6912c);
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, b bVar) {
            by byVar = (by) bsVar;
            bVar.f6910a = byVar.z();
            bVar.a(true);
            bVar.f6911b = byVar.x();
            bVar.b(true);
            bVar.f6912c = byVar.w();
            bVar.c(true);
        }
    }
}

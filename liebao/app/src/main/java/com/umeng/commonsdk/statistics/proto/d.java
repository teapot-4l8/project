package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bg;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bs;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.bz;
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

/* compiled from: Imprint.java */
/* loaded from: classes2.dex */
public class d implements at<d, e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<e, bf> f6928d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f6929e = 2846460275012375038L;
    private static final bx f = new bx("Imprint");
    private static final bn g = new bn("property", bz.k, 1);
    private static final bn h = new bn("version", (byte) 8, 2);
    private static final bn i = new bn("checksum", (byte) 11, 3);
    private static final Map<Class<? extends ca>, cb> j;
    private static final int k = 0;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f6930a;

    /* renamed from: b  reason: collision with root package name */
    public int f6931b;

    /* renamed from: c  reason: collision with root package name */
    public String f6932c;
    private byte l;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cc.class, new b());
        j.put(cd.class, new C0174d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new bf("property", (byte) 1, new bi(bz.k, new bg((byte) 11), new bk((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new bf("version", (byte) 1, new bg((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bf("checksum", (byte) 1, new bg((byte) 11)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f6928d = unmodifiableMap;
        bf.a(d.class, unmodifiableMap);
    }

    /* compiled from: Imprint.java */
    /* loaded from: classes2.dex */
    public enum e implements ba {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f6936d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final short f6937e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f6936d.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return CHECKSUM;
                }
                return VERSION;
            }
            return PROPERTY;
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return f6936d.get(str);
        }

        e(short s, String str) {
            this.f6937e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.f6937e;
        }

        @Override // com.umeng.analytics.pro.ba
        public String b() {
            return this.f;
        }
    }

    public d() {
        this.l = (byte) 0;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.f6930a = map;
        this.f6931b = i2;
        b(true);
        this.f6932c = str;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f6930a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f6930a = hashMap;
        }
        this.f6931b = dVar.f6931b;
        if (dVar.k()) {
            this.f6932c = dVar.f6932c;
        }
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a */
    public d deepCopy() {
        return new d(this);
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        this.f6930a = null;
        b(false);
        this.f6931b = 0;
        this.f6932c = null;
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f6930a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f6930a == null) {
            this.f6930a = new HashMap();
        }
        this.f6930a.put(str, eVar);
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f6930a;
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f6930a = map;
        return this;
    }

    public void d() {
        this.f6930a = null;
    }

    public boolean e() {
        return this.f6930a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f6930a = null;
    }

    public int f() {
        return this.f6931b;
    }

    public d a(int i2) {
        this.f6931b = i2;
        b(true);
        return this;
    }

    public void g() {
        this.l = aq.b(this.l, 0);
    }

    public boolean h() {
        return aq.a(this.l, 0);
    }

    public void b(boolean z) {
        this.l = aq.a(this.l, 0, z);
    }

    public String i() {
        return this.f6932c;
    }

    public d a(String str) {
        this.f6932c = str;
        return this;
    }

    public void j() {
        this.f6932c = null;
    }

    public boolean k() {
        return this.f6932c != null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f6932c = null;
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
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f6930a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f6931b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f6932c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    public void l() {
        if (this.f6930a == null) {
            throw new bt("Required field 'property' was not present! Struct: " + toString());
        } else if (this.f6932c != null) {
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
            this.l = (byte) 0;
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: Imprint.java */
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
    /* compiled from: Imprint.java */
    /* loaded from: classes2.dex */
    public static class a extends cc<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a */
        public void b(bs bsVar, d dVar) {
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
                            if (l.f6457b == 11) {
                                dVar.f6932c = bsVar.z();
                                dVar.c(true);
                            } else {
                                bv.a(bsVar, l.f6457b);
                            }
                        } else {
                            bv.a(bsVar, l.f6457b);
                        }
                    } else if (l.f6457b == 8) {
                        dVar.f6931b = bsVar.w();
                        dVar.b(true);
                    } else {
                        bv.a(bsVar, l.f6457b);
                    }
                } else if (l.f6457b == 13) {
                    bp n = bsVar.n();
                    dVar.f6930a = new HashMap(n.f6463c * 2);
                    for (int i = 0; i < n.f6463c; i++) {
                        String z = bsVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(bsVar);
                        dVar.f6930a.put(z, eVar);
                    }
                    bsVar.o();
                    dVar.a(true);
                } else {
                    bv.a(bsVar, l.f6457b);
                }
                bsVar.m();
            }
            bsVar.k();
            if (!dVar.h()) {
                throw new bt("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            dVar.l();
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b */
        public void a(bs bsVar, d dVar) {
            dVar.l();
            bsVar.a(d.f);
            if (dVar.f6930a != null) {
                bsVar.a(d.g);
                bsVar.a(new bp((byte) 11, (byte) 12, dVar.f6930a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f6930a.entrySet()) {
                    bsVar.a(entry.getKey());
                    entry.getValue().write(bsVar);
                }
                bsVar.e();
                bsVar.c();
            }
            bsVar.a(d.h);
            bsVar.a(dVar.f6931b);
            bsVar.c();
            if (dVar.f6932c != null) {
                bsVar.a(d.i);
                bsVar.a(dVar.f6932c);
                bsVar.c();
            }
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0174d implements cb {
        private C0174d() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Imprint.java */
    /* loaded from: classes2.dex */
    public static class c extends cd<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, d dVar) {
            by byVar = (by) bsVar;
            byVar.a(dVar.f6930a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f6930a.entrySet()) {
                byVar.a(entry.getKey());
                entry.getValue().write(byVar);
            }
            byVar.a(dVar.f6931b);
            byVar.a(dVar.f6932c);
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, d dVar) {
            by byVar = (by) bsVar;
            bp bpVar = new bp((byte) 11, (byte) 12, byVar.w());
            dVar.f6930a = new HashMap(bpVar.f6463c * 2);
            for (int i = 0; i < bpVar.f6463c; i++) {
                String z = byVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(byVar);
                dVar.f6930a.put(z, eVar);
            }
            dVar.a(true);
            dVar.f6931b = byVar.w();
            dVar.b(true);
            dVar.f6932c = byVar.z();
            dVar.c(true);
        }
    }
}

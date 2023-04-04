package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bg;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bo;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: IdTracking.java */
/* loaded from: classes2.dex */
public class c implements at<c, e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<e, bf> f6918d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f6919e = -5764118265293965743L;
    private static final bx f = new bx("IdTracking");
    private static final bn g = new bn("snapshots", bz.k, 1);
    private static final bn h = new bn("journals", bz.m, 2);
    private static final bn i = new bn("checksum", (byte) 11, 3);
    private static final Map<Class<? extends ca>, cb> j;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f6920a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.umeng.commonsdk.statistics.proto.a> f6921b;

    /* renamed from: c  reason: collision with root package name */
    public String f6922c;
    private e[] k;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cc.class, new b());
        j.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new bf("snapshots", (byte) 1, new bi(bz.k, new bg((byte) 11), new bk((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new bf("journals", (byte) 2, new bh(bz.m, new bk((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bf("checksum", (byte) 2, new bg((byte) 11)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f6918d = unmodifiableMap;
        bf.a(c.class, unmodifiableMap);
    }

    /* compiled from: IdTracking.java */
    /* loaded from: classes2.dex */
    public enum e implements ba {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f6926d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final short f6927e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f6926d.put(eVar.b(), eVar);
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
                return JOURNALS;
            }
            return SNAPSHOTS;
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return f6926d.get(str);
        }

        e(short s, String str) {
            this.f6927e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.f6927e;
        }

        @Override // com.umeng.analytics.pro.ba
        public String b() {
            return this.f;
        }
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f6920a = map;
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f6920a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f6920a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.f6921b) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(aVar));
            }
            this.f6921b = arrayList;
        }
        if (cVar.m()) {
            this.f6922c = cVar.f6922c;
        }
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a */
    public c deepCopy() {
        return new c(this);
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        this.f6920a = null;
        this.f6921b = null;
        this.f6922c = null;
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f6920a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f6920a == null) {
            this.f6920a = new HashMap();
        }
        this.f6920a.put(str, bVar);
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f6920a;
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f6920a = map;
        return this;
    }

    public void d() {
        this.f6920a = null;
    }

    public boolean e() {
        return this.f6920a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f6920a = null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f6921b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f6921b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f6921b == null) {
            this.f6921b = new ArrayList();
        }
        this.f6921b.add(aVar);
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f6921b;
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f6921b = list;
        return this;
    }

    public void i() {
        this.f6921b = null;
    }

    public boolean j() {
        return this.f6921b != null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f6921b = null;
    }

    public String k() {
        return this.f6922c;
    }

    public c a(String str) {
        this.f6922c = str;
        return this;
    }

    public void l() {
        this.f6922c = null;
    }

    public boolean m() {
        return this.f6922c != null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f6922c = null;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a */
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
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f6920a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f6921b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f6922c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void n() {
        if (this.f6920a != null) {
            return;
        }
        throw new bt("Required field 'snapshots' was not present! Struct: " + toString());
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
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: IdTracking.java */
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
    /* compiled from: IdTracking.java */
    /* loaded from: classes2.dex */
    public static class a extends cc<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a */
        public void b(bs bsVar, c cVar) {
            bsVar.j();
            while (true) {
                bn l = bsVar.l();
                if (l.f6457b != 0) {
                    short s = l.f6458c;
                    int i = 0;
                    if (s != 1) {
                        if (s != 2) {
                            if (s == 3) {
                                if (l.f6457b == 11) {
                                    cVar.f6922c = bsVar.z();
                                    cVar.c(true);
                                } else {
                                    bv.a(bsVar, l.f6457b);
                                }
                            } else {
                                bv.a(bsVar, l.f6457b);
                            }
                        } else if (l.f6457b == 15) {
                            bo p = bsVar.p();
                            cVar.f6921b = new ArrayList(p.f6460b);
                            while (i < p.f6460b) {
                                com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                                aVar.read(bsVar);
                                cVar.f6921b.add(aVar);
                                i++;
                            }
                            bsVar.q();
                            cVar.b(true);
                        } else {
                            bv.a(bsVar, l.f6457b);
                        }
                    } else if (l.f6457b == 13) {
                        bp n = bsVar.n();
                        cVar.f6920a = new HashMap(n.f6463c * 2);
                        while (i < n.f6463c) {
                            String z = bsVar.z();
                            com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                            bVar.read(bsVar);
                            cVar.f6920a.put(z, bVar);
                            i++;
                        }
                        bsVar.o();
                        cVar.a(true);
                    } else {
                        bv.a(bsVar, l.f6457b);
                    }
                    bsVar.m();
                } else {
                    bsVar.k();
                    cVar.n();
                    return;
                }
            }
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b */
        public void a(bs bsVar, c cVar) {
            cVar.n();
            bsVar.a(c.f);
            if (cVar.f6920a != null) {
                bsVar.a(c.g);
                bsVar.a(new bp((byte) 11, (byte) 12, cVar.f6920a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f6920a.entrySet()) {
                    bsVar.a(entry.getKey());
                    entry.getValue().write(bsVar);
                }
                bsVar.e();
                bsVar.c();
            }
            if (cVar.f6921b != null && cVar.j()) {
                bsVar.a(c.h);
                bsVar.a(new bo((byte) 12, cVar.f6921b.size()));
                for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.f6921b) {
                    aVar.write(bsVar);
                }
                bsVar.f();
                bsVar.c();
            }
            if (cVar.f6922c != null && cVar.m()) {
                bsVar.a(c.i);
                bsVar.a(cVar.f6922c);
                bsVar.c();
            }
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: IdTracking.java */
    /* loaded from: classes2.dex */
    private static class d implements cb {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a */
        public C0173c b() {
            return new C0173c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0173c extends cd<c> {
        private C0173c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, c cVar) {
            by byVar = (by) bsVar;
            byVar.a(cVar.f6920a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f6920a.entrySet()) {
                byVar.a(entry.getKey());
                entry.getValue().write(byVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            byVar.a(bitSet, 2);
            if (cVar.j()) {
                byVar.a(cVar.f6921b.size());
                for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.f6921b) {
                    aVar.write(byVar);
                }
            }
            if (cVar.m()) {
                byVar.a(cVar.f6922c);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, c cVar) {
            by byVar = (by) bsVar;
            bp bpVar = new bp((byte) 11, (byte) 12, byVar.w());
            cVar.f6920a = new HashMap(bpVar.f6463c * 2);
            for (int i = 0; i < bpVar.f6463c; i++) {
                String z = byVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(byVar);
                cVar.f6920a.put(z, bVar);
            }
            cVar.a(true);
            BitSet b2 = byVar.b(2);
            if (b2.get(0)) {
                bo boVar = new bo((byte) 12, byVar.w());
                cVar.f6921b = new ArrayList(boVar.f6460b);
                for (int i2 = 0; i2 < boVar.f6460b; i2++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(byVar);
                    cVar.f6921b.add(aVar);
                }
                cVar.b(true);
            }
            if (b2.get(1)) {
                cVar.f6922c = byVar.z();
                cVar.c(true);
            }
        }
    }
}

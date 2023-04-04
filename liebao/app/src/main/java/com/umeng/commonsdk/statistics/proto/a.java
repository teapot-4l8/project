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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IdJournal.java */
/* loaded from: classes2.dex */
public class a implements at<a, e>, Serializable, Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final Map<e, bf> f6898e;
    private static final long f = 9132678615281394583L;
    private static final bx g = new bx("IdJournal");
    private static final bn h = new bn("domain", (byte) 11, 1);
    private static final bn i = new bn("old_id", (byte) 11, 2);
    private static final bn j = new bn("new_id", (byte) 11, 3);
    private static final bn k = new bn("ts", (byte) 10, 4);
    private static final Map<Class<? extends ca>, cb> l;
    private static final int m = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f6899a;

    /* renamed from: b  reason: collision with root package name */
    public String f6900b;

    /* renamed from: c  reason: collision with root package name */
    public String f6901c;

    /* renamed from: d  reason: collision with root package name */
    public long f6902d;
    private byte n;
    private e[] o;

    static {
        HashMap hashMap = new HashMap();
        l = hashMap;
        hashMap.put(cc.class, new b());
        l.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new bf("domain", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new bf("old_id", (byte) 2, new bg((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new bf("new_id", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bf("ts", (byte) 1, new bg((byte) 10)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f6898e = unmodifiableMap;
        bf.a(a.class, unmodifiableMap);
    }

    /* compiled from: IdJournal.java */
    /* loaded from: classes2.dex */
    public enum e implements ba {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        

        /* renamed from: e  reason: collision with root package name */
        private static final Map<String, e> f6907e = new HashMap();
        private final short f;
        private final String g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f6907e.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return TS;
                    }
                    return NEW_ID;
                }
                return OLD_ID;
            }
            return DOMAIN;
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return f6907e.get(str);
        }

        e(short s, String str) {
            this.f = s;
            this.g = str;
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.f;
        }

        @Override // com.umeng.analytics.pro.ba
        public String b() {
            return this.g;
        }
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    public a(String str, String str2, long j2) {
        this();
        this.f6899a = str;
        this.f6901c = str2;
        this.f6902d = j2;
        d(true);
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f6899a = aVar.f6899a;
        }
        if (aVar.g()) {
            this.f6900b = aVar.f6900b;
        }
        if (aVar.j()) {
            this.f6901c = aVar.f6901c;
        }
        this.f6902d = aVar.f6902d;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a */
    public a deepCopy() {
        return new a(this);
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        this.f6899a = null;
        this.f6900b = null;
        this.f6901c = null;
        d(false);
        this.f6902d = 0L;
    }

    public String b() {
        return this.f6899a;
    }

    public a a(String str) {
        this.f6899a = str;
        return this;
    }

    public void c() {
        this.f6899a = null;
    }

    public boolean d() {
        return this.f6899a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f6899a = null;
    }

    public String e() {
        return this.f6900b;
    }

    public a b(String str) {
        this.f6900b = str;
        return this;
    }

    public void f() {
        this.f6900b = null;
    }

    public boolean g() {
        return this.f6900b != null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f6900b = null;
    }

    public String h() {
        return this.f6901c;
    }

    public a c(String str) {
        this.f6901c = str;
        return this;
    }

    public void i() {
        this.f6901c = null;
    }

    public boolean j() {
        return this.f6901c != null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f6901c = null;
    }

    public long k() {
        return this.f6902d;
    }

    public a a(long j2) {
        this.f6902d = j2;
        d(true);
        return this;
    }

    public void l() {
        this.n = aq.b(this.n, 0);
    }

    public boolean m() {
        return aq.a(this.n, 0);
    }

    public void d(boolean z) {
        this.n = aq.a(this.n, 0, z);
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        l.get(bsVar.D()).b().b(bsVar, this);
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        l.get(bsVar.D()).b().a(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f6899a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f6900b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f6901c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f6902d);
        sb.append(")");
        return sb.toString();
    }

    public void n() {
        if (this.f6899a == null) {
            throw new bt("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.f6901c != null) {
        } else {
            throw new bt("Required field 'new_id' was not present! Struct: " + toString());
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
            this.n = (byte) 0;
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: IdJournal.java */
    /* loaded from: classes2.dex */
    private static class b implements cb {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a */
        public C0171a b() {
            return new C0171a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0171a extends cc<a> {
        private C0171a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a */
        public void b(bs bsVar, a aVar) {
            bsVar.j();
            while (true) {
                bn l = bsVar.l();
                if (l.f6457b == 0) {
                    break;
                }
                short s = l.f6458c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s == 4) {
                                if (l.f6457b == 10) {
                                    aVar.f6902d = bsVar.x();
                                    aVar.d(true);
                                } else {
                                    bv.a(bsVar, l.f6457b);
                                }
                            } else {
                                bv.a(bsVar, l.f6457b);
                            }
                        } else if (l.f6457b == 11) {
                            aVar.f6901c = bsVar.z();
                            aVar.c(true);
                        } else {
                            bv.a(bsVar, l.f6457b);
                        }
                    } else if (l.f6457b == 11) {
                        aVar.f6900b = bsVar.z();
                        aVar.b(true);
                    } else {
                        bv.a(bsVar, l.f6457b);
                    }
                } else if (l.f6457b == 11) {
                    aVar.f6899a = bsVar.z();
                    aVar.a(true);
                } else {
                    bv.a(bsVar, l.f6457b);
                }
                bsVar.m();
            }
            bsVar.k();
            if (!aVar.m()) {
                throw new bt("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            aVar.n();
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b */
        public void a(bs bsVar, a aVar) {
            aVar.n();
            bsVar.a(a.g);
            if (aVar.f6899a != null) {
                bsVar.a(a.h);
                bsVar.a(aVar.f6899a);
                bsVar.c();
            }
            if (aVar.f6900b != null && aVar.g()) {
                bsVar.a(a.i);
                bsVar.a(aVar.f6900b);
                bsVar.c();
            }
            if (aVar.f6901c != null) {
                bsVar.a(a.j);
                bsVar.a(aVar.f6901c);
                bsVar.c();
            }
            bsVar.a(a.k);
            bsVar.a(aVar.f6902d);
            bsVar.c();
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: IdJournal.java */
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
    /* compiled from: IdJournal.java */
    /* loaded from: classes2.dex */
    public static class c extends cd<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, a aVar) {
            by byVar = (by) bsVar;
            byVar.a(aVar.f6899a);
            byVar.a(aVar.f6901c);
            byVar.a(aVar.f6902d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            byVar.a(bitSet, 1);
            if (aVar.g()) {
                byVar.a(aVar.f6900b);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, a aVar) {
            by byVar = (by) bsVar;
            aVar.f6899a = byVar.z();
            aVar.a(true);
            aVar.f6901c = byVar.z();
            aVar.c(true);
            aVar.f6902d = byVar.x();
            aVar.d(true);
            if (byVar.b(1).get(0)) {
                aVar.f6900b = byVar.z();
                aVar.b(true);
            }
        }
    }
}

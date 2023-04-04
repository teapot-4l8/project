package com.umeng.commonsdk.statistics.proto;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
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

/* compiled from: ImprintValue.java */
/* loaded from: classes2.dex */
public class e implements at<e, EnumC0175e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<EnumC0175e, bf> f6938d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f6939e = 7501688097813630241L;
    private static final bx f = new bx("ImprintValue");
    private static final bn g = new bn(AppMeasurementSdk.ConditionalUserProperty.VALUE, (byte) 11, 1);
    private static final bn h = new bn("ts", (byte) 10, 2);
    private static final bn i = new bn("guid", (byte) 11, 3);
    private static final Map<Class<? extends ca>, cb> j;
    private static final int k = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f6940a;

    /* renamed from: b  reason: collision with root package name */
    public long f6941b;

    /* renamed from: c  reason: collision with root package name */
    public String f6942c;
    private byte l;
    private EnumC0175e[] m;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cc.class, new b());
        j.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0175e.class);
        enumMap.put((EnumMap) EnumC0175e.VALUE, (EnumC0175e) new bf(AppMeasurementSdk.ConditionalUserProperty.VALUE, (byte) 2, new bg((byte) 11)));
        enumMap.put((EnumMap) EnumC0175e.TS, (EnumC0175e) new bf("ts", (byte) 1, new bg((byte) 10)));
        enumMap.put((EnumMap) EnumC0175e.GUID, (EnumC0175e) new bf("guid", (byte) 1, new bg((byte) 11)));
        Map<EnumC0175e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f6938d = unmodifiableMap;
        bf.a(e.class, unmodifiableMap);
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0175e implements ba {
        VALUE(1, AppMeasurementSdk.ConditionalUserProperty.VALUE),
        TS(2, "ts"),
        GUID(3, "guid");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, EnumC0175e> f6946d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final short f6947e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(EnumC0175e.class).iterator();
            while (it.hasNext()) {
                EnumC0175e enumC0175e = (EnumC0175e) it.next();
                f6946d.put(enumC0175e.b(), enumC0175e);
            }
        }

        public static EnumC0175e a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return GUID;
                }
                return TS;
            }
            return VALUE;
        }

        public static EnumC0175e b(int i) {
            EnumC0175e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static EnumC0175e a(String str) {
            return f6946d.get(str);
        }

        EnumC0175e(short s, String str) {
            this.f6947e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.f6947e;
        }

        @Override // com.umeng.analytics.pro.ba
        public String b() {
            return this.f;
        }
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0175e[]{EnumC0175e.VALUE};
    }

    public e(long j2, String str) {
        this();
        this.f6941b = j2;
        b(true);
        this.f6942c = str;
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0175e[]{EnumC0175e.VALUE};
        this.l = eVar.l;
        if (eVar.d()) {
            this.f6940a = eVar.f6940a;
        }
        this.f6941b = eVar.f6941b;
        if (eVar.j()) {
            this.f6942c = eVar.f6942c;
        }
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        this.f6940a = null;
        b(false);
        this.f6941b = 0L;
        this.f6942c = null;
    }

    public String b() {
        return this.f6940a;
    }

    public e a(String str) {
        this.f6940a = str;
        return this;
    }

    public void c() {
        this.f6940a = null;
    }

    public boolean d() {
        return this.f6940a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f6940a = null;
    }

    public long e() {
        return this.f6941b;
    }

    public e a(long j2) {
        this.f6941b = j2;
        b(true);
        return this;
    }

    public void f() {
        this.l = aq.b(this.l, 0);
    }

    public boolean g() {
        return aq.a(this.l, 0);
    }

    public void b(boolean z) {
        this.l = aq.a(this.l, 0, z);
    }

    public String h() {
        return this.f6942c;
    }

    public e b(String str) {
        this.f6942c = str;
        return this;
    }

    public void i() {
        this.f6942c = null;
    }

    public boolean j() {
        return this.f6942c != null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f6942c = null;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a */
    public EnumC0175e fieldForId(int i2) {
        return EnumC0175e.a(i2);
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
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f6940a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f6941b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f6942c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    public void k() {
        if (this.f6942c != null) {
            return;
        }
        throw new bt("Required field 'guid' was not present! Struct: " + toString());
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

    /* compiled from: ImprintValue.java */
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
    /* compiled from: ImprintValue.java */
    /* loaded from: classes2.dex */
    public static class a extends cc<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a */
        public void b(bs bsVar, e eVar) {
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
                                eVar.f6942c = bsVar.z();
                                eVar.c(true);
                            } else {
                                bv.a(bsVar, l.f6457b);
                            }
                        } else {
                            bv.a(bsVar, l.f6457b);
                        }
                    } else if (l.f6457b == 10) {
                        eVar.f6941b = bsVar.x();
                        eVar.b(true);
                    } else {
                        bv.a(bsVar, l.f6457b);
                    }
                } else if (l.f6457b == 11) {
                    eVar.f6940a = bsVar.z();
                    eVar.a(true);
                } else {
                    bv.a(bsVar, l.f6457b);
                }
                bsVar.m();
            }
            bsVar.k();
            if (!eVar.g()) {
                throw new bt("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            eVar.k();
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b */
        public void a(bs bsVar, e eVar) {
            eVar.k();
            bsVar.a(e.f);
            if (eVar.f6940a != null && eVar.d()) {
                bsVar.a(e.g);
                bsVar.a(eVar.f6940a);
                bsVar.c();
            }
            bsVar.a(e.h);
            bsVar.a(eVar.f6941b);
            bsVar.c();
            if (eVar.f6942c != null) {
                bsVar.a(e.i);
                bsVar.a(eVar.f6942c);
                bsVar.c();
            }
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: ImprintValue.java */
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
    /* compiled from: ImprintValue.java */
    /* loaded from: classes2.dex */
    public static class c extends cd<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, e eVar) {
            by byVar = (by) bsVar;
            byVar.a(eVar.f6941b);
            byVar.a(eVar.f6942c);
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            byVar.a(bitSet, 1);
            if (eVar.d()) {
                byVar.a(eVar.f6940a);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, e eVar) {
            by byVar = (by) bsVar;
            eVar.f6941b = byVar.x();
            eVar.b(true);
            eVar.f6942c = byVar.z();
            eVar.c(true);
            if (byVar.b(1).get(0)) {
                eVar.f6940a = byVar.z();
                eVar.a(true);
            }
        }
    }
}

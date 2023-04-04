package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bd;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: TUnion.java */
/* loaded from: classes2.dex */
public abstract class bd<T extends bd<?, ?>, F extends ba> implements at<T, F> {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends ca>, cb> f6419c;

    /* renamed from: a  reason: collision with root package name */
    protected Object f6420a;

    /* renamed from: b  reason: collision with root package name */
    protected F f6421b;

    protected abstract F a(short s);

    protected abstract Object a(bs bsVar, bn bnVar);

    protected abstract Object a(bs bsVar, short s);

    protected abstract void a(bs bsVar);

    protected abstract void b(F f, Object obj);

    protected abstract void b(bs bsVar);

    protected abstract bn c(F f);

    protected abstract bx d();

    protected bd() {
        this.f6421b = null;
        this.f6420a = null;
    }

    static {
        HashMap hashMap = new HashMap();
        f6419c = hashMap;
        hashMap.put(cc.class, new b());
        f6419c.put(cd.class, new d());
    }

    protected bd(F f, Object obj) {
        a((bd<T, F>) f, obj);
    }

    protected bd(bd<T, F> bdVar) {
        if (!bdVar.getClass().equals(getClass())) {
            throw new ClassCastException();
        }
        this.f6421b = bdVar.f6421b;
        this.f6420a = a(bdVar.f6420a);
    }

    private static Object a(Object obj) {
        if (obj instanceof at) {
            return ((at) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return au.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            hashSet.add(a(obj));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            arrayList.add(a(obj));
        }
        return arrayList;
    }

    public F a() {
        return this.f6421b;
    }

    public Object b() {
        return this.f6420a;
    }

    public Object a(F f) {
        if (f != this.f6421b) {
            throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.f6421b);
        }
        return b();
    }

    public Object a(int i) {
        return a((bd<T, F>) a((short) i));
    }

    public boolean c() {
        return this.f6421b != null;
    }

    public boolean b(F f) {
        return this.f6421b == f;
    }

    public boolean b(int i) {
        return b((bd<T, F>) a((short) i));
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        f6419c.get(bsVar.D()).b().b(bsVar, this);
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.f6421b = f;
        this.f6420a = obj;
    }

    public void a(int i, Object obj) {
        a((bd<T, F>) a((short) i), obj);
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        f6419c.get(bsVar.D()).b().a(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b2 = b();
            sb.append(c(a()).f6456a);
            sb.append(":");
            if (b2 instanceof ByteBuffer) {
                au.a((ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.at
    public final void clear() {
        this.f6421b = null;
        this.f6420a = null;
    }

    /* compiled from: TUnion.java */
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
    /* compiled from: TUnion.java */
    /* loaded from: classes2.dex */
    public static class a extends cc<bd> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a */
        public void b(bs bsVar, bd bdVar) {
            bdVar.f6421b = null;
            bdVar.f6420a = null;
            bsVar.j();
            bn l = bsVar.l();
            bdVar.f6420a = bdVar.a(bsVar, l);
            if (bdVar.f6420a != null) {
                bdVar.f6421b = (F) bdVar.a(l.f6458c);
            }
            bsVar.m();
            bsVar.l();
            bsVar.k();
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b */
        public void a(bs bsVar, bd bdVar) {
            if (bdVar.a() == null || bdVar.b() == null) {
                throw new bt("Cannot write a TUnion with no set value!");
            }
            bsVar.a(bdVar.d());
            bsVar.a(bdVar.c(bdVar.f6421b));
            bdVar.a(bsVar);
            bsVar.c();
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: TUnion.java */
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
    /* compiled from: TUnion.java */
    /* loaded from: classes2.dex */
    public static class c extends cd<bd> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a */
        public void b(bs bsVar, bd bdVar) {
            bdVar.f6421b = null;
            bdVar.f6420a = null;
            short v = bsVar.v();
            bdVar.f6420a = bdVar.a(bsVar, v);
            if (bdVar.f6420a != null) {
                bdVar.f6421b = (F) bdVar.a(v);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b */
        public void a(bs bsVar, bd bdVar) {
            if (bdVar.a() == null || bdVar.b() == null) {
                throw new bt("Cannot write a TUnion with no set value!");
            }
            bsVar.a(bdVar.f6421b.a());
            bdVar.b(bsVar);
        }
    }
}

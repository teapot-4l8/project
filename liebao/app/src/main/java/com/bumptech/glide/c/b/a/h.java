package com.bumptech.glide.c.b.a;

import com.bumptech.glide.c.b.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f4687a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f4688b = new HashMap();

    public void a(K k, V v) {
        a<K, V> aVar = this.f4688b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f4688b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public V a(K k) {
        a<K, V> aVar = this.f4688b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f4688b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public V a() {
        for (a aVar = this.f4687a.f4691c; !aVar.equals(this.f4687a); aVar = aVar.f4691c) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            d(aVar);
            this.f4688b.remove(aVar.f4689a);
            ((m) aVar.f4689a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f4687a.f4690b; !aVar.equals(this.f4687a); aVar = aVar.f4690b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f4689a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        aVar.f4691c = this.f4687a;
        aVar.f4690b = this.f4687a.f4690b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.f4691c = this.f4687a.f4691c;
        aVar.f4690b = this.f4687a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.f4690b.f4691c = aVar;
        aVar.f4691c.f4690b = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f4691c.f4690b = aVar.f4690b;
        aVar.f4690b.f4691c = aVar.f4691c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f4689a;

        /* renamed from: b  reason: collision with root package name */
        a<K, V> f4690b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f4691c;

        /* renamed from: d  reason: collision with root package name */
        private List<V> f4692d;

        a() {
            this(null);
        }

        a(K k) {
            this.f4691c = this;
            this.f4690b = this;
            this.f4689a = k;
        }

        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f4692d.remove(b2 - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.f4692d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void a(V v) {
            if (this.f4692d == null) {
                this.f4692d = new ArrayList();
            }
            this.f4692d.add(v);
        }
    }
}

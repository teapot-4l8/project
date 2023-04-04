package androidx.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f492a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f493b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f494c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f495d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a_(c<K, V> cVar);
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.f492a;
        while (cVar != null && !cVar.f496a.equals(k)) {
            cVar = cVar.f498c;
        }
        return cVar;
    }

    public V a(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f497b;
        }
        b(k, v);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> b(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f495d++;
        c<K, V> cVar2 = this.f493b;
        if (cVar2 == null) {
            this.f492a = cVar;
            this.f493b = cVar;
            return cVar;
        }
        cVar2.f498c = cVar;
        cVar.f499d = this.f493b;
        this.f493b = cVar;
        return cVar;
    }

    public V b(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f495d--;
        if (!this.f494c.isEmpty()) {
            for (f<K, V> fVar : this.f494c.keySet()) {
                fVar.a_(a2);
            }
        }
        if (a2.f499d != null) {
            a2.f499d.f498c = a2.f498c;
        } else {
            this.f492a = a2.f498c;
        }
        if (a2.f498c != null) {
            a2.f498c.f499d = a2.f499d;
        } else {
            this.f493b = a2.f499d;
        }
        a2.f498c = null;
        a2.f499d = null;
        return a2.f497b;
    }

    public int a() {
        return this.f495d;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f492a, this.f493b);
        this.f494c.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0017b c0017b = new C0017b(this.f493b, this.f492a);
        this.f494c.put(c0017b, false);
        return c0017b;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f494c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f492a;
    }

    public Map.Entry<K, V> e() {
        return this.f493b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (a() != bVar.a()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f503a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f504b;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f503a = cVar2;
            this.f504b = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f504b != null;
        }

        @Override // androidx.a.a.b.b.f
        public void a_(c<K, V> cVar) {
            if (this.f503a == cVar && cVar == this.f504b) {
                this.f504b = null;
                this.f503a = null;
            }
            c<K, V> cVar2 = this.f503a;
            if (cVar2 == cVar) {
                this.f503a = b(cVar2);
            }
            if (this.f504b == cVar) {
                this.f504b = b();
            }
        }

        private c<K, V> b() {
            c<K, V> cVar = this.f504b;
            c<K, V> cVar2 = this.f503a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return a(cVar);
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f504b;
            this.f504b = b();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.f498c;
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f499d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: androidx.a.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0017b<K, V> extends e<K, V> {
        C0017b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.f499d;
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f498c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private c<K, V> f501b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f502c = true;

        d() {
        }

        @Override // androidx.a.a.b.b.f
        public void a_(c<K, V> cVar) {
            c<K, V> cVar2 = this.f501b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f499d;
                this.f501b = cVar3;
                this.f502c = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f502c) {
                return b.this.f492a != null;
            }
            c<K, V> cVar = this.f501b;
            return (cVar == null || cVar.f498c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (this.f502c) {
                this.f502c = false;
                this.f501b = b.this.f492a;
            } else {
                c<K, V> cVar = this.f501b;
                this.f501b = cVar != null ? cVar.f498c : null;
            }
            return this.f501b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f496a;

        /* renamed from: b  reason: collision with root package name */
        final V f497b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f498c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f499d;

        c(K k, V v) {
            this.f496a = k;
            this.f497b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f496a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f497b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f496a + "=" + this.f497b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f496a.equals(cVar.f496a) && this.f497b.equals(cVar.f497b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f496a.hashCode() ^ this.f497b.hashCode();
        }
    }
}

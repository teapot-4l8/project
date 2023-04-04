package com.bumptech.glide.c.b.a;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool.java */
/* loaded from: classes.dex */
public final class j implements com.bumptech.glide.c.b.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final h<a, Object> f4693a;

    /* renamed from: b  reason: collision with root package name */
    private final b f4694b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f4695c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.c.b.a.a<?>> f4696d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4697e;
    private int f;

    public j() {
        this.f4693a = new h<>();
        this.f4694b = new b();
        this.f4695c = new HashMap();
        this.f4696d = new HashMap();
        this.f4697e = 4194304;
    }

    public j(int i) {
        this.f4693a = new h<>();
        this.f4694b = new b();
        this.f4695c = new HashMap();
        this.f4696d = new HashMap();
        this.f4697e = i;
    }

    @Override // com.bumptech.glide.c.b.a.b
    public synchronized <T> void a(T t) {
        Class<?> cls = t.getClass();
        com.bumptech.glide.c.b.a.a<T> b2 = b((Class) cls);
        int a2 = b2.a((com.bumptech.glide.c.b.a.a<T>) t);
        int b3 = b2.b() * a2;
        if (b(b3)) {
            a a3 = this.f4694b.a(a2, cls);
            this.f4693a.a(a3, t);
            NavigableMap<Integer, Integer> a4 = a(cls);
            Integer num = (Integer) a4.get(Integer.valueOf(a3.f4698a));
            Integer valueOf = Integer.valueOf(a3.f4698a);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            a4.put(valueOf, Integer.valueOf(i));
            this.f += b3;
            c();
        }
    }

    @Override // com.bumptech.glide.c.b.a.b
    public synchronized <T> T b(int i, Class<T> cls) {
        return (T) a(this.f4694b.a(i, cls), cls);
    }

    @Override // com.bumptech.glide.c.b.a.b
    public synchronized <T> T a(int i, Class<T> cls) {
        a a2;
        Integer ceilingKey = a((Class<?>) cls).ceilingKey(Integer.valueOf(i));
        if (a(i, ceilingKey)) {
            a2 = this.f4694b.a(ceilingKey.intValue(), cls);
        } else {
            a2 = this.f4694b.a(i, cls);
        }
        return (T) a(a2, cls);
    }

    private <T> T a(a aVar, Class<T> cls) {
        com.bumptech.glide.c.b.a.a<T> b2 = b((Class) cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.f -= b2.a((com.bumptech.glide.c.b.a.a<T>) t) * b2.b();
            c(b2.a((com.bumptech.glide.c.b.a.a<T>) t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(b2.a(), 2)) {
                Log.v(b2.a(), "Allocated " + aVar.f4698a + " bytes");
            }
            return b2.a(aVar.f4698a);
        }
        return t;
    }

    private <T> T a(a aVar) {
        return (T) this.f4693a.a((h<a, Object>) aVar);
    }

    private boolean b(int i) {
        return i <= this.f4697e / 2;
    }

    private boolean a(int i, Integer num) {
        return num != null && (b() || num.intValue() <= i * 8);
    }

    private boolean b() {
        int i = this.f;
        return i == 0 || this.f4697e / i >= 2;
    }

    @Override // com.bumptech.glide.c.b.a.b
    public synchronized void a() {
        c(0);
    }

    @Override // com.bumptech.glide.c.b.a.b
    public synchronized void a(int i) {
        try {
            if (i >= 40) {
                a();
            } else if (i >= 20 || i == 15) {
                c(this.f4697e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c() {
        c(this.f4697e);
    }

    private void c(int i) {
        while (this.f > i) {
            Object a2 = this.f4693a.a();
            com.bumptech.glide.i.i.a(a2);
            com.bumptech.glide.c.b.a.a b2 = b((j) a2);
            this.f -= b2.a((com.bumptech.glide.c.b.a.a) a2) * b2.b();
            c(b2.a((com.bumptech.glide.c.b.a.a) a2), a2.getClass());
            if (Log.isLoggable(b2.a(), 2)) {
                Log.v(b2.a(), "evicted: " + b2.a((com.bumptech.glide.c.b.a.a) a2));
            }
        }
    }

    private void c(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> a2 = a(cls);
        Integer num = (Integer) a2.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            a2.remove(Integer.valueOf(i));
        } else {
            a2.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f4695c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f4695c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private <T> com.bumptech.glide.c.b.a.a<T> b(T t) {
        return b((Class) t.getClass());
    }

    private <T> com.bumptech.glide.c.b.a.a<T> b(Class<T> cls) {
        i iVar = (com.bumptech.glide.c.b.a.a<T>) this.f4696d.get(cls);
        if (iVar == null) {
            if (cls.equals(int[].class)) {
                iVar = new i();
            } else if (cls.equals(byte[].class)) {
                iVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f4696d.put(cls, iVar);
        }
        return iVar;
    }

    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    private static final class b extends d<a> {
        b() {
        }

        a a(int i, Class<?> cls) {
            a c2 = c();
            c2.a(i, cls);
            return c2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.c.b.a.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f4698a;

        /* renamed from: b  reason: collision with root package name */
        private final b f4699b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f4700c;

        a(b bVar) {
            this.f4699b = bVar;
        }

        void a(int i, Class<?> cls) {
            this.f4698a = i;
            this.f4700c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f4698a == aVar.f4698a && this.f4700c == aVar.f4700c;
            }
            return false;
        }

        public String toString() {
            return "Key{size=" + this.f4698a + "array=" + this.f4700c + '}';
        }

        @Override // com.bumptech.glide.c.b.a.m
        public void a() {
            this.f4699b.a(this);
        }

        public int hashCode() {
            int i = this.f4698a * 31;
            Class<?> cls = this.f4700c;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }
}

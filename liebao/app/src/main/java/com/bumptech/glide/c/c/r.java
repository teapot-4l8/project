package com.bumptech.glide.c.c;

import androidx.core.g.e;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final c f4957a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final n<Object, Object> f4958b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final List<b<?, ?>> f4959c;

    /* renamed from: d  reason: collision with root package name */
    private final c f4960d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<b<?, ?>> f4961e;
    private final e.a<List<Throwable>> f;

    public r(e.a<List<Throwable>> aVar) {
        this(aVar, f4957a);
    }

    r(e.a<List<Throwable>> aVar, c cVar) {
        this.f4959c = new ArrayList();
        this.f4961e = new HashSet();
        this.f = aVar;
        this.f4960d = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f4959c;
        list.add(z ? list.size() : 0, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model> List<n<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f4959c) {
                if (!this.f4961e.contains(bVar) && bVar.a(cls)) {
                    this.f4961e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f4961e.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f4961e.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f4959c) {
            if (!arrayList.contains(bVar.f4962a) && bVar.a(cls)) {
                arrayList.add(bVar.f4962a);
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> n<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f4959c) {
                if (this.f4961e.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.f4961e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f4961e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f4960d.a(arrayList, this.f);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return a();
            } else {
                throw new h.c(cls, cls2);
            }
        } catch (Throwable th) {
            this.f4961e.clear();
            throw th;
        }
    }

    private <Model, Data> n<Model, Data> a(b<?, ?> bVar) {
        return (n) com.bumptech.glide.i.i.a(bVar.f4963b.a(this));
    }

    private static <Model, Data> n<Model, Data> a() {
        return (n<Model, Data>) f4958b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        final Class<Data> f4962a;

        /* renamed from: b  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f4963b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<Model> f4964c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f4964c = cls;
            this.f4962a = cls2;
            this.f4963b = oVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f4962a.isAssignableFrom(cls2);
        }

        public boolean a(Class<?> cls) {
            return this.f4964c.isAssignableFrom(cls);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    static class c {
        c() {
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, e.a<List<Throwable>> aVar) {
            return new q<>(list, aVar);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    private static class a implements n<Object, Object> {
        @Override // com.bumptech.glide.c.c.n
        public n.a<Object> a(Object obj, int i, int i2, com.bumptech.glide.c.j jVar) {
            return null;
        }

        @Override // com.bumptech.glide.c.c.n
        public boolean a(Object obj) {
            return false;
        }

        a() {
        }
    }
}

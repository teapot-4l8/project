package com.bumptech.glide.c.c;

import androidx.core.g.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f4946a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4947b;

    public p(e.a<List<Throwable>> aVar) {
        this(new r(aVar));
    }

    private p(r rVar) {
        this.f4947b = new a();
        this.f4946a = rVar;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f4946a.a(cls, cls2, oVar);
        this.f4947b.a();
    }

    public <A> List<n<A, ?>> a(A a2) {
        List<n<A, ?>> b2 = b((Class) b(a2));
        int size = b2.size();
        List<n<A, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            n<A, ?> nVar = b2.get(i);
            if (nVar.a(a2)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(nVar);
            }
        }
        return emptyList;
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.f4946a.b(cls);
    }

    private synchronized <A> List<n<A, ?>> b(Class<A> cls) {
        List<n<A, ?>> a2;
        a2 = this.f4947b.a(cls);
        if (a2 == null) {
            a2 = Collections.unmodifiableList(this.f4946a.a(cls));
            this.f4947b.a(cls, a2);
        }
        return a2;
    }

    private static <A> Class<A> b(A a2) {
        return (Class<A>) a2.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModelLoaderRegistry.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C0092a<?>> f4948a = new HashMap();

        a() {
        }

        public void a() {
            this.f4948a.clear();
        }

        public <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f4948a.put(cls, new C0092a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }

        public <Model> List<n<Model, ?>> a(Class<Model> cls) {
            C0092a<?> c0092a = this.f4948a.get(cls);
            if (c0092a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0092a.f4949a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: com.bumptech.glide.c.c.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0092a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f4949a;

            public C0092a(List<n<Model, ?>> list) {
                this.f4949a = list;
            }
        }
    }
}

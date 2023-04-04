package com.bumptech.glide;

import androidx.core.g.e;
import com.bumptech.glide.c.a.e;
import com.bumptech.glide.c.b.s;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.p;
import com.bumptech.glide.c.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Registry.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final p f5218a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.f.a f5219b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.f.e f5220c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.f.f f5221d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.c.a.f f5222e;
    private final com.bumptech.glide.c.d.f.f f;
    private final com.bumptech.glide.f.b g;
    private final com.bumptech.glide.f.d h = new com.bumptech.glide.f.d();
    private final com.bumptech.glide.f.c i = new com.bumptech.glide.f.c();
    private final e.a<List<Throwable>> j;

    public h() {
        e.a<List<Throwable>> a2 = com.bumptech.glide.i.a.a.a();
        this.j = a2;
        this.f5218a = new p(a2);
        this.f5219b = new com.bumptech.glide.f.a();
        this.f5220c = new com.bumptech.glide.f.e();
        this.f5221d = new com.bumptech.glide.f.f();
        this.f5222e = new com.bumptech.glide.c.a.f();
        this.f = new com.bumptech.glide.c.d.f.f();
        this.g = new com.bumptech.glide.f.b();
        a(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    public <Data> h a(Class<Data> cls, com.bumptech.glide.c.d<Data> dVar) {
        this.f5219b.a(cls, dVar);
        return this;
    }

    public <Data, TResource> h a(Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.c.k<Data, TResource> kVar) {
        a("legacy_append", cls, cls2, kVar);
        return this;
    }

    public <Data, TResource> h a(String str, Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.c.k<Data, TResource> kVar) {
        this.f5220c.a(str, kVar, cls, cls2);
        return this;
    }

    public final h a(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f5220c.a(arrayList);
        return this;
    }

    public <TResource> h a(Class<TResource> cls, l<TResource> lVar) {
        this.f5221d.a(cls, lVar);
        return this;
    }

    public h a(e.a<?> aVar) {
        this.f5222e.a(aVar);
        return this;
    }

    public <TResource, Transcode> h a(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.c.d.f.e<TResource, Transcode> eVar) {
        this.f.a(cls, cls2, eVar);
        return this;
    }

    public h a(com.bumptech.glide.c.f fVar) {
        this.g.a(fVar);
        return this;
    }

    public <Model, Data> h a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f5218a.a(cls, cls2, oVar);
        return this;
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> a2 = this.i.a(cls, cls2, cls3);
        if (this.i.a(a2)) {
            return null;
        }
        if (a2 == null) {
            List<com.bumptech.glide.c.b.h<Data, TResource, Transcode>> c2 = c(cls, cls2, cls3);
            a2 = c2.isEmpty() ? null : new s<>(cls, cls2, cls3, c2, this.j);
            this.i.a(cls, cls2, cls3, a2);
        }
        return a2;
    }

    private <Data, TResource, Transcode> List<com.bumptech.glide.c.b.h<Data, TResource, Transcode>> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f5220c.b(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.c.b.h(cls, cls4, cls5, this.f5220c.a(cls, cls4), this.f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.h.a(cls, cls2);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class<?> cls4 : this.f5218a.a((Class<?>) cls)) {
                for (Class<?> cls5 : this.f5220c.b(cls4, cls2)) {
                    if (!this.f.b(cls5, cls3).isEmpty() && !a2.contains(cls5)) {
                        a2.add(cls5);
                    }
                }
            }
            this.h.a(cls, cls2, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public boolean a(u<?> uVar) {
        return this.f5221d.a(uVar.c()) != null;
    }

    public <X> l<X> b(u<X> uVar) {
        l<X> a2 = this.f5221d.a(uVar.c());
        if (a2 != null) {
            return a2;
        }
        throw new d(uVar.c());
    }

    public <X> com.bumptech.glide.c.d<X> a(X x) {
        com.bumptech.glide.c.d<X> a2 = this.f5219b.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new e(x.getClass());
    }

    public <X> com.bumptech.glide.c.a.e<X> b(X x) {
        return this.f5222e.a((com.bumptech.glide.c.a.f) x);
    }

    public <Model> List<n<Model, ?>> c(Model model) {
        List<n<Model, ?>> a2 = this.f5218a.a((p) model);
        if (a2.isEmpty()) {
            throw new c(model);
        }
        return a2;
    }

    public List<com.bumptech.glide.c.f> a() {
        List<com.bumptech.glide.c.f> a2 = this.g.a();
        if (a2.isEmpty()) {
            throw new b();
        }
        return a2;
    }

    /* compiled from: Registry.java */
    /* loaded from: classes.dex */
    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* compiled from: Registry.java */
    /* loaded from: classes.dex */
    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* compiled from: Registry.java */
    /* loaded from: classes.dex */
    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    /* compiled from: Registry.java */
    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* compiled from: Registry.java */
    /* loaded from: classes.dex */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }
}

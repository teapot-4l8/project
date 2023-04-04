package com.bumptech.glide.c.c;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.c.n;

/* compiled from: UnitModelLoader.java */
/* loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f4973a = new v<>();

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Model model) {
        return true;
    }

    public static <T> v<T> a() {
        return (v<T>) f4973a;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Model> a(Model model, int i, int i2, com.bumptech.glide.c.j jVar) {
        return new n.a<>(new com.bumptech.glide.h.b(model), new b(model));
    }

    /* compiled from: UnitModelLoader.java */
    /* loaded from: classes.dex */
    private static class b<Model> implements com.bumptech.glide.c.a.d<Model> {

        /* renamed from: a  reason: collision with root package name */
        private final Model f4975a;

        @Override // com.bumptech.glide.c.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.c.a.d
        public void c() {
        }

        b(Model model) {
            this.f4975a = model;
        }

        @Override // com.bumptech.glide.c.a.d
        public void a(com.bumptech.glide.g gVar, d.a<? super Model> aVar) {
            aVar.a((d.a<? super Model>) ((Model) this.f4975a));
        }

        @Override // com.bumptech.glide.c.a.d
        public Class<Model> a() {
            return (Class<Model>) this.f4975a.getClass();
        }

        @Override // com.bumptech.glide.c.a.d
        public com.bumptech.glide.c.a d() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    /* compiled from: UnitModelLoader.java */
    /* loaded from: classes.dex */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f4974a = new a<>();

        public static <T> a<T> a() {
            return (a<T>) f4974a;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Model, Model> a(r rVar) {
            return v.a();
        }
    }
}

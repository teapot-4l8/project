package com.bumptech.glide.c.c;

import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader.java */
/* loaded from: classes.dex */
public interface n<Model, Data> {
    a<Data> a(Model model, int i, int i2, com.bumptech.glide.c.j jVar);

    boolean a(Model model);

    /* compiled from: ModelLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final com.bumptech.glide.c.h f4943a;

        /* renamed from: b  reason: collision with root package name */
        public final List<com.bumptech.glide.c.h> f4944b;

        /* renamed from: c  reason: collision with root package name */
        public final com.bumptech.glide.c.a.d<Data> f4945c;

        public a(com.bumptech.glide.c.h hVar, com.bumptech.glide.c.a.d<Data> dVar) {
            this(hVar, Collections.emptyList(), dVar);
        }

        public a(com.bumptech.glide.c.h hVar, List<com.bumptech.glide.c.h> list, com.bumptech.glide.c.a.d<Data> dVar) {
            this.f4943a = (com.bumptech.glide.c.h) com.bumptech.glide.i.i.a(hVar);
            this.f4944b = (List) com.bumptech.glide.i.i.a(list);
            this.f4945c = (com.bumptech.glide.c.a.d) com.bumptech.glide.i.i.a(dVar);
        }
    }
}

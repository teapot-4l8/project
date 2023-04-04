package com.bumptech.glide.f;

import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0095a<?>> f5155a = new ArrayList();

    public synchronized <T> com.bumptech.glide.c.d<T> a(Class<T> cls) {
        for (C0095a<?> c0095a : this.f5155a) {
            if (c0095a.a(cls)) {
                return (com.bumptech.glide.c.d<T>) c0095a.f5156a;
            }
        }
        return null;
    }

    public synchronized <T> void a(Class<T> cls, com.bumptech.glide.c.d<T> dVar) {
        this.f5155a.add(new C0095a<>(cls, dVar));
    }

    /* compiled from: EncoderRegistry.java */
    /* renamed from: com.bumptech.glide.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0095a<T> {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.c.d<T> f5156a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f5157b;

        C0095a(Class<T> cls, com.bumptech.glide.c.d<T> dVar) {
            this.f5157b = cls;
            this.f5156a = dVar;
        }

        boolean a(Class<?> cls) {
            return this.f5157b.isAssignableFrom(cls);
        }
    }
}

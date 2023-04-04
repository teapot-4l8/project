package com.bumptech.glide.c.d.f;

import java.util.ArrayList;
import java.util.List;

/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f5091a = new ArrayList();

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f5091a.add(new a<>(cls, cls2, eVar));
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a<?, ?> aVar : this.f5091a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f5092a;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.f5091a) {
            if (aVar.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    /* compiled from: TranscoderRegistry.java */
    /* loaded from: classes.dex */
    private static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        final e<Z, R> f5092a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<Z> f5093b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<R> f5094c;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f5093b = cls;
            this.f5094c = cls2;
            this.f5092a = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f5093b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f5094c);
        }
    }
}

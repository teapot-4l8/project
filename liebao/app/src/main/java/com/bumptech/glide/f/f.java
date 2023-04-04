package com.bumptech.glide.f;

import com.bumptech.glide.c.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f5169a = new ArrayList();

    public synchronized <Z> void a(Class<Z> cls, l<Z> lVar) {
        this.f5169a.add(new a<>(cls, lVar));
    }

    public synchronized <Z> l<Z> a(Class<Z> cls) {
        int size = this.f5169a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.f5169a.get(i);
            if (aVar.a(cls)) {
                return (l<Z>) aVar.f5170a;
            }
        }
        return null;
    }

    /* compiled from: ResourceEncoderRegistry.java */
    /* loaded from: classes.dex */
    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final l<T> f5170a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f5171b;

        a(Class<T> cls, l<T> lVar) {
            this.f5171b = cls;
            this.f5170a = lVar;
        }

        boolean a(Class<?> cls) {
            return this.f5171b.isAssignableFrom(cls);
        }
    }
}

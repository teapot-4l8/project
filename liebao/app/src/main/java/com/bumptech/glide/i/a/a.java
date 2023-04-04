package com.bumptech.glide.i.a;

import android.util.Log;
import androidx.core.g.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final d<Object> f5234a = new d<Object>() { // from class: com.bumptech.glide.i.a.a.1
        @Override // com.bumptech.glide.i.a.a.d
        public void a(Object obj) {
        }
    };

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0099a<T> {
        T b();
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface c {
        com.bumptech.glide.i.a.c d_();
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t);
    }

    public static <T extends c> e.a<T> a(int i, InterfaceC0099a<T> interfaceC0099a) {
        return a(new e.b(i), interfaceC0099a);
    }

    public static <T extends c> e.a<T> b(int i, InterfaceC0099a<T> interfaceC0099a) {
        return a(new e.c(i), interfaceC0099a);
    }

    public static <T> e.a<List<T>> a() {
        return a(20);
    }

    public static <T> e.a<List<T>> a(int i) {
        return a(new e.c(i), new InterfaceC0099a<List<T>>() { // from class: com.bumptech.glide.i.a.a.2
            @Override // com.bumptech.glide.i.a.a.InterfaceC0099a
            /* renamed from: a */
            public List<T> b() {
                return new ArrayList();
            }
        }, new d<List<T>>() { // from class: com.bumptech.glide.i.a.a.3
            @Override // com.bumptech.glide.i.a.a.d
            public void a(List<T> list) {
                list.clear();
            }
        });
    }

    private static <T extends c> e.a<T> a(e.a<T> aVar, InterfaceC0099a<T> interfaceC0099a) {
        return a(aVar, interfaceC0099a, b());
    }

    private static <T> e.a<T> a(e.a<T> aVar, InterfaceC0099a<T> interfaceC0099a, d<T> dVar) {
        return new b(aVar, interfaceC0099a, dVar);
    }

    private static <T> d<T> b() {
        return (d<T>) f5234a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public static final class b<T> implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final InterfaceC0099a<T> f5237a;

        /* renamed from: b  reason: collision with root package name */
        private final d<T> f5238b;

        /* renamed from: c  reason: collision with root package name */
        private final e.a<T> f5239c;

        b(e.a<T> aVar, InterfaceC0099a<T> interfaceC0099a, d<T> dVar) {
            this.f5239c = aVar;
            this.f5237a = interfaceC0099a;
            this.f5238b = dVar;
        }

        @Override // androidx.core.g.e.a
        public T a() {
            T a2 = this.f5239c.a();
            if (a2 == null) {
                a2 = this.f5237a.b();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + a2.getClass());
                }
            }
            if (a2 instanceof c) {
                ((c) a2).d_().a(false);
            }
            return a2;
        }

        @Override // androidx.core.g.e.a
        public boolean a(T t) {
            if (t instanceof c) {
                ((c) t).d_().a(true);
            }
            this.f5238b.a(t);
            return this.f5239c.a(t);
        }
    }
}

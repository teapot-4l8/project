package com.bumptech.glide.c.a;

import com.bumptech.glide.c.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final e.a<?> f4647b = new e.a<Object>() { // from class: com.bumptech.glide.c.a.f.1
        @Override // com.bumptech.glide.c.a.e.a
        public e<Object> a(Object obj) {
            return new a(obj);
        }

        @Override // com.bumptech.glide.c.a.e.a
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f4648a = new HashMap();

    public synchronized void a(e.a<?> aVar) {
        this.f4648a.put(aVar.a(), aVar);
    }

    public synchronized <T> e<T> a(T t) {
        e.a<?> aVar;
        com.bumptech.glide.i.i.a(t);
        aVar = this.f4648a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f4648a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f4647b;
        }
        return (e<T>) aVar.a(t);
    }

    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: classes.dex */
    private static final class a implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f4649a;

        @Override // com.bumptech.glide.c.a.e
        public void b() {
        }

        a(Object obj) {
            this.f4649a = obj;
        }

        @Override // com.bumptech.glide.c.a.e
        public Object a() {
            return this.f4649a;
        }
    }
}

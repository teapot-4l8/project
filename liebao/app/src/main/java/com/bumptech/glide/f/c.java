package com.bumptech.glide.f;

import com.bumptech.glide.c.b.h;
import com.bumptech.glide.c.b.s;
import com.bumptech.glide.c.d.f.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final s<?, ?, ?> f5159a = new s<>(Object.class, Object.class, Object.class, Collections.singletonList(new h(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* renamed from: b  reason: collision with root package name */
    private final androidx.b.a<com.bumptech.glide.i.h, s<?, ?, ?>> f5160b = new androidx.b.a<>();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<com.bumptech.glide.i.h> f5161c = new AtomicReference<>();

    public boolean a(s<?, ?, ?> sVar) {
        return f5159a.equals(sVar);
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> sVar;
        com.bumptech.glide.i.h b2 = b(cls, cls2, cls3);
        synchronized (this.f5160b) {
            sVar = (s<Data, TResource, Transcode>) this.f5160b.get(b2);
        }
        this.f5161c.set(b2);
        return sVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, s<?, ?, ?> sVar) {
        synchronized (this.f5160b) {
            androidx.b.a<com.bumptech.glide.i.h, s<?, ?, ?>> aVar = this.f5160b;
            com.bumptech.glide.i.h hVar = new com.bumptech.glide.i.h(cls, cls2, cls3);
            if (sVar == null) {
                sVar = f5159a;
            }
            aVar.put(hVar, sVar);
        }
    }

    private com.bumptech.glide.i.h b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        com.bumptech.glide.i.h andSet = this.f5161c.getAndSet(null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.i.h();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }
}

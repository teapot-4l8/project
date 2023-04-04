package com.bumptech.glide.f;

import com.bumptech.glide.i.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<h> f5162a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final androidx.b.a<h, List<Class<?>>> f5163b = new androidx.b.a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2) {
        List<Class<?>> list;
        h andSet = this.f5162a.getAndSet(null);
        if (andSet == null) {
            andSet = new h(cls, cls2);
        } else {
            andSet.a(cls, cls2);
        }
        synchronized (this.f5163b) {
            list = this.f5163b.get(andSet);
        }
        this.f5162a.set(andSet);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, List<Class<?>> list) {
        synchronized (this.f5163b) {
            this.f5163b.put(new h(cls, cls2), list);
        }
    }
}

package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.util.Map;

/* compiled from: GlideContext.java */
/* loaded from: classes.dex */
public class e extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    static final k<?, ?> f5144a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f5145b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.b f5146c;

    /* renamed from: d  reason: collision with root package name */
    private final h f5147d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.g.a.e f5148e;
    private final com.bumptech.glide.g.e f;
    private final Map<Class<?>, k<?, ?>> g;
    private final com.bumptech.glide.c.b.j h;
    private final int i;

    public e(Context context, com.bumptech.glide.c.b.a.b bVar, h hVar, com.bumptech.glide.g.a.e eVar, com.bumptech.glide.g.e eVar2, Map<Class<?>, k<?, ?>> map, com.bumptech.glide.c.b.j jVar, int i) {
        super(context.getApplicationContext());
        this.f5146c = bVar;
        this.f5147d = hVar;
        this.f5148e = eVar;
        this.f = eVar2;
        this.g = map;
        this.h = jVar;
        this.i = i;
        this.f5145b = new Handler(Looper.getMainLooper());
    }

    public com.bumptech.glide.g.e a() {
        return this.f;
    }

    public <T> k<?, T> a(Class<T> cls) {
        k<?, T> kVar = (k<?, T>) this.g.get(cls);
        if (kVar == null) {
            for (Map.Entry<Class<?>, k<?, ?>> entry : this.g.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    kVar = (k<?, T>) entry.getValue();
                }
            }
        }
        return kVar == null ? (k<?, T>) f5144a : kVar;
    }

    public <X> com.bumptech.glide.g.a.i<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f5148e.a(imageView, cls);
    }

    public com.bumptech.glide.c.b.j b() {
        return this.h;
    }

    public h c() {
        return this.f5147d;
    }

    public int d() {
        return this.i;
    }

    public com.bumptech.glide.c.b.a.b e() {
        return this.f5146c;
    }
}

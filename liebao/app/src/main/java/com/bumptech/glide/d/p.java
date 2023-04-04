package com.bumptech.glide.d;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker.java */
/* loaded from: classes.dex */
public final class p implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Set<com.bumptech.glide.g.a.h<?>> f5143a = Collections.newSetFromMap(new WeakHashMap());

    public void a(com.bumptech.glide.g.a.h<?> hVar) {
        this.f5143a.add(hVar);
    }

    public void b(com.bumptech.glide.g.a.h<?> hVar) {
        this.f5143a.remove(hVar);
    }

    @Override // com.bumptech.glide.d.i
    public void c() {
        for (com.bumptech.glide.g.a.h hVar : com.bumptech.glide.i.j.a(this.f5143a)) {
            hVar.c();
        }
    }

    @Override // com.bumptech.glide.d.i
    public void d() {
        for (com.bumptech.glide.g.a.h hVar : com.bumptech.glide.i.j.a(this.f5143a)) {
            hVar.d();
        }
    }

    @Override // com.bumptech.glide.d.i
    public void e() {
        for (com.bumptech.glide.g.a.h hVar : com.bumptech.glide.i.j.a(this.f5143a)) {
            hVar.e();
        }
    }

    public List<com.bumptech.glide.g.a.h<?>> a() {
        return com.bumptech.glide.i.j.a(this.f5143a);
    }

    public void b() {
        this.f5143a.clear();
    }
}

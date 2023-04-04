package com.bumptech.glide.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final Set<com.bumptech.glide.g.b> f5134a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<com.bumptech.glide.g.b> f5135b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f5136c;

    public void a(com.bumptech.glide.g.b bVar) {
        this.f5134a.add(bVar);
        if (!this.f5136c) {
            bVar.a();
            return;
        }
        bVar.b();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f5135b.add(bVar);
    }

    public boolean b(com.bumptech.glide.g.b bVar) {
        return a(bVar, true);
    }

    private boolean a(com.bumptech.glide.g.b bVar, boolean z) {
        boolean z2 = true;
        if (bVar == null) {
            return true;
        }
        boolean remove = this.f5134a.remove(bVar);
        if (!this.f5135b.remove(bVar) && !remove) {
            z2 = false;
        }
        if (z2) {
            bVar.b();
            if (z) {
                bVar.h();
            }
        }
        return z2;
    }

    public void a() {
        this.f5136c = true;
        for (com.bumptech.glide.g.b bVar : com.bumptech.glide.i.j.a(this.f5134a)) {
            if (bVar.c()) {
                bVar.b();
                this.f5135b.add(bVar);
            }
        }
    }

    public void b() {
        this.f5136c = false;
        for (com.bumptech.glide.g.b bVar : com.bumptech.glide.i.j.a(this.f5134a)) {
            if (!bVar.d() && !bVar.c()) {
                bVar.a();
            }
        }
        this.f5135b.clear();
    }

    public void c() {
        for (com.bumptech.glide.g.b bVar : com.bumptech.glide.i.j.a(this.f5134a)) {
            a(bVar, false);
        }
        this.f5135b.clear();
    }

    public void d() {
        for (com.bumptech.glide.g.b bVar : com.bumptech.glide.i.j.a(this.f5134a)) {
            if (!bVar.d() && !bVar.f()) {
                bVar.b();
                if (!this.f5136c) {
                    bVar.a();
                } else {
                    this.f5135b.add(bVar);
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f5134a.size() + ", isPaused=" + this.f5136c + "}";
    }
}

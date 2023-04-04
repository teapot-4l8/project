package com.bumptech.glide.c.b;

import android.util.Log;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.b.e;
import com.bumptech.glide.c.c.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SourceGenerator.java */
/* loaded from: classes.dex */
public class y implements d.a<Object>, e, e.a {

    /* renamed from: a  reason: collision with root package name */
    private final f<?> f4877a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a f4878b;

    /* renamed from: c  reason: collision with root package name */
    private int f4879c;

    /* renamed from: d  reason: collision with root package name */
    private b f4880d;

    /* renamed from: e  reason: collision with root package name */
    private Object f4881e;
    private volatile n.a<?> f;
    private c g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(f<?> fVar, e.a aVar) {
        this.f4877a = fVar;
        this.f4878b = aVar;
    }

    @Override // com.bumptech.glide.c.b.e
    public boolean a() {
        Object obj = this.f4881e;
        if (obj != null) {
            this.f4881e = null;
            b(obj);
        }
        b bVar = this.f4880d;
        if (bVar == null || !bVar.a()) {
            this.f4880d = null;
            this.f = null;
            boolean z = false;
            while (!z && d()) {
                List<n.a<?>> m = this.f4877a.m();
                int i = this.f4879c;
                this.f4879c = i + 1;
                this.f = m.get(i);
                if (this.f != null && (this.f4877a.c().a(this.f.f4945c.d()) || this.f4877a.a(this.f.f4945c.a()))) {
                    this.f.f4945c.a(this.f4877a.d(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    private boolean d() {
        return this.f4879c < this.f4877a.m().size();
    }

    private void b(Object obj) {
        long a2 = com.bumptech.glide.i.e.a();
        try {
            com.bumptech.glide.c.d<X> a3 = this.f4877a.a((f<?>) obj);
            d dVar = new d(a3, obj, this.f4877a.e());
            this.g = new c(this.f.f4943a, this.f4877a.f());
            this.f4877a.b().a(this.g, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.bumptech.glide.i.e.a(a2));
            }
            this.f.f4945c.b();
            this.f4880d = new b(Collections.singletonList(this.f.f4943a), this.f4877a, this);
        } catch (Throwable th) {
            this.f.f4945c.b();
            throw th;
        }
    }

    @Override // com.bumptech.glide.c.b.e
    public void b() {
        n.a<?> aVar = this.f;
        if (aVar != null) {
            aVar.f4945c.c();
        }
    }

    @Override // com.bumptech.glide.c.a.d.a
    public void a(Object obj) {
        i c2 = this.f4877a.c();
        if (obj != null && c2.a(this.f.f4945c.d())) {
            this.f4881e = obj;
            this.f4878b.c();
            return;
        }
        this.f4878b.a(this.f.f4943a, obj, this.f.f4945c, this.f.f4945c.d(), this.g);
    }

    @Override // com.bumptech.glide.c.a.d.a
    public void a(Exception exc) {
        this.f4878b.a(this.g, exc, this.f.f4945c, this.f.f4945c.d());
    }

    @Override // com.bumptech.glide.c.b.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.c.b.e.a
    public void a(com.bumptech.glide.c.h hVar, Object obj, com.bumptech.glide.c.a.d<?> dVar, com.bumptech.glide.c.a aVar, com.bumptech.glide.c.h hVar2) {
        this.f4878b.a(hVar, obj, dVar, this.f.f4945c.d(), hVar);
    }

    @Override // com.bumptech.glide.c.b.e.a
    public void a(com.bumptech.glide.c.h hVar, Exception exc, com.bumptech.glide.c.a.d<?> dVar, com.bumptech.glide.c.a aVar) {
        this.f4878b.a(hVar, exc, dVar, this.f.f4945c.d());
    }
}

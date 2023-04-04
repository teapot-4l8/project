package com.bumptech.glide.c.b;

import android.os.Looper;

/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
class o<Z> implements u<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4843a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4844b;

    /* renamed from: c  reason: collision with root package name */
    private a f4845c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.c.h f4846d;

    /* renamed from: e  reason: collision with root package name */
    private int f4847e;
    private boolean f;
    private final u<Z> g;

    /* compiled from: EngineResource.java */
    /* loaded from: classes.dex */
    interface a {
        void a(com.bumptech.glide.c.h hVar, o<?> oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(u<Z> uVar, boolean z, boolean z2) {
        this.g = (u) com.bumptech.glide.i.i.a(uVar);
        this.f4843a = z;
        this.f4844b = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.c.h hVar, a aVar) {
        this.f4846d = hVar;
        this.f4845c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u<Z> a() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f4843a;
    }

    @Override // com.bumptech.glide.c.b.u
    public Class<Z> c() {
        return this.g.c();
    }

    @Override // com.bumptech.glide.c.b.u
    public Z d() {
        return this.g.d();
    }

    @Override // com.bumptech.glide.c.b.u
    public int e() {
        return this.g.e();
    }

    @Override // com.bumptech.glide.c.b.u
    public void f() {
        if (this.f4847e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f = true;
        if (this.f4844b) {
            this.g.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.f4847e++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.f4847e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = this.f4847e - 1;
        this.f4847e = i;
        if (i == 0) {
            this.f4845c.a(this.f4846d, this);
        }
    }

    public String toString() {
        return "EngineResource{isCacheable=" + this.f4843a + ", listener=" + this.f4845c + ", key=" + this.f4846d + ", acquired=" + this.f4847e + ", isRecycled=" + this.f + ", resource=" + this.g + '}';
    }
}

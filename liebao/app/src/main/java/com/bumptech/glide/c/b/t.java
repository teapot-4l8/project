package com.bumptech.glide.c.b;

import androidx.core.g.e;
import com.bumptech.glide.i.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockedResource.java */
/* loaded from: classes.dex */
public final class t<Z> implements u<Z>, a.c {

    /* renamed from: a  reason: collision with root package name */
    private static final e.a<t<?>> f4861a = com.bumptech.glide.i.a.a.b(20, new a.InterfaceC0099a<t<?>>() { // from class: com.bumptech.glide.c.b.t.1
        @Override // com.bumptech.glide.i.a.a.InterfaceC0099a
        /* renamed from: a */
        public t<?> b() {
            return new t<>();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.i.a.c f4862b = com.bumptech.glide.i.a.c.a();

    /* renamed from: c  reason: collision with root package name */
    private u<Z> f4863c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4864d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4865e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Z> t<Z> a(u<Z> uVar) {
        t<Z> tVar = (t) com.bumptech.glide.i.i.a(f4861a.a());
        tVar.b(uVar);
        return tVar;
    }

    t() {
    }

    private void b(u<Z> uVar) {
        this.f4865e = false;
        this.f4864d = true;
        this.f4863c = uVar;
    }

    private void b() {
        this.f4863c = null;
        f4861a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        this.f4862b.b();
        if (!this.f4864d) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f4864d = false;
        if (this.f4865e) {
            f();
        }
    }

    @Override // com.bumptech.glide.c.b.u
    public Class<Z> c() {
        return this.f4863c.c();
    }

    @Override // com.bumptech.glide.c.b.u
    public Z d() {
        return this.f4863c.d();
    }

    @Override // com.bumptech.glide.c.b.u
    public int e() {
        return this.f4863c.e();
    }

    @Override // com.bumptech.glide.c.b.u
    public synchronized void f() {
        this.f4862b.b();
        this.f4865e = true;
        if (!this.f4864d) {
            this.f4863c.f();
            b();
        }
    }

    @Override // com.bumptech.glide.i.a.a.c
    public com.bumptech.glide.i.a.c d_() {
        return this.f4862b;
    }
}

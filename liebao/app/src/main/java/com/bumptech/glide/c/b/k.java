package com.bumptech.glide.c.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.g.e;
import com.bumptech.glide.c.b.g;
import com.bumptech.glide.i.a.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
class k<R> implements g.a<R>, a.c {

    /* renamed from: a  reason: collision with root package name */
    private static final a f4833a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Handler f4834b = new Handler(Looper.getMainLooper(), new b());

    /* renamed from: c  reason: collision with root package name */
    private final List<com.bumptech.glide.g.f> f4835c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.i.a.c f4836d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a<k<?>> f4837e;
    private final a f;
    private final l g;
    private final com.bumptech.glide.c.b.c.a h;
    private final com.bumptech.glide.c.b.c.a i;
    private final com.bumptech.glide.c.b.c.a j;
    private final com.bumptech.glide.c.b.c.a k;
    private com.bumptech.glide.c.h l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;

    /* renamed from: q  reason: collision with root package name */
    private u<?> f4838q;
    private com.bumptech.glide.c.a r;
    private boolean s;
    private p t;
    private boolean u;
    private List<com.bumptech.glide.g.f> v;
    private o<?> w;
    private g<R> x;
    private volatile boolean y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.bumptech.glide.c.b.c.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, l lVar, e.a<k<?>> aVar5) {
        this(aVar, aVar2, aVar3, aVar4, lVar, aVar5, f4833a);
    }

    k(com.bumptech.glide.c.b.c.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, l lVar, e.a<k<?>> aVar5, a aVar6) {
        this.f4835c = new ArrayList(2);
        this.f4836d = com.bumptech.glide.i.a.c.a();
        this.h = aVar;
        this.i = aVar2;
        this.j = aVar3;
        this.k = aVar4;
        this.g = lVar;
        this.f4837e = aVar5;
        this.f = aVar6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k<R> a(com.bumptech.glide.c.h hVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.l = hVar;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        return this;
    }

    public void b(g<R> gVar) {
        com.bumptech.glide.c.b.c.a g;
        this.x = gVar;
        if (gVar.a()) {
            g = this.h;
        } else {
            g = g();
        }
        g.execute(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.g.f fVar) {
        com.bumptech.glide.i.j.a();
        this.f4836d.b();
        if (this.s) {
            fVar.a(this.w, this.r);
        } else if (this.u) {
            fVar.a(this.t);
        } else {
            this.f4835c.add(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.bumptech.glide.g.f fVar) {
        com.bumptech.glide.i.j.a();
        this.f4836d.b();
        if (this.s || this.u) {
            c(fVar);
            return;
        }
        this.f4835c.remove(fVar);
        if (this.f4835c.isEmpty()) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.p;
    }

    private com.bumptech.glide.c.b.c.a g() {
        if (this.n) {
            return this.j;
        }
        return this.o ? this.k : this.i;
    }

    private void c(com.bumptech.glide.g.f fVar) {
        if (this.v == null) {
            this.v = new ArrayList(2);
        }
        if (this.v.contains(fVar)) {
            return;
        }
        this.v.add(fVar);
    }

    private boolean d(com.bumptech.glide.g.f fVar) {
        List<com.bumptech.glide.g.f> list = this.v;
        return list != null && list.contains(fVar);
    }

    void b() {
        if (this.u || this.s || this.y) {
            return;
        }
        this.y = true;
        this.x.b();
        this.g.a(this, this.l);
    }

    void c() {
        this.f4836d.b();
        if (this.y) {
            this.f4838q.f();
            a(false);
        } else if (this.f4835c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else {
            if (this.s) {
                throw new IllegalStateException("Already have resource");
            }
            o<?> a2 = this.f.a(this.f4838q, this.m);
            this.w = a2;
            this.s = true;
            a2.g();
            this.g.a(this, this.l, this.w);
            int size = this.f4835c.size();
            for (int i = 0; i < size; i++) {
                com.bumptech.glide.g.f fVar = this.f4835c.get(i);
                if (!d(fVar)) {
                    this.w.g();
                    fVar.a(this.w, this.r);
                }
            }
            this.w.h();
            a(false);
        }
    }

    void e() {
        this.f4836d.b();
        if (!this.y) {
            throw new IllegalStateException("Not cancelled");
        }
        this.g.a(this, this.l);
        a(false);
    }

    private void a(boolean z) {
        com.bumptech.glide.i.j.a();
        this.f4835c.clear();
        this.l = null;
        this.w = null;
        this.f4838q = null;
        List<com.bumptech.glide.g.f> list = this.v;
        if (list != null) {
            list.clear();
        }
        this.u = false;
        this.y = false;
        this.s = false;
        this.x.a(z);
        this.x = null;
        this.t = null;
        this.r = null;
        this.f4837e.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.c.b.g.a
    public void a(u<R> uVar, com.bumptech.glide.c.a aVar) {
        this.f4838q = uVar;
        this.r = aVar;
        f4834b.obtainMessage(1, this).sendToTarget();
    }

    @Override // com.bumptech.glide.c.b.g.a
    public void a(p pVar) {
        this.t = pVar;
        f4834b.obtainMessage(2, this).sendToTarget();
    }

    @Override // com.bumptech.glide.c.b.g.a
    public void a(g<?> gVar) {
        g().execute(gVar);
    }

    void f() {
        this.f4836d.b();
        if (this.y) {
            a(false);
        } else if (this.f4835c.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else {
            if (this.u) {
                throw new IllegalStateException("Already failed once");
            }
            this.u = true;
            this.g.a(this, this.l, null);
            for (com.bumptech.glide.g.f fVar : this.f4835c) {
                if (!d(fVar)) {
                    fVar.a(this.t);
                }
            }
            a(false);
        }
    }

    @Override // com.bumptech.glide.i.a.a.c
    public com.bumptech.glide.i.a.c d_() {
        return this.f4836d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public <R> o<R> a(u<R> uVar, boolean z) {
            return new o<>(uVar, z, true);
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    private static class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            k kVar = (k) message.obj;
            int i = message.what;
            if (i == 1) {
                kVar.c();
            } else if (i == 2) {
                kVar.f();
            } else if (i == 3) {
                kVar.e();
            } else {
                throw new IllegalStateException("Unrecognized message: " + message.what);
            }
            return true;
        }
    }
}

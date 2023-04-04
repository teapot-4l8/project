package com.bumptech.glide.g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.core.g.e;
import com.bumptech.glide.c.b.j;
import com.bumptech.glide.c.b.p;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.i.a.a;
import java.util.List;

/* compiled from: SingleRequest.java */
/* loaded from: classes.dex */
public final class g<R> implements com.bumptech.glide.g.a.g, b, f, a.c {

    /* renamed from: a  reason: collision with root package name */
    private static final e.a<g<?>> f5203a = com.bumptech.glide.i.a.a.a(150, new a.InterfaceC0099a<g<?>>() { // from class: com.bumptech.glide.g.g.1
        @Override // com.bumptech.glide.i.a.a.InterfaceC0099a
        /* renamed from: a */
        public g<?> b() {
            return new g<>();
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f5204c = Log.isLoggable("Request", 2);
    private int A;
    private int B;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5205b;

    /* renamed from: d  reason: collision with root package name */
    private final String f5206d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.i.a.c f5207e;
    private d<R> f;
    private c g;
    private Context h;
    private com.bumptech.glide.e i;
    private Object j;
    private Class<R> k;
    private e l;
    private int m;
    private int n;
    private com.bumptech.glide.g o;
    private com.bumptech.glide.g.a.h<R> p;

    /* renamed from: q  reason: collision with root package name */
    private List<d<R>> f5208q;
    private j r;
    private com.bumptech.glide.g.b.c<? super R> s;
    private u<R> t;
    private j.d u;
    private long v;
    private a w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SingleRequest.java */
    /* loaded from: classes.dex */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> g<R> a(Context context, com.bumptech.glide.e eVar, Object obj, Class<R> cls, e eVar2, int i, int i2, com.bumptech.glide.g gVar, com.bumptech.glide.g.a.h<R> hVar, d<R> dVar, List<d<R>> list, c cVar, j jVar, com.bumptech.glide.g.b.c<? super R> cVar2) {
        g<?> a2 = f5203a.a();
        if (a2 == null) {
            a2 = new g();
        }
        a2.b(context, eVar, obj, cls, eVar2, i, i2, gVar, hVar, dVar, list, cVar, jVar, cVar2);
        return a2;
    }

    g() {
        this.f5206d = f5204c ? String.valueOf(super.hashCode()) : null;
        this.f5207e = com.bumptech.glide.i.a.c.a();
    }

    private void b(Context context, com.bumptech.glide.e eVar, Object obj, Class<R> cls, e eVar2, int i, int i2, com.bumptech.glide.g gVar, com.bumptech.glide.g.a.h<R> hVar, d<R> dVar, List<d<R>> list, c cVar, j jVar, com.bumptech.glide.g.b.c<? super R> cVar2) {
        this.h = context;
        this.i = eVar;
        this.j = obj;
        this.k = cls;
        this.l = eVar2;
        this.m = i;
        this.n = i2;
        this.o = gVar;
        this.p = hVar;
        this.f = dVar;
        this.f5208q = list;
        this.g = cVar;
        this.r = jVar;
        this.s = cVar2;
        this.w = a.PENDING;
    }

    @Override // com.bumptech.glide.i.a.a.c
    public com.bumptech.glide.i.a.c d_() {
        return this.f5207e;
    }

    @Override // com.bumptech.glide.g.b
    public void h() {
        j();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = -1;
        this.p = null;
        this.f5208q = null;
        this.f = null;
        this.g = null;
        this.s = null;
        this.u = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = -1;
        this.B = -1;
        f5203a.a(this);
    }

    @Override // com.bumptech.glide.g.b
    public void a() {
        j();
        this.f5207e.b();
        this.v = com.bumptech.glide.i.e.a();
        if (this.j == null) {
            if (com.bumptech.glide.i.j.a(this.m, this.n)) {
                this.A = this.m;
                this.B = this.n;
            }
            a(new p("Received null model"), m() == null ? 5 : 3);
        } else if (this.w == a.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else {
            if (this.w == a.COMPLETE) {
                a((u<?>) this.t, com.bumptech.glide.c.a.MEMORY_CACHE);
                return;
            }
            this.w = a.WAITING_FOR_SIZE;
            if (com.bumptech.glide.i.j.a(this.m, this.n)) {
                a(this.m, this.n);
            } else {
                this.p.a((com.bumptech.glide.g.a.g) this);
            }
            if ((this.w == a.RUNNING || this.w == a.WAITING_FOR_SIZE) && q()) {
                this.p.b(l());
            }
            if (f5204c) {
                a("finished run method in " + com.bumptech.glide.i.e.a(this.v));
            }
        }
    }

    private void i() {
        j();
        this.f5207e.b();
        this.p.b(this);
        j.d dVar = this.u;
        if (dVar != null) {
            dVar.a();
            this.u = null;
        }
    }

    private void j() {
        if (this.f5205b) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.g.b
    public void b() {
        com.bumptech.glide.i.j.a();
        j();
        this.f5207e.b();
        if (this.w == a.CLEARED) {
            return;
        }
        i();
        u<R> uVar = this.t;
        if (uVar != null) {
            a((u<?>) uVar);
        }
        if (p()) {
            this.p.a(l());
        }
        this.w = a.CLEARED;
    }

    private void a(u<?> uVar) {
        this.r.a(uVar);
        this.t = null;
    }

    @Override // com.bumptech.glide.g.b
    public boolean c() {
        return this.w == a.RUNNING || this.w == a.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.g.b
    public boolean d() {
        return this.w == a.COMPLETE;
    }

    @Override // com.bumptech.glide.g.b
    public boolean e() {
        return d();
    }

    @Override // com.bumptech.glide.g.b
    public boolean f() {
        return this.w == a.CLEARED;
    }

    @Override // com.bumptech.glide.g.b
    public boolean g() {
        return this.w == a.FAILED;
    }

    private Drawable k() {
        if (this.x == null) {
            Drawable n = this.l.n();
            this.x = n;
            if (n == null && this.l.o() > 0) {
                this.x = a(this.l.o());
            }
        }
        return this.x;
    }

    private Drawable l() {
        if (this.y == null) {
            Drawable q2 = this.l.q();
            this.y = q2;
            if (q2 == null && this.l.p() > 0) {
                this.y = a(this.l.p());
            }
        }
        return this.y;
    }

    private Drawable m() {
        if (this.z == null) {
            Drawable s = this.l.s();
            this.z = s;
            if (s == null && this.l.r() > 0) {
                this.z = a(this.l.r());
            }
        }
        return this.z;
    }

    private Drawable a(int i) {
        return com.bumptech.glide.c.d.c.a.a(this.i, i, this.l.t() != null ? this.l.t() : this.h.getTheme());
    }

    private void n() {
        if (q()) {
            Drawable m = this.j == null ? m() : null;
            if (m == null) {
                m = k();
            }
            if (m == null) {
                m = l();
            }
            this.p.c(m);
        }
    }

    @Override // com.bumptech.glide.g.a.g
    public void a(int i, int i2) {
        this.f5207e.b();
        if (f5204c) {
            a("Got onSizeReady in " + com.bumptech.glide.i.e.a(this.v));
        }
        if (this.w != a.WAITING_FOR_SIZE) {
            return;
        }
        this.w = a.RUNNING;
        float B = this.l.B();
        this.A = a(i, B);
        this.B = a(i2, B);
        if (f5204c) {
            a("finished setup for calling load in " + com.bumptech.glide.i.e.a(this.v));
        }
        this.u = this.r.a(this.i, this.j, this.l.v(), this.A, this.B, this.l.l(), this.k, this.o, this.l.m(), this.l.i(), this.l.j(), this.l.C(), this.l.k(), this.l.u(), this.l.D(), this.l.E(), this.l.F(), this);
        if (this.w != a.RUNNING) {
            this.u = null;
        }
        if (f5204c) {
            a("finished onSizeReady in " + com.bumptech.glide.i.e.a(this.v));
        }
    }

    private static int a(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    private boolean o() {
        c cVar = this.g;
        return cVar == null || cVar.b(this);
    }

    private boolean p() {
        c cVar = this.g;
        return cVar == null || cVar.d(this);
    }

    private boolean q() {
        c cVar = this.g;
        return cVar == null || cVar.c(this);
    }

    private boolean r() {
        c cVar = this.g;
        return cVar == null || !cVar.i();
    }

    private void s() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.e(this);
        }
    }

    private void t() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.f(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.g.f
    public void a(u<?> uVar, com.bumptech.glide.c.a aVar) {
        this.f5207e.b();
        this.u = null;
        if (uVar == null) {
            a(new p("Expected to receive a Resource<R> with an object of " + this.k + " inside, but instead got null."));
            return;
        }
        Object d2 = uVar.d();
        if (d2 == null || !this.k.isAssignableFrom(d2.getClass())) {
            a(uVar);
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive an object of ");
            sb.append(this.k);
            sb.append(" but instead got ");
            sb.append(d2 != null ? d2.getClass() : "");
            sb.append("{");
            sb.append(d2);
            sb.append("} inside Resource{");
            sb.append(uVar);
            sb.append("}.");
            sb.append(d2 == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
            a(new p(sb.toString()));
        } else if (!o()) {
            a(uVar);
            this.w = a.COMPLETE;
        } else {
            a(uVar, d2, aVar);
        }
    }

    private void a(u<R> uVar, R r, com.bumptech.glide.c.a aVar) {
        boolean z;
        boolean r2 = r();
        this.w = a.COMPLETE;
        this.t = uVar;
        if (this.i.d() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + aVar + " for " + this.j + " with size [" + this.A + "x" + this.B + "] in " + com.bumptech.glide.i.e.a(this.v) + " ms");
        }
        boolean z2 = true;
        this.f5205b = true;
        try {
            if (this.f5208q != null) {
                z = false;
                for (d<R> dVar : this.f5208q) {
                    z |= dVar.a(r, this.j, this.p, aVar, r2);
                }
            } else {
                z = false;
            }
            if (this.f == null || !this.f.a(r, this.j, this.p, aVar, r2)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                this.p.a(r, this.s.a(aVar, r2));
            }
            this.f5205b = false;
            s();
        } catch (Throwable th) {
            this.f5205b = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.g.f
    public void a(p pVar) {
        a(pVar, 5);
    }

    private void a(p pVar, int i) {
        boolean z;
        this.f5207e.b();
        int d2 = this.i.d();
        if (d2 <= i) {
            Log.w("Glide", "Load failed for " + this.j + " with size [" + this.A + "x" + this.B + "]", pVar);
            if (d2 <= 4) {
                pVar.a("Glide");
            }
        }
        this.u = null;
        this.w = a.FAILED;
        boolean z2 = true;
        this.f5205b = true;
        try {
            if (this.f5208q != null) {
                z = false;
                for (d<R> dVar : this.f5208q) {
                    z |= dVar.a(pVar, this.j, this.p, r());
                }
            } else {
                z = false;
            }
            if (this.f == null || !this.f.a(pVar, this.j, this.p, r())) {
                z2 = false;
            }
            if (!(z | z2)) {
                n();
            }
            this.f5205b = false;
            t();
        } catch (Throwable th) {
            this.f5205b = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.g.b
    public boolean a(b bVar) {
        if (bVar instanceof g) {
            g gVar = (g) bVar;
            return this.m == gVar.m && this.n == gVar.n && com.bumptech.glide.i.j.b(this.j, gVar.j) && this.k.equals(gVar.k) && this.l.equals(gVar.l) && this.o == gVar.o && a((g<?>) this, (g<?>) gVar);
        }
        return false;
    }

    private static boolean a(g<?> gVar, g<?> gVar2) {
        List<d<?>> list = ((g) gVar).f5208q;
        int size = list == null ? 0 : list.size();
        List<d<?>> list2 = ((g) gVar2).f5208q;
        return size == (list2 == null ? 0 : list2.size());
    }

    private void a(String str) {
        Log.v("Request", str + " this: " + this.f5206d);
    }
}

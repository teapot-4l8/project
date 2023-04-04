package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.d.c;
import com.bumptech.glide.d.m;
import com.bumptech.glide.d.n;
import com.bumptech.glide.d.p;
import java.io.File;

/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class j implements com.bumptech.glide.d.i {

    /* renamed from: d  reason: collision with root package name */
    private static final com.bumptech.glide.g.e f5261d = com.bumptech.glide.g.e.a(Bitmap.class).g();

    /* renamed from: e  reason: collision with root package name */
    private static final com.bumptech.glide.g.e f5262e = com.bumptech.glide.g.e.a(com.bumptech.glide.c.d.e.c.class).g();
    private static final com.bumptech.glide.g.e f = com.bumptech.glide.g.e.a(com.bumptech.glide.c.b.i.f4811c).a(g.LOW).b(true);

    /* renamed from: a  reason: collision with root package name */
    protected final c f5263a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f5264b;

    /* renamed from: c  reason: collision with root package name */
    final com.bumptech.glide.d.h f5265c;
    private final n g;
    private final m h;
    private final p i;
    private final Runnable j;
    private final Handler k;
    private final com.bumptech.glide.d.c l;
    private com.bumptech.glide.g.e m;

    public j(c cVar, com.bumptech.glide.d.h hVar, m mVar, Context context) {
        this(cVar, hVar, mVar, new n(), cVar.d(), context);
    }

    j(c cVar, com.bumptech.glide.d.h hVar, m mVar, n nVar, com.bumptech.glide.d.d dVar, Context context) {
        this.i = new p();
        this.j = new Runnable() { // from class: com.bumptech.glide.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.f5265c.a(j.this);
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        this.f5263a = cVar;
        this.f5265c = hVar;
        this.h = mVar;
        this.g = nVar;
        this.f5264b = context;
        this.l = dVar.a(context.getApplicationContext(), new a(nVar));
        if (com.bumptech.glide.i.j.c()) {
            this.k.post(this.j);
        } else {
            hVar.a(this);
        }
        hVar.a(this.l);
        a(cVar.e().a());
        cVar.a(this);
    }

    protected void a(com.bumptech.glide.g.e eVar) {
        this.m = eVar.clone().h();
    }

    public void a() {
        com.bumptech.glide.i.j.a();
        this.g.a();
    }

    public void b() {
        com.bumptech.glide.i.j.a();
        this.g.b();
    }

    @Override // com.bumptech.glide.d.i
    public void c() {
        b();
        this.i.c();
    }

    @Override // com.bumptech.glide.d.i
    public void d() {
        a();
        this.i.d();
    }

    @Override // com.bumptech.glide.d.i
    public void e() {
        this.i.e();
        for (com.bumptech.glide.g.a.h<?> hVar : this.i.a()) {
            a(hVar);
        }
        this.i.b();
        this.g.c();
        this.f5265c.b(this);
        this.f5265c.b(this.l);
        this.k.removeCallbacks(this.j);
        this.f5263a.b(this);
    }

    public i<Bitmap> f() {
        return a(Bitmap.class).a(f5261d);
    }

    public i<Drawable> g() {
        return a(Drawable.class);
    }

    public i<Drawable> a(String str) {
        return g().a(str);
    }

    public i<Drawable> a(File file) {
        return g().a(file);
    }

    public <ResourceType> i<ResourceType> a(Class<ResourceType> cls) {
        return new i<>(this.f5263a, this, cls, this.f5264b);
    }

    public void a(final com.bumptech.glide.g.a.h<?> hVar) {
        if (hVar == null) {
            return;
        }
        if (com.bumptech.glide.i.j.b()) {
            c(hVar);
        } else {
            this.k.post(new Runnable() { // from class: com.bumptech.glide.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.a(hVar);
                }
            });
        }
    }

    private void c(com.bumptech.glide.g.a.h<?> hVar) {
        if (b(hVar) || this.f5263a.a(hVar) || hVar.b() == null) {
            return;
        }
        com.bumptech.glide.g.b b2 = hVar.b();
        hVar.a((com.bumptech.glide.g.b) null);
        b2.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(com.bumptech.glide.g.a.h<?> hVar) {
        com.bumptech.glide.g.b b2 = hVar.b();
        if (b2 == null) {
            return true;
        }
        if (this.g.b(b2)) {
            this.i.b(hVar);
            hVar.a((com.bumptech.glide.g.b) null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.g.a.h<?> hVar, com.bumptech.glide.g.b bVar) {
        this.i.a(hVar);
        this.g.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.g.e h() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> k<?, T> b(Class<T> cls) {
        return this.f5263a.e().a(cls);
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.g + ", treeNode=" + this.h + "}";
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    private static class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final n f5269a;

        a(n nVar) {
            this.f5269a = nVar;
        }

        @Override // com.bumptech.glide.d.c.a
        public void a(boolean z) {
            if (z) {
                this.f5269a.d();
            }
        }
    }
}

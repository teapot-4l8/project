package com.bumptech.glide.c.b;

import android.util.Log;
import androidx.core.g.e;
import com.bumptech.glide.c.b.b.a;
import com.bumptech.glide.c.b.b.h;
import com.bumptech.glide.c.b.g;
import com.bumptech.glide.c.b.o;
import com.bumptech.glide.i.a.a;
import java.util.Map;

/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class j implements h.a, l, o.a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f4814a = Log.isLoggable("Engine", 2);

    /* renamed from: b  reason: collision with root package name */
    private final r f4815b;

    /* renamed from: c  reason: collision with root package name */
    private final n f4816c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.c.b.b.h f4817d;

    /* renamed from: e  reason: collision with root package name */
    private final b f4818e;
    private final x f;
    private final c g;
    private final a h;
    private final com.bumptech.glide.c.b.a i;

    public j(com.bumptech.glide.c.b.b.h hVar, a.InterfaceC0086a interfaceC0086a, com.bumptech.glide.c.b.c.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, boolean z) {
        this(hVar, interfaceC0086a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    j(com.bumptech.glide.c.b.b.h hVar, a.InterfaceC0086a interfaceC0086a, com.bumptech.glide.c.b.c.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, r rVar, n nVar, com.bumptech.glide.c.b.a aVar5, b bVar, a aVar6, x xVar, boolean z) {
        this.f4817d = hVar;
        this.g = new c(interfaceC0086a);
        com.bumptech.glide.c.b.a aVar7 = aVar5 == null ? new com.bumptech.glide.c.b.a(z) : aVar5;
        this.i = aVar7;
        aVar7.a(this);
        this.f4816c = nVar == null ? new n() : nVar;
        this.f4815b = rVar == null ? new r() : rVar;
        this.f4818e = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this) : bVar;
        this.h = aVar6 == null ? new a(this.g) : aVar6;
        this.f = xVar == null ? new x() : xVar;
        hVar.a(this);
    }

    public <R> d a(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.c.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, com.bumptech.glide.g gVar, i iVar, Map<Class<?>, com.bumptech.glide.c.m<?>> map, boolean z, boolean z2, com.bumptech.glide.c.j jVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.g.f fVar) {
        com.bumptech.glide.i.j.a();
        long a2 = f4814a ? com.bumptech.glide.i.e.a() : 0L;
        m a3 = this.f4816c.a(obj, hVar, i, i2, map, cls, cls2, jVar);
        o<?> a4 = a(a3, z3);
        if (a4 != null) {
            fVar.a(a4, com.bumptech.glide.c.a.MEMORY_CACHE);
            if (f4814a) {
                a("Loaded resource from active resources", a2, a3);
            }
            return null;
        }
        o<?> b2 = b(a3, z3);
        if (b2 != null) {
            fVar.a(b2, com.bumptech.glide.c.a.MEMORY_CACHE);
            if (f4814a) {
                a("Loaded resource from cache", a2, a3);
            }
            return null;
        }
        k<?> a5 = this.f4815b.a(a3, z6);
        if (a5 != null) {
            a5.a(fVar);
            if (f4814a) {
                a("Added to existing load", a2, a3);
            }
            return new d(fVar, a5);
        }
        k<R> a6 = this.f4818e.a(a3, z3, z4, z5, z6);
        g<R> a7 = this.h.a(eVar, obj, a3, hVar, i, i2, cls, cls2, gVar, iVar, map, z, z2, z6, jVar, a6);
        this.f4815b.a((com.bumptech.glide.c.h) a3, (k<?>) a6);
        a6.a(fVar);
        a6.b(a7);
        if (f4814a) {
            a("Started new load", a2, a3);
        }
        return new d(fVar, a6);
    }

    private static void a(String str, long j, com.bumptech.glide.c.h hVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.i.e.a(j) + "ms, key: " + hVar);
    }

    private o<?> a(com.bumptech.glide.c.h hVar, boolean z) {
        if (z) {
            o<?> b2 = this.i.b(hVar);
            if (b2 != null) {
                b2.g();
            }
            return b2;
        }
        return null;
    }

    private o<?> b(com.bumptech.glide.c.h hVar, boolean z) {
        if (z) {
            o<?> a2 = a(hVar);
            if (a2 != null) {
                a2.g();
                this.i.a(hVar, a2);
            }
            return a2;
        }
        return null;
    }

    private o<?> a(com.bumptech.glide.c.h hVar) {
        u<?> a2 = this.f4817d.a(hVar);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof o) {
            return (o) a2;
        }
        return new o<>(a2, true, true);
    }

    public void a(u<?> uVar) {
        com.bumptech.glide.i.j.a();
        if (uVar instanceof o) {
            ((o) uVar).h();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.c.b.l
    public void a(k<?> kVar, com.bumptech.glide.c.h hVar, o<?> oVar) {
        com.bumptech.glide.i.j.a();
        if (oVar != null) {
            oVar.a(hVar, this);
            if (oVar.b()) {
                this.i.a(hVar, oVar);
            }
        }
        this.f4815b.b(hVar, kVar);
    }

    @Override // com.bumptech.glide.c.b.l
    public void a(k<?> kVar, com.bumptech.glide.c.h hVar) {
        com.bumptech.glide.i.j.a();
        this.f4815b.b(hVar, kVar);
    }

    @Override // com.bumptech.glide.c.b.b.h.a
    public void b(u<?> uVar) {
        com.bumptech.glide.i.j.a();
        this.f.a(uVar);
    }

    @Override // com.bumptech.glide.c.b.o.a
    public void a(com.bumptech.glide.c.h hVar, o<?> oVar) {
        com.bumptech.glide.i.j.a();
        this.i.a(hVar);
        if (oVar.b()) {
            this.f4817d.b(hVar, oVar);
        } else {
            this.f.a(oVar);
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final k<?> f4831a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.g.f f4832b;

        d(com.bumptech.glide.g.f fVar, k<?> kVar) {
            this.f4832b = fVar;
            this.f4831a = kVar;
        }

        public void a() {
            this.f4831a.b(this.f4832b);
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    private static class c implements g.d {

        /* renamed from: a  reason: collision with root package name */
        private final a.InterfaceC0086a f4829a;

        /* renamed from: b  reason: collision with root package name */
        private volatile com.bumptech.glide.c.b.b.a f4830b;

        c(a.InterfaceC0086a interfaceC0086a) {
            this.f4829a = interfaceC0086a;
        }

        @Override // com.bumptech.glide.c.b.g.d
        public com.bumptech.glide.c.b.b.a a() {
            if (this.f4830b == null) {
                synchronized (this) {
                    if (this.f4830b == null) {
                        this.f4830b = this.f4829a.a();
                    }
                    if (this.f4830b == null) {
                        this.f4830b = new com.bumptech.glide.c.b.b.b();
                    }
                }
            }
            return this.f4830b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final g.d f4819a;

        /* renamed from: b  reason: collision with root package name */
        final e.a<g<?>> f4820b = com.bumptech.glide.i.a.a.a(150, new a.InterfaceC0099a<g<?>>() { // from class: com.bumptech.glide.c.b.j.a.1
            @Override // com.bumptech.glide.i.a.a.InterfaceC0099a
            /* renamed from: a */
            public g<?> b() {
                return new g<>(a.this.f4819a, a.this.f4820b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        private int f4821c;

        a(g.d dVar) {
            this.f4819a = dVar;
        }

        <R> g<R> a(com.bumptech.glide.e eVar, Object obj, m mVar, com.bumptech.glide.c.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, com.bumptech.glide.g gVar, i iVar, Map<Class<?>, com.bumptech.glide.c.m<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.c.j jVar, g.a<R> aVar) {
            g gVar2 = (g) com.bumptech.glide.i.i.a(this.f4820b.a());
            int i3 = this.f4821c;
            this.f4821c = i3 + 1;
            return gVar2.a(eVar, obj, mVar, hVar, i, i2, cls, cls2, gVar, iVar, map, z, z2, z3, jVar, aVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.c.b.c.a f4823a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.c.b.c.a f4824b;

        /* renamed from: c  reason: collision with root package name */
        final com.bumptech.glide.c.b.c.a f4825c;

        /* renamed from: d  reason: collision with root package name */
        final com.bumptech.glide.c.b.c.a f4826d;

        /* renamed from: e  reason: collision with root package name */
        final l f4827e;
        final e.a<k<?>> f = com.bumptech.glide.i.a.a.a(150, new a.InterfaceC0099a<k<?>>() { // from class: com.bumptech.glide.c.b.j.b.1
            @Override // com.bumptech.glide.i.a.a.InterfaceC0099a
            /* renamed from: a */
            public k<?> b() {
                return new k<>(b.this.f4823a, b.this.f4824b, b.this.f4825c, b.this.f4826d, b.this.f4827e, b.this.f);
            }
        });

        b(com.bumptech.glide.c.b.c.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, l lVar) {
            this.f4823a = aVar;
            this.f4824b = aVar2;
            this.f4825c = aVar3;
            this.f4826d = aVar4;
            this.f4827e = lVar;
        }

        <R> k<R> a(com.bumptech.glide.c.h hVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((k) com.bumptech.glide.i.i.a(this.f.a())).a(hVar, z, z2, z3, z4);
        }
    }
}

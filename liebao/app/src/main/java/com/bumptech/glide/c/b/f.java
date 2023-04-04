package com.bumptech.glide.c.b;

import com.bumptech.glide.c.b.g;
import com.bumptech.glide.c.c.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeHelper.java */
/* loaded from: classes.dex */
public final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.a<?>> f4772a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<com.bumptech.glide.c.h> f4773b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.e f4774c;

    /* renamed from: d  reason: collision with root package name */
    private Object f4775d;

    /* renamed from: e  reason: collision with root package name */
    private int f4776e;
    private int f;
    private Class<?> g;
    private g.d h;
    private com.bumptech.glide.c.j i;
    private Map<Class<?>, com.bumptech.glide.c.m<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private com.bumptech.glide.c.h n;
    private com.bumptech.glide.g o;
    private i p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4777q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void a(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.c.h hVar, int i, int i2, i iVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.g gVar, com.bumptech.glide.c.j jVar, Map<Class<?>, com.bumptech.glide.c.m<?>> map, boolean z, boolean z2, g.d dVar) {
        this.f4774c = eVar;
        this.f4775d = obj;
        this.n = hVar;
        this.f4776e = i;
        this.f = i2;
        this.p = iVar;
        this.g = cls;
        this.h = dVar;
        this.k = cls2;
        this.o = gVar;
        this.i = jVar;
        this.j = map;
        this.f4777q = z;
        this.r = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f4774c = null;
        this.f4775d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f4772a.clear();
        this.l = false;
        this.f4773b.clear();
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.c.b.b.a b() {
        return this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i c() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.g d() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.c.j e() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.c.h f() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f4776e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.c.b.a.b i() {
        return this.f4774c.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> j() {
        return (Class<Transcode>) this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> k() {
        return this.f4774c.c().b(this.f4775d.getClass(), this.g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> s<Data, ?, Transcode> b(Class<Data> cls) {
        return this.f4774c.c().a(cls, this.g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.c.m<Z> c(Class<Z> cls) {
        com.bumptech.glide.c.m<Z> mVar = (com.bumptech.glide.c.m<Z>) this.j.get(cls);
        if (mVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.c.m<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.c.m<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    mVar = (com.bumptech.glide.c.m<Z>) next.getValue();
                    break;
                }
            }
        }
        if (mVar == null) {
            if (this.j.isEmpty() && this.f4777q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return com.bumptech.glide.c.d.b.a();
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(u<?> uVar) {
        return this.f4774c.c().a(uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.c.l<Z> b(u<Z> uVar) {
        return this.f4774c.c().b((u) uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.c.c.n<File, ?>> a(File file) {
        return this.f4774c.c().c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(com.bumptech.glide.c.h hVar) {
        List<n.a<?>> m = m();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            if (m.get(i).f4943a.equals(hVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n.a<?>> m() {
        if (!this.l) {
            this.l = true;
            this.f4772a.clear();
            List c2 = this.f4774c.c().c(this.f4775d);
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                n.a<?> a2 = ((com.bumptech.glide.c.c.n) c2.get(i)).a(this.f4775d, this.f4776e, this.f, this.i);
                if (a2 != null) {
                    this.f4772a.add(a2);
                }
            }
        }
        return this.f4772a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.c.h> n() {
        if (!this.m) {
            this.m = true;
            this.f4773b.clear();
            List<n.a<?>> m = m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                n.a<?> aVar = m.get(i);
                if (!this.f4773b.contains(aVar.f4943a)) {
                    this.f4773b.add(aVar.f4943a);
                }
                for (int i2 = 0; i2 < aVar.f4944b.size(); i2++) {
                    if (!this.f4773b.contains(aVar.f4944b.get(i2))) {
                        this.f4773b.add(aVar.f4944b.get(i2));
                    }
                }
            }
        }
        return this.f4773b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> com.bumptech.glide.c.d<X> a(X x) {
        return this.f4774c.c().a((com.bumptech.glide.h) x);
    }
}

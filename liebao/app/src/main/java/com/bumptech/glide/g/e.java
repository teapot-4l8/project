package com.bumptech.glide.g;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.i;
import com.bumptech.glide.c.d.a.o;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.m;
import com.google.android.gms.ads.AdRequest;
import java.util.Map;

/* compiled from: RequestOptions.java */
/* loaded from: classes.dex */
public class e implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f5197a;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f5201e;
    private int f;
    private Drawable g;
    private int h;
    private boolean m;
    private Drawable o;
    private int p;
    private boolean t;
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean z;

    /* renamed from: b  reason: collision with root package name */
    private float f5198b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private i f5199c = i.f4813e;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.g f5200d = com.bumptech.glide.g.NORMAL;
    private boolean i = true;
    private int j = -1;
    private int k = -1;
    private com.bumptech.glide.c.h l = com.bumptech.glide.h.a.a();
    private boolean n = true;

    /* renamed from: q  reason: collision with root package name */
    private j f5202q = new j();
    private Map<Class<?>, m<?>> r = new com.bumptech.glide.i.b();
    private Class<?> s = Object.class;
    private boolean y = true;

    private static boolean b(int i, int i2) {
        return (i & i2) != 0;
    }

    public static e a(i iVar) {
        return new e().b(iVar);
    }

    public static e a(com.bumptech.glide.c.h hVar) {
        return new e().b(hVar);
    }

    public static e a(Class<?> cls) {
        return new e().b(cls);
    }

    public e a(float f) {
        if (this.v) {
            return clone().a(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f5198b = f;
        this.f5197a |= 2;
        return G();
    }

    public e a(boolean z) {
        if (this.v) {
            return clone().a(z);
        }
        this.z = z;
        this.f5197a |= 1048576;
        return G();
    }

    public e b(i iVar) {
        if (this.v) {
            return clone().b(iVar);
        }
        this.f5199c = (i) com.bumptech.glide.i.i.a(iVar);
        this.f5197a |= 4;
        return G();
    }

    public e a(com.bumptech.glide.g gVar) {
        if (this.v) {
            return clone().a(gVar);
        }
        this.f5200d = (com.bumptech.glide.g) com.bumptech.glide.i.i.a(gVar);
        this.f5197a |= 8;
        return G();
    }

    public e b(boolean z) {
        if (this.v) {
            return clone().b(true);
        }
        this.i = !z;
        this.f5197a |= 256;
        return G();
    }

    public e a(int i, int i2) {
        if (this.v) {
            return clone().a(i, i2);
        }
        this.k = i;
        this.j = i2;
        this.f5197a |= AdRequest.MAX_CONTENT_URL_LENGTH;
        return G();
    }

    public e b(com.bumptech.glide.c.h hVar) {
        if (this.v) {
            return clone().b(hVar);
        }
        this.l = (com.bumptech.glide.c.h) com.bumptech.glide.i.i.a(hVar);
        this.f5197a |= 1024;
        return G();
    }

    /* renamed from: a */
    public e clone() {
        try {
            e eVar = (e) super.clone();
            j jVar = new j();
            eVar.f5202q = jVar;
            jVar.a(this.f5202q);
            com.bumptech.glide.i.b bVar = new com.bumptech.glide.i.b();
            eVar.r = bVar;
            bVar.putAll(this.r);
            eVar.t = false;
            eVar.v = false;
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public <T> e a(com.bumptech.glide.c.i<T> iVar, T t) {
        if (this.v) {
            return clone().a((com.bumptech.glide.c.i<com.bumptech.glide.c.i<T>>) iVar, (com.bumptech.glide.c.i<T>) t);
        }
        com.bumptech.glide.i.i.a(iVar);
        com.bumptech.glide.i.i.a(t);
        this.f5202q.a(iVar, t);
        return G();
    }

    public e b(Class<?> cls) {
        if (this.v) {
            return clone().b(cls);
        }
        this.s = (Class) com.bumptech.glide.i.i.a(cls);
        this.f5197a |= 4096;
        return G();
    }

    public final boolean b() {
        return this.n;
    }

    public final boolean c() {
        return a(2048);
    }

    public e a(com.bumptech.glide.c.d.a.j jVar) {
        return a((com.bumptech.glide.c.i<com.bumptech.glide.c.i<com.bumptech.glide.c.d.a.j>>) com.bumptech.glide.c.d.a.j.h, (com.bumptech.glide.c.i<com.bumptech.glide.c.d.a.j>) com.bumptech.glide.i.i.a(jVar));
    }

    public e d() {
        return a(com.bumptech.glide.c.d.a.j.f5002b, new com.bumptech.glide.c.d.a.g());
    }

    public e e() {
        return c(com.bumptech.glide.c.d.a.j.f5001a, new o());
    }

    public e f() {
        return c(com.bumptech.glide.c.d.a.j.f5005e, new com.bumptech.glide.c.d.a.h());
    }

    final e a(com.bumptech.glide.c.d.a.j jVar, m<Bitmap> mVar) {
        if (this.v) {
            return clone().a(jVar, mVar);
        }
        a(jVar);
        return a(mVar, false);
    }

    final e b(com.bumptech.glide.c.d.a.j jVar, m<Bitmap> mVar) {
        if (this.v) {
            return clone().b(jVar, mVar);
        }
        a(jVar);
        return a(mVar);
    }

    private e c(com.bumptech.glide.c.d.a.j jVar, m<Bitmap> mVar) {
        return a(jVar, mVar, false);
    }

    private e a(com.bumptech.glide.c.d.a.j jVar, m<Bitmap> mVar, boolean z) {
        e b2 = z ? b(jVar, mVar) : a(jVar, mVar);
        b2.y = true;
        return b2;
    }

    public e a(m<Bitmap> mVar) {
        return a(mVar, true);
    }

    private e a(m<Bitmap> mVar, boolean z) {
        if (this.v) {
            return clone().a(mVar, z);
        }
        com.bumptech.glide.c.d.a.m mVar2 = new com.bumptech.glide.c.d.a.m(mVar, z);
        a(Bitmap.class, mVar, z);
        a(Drawable.class, mVar2, z);
        a(BitmapDrawable.class, mVar2.a(), z);
        a(com.bumptech.glide.c.d.e.c.class, new com.bumptech.glide.c.d.e.f(mVar), z);
        return G();
    }

    private <T> e a(Class<T> cls, m<T> mVar, boolean z) {
        if (this.v) {
            return clone().a(cls, mVar, z);
        }
        com.bumptech.glide.i.i.a(cls);
        com.bumptech.glide.i.i.a(mVar);
        this.r.put(cls, mVar);
        int i = this.f5197a | 2048;
        this.f5197a = i;
        this.n = true;
        int i2 = i | 65536;
        this.f5197a = i2;
        this.y = false;
        if (z) {
            this.f5197a = i2 | 131072;
            this.m = true;
        }
        return G();
    }

    public e a(e eVar) {
        if (this.v) {
            return clone().a(eVar);
        }
        if (b(eVar.f5197a, 2)) {
            this.f5198b = eVar.f5198b;
        }
        if (b(eVar.f5197a, 262144)) {
            this.w = eVar.w;
        }
        if (b(eVar.f5197a, 1048576)) {
            this.z = eVar.z;
        }
        if (b(eVar.f5197a, 4)) {
            this.f5199c = eVar.f5199c;
        }
        if (b(eVar.f5197a, 8)) {
            this.f5200d = eVar.f5200d;
        }
        if (b(eVar.f5197a, 16)) {
            this.f5201e = eVar.f5201e;
            this.f = 0;
            this.f5197a &= -33;
        }
        if (b(eVar.f5197a, 32)) {
            this.f = eVar.f;
            this.f5201e = null;
            this.f5197a &= -17;
        }
        if (b(eVar.f5197a, 64)) {
            this.g = eVar.g;
            this.h = 0;
            this.f5197a &= -129;
        }
        if (b(eVar.f5197a, 128)) {
            this.h = eVar.h;
            this.g = null;
            this.f5197a &= -65;
        }
        if (b(eVar.f5197a, 256)) {
            this.i = eVar.i;
        }
        if (b(eVar.f5197a, (int) AdRequest.MAX_CONTENT_URL_LENGTH)) {
            this.k = eVar.k;
            this.j = eVar.j;
        }
        if (b(eVar.f5197a, 1024)) {
            this.l = eVar.l;
        }
        if (b(eVar.f5197a, 4096)) {
            this.s = eVar.s;
        }
        if (b(eVar.f5197a, 8192)) {
            this.o = eVar.o;
            this.p = 0;
            this.f5197a &= -16385;
        }
        if (b(eVar.f5197a, 16384)) {
            this.p = eVar.p;
            this.o = null;
            this.f5197a &= -8193;
        }
        if (b(eVar.f5197a, 32768)) {
            this.u = eVar.u;
        }
        if (b(eVar.f5197a, 65536)) {
            this.n = eVar.n;
        }
        if (b(eVar.f5197a, 131072)) {
            this.m = eVar.m;
        }
        if (b(eVar.f5197a, 2048)) {
            this.r.putAll(eVar.r);
            this.y = eVar.y;
        }
        if (b(eVar.f5197a, 524288)) {
            this.x = eVar.x;
        }
        if (!this.n) {
            this.r.clear();
            int i = this.f5197a & (-2049);
            this.f5197a = i;
            this.m = false;
            this.f5197a = i & (-131073);
            this.y = true;
        }
        this.f5197a |= eVar.f5197a;
        this.f5202q.a(eVar.f5202q);
        return G();
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            return Float.compare(eVar.f5198b, this.f5198b) == 0 && this.f == eVar.f && com.bumptech.glide.i.j.a(this.f5201e, eVar.f5201e) && this.h == eVar.h && com.bumptech.glide.i.j.a(this.g, eVar.g) && this.p == eVar.p && com.bumptech.glide.i.j.a(this.o, eVar.o) && this.i == eVar.i && this.j == eVar.j && this.k == eVar.k && this.m == eVar.m && this.n == eVar.n && this.w == eVar.w && this.x == eVar.x && this.f5199c.equals(eVar.f5199c) && this.f5200d == eVar.f5200d && this.f5202q.equals(eVar.f5202q) && this.r.equals(eVar.r) && this.s.equals(eVar.s) && com.bumptech.glide.i.j.a(this.l, eVar.l) && com.bumptech.glide.i.j.a(this.u, eVar.u);
        }
        return false;
    }

    public int hashCode() {
        return com.bumptech.glide.i.j.a(this.u, com.bumptech.glide.i.j.a(this.l, com.bumptech.glide.i.j.a(this.s, com.bumptech.glide.i.j.a(this.r, com.bumptech.glide.i.j.a(this.f5202q, com.bumptech.glide.i.j.a(this.f5200d, com.bumptech.glide.i.j.a(this.f5199c, com.bumptech.glide.i.j.a(this.x, com.bumptech.glide.i.j.a(this.w, com.bumptech.glide.i.j.a(this.n, com.bumptech.glide.i.j.a(this.m, com.bumptech.glide.i.j.b(this.k, com.bumptech.glide.i.j.b(this.j, com.bumptech.glide.i.j.a(this.i, com.bumptech.glide.i.j.a(this.o, com.bumptech.glide.i.j.b(this.p, com.bumptech.glide.i.j.a(this.g, com.bumptech.glide.i.j.b(this.h, com.bumptech.glide.i.j.a(this.f5201e, com.bumptech.glide.i.j.b(this.f, com.bumptech.glide.i.j.a(this.f5198b)))))))))))))))))))));
    }

    public e g() {
        this.t = true;
        return this;
    }

    public e h() {
        if (this.t && !this.v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.v = true;
        return g();
    }

    private e G() {
        if (this.t) {
            throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
        }
        return this;
    }

    public final Map<Class<?>, m<?>> i() {
        return this.r;
    }

    public final boolean j() {
        return this.m;
    }

    public final j k() {
        return this.f5202q;
    }

    public final Class<?> l() {
        return this.s;
    }

    public final i m() {
        return this.f5199c;
    }

    public final Drawable n() {
        return this.f5201e;
    }

    public final int o() {
        return this.f;
    }

    public final int p() {
        return this.h;
    }

    public final Drawable q() {
        return this.g;
    }

    public final int r() {
        return this.p;
    }

    public final Drawable s() {
        return this.o;
    }

    public final Resources.Theme t() {
        return this.u;
    }

    public final boolean u() {
        return this.i;
    }

    public final com.bumptech.glide.c.h v() {
        return this.l;
    }

    public final boolean w() {
        return a(8);
    }

    public final com.bumptech.glide.g x() {
        return this.f5200d;
    }

    public final int y() {
        return this.k;
    }

    public final boolean z() {
        return com.bumptech.glide.i.j.a(this.k, this.j);
    }

    public final int A() {
        return this.j;
    }

    public final float B() {
        return this.f5198b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        return this.y;
    }

    private boolean a(int i) {
        return b(this.f5197a, i);
    }

    public final boolean D() {
        return this.w;
    }

    public final boolean E() {
        return this.z;
    }

    public final boolean F() {
        return this.x;
    }
}

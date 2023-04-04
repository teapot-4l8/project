package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.c.b.b.a;
import com.bumptech.glide.c.b.b.i;
import com.bumptech.glide.d.l;
import java.util.Map;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    private com.bumptech.glide.c.b.j f5110b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.c.b.a.e f5111c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.c.b.a.b f5112d;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.c.b.b.h f5113e;
    private com.bumptech.glide.c.b.c.a f;
    private com.bumptech.glide.c.b.c.a g;
    private a.InterfaceC0086a h;
    private com.bumptech.glide.c.b.b.i i;
    private com.bumptech.glide.d.d j;
    private l.a m;
    private com.bumptech.glide.c.b.c.a n;
    private boolean o;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f5109a = new androidx.b.a();
    private int k = 4;
    private com.bumptech.glide.g.e l = new com.bumptech.glide.g.e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l.a aVar) {
        this.m = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(Context context) {
        if (this.f == null) {
            this.f = com.bumptech.glide.c.b.c.a.b();
        }
        if (this.g == null) {
            this.g = com.bumptech.glide.c.b.c.a.a();
        }
        if (this.n == null) {
            this.n = com.bumptech.glide.c.b.c.a.d();
        }
        if (this.i == null) {
            this.i = new i.a(context).a();
        }
        if (this.j == null) {
            this.j = new com.bumptech.glide.d.f();
        }
        if (this.f5111c == null) {
            int b2 = this.i.b();
            if (b2 > 0) {
                this.f5111c = new com.bumptech.glide.c.b.a.k(b2);
            } else {
                this.f5111c = new com.bumptech.glide.c.b.a.f();
            }
        }
        if (this.f5112d == null) {
            this.f5112d = new com.bumptech.glide.c.b.a.j(this.i.c());
        }
        if (this.f5113e == null) {
            this.f5113e = new com.bumptech.glide.c.b.b.g(this.i.a());
        }
        if (this.h == null) {
            this.h = new com.bumptech.glide.c.b.b.f(context);
        }
        if (this.f5110b == null) {
            this.f5110b = new com.bumptech.glide.c.b.j(this.f5113e, this.h, this.g, this.f, com.bumptech.glide.c.b.c.a.c(), com.bumptech.glide.c.b.c.a.d(), this.o);
        }
        return new c(context, this.f5110b, this.f5113e, this.f5111c, this.f5112d, new l(this.m), this.j, this.k, this.l.g(), this.f5109a);
    }
}

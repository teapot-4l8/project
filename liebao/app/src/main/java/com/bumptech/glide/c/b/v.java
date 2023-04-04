package com.bumptech.glide.c.b;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.b.e;
import com.bumptech.glide.c.c.n;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourceCacheGenerator.java */
/* loaded from: classes.dex */
public class v implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f4866a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f4867b;

    /* renamed from: c  reason: collision with root package name */
    private int f4868c;

    /* renamed from: d  reason: collision with root package name */
    private int f4869d = -1;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.c.h f4870e;
    private List<com.bumptech.glide.c.c.n<File, ?>> f;
    private int g;
    private volatile n.a<?> h;
    private File i;
    private w j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(f<?> fVar, e.a aVar) {
        this.f4867b = fVar;
        this.f4866a = aVar;
    }

    @Override // com.bumptech.glide.c.b.e
    public boolean a() {
        List<com.bumptech.glide.c.h> n = this.f4867b.n();
        boolean z = false;
        if (n.isEmpty()) {
            return false;
        }
        List<Class<?>> k = this.f4867b.k();
        if (k.isEmpty() && File.class.equals(this.f4867b.j())) {
            return false;
        }
        while (true) {
            if (this.f == null || !c()) {
                int i = this.f4869d + 1;
                this.f4869d = i;
                if (i >= k.size()) {
                    int i2 = this.f4868c + 1;
                    this.f4868c = i2;
                    if (i2 >= n.size()) {
                        return false;
                    }
                    this.f4869d = 0;
                }
                com.bumptech.glide.c.h hVar = n.get(this.f4868c);
                Class<?> cls = k.get(this.f4869d);
                this.j = new w(this.f4867b.i(), hVar, this.f4867b.f(), this.f4867b.g(), this.f4867b.h(), this.f4867b.c(cls), cls, this.f4867b.e());
                File a2 = this.f4867b.b().a(this.j);
                this.i = a2;
                if (a2 != null) {
                    this.f4870e = hVar;
                    this.f = this.f4867b.a(a2);
                    this.g = 0;
                }
            } else {
                this.h = null;
                while (!z && c()) {
                    List<com.bumptech.glide.c.c.n<File, ?>> list = this.f;
                    int i3 = this.g;
                    this.g = i3 + 1;
                    this.h = list.get(i3).a(this.i, this.f4867b.g(), this.f4867b.h(), this.f4867b.e());
                    if (this.h != null && this.f4867b.a(this.h.f4945c.a())) {
                        this.h.f4945c.a(this.f4867b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    private boolean c() {
        return this.g < this.f.size();
    }

    @Override // com.bumptech.glide.c.b.e
    public void b() {
        n.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.f4945c.c();
        }
    }

    @Override // com.bumptech.glide.c.a.d.a
    public void a(Object obj) {
        this.f4866a.a(this.f4870e, obj, this.h.f4945c, com.bumptech.glide.c.a.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.bumptech.glide.c.a.d.a
    public void a(Exception exc) {
        this.f4866a.a(this.j, exc, this.h.f4945c, com.bumptech.glide.c.a.RESOURCE_DISK_CACHE);
    }
}

package com.bumptech.glide.c.b;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.b.e;
import com.bumptech.glide.c.c.n;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataCacheGenerator.java */
/* loaded from: classes.dex */
public class b implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.bumptech.glide.c.h> f4715a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f4716b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f4717c;

    /* renamed from: d  reason: collision with root package name */
    private int f4718d;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.c.h f4719e;
    private List<com.bumptech.glide.c.c.n<File, ?>> f;
    private int g;
    private volatile n.a<?> h;
    private File i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(f<?> fVar, e.a aVar) {
        this(fVar.n(), fVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(List<com.bumptech.glide.c.h> list, f<?> fVar, e.a aVar) {
        this.f4718d = -1;
        this.f4715a = list;
        this.f4716b = fVar;
        this.f4717c = aVar;
    }

    @Override // com.bumptech.glide.c.b.e
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f == null || !c()) {
                int i = this.f4718d + 1;
                this.f4718d = i;
                if (i >= this.f4715a.size()) {
                    return false;
                }
                com.bumptech.glide.c.h hVar = this.f4715a.get(this.f4718d);
                File a2 = this.f4716b.b().a(new c(hVar, this.f4716b.f()));
                this.i = a2;
                if (a2 != null) {
                    this.f4719e = hVar;
                    this.f = this.f4716b.a(a2);
                    this.g = 0;
                }
            } else {
                this.h = null;
                while (!z && c()) {
                    List<com.bumptech.glide.c.c.n<File, ?>> list = this.f;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    this.h = list.get(i2).a(this.i, this.f4716b.g(), this.f4716b.h(), this.f4716b.e());
                    if (this.h != null && this.f4716b.a(this.h.f4945c.a())) {
                        this.h.f4945c.a(this.f4716b.d(), this);
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
        this.f4717c.a(this.f4719e, obj, this.h.f4945c, com.bumptech.glide.c.a.DATA_DISK_CACHE, this.f4719e);
    }

    @Override // com.bumptech.glide.c.a.d.a
    public void a(Exception exc) {
        this.f4717c.a(this.f4719e, exc, this.h.f4945c, com.bumptech.glide.c.a.DATA_DISK_CACHE);
    }
}

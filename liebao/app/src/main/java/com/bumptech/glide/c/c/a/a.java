package com.bumptech.glide.c.c.a;

import com.bumptech.glide.c.c.g;
import com.bumptech.glide.c.c.m;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.i;
import com.bumptech.glide.c.j;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader.java */
/* loaded from: classes.dex */
public class a implements n<g, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public static final i<Integer> f4889a = i.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: b  reason: collision with root package name */
    private final m<g, g> f4890b;

    @Override // com.bumptech.glide.c.c.n
    public boolean a(g gVar) {
        return true;
    }

    public a() {
        this(null);
    }

    public a(m<g, g> mVar) {
        this.f4890b = mVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<InputStream> a(g gVar, int i, int i2, j jVar) {
        m<g, g> mVar = this.f4890b;
        if (mVar != null) {
            g a2 = mVar.a(gVar, 0, 0);
            if (a2 == null) {
                this.f4890b.a(gVar, 0, 0, gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a<>(gVar, new com.bumptech.glide.c.a.j(gVar, ((Integer) jVar.a(f4889a)).intValue()));
    }

    /* compiled from: HttpGlideUrlLoader.java */
    /* renamed from: com.bumptech.glide.c.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0090a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f4891a = new m<>(500);

        @Override // com.bumptech.glide.c.c.o
        public n<g, InputStream> a(r rVar) {
            return new a(this.f4891a);
        }
    }
}

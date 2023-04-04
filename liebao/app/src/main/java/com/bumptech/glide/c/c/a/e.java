package com.bumptech.glide.c.c.a;

import com.bumptech.glide.c.c.g;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.j;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class e implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f4900a;

    @Override // com.bumptech.glide.c.c.n
    public boolean a(URL url) {
        return true;
    }

    public e(n<g, InputStream> nVar) {
        this.f4900a = nVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<InputStream> a(URL url, int i, int i2, j jVar) {
        return this.f4900a.a(new g(url), i, i2, jVar);
    }

    /* compiled from: UrlLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<URL, InputStream> {
        @Override // com.bumptech.glide.c.c.o
        public n<URL, InputStream> a(r rVar) {
            return new e(rVar.a(g.class, InputStream.class));
        }
    }
}

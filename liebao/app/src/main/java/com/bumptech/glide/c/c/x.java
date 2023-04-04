package com.bumptech.glide.c.c;

import android.net.Uri;
import com.bumptech.glide.c.c.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader.java */
/* loaded from: classes.dex */
public class x<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f4981a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: b  reason: collision with root package name */
    private final n<g, Data> f4982b;

    public x(n<g, Data> nVar) {
        this.f4982b = nVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Data> a(Uri uri, int i, int i2, com.bumptech.glide.c.j jVar) {
        return this.f4982b.a(new g(uri.toString()), i, i2, jVar);
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Uri uri) {
        return f4981a.contains(uri.getScheme());
    }

    /* compiled from: UrlUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.c.c.o
        public n<Uri, InputStream> a(r rVar) {
            return new x(rVar.a(g.class, InputStream.class));
        }
    }
}

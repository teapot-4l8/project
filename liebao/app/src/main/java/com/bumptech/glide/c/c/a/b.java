package com.bumptech.glide.c.c.a;

import android.net.Uri;
import com.bumptech.glide.c.c.g;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.j;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader.java */
/* loaded from: classes.dex */
public class b implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f4893a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: b  reason: collision with root package name */
    private final n<g, InputStream> f4894b;

    public b(n<g, InputStream> nVar) {
        this.f4894b = nVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<InputStream> a(Uri uri, int i, int i2, j jVar) {
        return this.f4894b.a(new g(uri.toString()), i, i2, jVar);
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Uri uri) {
        return f4893a.contains(uri.getScheme());
    }

    /* compiled from: HttpUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.c.c.o
        public n<Uri, InputStream> a(r rVar) {
            return new b(rVar.a(g.class, InputStream.class));
        }
    }
}

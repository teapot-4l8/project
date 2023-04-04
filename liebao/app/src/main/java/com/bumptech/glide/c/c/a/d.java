package com.bumptech.glide.c.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.d.a.w;
import com.bumptech.glide.c.j;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader.java */
/* loaded from: classes.dex */
public class d implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4898a;

    public d(Context context) {
        this.f4898a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<InputStream> a(Uri uri, int i, int i2, j jVar) {
        if (com.bumptech.glide.c.a.a.b.a(i, i2) && a(jVar)) {
            return new n.a<>(new com.bumptech.glide.h.b(uri), com.bumptech.glide.c.a.a.c.b(this.f4898a, uri));
        }
        return null;
    }

    private boolean a(j jVar) {
        Long l = (Long) jVar.a(w.f5041a);
        return l != null && l.longValue() == -1;
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Uri uri) {
        return com.bumptech.glide.c.a.a.b.b(uri);
    }

    /* compiled from: MediaStoreVideoThumbLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4899a;

        public a(Context context) {
            this.f4899a = context;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Uri, InputStream> a(r rVar) {
            return new d(this.f4899a);
        }
    }
}

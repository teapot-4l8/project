package com.bumptech.glide.c.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.j;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader.java */
/* loaded from: classes.dex */
public class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4896a;

    public c(Context context) {
        this.f4896a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<InputStream> a(Uri uri, int i, int i2, j jVar) {
        if (com.bumptech.glide.c.a.a.b.a(i, i2)) {
            return new n.a<>(new com.bumptech.glide.h.b(uri), com.bumptech.glide.c.a.a.c.a(this.f4896a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Uri uri) {
        return com.bumptech.glide.c.a.a.b.c(uri);
    }

    /* compiled from: MediaStoreImageThumbLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4897a;

        public a(Context context) {
            this.f4897a = context;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Uri, InputStream> a(r rVar) {
            return new c(this.f4897a);
        }
    }
}

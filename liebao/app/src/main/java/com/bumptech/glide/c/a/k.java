package com.bumptech.glide.c.a;

import com.bumptech.glide.c.a.e;
import com.bumptech.glide.c.d.a.r;
import java.io.InputStream;

/* compiled from: InputStreamRewinder.java */
/* loaded from: classes.dex */
public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final r f4660a;

    k(InputStream inputStream, com.bumptech.glide.c.b.a.b bVar) {
        r rVar = new r(inputStream, bVar);
        this.f4660a = rVar;
        rVar.mark(5242880);
    }

    @Override // com.bumptech.glide.c.a.e
    /* renamed from: c */
    public InputStream a() {
        this.f4660a.reset();
        return this.f4660a;
    }

    @Override // com.bumptech.glide.c.a.e
    public void b() {
        this.f4660a.b();
    }

    /* compiled from: InputStreamRewinder.java */
    /* loaded from: classes.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.c.b.a.b f4661a;

        public a(com.bumptech.glide.c.b.a.b bVar) {
            this.f4661a = bVar;
        }

        @Override // com.bumptech.glide.c.a.e.a
        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.f4661a);
        }

        @Override // com.bumptech.glide.c.a.e.a
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }
}

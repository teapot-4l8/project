package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.c.d.a.k;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class t implements com.bumptech.glide.c.k<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final k f5031a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.b f5032b;

    public t(k kVar, com.bumptech.glide.c.b.a.b bVar) {
        this.f5031a = kVar;
        this.f5032b = bVar;
    }

    @Override // com.bumptech.glide.c.k
    public boolean a(InputStream inputStream, com.bumptech.glide.c.j jVar) {
        return this.f5031a.a(inputStream);
    }

    @Override // com.bumptech.glide.c.k
    public com.bumptech.glide.c.b.u<Bitmap> a(InputStream inputStream, int i, int i2, com.bumptech.glide.c.j jVar) {
        r rVar;
        boolean z;
        if (inputStream instanceof r) {
            rVar = (r) inputStream;
            z = false;
        } else {
            rVar = new r(inputStream, this.f5032b);
            z = true;
        }
        com.bumptech.glide.i.d a2 = com.bumptech.glide.i.d.a(rVar);
        try {
            return this.f5031a.a(new com.bumptech.glide.i.g(a2), i, i2, jVar, new a(rVar, a2));
        } finally {
            a2.b();
            if (z) {
                rVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static class a implements k.a {

        /* renamed from: a  reason: collision with root package name */
        private final r f5033a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.i.d f5034b;

        a(r rVar, com.bumptech.glide.i.d dVar) {
            this.f5033a = rVar;
            this.f5034b = dVar;
        }

        @Override // com.bumptech.glide.c.d.a.k.a
        public void a() {
            this.f5033a.a();
        }

        @Override // com.bumptech.glide.c.d.a.k.a
        public void a(com.bumptech.glide.c.b.a.e eVar, Bitmap bitmap) {
            IOException a2 = this.f5034b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                }
                throw a2;
            }
        }
    }
}

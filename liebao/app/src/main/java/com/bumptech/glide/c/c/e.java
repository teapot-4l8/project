package com.bumptech.glide.c.c;

import android.util.Base64;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.c.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader.java */
/* loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f4907a;

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public interface a<Data> {
        Class<Data> a();

        Data a(String str);

        void a(Data data);
    }

    public e(a<Data> aVar) {
        this.f4907a = aVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Data> a(Model model, int i, int i2, com.bumptech.glide.c.j jVar) {
        return new n.a<>(new com.bumptech.glide.h.b(model), new b(model.toString(), this.f4907a));
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    private static final class b<Data> implements com.bumptech.glide.c.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f4908a;

        /* renamed from: b  reason: collision with root package name */
        private final a<Data> f4909b;

        /* renamed from: c  reason: collision with root package name */
        private Data f4910c;

        @Override // com.bumptech.glide.c.a.d
        public void c() {
        }

        b(String str, a<Data> aVar) {
            this.f4908a = str;
            this.f4909b = aVar;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.c.a.d
        public void a(com.bumptech.glide.g gVar, d.a<? super Data> aVar) {
            try {
                Data a2 = this.f4909b.a(this.f4908a);
                this.f4910c = a2;
                aVar.a((d.a<? super Data>) a2);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.c.a.d
        public void b() {
            try {
                this.f4909b.a((a<Data>) this.f4910c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.c.a.d
        public Class<Data> a() {
            return this.f4909b.a();
        }

        @Override // com.bumptech.glide.c.a.d
        public com.bumptech.glide.c.a d() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f4911a = new a<InputStream>() { // from class: com.bumptech.glide.c.c.e.c.1
            @Override // com.bumptech.glide.c.c.e.a
            /* renamed from: b */
            public InputStream a(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (!str.substring(0, indexOf).endsWith(";base64")) {
                    throw new IllegalArgumentException("Not a base64 image data URL.");
                }
                return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
            }

            @Override // com.bumptech.glide.c.c.e.a
            public void a(InputStream inputStream) {
                inputStream.close();
            }

            @Override // com.bumptech.glide.c.c.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }
        };

        @Override // com.bumptech.glide.c.c.o
        public n<Model, InputStream> a(r rVar) {
            return new e(this.f4911a);
        }
    }
}

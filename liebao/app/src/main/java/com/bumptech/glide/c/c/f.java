package com.bumptech.glide.c.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.c.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f4913a;

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public interface d<Data> {
        Class<Data> a();

        void a(Data data);

        Data b(File file);
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(File file) {
        return true;
    }

    public f(d<Data> dVar) {
        this.f4913a = dVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Data> a(File file, int i, int i2, com.bumptech.glide.c.j jVar) {
        return new n.a<>(new com.bumptech.glide.h.b(file), new c(file, this.f4913a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Data> implements com.bumptech.glide.c.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f4915a;

        /* renamed from: b  reason: collision with root package name */
        private final d<Data> f4916b;

        /* renamed from: c  reason: collision with root package name */
        private Data f4917c;

        @Override // com.bumptech.glide.c.a.d
        public void c() {
        }

        c(File file, d<Data> dVar) {
            this.f4915a = file;
            this.f4916b = dVar;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.c.a.d
        public void a(com.bumptech.glide.g gVar, d.a<? super Data> aVar) {
            try {
                Data b2 = this.f4916b.b(this.f4915a);
                this.f4917c = b2;
                aVar.a((d.a<? super Data>) b2);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.c.a.d
        public void b() {
            Data data = this.f4917c;
            if (data != null) {
                try {
                    this.f4916b.a(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.c.a.d
        public Class<Data> a() {
            return this.f4916b.a();
        }

        @Override // com.bumptech.glide.c.a.d
        public com.bumptech.glide.c.a d() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f4914a;

        public a(d<Data> dVar) {
            this.f4914a = dVar;
        }

        @Override // com.bumptech.glide.c.c.o
        public final n<File, Data> a(r rVar) {
            return new f(this.f4914a);
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class e extends a<InputStream> {
        public e() {
            super(new d<InputStream>() { // from class: com.bumptech.glide.c.c.f.e.1
                @Override // com.bumptech.glide.c.c.f.d
                /* renamed from: a */
                public InputStream b(File file) {
                    return new FileInputStream(file);
                }

                @Override // com.bumptech.glide.c.c.f.d
                public void a(InputStream inputStream) {
                    inputStream.close();
                }

                @Override // com.bumptech.glide.c.c.f.d
                public Class<InputStream> a() {
                    return InputStream.class;
                }
            });
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() { // from class: com.bumptech.glide.c.c.f.b.1
                @Override // com.bumptech.glide.c.c.f.d
                /* renamed from: a */
                public ParcelFileDescriptor b(File file) {
                    return ParcelFileDescriptor.open(file, 268435456);
                }

                @Override // com.bumptech.glide.c.c.f.d
                public void a(ParcelFileDescriptor parcelFileDescriptor) {
                    parcelFileDescriptor.close();
                }

                @Override // com.bumptech.glide.c.c.f.d
                public Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }
            });
        }
    }
}

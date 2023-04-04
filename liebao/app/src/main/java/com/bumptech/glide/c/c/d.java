package com.bumptech.glide.c.c;

import android.util.Log;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.c.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader.java */
/* loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {
    @Override // com.bumptech.glide.c.c.n
    public boolean a(File file) {
        return true;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<ByteBuffer> a(File file, int i, int i2, com.bumptech.glide.c.j jVar) {
        return new n.a<>(new com.bumptech.glide.h.b(file), new a(file));
    }

    /* compiled from: ByteBufferFileLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<File, ByteBuffer> {
        @Override // com.bumptech.glide.c.c.o
        public n<File, ByteBuffer> a(r rVar) {
            return new d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteBufferFileLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements com.bumptech.glide.c.a.d<ByteBuffer> {

        /* renamed from: a  reason: collision with root package name */
        private final File f4906a;

        @Override // com.bumptech.glide.c.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.c.a.d
        public void c() {
        }

        a(File file) {
            this.f4906a = file;
        }

        @Override // com.bumptech.glide.c.a.d
        public void a(com.bumptech.glide.g gVar, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a((d.a<? super ByteBuffer>) com.bumptech.glide.i.a.a(this.f4906a));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.c.a.d
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.c.a.d
        public com.bumptech.glide.c.a d() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }
}

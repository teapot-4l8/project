package com.bumptech.glide.c.c;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.c.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC0091b<Data> f4901a;

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0091b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(byte[] bArr) {
        return true;
    }

    public b(InterfaceC0091b<Data> interfaceC0091b) {
        this.f4901a = interfaceC0091b;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Data> a(byte[] bArr, int i, int i2, com.bumptech.glide.c.j jVar) {
        return new n.a<>(new com.bumptech.glide.h.b(bArr), new c(bArr, this.f4901a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class c<Data> implements com.bumptech.glide.c.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f4903a;

        /* renamed from: b  reason: collision with root package name */
        private final InterfaceC0091b<Data> f4904b;

        @Override // com.bumptech.glide.c.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.c.a.d
        public void c() {
        }

        c(byte[] bArr, InterfaceC0091b<Data> interfaceC0091b) {
            this.f4903a = bArr;
            this.f4904b = interfaceC0091b;
        }

        @Override // com.bumptech.glide.c.a.d
        public void a(com.bumptech.glide.g gVar, d.a<? super Data> aVar) {
            aVar.a((d.a<? super Data>) ((Data) this.f4904b.b(this.f4903a)));
        }

        @Override // com.bumptech.glide.c.a.d
        public Class<Data> a() {
            return this.f4904b.a();
        }

        @Override // com.bumptech.glide.c.a.d
        public com.bumptech.glide.c.a d() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<byte[], ByteBuffer> {
        @Override // com.bumptech.glide.c.c.o
        public n<byte[], ByteBuffer> a(r rVar) {
            return new b(new InterfaceC0091b<ByteBuffer>() { // from class: com.bumptech.glide.c.c.b.a.1
                @Override // com.bumptech.glide.c.c.b.InterfaceC0091b
                /* renamed from: a */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }

                @Override // com.bumptech.glide.c.c.b.InterfaceC0091b
                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }
            });
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class d implements o<byte[], InputStream> {
        @Override // com.bumptech.glide.c.c.o
        public n<byte[], InputStream> a(r rVar) {
            return new b(new InterfaceC0091b<InputStream>() { // from class: com.bumptech.glide.c.c.b.d.1
                @Override // com.bumptech.glide.c.c.b.InterfaceC0091b
                /* renamed from: a */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                @Override // com.bumptech.glide.c.c.b.InterfaceC0091b
                public Class<InputStream> a() {
                    return InputStream.class;
                }
            });
        }
    }
}

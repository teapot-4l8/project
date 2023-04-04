package com.bumptech.glide.c.d.b;

import com.bumptech.glide.c.a.e;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder.java */
/* loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f5049a;

    @Override // com.bumptech.glide.c.a.e
    public void b() {
    }

    public a(ByteBuffer byteBuffer) {
        this.f5049a = byteBuffer;
    }

    @Override // com.bumptech.glide.c.a.e
    /* renamed from: c */
    public ByteBuffer a() {
        this.f5049a.position(0);
        return this.f5049a;
    }

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: com.bumptech.glide.c.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0093a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.c.a.e.a
        public e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.bumptech.glide.c.a.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }
}

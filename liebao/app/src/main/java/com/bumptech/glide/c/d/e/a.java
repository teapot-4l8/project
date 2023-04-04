package com.bumptech.glide.c.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.k;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder.java */
/* loaded from: classes.dex */
public class a implements k<ByteBuffer, c> {

    /* renamed from: a  reason: collision with root package name */
    private static final C0094a f5054a = new C0094a();

    /* renamed from: b  reason: collision with root package name */
    private static final b f5055b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Context f5056c;

    /* renamed from: d  reason: collision with root package name */
    private final List<com.bumptech.glide.c.f> f5057d;

    /* renamed from: e  reason: collision with root package name */
    private final b f5058e;
    private final C0094a f;
    private final com.bumptech.glide.c.d.e.b g;

    public a(Context context, List<com.bumptech.glide.c.f> list, com.bumptech.glide.c.b.a.e eVar, com.bumptech.glide.c.b.a.b bVar) {
        this(context, list, eVar, bVar, f5055b, f5054a);
    }

    a(Context context, List<com.bumptech.glide.c.f> list, com.bumptech.glide.c.b.a.e eVar, com.bumptech.glide.c.b.a.b bVar, b bVar2, C0094a c0094a) {
        this.f5056c = context.getApplicationContext();
        this.f5057d = list;
        this.f = c0094a;
        this.g = new com.bumptech.glide.c.d.e.b(eVar, bVar);
        this.f5058e = bVar2;
    }

    @Override // com.bumptech.glide.c.k
    public boolean a(ByteBuffer byteBuffer, com.bumptech.glide.c.j jVar) {
        return !((Boolean) jVar.a(i.f5081b)).booleanValue() && com.bumptech.glide.c.g.a(this.f5057d, byteBuffer) == f.a.GIF;
    }

    @Override // com.bumptech.glide.c.k
    public e a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.c.j jVar) {
        com.bumptech.glide.b.d a2 = this.f5058e.a(byteBuffer);
        try {
            return a(byteBuffer, i, i2, a2, jVar);
        } finally {
            this.f5058e.a(a2);
        }
    }

    private e a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.b.d dVar, com.bumptech.glide.c.j jVar) {
        long a2 = com.bumptech.glide.i.e.a();
        try {
            com.bumptech.glide.b.c b2 = dVar.b();
            if (b2.c() > 0 && b2.d() == 0) {
                Bitmap.Config config = jVar.a(i.f5080a) == com.bumptech.glide.c.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                com.bumptech.glide.b.a a3 = this.f.a(this.g, b2, byteBuffer, a(b2, i, i2));
                a3.a(config);
                a3.b();
                Bitmap h = a3.h();
                if (h == null) {
                    return null;
                }
                e eVar = new e(new c(this.f5056c, a3, com.bumptech.glide.c.d.b.a(), i, i2, h));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.i.e.a(a2));
                }
                return eVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.i.e.a(a2));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.i.e.a(a2));
            }
        }
    }

    private static int a(com.bumptech.glide.b.c cVar, int i, int i2) {
        int min = Math.min(cVar.a() / i2, cVar.b() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + cVar.b() + "x" + cVar.a() + "]");
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    /* renamed from: com.bumptech.glide.c.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0094a {
        C0094a() {
        }

        com.bumptech.glide.b.a a(a.InterfaceC0084a interfaceC0084a, com.bumptech.glide.b.c cVar, ByteBuffer byteBuffer, int i) {
            return new com.bumptech.glide.b.e(interfaceC0084a, cVar, byteBuffer, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<com.bumptech.glide.b.d> f5059a = com.bumptech.glide.i.j.a(0);

        b() {
        }

        synchronized com.bumptech.glide.b.d a(ByteBuffer byteBuffer) {
            com.bumptech.glide.b.d poll;
            poll = this.f5059a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.b.d();
            }
            return poll.a(byteBuffer);
        }

        synchronized void a(com.bumptech.glide.b.d dVar) {
            dVar.a();
            this.f5059a.offer(dVar);
        }
    }
}

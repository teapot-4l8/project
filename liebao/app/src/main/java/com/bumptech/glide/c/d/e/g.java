package com.bumptech.glide.c.d.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.c.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    final com.bumptech.glide.j f5069a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.b.a f5070b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f5071c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f5072d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.e f5073e;
    private boolean f;
    private boolean g;
    private boolean h;
    private com.bumptech.glide.i<Bitmap> i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private m<Bitmap> n;
    private a o;
    private d p;

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        void f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.bumptech.glide.c cVar, com.bumptech.glide.b.a aVar, int i, int i2, m<Bitmap> mVar, Bitmap bitmap) {
        this(cVar.a(), com.bumptech.glide.c.b(cVar.c()), aVar, null, a(com.bumptech.glide.c.b(cVar.c()), i, i2), mVar, bitmap);
    }

    g(com.bumptech.glide.c.b.a.e eVar, com.bumptech.glide.j jVar, com.bumptech.glide.b.a aVar, Handler handler, com.bumptech.glide.i<Bitmap> iVar, m<Bitmap> mVar, Bitmap bitmap) {
        this.f5072d = new ArrayList();
        this.f5069a = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f5073e = eVar;
        this.f5071c = handler;
        this.i = iVar;
        this.f5070b = aVar;
        a(mVar, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(m<Bitmap> mVar, Bitmap bitmap) {
        this.n = (m) com.bumptech.glide.i.i.a(mVar);
        this.m = (Bitmap) com.bumptech.glide.i.i.a(bitmap);
        this.i = this.i.a(new com.bumptech.glide.g.e().a(mVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap a() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f5072d.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f5072d.isEmpty();
        this.f5072d.add(bVar);
        if (isEmpty) {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(b bVar) {
        this.f5072d.remove(bVar);
        if (this.f5072d.isEmpty()) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return i().getWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return i().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f5070b.g() + j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.f5074a;
        }
        return -1;
    }

    private int j() {
        return com.bumptech.glide.i.j.a(i().getWidth(), i().getHeight(), i().getConfig());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer f() {
        return this.f5070b.a().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f5070b.d();
    }

    private void k() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        m();
    }

    private void l() {
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f5072d.clear();
        n();
        l();
        a aVar = this.j;
        if (aVar != null) {
            this.f5069a.a(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f5069a.a(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f5069a.a(aVar3);
            this.o = null;
        }
        this.f5070b.i();
        this.k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap i() {
        a aVar = this.j;
        return aVar != null ? aVar.a() : this.m;
    }

    private void m() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            com.bumptech.glide.i.i.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.f5070b.f();
            this.h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            a(aVar);
            return;
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f5070b.c();
        this.f5070b.b();
        this.l = new a(this.f5071c, this.f5070b.e(), uptimeMillis);
        this.i.a(com.bumptech.glide.g.e.a(o())).a(this.f5070b).a((com.bumptech.glide.i<Bitmap>) this.l);
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f5073e.a(bitmap);
            this.m = null;
        }
    }

    void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.g = false;
        if (this.k) {
            this.f5071c.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f) {
            this.o = aVar;
        } else {
            if (aVar.a() != null) {
                n();
                a aVar2 = this.j;
                this.j = aVar;
                for (int size = this.f5072d.size() - 1; size >= 0; size--) {
                    this.f5072d.get(size).f();
                }
                if (aVar2 != null) {
                    this.f5071c.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            m();
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                g.this.a((a) message.obj);
                return true;
            } else if (message.what == 2) {
                g.this.f5069a.a((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class a extends com.bumptech.glide.g.a.f<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final int f5074a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f5075b;

        /* renamed from: c  reason: collision with root package name */
        private final long f5076c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap f5077d;

        @Override // com.bumptech.glide.g.a.h
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.g.b.b bVar) {
            a((Bitmap) obj, (com.bumptech.glide.g.b.b<? super Bitmap>) bVar);
        }

        a(Handler handler, int i, long j) {
            this.f5075b = handler;
            this.f5074a = i;
            this.f5076c = j;
        }

        Bitmap a() {
            return this.f5077d;
        }

        public void a(Bitmap bitmap, com.bumptech.glide.g.b.b<? super Bitmap> bVar) {
            this.f5077d = bitmap;
            this.f5075b.sendMessageAtTime(this.f5075b.obtainMessage(1, this), this.f5076c);
        }
    }

    private static com.bumptech.glide.i<Bitmap> a(com.bumptech.glide.j jVar, int i, int i2) {
        return jVar.f().a(com.bumptech.glide.g.e.a(com.bumptech.glide.c.b.i.f4810b).a(true).b(true).a(i, i2));
    }

    private static com.bumptech.glide.c.h o() {
        return new com.bumptech.glide.h.b(Double.valueOf(Math.random()));
    }
}

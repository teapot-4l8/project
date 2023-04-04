package com.bumptech.glide.c.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.bumptech.glide.c.b.o;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ActiveResources.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4671b;

    /* renamed from: d  reason: collision with root package name */
    private o.a f4673d;

    /* renamed from: e  reason: collision with root package name */
    private ReferenceQueue<o<?>> f4674e;
    private Thread f;
    private volatile boolean g;
    private volatile InterfaceC0085a h;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f4672c = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bumptech.glide.c.b.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                a.this.a((b) message.obj);
                return true;
            }
            return false;
        }
    });

    /* renamed from: a  reason: collision with root package name */
    final Map<com.bumptech.glide.c.h, b> f4670a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0085a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(boolean z) {
        this.f4671b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(o.a aVar) {
        this.f4673d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.c.h hVar, o<?> oVar) {
        b put = this.f4670a.put(hVar, new b(hVar, oVar, b(), this.f4671b));
        if (put != null) {
            put.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.c.h hVar) {
        b remove = this.f4670a.remove(hVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> b(com.bumptech.glide.c.h hVar) {
        b bVar = this.f4670a.get(hVar);
        if (bVar == null) {
            return null;
        }
        o<?> oVar = (o) bVar.get();
        if (oVar == null) {
            a(bVar);
        }
        return oVar;
    }

    void a(b bVar) {
        com.bumptech.glide.i.j.a();
        this.f4670a.remove(bVar.f4677a);
        if (!bVar.f4678b || bVar.f4679c == null) {
            return;
        }
        o<?> oVar = new o<>(bVar.f4679c, true, false);
        oVar.a(bVar.f4677a, this.f4673d);
        this.f4673d.a(bVar.f4677a, oVar);
    }

    private ReferenceQueue<o<?>> b() {
        if (this.f4674e == null) {
            this.f4674e = new ReferenceQueue<>();
            Thread thread = new Thread(new Runnable() { // from class: com.bumptech.glide.c.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    a.this.a();
                }
            }, "glide-active-resources");
            this.f = thread;
            thread.start();
        }
        return this.f4674e;
    }

    void a() {
        while (!this.g) {
            try {
                this.f4672c.obtainMessage(1, (b) this.f4674e.remove()).sendToTarget();
                InterfaceC0085a interfaceC0085a = this.h;
                if (interfaceC0085a != null) {
                    interfaceC0085a.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveResources.java */
    /* loaded from: classes.dex */
    public static final class b extends WeakReference<o<?>> {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.c.h f4677a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f4678b;

        /* renamed from: c  reason: collision with root package name */
        u<?> f4679c;

        b(com.bumptech.glide.c.h hVar, o<?> oVar, ReferenceQueue<? super o<?>> referenceQueue, boolean z) {
            super(oVar, referenceQueue);
            this.f4677a = (com.bumptech.glide.c.h) com.bumptech.glide.i.i.a(hVar);
            this.f4679c = (oVar.b() && z) ? (u) com.bumptech.glide.i.i.a(oVar.a()) : null;
            this.f4678b = oVar.b();
        }

        void a() {
            this.f4679c = null;
            clear();
        }
    }
}

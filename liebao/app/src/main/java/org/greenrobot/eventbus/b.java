package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundPoster.java */
/* loaded from: classes2.dex */
public final class b implements Runnable, l {

    /* renamed from: a  reason: collision with root package name */
    private final k f7787a = new k();

    /* renamed from: b  reason: collision with root package name */
    private final c f7788b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f7789c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f7788b = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        j a2 = j.a(qVar, obj);
        synchronized (this) {
            this.f7787a.a(a2);
            if (!this.f7789c) {
                this.f7789c = true;
                this.f7788b.b().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                j a2 = this.f7787a.a(1000);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f7787a.a();
                        if (a2 == null) {
                            return;
                        }
                    }
                }
                this.f7788b.a(a2);
            } catch (InterruptedException e2) {
                g c2 = this.f7788b.c();
                Level level = Level.WARNING;
                c2.a(level, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f7789c = false;
            }
        }
    }
}

package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.h;

/* compiled from: ServiceLifecycleDispatcher.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private final m f2041a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2042b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private a f2043c;

    public w(l lVar) {
        this.f2041a = new m(lVar);
    }

    private void a(h.a aVar) {
        a aVar2 = this.f2043c;
        if (aVar2 != null) {
            aVar2.run();
        }
        a aVar3 = new a(this.f2041a, aVar);
        this.f2043c = aVar3;
        this.f2042b.postAtFrontOfQueue(aVar3);
    }

    public void a() {
        a(h.a.ON_CREATE);
    }

    public void b() {
        a(h.a.ON_START);
    }

    public void c() {
        a(h.a.ON_START);
    }

    public void d() {
        a(h.a.ON_STOP);
        a(h.a.ON_DESTROY);
    }

    public h e() {
        return this.f2041a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServiceLifecycleDispatcher.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final h.a f2044a;

        /* renamed from: b  reason: collision with root package name */
        private final m f2045b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2046c = false;

        a(m mVar, h.a aVar) {
            this.f2045b = mVar;
            this.f2044a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2046c) {
                return;
            }
            this.f2045b.a(this.f2044a);
            this.f2046c = true;
        }
    }
}

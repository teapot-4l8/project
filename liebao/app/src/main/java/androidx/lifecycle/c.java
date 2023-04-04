package androidx.lifecycle;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ComputableLiveData.java */
/* loaded from: classes.dex */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    final Executor f2005a;

    /* renamed from: c  reason: collision with root package name */
    final AtomicBoolean f2007c = new AtomicBoolean(true);

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f2008d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    final Runnable f2009e = new Runnable() { // from class: androidx.lifecycle.c.2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            do {
                boolean z = false;
                if (c.this.f2008d.compareAndSet(false, true)) {
                    Object obj = null;
                    boolean z2 = false;
                    while (c.this.f2007c.compareAndSet(true, false)) {
                        try {
                            obj = c.this.c();
                            z2 = true;
                        } catch (Throwable th) {
                            c.this.f2008d.set(false);
                            throw th;
                        }
                    }
                    if (z2) {
                        c.this.f2006b.a((LiveData<T>) obj);
                    }
                    c.this.f2008d.set(false);
                    z = z2;
                }
                if (!z) {
                    return;
                }
            } while (c.this.f2007c.get());
        }
    };
    final Runnable f = new Runnable() { // from class: androidx.lifecycle.c.3
        @Override // java.lang.Runnable
        public void run() {
            boolean d2 = c.this.f2006b.d();
            if (c.this.f2007c.compareAndSet(false, true) && d2) {
                c.this.f2005a.execute(c.this.f2009e);
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    final LiveData<T> f2006b = new LiveData<T>() { // from class: androidx.lifecycle.c.1
        @Override // androidx.lifecycle.LiveData
        protected void a() {
            c.this.f2005a.execute(c.this.f2009e);
        }
    };

    protected abstract T c();

    public c(Executor executor) {
        this.f2005a = executor;
    }

    public LiveData<T> a() {
        return this.f2006b;
    }

    public void b() {
        androidx.a.a.a.a.a().c(this.f);
    }
}

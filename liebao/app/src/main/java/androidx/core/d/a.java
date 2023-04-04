package androidx.core.d;

import android.os.Build;
import android.os.CancellationSignal;

/* compiled from: CancellationSignal.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1500a;

    /* renamed from: b  reason: collision with root package name */
    private InterfaceC0033a f1501b;

    /* renamed from: c  reason: collision with root package name */
    private Object f1502c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1503d;

    /* compiled from: CancellationSignal.java */
    /* renamed from: androidx.core.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0033a {
        void a();
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = this.f1500a;
        }
        return z;
    }

    public void b() {
        if (a()) {
            throw new c();
        }
    }

    public void c() {
        synchronized (this) {
            if (this.f1500a) {
                return;
            }
            this.f1500a = true;
            this.f1503d = true;
            InterfaceC0033a interfaceC0033a = this.f1501b;
            Object obj = this.f1502c;
            if (interfaceC0033a != null) {
                try {
                    interfaceC0033a.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f1503d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f1503d = false;
                notifyAll();
            }
        }
    }

    public Object d() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f1502c == null) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                this.f1502c = cancellationSignal;
                if (this.f1500a) {
                    cancellationSignal.cancel();
                }
            }
            obj = this.f1502c;
        }
        return obj;
    }
}

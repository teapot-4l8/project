package b.b.e.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RxThreadFactory.java */
/* loaded from: classes.dex */
public final class g extends AtomicLong implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final String f3446a;

    /* renamed from: b  reason: collision with root package name */
    final int f3447b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f3448c;

    public g(String str) {
        this(str, 5, false);
    }

    public g(String str, int i) {
        this(str, i, false);
    }

    public g(String str, int i, boolean z) {
        this.f3446a = str;
        this.f3447b = i;
        this.f3448c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f3446a + '-' + incrementAndGet();
        Thread aVar = this.f3448c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f3447b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f3446a + "]";
    }

    /* compiled from: RxThreadFactory.java */
    /* loaded from: classes.dex */
    static final class a extends Thread {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }
}

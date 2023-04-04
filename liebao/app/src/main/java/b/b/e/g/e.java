package b.b.e.g;

import b.b.i;
import java.util.concurrent.ThreadFactory;

/* compiled from: NewThreadScheduler.java */
/* loaded from: classes.dex */
public final class e extends b.b.i {

    /* renamed from: c  reason: collision with root package name */
    private static final g f3442c = new g("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f3443b;

    public e() {
        this(f3442c);
    }

    public e(ThreadFactory threadFactory) {
        this.f3443b = threadFactory;
    }

    @Override // b.b.i
    public i.c a() {
        return new f(this.f3443b);
    }
}

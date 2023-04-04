package b.b.e.h;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AtomicThrowable.java */
/* loaded from: classes.dex */
public final class b extends AtomicReference<Throwable> {
    public boolean a(Throwable th) {
        return c.a(this, th);
    }

    public Throwable a() {
        return c.a(this);
    }
}

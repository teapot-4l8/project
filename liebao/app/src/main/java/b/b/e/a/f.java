package b.b.e.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequentialDisposable.java */
/* loaded from: classes.dex */
public final class f extends AtomicReference<b.b.b.b> implements b.b.b.b {
    public f() {
    }

    public f(b.b.b.b bVar) {
        lazySet(bVar);
    }

    public boolean a(b.b.b.b bVar) {
        return b.b(this, bVar);
    }

    @Override // b.b.b.b
    public void a() {
        b.a((AtomicReference<b.b.b.b>) this);
    }

    public boolean b() {
        return b.a(get());
    }
}

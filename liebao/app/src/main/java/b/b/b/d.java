package b.b.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReferenceDisposable.java */
/* loaded from: classes.dex */
abstract class d<T> extends AtomicReference<T> implements b {
    protected abstract void a(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(T t) {
        super(b.b.e.b.b.a((Object) t, "value is null"));
    }

    @Override // b.b.b.b
    public final void a() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    public final boolean b() {
        return get() == null;
    }
}

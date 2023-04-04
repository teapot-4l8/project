package androidx.work.impl.utils.a;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: SettableFuture.java */
/* loaded from: classes.dex */
public final class c<V> extends a<V> {
    public static <V> c<V> d() {
        return new c<>();
    }

    @Override // androidx.work.impl.utils.a.a
    public boolean a(V v) {
        return super.a((c<V>) v);
    }

    @Override // androidx.work.impl.utils.a.a
    public boolean a(Throwable th) {
        return super.a(th);
    }

    @Override // androidx.work.impl.utils.a.a
    public boolean a(ListenableFuture<? extends V> listenableFuture) {
        return super.a((ListenableFuture) listenableFuture);
    }

    private c() {
    }
}

package kotlin.g;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequencesJVM.kt */
/* loaded from: classes2.dex */
public final class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<b<T>> f7184a;

    public a(b<? extends T> bVar) {
        kotlin.d.b.i.b(bVar, "sequence");
        this.f7184a = new AtomicReference<>(bVar);
    }

    @Override // kotlin.g.b
    public Iterator<T> a() {
        b<T> andSet = this.f7184a.getAndSet(null);
        if (andSet == null) {
            throw new IllegalStateException("This sequence can be consumed only once.");
        }
        return andSet.a();
    }
}

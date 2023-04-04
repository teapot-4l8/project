package kotlin.a;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* loaded from: classes2.dex */
public abstract class u implements Iterator<Integer> {
    public abstract int b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public final Integer next() {
        return Integer.valueOf(b());
    }
}

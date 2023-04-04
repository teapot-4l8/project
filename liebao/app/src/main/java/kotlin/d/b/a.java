package kotlin.d.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes2.dex */
final class a<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f7149a;

    /* renamed from: b  reason: collision with root package name */
    private final T[] f7150b;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public a(T[] tArr) {
        i.b(tArr, "array");
        this.f7150b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7149a < this.f7150b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f7150b;
            int i = this.f7149a;
            this.f7149a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f7149a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}

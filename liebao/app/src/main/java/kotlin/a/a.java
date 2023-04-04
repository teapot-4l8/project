package kotlin.a;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
/* loaded from: classes2.dex */
public final class a<T> implements Collection<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f7140a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7141b;

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) kotlin.d.b.f.a(this, tArr);
    }

    public a(T[] tArr, boolean z) {
        kotlin.d.b.i.b(tArr, "values");
        this.f7140a = tArr;
        this.f7141b = z;
    }

    @Override // java.util.Collection
    public final int size() {
        return a();
    }

    public int a() {
        return this.f7140a.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f7140a.length == 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return b.a(this.f7140a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        kotlin.d.b.i.b(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return kotlin.d.b.b.a(this.f7140a);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return h.a(this.f7140a, this.f7141b);
    }
}

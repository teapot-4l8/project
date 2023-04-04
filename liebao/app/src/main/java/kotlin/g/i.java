package kotlin.g;

import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class i<T, R> implements b<R> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f7186a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.d.a.b<T, R> f7187b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Iterator<R> {

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<T> f7189b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a() {
            this.f7189b = i.this.f7186a.a();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) i.this.f7187b.a(this.f7189b.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7189b.hasNext();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(b<? extends T> bVar, kotlin.d.a.b<? super T, ? extends R> bVar2) {
        kotlin.d.b.i.b(bVar, "sequence");
        kotlin.d.b.i.b(bVar2, "transformer");
        this.f7186a = bVar;
        this.f7187b = bVar2;
    }

    @Override // kotlin.g.b
    public Iterator<R> a() {
        return new a();
    }
}

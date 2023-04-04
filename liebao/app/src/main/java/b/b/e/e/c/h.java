package b.b.e.e.c;

import b.b.e.e.c.n;

/* compiled from: ObservableJust.java */
/* loaded from: classes.dex */
public final class h<T> extends b.b.e<T> implements b.b.e.c.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f3339a;

    public h(T t) {
        this.f3339a = t;
    }

    @Override // b.b.e
    protected void b(b.b.h<? super T> hVar) {
        n.a aVar = new n.a(hVar, this.f3339a);
        hVar.a(aVar);
        aVar.run();
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return this.f3339a;
    }
}

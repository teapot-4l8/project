package kotlin;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes2.dex */
public final class g<T> implements Serializable, b<T> {

    /* renamed from: a  reason: collision with root package name */
    private kotlin.d.a.a<? extends T> f7181a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f7182b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f7183c;

    public g(kotlin.d.a.a<? extends T> aVar, Object obj) {
        kotlin.d.b.i.b(aVar, "initializer");
        this.f7181a = aVar;
        this.f7182b = j.f7209a;
        this.f7183c = obj == null ? this : obj;
    }

    public /* synthetic */ g(kotlin.d.a.a aVar, Object obj, int i, kotlin.d.b.g gVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }

    @Override // kotlin.b
    public T a() {
        T t;
        T t2 = (T) this.f7182b;
        if (t2 != j.f7209a) {
            return t2;
        }
        synchronized (this.f7183c) {
            t = (T) this.f7182b;
            if (t == j.f7209a) {
                kotlin.d.a.a<? extends T> aVar = this.f7181a;
                if (aVar == null) {
                    kotlin.d.b.i.a();
                }
                t = aVar.a();
                this.f7182b = t;
                this.f7181a = null;
            }
        }
        return t;
    }

    public boolean b() {
        return this.f7182b != j.f7209a;
    }

    public String toString() {
        return b() ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}

package b.b;

import b.b.e.e.c.k;
import b.b.e.e.c.l;
import b.b.e.e.c.o;
import b.b.e.e.c.p;
import b.b.e.e.c.q;
import b.b.e.e.c.r;
import b.b.e.e.c.s;
import b.b.e.e.c.t;
import java.util.concurrent.TimeUnit;

/* compiled from: Observable.java */
/* loaded from: classes.dex */
public abstract class e<T> implements f<T> {
    protected abstract void b(h<? super T> hVar);

    public static int a() {
        return c.a();
    }

    public static <T, R> e<R> a(b.b.d.e<? super Object[], ? extends R> eVar, int i, f<? extends T>... fVarArr) {
        return a(fVarArr, eVar, i);
    }

    public static <T, R> e<R> a(f<? extends T>[] fVarArr, b.b.d.e<? super Object[], ? extends R> eVar, int i) {
        b.b.e.b.b.a(fVarArr, "sources is null");
        if (fVarArr.length == 0) {
            return c();
        }
        b.b.e.b.b.a(eVar, "combiner is null");
        b.b.e.b.b.a(i, "bufferSize");
        return b.b.g.a.a(new b.b.e.e.c.b(fVarArr, null, eVar, i << 1, false));
    }

    public static <T1, T2, R> e<R> a(f<? extends T1> fVar, f<? extends T2> fVar2, b.b.d.b<? super T1, ? super T2, ? extends R> bVar) {
        b.b.e.b.b.a(fVar, "source1 is null");
        b.b.e.b.b.a(fVar2, "source2 is null");
        return a(b.b.e.b.a.a(bVar), a(), fVar, fVar2);
    }

    public static <T> e<T> c() {
        return b.b.g.a.a(b.b.e.e.c.c.f3329a);
    }

    public static e<Long> a(long j, long j2, TimeUnit timeUnit) {
        return a(j, j2, timeUnit, b.b.h.a.a());
    }

    public static e<Long> a(long j, long j2, TimeUnit timeUnit, i iVar) {
        b.b.e.b.b.a(timeUnit, "unit is null");
        b.b.e.b.b.a(iVar, "scheduler is null");
        return b.b.g.a.a(new b.b.e.e.c.g(Math.max(0L, j), Math.max(0L, j2), timeUnit, iVar));
    }

    public static e<Long> a(long j, TimeUnit timeUnit) {
        return a(j, j, timeUnit, b.b.h.a.a());
    }

    public static <T> e<T> b(T t) {
        b.b.e.b.b.a((Object) t, "The item is null");
        return b.b.g.a.a((e) new b.b.e.e.c.h(t));
    }

    public static <T> e<T> a(f<T> fVar) {
        b.b.e.b.b.a(fVar, "source is null");
        if (fVar instanceof e) {
            return b.b.g.a.a((e) fVar);
        }
        return b.b.g.a.a(new b.b.e.e.c.e(fVar));
    }

    public final <R> e<R> a(g<? super T, ? extends R> gVar) {
        return a(((g) b.b.e.b.b.a(gVar, "composer is null")).a(this));
    }

    public final e<T> a(b.b.d.g<? super T> gVar) {
        b.b.e.b.b.a(gVar, "predicate is null");
        return b.b.g.a.a(new b.b.e.e.c.d(this, gVar));
    }

    public final b d() {
        return b.b.g.a.a(new b.b.e.e.c.f(this));
    }

    public final <R> e<R> a(b.b.d.e<? super T, ? extends R> eVar) {
        b.b.e.b.b.a(eVar, "mapper is null");
        return b.b.g.a.a(new b.b.e.e.c.i(this, eVar));
    }

    public final e<T> a(i iVar) {
        return a(iVar, false, a());
    }

    public final e<T> a(i iVar, boolean z, int i) {
        b.b.e.b.b.a(iVar, "scheduler is null");
        b.b.e.b.b.a(i, "bufferSize");
        return b.b.g.a.a(new b.b.e.e.c.j(this, iVar, z, i));
    }

    public final e<T> b(b.b.d.e<? super Throwable, ? extends T> eVar) {
        b.b.e.b.b.a(eVar, "valueSupplier is null");
        return b.b.g.a.a(new k(this, eVar));
    }

    public final b.b.f.a<T> e() {
        return l.c(this);
    }

    public final e<T> f() {
        return e().b();
    }

    public final d<T> g() {
        return b.b.g.a.a(new o(this));
    }

    public final j<T> h() {
        return b.b.g.a.a(new p(this, null));
    }

    public final e<T> a(long j) {
        if (j <= 0) {
            return b.b.g.a.a(this);
        }
        return b.b.g.a.a(new q(this, j));
    }

    @Override // b.b.f
    public final void a(h<? super T> hVar) {
        b.b.e.b.b.a(hVar, "observer is null");
        try {
            h<? super T> a2 = b.b.g.a.a(this, hVar);
            b.b.e.b.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b((h) a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            b.b.c.b.b(th);
            b.b.g.a.a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final e<T> b(i iVar) {
        b.b.e.b.b.a(iVar, "scheduler is null");
        return b.b.g.a.a(new r(this, iVar));
    }

    public final e<T> b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j);
        }
        return b.b.g.a.a(new s(this, j));
    }

    public final <U> e<T> b(f<U> fVar) {
        b.b.e.b.b.a(fVar, "other is null");
        return b.b.g.a.a(new t(this, fVar));
    }

    public final c<T> a(a aVar) {
        b.b.e.e.b.b bVar = new b.b.e.e.b.b(this);
        int i = AnonymousClass1.f3289a[aVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return b.b.g.a.a(new b.b.e.e.b.e(bVar));
                    }
                    return bVar.b();
                }
                return bVar;
            }
            return bVar.d();
        }
        return bVar.c();
    }

    /* compiled from: Observable.java */
    /* renamed from: b.b.e$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3289a;

        static {
            int[] iArr = new int[a.values().length];
            f3289a = iArr;
            try {
                iArr[a.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3289a[a.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3289a[a.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3289a[a.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}

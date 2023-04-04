package b.b.g;

import b.b.b;
import b.b.c;
import b.b.c.f;
import b.b.d.d;
import b.b.d.e;
import b.b.h;
import b.b.i;
import b.b.j;
import java.util.concurrent.Callable;

/* compiled from: RxJavaPlugins.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile d<? super Throwable> f3494a;

    /* renamed from: b  reason: collision with root package name */
    static volatile e<? super Runnable, ? extends Runnable> f3495b;

    /* renamed from: c  reason: collision with root package name */
    static volatile e<? super Callable<i>, ? extends i> f3496c;

    /* renamed from: d  reason: collision with root package name */
    static volatile e<? super Callable<i>, ? extends i> f3497d;

    /* renamed from: e  reason: collision with root package name */
    static volatile e<? super Callable<i>, ? extends i> f3498e;
    static volatile e<? super Callable<i>, ? extends i> f;
    static volatile e<? super i, ? extends i> g;
    static volatile e<? super i, ? extends i> h;
    static volatile e<? super i, ? extends i> i;
    static volatile e<? super c, ? extends c> j;
    static volatile e<? super b.b.e, ? extends b.b.e> k;
    static volatile e<? super b.b.f.a, ? extends b.b.f.a> l;
    static volatile e<? super b.b.d, ? extends b.b.d> m;
    static volatile e<? super j, ? extends j> n;
    static volatile e<? super b, ? extends b> o;
    static volatile b.b.d.b<? super b.b.e, ? super h, ? extends h> p;

    public static i a(Callable<i> callable) {
        b.b.e.b.b.a(callable, "Scheduler Callable can't be null");
        e<? super Callable<i>, ? extends i> eVar = f3496c;
        if (eVar == null) {
            return e(callable);
        }
        return a(eVar, callable);
    }

    public static i b(Callable<i> callable) {
        b.b.e.b.b.a(callable, "Scheduler Callable can't be null");
        e<? super Callable<i>, ? extends i> eVar = f3498e;
        if (eVar == null) {
            return e(callable);
        }
        return a(eVar, callable);
    }

    public static i c(Callable<i> callable) {
        b.b.e.b.b.a(callable, "Scheduler Callable can't be null");
        e<? super Callable<i>, ? extends i> eVar = f;
        if (eVar == null) {
            return e(callable);
        }
        return a(eVar, callable);
    }

    public static i d(Callable<i> callable) {
        b.b.e.b.b.a(callable, "Scheduler Callable can't be null");
        e<? super Callable<i>, ? extends i> eVar = f3497d;
        if (eVar == null) {
            return e(callable);
        }
        return a(eVar, callable);
    }

    public static i a(i iVar) {
        e<? super i, ? extends i> eVar = g;
        return eVar == null ? iVar : (i) a((e<i, Object>) eVar, iVar);
    }

    public static void a(Throwable th) {
        d<? super Throwable> dVar = f3494a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!b(th)) {
            th = new f(th);
        }
        if (dVar != null) {
            try {
                dVar.a(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static boolean b(Throwable th) {
        return (th instanceof b.b.c.d) || (th instanceof b.b.c.c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof b.b.c.a);
    }

    static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static i b(i iVar) {
        e<? super i, ? extends i> eVar = h;
        return eVar == null ? iVar : (i) a((e<i, Object>) eVar, iVar);
    }

    public static i c(i iVar) {
        e<? super i, ? extends i> eVar = i;
        return eVar == null ? iVar : (i) a((e<i, Object>) eVar, iVar);
    }

    public static Runnable a(Runnable runnable) {
        b.b.e.b.b.a(runnable, "run is null");
        e<? super Runnable, ? extends Runnable> eVar = f3495b;
        return eVar == null ? runnable : (Runnable) a((e<Runnable, Object>) eVar, runnable);
    }

    public static <T> h<? super T> a(b.b.e<T> eVar, h<? super T> hVar) {
        b.b.d.b<? super b.b.e, ? super h, ? extends h> bVar = p;
        return bVar != null ? (h) a(bVar, eVar, hVar) : hVar;
    }

    public static <T> b.b.d<T> a(b.b.d<T> dVar) {
        e<? super b.b.d, ? extends b.b.d> eVar = m;
        return eVar != null ? (b.b.d) a((e<b.b.d<T>, Object>) eVar, dVar) : dVar;
    }

    public static <T> c<T> a(c<T> cVar) {
        e<? super c, ? extends c> eVar = j;
        return eVar != null ? (c) a((e<c<T>, Object>) eVar, cVar) : cVar;
    }

    public static <T> b.b.e<T> a(b.b.e<T> eVar) {
        e<? super b.b.e, ? extends b.b.e> eVar2 = k;
        return eVar2 != null ? (b.b.e) a((e<b.b.e<T>, Object>) eVar2, eVar) : eVar;
    }

    public static <T> b.b.f.a<T> a(b.b.f.a<T> aVar) {
        e<? super b.b.f.a, ? extends b.b.f.a> eVar = l;
        return eVar != null ? (b.b.f.a) a((e<b.b.f.a<T>, Object>) eVar, aVar) : aVar;
    }

    public static <T> j<T> a(j<T> jVar) {
        e<? super j, ? extends j> eVar = n;
        return eVar != null ? (j) a((e<j<T>, Object>) eVar, jVar) : jVar;
    }

    public static b a(b bVar) {
        e<? super b, ? extends b> eVar = o;
        return eVar != null ? (b) a((e<b, Object>) eVar, bVar) : bVar;
    }

    static <T, R> R a(e<T, R> eVar, T t) {
        try {
            return eVar.a(t);
        } catch (Throwable th) {
            throw b.b.e.h.c.a(th);
        }
    }

    static <T, U, R> R a(b.b.d.b<T, U, R> bVar, T t, U u) {
        try {
            return bVar.b(t, u);
        } catch (Throwable th) {
            throw b.b.e.h.c.a(th);
        }
    }

    static i e(Callable<i> callable) {
        try {
            return (i) b.b.e.b.b.a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw b.b.e.h.c.a(th);
        }
    }

    static i a(e<? super Callable<i>, ? extends i> eVar, Callable<i> callable) {
        return (i) b.b.e.b.b.a(a((e<Callable<i>, Object>) eVar, callable), "Scheduler Callable result can't be null");
    }
}

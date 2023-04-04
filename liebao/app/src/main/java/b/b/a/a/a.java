package b.b.a.a;

import b.b.c.b;
import b.b.d.e;
import b.b.i;
import java.util.concurrent.Callable;

/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e<Callable<i>, i> f3269a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile e<i, i> f3270b;

    public static i a(Callable<i> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        e<Callable<i>, i> eVar = f3269a;
        if (eVar == null) {
            return b(callable);
        }
        return a(eVar, callable);
    }

    public static i a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        e<i, i> eVar = f3270b;
        return eVar == null ? iVar : (i) a(eVar, iVar);
    }

    static i b(Callable<i> callable) {
        try {
            i call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    static i a(e<Callable<i>, i> eVar, Callable<i> callable) {
        i iVar = (i) a((e<Callable<i>, Object>) eVar, callable);
        if (iVar != null) {
            return iVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static <T, R> R a(e<T, R> eVar, T t) {
        try {
            return eVar.a(t);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }
}

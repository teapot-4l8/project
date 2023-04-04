package b.b.e.h;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ExceptionHelper.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f3485a = new a();

    public static RuntimeException a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        }
        return new RuntimeException(th);
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == f3485a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new b.b.c.a(th2, th)));
        return true;
    }

    public static <T> Throwable a(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f3485a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    /* compiled from: ExceptionHelper.java */
    /* loaded from: classes.dex */
    static final class a extends Throwable {
        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        a() {
            super("No further exceptions");
        }
    }
}

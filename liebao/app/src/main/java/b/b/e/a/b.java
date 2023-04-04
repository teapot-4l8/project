package b.b.e.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableHelper.java */
/* loaded from: classes.dex */
public enum b implements b.b.b.b {
    DISPOSED;

    @Override // b.b.b.b
    public void a() {
    }

    public static boolean a(b.b.b.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean a(AtomicReference<b.b.b.b> atomicReference, b.b.b.b bVar) {
        b.b.e.b.b.a(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.a();
        if (atomicReference.get() != DISPOSED) {
            b();
            return false;
        }
        return false;
    }

    public static boolean b(AtomicReference<b.b.b.b> atomicReference, b.b.b.b bVar) {
        b.b.b.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.a();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static boolean a(AtomicReference<b.b.b.b> atomicReference) {
        b.b.b.b andSet;
        b.b.b.b bVar = atomicReference.get();
        b bVar2 = DISPOSED;
        if (bVar == bVar2 || (andSet = atomicReference.getAndSet(bVar2)) == bVar2) {
            return false;
        }
        if (andSet != null) {
            andSet.a();
            return true;
        }
        return true;
    }

    public static boolean a(b.b.b.b bVar, b.b.b.b bVar2) {
        if (bVar2 == null) {
            b.b.g.a.a(new NullPointerException("next is null"));
            return false;
        } else if (bVar != null) {
            bVar2.a();
            b();
            return false;
        } else {
            return true;
        }
    }

    public static void b() {
        b.b.g.a.a(new b.b.c.e("Disposable already set!"));
    }
}

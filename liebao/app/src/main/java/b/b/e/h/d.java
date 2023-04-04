package b.b.e.h;

import b.b.h;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HalfSerializer.java */
/* loaded from: classes.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(h<? super T> hVar, T t, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            hVar.a_(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable a2 = bVar.a();
                if (a2 != null) {
                    hVar.a(a2);
                } else {
                    hVar.b();
                }
            }
        }
    }

    public static void a(h<?> hVar, Throwable th, AtomicInteger atomicInteger, b bVar) {
        if (bVar.a(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                hVar.a(bVar.a());
                return;
            }
            return;
        }
        b.b.g.a.a(th);
    }

    public static void a(h<?> hVar, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable a2 = bVar.a();
            if (a2 != null) {
                hVar.a(a2);
            } else {
                hVar.b();
            }
        }
    }
}

package b.b.c;

/* compiled from: Exceptions.java */
/* loaded from: classes.dex */
public final class b {
    public static RuntimeException a(Throwable th) {
        throw b.b.e.h.c.a(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}

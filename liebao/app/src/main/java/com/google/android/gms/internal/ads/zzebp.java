package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
abstract class zzebp<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zzids = new zzebq();
    private static final Runnable zzidt = new zzebq();
    private static final Runnable zzidu = new zzebq();

    abstract boolean isDone();

    abstract void zzb(@NullableDecl T t, @NullableDecl Throwable th);

    abstract T zzbba();

    abstract String zzbbb();

    @Override // java.lang.Runnable
    public final void run() {
        T zzbba;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !isDone();
            if (z) {
                try {
                    zzbba = zzbba();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zzids)) {
                        Runnable runnable = get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            if (runnable != zzidt && runnable != zzidu) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable2 = zzidu;
                                if (runnable == runnable2 || compareAndSet(zzidt, runnable2)) {
                                    z2 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        zzb(null, th);
                        return;
                    }
                    return;
                }
            } else {
                zzbba = null;
            }
            if (!compareAndSet(currentThread, zzids)) {
                Runnable runnable3 = get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    if (runnable3 != zzidt && runnable3 != zzidu) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable4 = zzidu;
                        if (runnable3 == runnable4 || compareAndSet(zzidt, runnable4)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable3 = get();
                }
                if (z3) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                zzb(zzbba, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void interruptTask() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, zzidt)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (getAndSet(zzids) == zzidu) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == zzids) {
            str = "running=[DONE]";
        } else if (runnable == zzidt) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String zzbbb = zzbbb();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(zzbbb).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(zzbbb);
        return sb2.toString();
    }
}

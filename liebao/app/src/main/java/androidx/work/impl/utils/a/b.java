package androidx.work.impl.utils.a;

import java.util.concurrent.Executor;

/* compiled from: DirectExecutor.java */
/* loaded from: classes.dex */
enum b implements Executor {
    INSTANCE;

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}

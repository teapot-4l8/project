package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: TransactionExecutor.java */
/* loaded from: classes.dex */
class o implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f2482a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<Runnable> f2483b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f2484c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Executor executor) {
        this.f2482a = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.f2483b.offer(new Runnable() { // from class: androidx.room.o.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    o.this.a();
                }
            }
        });
        if (this.f2484c == null) {
            a();
        }
    }

    synchronized void a() {
        Runnable poll = this.f2483b.poll();
        this.f2484c = poll;
        if (poll != null) {
            this.f2482a.execute(poll);
        }
    }
}

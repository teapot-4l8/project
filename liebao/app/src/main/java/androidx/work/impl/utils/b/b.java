package androidx.work.impl.utils.b;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.f;
import java.util.concurrent.Executor;

/* compiled from: WorkManagerTaskExecutor.java */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3035a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3036b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Executor f3037c = new Executor() { // from class: androidx.work.impl.utils.b.b.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b.this.b(runnable);
        }
    };

    public b(Executor executor) {
        this.f3035a = new f(executor);
    }

    public void b(Runnable runnable) {
        this.f3036b.post(runnable);
    }

    @Override // androidx.work.impl.utils.b.a
    public Executor a() {
        return this.f3037c;
    }

    @Override // androidx.work.impl.utils.b.a
    public void a(Runnable runnable) {
        this.f3035a.execute(runnable);
    }

    @Override // androidx.work.impl.utils.b.a
    public Executor b() {
        return this.f3035a;
    }
}

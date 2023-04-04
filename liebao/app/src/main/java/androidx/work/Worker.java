package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    androidx.work.impl.utils.a.c<ListenableWorker.a> mFuture;

    public abstract ListenableWorker.a doWork();

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ListenableWorker.a> startWork() {
        this.mFuture = androidx.work.impl.utils.a.c.d();
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.Worker.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Worker.this.mFuture.a((androidx.work.impl.utils.a.c<ListenableWorker.a>) Worker.this.doWork());
                } catch (Throwable th) {
                    Worker.this.mFuture.a(th);
                }
            }
        });
        return this.mFuture;
    }
}

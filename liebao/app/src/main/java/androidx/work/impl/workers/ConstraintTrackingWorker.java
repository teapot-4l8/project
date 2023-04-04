package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.a.c;
import androidx.work.impl.a.d;
import androidx.work.impl.b.j;
import androidx.work.impl.utils.b.a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: d  reason: collision with root package name */
    private static final String f3059d = h.a("ConstraintTrkngWrkr");

    /* renamed from: a  reason: collision with root package name */
    final Object f3060a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f3061b;

    /* renamed from: c  reason: collision with root package name */
    androidx.work.impl.utils.a.c<ListenableWorker.a> f3062c;

    /* renamed from: e  reason: collision with root package name */
    private WorkerParameters f3063e;
    private ListenableWorker f;

    @Override // androidx.work.impl.a.c
    public void a(List<String> list) {
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f3063e = workerParameters;
        this.f3060a = new Object();
        this.f3061b = false;
        this.f3062c = androidx.work.impl.utils.a.c.d();
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.a> startWork() {
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.1
            @Override // java.lang.Runnable
            public void run() {
                ConstraintTrackingWorker.this.a();
            }
        });
        return this.f3062c;
    }

    void a() {
        String a2 = getInputData().a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(a2)) {
            h.a().e(f3059d, "No worker to delegate to.", new Throwable[0]);
            b();
            return;
        }
        ListenableWorker b2 = getWorkerFactory().b(getApplicationContext(), a2, this.f3063e);
        this.f = b2;
        if (b2 == null) {
            h.a().b(f3059d, "No worker to delegate to.", new Throwable[0]);
            b();
            return;
        }
        j b3 = d().p().b(getId().toString());
        if (b3 == null) {
            b();
            return;
        }
        d dVar = new d(getApplicationContext(), getTaskExecutor(), this);
        dVar.a(Collections.singletonList(b3));
        if (dVar.a(getId().toString())) {
            h.a().b(f3059d, String.format("Constraints met for delegate %s", a2), new Throwable[0]);
            try {
                final ListenableFuture<ListenableWorker.a> startWork = this.f.startWork();
                startWork.addListener(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (ConstraintTrackingWorker.this.f3060a) {
                            if (ConstraintTrackingWorker.this.f3061b) {
                                ConstraintTrackingWorker.this.c();
                            } else {
                                ConstraintTrackingWorker.this.f3062c.a(startWork);
                            }
                        }
                    }
                }, getBackgroundExecutor());
                return;
            } catch (Throwable th) {
                h.a().b(f3059d, String.format("Delegated worker %s threw exception in startWork.", a2), th);
                synchronized (this.f3060a) {
                    if (this.f3061b) {
                        h.a().b(f3059d, "Constraints were unmet, Retrying.", new Throwable[0]);
                        c();
                    } else {
                        b();
                    }
                    return;
                }
            }
        }
        h.a().b(f3059d, String.format("Constraints not met for delegate %s. Requesting retry.", a2), new Throwable[0]);
        c();
    }

    void b() {
        this.f3062c.a((androidx.work.impl.utils.a.c<ListenableWorker.a>) ListenableWorker.a.c());
    }

    void c() {
        this.f3062c.a((androidx.work.impl.utils.a.c<ListenableWorker.a>) ListenableWorker.a.b());
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f;
        if (listenableWorker != null) {
            listenableWorker.stop();
        }
    }

    public WorkDatabase d() {
        return androidx.work.impl.h.b(getApplicationContext()).c();
    }

    @Override // androidx.work.ListenableWorker
    public a getTaskExecutor() {
        return androidx.work.impl.h.b(getApplicationContext()).g();
    }

    @Override // androidx.work.impl.a.c
    public void b(List<String> list) {
        h.a().b(f3059d, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f3060a) {
            this.f3061b = true;
        }
    }
}

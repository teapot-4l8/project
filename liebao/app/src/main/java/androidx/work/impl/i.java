package androidx.work.impl;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.m;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: WorkerWrapper.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final String f2978a = androidx.work.h.a("WorkerWrapper");

    /* renamed from: b  reason: collision with root package name */
    j f2979b;

    /* renamed from: c  reason: collision with root package name */
    ListenableWorker f2980c;
    private Context f;
    private String g;
    private List<d> h;
    private WorkerParameters.a i;
    private androidx.work.b j;
    private androidx.work.impl.utils.b.a k;
    private WorkDatabase l;
    private k m;
    private androidx.work.impl.b.b n;
    private n o;
    private List<String> p;

    /* renamed from: q  reason: collision with root package name */
    private String f2983q;
    private volatile boolean s;

    /* renamed from: d  reason: collision with root package name */
    ListenableWorker.a f2981d = ListenableWorker.a.c();
    private androidx.work.impl.utils.a.c<Boolean> r = androidx.work.impl.utils.a.c.d();

    /* renamed from: e  reason: collision with root package name */
    ListenableFuture<ListenableWorker.a> f2982e = null;

    i(a aVar) {
        this.f = aVar.f2989a;
        this.k = aVar.f2991c;
        this.g = aVar.f;
        this.h = aVar.g;
        this.i = aVar.h;
        this.f2980c = aVar.f2990b;
        this.j = aVar.f2992d;
        WorkDatabase workDatabase = aVar.f2993e;
        this.l = workDatabase;
        this.m = workDatabase.p();
        this.n = this.l.q();
        this.o = this.l.r();
    }

    public ListenableFuture<Boolean> a() {
        return this.r;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> a2 = this.o.a(this.g);
        this.p = a2;
        this.f2983q = a(a2);
        d();
    }

    private void d() {
        androidx.work.e a2;
        if (f()) {
            return;
        }
        this.l.g();
        try {
            j b2 = this.m.b(this.g);
            this.f2979b = b2;
            if (b2 == null) {
                androidx.work.h.a().e(f2978a, String.format("Didn't find WorkSpec for id %s", this.g), new Throwable[0]);
                b(false);
            } else if (b2.f2865b != m.a.ENQUEUED) {
                e();
                this.l.j();
                androidx.work.h.a().b(f2978a, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f2979b.f2866c), new Throwable[0]);
            } else {
                if (this.f2979b.a() || this.f2979b.b()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!(this.f2979b.n == 0) && currentTimeMillis < this.f2979b.c()) {
                        androidx.work.h.a().b(f2978a, String.format("Delaying execution for %s because it is being executed before schedule.", this.f2979b.f2866c), new Throwable[0]);
                        b(true);
                        return;
                    }
                }
                this.l.j();
                this.l.h();
                if (this.f2979b.a()) {
                    a2 = this.f2979b.f2868e;
                } else {
                    androidx.work.g a3 = androidx.work.g.a(this.f2979b.f2867d);
                    if (a3 == null) {
                        androidx.work.h.a().e(f2978a, String.format("Could not create Input Merger %s", this.f2979b.f2867d), new Throwable[0]);
                        c();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f2979b.f2868e);
                    arrayList.addAll(this.m.g(this.g));
                    a2 = a3.a(arrayList);
                }
                WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.g), a2, this.p, this.i, this.f2979b.k, this.j.a(), this.k, this.j.c());
                if (this.f2980c == null) {
                    this.f2980c = this.j.c().b(this.f, this.f2979b.f2866c, workerParameters);
                }
                ListenableWorker listenableWorker = this.f2980c;
                if (listenableWorker == null) {
                    androidx.work.h.a().e(f2978a, String.format("Could not create Worker %s", this.f2979b.f2866c), new Throwable[0]);
                    c();
                } else if (listenableWorker.isUsed()) {
                    androidx.work.h.a().e(f2978a, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f2979b.f2866c), new Throwable[0]);
                    c();
                } else {
                    this.f2980c.setUsed();
                    if (!g()) {
                        e();
                    } else if (f()) {
                    } else {
                        final androidx.work.impl.utils.a.c d2 = androidx.work.impl.utils.a.c.d();
                        this.k.a().execute(new Runnable() { // from class: androidx.work.impl.i.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    androidx.work.h.a().b(i.f2978a, String.format("Starting work for %s", i.this.f2979b.f2866c), new Throwable[0]);
                                    i.this.f2982e = i.this.f2980c.startWork();
                                    d2.a((ListenableFuture) i.this.f2982e);
                                } catch (Throwable th) {
                                    d2.a(th);
                                }
                            }
                        });
                        final String str = this.f2983q;
                        d2.addListener(new Runnable() { // from class: androidx.work.impl.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        ListenableWorker.a aVar = (ListenableWorker.a) d2.get();
                                        if (aVar == null) {
                                            androidx.work.h.a().e(i.f2978a, String.format("%s returned a null result. Treating it as a failure.", i.this.f2979b.f2866c), new Throwable[0]);
                                        } else {
                                            androidx.work.h.a().b(i.f2978a, String.format("%s returned a %s result.", i.this.f2979b.f2866c, aVar), new Throwable[0]);
                                            i.this.f2981d = aVar;
                                        }
                                    } catch (InterruptedException e2) {
                                        e = e2;
                                        androidx.work.h.a().e(i.f2978a, String.format("%s failed because it threw an exception/error", str), e);
                                    } catch (CancellationException e3) {
                                        androidx.work.h.a().c(i.f2978a, String.format("%s was cancelled", str), e3);
                                    } catch (ExecutionException e4) {
                                        e = e4;
                                        androidx.work.h.a().e(i.f2978a, String.format("%s failed because it threw an exception/error", str), e);
                                    }
                                } finally {
                                    i.this.b();
                                }
                            }
                        }, this.k.b());
                    }
                }
            }
        } finally {
            this.l.h();
        }
    }

    void b() {
        boolean z = false;
        if (!f()) {
            this.l.g();
            try {
                m.a f = this.m.f(this.g);
                if (f == null) {
                    b(false);
                    z = true;
                } else if (f == m.a.RUNNING) {
                    a(this.f2981d);
                    z = this.m.f(this.g).a();
                } else if (!f.a()) {
                    h();
                }
                this.l.j();
            } finally {
                this.l.h();
            }
        }
        List<d> list = this.h;
        if (list != null) {
            if (z) {
                for (d dVar : list) {
                    dVar.a(this.g);
                }
            }
            e.a(this.j, this.l, this.h);
        }
    }

    public void a(boolean z) {
        this.s = true;
        f();
        ListenableFuture<ListenableWorker.a> listenableFuture = this.f2982e;
        if (listenableFuture != null) {
            listenableFuture.cancel(true);
        }
        ListenableWorker listenableWorker = this.f2980c;
        if (listenableWorker != null) {
            listenableWorker.stop();
        }
    }

    private void e() {
        m.a f = this.m.f(this.g);
        if (f == m.a.RUNNING) {
            androidx.work.h.a().b(f2978a, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.g), new Throwable[0]);
            b(true);
            return;
        }
        androidx.work.h.a().b(f2978a, String.format("Status for %s is %s; not doing any work", this.g, f), new Throwable[0]);
        b(false);
    }

    private boolean f() {
        if (this.s) {
            androidx.work.h.a().b(f2978a, String.format("Work interrupted for %s", this.f2983q), new Throwable[0]);
            m.a f = this.m.f(this.g);
            if (f == null) {
                b(false);
            } else {
                b(!f.a());
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:3:0x0005, B:5:0x0012, B:11:0x001e, B:12:0x0025), top: B:18:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(boolean z) {
        boolean z2;
        this.l.g();
        try {
            List<String> a2 = this.l.p().a();
            if (a2 != null && !a2.isEmpty()) {
                z2 = false;
                if (z2) {
                    androidx.work.impl.utils.d.a(this.f, RescheduleReceiver.class, false);
                }
                this.l.j();
                this.l.h();
                this.r.a((androidx.work.impl.utils.a.c<Boolean>) Boolean.valueOf(z));
            }
            z2 = true;
            if (z2) {
            }
            this.l.j();
            this.l.h();
            this.r.a((androidx.work.impl.utils.a.c<Boolean>) Boolean.valueOf(z));
        } catch (Throwable th) {
            this.l.h();
            throw th;
        }
    }

    private void a(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            androidx.work.h.a().c(f2978a, String.format("Worker result SUCCESS for %s", this.f2983q), new Throwable[0]);
            if (this.f2979b.a()) {
                i();
            } else {
                j();
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            androidx.work.h.a().c(f2978a, String.format("Worker result RETRY for %s", this.f2983q), new Throwable[0]);
            h();
        } else {
            androidx.work.h.a().c(f2978a, String.format("Worker result FAILURE for %s", this.f2983q), new Throwable[0]);
            if (this.f2979b.a()) {
                i();
            } else {
                c();
            }
        }
    }

    private boolean g() {
        this.l.g();
        try {
            boolean z = true;
            if (this.m.f(this.g) == m.a.ENQUEUED) {
                this.m.a(m.a.RUNNING, this.g);
                this.m.d(this.g);
            } else {
                z = false;
            }
            this.l.j();
            return z;
        } finally {
            this.l.h();
        }
    }

    void c() {
        this.l.g();
        try {
            a(this.g);
            this.m.a(this.g, ((ListenableWorker.a.C0060a) this.f2981d).d());
            this.l.j();
        } finally {
            this.l.h();
            b(false);
        }
    }

    private void a(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.m.f(str2) != m.a.CANCELLED) {
                this.m.a(m.a.FAILED, str2);
            }
            linkedList.addAll(this.n.b(str2));
        }
    }

    private void h() {
        this.l.g();
        try {
            this.m.a(m.a.ENQUEUED, this.g);
            this.m.a(this.g, System.currentTimeMillis());
            this.m.b(this.g, -1L);
            this.l.j();
        } finally {
            this.l.h();
            b(true);
        }
    }

    private void i() {
        this.l.g();
        try {
            this.m.a(this.g, System.currentTimeMillis());
            this.m.a(m.a.ENQUEUED, this.g);
            this.m.e(this.g);
            this.m.b(this.g, -1L);
            this.l.j();
        } finally {
            this.l.h();
            b(false);
        }
    }

    private void j() {
        this.l.g();
        try {
            this.m.a(m.a.SUCCEEDED, this.g);
            this.m.a(this.g, ((ListenableWorker.a.c) this.f2981d).d());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.n.b(this.g)) {
                if (this.m.f(str) == m.a.BLOCKED && this.n.a(str)) {
                    androidx.work.h.a().c(f2978a, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.m.a(m.a.ENQUEUED, str);
                    this.m.a(str, currentTimeMillis);
                }
            }
            this.l.j();
        } finally {
            this.l.h();
            b(false);
        }
    }

    private String a(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.g);
        sb.append(", tags={ ");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    /* compiled from: WorkerWrapper.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Context f2989a;

        /* renamed from: b  reason: collision with root package name */
        ListenableWorker f2990b;

        /* renamed from: c  reason: collision with root package name */
        androidx.work.impl.utils.b.a f2991c;

        /* renamed from: d  reason: collision with root package name */
        androidx.work.b f2992d;

        /* renamed from: e  reason: collision with root package name */
        WorkDatabase f2993e;
        String f;
        List<d> g;
        WorkerParameters.a h = new WorkerParameters.a();

        public a(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar, WorkDatabase workDatabase, String str) {
            this.f2989a = context.getApplicationContext();
            this.f2991c = aVar;
            this.f2992d = bVar;
            this.f2993e = workDatabase;
            this.f = str;
        }

        public a a(List<d> list) {
            this.g = list;
            return this;
        }

        public a a(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.h = aVar;
            }
            return this;
        }

        public i a() {
            return new i(this);
        }
    }
}

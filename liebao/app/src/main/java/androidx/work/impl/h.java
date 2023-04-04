package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.R;
import androidx.work.WorkerParameters;
import androidx.work.b;
import androidx.work.h;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.k;
import androidx.work.n;
import androidx.work.o;
import java.util.Arrays;
import java.util.List;

/* compiled from: WorkManagerImpl.java */
/* loaded from: classes.dex */
public class h extends n {
    private static h j;
    private static h k;
    private static final Object l = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f2973a;

    /* renamed from: b  reason: collision with root package name */
    private androidx.work.b f2974b;

    /* renamed from: c  reason: collision with root package name */
    private WorkDatabase f2975c;

    /* renamed from: d  reason: collision with root package name */
    private androidx.work.impl.utils.b.a f2976d;

    /* renamed from: e  reason: collision with root package name */
    private List<d> f2977e;
    private c f;
    private androidx.work.impl.utils.e g;
    private boolean h;
    private BroadcastReceiver.PendingResult i;

    @Deprecated
    public static h a() {
        synchronized (l) {
            if (j != null) {
                return j;
            }
            return k;
        }
    }

    public static h b(Context context) {
        h a2;
        synchronized (l) {
            a2 = a();
            if (a2 == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof b.InterfaceC0061b) {
                    b(applicationContext, ((b.InterfaceC0061b) applicationContext).a());
                    a2 = b(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return a2;
    }

    public static void b(Context context, androidx.work.b bVar) {
        synchronized (l) {
            if (j != null && k != null) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class levelJavadoc for more information.");
            }
            if (j == null) {
                Context applicationContext = context.getApplicationContext();
                if (k == null) {
                    k = new h(applicationContext, bVar, new androidx.work.impl.utils.b.b(bVar.b()));
                }
                j = k;
            }
        }
    }

    public h(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar) {
        this(context, bVar, aVar, context.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    public h(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar, boolean z) {
        Context applicationContext = context.getApplicationContext();
        WorkDatabase a2 = WorkDatabase.a(applicationContext, bVar.b(), z);
        androidx.work.h.a(new h.a(bVar.d()));
        List<d> a3 = a(applicationContext, aVar);
        a(context, bVar, aVar, a2, a3, new c(context, bVar, aVar, a2, a3));
    }

    public Context b() {
        return this.f2973a;
    }

    public WorkDatabase c() {
        return this.f2975c;
    }

    public androidx.work.b d() {
        return this.f2974b;
    }

    public List<d> e() {
        return this.f2977e;
    }

    public c f() {
        return this.f;
    }

    public androidx.work.impl.utils.b.a g() {
        return this.f2976d;
    }

    public androidx.work.impl.utils.e h() {
        return this.g;
    }

    @Override // androidx.work.n
    public k a(List<? extends o> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new f(this, list).i();
    }

    @Override // androidx.work.n
    public k a(String str) {
        androidx.work.impl.utils.a a2 = androidx.work.impl.utils.a.a(str, this);
        this.f2976d.a(a2);
        return a2.a();
    }

    public void b(String str) {
        a(str, (WorkerParameters.a) null);
    }

    public void a(String str, WorkerParameters.a aVar) {
        this.f2976d.a(new androidx.work.impl.utils.g(this, str, aVar));
    }

    public void c(String str) {
        this.f2976d.a(new androidx.work.impl.utils.h(this, str));
    }

    public void i() {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b.a(b());
        }
        c().p().b();
        e.a(d(), c(), e());
    }

    public void j() {
        synchronized (l) {
            this.h = true;
            if (this.i != null) {
                this.i.finish();
                this.i = null;
            }
        }
    }

    public void a(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (l) {
            this.i = pendingResult;
            if (this.h) {
                pendingResult.finish();
                this.i = null;
            }
        }
    }

    private void a(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar, WorkDatabase workDatabase, List<d> list, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2973a = applicationContext;
        this.f2974b = bVar;
        this.f2976d = aVar;
        this.f2975c = workDatabase;
        this.f2977e = list;
        this.f = cVar;
        this.g = new androidx.work.impl.utils.e(applicationContext);
        this.h = false;
        this.f2976d.a(new ForceStopRunnable(applicationContext, this));
    }

    public List<d> a(Context context, androidx.work.impl.utils.b.a aVar) {
        return Arrays.asList(e.a(context, this), new androidx.work.impl.background.a.a(context, aVar, this));
    }
}

package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.d;
import androidx.work.impl.utils.c;
import androidx.work.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: SystemJobScheduler.java */
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2950a = h.a("SystemJobScheduler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f2951b;

    /* renamed from: c  reason: collision with root package name */
    private final JobScheduler f2952c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.work.impl.h f2953d;

    /* renamed from: e  reason: collision with root package name */
    private final c f2954e;
    private final a f;

    public b(Context context, androidx.work.impl.h hVar) {
        this(context, hVar, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    public b(Context context, androidx.work.impl.h hVar, JobScheduler jobScheduler, a aVar) {
        this.f2951b = context;
        this.f2953d = hVar;
        this.f2952c = jobScheduler;
        this.f2954e = new c(context);
        this.f = aVar;
    }

    @Override // androidx.work.impl.d
    public void a(j... jVarArr) {
        List<Integer> a2;
        int a3;
        WorkDatabase c2 = this.f2953d.c();
        for (j jVar : jVarArr) {
            c2.g();
            try {
                j b2 = c2.p().b(jVar.f2864a);
                if (b2 == null) {
                    h.a().d(f2950a, "Skipping scheduling " + jVar.f2864a + " because it's no longer in the DB", new Throwable[0]);
                    c2.j();
                } else if (b2.f2865b != m.a.ENQUEUED) {
                    h.a().d(f2950a, "Skipping scheduling " + jVar.f2864a + " because it is no longer enqueued", new Throwable[0]);
                    c2.j();
                } else {
                    androidx.work.impl.b.d a4 = c2.s().a(jVar.f2864a);
                    int a5 = a4 != null ? a4.f2852b : this.f2954e.a(this.f2953d.d().e(), this.f2953d.d().f());
                    if (a4 == null) {
                        this.f2953d.c().s().a(new androidx.work.impl.b.d(jVar.f2864a, a5));
                    }
                    a(jVar, a5);
                    if (Build.VERSION.SDK_INT == 23 && (a2 = a(this.f2951b, this.f2952c, jVar.f2864a)) != null) {
                        int indexOf = a2.indexOf(Integer.valueOf(a5));
                        if (indexOf >= 0) {
                            a2.remove(indexOf);
                        }
                        if (!a2.isEmpty()) {
                            a3 = a2.get(0).intValue();
                        } else {
                            a3 = this.f2954e.a(this.f2953d.d().e(), this.f2953d.d().f());
                        }
                        a(jVar, a3);
                    }
                    c2.j();
                }
                c2.h();
            } catch (Throwable th) {
                c2.h();
                throw th;
            }
        }
    }

    public void a(j jVar, int i) {
        JobInfo a2 = this.f.a(jVar, i);
        h.a().b(f2950a, String.format("Scheduling work ID %s Job ID %s", jVar.f2864a, Integer.valueOf(i)), new Throwable[0]);
        try {
            this.f2952c.schedule(a2);
        } catch (IllegalStateException e2) {
            List<JobInfo> a3 = a(this.f2951b, this.f2952c);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(a3 != null ? a3.size() : 0), Integer.valueOf(this.f2953d.c().p().c().size()), Integer.valueOf(this.f2953d.d().g()));
            h.a().e(f2950a, format, new Throwable[0]);
            throw new IllegalStateException(format, e2);
        } catch (Throwable th) {
            h.a().e(f2950a, String.format("Unable to schedule %s", jVar), th);
        }
    }

    @Override // androidx.work.impl.d
    public void a(String str) {
        List<Integer> a2 = a(this.f2951b, this.f2952c, str);
        if (a2 == null || a2.isEmpty()) {
            return;
        }
        for (Integer num : a2) {
            a(this.f2952c, num.intValue());
        }
        this.f2953d.c().s().b(str);
    }

    private static void a(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            h.a().e(f2950a, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static void a(Context context) {
        List<JobInfo> a2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (a2 = a(context, jobScheduler)) == null || a2.isEmpty()) {
            return;
        }
        for (JobInfo jobInfo : a2) {
            a(jobScheduler, jobInfo.getId());
        }
    }

    public static void b(Context context) {
        List<JobInfo> a2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (a2 = a(context, jobScheduler)) == null || a2.isEmpty()) {
            return;
        }
        for (JobInfo jobInfo : a2) {
            PersistableBundle extras = jobInfo.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                a(jobScheduler, jobInfo.getId());
            }
        }
    }

    private static List<JobInfo> a(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            h.a().e(f2950a, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static List<Integer> a(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> a2 = a(context, jobScheduler);
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : a2) {
            PersistableBundle extras = jobInfo.getExtras();
            if (extras != null && extras.containsKey("EXTRA_WORK_SPEC_ID") && str.equals(extras.getString("EXTRA_WORK_SPEC_ID"))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }
}

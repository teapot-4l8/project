package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import androidx.work.h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements androidx.work.impl.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2944a = h.a("SystemJobService");

    /* renamed from: b  reason: collision with root package name */
    private androidx.work.impl.h f2945b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, JobParameters> f2946c = new HashMap();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            androidx.work.impl.h b2 = androidx.work.impl.h.b(getApplicationContext());
            this.f2945b = b2;
            b2.f().a(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            h.a().d(f2944a, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        androidx.work.impl.h hVar = this.f2945b;
        if (hVar != null) {
            hVar.f().b(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.f2945b == null) {
            h.a().b(f2944a, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        PersistableBundle extras = jobParameters.getExtras();
        if (extras == null) {
            h.a().e(f2944a, "No extras in JobParameters.", new Throwable[0]);
            return false;
        }
        String string = extras.getString("EXTRA_WORK_SPEC_ID");
        if (TextUtils.isEmpty(string)) {
            h.a().e(f2944a, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.f2946c) {
            if (this.f2946c.containsKey(string)) {
                h.a().b(f2944a, String.format("Job is already being executed by SystemJobService: %s", string), new Throwable[0]);
                return false;
            }
            h.a().b(f2944a, String.format("onStartJob for %s", string), new Throwable[0]);
            this.f2946c.put(string, jobParameters);
            WorkerParameters.a aVar = null;
            if (Build.VERSION.SDK_INT >= 24) {
                aVar = new WorkerParameters.a();
                if (jobParameters.getTriggeredContentUris() != null) {
                    aVar.f2759b = Arrays.asList(jobParameters.getTriggeredContentUris());
                }
                if (jobParameters.getTriggeredContentAuthorities() != null) {
                    aVar.f2758a = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    aVar.f2760c = jobParameters.getNetwork();
                }
            }
            this.f2945b.a(string, aVar);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f2945b == null) {
            h.a().b(f2944a, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        PersistableBundle extras = jobParameters.getExtras();
        if (extras == null) {
            h.a().e(f2944a, "No extras in JobParameters.", new Throwable[0]);
            return false;
        }
        String string = extras.getString("EXTRA_WORK_SPEC_ID");
        if (TextUtils.isEmpty(string)) {
            h.a().e(f2944a, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        h.a().b(f2944a, String.format("onStopJob for %s", string), new Throwable[0]);
        synchronized (this.f2946c) {
            this.f2946c.remove(string);
        }
        this.f2945b.c(string);
        return !this.f2945b.f().d(string);
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        JobParameters remove;
        h.a().b(f2944a, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.f2946c) {
            remove = this.f2946c.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }
}

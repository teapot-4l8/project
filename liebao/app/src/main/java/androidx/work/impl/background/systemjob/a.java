package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.c;
import androidx.work.d;
import androidx.work.h;
import androidx.work.i;
import androidx.work.impl.b.j;

/* compiled from: SystemJobInfoConverter.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2947a = h.a("SystemJobInfoConverter");

    /* renamed from: b  reason: collision with root package name */
    private final ComponentName f2948b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.f2948b = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JobInfo a(j jVar, int i) {
        c cVar = jVar.j;
        int a2 = a(cVar.a());
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", jVar.f2864a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", jVar.a());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.f2948b).setRequiredNetworkType(a2).setRequiresCharging(cVar.b()).setRequiresDeviceIdle(cVar.c()).setExtras(persistableBundle);
        if (!cVar.c()) {
            extras.setBackoffCriteria(jVar.m, jVar.l == androidx.work.a.LINEAR ? 0 : 1);
        }
        extras.setMinimumLatency(Math.max(jVar.c() - System.currentTimeMillis(), 0L));
        if (Build.VERSION.SDK_INT >= 24 && cVar.i()) {
            for (d.a aVar : cVar.h().a()) {
                extras.addTriggerContentUri(a(aVar));
            }
            extras.setTriggerContentUpdateDelay(cVar.f());
            extras.setTriggerContentMaxDelay(cVar.g());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(cVar.d());
            extras.setRequiresStorageNotLow(cVar.e());
        }
        return extras.build();
    }

    private static JobInfo.TriggerContentUri a(d.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemJobInfoConverter.java */
    /* renamed from: androidx.work.impl.background.systemjob.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2949a;

        static {
            int[] iArr = new int[i.values().length];
            f2949a = iArr;
            try {
                iArr[i.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2949a[i.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2949a[i.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2949a[i.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2949a[i.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static int a(i iVar) {
        int i = AnonymousClass1.f2949a[iVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            return 3;
                        }
                    } else if (i == 5 && Build.VERSION.SDK_INT >= 26) {
                        return 4;
                    }
                    h.a().b(f2947a, String.format("API version too low. Cannot convert network type value %s", iVar), new Throwable[0]);
                    return 1;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }
}

package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.m;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2994a = androidx.work.h.a("ForceStopRunnable");

    /* renamed from: b  reason: collision with root package name */
    private static final long f2995b = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: c  reason: collision with root package name */
    private final Context f2996c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.work.impl.h f2997d;

    public ForceStopRunnable(Context context, androidx.work.impl.h hVar) {
        this.f2996c = context.getApplicationContext();
        this.f2997d = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx.work.h.a().b(f2994a, "Performing cleanup operations.", new Throwable[0]);
        boolean b2 = b();
        if (c()) {
            androidx.work.h.a().b(f2994a, "Rescheduling Workers.", new Throwable[0]);
            this.f2997d.i();
            this.f2997d.h().a(false);
        } else if (a()) {
            androidx.work.h.a().b(f2994a, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f2997d.i();
        } else if (b2) {
            androidx.work.h.a().b(f2994a, "Found unfinished work, scheduling it.", new Throwable[0]);
            androidx.work.impl.e.a(this.f2997d.d(), this.f2997d.c(), this.f2997d.e());
        }
        this.f2997d.j();
    }

    public boolean a() {
        if (a(this.f2996c, 536870912) == null) {
            b(this.f2996c);
            return true;
        }
        return false;
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b.b(this.f2996c);
        }
        WorkDatabase c2 = this.f2997d.c();
        k p = c2.p();
        c2.g();
        try {
            List<j> d2 = p.d();
            boolean z = (d2 == null || d2.isEmpty()) ? false : true;
            if (z) {
                for (j jVar : d2) {
                    p.a(m.a.ENQUEUED, jVar.f2864a);
                    p.b(jVar.f2864a, -1L);
                }
            }
            c2.j();
            return z;
        } finally {
            c2.h();
        }
    }

    boolean c() {
        return this.f2997d.h().a();
    }

    private static PendingIntent a(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, a(context), i);
    }

    static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    static void b(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent a2 = a(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f2995b;
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, currentTimeMillis, a2);
            } else {
                alarmManager.set(0, currentTimeMillis, a2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static final String f2998a = androidx.work.h.a("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            androidx.work.h.a().a(f2998a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.b(context);
        }
    }
}

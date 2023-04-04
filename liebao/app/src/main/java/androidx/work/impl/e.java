package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.List;

/* compiled from: Schedulers.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2963a = androidx.work.h.a("Schedulers");

    public static void a(androidx.work.b bVar, WorkDatabase workDatabase, List<d> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        k p = workDatabase.p();
        workDatabase.g();
        try {
            List<j> a2 = p.a(bVar.g());
            if (a2 != null && a2.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                for (j jVar : a2) {
                    p.b(jVar.f2864a, currentTimeMillis);
                }
            }
            workDatabase.j();
            if (a2 == null || a2.size() <= 0) {
                return;
            }
            j[] jVarArr = (j[]) a2.toArray(new j[0]);
            for (d dVar : list) {
                dVar.a(jVarArr);
            }
        } finally {
            workDatabase.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(Context context, h hVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b bVar = new androidx.work.impl.background.systemjob.b(context, hVar);
            androidx.work.impl.utils.d.a(context, SystemJobService.class, true);
            androidx.work.h.a().b(f2963a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return bVar;
        }
        d a2 = a(context);
        if (a2 == null) {
            androidx.work.impl.background.systemalarm.f fVar = new androidx.work.impl.background.systemalarm.f(context);
            androidx.work.impl.utils.d.a(context, SystemAlarmService.class, true);
            androidx.work.h.a().b(f2963a, "Created SystemAlarmScheduler", new Throwable[0]);
            return fVar;
        }
        return a2;
    }

    private static d a(Context context) {
        try {
            d dVar = (d) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            androidx.work.h.a().b(f2963a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            return dVar;
        } catch (Throwable th) {
            androidx.work.h.a().b(f2963a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}

package androidx.work.impl;

import android.content.Context;
import androidx.room.j;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import androidx.work.impl.g;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class WorkDatabase extends j {

    /* renamed from: d  reason: collision with root package name */
    private static final long f2804d = TimeUnit.DAYS.toMillis(7);

    public abstract k p();

    public abstract androidx.work.impl.b.b q();

    public abstract n r();

    public abstract androidx.work.impl.b.e s();

    public abstract androidx.work.impl.b.h t();

    public static WorkDatabase a(Context context, Executor executor, boolean z) {
        j.a a2;
        if (z) {
            a2 = androidx.room.i.a(context, WorkDatabase.class).a();
        } else {
            a2 = androidx.room.i.a(context, WorkDatabase.class, "androidx.work.workdb").a(executor);
        }
        return (WorkDatabase) a2.a(m()).a(g.f2969a).a(new g.a(context, 2, 3)).a(g.f2970b).a(g.f2971c).a(new g.a(context, 5, 6)).b().c();
    }

    static j.b m() {
        return new j.b() { // from class: androidx.work.impl.WorkDatabase.1
            @Override // androidx.room.j.b
            public void b(androidx.e.a.b bVar) {
                super.b(bVar);
                bVar.a();
                try {
                    bVar.c(WorkDatabase.n());
                    bVar.c();
                } finally {
                    bVar.b();
                }
            }
        };
    }

    static String n() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + o() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    static long o() {
        return System.currentTimeMillis() - f2804d;
    }
}

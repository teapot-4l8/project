package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.background.systemalarm.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CommandHandler.java */
/* loaded from: classes.dex */
public class b implements androidx.work.impl.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2909a = h.a("CommandHandler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f2910b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, androidx.work.impl.a> f2911c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Object f2912d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent c(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent b(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f2910b = context;
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        synchronized (this.f2912d) {
            androidx.work.impl.a remove = this.f2911c.remove(str);
            if (remove != null) {
                remove.a(str, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        boolean z;
        synchronized (this.f2912d) {
            z = !this.f2911c.isEmpty();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Intent intent, int i, e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            e(intent, i, eVar);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            f(intent, i, eVar);
        } else if (!a(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            h.a().e(f2909a, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            b(intent, i, eVar);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            c(intent, i, eVar);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            d(intent, i, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            g(intent, i, eVar);
        } else {
            h.a().d(f2909a, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }

    private void b(Intent intent, int i, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        h.a().b(f2909a, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase c2 = eVar.d().c();
        c2.g();
        try {
            j b2 = c2.p().b(string);
            if (b2 == null) {
                h a2 = h.a();
                String str = f2909a;
                a2.d(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (b2.f2865b.a()) {
                h a3 = h.a();
                String str2 = f2909a;
                a3.d(str2, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
            } else {
                long c3 = b2.c();
                if (!b2.d()) {
                    h.a().b(f2909a, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(c3)), new Throwable[0]);
                    a.a(this.f2910b, eVar.d(), string, c3);
                } else {
                    h.a().b(f2909a, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(c3)), new Throwable[0]);
                    a.a(this.f2910b, eVar.d(), string, c3);
                    eVar.a(new e.a(eVar, a(this.f2910b), i));
                }
                c2.j();
            }
        } finally {
            c2.h();
        }
    }

    private void c(Intent intent, int i, e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f2912d) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            h.a().b(f2909a, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (!this.f2911c.containsKey(string)) {
                d dVar = new d(this.f2910b, i, string, eVar);
                this.f2911c.put(string, dVar);
                dVar.a();
            } else {
                h.a().b(f2909a, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            }
        }
    }

    private void d(Intent intent, int i, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        h.a().b(f2909a, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        eVar.d().c(string);
        a.a(this.f2910b, eVar.d(), string);
        eVar.a(string, false);
    }

    private void e(Intent intent, int i, e eVar) {
        h.a().b(f2909a, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new c(this.f2910b, i, eVar).a();
    }

    private void f(Intent intent, int i, e eVar) {
        h.a().b(f2909a, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
        eVar.d().i();
    }

    private void g(Intent intent, int i, e eVar) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        h.a().b(f2909a, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
        a(string, z);
    }

    private static boolean a(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }
}

package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Alarms.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2908a = h.a("Alarms");

    public static void a(Context context, androidx.work.impl.h hVar, String str, long j) {
        androidx.work.impl.b.e s = hVar.c().s();
        androidx.work.impl.b.d a2 = s.a(str);
        if (a2 != null) {
            a(context, str, a2.f2852b);
            a(context, str, a2.f2852b, j);
            return;
        }
        int a3 = new androidx.work.impl.utils.c(context).a();
        s.a(new androidx.work.impl.b.d(str, a3));
        a(context, str, a3, j);
    }

    public static void a(Context context, androidx.work.impl.h hVar, String str) {
        androidx.work.impl.b.e s = hVar.c().s();
        androidx.work.impl.b.d a2 = s.a(str);
        if (a2 != null) {
            a(context, str, a2.f2852b);
            h.a().b(f2908a, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            s.b(str);
        }
    }

    private static void a(Context context, String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, b.b(context, str), 536870912);
        if (service == null || alarmManager == null) {
            return;
        }
        h.a().b(f2908a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i)), new Throwable[0]);
        alarmManager.cancel(service);
    }

    private static void a(Context context, String str, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, b.b(context, str), 1073741824);
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, j, service);
            } else {
                alarmManager.set(0, j, service);
            }
        }
    }
}

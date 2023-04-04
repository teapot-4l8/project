package cn.jiguang.at;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.AlarmReceiver;
import com.just.agentweb.WebIndicator;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f3933a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3934b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Context f3935c;

    /* renamed from: d  reason: collision with root package name */
    private cn.jiguang.ax.a f3936d = new g(this);

    /* renamed from: e  reason: collision with root package name */
    private long f3937e;

    private f() {
    }

    public static f a() {
        if (f3933a == null) {
            synchronized (f3934b) {
                if (f3933a == null) {
                    f3933a = new f();
                }
            }
        }
        return f3933a;
    }

    private void a(Context context) {
        this.f3935c = context;
        cn.jiguang.ax.b.a().a(WebIndicator.MAX_UNIFORM_SPEED_DURATION, JConstants.DEFAULT_HEARTBEAT_INTERVAL * 1000, this.f3936d);
    }

    private void b(Context context) {
        this.f3937e = SystemClock.elapsedRealtime();
        if (!((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.z())).booleanValue()) {
            a.a(context);
            return;
        }
        try {
            ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0));
        } catch (Throwable unused) {
            cn.jiguang.an.d.f("AlarmHelper", "Cancel heartbeat alarm failed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        cn.jiguang.an.d.b("PeriodWorker", "periodTask...");
        b(context);
        cn.jiguang.a.a.a(context, false, 0L);
        b.a().a(context, 19, 0, "periodTask");
        d.a(context, "periodtask", null);
    }

    public final void a(Context context, boolean z) {
        cn.jiguang.an.d.d("PeriodWorker", "PeriodWorker resume");
        if (this.f3937e > 0 && SystemClock.elapsedRealtime() > this.f3937e + ((JConstants.DEFAULT_HEARTBEAT_INTERVAL + 5) * 1000)) {
            cn.jiguang.an.d.d("PeriodWorker", "schedule time is expired, execute now");
            a(context);
            c(context);
        } else if (!z) {
            cn.jiguang.an.d.b("PeriodWorker", "need not change period task");
        } else {
            a(context);
            b(context);
        }
    }
}

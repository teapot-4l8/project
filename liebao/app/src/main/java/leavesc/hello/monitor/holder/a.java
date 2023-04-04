package leavesc.hello.monitor.holder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.LongSparseArray;
import androidx.core.app.i;
import leavesc.hello.monitor.R;
import leavesc.hello.monitor.db.a.b;

/* compiled from: NotificationHolder.java */
/* loaded from: classes2.dex */
public class a {
    private static volatile a f;

    /* renamed from: b  reason: collision with root package name */
    private Context f7263b;

    /* renamed from: c  reason: collision with root package name */
    private NotificationManager f7264c;

    /* renamed from: d  reason: collision with root package name */
    private int f7265d;

    /* renamed from: a  reason: collision with root package name */
    private LongSparseArray<b> f7262a = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f7266e = true;

    private a(Context context) {
        this.f7263b = context.getApplicationContext();
        this.f7264c = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f7264c.createNotificationChannel(new NotificationChannel("monitorLeavesChannelId", "Http Notifications", 3));
        }
    }

    public static a a(Context context) {
        if (f == null) {
            synchronized (a.class) {
                if (f == null) {
                    f = new a(context);
                }
            }
        }
        return f;
    }

    public synchronized void a(b bVar) {
        if (this.f7266e) {
            b(bVar);
            i.c a2 = new i.c(this.f7263b, "monitorLeavesChannelId").a(b(this.f7263b)).c(true).a(R.drawable.ic_launcher).a((CharSequence) "Recording Http Activity");
            i.d dVar = new i.d();
            int size = this.f7262a.size();
            if (size > 0) {
                int i = size - 1;
                a2.b(this.f7262a.valueAt(i).b());
                while (i >= 0) {
                    dVar.a(this.f7262a.valueAt(i).b());
                    i--;
                }
            }
            a2.b(false);
            a2.a(dVar);
            a2.a((Uri) null);
            if (Build.VERSION.SDK_INT >= 24) {
                a2.c(String.valueOf(this.f7265d));
            } else {
                a2.b(this.f7265d);
            }
            this.f7264c.notify(19950724, a2.b());
        }
    }

    private synchronized void b(b bVar) {
        this.f7265d++;
        this.f7262a.put(bVar.i(), bVar);
        if (this.f7262a.size() > 10) {
            this.f7262a.removeAt(0);
        }
    }

    public synchronized void a(boolean z) {
        this.f7266e = z;
    }

    public synchronized void a() {
        this.f7262a.clear();
        this.f7265d = 0;
    }

    public synchronized void b() {
        this.f7264c.cancel(19950724);
    }

    private PendingIntent b(Context context) {
        return PendingIntent.getActivity(context, 100, leavesc.hello.monitor.a.a(context), 0);
    }
}

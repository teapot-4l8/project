package b.a.e;

import android.app.Application;
import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import b.a.f.q;
import com.fm.openinstall.Configuration;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedBlockingQueue f3143a = new LinkedBlockingQueue(1);

    /* renamed from: b  reason: collision with root package name */
    private final b.a.k.e f3144b = b.a.k.e.a("EventsCollector");

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f3145c = true;

    /* renamed from: d  reason: collision with root package name */
    private final Thread f3146d = new Thread(new f(this));

    /* renamed from: e  reason: collision with root package name */
    private final Application f3147e;
    private Application.ActivityLifecycleCallbacks f;
    private final q g;

    public e(Context context, b.a.b bVar, b.a.f fVar, b.a.c.b bVar2, Configuration configuration) {
        this.f3147e = (Application) context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("EventsHandler-Thread");
        handlerThread.start();
        this.g = new q(context, handlerThread.getLooper(), bVar, fVar, bVar2, configuration);
        b();
    }

    private void b() {
        this.f3145c = true;
        this.f3146d.start();
        c();
    }

    private void c() {
        g gVar = new g(this);
        this.f = gVar;
        this.f3147e.registerActivityLifecycleCallbacks(gVar);
    }

    public void a() {
        a a2 = a.a();
        a2.a(true);
        this.g.a(a2);
    }

    public void a(long j) {
        if (j > 1) {
            this.g.a(a.a(j));
        }
    }

    public void a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.a(a.a(str, j));
    }

    public void a(String str, boolean z) {
        this.g.a(str, z);
    }
}

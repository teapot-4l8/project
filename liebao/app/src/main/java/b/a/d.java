package b.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.HandlerThread;
import com.fm.openinstall.Configuration;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f3121a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a.f.a f3122b;

    /* renamed from: c  reason: collision with root package name */
    private final b.a.e.e f3123c;

    private d(Context context, Configuration configuration) {
        b bVar = new b();
        b.a.c.b bVar2 = new b.a.c.b();
        f fVar = new f(new h().a(context, "FM_config", null));
        HandlerThread handlerThread = new HandlerThread("CoreHandler-Thread");
        handlerThread.start();
        this.f3122b = new b.a.f.a(context, handlerThread.getLooper(), bVar, fVar, bVar2, configuration);
        this.f3123c = new b.a.e.e(context, bVar, fVar, bVar2, configuration);
        a(context);
    }

    public static d a(Context context, Configuration configuration) {
        if (f3121a == null) {
            synchronized (d.class) {
                if (f3121a == null) {
                    f3121a = new d(context, configuration);
                }
            }
        }
        return f3121a;
    }

    private void a(Context context) {
        Application application = (Application) context.getApplicationContext();
        application.registerActivityLifecycleCallbacks(new e(this, application));
    }

    private void a(Uri uri, com.fm.openinstall.a.c cVar) {
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("decodeWakeUp", new Object[0]);
        }
        this.f3122b.a(uri, cVar);
    }

    public void a() {
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("reportRegister", new Object[0]);
        }
        this.f3123c.a();
    }

    public void a(long j, com.fm.openinstall.a.b bVar) {
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("getInstallData", new Object[0]);
        }
        this.f3122b.a(j, bVar);
    }

    public void a(Intent intent, com.fm.openinstall.a.c cVar) {
        a(intent.getData(), cVar);
    }

    public void a(com.fm.openinstall.a.c cVar) {
        a((Uri) null, cVar);
    }

    public void a(com.fm.openinstall.a.d dVar) {
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("getOriginalApk", new Object[0]);
        }
        this.f3122b.a(dVar);
    }

    public void a(String str, long j) {
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("reportEffectPoint", new Object[0]);
        }
        this.f3123c.a(str, j);
    }

    public void a(String str, boolean z) {
        this.f3122b.a(str, z);
        this.f3123c.a(str, z);
        this.f3122b.d();
    }
}

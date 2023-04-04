package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* compiled from: LifecycleService.java */
/* loaded from: classes.dex */
public class o extends Service implements l {

    /* renamed from: a  reason: collision with root package name */
    private final w f2028a = new w(this);

    @Override // android.app.Service
    public void onCreate() {
        this.f2028a.a();
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f2028a.b();
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        this.f2028a.c();
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f2028a.d();
        super.onDestroy();
    }

    @Override // androidx.lifecycle.l
    public h getLifecycle() {
        return this.f2028a.e();
    }
}

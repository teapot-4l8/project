package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.o;
import androidx.work.h;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.impl.utils.i;

/* loaded from: classes.dex */
public class SystemAlarmService extends o implements e.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2905a = h.a("SystemAlarmService");

    /* renamed from: b  reason: collision with root package name */
    private e f2906b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2907c;

    @Override // androidx.lifecycle.o, android.app.Service
    public void onCreate() {
        super.onCreate();
        b();
        this.f2907c = false;
    }

    @Override // androidx.lifecycle.o, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f2907c = true;
        this.f2906b.a();
    }

    @Override // androidx.lifecycle.o, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f2907c) {
            h.a().c(f2905a, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f2906b.a();
            b();
            this.f2907c = false;
        }
        if (intent != null) {
            this.f2906b.a(intent, i2);
            return 3;
        }
        return 3;
    }

    @Override // androidx.work.impl.background.systemalarm.e.b
    public void a() {
        this.f2907c = true;
        h.a().b(f2905a, "All commands completed in dispatcher", new Throwable[0]);
        i.a();
        stopSelf();
    }

    private void b() {
        e eVar = new e(this);
        this.f2906b = eVar;
        eVar.a(this);
    }
}

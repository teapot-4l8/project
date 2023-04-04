package leavesc.hello.monitor.service;

import android.app.IntentService;
import android.content.Intent;
import leavesc.hello.monitor.holder.a;

/* loaded from: classes2.dex */
public class ClearMonitorService extends IntentService {
    public ClearMonitorService() {
        super(ClearMonitorService.class.getName());
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        a a2 = a.a(this);
        a2.a();
        a2.b();
    }
}

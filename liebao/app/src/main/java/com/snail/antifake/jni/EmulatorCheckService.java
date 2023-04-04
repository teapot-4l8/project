package com.snail.antifake.jni;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.snail.antifake.a;

/* loaded from: classes2.dex */
public class EmulatorCheckService extends Service {

    /* renamed from: a  reason: collision with root package name */
    Handler f5538a = new Handler();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new a.AbstractBinderC0130a() { // from class: com.snail.antifake.jni.EmulatorCheckService.1
            @Override // com.snail.antifake.a
            public boolean a() {
                return EmulatorDetectUtil.a(EmulatorCheckService.this);
            }

            @Override // com.snail.antifake.a
            public void b() {
                EmulatorCheckService.this.stopSelf();
                EmulatorCheckService.this.f5538a.postDelayed(new Runnable() { // from class: com.snail.antifake.jni.EmulatorCheckService.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        System.exit(0);
                    }
                }, 500L);
            }
        };
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.v("lishang", "onCreate");
    }
}

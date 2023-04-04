package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.b;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: SamsungDeviceIdSupplier.java */
/* loaded from: classes2.dex */
public class ag implements z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6357a = "DeviceIdService";

    /* renamed from: b  reason: collision with root package name */
    private static final String f6358b = "com.samsung.android.deviceidservice";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6359c = "com.samsung.android.deviceidservice.DeviceIdService";

    /* renamed from: e  reason: collision with root package name */
    private CountDownLatch f6361e;

    /* renamed from: d  reason: collision with root package name */
    private String f6360d = "";
    private final ServiceConnection f = new ServiceConnection() { // from class: com.umeng.analytics.pro.ag.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b a2 = b.a.a(iBinder);
                ag.this.f6360d = a2.a();
                Log.d(ag.f6357a, "onServiceConnected");
            } catch (RemoteException | NullPointerException e2) {
                Log.e(ag.f6357a, "onServiceConnected failed e=" + e2.getMessage());
            }
            ag.this.f6361e.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(ag.f6357a, "onServiceDisconnected");
        }
    };

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        this.f6361e = new CountDownLatch(1);
        try {
            try {
                b(context);
                if (!this.f6361e.await(500L, TimeUnit.MILLISECONDS)) {
                    Log.e(f6357a, "getOAID time-out");
                }
                return this.f6360d;
            } catch (InterruptedException e2) {
                Log.e(f6357a, "getOAID interrupted. e=" + e2.getMessage());
                c(context);
                return null;
            }
        } finally {
            c(context);
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName(f6358b, f6359c);
            if (context.bindService(intent, this.f, 1)) {
                return;
            }
            throw new UnsupportedOperationException("not supported service");
        } catch (Error | Exception e2) {
            Log.e(f6357a, "bindService failed. e=" + e2.getMessage());
            this.f6361e.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f);
        } catch (Error | Exception e2) {
            Log.e(f6357a, "unbindService failed. e=" + e2.getMessage());
        }
    }
}

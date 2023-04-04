package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: CoolpadDeviceIdSupplier.java */
/* loaded from: classes2.dex */
public class ab implements z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6344a = "Coolpad";

    /* renamed from: b  reason: collision with root package name */
    private static final String f6345b = "com.coolpad.deviceidsupport";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6346c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d  reason: collision with root package name */
    private static a f6347d;
    private CountDownLatch f;
    private Context g;

    /* renamed from: e  reason: collision with root package name */
    private String f6348e = "";
    private final ServiceConnection h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ab.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ab.f6347d = a.AbstractBinderC0160a.a(iBinder);
                ab.this.f6348e = ab.f6347d.b(ab.this.g.getPackageName());
                Log.d(ab.f6344a, "onServiceConnected: oaid = " + ab.this.f6348e);
            } catch (RemoteException | NullPointerException e2) {
                Log.e(ab.f6344a, "onServiceConnected failed e=" + e2.getMessage());
            }
            ab.this.f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(ab.f6344a, "onServiceDisconnected");
            a unused = ab.f6347d = null;
        }
    };

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.g = context.getApplicationContext();
        this.f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(f6344a, "getOAID time-out");
            }
            return this.f6348e;
        } catch (InterruptedException e2) {
            Log.e(f6344a, "getOAID interrupted. e=" + e2.getMessage());
            return null;
        } finally {
            c(context);
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f6345b, f6346c));
            if (context.bindService(intent, this.h, 1)) {
                return;
            }
            Log.e(f6344a, "bindService return false");
        } catch (Throwable th) {
            Log.e(f6344a, "bindService failed. e=" + th.getMessage());
            this.f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d(f6344a, "call unbindService.");
            context.unbindService(this.h);
        } catch (Throwable th) {
            Log.e(f6344a, "unbindService failed. e=" + th.getMessage());
        }
    }
}

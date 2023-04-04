package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONObject;

/* compiled from: BatteryUtils.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6768a = "BatteryUtils";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6769b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Context f6770c;

    /* renamed from: d  reason: collision with root package name */
    private BroadcastReceiver f6771d;

    private b() {
        this.f6771d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.b.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("le", intent.getIntExtra("level", 0));
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObject.put("vol", intent.getIntExtra("voltage", 0));
                        } catch (Exception unused2) {
                        }
                        try {
                            jSONObject.put("temp", intent.getIntExtra("temperature", 0));
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused3) {
                        }
                        int intExtra = intent.getIntExtra("status", 0);
                        int i = -1;
                        int i2 = 2;
                        if (intExtra != 1) {
                            if (intExtra == 2) {
                                i = 1;
                            } else if (intExtra == 4) {
                                i = 0;
                            } else if (intExtra == 5) {
                                i = 2;
                            }
                        }
                        try {
                            jSONObject.put("st", i);
                        } catch (Exception unused4) {
                        }
                        int intExtra2 = intent.getIntExtra("plugged", 0);
                        if (intExtra2 == 1) {
                            i2 = 1;
                        } else if (intExtra2 != 2) {
                            i2 = 0;
                        }
                        try {
                            jSONObject.put("ct", i2);
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused5) {
                        }
                        ULog.i(b.f6768a, jSONObject.toString());
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.h, com.umeng.commonsdk.internal.b.a(b.f6770c).a(), jSONObject.toString());
                        b.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(b.f6770c, th);
                }
            }
        };
    }

    /* compiled from: BatteryUtils.java */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f6773a = new b();

        private a() {
        }
    }

    public static b a(Context context) {
        if (f6770c == null && context != null) {
            f6770c = context.getApplicationContext();
        }
        return a.f6773a;
    }

    public synchronized boolean a() {
        return f6769b;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f6770c.registerReceiver(this.f6771d, intentFilter);
            f6769b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f6770c, th);
        }
    }

    public synchronized void c() {
        try {
            f6770c.unregisterReceiver(this.f6771d);
            f6769b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f6770c, th);
        }
    }
}

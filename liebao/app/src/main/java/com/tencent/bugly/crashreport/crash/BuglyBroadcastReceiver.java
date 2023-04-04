package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.just.agentweb.DefaultWebClient;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d  reason: collision with root package name */
    private static BuglyBroadcastReceiver f6028d;

    /* renamed from: b  reason: collision with root package name */
    private Context f6030b;

    /* renamed from: c  reason: collision with root package name */
    private String f6031c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6032e = true;

    /* renamed from: a  reason: collision with root package name */
    private IntentFilter f6029a = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f6028d == null) {
                f6028d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f6028d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.f6029a.hasAction(str)) {
            this.f6029a.addAction(str);
        }
        x.c("add action %s", str);
    }

    public synchronized void register(Context context) {
        this.f6030b = context;
        z.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    x.a(BuglyBroadcastReceiver.f6028d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.f6030b.registerReceiver(BuglyBroadcastReceiver.f6028d, BuglyBroadcastReceiver.this.f6029a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f6030b = context;
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f6032e) {
                    this.f6032e = false;
                    return true;
                }
                String c2 = com.tencent.bugly.crashreport.common.info.b.c(this.f6030b);
                x.c("is Connect BC " + c2, new Object[0]);
                x.a("network %s changed to %s", this.f6031c, c2);
                if (c2 == null) {
                    this.f6031c = null;
                    return true;
                }
                String str = this.f6031c;
                this.f6031c = c2;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
                u a3 = u.a();
                com.tencent.bugly.crashreport.common.info.a a4 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (a2 != null && a3 != null && a4 != null) {
                    if (!c2.equals(str)) {
                        if (currentTimeMillis - a3.a(c.f6074a) > 30000) {
                            x.a("try to upload crash on network changed.", new Object[0]);
                            c a5 = c.a();
                            if (a5 != null) {
                                a5.a(0L);
                            }
                        }
                        if (currentTimeMillis - a3.a(DefaultWebClient.DERECT_OPEN_OTHER_PAGE) > 30000) {
                            x.a("try to upload userinfo on network changed.", new Object[0]);
                            com.tencent.bugly.crashreport.biz.b.f5994a.b();
                        }
                    }
                    return true;
                }
                x.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}

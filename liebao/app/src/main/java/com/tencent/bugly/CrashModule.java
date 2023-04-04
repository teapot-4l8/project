package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.x;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;

    /* renamed from: c  reason: collision with root package name */
    private static int f5962c;

    /* renamed from: e  reason: collision with root package name */
    private static CrashModule f5963e = new CrashModule();

    /* renamed from: a  reason: collision with root package name */
    private long f5964a;

    /* renamed from: b  reason: collision with root package name */
    private BuglyStrategy.a f5965b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5966d = false;

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public static CrashModule getInstance() {
        f5963e.id = MODULE_ID;
        return f5963e;
    }

    public synchronized boolean hasInitialized() {
        return this.f5966d;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007a A[Catch: all -> 0x00a4, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0009, B:9:0x0039, B:10:0x0047, B:12:0x004c, B:15:0x0053, B:18:0x0063, B:21:0x006a, B:24:0x007a, B:26:0x0081, B:22:0x0075, B:16:0x005e), top: B:34:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    @Override // com.tencent.bugly.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        if (context != null) {
            if (!this.f5966d) {
                x.a("Initializing crash module.", new Object[0]);
                n a2 = n.a();
                int i = f5962c + 1;
                f5962c = i;
                a2.a(MODULE_ID, i);
                this.f5966d = true;
                CrashReport.setContext(context);
                a(context, buglyStrategy);
                c a3 = c.a((int) MODULE_ID, context, z, this.f5965b, (o) null, (String) null);
                a3.e();
                if (buglyStrategy != null) {
                    a3.a(buglyStrategy.getCallBackType());
                    a3.a(buglyStrategy.getCloseErrorCallback());
                }
                a3.m();
                if (buglyStrategy != null && !buglyStrategy.isEnableNativeCrashMonitor()) {
                    x.a("[crash] Closed native crash monitor!", new Object[0]);
                    a3.f();
                    if (buglyStrategy != null && !buglyStrategy.isEnableANRCrashMonitor()) {
                        x.a("[crash] Closed ANR monitor!", new Object[0]);
                        a3.i();
                        a3.a(buglyStrategy == null ? buglyStrategy.getAppReportDelay() : 0L);
                        a3.l();
                        d.a(context);
                        BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
                        buglyBroadcastReceiver.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        buglyBroadcastReceiver.register(context);
                        n a4 = n.a();
                        int i2 = f5962c - 1;
                        f5962c = i2;
                        a4.a(MODULE_ID, i2);
                    }
                    a3.h();
                    a3.a(buglyStrategy == null ? buglyStrategy.getAppReportDelay() : 0L);
                    a3.l();
                    d.a(context);
                    BuglyBroadcastReceiver buglyBroadcastReceiver2 = BuglyBroadcastReceiver.getInstance();
                    buglyBroadcastReceiver2.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    buglyBroadcastReceiver2.register(context);
                    n a42 = n.a();
                    int i22 = f5962c - 1;
                    f5962c = i22;
                    a42.a(MODULE_ID, i22);
                }
                a3.g();
                if (buglyStrategy != null) {
                    x.a("[crash] Closed ANR monitor!", new Object[0]);
                    a3.i();
                    a3.a(buglyStrategy == null ? buglyStrategy.getAppReportDelay() : 0L);
                    a3.l();
                    d.a(context);
                    BuglyBroadcastReceiver buglyBroadcastReceiver22 = BuglyBroadcastReceiver.getInstance();
                    buglyBroadcastReceiver22.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    buglyBroadcastReceiver22.register(context);
                    n a422 = n.a();
                    int i222 = f5962c - 1;
                    f5962c = i222;
                    a422.a(MODULE_ID, i222);
                }
                a3.h();
                a3.a(buglyStrategy == null ? buglyStrategy.getAppReportDelay() : 0L);
                a3.l();
                d.a(context);
                BuglyBroadcastReceiver buglyBroadcastReceiver222 = BuglyBroadcastReceiver.getInstance();
                buglyBroadcastReceiver222.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                buglyBroadcastReceiver222.register(context);
                n a4222 = n.a();
                int i2222 = f5962c - 1;
                f5962c = i2222;
                a4222.a(MODULE_ID, i2222);
            }
        }
    }

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            com.tencent.bugly.crashreport.common.info.a.a(context).n = libBuglySOFilePath;
            x.a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.f5965b = buglyStrategy.getCrashHandleCallback();
            x.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            long appReportDelay = buglyStrategy.getAppReportDelay();
            this.f5964a = appReportDelay;
            x.a("setted delay: %d", Long.valueOf(appReportDelay));
        }
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        c a2;
        if (strategyBean == null || (a2 = c.a()) == null) {
            return;
        }
        a2.a(strategyBean);
    }
}

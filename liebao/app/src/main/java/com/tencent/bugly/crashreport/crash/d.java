package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f6086a;

    /* renamed from: b  reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.strategy.a f6087b;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.info.a f6088c;

    /* renamed from: d  reason: collision with root package name */
    private b f6089d;

    /* renamed from: e  reason: collision with root package name */
    private Context f6090e;

    static /* synthetic */ void a(d dVar) {
        x.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            dVar.f6088c.getClass();
            z.a(cls, "sdkPackageName", "com.tencent.bugly", (Object) null);
            x.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            x.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    static /* synthetic */ void a(d dVar, Thread thread, int i, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i == 4) {
            str4 = "Unity";
        } else if (i == 5 || i == 6) {
            str4 = "Cocos";
        } else if (i != 8) {
            x.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
            return;
        } else {
            str4 = "H5";
        }
        x.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!dVar.f6087b.b()) {
                x.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c2 = dVar.f6087b.c();
            if (!c2.g && dVar.f6087b.b()) {
                x.e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                String a2 = z.a();
                String str7 = dVar.f6088c.f6008d;
                String name = currentThread.getName();
                b.a(str4, a2, str7, name, str + "\n" + str2 + "\n" + str3, null);
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i == 5 || i == 6) {
                if (!c2.l) {
                    x.e("[ExtraCrashManager] %s report is disabled.", str4);
                    x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (i == 8 && !c2.m) {
                x.e("[ExtraCrashManager] %s report is disabled.", str4);
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i2 = i != 8 ? i : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
            crashDetailBean.F = dVar.f6088c.p();
            crashDetailBean.G = dVar.f6088c.o();
            crashDetailBean.H = dVar.f6088c.q();
            crashDetailBean.w = z.a(dVar.f6090e, c.f6078e, (String) null);
            crashDetailBean.f6036b = i2;
            crashDetailBean.f6039e = dVar.f6088c.h();
            crashDetailBean.f = dVar.f6088c.k;
            crashDetailBean.g = dVar.f6088c.w();
            crashDetailBean.m = dVar.f6088c.g();
            crashDetailBean.n = str;
            crashDetailBean.o = str2;
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.p = str5;
            crashDetailBean.f6040q = str6;
            crashDetailBean.r = System.currentTimeMillis();
            crashDetailBean.u = z.b(crashDetailBean.f6040q.getBytes());
            crashDetailBean.z = z.a(c.f, false);
            crashDetailBean.A = dVar.f6088c.f6008d;
            crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.I = dVar.f6088c.y();
            crashDetailBean.h = dVar.f6088c.v();
            crashDetailBean.M = dVar.f6088c.f6005a;
            crashDetailBean.N = dVar.f6088c.a();
            crashDetailBean.P = dVar.f6088c.H();
            crashDetailBean.Q = dVar.f6088c.I();
            crashDetailBean.R = dVar.f6088c.B();
            crashDetailBean.S = dVar.f6088c.G();
            if (!c.a().n()) {
                dVar.f6089d.d(crashDetailBean);
            }
            crashDetailBean.y = y.a();
            if (crashDetailBean.O == null) {
                crashDetailBean.O = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.O.putAll(map);
            }
            String a3 = z.a();
            String str8 = dVar.f6088c.f6008d;
            String name2 = currentThread.getName();
            b.a(str4, a3, str8, name2, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!dVar.f6089d.a(crashDetailBean)) {
                dVar.f6089d.a(crashDetailBean, 3000L, false);
            }
            x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    private d(Context context) {
        c a2 = c.a();
        if (a2 == null) {
            return;
        }
        this.f6087b = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f6088c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f6089d = a2.p;
        this.f6090e = context;
        w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.a(d.this);
            }
        });
    }

    public static d a(Context context) {
        if (f6086a == null) {
            f6086a = new d(context);
        }
        return f6086a;
    }

    public static void a(final Thread thread, final int i, final String str, final String str2, final String str3, final Map<String, String> map) {
        w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (d.f6086a != null) {
                        d.a(d.f6086a, thread, i, str, str2, str3, map);
                    } else {
                        x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    }
                } catch (Throwable th) {
                    if (!x.b(th)) {
                        th.printStackTrace();
                    }
                    x.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}

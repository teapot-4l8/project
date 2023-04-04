package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f5994a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5995b = false;

    /* renamed from: c  reason: collision with root package name */
    private static int f5996c = 10;

    /* renamed from: d  reason: collision with root package name */
    private static long f5997d = 300000;

    /* renamed from: e  reason: collision with root package name */
    private static long f5998e = 30000;
    private static long f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static Application.ActivityLifecycleCallbacks k = null;
    private static Class<?> l = null;
    private static boolean m = true;

    static /* synthetic */ String a(String str, String str2) {
        return z.a() + "  " + str + "  " + str2 + "\n";
    }

    static /* synthetic */ int g() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean z;
        boolean z2;
        StackTraceElement[] stackTrace;
        boolean z3;
        if (buglyStrategy != null) {
            z2 = buglyStrategy.recordUserInfoOnceADay();
            z = buglyStrategy.isEnableUserInfo();
        } else {
            z = true;
            z2 = false;
        }
        if (z2) {
            com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
            List<UserInfoBean> a3 = f5994a.a(a2.f6008d);
            if (a3 != null) {
                for (int i2 = 0; i2 < a3.size(); i2++) {
                    UserInfoBean userInfoBean = a3.get(i2);
                    if (userInfoBean.n.equals(a2.k) && userInfoBean.f5976b == 1) {
                        long b2 = z.b();
                        if (b2 <= 0) {
                            break;
                        } else if (userInfoBean.f5979e >= b2) {
                            if (userInfoBean.f <= 0) {
                                a aVar = f5994a;
                                w a4 = w.a();
                                if (a4 != null) {
                                    a4.a(new a.AnonymousClass2());
                                }
                            }
                            z3 = false;
                            if (z3) {
                                return;
                            }
                            z = false;
                        }
                    }
                }
            }
            z3 = true;
            if (z3) {
            }
        }
        com.tencent.bugly.crashreport.common.info.a b3 = com.tencent.bugly.crashreport.common.info.a.b();
        if (b3 != null) {
            String str = null;
            boolean z4 = false;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getMethodName().equals("onCreate")) {
                    str = stackTraceElement.getClassName();
                }
                if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                    z4 = true;
                }
            }
            if (str == null) {
                str = "unknown";
            } else if (z4) {
                b3.a(true);
            } else {
                str = "background";
            }
            b3.f6010q = str;
        }
        if (z && Build.VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (k == null) {
                        k = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.bugly.crashreport.biz.b.2
                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityStarted(Activity activity) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityStopped(Activity activity) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityResumed(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onResumed <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a b4 = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (b4 == null) {
                                        return;
                                    }
                                    b4.E.add(b.a(name, "onResumed"));
                                    b4.a(true);
                                    b4.f6010q = name;
                                    b4.r = System.currentTimeMillis();
                                    b4.u = b4.r - b.i;
                                    long j2 = b4.r - b.h;
                                    if (j2 > (b.f > 0 ? b.f : b.f5998e)) {
                                        b4.d();
                                        b.g();
                                        x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(b.f5998e / 1000));
                                        if (b.g % b.f5996c == 0) {
                                            b.f5994a.a(4, b.m, 0L);
                                            return;
                                        }
                                        b.f5994a.a(4, false, 0L);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        if (currentTimeMillis - b.j > b.f5997d) {
                                            long unused = b.j = currentTimeMillis;
                                            x.a("add a timer to upload hot start user info", new Object[0]);
                                            if (b.m) {
                                                w.a().a(new a.RunnableC0159a(null, true), b.f5997d);
                                            }
                                        }
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityPaused(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onPaused <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a b4 = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (b4 == null) {
                                        return;
                                    }
                                    b4.E.add(b.a(name, "onPaused"));
                                    b4.a(false);
                                    b4.s = System.currentTimeMillis();
                                    b4.t = b4.s - b4.r;
                                    long unused = b.h = b4.s;
                                    if (b4.t < 0) {
                                        b4.t = 0L;
                                    }
                                    if (activity != null) {
                                        b4.f6010q = "background";
                                    } else {
                                        b4.f6010q = "unknown";
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityDestroyed(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onDestroyed <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a b4 = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (b4 != null) {
                                        b4.E.add(b.a(name, "onDestroyed"));
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityCreated(Activity activity, Bundle bundle) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onCreated <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a b4 = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (b4 != null) {
                                        b4.E.add(b.a(name, "onCreated"));
                                    }
                                }
                            }
                        };
                    }
                    application.registerActivityLifecycleCallbacks(k);
                } catch (Exception e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (m) {
            i = System.currentTimeMillis();
            f5994a.a(1, false, 0L);
            x.a("[session] launch app, new start", new Object[0]);
            f5994a.a();
            w.a().a(new a.c(21600000L), 21600000L);
        }
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j2;
        if (f5995b) {
            return;
        }
        boolean z = com.tencent.bugly.crashreport.common.info.a.a(context).f6009e;
        m = z;
        f5994a = new a(context, z);
        f5995b = true;
        if (buglyStrategy != null) {
            l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, buglyStrategy);
        } else {
            w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(context, buglyStrategy);
                }
            }, j2);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.crashreport.common.strategy.a.a().c().f6021q;
        }
        f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        w a2;
        a aVar = f5994a;
        if (aVar != null && !z && (a2 = w.a()) != null) {
            a2.a(new a.AnonymousClass2());
        }
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.f6021q > 0) {
            f5998e = strategyBean.f6021q;
        }
        if (strategyBean.w > 0) {
            f5996c = strategyBean.w;
        }
        if (strategyBean.x > 0) {
            f5997d = strategyBean.x;
        }
    }

    public static void a() {
        a aVar = f5994a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (!f5995b || context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (k != null) {
                        application.unregisterActivityLifecycleCallbacks(k);
                    }
                } catch (Exception e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        f5995b = false;
    }
}

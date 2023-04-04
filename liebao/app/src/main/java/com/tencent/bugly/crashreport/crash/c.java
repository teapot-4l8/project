package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Build;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f6074a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f6075b = false;

    /* renamed from: c  reason: collision with root package name */
    public static int f6076c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f6077d = true;

    /* renamed from: e  reason: collision with root package name */
    public static int f6078e = 20480;
    public static int f = 20480;
    public static long g = 604800000;
    public static String h = null;
    public static boolean i = false;
    public static String j = null;
    public static int k = 5000;
    public static boolean l = true;
    public static boolean m = false;
    public static String n;
    public static String o;
    private static c r;
    public final b p;

    /* renamed from: q  reason: collision with root package name */
    private final Context f6079q;
    private final e s;
    private final NativeCrashHandler t;
    private com.tencent.bugly.crashreport.common.strategy.a u;
    private w v;
    private final com.tencent.bugly.crashreport.crash.anr.b w;
    private Boolean x;
    private int y = 31;
    private boolean z = false;

    private c(int i2, Context context, w wVar, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        f6074a = i2;
        Context a2 = z.a(context);
        this.f6079q = a2;
        this.u = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.v = wVar;
        this.p = new b(i2, a2, u.a(), p.a(), this.u, aVar, oVar);
        com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(a2);
        this.s = new e(a2, this.p, this.u, a3);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a2, a3, this.p, this.u, wVar, z, str);
        this.t = nativeCrashHandler;
        a3.F = nativeCrashHandler;
        this.w = new com.tencent.bugly.crashreport.crash.anr.b(a2, this.u, a3, wVar, this.p);
    }

    public static synchronized c a(int i2, Context context, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        c cVar;
        synchronized (c.class) {
            if (r == null) {
                r = new c(CrashModule.MODULE_ID, context, w.a(), z, aVar, null, null);
            }
            cVar = r;
        }
        return cVar;
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = r;
        }
        return cVar;
    }

    public final void a(StrategyBean strategyBean) {
        this.s.a(strategyBean);
        this.t.onStrategyChanged(strategyBean);
        this.w.c();
        w.a().a(new AnonymousClass2(), 3000L);
    }

    public final boolean b() {
        Boolean bool = this.x;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().f6008d;
        List<r> a2 = p.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a2 != null && a2.size() > 0) {
            for (r rVar : a2) {
                if (str.equals(rVar.f6236c)) {
                    this.x = true;
                    arrayList.add(rVar);
                }
            }
            if (arrayList.size() > 0) {
                p.a().a(arrayList);
            }
            return true;
        }
        this.x = false;
        return false;
    }

    public final synchronized void c() {
        this.s.a();
        this.t.setUserOpened(true);
        if (Build.VERSION.SDK_INT <= 19) {
            this.w.a(true);
        } else {
            this.w.d();
        }
    }

    public final synchronized void d() {
        this.s.b();
        this.t.setUserOpened(false);
        if (Build.VERSION.SDK_INT < 19) {
            this.w.a(false);
        } else {
            this.w.e();
        }
    }

    public final void e() {
        this.s.a();
    }

    public final void f() {
        this.t.setUserOpened(false);
    }

    public final void g() {
        this.t.setUserOpened(true);
    }

    public final void h() {
        if (Build.VERSION.SDK_INT <= 19) {
            this.w.a(true);
        } else {
            this.w.d();
        }
    }

    public final void i() {
        if (Build.VERSION.SDK_INT < 19) {
            this.w.a(false);
        } else {
            this.w.e();
        }
    }

    public final synchronized void a(boolean z, boolean z2, boolean z3) {
        this.t.testNativeCrash(z, z2, z3);
    }

    public final synchronized void j() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 30) {
                try {
                    x.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                    z.b(5000L);
                    i2 = i3;
                } catch (Throwable th) {
                    if (x.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean k() {
        return this.w.a();
    }

    public final void a(final Thread thread, final Throwable th, boolean z, String str, byte[] bArr, final boolean z2) {
        this.v.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    x.c("post a throwable %b", Boolean.valueOf(r2));
                    c.this.s.a(thread, th, false, r5, r6);
                    if (z2) {
                        x.a("clear user datas", new Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(c.this.f6079q).C();
                    }
                } catch (Throwable th2) {
                    if (!x.b(th2)) {
                        th2.printStackTrace();
                    }
                    x.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.p.e(crashDetailBean);
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.c$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    final class AnonymousClass2 extends Thread {
        AnonymousClass2() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            ArrayList arrayList;
            if (z.a(c.this.f6079q, "local_crash_lock", 10000L)) {
                List<CrashDetailBean> a2 = c.this.p.a();
                if (a2 != null && a2.size() > 0) {
                    x.c("Size of crash list: %s", Integer.valueOf(a2.size()));
                    int size = a2.size();
                    if (size > 20) {
                        ArrayList arrayList2 = new ArrayList();
                        Collections.sort(a2);
                        for (int i = 0; i < 20; i++) {
                            arrayList2.add(a2.get((size - 1) - i));
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = a2;
                    }
                    c.this.p.a(arrayList, 0L, false, false, false);
                }
                z.b(c.this.f6079q, "local_crash_lock");
            }
        }
    }

    public final void a(long j2) {
        w.a().a(new AnonymousClass2(), j2);
    }

    public final void l() {
        this.t.checkUploadRecordCrash();
    }

    public final void m() {
        if (com.tencent.bugly.crashreport.common.info.a.b().f6008d.equals(AppInfo.a(this.f6079q))) {
            this.t.removeEmptyNativeRecordFiles();
        }
    }

    public final void a(int i2) {
        this.y = i2;
    }

    public final void a(boolean z) {
        this.z = z;
    }

    public final boolean n() {
        return this.z;
    }

    public final boolean o() {
        return (this.y & 16) > 0;
    }

    public final boolean p() {
        return (this.y & 8) > 0;
    }

    public final boolean q() {
        return (this.y & 4) > 0;
    }

    public final boolean r() {
        return (this.y & 2) > 0;
    }

    public final boolean s() {
        return (this.y & 1) > 0;
    }
}

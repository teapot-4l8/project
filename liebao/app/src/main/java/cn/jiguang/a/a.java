package cn.jiguang.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.an.d;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f3639a = ".permission.JPUSH_MESSAGE";

    /* renamed from: b  reason: collision with root package name */
    public static String f3640b = "2.2.8";

    /* renamed from: c  reason: collision with root package name */
    public static int f3641c = 228;

    /* renamed from: d  reason: collision with root package name */
    public static String f3642d = "";

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f3643e;
    private static Boolean f;
    private static ServiceConnection g = new b();

    public static void a(Context context, String str, Bundle bundle) {
        cn.jiguang.ba.a.a("SDK_INIT", new c(context, false, str, bundle));
    }

    public static void a(Context context, boolean z, long j) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z);
            bundle.putLong("delay_time", j);
            a(context, "tcp_a2", bundle);
        } catch (Throwable th) {
            d.g("JCoreGobal", "sendHeartBeat error:" + th);
        }
    }

    public static synchronized boolean a(Context context) {
        synchronized (a.class) {
            if (f3643e != null) {
                return f3643e.booleanValue();
            } else if (context == null) {
                d.i("JCoreGobal", "init failed,context is null");
                return false;
            } else {
                d.e("JCoreGobal", "action:init jcore,version:" + f3640b + ",build id:68");
                d.b("JCoreGobal", "build type:release");
                JConstants.mApplicationContext = context.getApplicationContext();
                Context applicationContext = context.getApplicationContext();
                cn.jiguang.am.b.a();
                String b2 = cn.jiguang.am.c.b(applicationContext);
                if ((cn.jiguang.am.b.a().c() || cn.jiguang.am.b.a().b()) && TextUtils.isEmpty(b2)) {
                    f3643e = false;
                    d.i("JCoreGobal", "AndroidManifest.xml missing required service:" + JCommonService.class.getCanonicalName() + ",please custom one service and extends JCommonService");
                    return false;
                }
                cn.jiguang.b.a.a().b();
                String b3 = cn.jiguang.am.c.b(applicationContext);
                if (TextUtils.isEmpty(b3)) {
                    d.d("JCoreGobal", "not found commonServiceClass（JCommonService）");
                } else if (DataShare.isBinding()) {
                    d.b("JCoreGobal", "is binding service");
                } else {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(applicationContext, Class.forName(b3));
                        if (applicationContext.bindService(intent, g, 1)) {
                            d.a("JCoreGobal", "Remote Service on binding...");
                            DataShare.setBinding();
                        } else {
                            d.a("JCoreGobal", "Remote Service bind failed");
                        }
                    } catch (SecurityException unused) {
                        d.g("JCoreGobal", "Remote Service bind failed caused by SecurityException!");
                    } catch (Throwable th) {
                        d.g("JCoreGobal", "Remote Service bind failed :" + th);
                    }
                }
                Boolean bool = true;
                f3643e = bool;
                return bool.booleanValue();
            }
        }
    }

    public static void b(Context context, String str, Bundle bundle) {
        cn.jiguang.ba.a.a("SDK_SERVICE_INIT", new c(context, true, str, bundle));
    }

    public static synchronized boolean b(Context context) {
        synchronized (a.class) {
            if (f != null) {
                return f.booleanValue();
            } else if (context == null) {
                d.i("JCoreGobal", "init failed,context is null");
                return false;
            } else {
                d.b("JCoreGobal", "serviceInit...");
                JConstants.mApplicationContext = context.getApplicationContext();
                Context applicationContext = context.getApplicationContext();
                if (!cn.jiguang.am.a.d(applicationContext)) {
                    Boolean bool = false;
                    f = bool;
                    return bool.booleanValue();
                }
                JCoreInternalHelper.getInstance().onEvent(applicationContext, JConstants.SDK_TYPE, 65, true, "", null, 1);
                cn.jiguang.am.b.a();
                try {
                    JConstants.isCallInit.set(true);
                } catch (Throwable unused) {
                }
                IntentFilter intentFilter = new IntentFilter();
                PushReceiver pushReceiver = new PushReceiver();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                String str = applicationContext.getPackageName() + f3639a;
                applicationContext.registerReceiver(pushReceiver, intentFilter, str, null);
                if (!cn.jiguang.f.a.a(applicationContext, PushReceiver.class)) {
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter2.addDataScheme("package");
                    applicationContext.registerReceiver(pushReceiver, intentFilter2, str, null);
                }
                f = true;
                cn.jiguang.b.a.a();
                cn.jiguang.b.a.c(applicationContext);
                cn.jiguang.at.d.a(applicationContext, "service_create", null);
                return f.booleanValue();
            }
        }
    }
}

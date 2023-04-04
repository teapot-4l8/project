package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5967a = true;

    /* renamed from: b  reason: collision with root package name */
    public static List<a> f5968b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f5969c;

    /* renamed from: d  reason: collision with root package name */
    private static p f5970d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f5971e;

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        List<String> list = aVar.p;
        aVar.getClass();
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (f5971e) {
                x.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(x.f6265a, "[init] context of init() is null, check it.");
            } else {
                com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (a(a2)) {
                    f5967a = false;
                    return;
                }
                String f = a2.f();
                if (f == null) {
                    Log.e(x.f6265a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                } else {
                    a(context, f, a2.v, buglyStrategy);
                }
            }
        }
    }

    public static synchronized void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (b.class) {
            if (f5971e) {
                x.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(x.f6265a, "[init] context is null, check it.");
            } else if (str == null) {
                Log.e(x.f6265a, "init arg 'crashReportAppID' should not be null!");
            } else {
                f5971e = true;
                if (z) {
                    f5969c = true;
                    x.f6266b = true;
                    x.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    x.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    x.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    x.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    x.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    x.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    x.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    x.b("[init] Open debug mode of Bugly.", new Object[0]);
                }
                x.a(" crash report start initializing...", new Object[0]);
                x.b("[init] Bugly start initializing...", new Object[0]);
                x.a("[init] Bugly complete version: v%s", "3.1.9");
                Context a2 = z.a(context);
                com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(a2);
                a3.t();
                y.a(a2);
                f5970d = p.a(a2, f5968b);
                u.a(a2);
                com.tencent.bugly.crashreport.common.strategy.a a4 = com.tencent.bugly.crashreport.common.strategy.a.a(a2, f5968b);
                n a5 = n.a(a2);
                if (a(a3)) {
                    f5967a = false;
                    return;
                }
                a3.a(str);
                x.a("[param] Set APP ID:%s", str);
                if (buglyStrategy != null) {
                    String appVersion = buglyStrategy.getAppVersion();
                    if (!TextUtils.isEmpty(appVersion)) {
                        if (appVersion.length() > 100) {
                            String substring = appVersion.substring(0, 100);
                            x.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                            appVersion = substring;
                        }
                        a3.k = appVersion;
                        x.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                    }
                    try {
                        if (buglyStrategy.isReplaceOldChannel()) {
                            String appChannel = buglyStrategy.getAppChannel();
                            if (!TextUtils.isEmpty(appChannel)) {
                                if (appChannel.length() > 100) {
                                    String substring2 = appChannel.substring(0, 100);
                                    x.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                    appChannel = substring2;
                                }
                                f5970d.a(556, "app_channel", appChannel.getBytes(), (o) null, false);
                                a3.m = appChannel;
                            }
                        } else {
                            Map<String, byte[]> a6 = f5970d.a(556, (o) null, true);
                            if (a6 != null && (bArr = a6.get("app_channel")) != null) {
                                a3.m = new String(bArr);
                            }
                        }
                        x.a("[param] Set App channel: %s", a3.m);
                    } catch (Exception e2) {
                        if (f5969c) {
                            e2.printStackTrace();
                        }
                    }
                    String appPackageName = buglyStrategy.getAppPackageName();
                    if (!TextUtils.isEmpty(appPackageName)) {
                        if (appPackageName.length() > 100) {
                            String substring3 = appPackageName.substring(0, 100);
                            x.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                            appPackageName = substring3;
                        }
                        a3.f6007c = appPackageName;
                        x.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                    }
                    String deviceID = buglyStrategy.getDeviceID();
                    if (deviceID != null) {
                        if (deviceID.length() > 100) {
                            String substring4 = deviceID.substring(0, 100);
                            x.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                            deviceID = substring4;
                        }
                        a3.c(deviceID);
                        x.a("[param] Set device ID: %s", deviceID);
                    }
                    a3.f6009e = buglyStrategy.isUploadProcess();
                    y.f6268a = buglyStrategy.isBuglyLogUpload();
                }
                for (int i = 0; i < f5968b.size(); i++) {
                    if (a5.a(f5968b.get(i).id)) {
                        f5968b.get(i).init(a2, z, buglyStrategy);
                    }
                }
                com.tencent.bugly.crashreport.biz.b.a(a2, buglyStrategy);
                a4.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                x.b("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (!f5968b.contains(aVar)) {
                f5968b.add(aVar);
            }
        }
    }
}

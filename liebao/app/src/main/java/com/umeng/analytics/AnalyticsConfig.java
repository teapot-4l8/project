package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.j;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_SP_FILE = "um_rtd_conf";
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a  reason: collision with root package name */
    static double[] f6302a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6303b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f6304c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f6305d = null;

    /* renamed from: e  reason: collision with root package name */
    private static int f6306e = 0;
    public static boolean enable = true;
    private static Object f = new Object();
    private static boolean g = false;
    private static String h = "";
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f) {
            g = true;
            if (map != null && map.containsKey(DEBUG_KEY)) {
                h = map.get(DEBUG_KEY);
            }
        }
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f) {
            g = false;
            h = "";
        }
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f) {
            z = g;
        }
        return z;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f) {
            str = h;
        }
        return str;
    }

    static void a(String str) {
        f6304c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static double[] getLocation() {
        return f6302a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f6305d = str;
            com.umeng.common.b.a(context).a(f6305d);
            return;
        }
        UMLog.aq(j.A, 0, "\\|");
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f6305d)) {
            f6305d = com.umeng.common.b.a(context).c();
        }
        return f6305d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, int i) {
        f6306e = i;
        com.umeng.common.b.a(context).a(f6306e);
    }

    public static int getVerticalType(Context context) {
        if (f6306e == 0) {
            f6306e = com.umeng.common.b.a(context).d();
        }
        return f6306e;
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            if (cls != null) {
                return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

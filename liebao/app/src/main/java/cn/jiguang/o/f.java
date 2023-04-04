package cn.jiguang.o;

import android.content.Context;
import android.content.SharedPreferences;
import cn.jiguang.internal.JConstants;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f4175a;

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, Long> f4176b;

    public static int a(Context context) {
        return l(context).getInt("rrat", 1);
    }

    private static String a(String str, String str2) {
        return str + str2;
    }

    public static void a(Context context, int i) {
        l(context).edit().putInt("rrat", i).apply();
    }

    public static void a(Context context, long j) {
        l(context).edit().putLong("copy_time", j).apply();
    }

    public static void a(Context context, String str, int i) {
        l(context).edit().putInt(a("JType", "ktsv_" + str), i).apply();
    }

    public static void a(Context context, String str, long j) {
        if (j < 0) {
            return;
        }
        if (!str.contains("JLocation") || j <= g(context, str)) {
            String a2 = a(str, "_bi");
            cn.jiguang.ad.a.c("JCommonConfig", "update " + str + " businessInterval:" + j);
            l(context).edit().putLong(a2, j).apply();
        }
    }

    public static void a(Context context, String str, String str2) {
        l(context).edit().putString(a("JType", str), str2).apply();
    }

    public static void a(Context context, String str, boolean z) {
        l(context).edit().putBoolean(a(str, "_ace"), z).apply();
    }

    public static void a(Context context, boolean z) {
        l(context).edit().putBoolean("JArponceEnable", z).apply();
    }

    public static boolean a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long d2 = d(context, str);
        long j = l(context).getLong(a(str, "_bi"), b(str, "_bi"));
        boolean z = currentTimeMillis - d2 > j;
        cn.jiguang.ad.a.c("JCommonConfig", "is " + str + " businessTime:" + z + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + d2 + ",businessInterval:" + j);
        return z;
    }

    public static int b(Context context) {
        return l(context).getInt("rrpt", 1);
    }

    private static long b(String str, String str2) {
        try {
            return f4176b.get(a(str, str2)).longValue();
        } catch (NullPointerException unused) {
            return 0L;
        }
    }

    public static void b(Context context, int i) {
        l(context).edit().putInt("rrpt", i).apply();
    }

    public static void b(Context context, long j) {
        l(context).edit().putLong("copy_report_time", j).apply();
    }

    public static void b(Context context, String str, long j) {
        if (j < 0) {
            return;
        }
        String a2 = a(str, "_ri");
        cn.jiguang.ad.a.c("JCommonConfig", "update " + str + " reportInterval:" + j);
        l(context).edit().putLong(a2, j).apply();
    }

    public static void b(Context context, String str, boolean z) {
        l(context).edit().putBoolean(a(str, "_aue"), z).apply();
    }

    public static boolean b(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long f = f(context, str);
        long g = g(context, str);
        boolean z = currentTimeMillis - f > g;
        cn.jiguang.ad.a.c("JCommonConfig", "is " + str + " reportTime:" + z + ",curTime:" + currentTimeMillis + ",lastReportTime:" + f + ",reportInterval:" + g);
        return z;
    }

    public static void c(Context context, String str) {
        if (!str.contains("JApp") || str.equals("JAppMovement")) {
            String a2 = a(str, "_blt");
            long currentTimeMillis = System.currentTimeMillis();
            cn.jiguang.ad.a.c("JCommonConfig", "update " + str + " lastBusinessTime");
            l(context).edit().putLong(a2, currentTimeMillis).apply();
        }
    }

    public static boolean c(Context context) {
        return l(context).getBoolean("JArponceEnable", false);
    }

    public static long d(Context context, String str) {
        return l(context).getLong(a(str, "_blt"), 0L);
    }

    public static String d(Context context) {
        return l(context).getString(a("JLocation", "info"), "");
    }

    public static String e(Context context) {
        return l(context).getString("JNotificationState", "");
    }

    public static void e(Context context, String str) {
        cn.jiguang.ad.a.c("JCommonConfig", "update " + str + " lastReportTime");
        long currentTimeMillis = System.currentTimeMillis();
        l(context).edit().putLong(a(str, "_rlt"), currentTimeMillis).apply();
    }

    public static long f(Context context, String str) {
        return l(context).getLong(a(str, "_rlt"), 0L);
    }

    public static String f(Context context) {
        return l(context).getString("JDevicesession", "");
    }

    public static long g(Context context, String str) {
        return l(context).getLong(a(str, "_ri"), b(str, "_ri"));
    }

    public static String g(Context context) {
        return l(context).getString("copy_config", "");
    }

    public static String h(Context context) {
        return l(context).getString("copy_history", "");
    }

    public static boolean h(Context context, String str) {
        return l(context).getBoolean(a(str, "_ace"), !str.equals("JArp"));
    }

    public static long i(Context context) {
        return l(context).getLong("copy_time", 0L);
    }

    public static boolean i(Context context, String str) {
        return l(context).getBoolean(a(str, "_aue"), true);
    }

    public static long j(Context context) {
        return l(context).getLong("copy_report_time", 0L);
    }

    public static String j(Context context, String str) {
        return l(context).getString(a("JType", str), "-1,-1");
    }

    public static int k(Context context, String str) {
        return l(context).getInt(a("JType", "ktsv_" + str), 0);
    }

    public static void k(Context context) {
        l(context).edit().remove("copy_config").remove("copy_history").remove("copy_time").remove("copy_report_time").apply();
    }

    private static SharedPreferences l(Context context) {
        if (f4175a == null) {
            f4175a = context.getSharedPreferences("cn.jiguang.common", 0);
            HashMap<String, Long> hashMap = new HashMap<>();
            f4176b = hashMap;
            hashMap.put(a("JLocation", "_bi"), 900000L);
            f4176b.put(a("JWake", "_bi"), Long.valueOf((long) JConstants.HOUR));
            f4176b.put(a("JWakeConfigHelper", "_bi"), Long.valueOf((long) JConstants.HOUR));
            f4176b.put(a("JArp", "_ri"), Long.valueOf((long) JConstants.HOUR));
            f4176b.put(a("JDeviceBattery", "_ri"), Long.valueOf((long) JConstants.HOUR));
            f4176b.put(a("JDevice", "_ri"), 86400000L);
            f4176b.put(a("JLocation", "_ri"), Long.valueOf((long) JConstants.HOUR));
            f4176b.put(a("JWake", "_ri"), Long.valueOf((long) JConstants.HOUR));
            f4176b.put(a("JAppMovement", "_bi"), Long.valueOf((long) JConstants.HOUR));
            f4176b.put(a("JAppAll", "_ri"), 604800000L);
            f4176b.put(a("JAppRunning", "_ri"), Long.valueOf((long) JConstants.HOUR));
        }
        return f4175a;
    }

    public static void l(Context context, String str) {
        l(context).edit().putBoolean(a("JArp", str), true).apply();
    }

    public static boolean m(Context context, String str) {
        return l(context).getBoolean(a("JArp", str), false);
    }

    public static void n(Context context, String str) {
        l(context).edit().putString(a("JLocation", "info"), str).apply();
    }

    public static void o(Context context, String str) {
        l(context).edit().putString("JNotificationState", str).apply();
    }

    public static void p(Context context, String str) {
        cn.jiguang.ad.a.c("JCommonConfig", "update deviceSession");
        l(context).edit().putString("JDevicesession", str).apply();
    }

    public static void q(Context context, String str) {
        l(context).edit().putString("copy_config", str).apply();
    }

    public static void r(Context context, String str) {
        l(context).edit().putString("copy_history", str).apply();
    }
}

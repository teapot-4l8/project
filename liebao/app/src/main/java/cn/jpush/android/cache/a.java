package cn.jpush.android.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f4306a;

    public static void a(Context context) {
        f4306a = context.getSharedPreferences("cn.jpush.config", 0);
    }

    public static void a(Context context, int i) {
        l(context).edit().putInt("service_stoped", i).apply();
    }

    public static void a(Context context, long j) {
        if (j < 0) {
            Logger.w("PushConfig", "freeze end time was incorrect!");
            return;
        }
        if (j > 1800) {
            Logger.i("PushConfig", "freeze end time was greate than half an hour");
            j = 1800;
        }
        l(context).edit().putLong("TAFreezeSetTime", System.currentTimeMillis()).putLong("TAFreezeEndTime", j * 1000).apply();
    }

    public static void a(Context context, String str) {
        l(context).edit().putString("mobile_number", str).apply();
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = l(context).edit();
        edit.putString("jpush_save_custom_builder" + str, str2).apply();
    }

    public static void a(Context context, boolean z) {
        l(context).edit().putBoolean("notification_enabled", z).apply();
    }

    public static int b(Context context) {
        SharedPreferences reload = Sp.reload(context, "cn.jpush.config");
        if (reload == null) {
            reload = l(context);
        }
        int i = reload.getInt("service_stoped", -1);
        if (i < 0) {
            int i2 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getInt("service_stoped", 0);
            a(context, i2);
            return i2;
        }
        return i;
    }

    public static void b(Context context, int i) {
        l(context).edit().putInt("notification_num", i).apply();
    }

    public static void b(Context context, long j) {
        l(context).edit().putLong("geofence_interval", j).apply();
    }

    public static void b(Context context, String str) {
        l(context).edit().putString("setting_push_time", str).apply();
    }

    public static void b(Context context, boolean z) {
        l(context).edit().putBoolean("push_lbs_enable", z).apply();
    }

    public static long c(Context context, long j) {
        long j2 = l(context).getLong("geofence_interval", -1L);
        if (j2 == -1) {
            j2 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getLong("geofence_interval", -1L);
            if (j2 != -1) {
                b(context, j2);
            }
        }
        return j2 == -1 ? j : j2;
    }

    public static void c(Context context, int i) {
        l(context).edit().putInt("geofence_max_num", i).apply();
    }

    public static void c(Context context, String str) {
        l(context).edit().putString("setting_silence_push_time", str).apply();
    }

    public static boolean c(Context context) {
        boolean z = b(context) >= 1;
        if (z) {
            Logger.dd("PushConfig", "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.");
        }
        return z;
    }

    public static int d(Context context, int i) {
        int i2 = l(context).getInt("geofence_max_num", -1);
        if (i2 == -1 && (i2 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getInt("geofence_max_num", -1)) != -1) {
            c(context, i2);
        }
        return i2 == -1 ? i : i2;
    }

    public static String d(Context context) {
        return l(context).getString("mobile_number", null);
    }

    public static String d(Context context, String str) {
        SharedPreferences l = l(context);
        String string = l.getString("jpush_save_custom_builder" + str, "");
        if (TextUtils.isEmpty(string)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jpush.android.user.profile", 0);
            String string2 = sharedPreferences.getString("jpush_save_custom_builder" + str, "");
            a(context, str, string2);
            return string2;
        }
        return string;
    }

    public static void e(Context context, String str) {
        l(context).edit().putString("push_ssp_last_state", str).apply();
    }

    public static boolean e(Context context) {
        return l(context).getBoolean("notification_enabled", true);
    }

    public static String f(Context context) {
        return l(context).getString("setting_push_time", "");
    }

    public static String g(Context context) {
        return l(context).getString("setting_silence_push_time", "");
    }

    public static int h(Context context) {
        return l(context).getInt("notification_num", JPushInterface.DEFAULT_NOTIFICATION_NUM);
    }

    public static boolean i(Context context) {
        long j = l(context).getLong("TAFreezeEndTime", -1L);
        if (j > 1800) {
            j = 0;
        }
        long j2 = l(context).getLong("TAFreezeSetTime", -1L);
        if (j == -1 || j2 == -1) {
            return false;
        }
        if (System.currentTimeMillis() - j2 < 0 || System.currentTimeMillis() - j2 > j) {
            l(context).edit().putLong("TAFreezeSetTime", -1L).putLong("TAFreezeEndTime", -1L).apply();
            Logger.w("PushConfig", "incorrect timestamp");
            return true;
        }
        return false;
    }

    public static boolean j(Context context) {
        return l(context).getBoolean("push_lbs_enable", true);
    }

    public static String k(Context context) {
        return l(context).getString("push_ssp_last_state", "0,0");
    }

    private static SharedPreferences l(Context context) {
        if (f4306a == null) {
            a(context);
        }
        return f4306a;
    }
}

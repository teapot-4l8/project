package cn.jiguang.r;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.jiguang.f.i;
import cn.jiguang.u.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f4211a;

    public static String a(Context context) {
        return b(context, "number_version", "1.3.0");
    }

    public static String a(Context context, int i) {
        if (i < 0 || i >= 3) {
            return "http://182.92.20.189:9099/";
        }
        return b(context, "number_url" + i, "http://182.92.20.189:9099/");
    }

    public static void a(Context context, String str) {
        String a2 = d.a(context);
        if (i.a(a2)) {
            a2 = "number_num";
        }
        a(context, a2, str);
    }

    public static void a(Context context, String str, String str2) {
        g(context).edit().putString(str, cn.jiguang.bb.d.a(str2)).apply();
    }

    public static void a(Context context, boolean z) {
        g(context).edit().putBoolean("nb_upload", z).apply();
    }

    public static String b(Context context) {
        return b(context, "number_appid", "7");
    }

    private static String b(Context context, String str, String str2) {
        String string = g(context).getString(str, "");
        if (i.a(string)) {
            return str2;
        }
        String b2 = cn.jiguang.bb.d.b(string);
        return !TextUtils.isEmpty(b2) ? b2 : str2;
    }

    public static String c(Context context) {
        return b(context, "number_appsecret", "2b90de0f1f88eaf49593f1d827b19c63");
    }

    public static String d(Context context) {
        String a2 = d.a(context);
        if (i.a(a2)) {
            a2 = "number_num";
        }
        return b(context, a2, "");
    }

    public static boolean e(Context context) {
        return g(context).getBoolean("nb_upload", false);
    }

    public static void f(Context context) {
        g(context).edit().putLong("nb_lasttime", System.currentTimeMillis()).apply();
    }

    private static SharedPreferences g(Context context) {
        if (f4211a == null) {
            f4211a = context.getSharedPreferences("cn.jiguang.common.pn", 0);
        }
        return f4211a;
    }
}

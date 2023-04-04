package cn.jiguang.al;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    private static SharedPreferences f3728d;

    /* renamed from: b  reason: collision with root package name */
    private static final String f3726b = d.a("LmV4dENvbmZpZw==");

    /* renamed from: c  reason: collision with root package name */
    private static final String f3727c = d.a("ZXh0LQ==");

    /* renamed from: e  reason: collision with root package name */
    private static final String f3729e = d.a("MTJlNDU2N2c5MWszNHI2Nw==");

    /* renamed from: a  reason: collision with root package name */
    public static final String f3725a = d.a("MDEwMjAzMDQwNTA2MDcwOA");

    public static String a(Context context, int i, String str) {
        if (f3728d == null) {
            f3728d = context.getSharedPreferences(f3726b, 0);
        }
        SharedPreferences sharedPreferences = f3728d;
        String string = sharedPreferences.getString(f3727c + str + "-" + i, "");
        StringBuilder sb = new StringBuilder("g1:");
        sb.append(string);
        cn.jiguang.an.d.b("JC", sb.toString());
        if (!"".equals(string)) {
            try {
                string = new String(cn.jiguang.bb.d.a(string, f3729e, f3725a));
            } catch (Exception unused) {
                cn.jiguang.an.d.b("JC", "decrypt plugin failed");
            }
        }
        cn.jiguang.an.d.b("JC", "g2:" + string);
        return string;
    }

    public static void a(Context context, int i, String str, String str2) {
        if (f3728d == null) {
            f3728d = context.getSharedPreferences(f3726b, 0);
        }
        try {
            cn.jiguang.an.d.b("JC", "s1:" + str2);
            str2 = cn.jiguang.bb.d.a(str2.getBytes(), f3729e, f3725a);
            cn.jiguang.an.d.b("JC", "s2:" + str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        SharedPreferences.Editor edit = f3728d.edit();
        edit.putString(f3727c + str + "-" + i, str2);
        edit.commit();
    }
}

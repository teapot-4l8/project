package com.lxj.xpopup.g.a;

import android.text.TextUtils;

/* compiled from: OSUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static boolean a() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public static boolean b() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public static String c() {
        return b() ? a("ro.build.version.emui", "") : "";
    }

    public static boolean d() {
        String c2 = c();
        return "EmotionUI 3".equals(c2) || c2.contains("EmotionUI_3.1");
    }

    public static boolean e() {
        return c().contains("EmotionUI_3.0");
    }

    public static boolean f() {
        return e() || d();
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }
}

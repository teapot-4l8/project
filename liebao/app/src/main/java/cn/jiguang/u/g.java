package cn.jiguang.u;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f4233a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f4234b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f4235c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f4236d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f4237e = "";
    private static String f = "";

    public static String a() {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains("huawei")) {
                if (TextUtils.isEmpty(f4233a)) {
                    String a2 = a("ro.build.version.emui");
                    f4233a = a2;
                    return a2;
                }
                return f4233a;
            } else if (lowerCase.contains("xiaomi")) {
                if (TextUtils.isEmpty(f4237e)) {
                    String a3 = a("ro.miui.ui.version.name");
                    f4237e = a3;
                    return a3;
                }
                return f4237e;
            } else if (lowerCase.contains("meizu")) {
                if (TextUtils.isEmpty(f)) {
                    String a4 = a("ro.build.display.id");
                    f = a4;
                    return a4;
                }
                return f;
            } else {
                if (!lowerCase.contains("oppo") && !lowerCase.contains("realme")) {
                    if (lowerCase.contains("vivo")) {
                        if (TextUtils.isEmpty(f4235c)) {
                            String a5 = a("ro.vivo.os.build.display.id");
                            f4235c = a5;
                            return a5;
                        }
                        return f4235c;
                    } else if (lowerCase.contains("oneplus")) {
                        if (TextUtils.isEmpty(f4236d)) {
                            String a6 = a("ro.rom.version");
                            f4236d = a6;
                            return a6;
                        }
                        return f4236d;
                    } else {
                        return "";
                    }
                }
                if (TextUtils.isEmpty(f4234b)) {
                    String a7 = a("ro.build.version.opporom");
                    f4234b = a7;
                    return a7;
                }
                return f4234b;
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            cn.jiguang.ad.a.c("JRomVersionHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            cn.jiguang.ad.a.f("JRomVersionHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }
}

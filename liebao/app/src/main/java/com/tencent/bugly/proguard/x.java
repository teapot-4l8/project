package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static String f6265a = "CrashReport";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f6266b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f6267c = "CrashReportInfo";

    private static boolean a(int i, String str, Object... objArr) {
        if (f6266b) {
            if (str == null) {
                str = "null";
            } else if (objArr != null && objArr.length != 0) {
                str = String.format(Locale.US, str, objArr);
            }
            if (i == 0) {
                Log.i(f6265a, str);
                return true;
            } else if (i == 1) {
                Log.d(f6265a, str);
                return true;
            } else if (i == 2) {
                Log.w(f6265a, str);
                return true;
            } else if (i == 3) {
                Log.e(f6265a, str);
                return true;
            } else if (i != 5) {
                return false;
            } else {
                Log.i(f6267c, str);
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean a(Throwable th) {
        if (f6266b) {
            return a(2, z.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Throwable th) {
        if (f6266b) {
            return a(3, z.a(th), new Object[0]);
        }
        return false;
    }
}

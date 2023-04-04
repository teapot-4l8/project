package com.snail.antifake.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.snail.antifake.a.b;
import com.snail.antifake.jni.PropertiesGet;

/* compiled from: EmuCheckUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(Context context) {
        return c(context) || b(context) || b() || a();
    }

    public static boolean b(Context context) {
        if (TextUtils.isEmpty(PropertiesGet.a("ro.product.model")) || !PropertiesGet.a("ro.product.model").toLowerCase().contains("sdk")) {
            if (TextUtils.isEmpty(PropertiesGet.a("ro.product.manufacturer")) || !PropertiesGet.a("ro.product.manufacture").toLowerCase().contains("unknown")) {
                return !TextUtils.isEmpty(PropertiesGet.a("ro.product.device")) && PropertiesGet.a("ro.product.device").toLowerCase().contains("generic");
            }
            return true;
        }
        return true;
    }

    public static boolean c(Context context) {
        return "1".equals(PropertiesGet.a("ro.kernel.qemu"));
    }

    private static boolean a() {
        b.a a2 = b.a("cat /proc/cpuinfo", false);
        String str = a2 == null ? "" : a2.f5536b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("intel") || str.toLowerCase().contains("amd");
    }

    private static boolean b() {
        String a2 = com.snail.antifake.a.a.a();
        return !TextUtils.isEmpty(a2) && a2.contains("x86");
    }
}

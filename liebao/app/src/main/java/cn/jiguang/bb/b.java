package cn.jiguang.bb;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import cn.jiguang.f.e;
import cn.jiguang.f.i;
import cn.jiguang.internal.JConstants;
import java.io.File;
import java.util.UUID;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f4041a = 1;

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str;
        String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a());
        if (i.h(str2)) {
            f4041a = 3;
            return str2;
        }
        String b2 = b(context, str2);
        if (i.h(b2)) {
            f4041a = 1;
            d(context, b2);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.a().a((cn.jiguang.g.a<String>) b2));
            return b2;
        }
        if (!JConstants.isAndroidQ(context, true, "do not get deviceId from SD") && cn.jiguang.f.a.c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            String b3 = cn.jiguang.f.a.b();
            if (TextUtils.isEmpty(b3)) {
                cn.jiguang.an.d.h("DeviceIdUtils", "can't get sdcard data path");
            } else {
                String b4 = e.b(new File(b3 + ".push_deviceid"));
                if (b4 != null) {
                    int indexOf = b4.indexOf("\n");
                    if (indexOf >= 0) {
                        b4 = b4.substring(0, indexOf);
                    }
                    str = b4.trim();
                    if (!i.h(str)) {
                        f4041a = 2;
                        c(context, str);
                        cn.jiguang.g.b.a(context, cn.jiguang.g.a.a().a((cn.jiguang.g.a<String>) str));
                        return str;
                    }
                    String d2 = Build.VERSION.SDK_INT < 23 ? cn.jiguang.f.a.d(context, str) : "";
                    String g = cn.jiguang.f.a.g(context);
                    String f = cn.jiguang.f.a.f(context, "");
                    String uuid = UUID.randomUUID().toString();
                    String d3 = i.d(d2 + g + f + uuid);
                    if (!TextUtils.isEmpty(d3)) {
                        uuid = d3;
                    }
                    cn.jiguang.g.b.a(context, cn.jiguang.g.a.a().a((cn.jiguang.g.a<String>) uuid));
                    f4041a = 0;
                    c(context, uuid);
                    d(context, uuid);
                    return uuid;
                }
            }
        }
        str = null;
        if (!i.h(str)) {
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(context, str);
        d(context, str);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.a().a((cn.jiguang.g.a<String>) str));
    }

    private static String b(Context context, String str) {
        if (cn.jiguang.f.a.c(context, "android.permission.WRITE_SETTINGS")) {
            try {
                return Settings.System.getString(context.getContentResolver(), "dig");
            } catch (Throwable unused) {
                cn.jiguang.an.d.h("DeviceIdUtils", "Can not read from settings");
                return str;
            }
        }
        return str;
    }

    private static String c(Context context, String str) {
        if (cn.jiguang.f.a.c(context, "android.permission.WRITE_SETTINGS")) {
            try {
                if (Settings.System.putString(context.getContentResolver(), "dig", str)) {
                    return str;
                }
                return null;
            } catch (Throwable unused) {
                cn.jiguang.an.d.h("DeviceIdUtils", "Can not write settings");
                return null;
            }
        }
        return null;
    }

    private static String d(Context context, String str) {
        if (JConstants.isAndroidQ(context, true, "not write deviceId to SD")) {
            return str;
        }
        if (cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            try {
                String b2 = cn.jiguang.f.a.b();
                if (TextUtils.isEmpty(b2)) {
                    cn.jiguang.an.d.h("DeviceIdUtils", "can't get sdcard data path");
                    return null;
                }
                e.a(new File(b2 + ".push_deviceid"), str);
                return str;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}

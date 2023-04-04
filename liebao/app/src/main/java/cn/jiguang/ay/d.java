package cn.jiguang.ay;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.f.e;
import cn.jiguang.f.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f4023a;

    static {
        ArrayList arrayList = new ArrayList();
        f4023a = arrayList;
        arrayList.add("358673013795895");
        f4023a.add("004999010640000");
        f4023a.add("00000000000000");
        f4023a.add("000000000000000");
    }

    public static String a(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.C());
        if (!TextUtils.isEmpty(str)) {
            str = new String(Base64.decode(str, 2));
        }
        if (a(str)) {
            return str;
        }
        String b2 = b(context);
        if (!TextUtils.isEmpty(b2)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.C().a((cn.jiguang.g.a<String>) Base64.encodeToString(b2.getBytes(), 2)));
        }
        return b2;
    }

    private static boolean a(String str) {
        if (i.h(str) && str.length() >= 10) {
            for (String str2 : f4023a) {
                if (str.startsWith(str2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static String b(Context context) {
        try {
            String str = a.a(context).f4017q;
            if (a(str)) {
                return str;
            }
            String str2 = a.a(context).i;
            if (!a(str2) || "9774d56d682e549c".equals(str2.toLowerCase(Locale.getDefault()))) {
                String h = cn.jiguang.d.a.i(context) ? cn.jiguang.f.a.h(context) : "";
                if (!a(h) && (h = c(context)) == null) {
                    h = " ";
                }
                return a(h) ? h : "";
            }
            return str2;
        } catch (Exception e2) {
            cn.jiguang.an.d.b("UDIDUtils", "", e2);
            String c2 = c(context);
            return a(c2) ? c2 : "";
        }
    }

    private static String c(Context context) {
        cn.jiguang.an.d.b("UDIDUtils", "Action:getSavedUuid");
        String str = (String) cn.jiguang.g.b.b(context, cn.jiguang.g.a.R());
        if (i.a(str)) {
            if (cn.jiguang.f.a.a()) {
                String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.D());
                return TextUtils.isEmpty(str2) ? (Build.VERSION.SDK_INT < 23 || (cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE") && cn.jiguang.f.a.c(context, "android.permission.READ_EXTERNAL_STORAGE"))) ? d(context) : e(context) : str2;
            }
            return e(context);
        }
        return str;
    }

    private static String d(Context context) {
        String str;
        String b2 = cn.jiguang.f.a.b();
        if (b2 == null) {
            str = null;
        } else {
            str = b2 + ".push_udid";
        }
        File file = i.a(str) ? null : new File(str);
        String b3 = e.b(file);
        if (!TextUtils.isEmpty(b3)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.D().a((cn.jiguang.g.a<String>) b3));
            cn.jiguang.an.d.d("UDIDUtils", "Got sdcard file saved udid - " + b3);
            return b3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        String k = i.k(UUID.nameUUIDFromBytes(sb.toString().getBytes()).toString());
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.D().a((cn.jiguang.g.a<String>) k));
        e.a(file, k);
        return k;
    }

    private static String e(Context context) {
        cn.jiguang.g.a<String> R = cn.jiguang.g.a.R();
        String str = (String) cn.jiguang.g.b.b(context, R);
        if (str == null) {
            String uuid = UUID.randomUUID().toString();
            cn.jiguang.g.b.a(context, R.a((cn.jiguang.g.a<String>) uuid));
            return uuid;
        }
        return str;
    }
}

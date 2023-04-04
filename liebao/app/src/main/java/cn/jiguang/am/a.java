package cn.jiguang.am;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.f.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f3730a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f3731b;

    /* renamed from: c  reason: collision with root package name */
    private static Pair<String, Integer> f3732c;

    /* renamed from: d  reason: collision with root package name */
    private static final ArrayList<String> f3733d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private static final ArrayList<String> f3734e = new ArrayList<>();
    private static final ArrayList<String> f;

    static {
        f3733d.add("android.permission.INTERNET");
        f3733d.add("android.permission.ACCESS_NETWORK_STATE");
        f3734e.add("android.permission.WAKE_LOCK");
        f3734e.add("android.permission.VIBRATE");
        f3734e.add("android.permission.CHANGE_WIFI_STATE");
        ArrayList<String> arrayList = new ArrayList<>();
        f = arrayList;
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        f.add("android.permission.ACCESS_COARSE_LOCATION");
        f.add("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS");
        f.add("android.permission.ACCESS_WIFI_STATE");
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f3730a)) {
            try {
                if (context != null) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && applicationInfo.metaData != null) {
                        String a2 = a(applicationInfo.metaData, "JPUSH_APPKEY");
                        f3730a = a2;
                        if (!TextUtils.isEmpty(a2)) {
                            f3730a = f3730a.toLowerCase(Locale.getDefault());
                        }
                    }
                } else {
                    cn.jiguang.an.d.b("CheckManifestHelper", "[getAppKey] context is null");
                }
            } catch (Throwable unused) {
            }
        }
        return f3730a;
    }

    public static String a(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static void a(Context context, String str) {
        f3731b = str;
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.l().a((cn.jiguang.g.a<String>) str));
        b(context);
    }

    public static String b(Context context) {
        StringBuilder sb;
        if (f3731b == null && context != null) {
            try {
                String str = (String) cn.jiguang.g.b.b(context, cn.jiguang.g.a.l());
                f3731b = str;
                if (str != null) {
                    sb = new StringBuilder("get option channel - ");
                    sb.append(f3731b);
                } else {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && applicationInfo.metaData != null) {
                        String a2 = a(applicationInfo.metaData, "JPUSH_CHANNEL");
                        f3731b = a2;
                        if (!TextUtils.isEmpty(a2)) {
                            f3731b = i.b(f3731b);
                        }
                    }
                    sb = new StringBuilder("manifest:channel - ");
                    sb.append(f3731b);
                }
                cn.jiguang.an.d.c("CheckManifestHelper", sb.toString());
            } catch (Throwable unused) {
            }
        }
        return f3731b;
    }

    public static Pair<String, Integer> c(Context context) {
        if (f3732c == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String str = packageInfo.versionName;
                if (str != null && str.length() > 30) {
                    str = str.substring(0, 30);
                }
                f3732c = new Pair<>(str, Integer.valueOf(packageInfo.versionCode));
            } catch (Throwable unused) {
                cn.jiguang.an.d.c("CheckManifestHelper", "NO versionCode or versionName defined in manifest.");
            }
        }
        return f3732c;
    }

    public static boolean d(Context context) {
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            cn.jiguang.an.d.i("CheckManifestHelper", "errorcode:10001,metadata: JCore appKey - not defined in manifest");
            cn.jiguang.f.a.a(context, " 未在manifest中配置AppKey", -1);
            return false;
        } else if (a2.length() != 24) {
            cn.jiguang.an.d.i("CheckManifestHelper", "errorcode:1008,Invalid appKey : " + a2 + ", Please get your Appkey from JIGUANG web console!");
            cn.jiguang.f.a.a(context, " AppKey:" + a2 + " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致", -1);
            return false;
        } else {
            b(context);
            if (b.a().c() || b.a().b()) {
                String str = context.getPackageName() + cn.jiguang.a.a.f3639a;
                if (!cn.jiguang.f.a.h(context, str)) {
                    cn.jiguang.an.d.i("CheckManifestHelper", "The permission should be defined - " + str);
                    return false;
                }
                f3733d.add(str);
            }
            Iterator<String> it = f3733d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!cn.jiguang.f.a.c(context, next)) {
                    cn.jiguang.an.d.i("CheckManifestHelper", "The permissoin is required - " + next);
                    return false;
                }
            }
            if (Build.VERSION.SDK_INT < 23 && !cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                cn.jiguang.an.d.i("CheckManifestHelper", "The permissoin is required - android.permission.WRITE_EXTERNAL_STORAGE");
                return false;
            }
            Iterator<String> it2 = f3734e.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!cn.jiguang.f.a.h(context, next2)) {
                    cn.jiguang.an.d.f("CheckManifestHelper", "We recommend you add the permission - " + next2);
                }
            }
            Iterator<String> it3 = f.iterator();
            while (it3.hasNext()) {
                String next3 = it3.next();
                if (!cn.jiguang.f.a.h(context, next3)) {
                    cn.jiguang.an.d.f("CheckManifestHelper", "We recommend you add the permission - " + next3 + ", otherwise you can not locate the devices.");
                }
            }
            return true;
        }
    }
}

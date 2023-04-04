package cn.jpush.android.helper;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f4363a;

    /* renamed from: b  reason: collision with root package name */
    private static List<String> f4364b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Integer> f4365c;

    /* renamed from: d  reason: collision with root package name */
    private static Map<String, Integer> f4366d;

    /* renamed from: e  reason: collision with root package name */
    private static List<String> f4367e;
    private static String f;
    private static String g;
    private static String h;

    static {
        HashMap hashMap = new HashMap();
        f4365c = hashMap;
        hashMap.put("xiaomi", 1);
        f4365c.put("meizu", 1);
        f4365c.put("vivo", 1);
        f4365c.put("lge", 1);
        ArrayList arrayList = new ArrayList();
        f4363a = arrayList;
        arrayList.add("Smartisan");
        f4363a.add("Lenovo");
        ArrayList arrayList2 = new ArrayList();
        f4364b = arrayList2;
        arrayList2.add("MI 5C");
        ArrayList arrayList3 = new ArrayList();
        f4367e = arrayList3;
        arrayList3.add("nubia");
        HashMap hashMap2 = new HashMap();
        f4366d = hashMap2;
        hashMap2.put("galaxy nexus", 1);
        f = "";
        g = "";
        h = "";
    }

    public static int a(Context context, int i, long j) {
        try {
            String[] split = cn.jpush.android.cache.a.k(context).split(",");
            int intValue = Integer.valueOf(split[0]).intValue();
            long longValue = Long.valueOf(split[1]).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (cn.jpush.android.u.b.a(currentTimeMillis, longValue)) {
                if (i == 0) {
                    Logger.d("SSPHelper", "ssp count is 0，not limit count");
                } else if (intValue >= i) {
                    Logger.d("SSPHelper", "ssp message count limit,sspLastCount:" + intValue + ",sspLimitCount:" + i);
                    return -1;
                }
                if (j == 0) {
                    Logger.d("SSPHelper", "ssp interval is 0，not limit time");
                } else if (currentTimeMillis - longValue <= j) {
                    Logger.d("SSPHelper", "ssp message time limit,sspLastTime:" + longValue + ",currentTime:" + currentTimeMillis + ",sspLimitInterval:" + j);
                    return -2;
                }
            } else {
                Logger.d("SSPHelper", "is a new day,reset sspState");
                cn.jpush.android.cache.a.e(context, "0,0");
            }
        } catch (Throwable th) {
            Logger.w("SSPHelper", "getSSPState error:" + th.getMessage());
        }
        return 0;
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            Logger.i("SSPHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            Logger.e("SSPHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    public static void a(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String[] split = cn.jpush.android.cache.a.k(context).split(",");
            int intValue = cn.jpush.android.u.b.a(currentTimeMillis, Long.valueOf(split[1]).longValue()) ? 1 + Integer.valueOf(split[0]).intValue() : 1;
            Logger.d("SSPHelper", "setSSPState sspCount:" + intValue + ",sspTime:" + currentTimeMillis);
            StringBuilder sb = new StringBuilder();
            sb.append(intValue);
            sb.append(",");
            sb.append(currentTimeMillis);
            cn.jpush.android.cache.a.e(context, sb.toString());
        } catch (Throwable th) {
            Logger.w("SSPHelper", "setSSPState error:" + th.getMessage());
        }
    }

    public static boolean a() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str) && f4363a != null && !f4363a.isEmpty()) {
                for (String str2 : f4363a) {
                    if (str2.toLowerCase().equals(str.toLowerCase())) {
                        Logger.d("SSPHelper", "black manufacturer:" + str);
                        return true;
                    }
                }
            }
            if (str.toLowerCase().equals("nubia") && Build.VERSION.SDK_INT < 23) {
                Logger.d("SSPHelper", "black manufacturer:" + str + ",black android version:" + Build.VERSION.SDK_INT);
                return true;
            }
        } catch (Throwable th) {
            Logger.d("SSPHelper", "manufacturer fiflter failed:" + th.getMessage());
        }
        try {
            String str3 = Build.MODEL;
            if (!TextUtils.isEmpty(str3) && f4364b != null && !f4364b.isEmpty()) {
                for (String str4 : f4364b) {
                    if (str4.toLowerCase().equals(str3.toLowerCase())) {
                        Logger.d("SSPHelper", "black model:" + str3);
                        return true;
                    }
                }
            }
        } catch (Throwable th2) {
            Logger.d("SSPHelper", "model fiflter failed:" + th2.getMessage());
        }
        String d2 = d();
        if (!TextUtils.isEmpty(d2) && d2.startsWith("EmotionUI_4.0")) {
            Logger.d("SSPHelper", "emuiVersion is in black:" + d2);
            return true;
        }
        try {
            String e2 = e();
            if (TextUtils.isEmpty(e2)) {
                return false;
            }
            if (e2.startsWith("Funtouch OS_4.0") || e2.startsWith("Funtouch OS_3.1") || e2.startsWith("Funtouch OS_9")) {
                Logger.d("SSPHelper", "vivoVersion is in black:" + e2);
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str) && f4365c != null && !f4365c.isEmpty() && f4365c.containsKey(str.toLowerCase())) {
                Logger.d("SSPHelper", "found notify style by manufacturer:" + str);
                return f4365c.get(str.toLowerCase()).intValue();
            }
        } catch (Throwable th) {
            Logger.d("SSPHelper", "manufacturer fiflter failed:" + th.getMessage());
        }
        try {
            String str2 = Build.MODEL;
            if (!TextUtils.isEmpty(str2) && f4366d != null && !f4366d.isEmpty() && f4366d.containsKey(str2.toLowerCase())) {
                Logger.d("SSPHelper", "found notify style by model:" + str2);
                return f4366d.get(str2.toLowerCase()).intValue();
            }
        } catch (Throwable th2) {
            Logger.d("SSPHelper", "model fiflter failed:" + th2.getMessage());
        }
        String f2 = f();
        if (TextUtils.isEmpty(f2)) {
            return 0;
        }
        if (f2.startsWith("V3.0") || f2.startsWith("V2.")) {
            Logger.d("SSPHelper", "oppo V2.X/V3.0 version use left-right notify style :" + f2);
            return -1;
        }
        return 0;
    }

    public static boolean c() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str) && f4367e != null && !f4367e.isEmpty()) {
                for (String str2 : f4367e) {
                    if (str2.toLowerCase().equals(str.toLowerCase())) {
                        Logger.d("SSPHelper", "one line manufacturer:" + str);
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            Logger.d("SSPHelper", "manufacturer fiflter failed:" + th.getMessage());
        }
        String f2 = f();
        if (TextUtils.isEmpty(f2)) {
            return false;
        }
        if (f2.startsWith("V3.2") || f2.startsWith("V3.1")) {
            Logger.d("SSPHelper", "oppo V3.1/V3.2 version use one line  qnotify style :" + f2);
            return true;
        }
        return false;
    }

    private static String d() {
        if (TextUtils.isEmpty(f)) {
            String a2 = a("ro.build.version.emui");
            f = a2;
            return a2;
        }
        return f;
    }

    private static String e() {
        if (TextUtils.isEmpty(h)) {
            String a2 = a("ro.vivo.os.build.display.id");
            h = a2;
            return a2;
        }
        return h;
    }

    private static String f() {
        if (TextUtils.isEmpty(g)) {
            String a2 = a("ro.build.version.opporom");
            g = a2;
            return a2;
        }
        return g;
    }
}

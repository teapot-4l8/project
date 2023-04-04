package cn.jiguang.aq;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.an.d;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.g.b;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f3802a;

    /* renamed from: b  reason: collision with root package name */
    public static int f3803b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3804c;

    /* renamed from: d  reason: collision with root package name */
    public static int f3805d;

    /* renamed from: e  reason: collision with root package name */
    private static final LinkedHashMap<String, Integer> f3806e;
    private static final LinkedHashMap<String, Integer> f;
    private static final LinkedHashMap<String, Integer> g;
    private static final LinkedHashMap<String, Integer> h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;

    static {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        f3806e = linkedHashMap;
        linkedHashMap.put("s.jpush.cn", 19000);
        f3806e.put("sis.jpush.io", 19000);
        f3806e.put("easytomessage.com", 19000);
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>();
        f = linkedHashMap2;
        linkedHashMap2.put("123.196.118.23", 19000);
        f.put("103.229.215.60", 19000);
        f.put("117.121.49.100", 19000);
        g = new LinkedHashMap<>();
        h = new LinkedHashMap<>();
        i = "";
        j = "";
        k = "";
        l = "";
    }

    public static String a(Context context) {
        if (!JCoreManager.isTestEnv() || TextUtils.isEmpty(i)) {
            String str = (String) b.b(context, cn.jiguang.g.a.O());
            return !TextUtils.isEmpty(str) ? str : "im64.jpush.cn";
        }
        return i;
    }

    public static LinkedHashMap<String, Integer> a() {
        return (!JCoreManager.isTestEnv() || g.isEmpty()) ? f3806e : g;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            d.f("HostConfig", "conn info was empty");
            return;
        }
        d.b("HostConfig", "get conn info=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("srv");
            d.b("HostConfig", "save srvHost:" + optString);
            if (!TextUtils.isEmpty(optString)) {
                b.a(context, cn.jiguang.g.a.P().a((cn.jiguang.g.a<String>) optString));
            }
            String optString2 = jSONObject.optString("conn");
            d.b("HostConfig", "save connHost:" + optString2);
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            b.a(context, cn.jiguang.g.a.O().a((cn.jiguang.g.a<String>) optString2));
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        if (!JCoreManager.isTestEnv() || TextUtils.isEmpty(j)) {
            String str = (String) b.b(context, cn.jiguang.g.a.P());
            return !TextUtils.isEmpty(str) ? str : "_im64._tcp.jpush.cn";
        }
        return j;
    }

    public static LinkedHashMap<String, Integer> b() {
        return (!JCoreManager.isTestEnv() || h.isEmpty()) ? f : h;
    }

    public static String c() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(k)) ? "_psis._udp.jpush.cn" : k;
    }

    public static String d() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(l)) ? "" : l;
    }
}

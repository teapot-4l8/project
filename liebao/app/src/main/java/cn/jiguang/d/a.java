package cn.jiguang.d;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.an.d;
import cn.jiguang.analytics.page.ActivityLifecycle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.f.e;
import cn.jiguang.f.i;
import cn.jiguang.internal.JConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {
    public static JSONObject a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                d.b("JBridgeHelper", "file_name is null , give up read ");
                return null;
            }
            String b2 = e.b(e.a(context, str));
            if (i.a(b2)) {
                d.b("JBridgeHelper", "read String is empty");
                return null;
            }
            return new JSONObject(b2.trim());
        } catch (Throwable th) {
            d.b("JBridgeHelper", "can't build " + str + " into JsonObject, give up read :" + th);
            return null;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("itime", b.a(context, System.currentTimeMillis()));
            jSONObject.put(com.umeng.analytics.pro.d.y, str);
            jSONObject.put("account_id", cn.jiguang.g.b.a(context, cn.jiguang.g.a.m()));
        } catch (JSONException e2) {
            d.f("JBridgeHelper", "fillBase exception:" + e2);
        }
        return jSONObject;
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            try {
            } catch (Throwable th) {
                d.g("JBridgeHelper", "registerActivityLifecycleCallbacks failed:" + th);
                JConstants.isInstrumentationHookFailed = true;
            }
            if (JConstants.isInstrumentationHookFailed && Build.VERSION.SDK_INT >= 14 && (context instanceof Application)) {
                String a2 = cn.jiguang.f.a.a(context);
                String packageName = context.getPackageName();
                if (a2 != null && packageName != null && context.getPackageName().equals(a2)) {
                    JConstants.isInstrumentationHookFailed = false;
                    ((Application) context).registerActivityLifecycleCallbacks(new ActivityLifecycle());
                    d.b("JBridgeHelper", "registerActivityLifecycleCallbacks in main process,packageName:" + packageName + ",currentProcessName:" + a2);
                    return;
                }
                d.b("JBridgeHelper", "need not registerActivityLifecycleCallbacks in other process :" + a2);
            }
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("asm".equals(intent.getAction())) {
                    JCoreManager.onEvent(context, JConstants.SDK_TYPE, 3, "asm", intent.getExtras(), new Object[0]);
                    return;
                }
            } catch (Throwable th) {
                d.f("JBridgeHelper", "shareActionRun error:" + th.getMessage());
                return;
            }
        }
        StringBuilder sb = new StringBuilder("shareActionRun intent error:");
        sb.append(intent == null ? "null" : intent.getAction());
        d.b("JBridgeHelper", sb.toString());
    }

    public static String b(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.d());
    }

    public static String c(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.m());
    }

    public static long d(Context context) {
        return ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
    }

    public static String e(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a());
    }

    public static String f(Context context) {
        return (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.e());
    }

    public static Object g(Context context) {
        HashMap hashMap = new HashMap();
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.j())).longValue();
        int intValue = ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.k())).intValue();
        hashMap.put("uuid", (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.i()));
        hashMap.put("ct", Long.valueOf(longValue));
        hashMap.put("state", Integer.valueOf(intValue));
        return hashMap;
    }

    public static int h(Context context) {
        return ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.f())).intValue();
    }

    public static boolean i(Context context) {
        d.b("JBridgeHelper", "canShowLbsPermissionDialog");
        Boolean bool = (Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.y());
        if (bool != null && !bool.booleanValue()) {
            d.c("JBridgeHelper", "lbs disable");
            return false;
        }
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue();
        long longValue2 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.w())).longValue();
        d.b("JBridgeHelper", "lbs permission dialog shield, firstInit=" + longValue2 + ", delay=" + longValue);
        if (longValue2 > 0) {
            return longValue <= 0 || System.currentTimeMillis() > longValue2 + longValue;
        }
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.w().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
        return longValue <= 0;
    }

    public static int j(Context context) {
        return ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.k())).intValue();
    }
}

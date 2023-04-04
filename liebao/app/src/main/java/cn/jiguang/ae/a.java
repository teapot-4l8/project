package cn.jiguang.ae;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.o.f;
import cn.jiguang.o.i;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {
    public static void a(Context context, int i) {
        boolean z;
        boolean z2;
        String e2 = f.e(context);
        new a();
        boolean a2 = Build.VERSION.SDK_INT >= 24 ? a(context) : b(context);
        boolean z3 = true;
        if (!TextUtils.isEmpty(e2)) {
            if (TextUtils.equals("ON", e2)) {
                z = false;
                z2 = true;
            } else {
                z = !TextUtils.equals("OFF", e2);
                z2 = false;
            }
            if (z) {
                cn.jiguang.ad.a.a("JNotificationState", "notification state do not changed");
                z3 = z;
            } else if (z2 == a2) {
                z3 = false;
            }
        }
        cn.jiguang.ad.a.a("JNotificationState", "lastCacheNotificationState:" + e2 + ",currentNotificationSate:" + a2 + ",isNeedReport:" + z3 + ",triggerScene:" + i);
        if (!z3) {
            cn.jiguang.ad.a.a("JNotificationState", "do not need report notification state");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("notification_state", a2);
            jSONObject.put("imei", cn.jiguang.f.a.d(context, cn.jiguang.f.a.d(context, "")));
            jSONObject.put("device_id", cn.jiguang.d.a.e(context));
            jSONObject.put("trigger_scene", i);
            cn.jiguang.d.a.a(context, jSONObject, "android_notification_state");
            i.a(context, (Object) jSONObject);
            f.o(context, a2 ? "ON" : "OFF");
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JNotificationState", "report notification state failed, error:" + th.getMessage());
        }
    }

    private static boolean a(Context context) {
        try {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JNotificationState", "invoke areNotificationsEnabled method failed, error:" + th.getMessage());
            return true;
        }
    }

    private static boolean b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JNotificationState", "getNotificationStateCommon failed, other error:" + th.getMessage());
            return true;
        }
    }
}

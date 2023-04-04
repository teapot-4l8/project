package cn.jpush.android.f;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.push.asus.PushMessageReceiver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4327a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4328b;
    private static cn.jpush.android.g.a g;
    private static String h;
    private static Boolean i;
    private static AtomicLong f = new AtomicLong(0);

    /* renamed from: c  reason: collision with root package name */
    public static String f4329c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f4330d = false;

    /* renamed from: e  reason: collision with root package name */
    public static String f4331e = "com.asus.as";
    private static ExecutorService j = Executors.newSingleThreadExecutor();

    public static long a() {
        long incrementAndGet = f.incrementAndGet();
        if (incrementAndGet == Long.MAX_VALUE) {
            f.set(0L);
        }
        return incrementAndGet;
    }

    public static void a(Context context, String str, long j2, JSONObject jSONObject) {
        if (c(context)) {
            j.execute(new d(str, j2, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(String str, long j2, JSONObject jSONObject) {
        cn.jpush.android.g.a aVar = g;
        if (!(aVar != null ? aVar.b() : false)) {
            cn.jpush.android.i.b.a("Gobal", "connect has disconnect, will reconnect.");
            cn.jpush.android.g.a aVar2 = g;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("JPUSH_PACKAGE", f4329c);
            if (j2 <= 0) {
                j2 = a();
            }
            jSONObject.put("JPUSH_RID", j2);
            String jSONObject2 = jSONObject.toString();
            cn.jpush.android.i.b.c("Gobal", "cmd:" + str + ",data:" + jSONObject2);
            if (g != null) {
                g.a(str, jSONObject2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(Context context) {
        return cn.jpush.android.g.c.a(context, f4331e);
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(h)) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.ups.push.PUSH_RESPONSE");
                intent.setPackage(context.getPackageName());
                ComponentInfo a2 = cn.jpush.android.j.a.a(context, context.getPackageName(), PushMessageReceiver.class);
                if (a2 != null) {
                    h = a2.name;
                    cn.jpush.android.i.a.a("ASUS_PUSH", "Gobal", 4, "found userServiceClass :" + h + " by getComponentInfo");
                }
            } catch (Throwable th) {
                cn.jpush.android.i.b.e("Gobal", "not found PushMessageReceiver :" + th.getMessage());
            }
            return h;
        }
        return h;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c(Context context) {
        String str;
        Boolean bool;
        Boolean bool2 = i;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (context == null) {
            cn.jpush.android.i.b.g("Gobal", "context is null");
            return false;
        }
        cn.jpush.android.g.d dVar = null;
        if (!cn.jpush.android.j.a.a(context)) {
            str = "Manufacturer not match, give up create connection.";
        } else if (cn.jpush.android.g.c.a(context, f4331e)) {
            dVar = new cn.jpush.android.g.d();
            g = dVar;
            if (dVar != null) {
                cn.jpush.android.i.b.g("Gobal", "unsupport this device.");
                bool = false;
            } else {
                Context applicationContext = context.getApplicationContext();
                f4327a = applicationContext;
                f4329c = applicationContext.getPackageName();
                cn.jpush.android.a.b.a(context);
                try {
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel("asus_default_channel_id") == null) {
                        cn.jpush.android.i.b.b("Gobal", "create default channel:默认");
                        notificationManager.createNotificationChannel(new NotificationChannel("asus_default_channel_id", "默认", 3));
                    }
                } catch (Throwable th) {
                    cn.jpush.android.i.b.e("Gobal", "[initNotificationChannel] failed:" + th.getMessage());
                }
                bool = true;
            }
            i = bool;
            return bool.booleanValue();
        } else {
            str = "cn.jpush.android.service.PushManagerService not exist in system, give up create connection.";
        }
        cn.jpush.android.i.b.f("ConnectionFactory", str);
        g = dVar;
        if (dVar != null) {
        }
        i = bool;
        return bool.booleanValue();
    }
}

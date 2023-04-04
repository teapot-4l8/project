package cn.jiguang.x;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bun.miitmdid.core.MdidSdkHelper;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[Catch: all -> 0x007e, TryCatch #0 {all -> 0x007e, blocks: (B:3:0x0002, B:6:0x000f, B:14:0x002c, B:16:0x0032, B:28:0x006c, B:32:0x007a, B:17:0x0038, B:19:0x0040, B:21:0x004c, B:23:0x0056, B:24:0x005c, B:27:0x0069, B:7:0x0015, B:9:0x001b, B:12:0x0026), top: B:37:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038 A[Catch: all -> 0x007e, TryCatch #0 {all -> 0x007e, blocks: (B:3:0x0002, B:6:0x000f, B:14:0x002c, B:16:0x0032, B:28:0x006c, B:32:0x007a, B:17:0x0038, B:19:0x0040, B:21:0x004c, B:23:0x0056, B:24:0x005c, B:27:0x0069, B:7:0x0015, B:9:0x001b, B:12:0x0026), top: B:37:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject a(Context context) {
        String d2;
        String f;
        try {
            JSONObject jSONObject = new JSONObject();
            String str = "";
            if (b()) {
                cn.jiguang.ad.a.f("IdHelper", "not get id in main thread");
            } else if (a()) {
                d2 = d(context);
                if (!TextUtils.isEmpty(d2)) {
                    if (TextUtils.isEmpty(d2)) {
                        jSONObject = new JSONObject(d2);
                    } else {
                        String str2 = Build.MANUFACTURER;
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.toLowerCase().equals("xiaomi")) {
                                String a2 = cn.jiguang.aa.a.a(context);
                                if (!TextUtils.isEmpty(a2)) {
                                    jSONObject = new JSONObject(a2);
                                }
                            } else {
                                String e2 = e(context);
                                if (TextUtils.isEmpty(e2)) {
                                    e2 = "";
                                }
                                jSONObject.put("oaid", e2);
                            }
                        }
                    }
                    f = f(context);
                    if (TextUtils.isEmpty(f)) {
                        str = f;
                    }
                    jSONObject.put("gadid", str);
                    return jSONObject;
                }
                cn.jiguang.ad.a.e("IdHelper", "not get ids by mitts");
            }
            d2 = "";
            if (TextUtils.isEmpty(d2)) {
            }
            f = f(context);
            if (TextUtils.isEmpty(f)) {
            }
            jSONObject.put("gadid", str);
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("IdHelper", "[getAllIds] failed：" + th.getMessage());
            return null;
        }
    }

    private static boolean a() {
        try {
            String canonicalName = MdidSdkHelper.class.getCanonicalName();
            cn.jiguang.ad.a.a("IdHelper", "MdidSdkHelper name:" + canonicalName);
            return true;
        } catch (Throwable unused) {
            cn.jiguang.ad.a.e("IdHelper", "not found mitt class");
            return false;
        }
    }

    private static boolean b() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("IdHelper", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    private static String d(Context context) {
        try {
            FutureTask futureTask = new FutureTask(new d(context));
            new Thread(futureTask).start();
            return (String) futureTask.get(1L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("IdHelper", "getMittIds failed:" + th.getMessage());
            return "";
        }
    }

    private static String e(Context context) {
        try {
            if (b()) {
                cn.jiguang.ad.a.e("IdHelper", "not get id in main thread");
                return "";
            }
            FutureTask futureTask = new FutureTask(new c(context));
            new Thread(futureTask).start();
            return (String) futureTask.get(1L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("IdHelper", "getOaidByLocal failed:" + th.getMessage());
            return "";
        }
    }

    private static String f(Context context) {
        try {
            if (b()) {
                cn.jiguang.ad.a.e("IdHelper", "not get id in main thread");
                return "";
            }
            FutureTask futureTask = new FutureTask(new b(context));
            new Thread(futureTask).start();
            return (String) futureTask.get(1L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("IdHelper", "getGoogleAdid failed:" + th.getMessage());
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(Context context) {
        Intent intent;
        cn.jiguang.y.b bVar;
        if (b()) {
            cn.jiguang.ad.a.f("IdHelper", "not get id in main thread");
            return "";
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            try {
                intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                bVar = new cn.jiguang.y.b();
            } catch (Throwable th) {
                cn.jiguang.ad.a.e("IdHelper", "getAdvertisingIdInfo Exception: " + th.toString());
            }
            if (!context.bindService(intent, bVar, 1)) {
                cn.jiguang.ad.a.e("IdHelper", "bind failed");
                return "";
            } else if (bVar.f4253a) {
                cn.jiguang.ad.a.f("IdHelper", "repeat bind");
                context.unbindService(bVar);
                return "";
            } else {
                cn.jiguang.y.a aVar = new cn.jiguang.y.a(bVar.f4254b.take());
                cn.jiguang.ad.a.a("IdHelper", "google ad id:" + aVar.a());
                String a2 = aVar.a();
                context.unbindService(bVar);
                return a2;
            }
        } catch (Throwable unused) {
            cn.jiguang.ad.a.b("IdHelper", "not supported google");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(Context context) {
        Intent intent;
        cn.jiguang.z.b bVar;
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            try {
                intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                bVar = new cn.jiguang.z.b();
            } catch (Throwable th) {
                cn.jiguang.ad.a.e("IdHelper", "getAdvertisingIdInfo Exception: " + th.toString());
            }
        } catch (Throwable unused) {
        }
        if (!context.bindService(intent, bVar, 1)) {
            cn.jiguang.ad.a.e("IdHelper", "bind failed");
            return "";
        } else if (bVar.f4256a) {
            cn.jiguang.ad.a.f("IdHelper", "repeat bind");
            context.unbindService(bVar);
            return "";
        } else {
            cn.jiguang.z.a aVar = new cn.jiguang.z.a(bVar.f4257b.take());
            cn.jiguang.ad.a.a("IdHelper", "oaid:" + aVar.a());
            String a2 = aVar.a();
            context.unbindService(bVar);
            return a2;
        }
    }
}

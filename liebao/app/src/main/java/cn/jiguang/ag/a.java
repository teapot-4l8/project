package cn.jiguang.ag;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.o.f;
import cn.jpush.android.service.WakedResultReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends cn.jiguang.o.a {

    /* renamed from: a */
    private static volatile a f3685a;

    /* renamed from: c */
    private static WakedResultReceiver f3686c;

    /* renamed from: b */
    private Context f3687b;

    private a() {
        cn.jiguang.ap.b.a("JWake");
    }

    public static a a() {
        if (f3685a == null) {
            synchronized (a.class) {
                f3685a = new a();
            }
        }
        return f3685a;
    }

    public static void a(Context context, int i) {
        if (context == null) {
            cn.jiguang.ad.a.d("JWake", "context is null,can not notify waked");
            return;
        }
        WakedResultReceiver j = j(context);
        f3686c = j;
        if (j == null) {
            cn.jiguang.ad.a.d("JWake", "waked receiver is null");
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("1", context);
        hashMap.put(WakedResultReceiver.WAKE_TYPE_KEY, Integer.valueOf(i));
        f3686c.onWakeMap(hashMap);
    }

    private void a(Context context, List<cn.jiguang.ah.b> list) {
        StringBuilder sb;
        String str;
        if (list == null || list.size() <= 0) {
            cn.jiguang.ad.a.d("JWake", "there are no wakeTarget");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("from_package", context.getPackageName());
        for (cn.jiguang.ah.b bVar : list) {
            int i = 2;
            if (bVar.f3703c == 2) {
                sb = new StringBuilder("command this app is not allow to wake package:");
                sb.append(bVar.f3701a);
                sb.append(",service:");
                str = bVar.f3702b;
            } else {
                i = (Build.VERSION.SDK_INT < 26 || bVar.f3703c < 26) ? 3 : 3;
                if (!TextUtils.isEmpty(bVar.f3704d)) {
                    i |= 4;
                }
                if (!cn.jiguang.ai.a.a(context) && cn.jiguang.ai.a.b(context)) {
                    i |= 8;
                }
                ComponentName componentName = new ComponentName(bVar.f3701a, bVar.f3702b);
                Intent intent = null;
                int i2 = i & 2;
                if (i2 != 0 || (i & 1) != 0) {
                    intent = new Intent();
                    intent.setComponent(componentName);
                    if (Build.VERSION.SDK_INT >= 12) {
                        intent.setFlags(32);
                    }
                    Bundle a2 = cn.jiguang.ai.c.a(hashMap);
                    if (a2 != null) {
                        intent.putExtras(a2);
                    }
                }
                if (i2 != 0) {
                    try {
                        context.getApplicationContext().bindService(intent, new e(this, (byte) 0), 1);
                    } catch (Throwable th) {
                        cn.jiguang.ad.a.d("JWake", "bindService throwable:" + th.getMessage());
                    }
                }
                if ((i & 1) != 0) {
                    try {
                        context.startService(intent);
                    } catch (Throwable th2) {
                        cn.jiguang.ad.a.d("JWake", "startService throwable:" + th2.getMessage());
                    }
                }
                if ((i & 4) != 0) {
                    try {
                        if (!TextUtils.isEmpty(bVar.f3704d)) {
                            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
                            String str2 = bVar.f3704d;
                            if (!str2.startsWith("content://")) {
                                str2 = "content://" + str2;
                            }
                            String b2 = cn.jiguang.ai.c.b(hashMap);
                            if (!TextUtils.isEmpty(b2)) {
                                str2 = str2 + b2;
                            }
                            Cursor query = contentResolver.query(Uri.parse(str2), null, null, null, null);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                        }
                    } catch (Throwable th3) {
                        sb = new StringBuilder("getContentResolver throwable:");
                        str = th3.getMessage();
                    }
                }
            }
            sb.append(str);
            cn.jiguang.ad.a.d("JWake", sb.toString());
        }
    }

    public static /* synthetic */ void a(a aVar, Context context, JSONObject jSONObject) {
        List<cn.jiguang.ah.b> a2;
        ApplicationInfo applicationInfo;
        try {
            String b2 = cn.jiguang.v.d.b(context, "bwct.catch.v2");
            cn.jiguang.ad.a.a("JWake", "read cmd wakeTarget:" + b2);
            if (jSONObject != null) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                int optInt = jSONObject2.optInt(com.umeng.analytics.pro.d.y, 1);
                String optString = jSONObject2.optString("pkgName", "");
                String optString2 = jSONObject2.optString("serviceName", "");
                a2 = null;
                if (optInt == 1 && (applicationInfo = context.getPackageManager().getApplicationInfo(optString, 128)) != null) {
                    a2 = new ArrayList<>();
                    cn.jiguang.ah.b bVar = new cn.jiguang.ah.b();
                    bVar.f3701a = optString;
                    bVar.f3702b = optString2;
                    bVar.f3703c = applicationInfo.targetSdkVersion;
                    bVar.f = 1;
                    a2.add(bVar);
                }
                String a3 = cn.jiguang.ai.c.a(cn.jiguang.ai.d.a(b2, optString, optString2, optInt));
                cn.jiguang.ad.a.a("JWake", "write cmd wakeTarget:" + a3);
                cn.jiguang.v.d.a(context, "bwct.catch.v2", a3);
            } else if (b2 == null || TextUtils.isEmpty(b2)) {
                cn.jiguang.ad.a.d("JWake", "there are no cache cmd wakeTarget");
                return;
            } else {
                a2 = cn.jiguang.ai.c.a(context, cn.jiguang.ai.c.a(b2));
            }
            if (a2 != null) {
                aVar.a(context, a2);
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWake", "parse throwable:" + th.getMessage());
        }
    }

    public static void b(Context context, Bundle bundle) {
        try {
            cn.jiguang.ad.a.a("JWake", "executeWakedAction.");
            if (bundle != null) {
                a(context, bundle.getInt(com.umeng.analytics.pro.d.y));
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.a("JWake", "executeWakedAction failed:" + th.getLocalizedMessage());
        }
    }

    public cn.jiguang.ah.a i(Context context) {
        JSONObject a2;
        boolean a3 = f.a(context, "JWakeConfigHelper");
        cn.jiguang.ad.a.a("JWake", "isRequestWakeConfigEnable:" + a3);
        if (!a3 || (a2 = cn.jiguang.ai.b.a(context)) == null) {
            return cn.jiguang.ai.b.b(context, cn.jiguang.v.d.a(context, "bwc.catch"));
        }
        cn.jiguang.ah.a b2 = cn.jiguang.ai.b.b(context, a2);
        cn.jiguang.ad.a.a("JWake", "wakeConfig:" + b2);
        cn.jiguang.ai.b.a(context, a2);
        f.a(this.f3687b, "JWakeConfigHelper", b2.f);
        f.a(this.f3687b, "JWake", b2.f3700e);
        f.b(this.f3687b, "JWake", b2.g);
        boolean z = true;
        f.a(this.f3687b, "JWake", b2.f3696a && b2.f3698c);
        z = (b2.f3697b && b2.f3699d) ? false : false;
        f.a(this.f3687b, "JWakeComponentHelper", z);
        cn.jiguang.ai.a.a(this.f3687b, z);
        return b2;
    }

    private static WakedResultReceiver j(Context context) {
        WakedResultReceiver wakedResultReceiver = f3686c;
        if (wakedResultReceiver != null) {
            return wakedResultReceiver;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.WakedReceiver");
            intent.setPackage(context.getPackageName());
            intent.addCategory(context.getPackageName());
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() == 0) {
                return null;
            }
            return (WakedResultReceiver) Class.forName(queryBroadcastReceivers.get(0).activityInfo.name).newInstance();
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWake", "find waked receiver throwable:" + th.getMessage());
            return null;
        }
    }

    @Override // cn.jiguang.o.a
    public final String a(Context context) {
        this.f3687b = context;
        return "JWake";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
        cn.jiguang.ah.a b2 = cn.jiguang.ai.b.b(this.f3687b, cn.jiguang.v.d.a(this.f3687b, "bwc.catch"));
        List<cn.jiguang.ah.b> a2 = cn.jiguang.ai.c.a(this.f3687b);
        if (a2 == null || a2.isEmpty()) {
            a2 = null;
        } else {
            HashMap hashMap = new HashMap();
            for (cn.jiguang.ah.b bVar : a2) {
                hashMap.put(bVar.f3701a, bVar);
            }
            List<String> a3 = cn.jiguang.ai.c.a(b2, new ArrayList(hashMap.keySet()));
            a2.clear();
            for (String str2 : a3) {
                if (hashMap.containsKey(str2)) {
                    a2.add(hashMap.get(str2));
                }
            }
        }
        if (a2 == null || a2.isEmpty()) {
            cn.jiguang.ad.a.a("JWake", "there are no app need wake");
            return;
        }
        a(context, a2);
        super.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
    }

    public final void c(Context context, JSONObject jSONObject) {
        StringBuilder sb;
        String str;
        this.f3687b = context;
        if (jSONObject == null) {
            sb = new StringBuilder("executeWakeAction: [");
            sb.append("JWake");
            str = "] from cmd";
        } else {
            sb = new StringBuilder("executeWakeAction: [");
            sb.append("JWake");
            str = "] from heartBeat";
        }
        sb.append(str);
        cn.jiguang.ad.a.a("JWake", sb.toString());
        boolean b2 = b();
        cn.jiguang.ad.a.a("JWake", "JWake isActionUserEnable:" + b2);
        if (b2) {
            cn.jiguang.ap.b.a("JWake", new d(this, context, jSONObject));
        }
    }

    @Override // cn.jiguang.o.a
    protected final boolean c(Context context, String str) {
        boolean a2 = f.a(context, "JWake");
        if (i(context) == null) {
            cn.jiguang.ad.a.d("JWake", "wakeConfig is null");
            return false;
        }
        boolean h = f.h(context, "JWakeComponentHelper");
        cn.jiguang.ad.a.a("JWake", "isComponentEnable:" + h);
        cn.jiguang.ai.a.a(context, h);
        return f.h(context, "JWake") && a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final boolean d(Context context, String str) {
        return super.d(context, str);
    }

    @Override // cn.jiguang.o.a
    protected final boolean e(Context context) {
        return true;
    }

    @Override // cn.jiguang.o.a
    public final Object f(Context context) {
        return Boolean.valueOf(f.h(context, "JWake"));
    }

    public final void g(Context context) {
        this.f3687b = context;
        cn.jiguang.ad.a.a("JWake", "executeWakeAction: [JWake] from first launch");
        cn.jiguang.ap.b.a("JWake", new b(this, context));
    }

    public final void h(Context context) {
        cn.jiguang.ap.b.a("JWake", new c(this, context, (byte) 0));
    }
}

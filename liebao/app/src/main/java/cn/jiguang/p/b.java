package cn.jiguang.p;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.f.i;
import cn.jiguang.internal.JConstants;
import cn.jiguang.o.f;
import cn.jiguang.v.g;
import com.umeng.analytics.pro.ak;
import java.security.SecureRandom;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f4183a;

    /* renamed from: b  reason: collision with root package name */
    private static Object f4184b;

    /* renamed from: c  reason: collision with root package name */
    private static String f4185c;

    private b() {
    }

    public static b a() {
        if (f4183a == null) {
            synchronized (b.class) {
                if (f4183a == null) {
                    f4183a = new b();
                }
            }
        }
        return f4183a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0084 A[Catch: all -> 0x00ac, TryCatch #1 {all -> 0x00ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x001c, B:11:0x002a, B:14:0x0035, B:16:0x003b, B:18:0x0043, B:20:0x004b, B:22:0x0051, B:29:0x007e, B:31:0x0084, B:32:0x0092, B:35:0x009a, B:39:0x00a4, B:40:0x00a8), top: B:49:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a4 A[Catch: all -> 0x00ac, TryCatch #1 {all -> 0x00ac, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x001c, B:11:0x002a, B:14:0x0035, B:16:0x003b, B:18:0x0043, B:20:0x004b, B:22:0x0051, B:29:0x007e, B:31:0x0084, B:32:0x0092, B:35:0x009a, B:39:0x00a4, B:40:0x00a8), top: B:49:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static d a(Context context, Object obj, boolean z) {
        Object obj2;
        String str;
        long b2;
        if (obj != null) {
            try {
                if (Build.VERSION.SDK_INT > 11) {
                    Object onEvent = JCoreManager.onEvent(context, null, 20, null, null, new Object[0]);
                    if ((onEvent instanceof Long) && ((Long) onEvent).longValue() > 0) {
                        String a2 = a.a(context, obj);
                        if (TextUtils.isEmpty(a2)) {
                            return null;
                        }
                        String d2 = i.d(a2);
                        if (z && !TextUtils.isEmpty(f4185c) && f4185c.equals(d2)) {
                            cn.jiguang.ad.a.a("CopyManager", "same as last, skip");
                            return null;
                        }
                        f4185c = d2;
                        long nextLong = new SecureRandom().nextLong();
                        String a3 = cn.jiguang.bb.d.a(g.a(a2.getBytes()), nextLong);
                        d dVar = new d();
                        dVar.f4191c = nextLong;
                        dVar.f4189a = a3;
                        try {
                            obj2 = a.a(obj);
                        } catch (Throwable unused) {
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            try {
                                str = obj2.toString();
                            } catch (Throwable unused2) {
                            }
                            if (!TextUtils.isEmpty(str)) {
                                dVar.f4190b = cn.jiguang.bb.d.a(g.a(str.getBytes()), nextLong);
                            }
                            b2 = (Build.VERSION.SDK_INT >= 26 || obj2 == null) ? 0L : a.b(obj2);
                            if (b2 == 0) {
                                b2 = System.currentTimeMillis();
                            }
                            dVar.f4192d = b2;
                            return dVar;
                        }
                        str = null;
                        if (!TextUtils.isEmpty(str)) {
                        }
                        if (Build.VERSION.SDK_INT >= 26) {
                        }
                        if (b2 == 0) {
                        }
                        dVar.f4192d = b2;
                        return dVar;
                    }
                    return null;
                }
            } catch (Throwable th) {
                cn.jiguang.ad.a.d("CopyManager", "convert e:" + th);
            }
        }
        return null;
    }

    private static d a(Context context, boolean z) {
        Object c2;
        if (Build.VERSION.SDK_INT < 11) {
            return null;
        }
        try {
            Object f = f(context);
            if (f != null && (c2 = a.c(f)) != null) {
                return a(context, c2, z);
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyManager", "get Current copy e:" + th);
        }
        return null;
    }

    private static JSONObject a(d dVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("board", dVar.f4189a);
            jSONObject.put("desc", dVar.f4190b);
            jSONObject.put("time", dVar.f4192d);
            jSONObject.put("seed", dVar.f4191c);
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyManager", "convert e:" + th);
            return null;
        }
    }

    public static void a(Context context) {
        cn.jiguang.ax.b.a().b(2004, 0L, new e(context));
    }

    private static void a(Context context, JSONArray jSONArray) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("list", jSONArray);
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 26, null, null, jSONObject, "board");
            if (onEvent instanceof JSONObject) {
                jSONObject = (JSONObject) onEvent;
            }
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 39, null, null, jSONObject);
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyManager", "report e:" + th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) {
        c g;
        d a2;
        JSONObject a3;
        Context appContext = JCoreManager.getAppContext(context);
        if (appContext == null || (g = g(appContext)) == null || (a2 = a(appContext, true)) == null) {
            return;
        }
        String h = f.h(appContext);
        JSONArray jSONArray = null;
        if (!TextUtils.isEmpty(h)) {
            try {
                JSONArray jSONArray2 = new JSONArray(h);
                try {
                    if (jSONArray2.length() > 0 && jSONArray2.getJSONObject(jSONArray2.length() - 1).getString("board").equals(a2.f4189a)) {
                        cn.jiguang.ad.a.a("CopyManager", "same as last, won't update");
                        return;
                    }
                    jSONArray = jSONArray2;
                } catch (Throwable th) {
                    th = th;
                    jSONArray = jSONArray2;
                    cn.jiguang.ad.a.d("CopyManager", "deal history e:" + th);
                    a3 = a(a2);
                    if (a3 == null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        a3 = a(a2);
        if (a3 == null) {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            JSONArray put = jSONArray.put(a3);
            if (g.f4188c < -1 || g.f4188c == 0) {
                g.f4188c = 20;
            }
            if (g.f4188c != -1 && jSONArray.length() > g.f4188c) {
                try {
                    int length = jSONArray.length() - g.f4188c;
                    cn.jiguang.ad.a.a("CopyManager", "need remove first " + length);
                    JSONArray jSONArray3 = new JSONArray();
                    while (length < jSONArray.length()) {
                        try {
                            jSONArray3.put(jSONArray.get(length));
                            length++;
                        } catch (Throwable unused) {
                        }
                    }
                    put = jSONArray3;
                } catch (Throwable unused2) {
                }
            }
            String jSONArray4 = put.toString();
            try {
                cn.jiguang.ad.a.a("CopyManager", "save history=" + put.toString(2));
            } catch (JSONException unused3) {
            }
            f.r(appContext, jSONArray4);
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        try {
            if (Build.VERSION.SDK_INT < 11 || jSONObject.getInt(ak.aT) < 0) {
                return;
            }
            f.q(context, jSONObject.toString());
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyManager", "setConfig e:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(Context context) {
        try {
            String h = f.h(context);
            if (TextUtils.isEmpty(h)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(h);
            f.r(context, null);
            a(context, jSONArray);
            cn.jiguang.ad.a.a("CopyManager", "report history=" + jSONArray.toString(2));
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyManager", "reportHistory e:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(Context context) {
        JSONObject a2;
        try {
            d a3 = a(context, false);
            if (a3 == null || (a2 = a(a3)) == null) {
                return;
            }
            a(context, new JSONArray().put(a2));
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyManager", "reportCurrent e:" + th);
        }
    }

    private static Object f(Context context) {
        if (Build.VERSION.SDK_INT >= 11 && f4184b == null && context != null) {
            synchronized (b.class) {
                if (f4184b == null) {
                    if (Looper.myLooper() != null) {
                        f4184b = a.a(context);
                    } else {
                        cn.jiguang.ad.a.d("CopyManager", "can't get copyMgr");
                    }
                }
            }
        }
        return f4184b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c g(Context context) {
        try {
            String g = f.g(context);
            if (TextUtils.isEmpty(g)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(g);
            c cVar = new c();
            cVar.f4186a = jSONObject.getInt(ak.aT);
            cVar.f4187b = jSONObject.optInt("r_interval");
            if (cVar.f4187b <= 0) {
                cVar.f4187b = 3600;
            }
            if (cVar.f4187b < cVar.f4186a) {
                cVar.f4187b = cVar.f4186a;
            }
            cVar.f4188c = jSONObject.optInt("limit");
            return cVar;
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyManager", "readConfig e:" + th);
            return null;
        }
    }

    public final void a(Context context, JSONObject jSONObject) {
        try {
            if (Build.VERSION.SDK_INT < 11) {
                cn.jiguang.ad.a.a("CopyManager", "sdk below 11, won't deal");
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            int i = jSONObject2.getInt("action");
            if (i == 1) {
                cn.jiguang.ad.a.a("CopyManager", "disable");
                f.k(context);
            } else if (i == 2) {
                cn.jiguang.ad.a.a("CopyManager", "reportCurrent");
                cn.jiguang.ax.b.a().b(2003, 0L, new e(context));
            } else if (i != 3) {
            } else {
                cn.jiguang.ad.a.a("CopyManager", "setConfig=" + jSONObject2);
                b(context, jSONObject2);
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyManager", "deal report e:" + th);
        }
    }
}

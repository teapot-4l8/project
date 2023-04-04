package cn.jiguang.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.f.e;
import cn.jiguang.internal.JConstants;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    private static a f4035b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static int f4036c = 1048576;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4037a;

    /* renamed from: d  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f4038d = null;

    private a() {
        this.f4037a = true;
        this.f4037a = ((Boolean) cn.jiguang.g.b.a(JConstants.getAppContext(null), cn.jiguang.g.a.b())).booleanValue();
    }

    public static a a() {
        return f4035b;
    }

    private static String a(Throwable th) {
        String th2 = th.toString();
        try {
            String[] split = th2.split(":");
            if (split.length > 1) {
                for (int length = split.length - 1; length >= 0; length--) {
                    if (!split[length].endsWith("Exception") && !split[length].endsWith("Error")) {
                    }
                    return split[length];
                }
                return th2;
            }
            return th2;
        } catch (NullPointerException | PatternSyntaxException unused) {
            return th2;
        }
    }

    public static JSONArray a(Context context) {
        String b2 = e.b(e.a(context, "jpush_uncaughtexception_file"));
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            return new JSONArray(b2);
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONArray a(Context context, Throwable th) {
        String b2 = e.b(e.a(context, "jpush_uncaughtexception_file"));
        JSONArray jSONArray = null;
        int i = 0;
        if (!TextUtils.isEmpty(b2)) {
            try {
                JSONArray jSONArray2 = new JSONArray(b2);
                try {
                    i = b2.length();
                } catch (JSONException unused) {
                }
                jSONArray = jSONArray2;
            } catch (JSONException unused2) {
            }
        }
        return a(context, jSONArray, i, th);
    }

    private JSONArray a(Context context, JSONArray jSONArray, int i, Throwable th) {
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis() + cn.jiguang.d.b.c(context);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        int i2 = 0;
        while (true) {
            jSONObject = null;
            try {
                if (i2 >= jSONArray.length()) {
                    break;
                }
                jSONObject = jSONArray.optJSONObject(i2);
                if (jSONObject != null && stringWriter2.equals(jSONObject.getString("stacktrace"))) {
                    jSONObject.put("count", jSONObject.getInt("count") + 1);
                    jSONObject.put("crashtime", currentTimeMillis);
                    break;
                }
                i2++;
            } catch (Throwable unused) {
            }
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("crashtime", currentTimeMillis);
            jSONObject2.put("stacktrace", stringWriter2);
            jSONObject2.put("message", a(th));
            jSONObject2.put("count", 1);
            jSONObject2.put("networktype", cn.jiguang.f.a.j(context));
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName == null ? "null" : packageInfo.versionName;
                StringBuilder sb = new StringBuilder();
                sb.append(packageInfo.versionCode);
                String sb2 = sb.toString();
                jSONObject2.put(d.az, str);
                jSONObject2.put("versioncode", sb2);
            }
            if (i + jSONObject2.toString().length() < f4036c) {
                jSONArray.put(jSONObject2);
            } else {
                long j = -1;
                int i3 = 0;
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        long optLong = optJSONObject.optLong("crashtime");
                        if (j == -1 || optLong < j) {
                            i3 = i4;
                            j = optLong;
                        }
                    }
                }
                jSONArray.put(i3, jSONObject2);
            }
        }
        return jSONArray;
    }

    public static void b(Context context) {
        if (context == null) {
            cn.jiguang.an.d.f("JPushCrashHandler", "Action - deleteCrashLog context is null");
        } else {
            e.a(e.a(context, "jpush_uncaughtexception_file"));
        }
    }

    public static void c(Context context) {
        if (context == null) {
            cn.jiguang.an.d.f("JPushCrashHandler", "Action - reportCrashLog context is null");
        } else if (cn.jiguang.d.b.a(context)) {
            try {
                new b().start();
            } catch (Throwable th) {
                cn.jiguang.an.d.h("JPushCrashHandler", "report crash e:" + th);
            }
        }
    }

    public final void b() {
        if (this.f4038d == null) {
            this.f4038d = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        File a2;
        if (this.f4037a) {
            cn.jiguang.an.d.a("JPushCrashHandler", "enable crash report");
            if (this.f4037a) {
                Context appContext = JConstants.getAppContext(null);
                if (appContext != null) {
                    JSONArray a3 = a(appContext, th);
                    b(appContext);
                    String jSONArray = a3 != null ? a3.toString() : null;
                    if (!TextUtils.isEmpty(jSONArray) && (a2 = e.a(appContext, "jpush_uncaughtexception_file")) != null) {
                        e.a(a2, jSONArray);
                    }
                } else {
                    cn.jiguang.an.d.h("JPushCrashHandler", "handleException failed: context is null");
                }
            }
            try {
                b bVar = new b();
                bVar.start();
                bVar.join(2000L);
            } catch (InterruptedException unused) {
            } catch (Throwable th2) {
                cn.jiguang.an.d.h("JPushCrashHandler", "report crash e:" + th2);
            }
        } else {
            cn.jiguang.an.d.a("JPushCrashHandler", "disable crash report");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4038d;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}

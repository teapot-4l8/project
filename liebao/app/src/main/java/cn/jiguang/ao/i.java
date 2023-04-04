package cn.jiguang.ao;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a */
    private static j f3781a;

    /* renamed from: b */
    private static volatile FutureTask<?> f3782b;

    /* renamed from: c */
    private static final Object f3783c = new Object();

    /* renamed from: d */
    private static final LinkedHashSet<String> f3784d;

    /* renamed from: e */
    private static final LinkedHashSet<String> f3785e;

    static {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        f3784d = linkedHashSet;
        linkedHashSet.add("https://tsis.jpush.cn");
        f3785e = new LinkedHashSet<>();
    }

    public static LinkedHashSet<String> a() {
        return (!JConstants.isTestEnv() || f3785e.isEmpty()) ? f3784d : f3785e;
    }

    public static void a(Context context, boolean z) {
        StringBuilder sb;
        if (f3781a == null) {
            f3781a = new j(context, (byte) 0);
        }
        if (f3782b == null || f3782b.isCancelled() || f3782b.isDone()) {
            synchronized (f3783c) {
                if (f3782b == null || f3782b.isCancelled() || f3782b.isDone()) {
                    f3782b = new FutureTask<>(f3781a, null);
                    cn.jiguang.ba.a.a("ASYNC", f3782b);
                }
            }
        }
        if (z) {
            try {
                f3782b.get(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                sb = new StringBuilder("sis task e:");
                sb.append(e);
                cn.jiguang.an.d.f("ReportSis", sb.toString());
            } catch (ExecutionException e3) {
                e = e3;
                sb = new StringBuilder("sis task e:");
                sb.append(e);
                cn.jiguang.an.d.f("ReportSis", sb.toString());
            } catch (TimeoutException e4) {
                e = e4;
                sb = new StringBuilder("sis task e:");
                sb.append(e);
                cn.jiguang.an.d.f("ReportSis", sb.toString());
            } catch (Throwable th) {
                cn.jiguang.an.d.f("ReportSis", "sis task e:" + th);
            }
        }
    }

    public static boolean b(Context context, String str, String str2) {
        n a2 = b.a(str, str2, context, true, 3, 2);
        cn.jiguang.an.d.b("ReportSis", "report sis code[" + a2.a() + "] from url=" + str + "\n body=" + a2.b());
        if (a2.a() == 0) {
            String b2 = a2.b();
            if (TextUtils.isEmpty(b2)) {
                return false;
            }
            try {
                a.a().a(context, new JSONObject(b2).getJSONObject("ret"));
                return true;
            } catch (Throwable th) {
                cn.jiguang.an.d.f("ReportSis", "getUrls e:" + th);
                return false;
            }
        }
        return false;
    }

    public static String c(Context context) {
        long j;
        Object a2;
        double d2;
        double d3;
        JSONObject jSONObject = new JSONObject();
        try {
            String a3 = cn.jiguang.am.a.a(context);
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
            int a4 = cn.jiguang.f.j.a(context);
            String b2 = cn.jiguang.f.j.b(context);
            jSONObject.put(com.umeng.analytics.pro.d.y, a4);
            jSONObject.put("appkey", a3);
            jSONObject.put("sdkver", cn.jiguang.a.a.f3640b);
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, 0);
            j = 0;
            if (longValue != 0) {
                jSONObject.put("uid", longValue);
            }
            if (b2 != null) {
                jSONObject.put("opera", b2);
            }
            a2 = cn.jiguang.at.d.a(context, "get_loc_info", null);
            d2 = 200.0d;
        } catch (Throwable unused) {
        }
        if (a2 instanceof Bundle) {
            try {
                Bundle bundle = (Bundle) a2;
                double d4 = bundle.getDouble(com.umeng.analytics.pro.d.C);
                try {
                    d2 = bundle.getDouble("lot");
                    j = bundle.getLong("time");
                } catch (Throwable unused2) {
                }
                double d5 = d2;
                d2 = d4;
                d3 = d5;
            } catch (Throwable unused3) {
            }
            if (d2 > -90.0d && d2 < 90.0d && d3 > -180.0d && d3 < 180.0d) {
                jSONObject.put(com.umeng.analytics.pro.d.C, d2);
                jSONObject.put(com.umeng.analytics.pro.d.D, d3);
                jSONObject.put("time", j);
            }
            return jSONObject.toString();
        }
        d3 = 200.0d;
        if (d2 > -90.0d) {
            jSONObject.put(com.umeng.analytics.pro.d.C, d2);
            jSONObject.put(com.umeng.analytics.pro.d.D, d3);
            jSONObject.put("time", j);
        }
        return jSONObject.toString();
    }

    public static LinkedHashSet<String> d(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.s());
        if (TextUtils.isEmpty(str)) {
            return linkedHashSet;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedHashSet.add(jSONArray.optString(i));
            }
        } catch (JSONException unused) {
        }
        return linkedHashSet;
    }
}

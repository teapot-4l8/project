package cn.jiguang.b;

import android.content.Context;
import cn.jiguang.an.d;
import cn.jiguang.ao.k;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.internal.JConstants;
import com.umeng.analytics.pro.ak;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b extends Thread implements ReportCallBack {
    private static JSONObject a(Context context) {
        JSONArray a2 = a.a(context);
        if (a2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashlogs", a2);
            jSONObject.put(ak.T, cn.jiguang.f.a.j(context));
            cn.jiguang.d.a.a(context, jSONObject, "crash_log");
            Object a3 = cn.jiguang.c.b.a(context);
            JSONObject jSONObject2 = a3 instanceof JSONObject ? (JSONObject) a3 : null;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject.put("device_info", jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public final void onFinish(int i) {
        d.f("ReportCrashLogDirect", "ReportDirect finish : " + i);
        if (i == 0) {
            a.b(JConstants.getAppContext(null));
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            Context appContext = JConstants.getAppContext(null);
            if (appContext == null) {
                d.f("ReportCrashLogDirect", "ReportDirect context is null");
                return;
            }
            JSONObject a2 = a(appContext);
            if (a2 != null) {
                k.a(appContext, a2, this);
            }
        } catch (Throwable th) {
            d.h("ReportCrashLogDirect", "run report crash e:" + th);
        }
    }
}

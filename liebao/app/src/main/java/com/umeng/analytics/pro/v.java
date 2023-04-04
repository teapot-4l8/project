package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ViewPageTracker.java */
/* loaded from: classes2.dex */
public class v {

    /* renamed from: c  reason: collision with root package name */
    private static final int f6632c = 5;

    /* renamed from: d  reason: collision with root package name */
    private static JSONArray f6633d = new JSONArray();

    /* renamed from: e  reason: collision with root package name */
    private static Object f6634e = new Object();
    private final Map<String, Long> f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    Stack<String> f6635a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    com.umeng.analytics.vshelper.a f6636b = PageNameMonitor.getInstance();

    protected int a() {
        return 2;
    }

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f6634e) {
                    jSONArray = f6633d.toString();
                    f6633d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        i.a(context).a(u.a().c(), jSONObject, i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f6635a.size() != 0) {
            UMLog.aq(j.F, 0, "\\|", new String[]{"@"}, new String[]{this.f6635a.peek()}, null, null);
        }
        this.f6636b.customPageBegin(str);
        synchronized (this.f) {
            this.f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f6635a.push(str);
            }
        }
    }

    public void b(String str) {
        Long l;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f.containsKey(str)) {
            synchronized (this.f) {
                l = this.f.get(str);
            }
            if (l == null) {
                return;
            }
            if (UMConfigure.isDebugLog() && this.f6635a.size() > 0 && str.equals(this.f6635a.peek())) {
                this.f6635a.pop();
            }
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            synchronized (f6634e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.v, str);
                    jSONObject.put("duration", currentTimeMillis);
                    jSONObject.put(d.x, l);
                    jSONObject.put(d.y, a());
                    f6633d.put(jSONObject);
                    if (f6633d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                        UMWorkDispatch.sendEvent(appContext, o.a.f6598c, CoreProtocol.getInstance(appContext), null);
                    }
                } catch (Throwable unused) {
                }
            }
            if (!UMConfigure.isDebugLog() || this.f6635a.size() == 0) {
                return;
            }
            UMLog.aq(j.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        } else if (UMConfigure.isDebugLog() && this.f6635a.size() == 0) {
            UMLog.aq(j.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        }
    }

    public void b() {
        String str;
        synchronized (this.f) {
            str = null;
            long j = 0;
            for (Map.Entry<String, Long> entry : this.f.entrySet()) {
                if (entry.getValue().longValue() > j) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }
}

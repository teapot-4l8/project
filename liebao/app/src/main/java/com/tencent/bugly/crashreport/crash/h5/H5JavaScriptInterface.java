package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class H5JavaScriptInterface {

    /* renamed from: a  reason: collision with root package name */
    private static HashSet<Integer> f6102a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private String f6103b = null;

    /* renamed from: c  reason: collision with root package name */
    private Thread f6104c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f6105d = null;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f6106e = null;

    private H5JavaScriptInterface() {
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        String str = null;
        if (webViewInterface == null || f6102a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f6102a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f6104c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i = 2; i < currentThread.getStackTrace().length; i++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.f6105d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f6106e = hashMap;
        return h5JavaScriptInterface;
    }

    private static a a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                aVar.f6107a = jSONObject.getString("projectRoot");
                if (aVar.f6107a == null) {
                    return null;
                }
                aVar.f6108b = jSONObject.getString(d.R);
                if (aVar.f6108b == null) {
                    return null;
                }
                aVar.f6109c = jSONObject.getString(ImagesContract.URL);
                if (aVar.f6109c == null) {
                    return null;
                }
                aVar.f6110d = jSONObject.getString("userAgent");
                if (aVar.f6110d == null) {
                    return null;
                }
                aVar.f6111e = jSONObject.getString(ak.N);
                if (aVar.f6111e == null) {
                    return null;
                }
                aVar.f = jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                if (aVar.f == null || aVar.f.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    x.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.h = string.substring(indexOf + 1);
                aVar.g = string.substring(0, indexOf);
                int indexOf2 = aVar.g.indexOf(":");
                if (indexOf2 > 0) {
                    aVar.g = aVar.g.substring(indexOf2 + 1);
                }
                aVar.i = jSONObject.getString("file");
                if (aVar.f == null) {
                    return null;
                }
                aVar.j = jSONObject.getLong("lineNumber");
                if (aVar.j < 0) {
                    return null;
                }
                aVar.k = jSONObject.getLong("columnNumber");
                if (aVar.k < 0) {
                    return null;
                }
                x.a("H5 crash information is following: ", new Object[0]);
                x.a("[projectRoot]: " + aVar.f6107a, new Object[0]);
                x.a("[context]: " + aVar.f6108b, new Object[0]);
                x.a("[url]: " + aVar.f6109c, new Object[0]);
                x.a("[userAgent]: " + aVar.f6110d, new Object[0]);
                x.a("[language]: " + aVar.f6111e, new Object[0]);
                x.a("[name]: " + aVar.f, new Object[0]);
                x.a("[message]: " + aVar.g, new Object[0]);
                x.a("[stacktrace]: \n" + aVar.h, new Object[0]);
                x.a("[file]: " + aVar.i, new Object[0]);
                x.a("[lineNumber]: " + aVar.j, new Object[0]);
                x.a("[columnNumber]: " + aVar.k, new Object[0]);
                return aVar;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    @JavascriptInterface
    public void printLog(String str) {
        x.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            x.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String b2 = z.b(str.getBytes());
        String str2 = this.f6103b;
        if (str2 != null && str2.equals(b2)) {
            x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f6103b = b2;
        x.d("Handling JS exception ...", new Object[0]);
        a a2 = a(str);
        if (a2 == null) {
            x.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (a2.f6107a != null) {
            linkedHashMap2.put("[JS] projectRoot", a2.f6107a);
        }
        if (a2.f6108b != null) {
            linkedHashMap2.put("[JS] context", a2.f6108b);
        }
        if (a2.f6109c != null) {
            linkedHashMap2.put("[JS] url", a2.f6109c);
        }
        if (a2.f6110d != null) {
            linkedHashMap2.put("[JS] userAgent", a2.f6110d);
        }
        if (a2.i != null) {
            linkedHashMap2.put("[JS] file", a2.i);
        }
        if (a2.j != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(a2.j));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f6106e);
        linkedHashMap.put("Java Stack", this.f6105d);
        Thread thread = this.f6104c;
        if (a2 != null) {
            InnerApi.postH5CrashAsync(thread, a2.f, a2.g, a2.h, linkedHashMap);
        }
    }
}

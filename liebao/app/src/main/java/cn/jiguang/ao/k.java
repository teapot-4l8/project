package cn.jiguang.ao;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f3787a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3788b = true;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f3789c = true;

    /* renamed from: d  reason: collision with root package name */
    private static String f3790d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f3791e = "/v3/report";
    private static String f = "";

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file, ReportCallBack reportCallBack) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    if (!cn.jiguang.f.a.d(context)) {
                        cn.jiguang.an.d.f("ReportUtils", "no network, give up upload");
                        d.a(file);
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-2);
                        }
                        return -2;
                    }
                    Pair<byte[], Integer> a2 = a(jSONObject.toString(), true, 2);
                    if (a2 != null && a2.first != null && ((byte[]) a2.first).length != 0) {
                        byte[] bArr = (byte[]) a2.first;
                        int intValue = ((Integer) a2.second).intValue();
                        cn.jiguang.an.d.b("ReportUtils", "will upload length=" + bArr.length);
                        if (f3788b && bArr.length < 30680 && set != null && !set.contains("crash_log")) {
                            cn.jiguang.at.k.a();
                            cn.jiguang.at.k.a().a(context, cn.jiguang.at.k.a(context, jSONObject, bArr, intValue, file, set, reportCallBack));
                            return 1;
                        }
                        int a3 = a(context, bArr, intValue, set);
                        if (a3 == 0) {
                            cn.jiguang.an.d.b("ReportUtils", "http upload success json=" + cn.jiguang.f.g.a(jSONObject));
                            cn.jiguang.f.e.a(file);
                        }
                        if (a3 != 1) {
                            d.a(file);
                            if (reportCallBack != null) {
                                reportCallBack.onFinish(a3);
                            }
                        }
                        return a3;
                    }
                    cn.jiguang.an.d.f("ReportUtils", "package body failed, give up upload");
                    d.a(file);
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                }
            } catch (Throwable th) {
                try {
                    cn.jiguang.an.d.f("ReportUtils", "upload failed, error:" + th);
                    d.a(file);
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                } catch (Throwable th2) {
                    if (0 != 1) {
                        d.a(file);
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(0);
                        }
                    }
                    throw th2;
                }
            }
        }
        cn.jiguang.an.d.f("ReportUtils", "upload content is empty, do nothing");
        d.a(file);
        if (reportCallBack != null) {
            reportCallBack.onFinish(-1);
        }
        return -1;
    }

    private static int a(Context context, byte[] bArr, int i, Set<String> set) {
        n a2;
        String str;
        String[] split;
        StringBuilder sb;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        Set<String> b2 = a.a().b(context).b(set);
        if (b2 != null) {
            for (String str2 : b2) {
                if (!TextUtils.isEmpty(str2)) {
                    linkedHashSet.add(str2);
                }
            }
        }
        String str3 = (!JCoreManager.isTestEnv() || TextUtils.isEmpty(f)) ? "stats.jpush.cn" : f;
        if (!TextUtils.isEmpty(str3)) {
            linkedHashSet.add("https://" + str3);
        }
        String str4 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a(true));
        if (!TextUtils.isEmpty(str4)) {
            for (String str5 : str4.split(",")) {
                if (!cn.jiguang.f.i.f(str5)) {
                    if (!cn.jiguang.f.i.g(str5)) {
                        sb = new StringBuilder();
                    } else if (!f3789c) {
                        sb = new StringBuilder();
                    }
                    sb.append("https://");
                    sb.append(str5);
                    linkedHashSet.add(sb.toString());
                } else if (f3789c) {
                    sb = new StringBuilder();
                    sb.append("https://");
                    sb.append(str5);
                    linkedHashSet.add(sb.toString());
                }
            }
        }
        cn.jiguang.an.d.b("ReportUtils", "types=" + set + " find urls=" + linkedHashSet);
        if (linkedHashSet.isEmpty()) {
            cn.jiguang.an.d.f("ReportUtils", "can't get url, give up upload");
            return -2;
        }
        String str6 = " type=" + set;
        for (String str7 : linkedHashSet) {
            if (TextUtils.isEmpty(str7)) {
                cn.jiguang.an.d.f("ReportUtils", "can't get url, give up upload");
            } else if (Build.VERSION.SDK_INT < 28 || str7.startsWith("https://")) {
                if (!str7.endsWith(f3791e)) {
                    str7 = str7 + f3791e;
                }
                String str8 = str7;
                cn.jiguang.an.d.b("ReportUtils", "upload" + str6 + " to url:" + str8);
                int a3 = b.a(context, str8, bArr, i, 3, 1).a();
                if (a3 == -3) {
                    d.a(context, cn.jiguang.am.a.a(context));
                    return -2;
                }
                if (a3 == -1) {
                    str = "upload" + str6 + " error:" + a2.b();
                } else if (a3 == 0) {
                    return 0;
                } else {
                    str = "upload" + str6 + " failed";
                }
                cn.jiguang.an.d.b("ReportUtils", str);
            } else {
                cn.jiguang.an.d.f("ReportUtils", "won't use http at device since 28");
            }
        }
        return -1;
    }

    private static Pair<byte[], Integer> a(String str, boolean z, int i) {
        try {
            byte[] a2 = cn.jiguang.f.k.a(str.getBytes("UTF-8"));
            int a3 = cn.jiguang.bb.d.a();
            return new Pair<>(cn.jiguang.bb.d.a(a2, cn.jiguang.bb.d.a(a3), "iop203040506aPk!", true), Integer.valueOf(a3));
        } catch (UnsupportedEncodingException | IOException | Exception unused) {
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
        if (longValue == 0) {
            cn.jiguang.an.d.b("ReportUtils", " miss uid,generate report token failed");
            return null;
        }
        String e2 = cn.jiguang.f.i.e((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.e()));
        String l = cn.jiguang.f.i.l(longValue + e2 + str);
        if (cn.jiguang.f.i.a(l)) {
            return null;
        }
        try {
            return Base64.encodeToString((longValue + ":" + l + ":" + str2).getBytes(), 10);
        } catch (Exception unused) {
            cn.jiguang.an.d.h("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static String a(String str) {
        try {
            return cn.jiguang.bb.d.a(str, cn.jiguang.bb.a.a());
        } catch (Throwable unused) {
            cn.jiguang.an.d.h("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    private static ArrayList<JSONArray> a(JSONArray jSONArray, int i, int i2) {
        ArrayList<JSONArray> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            if (jSONArray.length() == 1) {
                arrayList.add(jSONArray);
                return arrayList;
            }
            JSONArray jSONArray2 = new JSONArray();
            int i3 = 0;
            int i4 = 0;
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                JSONObject optJSONObject = jSONArray.optJSONObject(length);
                try {
                    int b2 = cn.jiguang.f.g.b(optJSONObject);
                    if (b2 != 0) {
                        int i5 = i3 + b2;
                        if (i5 > 204800) {
                            break;
                        }
                        int i6 = i4 + b2;
                        if (i6 > 40960) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            try {
                                jSONArray3.put(optJSONObject);
                                jSONArray2 = jSONArray3;
                            } catch (Throwable th) {
                                th = th;
                                jSONArray2 = jSONArray3;
                                cn.jiguang.an.d.f("ReportUtils", "partition exception:" + th);
                            }
                        } else {
                            jSONArray2.put(optJSONObject);
                            b2 = i6;
                        }
                        i4 = b2;
                        i3 = i5;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (jSONArray2.length() > 0) {
                arrayList.add(jSONArray2);
            }
        }
        return arrayList;
    }

    public static Set<String> a(JSONObject jSONObject) {
        return jSONObject == null ? new HashSet() : c(jSONObject.optJSONArray("content"));
    }

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, ak.av);
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
            if (longValue == 0) {
                cn.jiguang.an.d.f("ReportUtils", "miss uid when wrap container info");
                return null;
            }
            jSONObject.put("uid", longValue);
            String a2 = cn.jiguang.am.a.a(context);
            if (cn.jiguang.f.i.a(a2)) {
                cn.jiguang.an.d.h("ReportUtils", "miss app_key when wrap container info");
                return null;
            }
            jSONObject.put("app_key", a2);
            ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
            jSONObject.put("core_sdk_ver", cn.jiguang.a.a.f3640b);
            String b2 = cn.jiguang.am.a.b(context);
            if (cn.jiguang.f.i.a(b2)) {
                cn.jiguang.an.d.g("ReportUtils", "miss channel when wrap container info,but continue report...");
            } else {
                jSONObject.put("channel", b2);
            }
            Pair<String, Integer> b3 = cn.jiguang.c.b.b(context);
            if (b3 == null || cn.jiguang.f.i.a((String) b3.first)) {
                cn.jiguang.an.d.g("ReportUtils", "miss app version when wrap container info,but continue report...");
            } else {
                jSONObject.put("app_version", b3.first);
            }
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.an.d.f("ReportUtils", "wrapContainerInfo exception:" + th);
            return null;
        }
    }

    private static JSONObject a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("content", jSONArray);
        } catch (JSONException unused) {
        }
        cn.jiguang.f.g.a(jSONObject2, jSONObject);
        return jSONObject2;
    }

    public static void a(Context context, int i, JSONObject jSONObject, byte[] bArr, int i2, File file, Set<String> set, ReportCallBack reportCallBack) {
        try {
            cn.jiguang.an.d.b("ReportUtils", "onTcpReportResult, types=" + set + " code=" + i);
            if (i != -3) {
                if (i != 0) {
                    i = a(context, bArr, i2, set);
                    if (i == 0) {
                        if (JConstants.DEBUG_MODE && JConstants.INTERNAL_USE) {
                            cn.jiguang.an.d.b("ReportUtils", "http upload success, json=" + cn.jiguang.f.g.a(jSONObject));
                        }
                    }
                } else if (JConstants.DEBUG_MODE && JConstants.INTERNAL_USE) {
                    cn.jiguang.an.d.b("ReportUtils", "tcp upload success, json=" + cn.jiguang.f.g.a(jSONObject));
                }
                cn.jiguang.f.e.a(file);
            } else {
                d.a(context, cn.jiguang.am.a.a(context));
            }
            if (reportCallBack != null) {
                reportCallBack.onFinish(i);
            }
            d.a(file);
        } catch (Throwable unused) {
            if (reportCallBack != null) {
                reportCallBack.onFinish(i);
            }
            d.a(file);
        }
    }

    public static void a(Context context, Object obj) {
        try {
            if (b(obj)) {
                cn.jiguang.ba.a.a("BUILD_REPORT", new l(obj, context));
            } else {
                cn.jiguang.an.d.b("ReportUtils", "data is invalid or empty");
            }
            d.b(context);
        } catch (Throwable th) {
            cn.jiguang.an.d.f("ReportUtils", "report e:" + th);
        }
    }

    public static void a(Context context, String str, Object obj) {
        try {
            cn.jiguang.an.d.b("ReportUtils", "going to report data at push service");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(ak.u, str);
            }
            if (b(obj)) {
                bundle.putString("report_data", obj.toString());
            }
            cn.jiguang.a.a.a(context, "a1", bundle);
        } catch (Throwable th) {
            try {
                cn.jiguang.an.d.b("ReportUtils", "reportAtPushService", th);
            } catch (Throwable th2) {
                cn.jiguang.an.d.b("ReportUtils", "reportAtPushService", th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, JSONArray jSONArray, Set set) {
        try {
            String a2 = a.a().a(context).a(set);
            JSONObject a3 = a(context);
            boolean z = a3 != null;
            StringBuilder sb = new StringBuilder();
            sb.append(File.separator);
            sb.append(a2);
            sb.append(File.separator);
            sb.append(z ? "tmp" : "nowrap");
            String sb2 = sb.toString();
            Iterator<JSONArray> it = a(jSONArray, 40960, 204800).iterator();
            while (it.hasNext()) {
                JSONObject a4 = a(it.next(), a3);
                File a5 = d.a(context, sb2, a4, z);
                cn.jiguang.an.d.b("ReportUtils", "save report types=" + set + " at " + sb2 + File.separator + a5.getName());
                if (z) {
                    cn.jiguang.ba.a.a("UPLOAD_REPORT", new m(context, set, a4, a5));
                }
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.h("ReportUtils", "report exception:" + th);
        }
    }

    public static void a(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject a2 = a(context);
                    if (a2 == null) {
                        cn.jiguang.an.d.h("ReportUtils", "wrap data failed");
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-1);
                        }
                    } else {
                        String b2 = b(jSONObject);
                        JSONObject a3 = a(new JSONArray().put(jSONObject), a2);
                        HashSet hashSet = new HashSet();
                        hashSet.add(b2);
                        cn.jiguang.an.d.b("ReportUtils", "reportWithoutStore type=" + b2);
                        a(context, hashSet, a3, null, reportCallBack);
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.an.d.h("ReportUtils", "reportWithoutStore exception:" + th);
            }
        }
        d.b(context);
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        try {
            if (cn.jiguang.f.i.a(str)) {
                cn.jiguang.an.d.b("ReportUtils", "file_name is null , give up save ");
                return false;
            } else if (context != null) {
                return cn.jiguang.f.e.a(cn.jiguang.f.e.a(context, str), jSONObject != null ? jSONObject.toString() : "");
            } else {
                cn.jiguang.an.d.b("ReportUtils", "context is null , give up save " + str);
                return false;
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.b("ReportUtils", "writeLogFile e:" + th);
            return false;
        }
    }

    private static String b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString(com.umeng.analytics.pro.d.y);
        }
        return null;
    }

    private static JSONArray b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.length() > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    private static boolean b(Object obj) {
        return obj instanceof String ? ((String) obj).length() > 2 : obj instanceof JSONObject ? ((JSONObject) obj).length() > 0 : (obj instanceof JSONArray) && b((JSONArray) obj).length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<String> c(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String b2 = b(jSONArray.optJSONObject(i));
                if (b2 == null) {
                    b2 = "";
                }
                hashSet.add(b2);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0001, B:16:0x0036, B:18:0x003c, B:9:0x001f, B:11:0x0023, B:12:0x002d, B:14:0x0031), top: B:25:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray c(Object obj) {
        JSONArray put;
        JSONArray b2;
        try {
        } catch (Throwable th) {
            cn.jiguang.an.d.f("ReportUtils", "adapt JSONArray e:" + th);
        }
        if (obj instanceof String) {
            try {
                try {
                    put = new JSONArray((String) obj);
                } catch (Throwable unused) {
                    put = new JSONArray().put(new JSONObject((String) obj));
                }
            } catch (Throwable unused2) {
            }
            b2 = b(put);
            if (b2 != null) {
                if (b2.length() > 0) {
                    return b2;
                }
            }
            return null;
        }
        if (obj instanceof JSONObject) {
            put = new JSONArray().put(obj);
        } else {
            if (obj instanceof JSONArray) {
                put = (JSONArray) obj;
            }
            put = null;
        }
        b2 = b(put);
        if (b2 != null) {
        }
        return null;
    }
}

package cn.jiguang.ab;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.ak;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends cn.jiguang.o.a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f3648b;

    /* renamed from: a  reason: collision with root package name */
    private Context f3649a;

    private static Bundle a(long j, double d2, double d3) {
        Bundle bundle = new Bundle();
        bundle.putLong("time", j);
        bundle.putDouble("lot", d2);
        bundle.putDouble(com.umeng.analytics.pro.d.C, d3);
        return bundle;
    }

    public static a a() {
        if (f3648b == null) {
            synchronized (a.class) {
                f3648b = new a();
            }
        }
        return f3648b;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject a(List<cn.jiguang.ac.c> list, cn.jiguang.ac.a aVar, cn.jiguang.ac.b bVar) {
        String str;
        boolean z;
        String str2;
        String str3;
        JSONObject jSONObject;
        cn.jiguang.ac.c cVar;
        JSONObject jSONObject2 = new JSONObject();
        boolean z2 = false;
        String str4 = "JLocation";
        if (list == null || list.isEmpty()) {
            str = "JLocation";
        } else {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            boolean z3 = false;
            while (i < list.size()) {
                try {
                    jSONObject = new JSONObject();
                    cVar = list.get(i);
                    str2 = str4;
                } catch (JSONException e2) {
                    e = e2;
                    str2 = str4;
                }
                try {
                    jSONObject.put("itime", cVar.f3675a);
                    if (cVar.f3677c != null) {
                        jSONObject.put("tag", cVar.f3677c);
                    }
                    jSONObject.put("ssid", cVar.f3676b);
                    jSONObject.put("mac_address", cVar.f3679e);
                    jSONObject.put("signal_strength", cVar.f3678d);
                    jSONObject.put("age", 0);
                    jSONArray.put(jSONObject);
                    jSONObject2.put("wifi", jSONArray);
                    str3 = str2;
                    z3 = true;
                } catch (JSONException e3) {
                    e = e3;
                    str3 = str2;
                    cn.jiguang.ad.a.d(str3, "package wifi json exception:" + e.getMessage());
                    i++;
                    str4 = str3;
                }
                i++;
                str4 = str3;
            }
            str = str4;
            z2 = z3;
        }
        if (aVar != null) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("itime", aVar.f3665a);
                jSONObject3.put("radio_type", aVar.g);
                jSONObject3.put("generation", aVar.h);
                jSONObject3.put(ak.P, aVar.i);
                jSONObject3.put("mobile_country_code", aVar.f3666b);
                jSONObject3.put("mobile_network_code", aVar.f3667c);
                jSONObject3.put("signal_strength", aVar.f);
                jSONObject3.put("cell_id", aVar.f3669e);
                jSONObject3.put("location_area_code", aVar.f3668d);
                jSONArray2.put(jSONObject3);
                jSONObject2.put("cell", jSONArray2);
                z2 = true;
            } catch (JSONException e4) {
                cn.jiguang.ad.a.d(str, "package cell json exception:" + e4.getMessage());
            }
        }
        if (bVar != null) {
            try {
                JSONArray jSONArray3 = new JSONArray();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("itime", bVar.f3670a);
                jSONObject4.put("tag", bVar.f3671b);
                jSONObject4.put(com.umeng.analytics.pro.d.C, bVar.f3672c);
                jSONObject4.put(com.umeng.analytics.pro.d.D, bVar.f3673d);
                jSONObject4.put("alt", bVar.f3674e);
                jSONObject4.put("bear", bVar.f);
                jSONObject4.put("acc", bVar.g);
                jSONArray3.put(jSONObject4);
                jSONObject2.put("gps", jSONArray3);
                z = true;
            } catch (JSONException e5) {
                cn.jiguang.ad.a.d(str, "package gps json exception:" + e5.getMessage());
            }
            if (z) {
                try {
                    cn.jiguang.d.a.a(this.f3649a, jSONObject2, "loc_info");
                    jSONObject2.put("local_dns", cn.jiguang.f.a.c());
                    jSONObject2.put(ak.T, cn.jiguang.f.a.j(this.f3649a));
                } catch (JSONException e6) {
                    cn.jiguang.ad.a.d(str, "package json exception:" + e6.getMessage());
                }
            }
            return jSONObject2;
        }
        z = z2;
        if (z) {
        }
        return jSONObject2;
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONArray jSONArray;
        cn.jiguang.ad.a.a("JLocation", "currentJson:" + jSONObject + ",cacheJson:" + jSONObject2);
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            try {
                jSONObject3 = new JSONObject();
            } catch (JSONException e2) {
                e = e2;
            }
            try {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(jSONObject);
                jSONObject3.put("content", jSONArray2);
                return jSONObject3;
            } catch (JSONException e3) {
                e = e3;
                jSONObject2 = jSONObject3;
                cn.jiguang.ad.a.d("JLocation", "mergeJson exception:" + e.getMessage());
                return jSONObject2;
            }
        }
        try {
            jSONArray = jSONObject2.getJSONArray("content");
        } catch (JSONException unused) {
            jSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            JSONArray optJSONArray = optJSONObject.optJSONArray("wifi");
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("cell");
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("gps");
            JSONArray optJSONArray4 = jSONObject.optJSONArray("wifi");
            JSONArray optJSONArray5 = jSONObject.optJSONArray("cell");
            JSONArray optJSONArray6 = jSONObject.optJSONArray("gps");
            if (optJSONArray != null && optJSONArray.equals(optJSONArray4)) {
                jSONObject.remove("wifi");
            }
            if (optJSONArray2 != null && optJSONArray2.equals(optJSONArray5)) {
                jSONObject.remove("cell");
            }
            if (optJSONArray3 != null && optJSONArray3.equals(optJSONArray6)) {
                jSONObject.remove("gps");
            }
        }
        if (jSONObject.length() != 0) {
            try {
                jSONObject.put(ak.T, cn.jiguang.f.a.j(this.f3649a));
                jSONObject.put("local_dns", cn.jiguang.f.a.c());
                cn.jiguang.d.a.a(this.f3649a, jSONObject, "loc_info");
                jSONArray.put(jSONObject);
            } catch (JSONException e4) {
                cn.jiguang.ad.a.d("JLocation", "package json exception:" + e4.getMessage());
            }
        }
        return jSONObject2;
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f3649a = context;
        return "JLocation";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(2:3|(17:5|6|7|(12:12|13|14|15|(6:20|(3:28|29|(1:31))|22|(1:24)|25|26)|35|(3:39|(4:41|(2:62|63)(1:43)|44|45)(1:64)|(1:47))|(0)|22|(0)|25|26)|69|(13:71|72|73|14|15|(7:17|20|(0)|22|(0)|25|26)|35|(4:37|39|(0)(0)|(0))|(0)|22|(0)|25|26)|13|14|15|(0)|35|(0)|(0)|22|(0)|25|26)(1:92))(1:94)|93|6|7|(13:9|12|13|14|15|(0)|35|(0)|(0)|22|(0)|25|26)|69|(0)|13|14|15|(0)|35|(0)|(0)|22|(0)|25|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0096, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0097, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009a, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009d, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cd, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01a4, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01a6, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a8, code lost:
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0096, InterruptedException -> 0x0099, ExecutionException -> 0x009c, TimeoutException -> 0x00cd, TRY_LEAVE, TryCatch #7 {InterruptedException -> 0x0099, ExecutionException -> 0x009c, TimeoutException -> 0x00cd, all -> 0x0096, blocks: (B:10:0x0047, B:12:0x004d, B:15:0x0054, B:16:0x005a, B:18:0x0060), top: B:102:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0103 A[Catch: all -> 0x01a4, InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, TryCatch #8 {InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, all -> 0x01a4, blocks: (B:41:0x00d3, B:43:0x0103, B:46:0x010a, B:47:0x0111, B:49:0x0117, B:51:0x0121, B:53:0x012b, B:69:0x0182, B:67:0x016b), top: B:101:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0117 A[Catch: all -> 0x01a4, InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, TryCatch #8 {InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, all -> 0x01a4, blocks: (B:41:0x00d3, B:43:0x0103, B:46:0x010a, B:47:0x0111, B:49:0x0117, B:51:0x0121, B:53:0x012b, B:69:0x0182, B:67:0x016b), top: B:101:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012b A[Catch: all -> 0x01a4, InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, TRY_LEAVE, TryCatch #8 {InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, all -> 0x01a4, blocks: (B:41:0x00d3, B:43:0x0103, B:46:0x010a, B:47:0x0111, B:49:0x0117, B:51:0x0121, B:53:0x012b, B:69:0x0182, B:67:0x016b), top: B:101:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016b A[Catch: all -> 0x01a4, InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, TRY_ENTER, TryCatch #8 {InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, all -> 0x01a4, blocks: (B:41:0x00d3, B:43:0x0103, B:46:0x010a, B:47:0x0111, B:49:0x0117, B:51:0x0121, B:53:0x012b, B:69:0x0182, B:67:0x016b), top: B:101:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0182 A[Catch: all -> 0x01a4, InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, TRY_LEAVE, TryCatch #8 {InterruptedException -> 0x01a6, ExecutionException -> 0x01a8, TimeoutException -> 0x01d1, all -> 0x01a4, blocks: (B:41:0x00d3, B:43:0x0103, B:46:0x010a, B:47:0x0111, B:49:0x0117, B:51:0x0121, B:53:0x012b, B:69:0x0182, B:67:0x016b), top: B:101:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // cn.jiguang.o.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Context context, String str) {
        String str2;
        List<cn.jiguang.ac.c> list;
        cn.jiguang.ac.a aVar;
        String str3;
        StringBuilder sb;
        String message;
        StringBuilder sb2;
        String message2;
        String str4;
        JSONObject a2;
        String str5;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        cn.jiguang.ac.b bVar = null;
        if (!cn.jiguang.f.a.h(context, "android.permission.ACCESS_WIFI_STATE")) {
            str2 = "collect wifi failed because has no android.permission.ACCESS_WIFI_STATE";
        } else if (cn.jiguang.f.a.i(context)) {
            List<cn.jiguang.ac.c> a3 = new i(context).a();
            cn.jiguang.ad.a.a("JLocation", "collect wifi success:" + a3);
            list = a3;
            if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION") && !cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION")) {
                cn.jiguang.ad.a.d("JLocation", "collect cell failed because has no Manifest.permission.LOCATION");
                aVar = null;
                cn.jiguang.ad.a.a("JLocation", "coares:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION"));
                cn.jiguang.ad.a.a("JLocation", "fine:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION"));
                if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION") && !cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION")) {
                    cn.jiguang.ad.a.d("JLocation", "collect gps failed because has no Manifest.permission.LOCATION");
                    if (newSingleThreadExecutor != null) {
                        try {
                            if (!newSingleThreadExecutor.isShutdown()) {
                                newSingleThreadExecutor.shutdown();
                            }
                        } catch (Throwable th) {
                            cn.jiguang.ad.a.d("JLocation", "shut down failed:" + th.getMessage());
                        }
                    }
                    a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                    if (a2 != null) {
                        cn.jiguang.ad.a.a("JLocation", "save json:" + a2);
                        cn.jiguang.v.d.a(context, "rl.catch", a2);
                    }
                    super.a(context, str);
                }
                if (cn.jiguang.o.i.a(context) && f.a(context).e()) {
                    bVar = f.a(context).d();
                    if (bVar != null) {
                        FutureTask futureTask = new FutureTask(new c(this));
                        newSingleThreadExecutor.execute(futureTask);
                        cn.jiguang.ac.b bVar2 = (cn.jiguang.ac.b) futureTask.get(31000L, TimeUnit.MILLISECONDS);
                        if (bVar2 != null) {
                            try {
                                str5 = "collect gps success:" + bVar2.toString();
                            } catch (InterruptedException e2) {
                                e = e2;
                                bVar = bVar2;
                                sb2 = new StringBuilder("collect gps exception:");
                                message2 = e.getMessage();
                                sb2.append(message2);
                                str4 = sb2.toString();
                                cn.jiguang.ad.a.d("JLocation", str4);
                                if (newSingleThreadExecutor != null) {
                                }
                                a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                                if (a2 != null) {
                                }
                                super.a(context, str);
                            } catch (ExecutionException e3) {
                                e = e3;
                                bVar = bVar2;
                                sb2 = new StringBuilder("collect gps exception:");
                                message2 = e.getMessage();
                                sb2.append(message2);
                                str4 = sb2.toString();
                                cn.jiguang.ad.a.d("JLocation", str4);
                                if (newSingleThreadExecutor != null) {
                                }
                                a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                                if (a2 != null) {
                                }
                                super.a(context, str);
                            } catch (TimeoutException unused) {
                                bVar = bVar2;
                                str4 = "collect gps time out";
                                cn.jiguang.ad.a.d("JLocation", str4);
                                if (newSingleThreadExecutor != null) {
                                }
                                a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                                if (a2 != null) {
                                }
                                super.a(context, str);
                            } catch (Throwable th2) {
                                th = th2;
                                bVar = bVar2;
                                sb2 = new StringBuilder("collect gps throwable:");
                                message2 = th.getMessage();
                                sb2.append(message2);
                                str4 = sb2.toString();
                                cn.jiguang.ad.a.d("JLocation", str4);
                                if (newSingleThreadExecutor != null) {
                                }
                                a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                                if (a2 != null) {
                                }
                                super.a(context, str);
                            }
                        } else {
                            str5 = "collect gps failed";
                        }
                        cn.jiguang.ad.a.a("JLocation", str5);
                        bVar = bVar2;
                    } else {
                        cn.jiguang.ad.a.a("JLocation", "load  last gps success:" + bVar.toString());
                    }
                    if (bVar != null) {
                        cn.jiguang.o.f.n(context, bVar.f3670a + "," + bVar.f3673d + "," + bVar.f3672c);
                    }
                }
                if (newSingleThreadExecutor != null) {
                }
                a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                if (a2 != null) {
                }
                super.a(context, str);
            }
            if (cn.jiguang.o.i.a(context)) {
                FutureTask futureTask2 = new FutureTask(new b(this));
                newSingleThreadExecutor.execute(futureTask2);
                aVar = (cn.jiguang.ac.a) futureTask2.get(20000L, TimeUnit.MILLISECONDS);
                try {
                    cn.jiguang.ad.a.a("JLocation", "collect cell success:" + aVar.toString());
                } catch (InterruptedException e4) {
                    e = e4;
                    sb = new StringBuilder("collect cell exception:");
                    message = e.getMessage();
                    sb.append(message);
                    str3 = sb.toString();
                    cn.jiguang.ad.a.d("JLocation", str3);
                    cn.jiguang.ad.a.a("JLocation", "coares:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION"));
                    cn.jiguang.ad.a.a("JLocation", "fine:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION"));
                    if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                    }
                    if (cn.jiguang.o.i.a(context)) {
                    }
                    if (newSingleThreadExecutor != null) {
                    }
                    a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                    if (a2 != null) {
                    }
                    super.a(context, str);
                } catch (ExecutionException e5) {
                    e = e5;
                    sb = new StringBuilder("collect cell exception:");
                    message = e.getMessage();
                    sb.append(message);
                    str3 = sb.toString();
                    cn.jiguang.ad.a.d("JLocation", str3);
                    cn.jiguang.ad.a.a("JLocation", "coares:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION"));
                    cn.jiguang.ad.a.a("JLocation", "fine:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION"));
                    if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                    }
                    if (cn.jiguang.o.i.a(context)) {
                    }
                    if (newSingleThreadExecutor != null) {
                    }
                    a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                    if (a2 != null) {
                    }
                    super.a(context, str);
                } catch (TimeoutException unused2) {
                    str3 = "collect cell time out";
                    cn.jiguang.ad.a.d("JLocation", str3);
                    cn.jiguang.ad.a.a("JLocation", "coares:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION"));
                    cn.jiguang.ad.a.a("JLocation", "fine:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION"));
                    if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                    }
                    if (cn.jiguang.o.i.a(context)) {
                    }
                    if (newSingleThreadExecutor != null) {
                    }
                    a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                    if (a2 != null) {
                    }
                    super.a(context, str);
                } catch (Throwable th3) {
                    th = th3;
                    str3 = "collect cell throwable:" + th.getMessage();
                    cn.jiguang.ad.a.d("JLocation", str3);
                    cn.jiguang.ad.a.a("JLocation", "coares:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION"));
                    cn.jiguang.ad.a.a("JLocation", "fine:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION"));
                    if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                    }
                    if (cn.jiguang.o.i.a(context)) {
                    }
                    if (newSingleThreadExecutor != null) {
                    }
                    a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                    if (a2 != null) {
                    }
                    super.a(context, str);
                }
                cn.jiguang.ad.a.a("JLocation", "coares:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION"));
                cn.jiguang.ad.a.a("JLocation", "fine:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION"));
                if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                    cn.jiguang.ad.a.d("JLocation", "collect gps failed because has no Manifest.permission.LOCATION");
                    if (newSingleThreadExecutor != null) {
                    }
                    a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                    if (a2 != null) {
                    }
                    super.a(context, str);
                }
                if (cn.jiguang.o.i.a(context)) {
                    bVar = f.a(context).d();
                    if (bVar != null) {
                    }
                    if (bVar != null) {
                    }
                }
                if (newSingleThreadExecutor != null) {
                }
                a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
                if (a2 != null) {
                }
                super.a(context, str);
            }
            aVar = null;
            cn.jiguang.ad.a.a("JLocation", "coares:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION"));
            cn.jiguang.ad.a.a("JLocation", "fine:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION"));
            if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            }
            if (cn.jiguang.o.i.a(context)) {
            }
            if (newSingleThreadExecutor != null) {
            }
            a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
            if (a2 != null) {
            }
            super.a(context, str);
        } else {
            str2 = "collect wifi failed because not enable to collect wifi list";
        }
        cn.jiguang.ad.a.d("JLocation", str2);
        list = null;
        if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            cn.jiguang.ad.a.d("JLocation", "collect cell failed because has no Manifest.permission.LOCATION");
            aVar = null;
            cn.jiguang.ad.a.a("JLocation", "coares:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION"));
            cn.jiguang.ad.a.a("JLocation", "fine:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION"));
            if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            }
            if (cn.jiguang.o.i.a(context)) {
            }
            if (newSingleThreadExecutor != null) {
            }
            a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
            if (a2 != null) {
            }
            super.a(context, str);
        }
        if (cn.jiguang.o.i.a(context)) {
        }
        aVar = null;
        cn.jiguang.ad.a.a("JLocation", "coares:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION"));
        cn.jiguang.ad.a.a("JLocation", "fine:" + cn.jiguang.f.a.c(context, "android.permission.ACCESS_FINE_LOCATION"));
        if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_COARSE_LOCATION")) {
        }
        if (cn.jiguang.o.i.a(context)) {
        }
        if (newSingleThreadExecutor != null) {
        }
        a2 = a(a(list, aVar, bVar), cn.jiguang.v.d.a(context, "rl.catch"));
        if (a2 != null) {
        }
        super.a(context, str);
    }

    @Override // cn.jiguang.o.a
    protected final void a(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        if (optInt != 5) {
            if (optInt == 45) {
                cn.jiguang.o.f.a(this.f3649a, "JLocation", optJSONObject.optLong(ak.aT, 0L) * 1000);
                return;
            }
            return;
        }
        boolean optBoolean = true ^ optJSONObject.optBoolean("disable", true);
        cn.jiguang.o.f.a(this.f3649a, "JLocation", optBoolean);
        if (optBoolean) {
            cn.jiguang.o.f.b(this.f3649a, "JLocation", optJSONObject.optLong("frequency", 0L) * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
        String str2;
        String str3;
        JSONObject a2 = cn.jiguang.v.d.a(context, "rl.catch");
        if (a2 == null) {
            str2 = "JLocation";
            str3 = "there are no data to report";
        } else {
            JSONArray optJSONArray = a2.optJSONArray("content");
            if (optJSONArray != null) {
                cn.jiguang.o.i.a(context, optJSONArray);
                cn.jiguang.ad.a.a("JLocation", "clean cache json");
                if (context != null && !TextUtils.isEmpty("rl.catch")) {
                    try {
                        if (!cn.jiguang.v.d.a(context, "rl.catch", (JSONObject) null)) {
                            synchronized ("rl.catch") {
                                context.deleteFile("rl.catch");
                            }
                        }
                    } catch (Throwable th) {
                        cn.jiguang.ad.a.d("JCommonFileHelper", "cleanJson throwable:" + th.getMessage());
                    }
                }
                super.b(context, str);
                return;
            }
            str2 = "JLocation";
            str3 = "there are no content data to report";
        }
        cn.jiguang.ad.a.a(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final boolean b() {
        return cn.jiguang.o.f.i(this.f3649a, "JLocation");
    }

    @Override // cn.jiguang.o.a
    protected final boolean c() {
        return cn.jiguang.o.f.h(this.f3649a, "JLocation");
    }

    @Override // cn.jiguang.o.a
    protected final boolean c(Context context, String str) {
        return cn.jiguang.o.f.a(context, str);
    }

    @Override // cn.jiguang.o.a
    protected final boolean e(Context context) {
        return true;
    }

    @Override // cn.jiguang.o.a
    /* renamed from: g */
    public final Bundle f(Context context) {
        long longValue;
        double doubleValue;
        double doubleValue2;
        String d2 = cn.jiguang.o.f.d(context);
        if (TextUtils.isEmpty(d2)) {
            longValue = 0;
            doubleValue = 200.0d;
            doubleValue2 = 200.0d;
        } else {
            String[] split = d2.split(",");
            longValue = Long.valueOf(split[0]).longValue();
            doubleValue = Double.valueOf(split[1]).doubleValue();
            doubleValue2 = Double.valueOf(split[2]).doubleValue();
        }
        return a(longValue, doubleValue, doubleValue2);
    }
}

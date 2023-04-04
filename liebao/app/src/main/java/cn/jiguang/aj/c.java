package cn.jiguang.aj;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f3711a;

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f3712b = Executors.newSingleThreadExecutor();

    private c() {
    }

    private static int a(Context context, int i) {
        cn.jiguang.ak.a b2 = a.b(context, i);
        if (a.a(context, i) == null) {
            try {
                return Integer.parseInt(a.a(i, 4));
            } catch (Throwable unused) {
                return -1;
            }
        }
        return b2.m;
    }

    public static c a() {
        if (f3711a == null) {
            synchronized (c.class) {
                if (f3711a == null) {
                    f3711a = new c();
                }
            }
        }
        return f3711a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017d A[Catch: all -> 0x0304, TryCatch #0 {all -> 0x0304, blocks: (B:20:0x00a6, B:23:0x00b2, B:26:0x00bf, B:29:0x00c7, B:32:0x00dd, B:47:0x017d, B:48:0x0184, B:50:0x018a, B:53:0x0191, B:59:0x019f, B:61:0x01a5, B:63:0x01ab, B:45:0x016a), top: B:119:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0184 A[Catch: all -> 0x0304, TryCatch #0 {all -> 0x0304, blocks: (B:20:0x00a6, B:23:0x00b2, B:26:0x00bf, B:29:0x00c7, B:32:0x00dd, B:47:0x017d, B:48:0x0184, B:50:0x018a, B:53:0x0191, B:59:0x019f, B:61:0x01a5, B:63:0x01ab, B:45:0x016a), top: B:119:0x00a6 }] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(c cVar, Context context, int i, String str) {
        int i2;
        String str2;
        String str3;
        StringBuilder sb;
        JSONArray jSONArray;
        JSONObject jSONObject;
        String a2;
        int i3;
        String str4;
        String str5;
        boolean z;
        String str6;
        JSONObject jSONObject2;
        int i4;
        try {
            cn.jiguang.an.d.b("UPM", "u p:" + i + ",url:" + str);
            int a3 = a(context, i);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(cn.jiguang.dy.a.h, i);
            jSONObject3.put(cn.jiguang.dy.a.i, a3);
            String a4 = a.a(i, 4);
            if (!TextUtils.isEmpty(a4)) {
                try {
                    jSONObject3.put(cn.jiguang.dy.a.j, Integer.parseInt(a4));
                } catch (Throwable unused) {
                }
            }
            jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            long d2 = cn.jiguang.d.a.d(context);
            Object a5 = cn.jiguang.am.a.a(context);
            Object b2 = cn.jiguang.am.a.b(context);
            Object obj = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String charSequence = applicationInfo != null ? context.getPackageManager().getApplicationLabel(applicationInfo).toString() : "";
            Object a6 = cn.jiguang.c.b.a(context);
            try {
                jSONObject = null;
                Object obj2 = a6 instanceof JSONObject ? (JSONObject) a6 : null;
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put(cn.jiguang.dy.a.k, jSONArray);
                    try {
                        jSONObject4.put(cn.jiguang.dy.a.f4047a, System.currentTimeMillis());
                        String str7 = cn.jiguang.dy.a.f4048b;
                        if (a5 == null) {
                            a5 = "";
                        }
                        jSONObject4.put(str7, a5);
                        jSONObject4.put(cn.jiguang.dy.a.f4049c, d2);
                        String str8 = cn.jiguang.dy.a.f4050d;
                        if (b2 == null) {
                            b2 = "";
                        }
                        jSONObject4.put(str8, b2);
                        String str9 = cn.jiguang.dy.a.f4051e;
                        if (obj == null) {
                            obj = "";
                        }
                        jSONObject4.put(str9, obj);
                        jSONObject4.put(cn.jiguang.dy.a.f, charSequence);
                        jSONObject4.put(cn.jiguang.dy.a.g, context.getPackageName());
                        String str10 = cn.jiguang.dy.a.l;
                        if (obj2 == null) {
                            obj2 = "";
                        }
                        jSONObject4.put(str10, obj2);
                        cn.jiguang.an.d.b("UPM", "u:" + str);
                        cn.jiguang.an.d.b("UPM", "request p :" + jSONObject4.toString());
                        a2 = cn.jiguang.al.b.a(str, 10000, jSONObject4.toString());
                        cn.jiguang.an.d.b("UPM", "request http response:" + a2);
                    } catch (Throwable th) {
                        th = th;
                        jSONArray = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jSONArray = i;
                }
            } catch (Throwable th3) {
                th = th3;
                i2 = i;
                str3 = "pI:";
                str2 = " u finish";
            }
        } catch (Throwable th4) {
            th = th4;
            i2 = i;
            str2 = " u finish";
            str3 = "pI:";
        }
        if (!TextUtils.isEmpty(a2)) {
            try {
                jSONObject2 = new JSONObject(a2);
                i4 = jSONObject2.getInt(JThirdPlatFormInterface.KEY_CODE);
            } catch (Throwable th5) {
                th = th5;
            }
            if (i4 != 0) {
                cn.jiguang.an.d.g("UPM", "dealUif ERR:" + i4);
                cn.jiguang.an.d.g("UPM", "dealUif ERR:" + jSONObject2.getString("message"));
            } else {
                try {
                    jSONObject = jSONObject2.getJSONArray(JThirdPlatFormInterface.KEY_DATA).optJSONObject(0);
                } catch (Throwable th6) {
                    th = th6;
                    cn.jiguang.an.d.g("UPM", "dealUif e:" + th);
                    if (jSONObject == null) {
                    }
                    i3 = i;
                    sb = new StringBuilder("pI:");
                    sb.append(i3);
                    str2 = " u finish";
                    sb.append(str2);
                    cn.jiguang.an.d.b("UPM", sb.toString());
                }
                if (jSONObject == null) {
                    cn.jiguang.ak.a a7 = cn.jiguang.ak.a.a(jSONObject);
                    try {
                    } catch (Throwable th7) {
                        th = th7;
                        str2 = " u finish";
                        str3 = "pI:";
                        i2 = jSONArray;
                        try {
                            cn.jiguang.an.d.g("UPM", "sU error:" + th.getMessage());
                            sb = new StringBuilder(str3);
                            sb.append(i2);
                            sb.append(str2);
                            cn.jiguang.an.d.b("UPM", sb.toString());
                        } catch (Throwable th8) {
                            cn.jiguang.an.d.b("UPM", str3 + i2 + str2);
                            throw th8;
                        }
                    }
                    if (a7 != null) {
                        int i5 = a7.o;
                        if (i5 == 2) {
                            str6 = "l is newest.";
                        } else if (i5 != 1) {
                            if (i5 == 3) {
                                File a8 = a.a(context, i);
                                if (a8 != null && a8.exists()) {
                                    a8.delete();
                                }
                                i3 = i;
                                a.a(context, i3, "");
                            } else {
                                i3 = i;
                                if (i5 == 0) {
                                    cn.jiguang.an.d.b("UPM", "c nU l p...");
                                    File a9 = a.a(context, a7, true);
                                    cn.jiguang.an.d.b("UPM", "pII:" + a9);
                                    if (a9 != null) {
                                        a.a(context, a7.k, a7.v);
                                        cn.jiguang.an.d.b("UPM", "p has exist, p is:" + a9.getAbsolutePath());
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        if (TextUtils.isEmpty(a7.p)) {
                                            str4 = "p:" + i3 + " du is empty";
                                        } else {
                                            File a10 = b.a(context, a7.f3722q, a7.k, a7.m);
                                            if (cn.jiguang.al.b.b(a7.p, 10000, a10.getAbsolutePath()) != null) {
                                                cn.jiguang.an.d.b("UPM", "d p :" + a7.p + " p:" + a10);
                                                String a11 = cn.jiguang.al.a.a(a10.getAbsolutePath());
                                                if (!TextUtils.isEmpty(a11) && a11.equalsIgnoreCase(a7.f3722q)) {
                                                    File a12 = a.a(context, a7.k);
                                                    a.a(context, a7.k, a7.v);
                                                    if (a12 != null && a12.exists()) {
                                                        cn.jiguang.an.d.b("UPM", "delete old file:" + a12.getAbsolutePath());
                                                        a12.delete();
                                                    }
                                                    str4 = "d p val succ";
                                                }
                                                cn.jiguang.an.d.b("UPM", "d p m not m, will d: file m:" + a11 + ",config m:" + a7.f3722q);
                                                a10.delete();
                                            } else {
                                                str5 = "d p :" + a7.p + " fail.";
                                            }
                                        }
                                    }
                                } else {
                                    str5 = "p status is :" + i5;
                                }
                                cn.jiguang.an.d.f("UPM", str5);
                            }
                            sb = new StringBuilder("pI:");
                            sb.append(i3);
                            str2 = " u finish";
                            sb.append(str2);
                            cn.jiguang.an.d.b("UPM", sb.toString());
                        } else {
                            str6 = "p not exist.";
                        }
                        cn.jiguang.an.d.b("UPM", str6);
                    } else {
                        i3 = i;
                        str4 = "dUif error:" + a2;
                    }
                    cn.jiguang.an.d.b("UPM", str4);
                    sb = new StringBuilder("pI:");
                    sb.append(i3);
                    str2 = " u finish";
                    sb.append(str2);
                    cn.jiguang.an.d.b("UPM", sb.toString());
                }
                cn.jiguang.an.d.g("UPM", "dealUif ERR");
            }
        }
        i3 = i;
        sb = new StringBuilder("pI:");
        sb.append(i3);
        str2 = " u finish";
        sb.append(str2);
        cn.jiguang.an.d.b("UPM", sb.toString());
    }

    public final void a(Context context, int i, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jiguang.prefs", 0);
        long j = sharedPreferences.getLong("plugin_update_time_" + i, 0L);
        StringBuilder sb = new StringBuilder("plugin_update_interval_");
        sb.append(i);
        boolean z = j <= 0 || System.currentTimeMillis() > sharedPreferences.getLong(sb.toString(), 86400000L) + j;
        if (!z) {
            cn.jiguang.an.d.b("UPM", "no need update, last is " + cn.jiguang.f.c.a(j));
        }
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("cn.jiguang.prefs", 0).edit();
                edit.putLong("plugin_update_time_" + i, currentTimeMillis).apply();
            } catch (Throwable unused) {
            }
            f3712b.execute(new d(this, context, i, str));
        }
    }
}

package cn.jiguang.q;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jiguang.o.f;
import cn.jiguang.o.i;
import cn.jiguang.u.e;
import cn.jiguang.u.g;
import com.umeng.analytics.pro.ak;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends cn.jiguang.o.a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f4201c;

    /* renamed from: a  reason: collision with root package name */
    private Context f4202a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f4203b;

    /* renamed from: d  reason: collision with root package name */
    private String f4204d;

    public static b a() {
        if (f4201c == null) {
            synchronized (b.class) {
                f4201c = new b();
            }
        }
        return f4201c;
    }

    private static JSONObject g(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb;
        if (context == null) {
            cn.jiguang.ad.a.d("JDevice", "when getDeviceInfo, context can't be null");
            return null;
        }
        try {
            String a2 = cn.jiguang.u.a.a();
            String a3 = cn.jiguang.u.a.a(context);
            String format = String.format(Locale.ENGLISH, "%.1f", Double.valueOf(cn.jiguang.u.a.b(context)));
            String format2 = String.format(Locale.ENGLISH, Build.VERSION.RELEASE, new Object[0]);
            String format3 = String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
            String format4 = String.format(Locale.ENGLISH, Build.BRAND, new Object[0]);
            String format5 = String.format(Locale.ENGLISH, Build.PRODUCT, new Object[0]);
            String format6 = JConstants.isAndroidQ(context, false, "won't get serial") ? "" : String.format(Locale.ENGLISH, Build.SERIAL, new Object[0]);
            String format7 = String.format(Locale.ENGLISH, Build.FINGERPRINT, new Object[0]);
            String locale = context.getResources().getConfiguration().locale.toString();
            String format8 = String.format(Locale.ENGLISH, Build.MANUFACTURER, new Object[0]);
            try {
                long rawOffset = TimeZone.getDefault().getRawOffset() / JConstants.HOUR;
                String f = cn.jiguang.f.a.f(context, "");
                if (rawOffset > 0) {
                    str4 = "";
                    sb = new StringBuilder("+");
                    sb.append(rawOffset);
                } else {
                    str4 = "";
                    if (rawOffset < 0) {
                        sb = new StringBuilder("-");
                        sb.append(rawOffset);
                    } else {
                        sb = new StringBuilder();
                        sb.append(rawOffset);
                    }
                }
                String sb2 = sb.toString();
                long c2 = cn.jiguang.u.a.c(context);
                str = "JDevice";
                try {
                    long c3 = cn.jiguang.u.a.c();
                    int d2 = cn.jiguang.u.a.d();
                    String b2 = cn.jiguang.u.a.b();
                    int e2 = cn.jiguang.u.a.e();
                    String a4 = e.a(context);
                    String g = cn.jiguang.f.a.g(context);
                    JSONArray d3 = cn.jiguang.u.a.d(context);
                    JSONObject jSONObject = new JSONObject();
                    String str5 = format6;
                    if (TextUtils.isEmpty(a2)) {
                        a2 = str4;
                    }
                    jSONObject.put("cpu_info", a2);
                    jSONObject.put("cpu_count", d2);
                    jSONObject.put("cpu_max_freq", e2);
                    jSONObject.put("cpu_hardware", b2);
                    jSONObject.put("ram", c2);
                    jSONObject.put("rom", c3);
                    if (TextUtils.isEmpty(a3)) {
                        a3 = str4;
                    }
                    jSONObject.put(ak.z, a3);
                    if (TextUtils.isEmpty(format)) {
                        format = str4;
                    }
                    jSONObject.put("screensize", format);
                    if (TextUtils.isEmpty(format2)) {
                        format2 = str4;
                    }
                    jSONObject.put(ak.y, format2);
                    if (TextUtils.isEmpty(format3)) {
                        format3 = str4;
                    }
                    jSONObject.put("model", format3);
                    if (TextUtils.isEmpty(format4)) {
                        format4 = str4;
                    }
                    jSONObject.put("brand", format4);
                    if (TextUtils.isEmpty(format5)) {
                        format5 = str4;
                    }
                    jSONObject.put("product", format5);
                    jSONObject.put("serial", TextUtils.isEmpty(str5) ? str4 : str5);
                    jSONObject.put("fingerprint", TextUtils.isEmpty(format7) ? str4 : format7);
                    jSONObject.put(ak.N, TextUtils.isEmpty(locale) ? str4 : locale);
                    jSONObject.put("manufacturer", TextUtils.isEmpty(format8) ? str4 : format8);
                    jSONObject.put(ak.M, TextUtils.isEmpty(sb2) ? str4 : sb2);
                    String a5 = g.a();
                    if (TextUtils.isEmpty(a5)) {
                        a5 = str4;
                    }
                    jSONObject.put("romversion", a5);
                    jSONObject.put("mac", TextUtils.isEmpty(f) ? str4 : f);
                    jSONObject.put("meid", TextUtils.isEmpty(a4) ? str4 : a4);
                    jSONObject.put("sim_slots", d3);
                    jSONObject.put("android_id", TextUtils.isEmpty(g) ? str4 : g);
                    JSONObject a6 = cn.jiguang.x.a.a(context);
                    if (a6 != null) {
                        jSONObject.put("ids", a6);
                    }
                    return jSONObject;
                } catch (JSONException e3) {
                    e = e3;
                    str2 = str;
                    str3 = "package json exception: " + e.getMessage();
                    cn.jiguang.ad.a.d(str2, str3);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    str3 = "getDeviceInfo exception: " + th.getMessage();
                    str2 = str;
                    cn.jiguang.ad.a.d(str2, str3);
                    return null;
                }
            } catch (JSONException e4) {
                e = e4;
                str2 = "JDevice";
            } catch (Throwable th2) {
                th = th2;
                str = "JDevice";
            }
        } catch (JSONException e5) {
            e = e5;
            str2 = "JDevice";
        } catch (Throwable th3) {
            th = th3;
            str = "JDevice";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[Catch: all -> 0x00ab, TryCatch #0 {all -> 0x00ab, blocks: (B:3:0x0007, B:18:0x0047, B:21:0x0061, B:24:0x006e, B:27:0x007b, B:30:0x0088, B:33:0x0095, B:37:0x00a3, B:17:0x0041, B:14:0x003b, B:11:0x0021), top: B:42:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: all -> 0x00ab, TryCatch #0 {all -> 0x00ab, blocks: (B:3:0x0007, B:18:0x0047, B:21:0x0061, B:24:0x006e, B:27:0x007b, B:30:0x0088, B:33:0x0095, B:37:0x00a3, B:17:0x0041, B:14:0x003b, B:11:0x0021), top: B:42:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String h(Context context) {
        String str;
        PackageInfo packageInfo;
        String str2;
        String valueOf;
        String str3;
        String valueOf2;
        String str4 = "";
        try {
            String b2 = cn.jiguang.am.a.b(context);
            String a2 = cn.jiguang.am.a.a(context);
            try {
                str = context.getPackageName();
            } catch (Throwable th) {
                th = th;
                str = "";
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable th2) {
                th = th2;
                cn.jiguang.ad.a.d("JDevice", "getPackageManager failed:" + th.getMessage());
                packageInfo = null;
                if (packageInfo != null) {
                }
                if (packageInfo != null) {
                }
                str3 = cn.jiguang.a.a.f3640b;
                valueOf2 = String.valueOf(cn.jiguang.a.a.f3641c);
                StringBuilder sb = new StringBuilder();
                sb.append(b2);
                sb.append(",");
                if (TextUtils.isEmpty(a2)) {
                }
                sb.append(a2);
                sb.append(",");
                if (TextUtils.isEmpty(str2)) {
                }
                sb.append(str2);
                sb.append(",");
                if (TextUtils.isEmpty(valueOf)) {
                }
                sb.append(valueOf);
                sb.append(",");
                if (TextUtils.isEmpty(str3)) {
                }
                sb.append(str3);
                sb.append(",");
                if (TextUtils.isEmpty(valueOf2)) {
                }
                sb.append(valueOf2);
                sb.append(",");
                if (TextUtils.isEmpty(str)) {
                }
                sb.append(str4);
                return sb.toString();
            }
            str2 = packageInfo != null ? "" : packageInfo.versionName;
            valueOf = packageInfo != null ? "" : String.valueOf(packageInfo.versionCode);
            str3 = cn.jiguang.a.a.f3640b;
            valueOf2 = String.valueOf(cn.jiguang.a.a.f3641c);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b2);
            sb2.append(",");
            if (TextUtils.isEmpty(a2)) {
                a2 = "";
            }
            sb2.append(a2);
            sb2.append(",");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb2.append(str2);
            sb2.append(",");
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = "";
            }
            sb2.append(valueOf);
            sb2.append(",");
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            sb2.append(str3);
            sb2.append(",");
            if (TextUtils.isEmpty(valueOf2)) {
                valueOf2 = "";
            }
            sb2.append(valueOf2);
            sb2.append(",");
            if (TextUtils.isEmpty(str)) {
                str4 = str;
            }
            sb2.append(str4);
            return sb2.toString();
        } catch (Throwable th3) {
            cn.jiguang.ad.a.d("JDevice", "getCurrentCondition throwable: " + th3.getMessage());
            return null;
        }
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f4202a = context;
        return "JDevice";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
        JSONObject g = g(context);
        this.f4203b = g;
        if (g == null) {
            cn.jiguang.ad.a.d("JDevice", "collect failed");
            return;
        }
        cn.jiguang.ad.a.a("JDevice", "collect success:" + this.f4203b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
        JSONObject jSONObject = this.f4203b;
        if (jSONObject == null) {
            cn.jiguang.ad.a.a("JDevice", "there are no data to report");
            return;
        }
        cn.jiguang.d.a.a(context, jSONObject, "device_info");
        i.a(context, this.f4203b, new a(context, this.f4204d, str));
        this.f4203b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final boolean d(Context context, String str) {
        if (f.b(context, str)) {
            JSONObject jSONObject = this.f4203b;
            if (jSONObject == null) {
                cn.jiguang.ad.a.d("JDevice", "there are no data to report");
                return false;
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                return false;
            }
            this.f4204d = cn.jiguang.f.i.k(jSONObject2 + h(context));
            String f = f.f(context);
            if (TextUtils.isEmpty(this.f4204d) || TextUtils.equals(this.f4204d, f)) {
                cn.jiguang.ad.a.a("JDevice", "device detail is not change");
                return false;
            }
            cn.jiguang.ad.a.a("JDevice", "device detail is change");
            return super.d(context, str);
        }
        return false;
    }

    @Override // cn.jiguang.o.a
    public final Object f(Context context) {
        return g(context);
    }
}

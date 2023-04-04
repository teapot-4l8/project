package cn.jiguang.e;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.an.d;
import cn.jiguang.at.h;
import cn.jiguang.at.n;
import cn.jiguang.av.c;
import cn.jiguang.f.e;
import cn.jiguang.f.i;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.service.DownloadProvider;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4054b = ".jpush" + File.separator + ".shareinfo" + File.separator;
    private static final Object f = new Object();
    private static Boolean g;
    private static Boolean h;
    private static a j;

    /* renamed from: a  reason: collision with root package name */
    Context f4055a;

    /* renamed from: c  reason: collision with root package name */
    private int f4056c;

    /* renamed from: d  reason: collision with root package name */
    private long[] f4057d;

    /* renamed from: e  reason: collision with root package name */
    private String f4058e;
    private volatile boolean i;
    private boolean k;

    private a() {
        cn.jiguang.ap.b.a("share_process_executor");
    }

    private static ActivityInfo a(String str, Context context) {
        String str2;
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DownloadActivity");
            intent.addCategory(str);
            intent.setPackage(str);
            ActivityInfo activityInfo = context.getPackageManager().resolveActivity(intent, 0).activityInfo;
            if ((activityInfo instanceof ActivityInfo) && ((ComponentInfo) activityInfo).exported && ((ComponentInfo) activityInfo).enabled) {
                if (!"jpush.custom".equals(activityInfo.taskAffinity)) {
                    str2 = "download activity need config taskAffinity is jpush.custom";
                } else if (activityInfo.theme == 16973840) {
                    return activityInfo;
                } else {
                    str2 = "download activity theme must config as @android:style/Theme.Translucent.NoTitleBar";
                }
                d.b("ShareProcessManager", str2);
            }
        } catch (Throwable th) {
            d.f("ShareProcessManager", "check downloadActivity error:" + th.getMessage());
        }
        d.b("ShareProcessManager", "DownloadActivity is invalid in " + str);
        return null;
    }

    public static a a() {
        if (j == null) {
            synchronized (f) {
                if (j == null) {
                    j = new a();
                }
            }
        }
        return j;
    }

    private b a(String str) {
        Throwable th;
        b bVar;
        try {
        } catch (Throwable th2) {
            th = th2;
            bVar = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        bVar = new b(this);
        try {
            long optLong = jSONObject.optLong(ak.aG);
            String optString = jSONObject.optString("ak");
            String optString2 = jSONObject.optString("pn");
            String optString3 = jSONObject.optString("ud");
            int optInt = jSONObject.optInt("idc", -1);
            int optInt2 = jSONObject.optInt("sv");
            long optLong2 = jSONObject.optLong("uct", -1L);
            bVar.f4062d = optLong;
            bVar.f4061c = optString3;
            bVar.f = optString;
            bVar.f4060b = optInt;
            bVar.f4063e = optString2;
            bVar.g = optInt2;
            bVar.h = optLong2;
        } catch (Throwable th3) {
            th = th3;
            d.f("ShareProcessManager", "parse json to shareBean failed:" + th.getMessage());
            return bVar;
        }
        return bVar;
    }

    public static String a(Context context, Uri uri) {
        try {
        } catch (Throwable th) {
            d.f("ShareProcessManager", "parseUriFromProvider failed:" + th.getMessage());
        }
        if (uri == null) {
            return cn.jiguang.a.a.f3640b;
        }
        String queryParameter = uri.getQueryParameter("kpgt");
        if (TextUtils.isEmpty(queryParameter)) {
            return cn.jiguang.a.a.f3640b;
        }
        String b2 = cn.jiguang.bb.d.b(queryParameter);
        if (TextUtils.isEmpty(b2)) {
            return "-6";
        }
        JSONObject jSONObject = new JSONObject(b2);
        String optString = jSONObject.optString("kta");
        d.b("ShareProcessManager", "action:" + optString);
        if (!TextUtils.isEmpty(optString)) {
            if (optString.equals("asai")) {
                return e(context);
            }
            if (optString.equals("asm")) {
                d.b("ShareProcessManager", "recv msg:" + jSONObject.toString());
                if (g(context) && ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.k())).intValue() != 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString(JThirdPlatFormInterface.KEY_DATA, jSONObject.toString());
                    cn.jiguang.c.b.a(context, JConstants.SDK_TYPE, "asm", bundle);
                    return "0";
                }
                d.b("ShareProcessManager", "share process is closed!");
                return "-4";
            } else if (optString.equals("asmr")) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(JThirdPlatFormInterface.KEY_DATA, jSONObject.toString());
                cn.jiguang.c.b.a(context, JConstants.SDK_TYPE, "asmr", bundle2);
            }
        }
        return cn.jiguang.a.a.f3640b;
    }

    private static String a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            String str3 = str + ".DownloadProvider";
            if (!str3.startsWith("content://")) {
                str3 = "content://" + str3;
            }
            Uri parse = Uri.parse(str3);
            JSONObject jSONObject = new JSONObject();
            Uri.Builder buildUpon = parse.buildUpon();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("kta", str2);
            }
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            buildUpon.appendQueryParameter("kpgt", cn.jiguang.bb.d.a(jSONObject.toString()));
            return contentResolver.getType(buildUpon.build());
        } catch (Throwable th) {
            d.f("ShareProcessManager", "callUriToDownloadProvider error:" + th.getMessage());
            return null;
        }
    }

    private static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            d.f("ShareProcessManager", "mapToJSONObject error:" + th.getMessage());
        }
        return jSONObject;
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            d.f("ShareProcessManager", "deletFileIfUninstall failed ,context is null or pkgname is empty");
            return;
        }
        try {
            if (cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                File b2 = b(str);
                if (b2.exists()) {
                    b2.delete();
                } else {
                    d.b("ShareProcessManager", "not found file in sdcard,filepath:" + b2.getAbsolutePath());
                }
            } else {
                d.b("ShareProcessManager", "no write sdcard permission when deletFileIfUninstall");
            }
        } catch (Throwable unused) {
        }
    }

    private b b(Context context, String str) {
        String str2;
        File b2;
        String str3;
        String str4;
        String str5;
        String str6;
        try {
            String a2 = a(context, str, "asai", null);
            d.b("ShareProcessManager", "get type from:" + str + ",info:" + a2);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2) && a2.length() > 10) {
                    String b3 = cn.jiguang.bb.d.b(a2);
                    if (TextUtils.isEmpty(b3)) {
                        d.b("ShareProcessManager", "decrypt error");
                        return null;
                    }
                    d.b("ShareProcessManager", "parse success:" + b3);
                    return a(b3);
                }
                str2 = "is not shareprocessbean info";
            } else if (!f(context) || JConstants.isAndroidQ(context, false, "do not get share info from SD")) {
                return null;
            } else {
                if (cn.jiguang.f.a.c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                    String b4 = e.b(b(str));
                    if (TextUtils.isEmpty(b4)) {
                        str2 = "read info is empty from :" + b2.getAbsolutePath();
                    } else {
                        b a3 = a(cn.jiguang.bb.d.b(b4));
                        if (a3 != null) {
                            str3 = a3.f4063e;
                            if (!cn.jiguang.f.a.g(context, str3)) {
                                StringBuilder sb = new StringBuilder("found target app is uninsatll when scan sdcard,pkgname:");
                                str4 = a3.f4063e;
                                sb.append(str4);
                                d.b("ShareProcessManager", sb.toString());
                                str5 = a3.f4063e;
                                a(context, str5);
                                return null;
                            }
                            str6 = a3.f4063e;
                            if (a(str6, context) != null) {
                                d.b("ShareProcessManager", "get share bean info from sdcard:" + a3.toString());
                                return a3;
                            }
                            str2 = "not config DownloadActivity in target app:" + str;
                        } else {
                            str2 = "parse share process bean with target app:" + str;
                        }
                    }
                } else {
                    str2 = "no read sdcard permission";
                }
            }
            d.b("ShareProcessManager", str2);
            return null;
        } catch (Throwable th) {
            d.g("ShareProcessManager", "scanShareProcessBean error:" + th.getMessage());
            return null;
        }
    }

    private static File b(String str) {
        String d2 = i.d(str);
        if (!TextUtils.isEmpty(d2)) {
            str = d2;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return new File(externalStorageDirectory, f4054b + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea A[Catch: all -> 0x016f, TryCatch #0 {all -> 0x016f, blocks: (B:3:0x000d, B:5:0x0022, B:8:0x002a, B:9:0x0030, B:11:0x0036, B:13:0x0048, B:15:0x004e, B:17:0x0058, B:19:0x0060, B:21:0x0064, B:23:0x0095, B:25:0x0099, B:27:0x00a1, B:33:0x00ea, B:30:0x00bc, B:34:0x00ed, B:35:0x00f1, B:37:0x0110, B:38:0x0113, B:39:0x012c, B:41:0x0132, B:43:0x014f, B:44:0x0153, B:45:0x0169), top: B:50:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ed A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Set<b> c(Context context) {
        List<ResolveInfo> queryIntentServices;
        boolean z;
        HashSet hashSet = new HashSet();
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DaemonService");
            queryIntentServices = packageManager.queryIntentServices(intent, 0);
        } catch (Throwable th) {
            d.f("ShareProcessManager", "scanOtherApp error:" + th.getMessage());
        }
        if (queryIntentServices != null && queryIntentServices.size() != 0) {
            List<String> arrayList = new ArrayList();
            for (int i = 0; i < queryIntentServices.size(); i++) {
                ServiceInfo serviceInfo = queryIntentServices.get(i).serviceInfo;
                String str = serviceInfo.name;
                String str2 = serviceInfo.packageName;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !context.getPackageName().equals(str2)) {
                    ProviderInfo b2 = cn.jiguang.f.a.b(context, str2, DownloadProvider.class);
                    if (b2 != null && (b2 instanceof ProviderInfo)) {
                        ProviderInfo providerInfo = b2;
                        d.a("ShareProcessManager", "scan exported:" + providerInfo.exported + ",enable:" + providerInfo.enabled + ",authority:" + providerInfo.authority + ",process:" + providerInfo.processName);
                        if (providerInfo.exported && providerInfo.enabled && !TextUtils.isEmpty(providerInfo.authority)) {
                            if (TextUtils.equals(str2 + ".DownloadProvider", providerInfo.authority)) {
                                z = true;
                                if (!z) {
                                    arrayList.add(str2);
                                }
                            }
                        }
                        d.b("ShareProcessManager", "downloadprovider config error,exported:" + providerInfo.exported + ",enable:" + providerInfo.enabled + ",authority:" + providerInfo.authority + ",process:" + providerInfo.processName);
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            d.b("ShareProcessManager", "valid size:" + arrayList.size());
            Object a2 = cn.jiguang.at.d.a(context, "filter_pkg_list", arrayList);
            if (a2 instanceof List) {
                arrayList = (List) a2;
            }
            d.b("ShareProcessManager", "valid end size:" + arrayList.size());
            for (String str3 : arrayList) {
                b b3 = b(context, str3);
                d.b("ShareProcessManager", "scan share bean from:" + str3);
                if (b3 != null) {
                    hashSet.add(b3);
                }
            }
            d.b("ShareProcessManager", "end share bean list size:" + hashSet.size());
            return hashSet;
        }
        d.b("ShareProcessManager", "query service size is empty");
        return hashSet;
    }

    private static void d(Context context) {
        try {
            if (JConstants.isAndroidQ(context, false, "do not save ShareInfo to SD")) {
                return;
            }
            if (!cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                d.b("ShareProcessManager", "no write sdcard permission");
                return;
            }
            File b2 = b(context.getPackageName());
            if (!f(context)) {
                e.a(b2);
                return;
            }
            String e2 = e(context);
            d.b("ShareProcessManager", "save info to sdcard:" + b2.getAbsolutePath());
            if (TextUtils.isEmpty(e2) || e2.length() <= 10) {
                return;
            }
            e.a(b2);
            e.a(b2, e2);
        } catch (Throwable th) {
            d.f("ShareProcessManager", "saveShareInfoToSdCard failed:" + th.getMessage());
        }
    }

    private static String e(Context context) {
        if (context == null) {
            return "-1";
        }
        if (!g(context) || cn.jiguang.d.a.j(context) == 1) {
            d.b("ShareProcessManager", "[getTypeJson]share process is close by action");
            return "-4";
        } else if (!cn.jiguang.am.b.a().d()) {
            d.b("ShareProcessManager", "getAttachJson,is not support jpush or jmessage ");
            return "-7";
        } else {
            int h2 = cn.jiguang.d.a.h(context);
            if (h2 < 0) {
                d.b("ShareProcessManager", "[getTypeJson]idc<0,need login to get it");
                return "-3";
            }
            long d2 = cn.jiguang.d.a.d(context);
            if (d2 <= 0) {
                d.b("ShareProcessManager", "[getTypeJson]uid<=0,need login to get it");
                return "-2";
            }
            Map map = (Map) cn.jiguang.d.a.g(context);
            String str = (String) map.get("uuid");
            long longValue = ((Long) map.get("ct")).longValue();
            String a2 = cn.jiguang.am.a.a(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ak.aG, d2);
                jSONObject.put(ak.ax, cn.jiguang.d.a.f(context));
                jSONObject.put("ud", str);
                jSONObject.put("ak", a2);
                jSONObject.put("idc", h2);
                jSONObject.put("pn", context.getPackageName());
                jSONObject.put("sv", cn.jiguang.a.a.f3641c);
                jSONObject.put("uct", longValue);
                return cn.jiguang.bb.d.a(jSONObject.toString());
            } catch (JSONException unused) {
                d.b("ShareProcessManager", "[getTypeJson] to json error");
                return cn.jiguang.a.a.f3640b;
            }
        }
    }

    private static boolean f(Context context) {
        Boolean bool = h;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            String str = Build.MANUFACTURER;
            String lowerCase = "Xiaomi".toLowerCase();
            if (!TextUtils.isEmpty(str) && TextUtils.equals(lowerCase, str.toLowerCase())) {
                d.b("ShareProcessManager", "xiaomi not use activity and sdcard");
                Boolean bool2 = false;
                h = bool2;
                return bool2.booleanValue();
            }
        } catch (Throwable th) {
            d.f("ShareProcessManager", "get MANUFACTURER failed - error:" + th.getMessage());
        }
        h = a(context.getPackageName(), context) != null;
        return h.booleanValue();
    }

    private static boolean g(Context context) {
        Boolean bool = g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            d.f("ShareProcessManager", "context is null");
            return true;
        }
        try {
            ProviderInfo b2 = cn.jiguang.f.a.b(context, context.getPackageName(), DownloadProvider.class);
            if (b2 == null) {
                d.b("ShareProcessManager", "not found download provider in manifest");
                Boolean bool2 = false;
                g = bool2;
                return bool2.booleanValue();
            }
            if (((ComponentInfo) b2).enabled && ((ComponentInfo) b2).exported && !TextUtils.isEmpty(b2.authority)) {
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("cn.jiguang.android.share.close");
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                g = queryIntentServices == null || queryIntentServices.isEmpty();
                return g.booleanValue();
            }
            d.b("ShareProcessManager", "download provider config error,enable" + ((ComponentInfo) b2).enabled + ",exported:" + ((ComponentInfo) b2).exported + ",authority:" + b2.authority);
            Boolean bool3 = false;
            g = bool3;
            return bool3.booleanValue();
        } catch (Throwable th) {
            d.b("ShareProcessManager", "Get isShareProcessModeOpen error#:" + th.getMessage());
            return true;
        }
    }

    public final void a(int i, int i2) {
        d.b("ShareProcessManager", "requestsuccess,cmd:" + i2 + ",code:0");
        if (i2 == 30) {
            this.f4056c = 0;
        }
    }

    public final synchronized void a(Context context) {
        if (g(context) && cn.jiguang.ap.b.c(context) != 1) {
            if (!cn.jiguang.am.b.a().d()) {
                d.b("ShareProcessManager", "is not support jpush or jmessage ");
                return;
            }
            Object a2 = cn.jiguang.at.d.a(context, "getwakeenable", null);
            if ((a2 instanceof Boolean) && !((Boolean) a2).booleanValue()) {
                d.b("ShareProcessManager", "wake disable,not scan share app");
                return;
            } else if (this.i) {
                d.b("ShareProcessManager", "isAttaching");
                return;
            } else {
                this.f4055a = context;
                this.i = true;
                d.b("ShareProcessManager", "scanOtherApp...");
                this.f4056c = 0;
                cn.jiguang.ap.b.a("share_process_executor", this);
                return;
            }
        }
        d.b("ShareProcessManager", "share process is close by action");
        a(context, context.getPackageName());
    }

    public final void a(Context context, int i) {
        d.b("ShareProcessManager", "requestTimeOut,cmd:" + i + ",isAttaching:" + this.i);
        if (i != 30 || this.i) {
            return;
        }
        this.f4056c++;
        d.b("ShareProcessManager", "attachTimeoutTimes:" + this.f4056c + ",requestUIDS:" + this.f4057d + ",shareProcessUUID:" + this.f4058e);
        if (this.f4056c > 2) {
            d.b("ShareProcessManager", "attach too many times by once scan");
            return;
        }
        long[] jArr = this.f4057d;
        if (jArr == null || jArr.length <= 0 || TextUtils.isEmpty(this.f4058e)) {
            return;
        }
        d.b("ShareProcessManager", "will retry attach");
        cn.jiguang.ap.b.a(context, JConstants.SDK_TYPE, 30, 0, n.b(), 0L, cn.jiguang.av.b.a(cn.jiguang.d.a.d(context), this.f4058e, this.f4057d));
    }

    public final void a(Context context, long j2) {
        try {
            if (TextUtils.isEmpty(this.f4058e)) {
                d.b("ShareProcessManager", "dettachUid error,shareUUID is empty");
                return;
            }
            d.b("ShareProcessManager", "dettach uid:" + j2);
            cn.jiguang.ap.b.a(context, JConstants.SDK_TYPE, 32, 0, n.b(), 0L, cn.jiguang.av.b.a(this.f4058e, new long[]{j2}));
        } catch (Throwable th) {
            d.b("ShareProcessManager", "dettach uid error:" + th.getMessage());
        }
    }

    public final void a(Context context, long j2, byte[] bArr) {
        String str;
        long j3;
        if (j2 == 0 || bArr == null) {
            return;
        }
        try {
            Pair<c, ByteBuffer> a2 = cn.jiguang.av.a.a(context, bArr, "");
            if (a2 != null && ((c) a2.first).f3985c == 3) {
                ByteBuffer byteBuffer = (ByteBuffer) a2.second;
                byteBuffer.get();
                long j4 = byteBuffer.getLong();
                String a3 = cn.jiguang.av.b.a(byteBuffer);
                if (TextUtils.isEmpty(a3)) {
                    d.f("ShareProcessManager", "msgContent is empty");
                    return;
                }
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(a3));
                String readLine = lineNumberReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    d.h("ShareProcessManager", "appid is empty");
                    return;
                }
                String readLine2 = lineNumberReader.readLine();
                if (TextUtils.isEmpty(readLine2)) {
                    d.h("ShareProcessManager", "senderId is empty");
                    return;
                }
                if (g(context) && cn.jiguang.ap.b.c(context) != 1) {
                    if (!cn.jiguang.f.a.g(context, readLine)) {
                        a(context, ((c) a2.first).g);
                        d.b("ShareProcessManager", "app not installed:" + readLine);
                        a(context, readLine);
                        return;
                    }
                    String encodeToString = Base64.encodeToString(bArr, 10);
                    Long valueOf = Long.valueOf(((c) a2.first).f3987e);
                    HashMap hashMap = new HashMap();
                    hashMap.put("ktm", encodeToString);
                    hashMap.put("ktp", cn.jiguang.bb.d.a(cn.jiguang.d.a.d(context)));
                    hashMap.put("ktma", readLine2);
                    StringBuilder sb = new StringBuilder();
                    sb.append(j4);
                    hashMap.put("mtmmi", sb.toString());
                    hashMap.put("ktmfp", context.getPackageName());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(valueOf);
                    hashMap.put("ktmr", sb2.toString());
                    d.b("ShareProcessManager", "dispatch share msg,appkey:" + readLine2 + ",msgid:" + j4 + ",rid:" + valueOf);
                    String a4 = a(context, readLine, "asm", hashMap);
                    StringBuilder sb3 = new StringBuilder("dispatch result:");
                    sb3.append(a4);
                    d.b("ShareProcessManager", sb3.toString());
                    if (TextUtils.isEmpty(a4)) {
                        if (!f(context)) {
                            d.b("ShareProcessManager", "app can not use downloadActivity dispatch msg");
                            j3 = ((c) a2.first).g;
                        } else if (!cn.jiguang.ap.b.f3801a && JConstants.isAndroidQ(context, false, "do not startActivity in BackGround")) {
                            this.k = true;
                            a(context, cn.jiguang.d.a.d(context));
                            return;
                        } else {
                            ActivityInfo a5 = a(readLine, context);
                            if (a5 != null) {
                                d.b("ShareProcessManager", "will try use downloadActivity");
                                JSONObject a6 = a(hashMap);
                                Intent intent = new Intent("asm");
                                intent.setComponent(new ComponentName(a5.packageName, a5.name));
                                intent.setFlags(268435456);
                                intent.addCategory(readLine);
                                intent.putExtra(JThirdPlatFormInterface.KEY_DATA, a6.toString());
                                context.startActivity(intent);
                            } else {
                                j3 = ((c) a2.first).g;
                            }
                        }
                        a(context, j3);
                    } else if (a4.equals("-4")) {
                        j3 = ((c) a2.first).g;
                        a(context, j3);
                    } else {
                        if (a4.equals("0")) {
                            str = "wait the msg reponse";
                        } else {
                            str = "provider is :" + a4 + ",app is less than jcore_v125";
                        }
                        d.b("ShareProcessManager", str);
                    }
                    lineNumberReader.close();
                    return;
                }
                a(context, cn.jiguang.d.a.d(context));
                d.b("ShareProcessManager", " share process is close,will not dispatch the msg and dettach mine uid");
                return;
            }
            d.b("ShareProcessManager", "share msg cmd is not 3");
        } catch (Throwable th) {
            d.f("ShareProcessManager", "dispatchMsg error:" + th.getMessage());
        }
    }

    public final void a(Context context, Bundle bundle) {
        String str;
        try {
            d.b("ShareProcessManager", "doMsg");
            if (bundle != null) {
                String string = bundle.getString(JThirdPlatFormInterface.KEY_DATA);
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                d.b("ShareProcessManager", "doMsg json:" + jSONObject.toString());
                String optString = jSONObject.optString("ktm");
                String optString2 = jSONObject.optString("ktp");
                String optString3 = jSONObject.optString("mtmmi");
                String optString4 = jSONObject.optString("ktmfp");
                String optString5 = jSONObject.optString("ktma");
                String optString6 = jSONObject.optString("ktmr");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString5)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("mtmmi", optString3);
                hashMap.put("ktmfp", optString4);
                hashMap.put("ktma", optString5);
                hashMap.put("ktmr", optString6);
                Pair<c, ByteBuffer> a2 = cn.jiguang.av.a.a(context, Base64.decode(optString, 10), optString2);
                if (a2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(((c) a2.first).g);
                    hashMap.put("ktmu", sb.toString());
                    if (g(context) && cn.jiguang.ap.b.c(context) != 1) {
                        if (((c) a2.first).g != cn.jiguang.d.a.d(context)) {
                            d.b("ShareProcessManager", "this msg uid is :" + ((c) a2.first).g + ",is not this app msg");
                            str = "1";
                            hashMap.put("asmrc", str);
                        } else {
                            hashMap.put("asmrc", "0");
                            cn.jiguang.at.b.a();
                            cn.jiguang.at.b.a(context, (c) a2.first, (ByteBuffer) a2.second);
                        }
                    }
                    d.b("ShareProcessManager", "share process is closed");
                    str = "3";
                    hashMap.put("asmrc", str);
                }
                a(context, optString4, "asmr", hashMap);
            }
        } catch (Throwable th) {
            d.b("ShareProcessManager", "doMsg error:" + th.getMessage());
        }
    }

    public final void b(Context context) {
        if (this.k) {
            this.k = false;
            if (h.a().d()) {
                d.b("ShareProcessManager", "attach mine while app in foreground from background");
                cn.jiguang.ap.b.a(context, JConstants.SDK_TYPE, 30, 0, n.b(), 0L, cn.jiguang.av.b.a(cn.jiguang.d.a.d(context), this.f4058e, new long[]{cn.jiguang.d.a.d(context)}));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1 A[Catch: all -> 0x026e, TRY_ENTER, TryCatch #1 {all -> 0x026e, blocks: (B:3:0x0005, B:5:0x000d, B:7:0x0026, B:14:0x0088, B:17:0x0096, B:21:0x00a1, B:22:0x00c1, B:24:0x00c7, B:26:0x00d3, B:28:0x00db, B:30:0x00eb, B:31:0x00ef, B:34:0x00f8, B:36:0x0107, B:38:0x010d, B:40:0x015e, B:42:0x016e, B:49:0x01b9, B:46:0x0182, B:50:0x01bd, B:55:0x01f4, B:56:0x01f9, B:65:0x0230, B:59:0x0205, B:63:0x0228, B:60:0x0212, B:62:0x021a, B:64:0x022b, B:13:0x0052), top: B:77:0x0005 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        long j2;
        boolean z2;
        Set<b> c2;
        long j3;
        long j4;
        String str;
        long j5;
        long j6;
        String str2;
        String str3;
        int i;
        long j7;
        String str4;
        try {
            Map b2 = cn.jiguang.ap.b.b(this.f4055a);
            if (b2 != null) {
                this.f4058e = (String) b2.get("uuid");
                j2 = ((Long) b2.get("ct")).longValue();
            } else {
                j2 = -1;
            }
            d.b("ShareProcessManager", "sp uuid:" + this.f4058e + ",createTime:" + j2);
        } catch (Throwable th) {
            try {
                d.h("ShareProcessManager", "#unception, execute ScanAppAction failed:" + th);
                z = false;
            } catch (Throwable th2) {
                this.i = false;
                d(this.f4055a);
                throw th2;
            }
        }
        if (!TextUtils.isEmpty(this.f4058e) && j2 >= 0) {
            z2 = false;
            c2 = c(this.f4055a);
            if (c2.isEmpty()) {
                int h2 = cn.jiguang.d.a.h(this.f4055a);
                d.b("ShareProcessManager", "mine idc:" + h2);
                ArrayList arrayList = new ArrayList();
                for (b bVar : c2) {
                    i = bVar.f4060b;
                    if (h2 == i) {
                        j7 = bVar.f4062d;
                        if (j7 > 0) {
                            String packageName = this.f4055a.getPackageName();
                            str4 = bVar.f4063e;
                            if (!packageName.equals(str4)) {
                                arrayList.add(bVar);
                            }
                        }
                    }
                }
                if (arrayList.size() != 0) {
                    this.f4057d = new long[arrayList.size()];
                    String str5 = "";
                    String str6 = str5;
                    long j8 = -1;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        d.b("ShareProcessManager", "found same idc app :" + arrayList.get(i2));
                        long[] jArr = this.f4057d;
                        j3 = ((b) arrayList.get(i2)).f4062d;
                        jArr[i2] = j3;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str5);
                        j4 = ((b) arrayList.get(i2)).f4062d;
                        sb.append(j4);
                        sb.append(",");
                        str5 = sb.toString();
                        str = ((b) arrayList.get(i2)).f4061c;
                        if (!TextUtils.isEmpty(str)) {
                            j5 = ((b) arrayList.get(i2)).h;
                            if (j5 > 0) {
                                j6 = ((b) arrayList.get(i2)).h;
                                if (j6 < j8 || j8 == -1) {
                                    StringBuilder sb2 = new StringBuilder("found older uuid from:");
                                    str2 = ((b) arrayList.get(i2)).f4063e;
                                    sb2.append(str2);
                                    d.b("ShareProcessManager", sb2.toString());
                                    str6 = ((b) arrayList.get(i2)).f4061c;
                                    j8 = ((b) arrayList.get(i2)).h;
                                }
                            }
                        }
                    }
                    d.b("ShareProcessManager", "oldestUUID:" + str6 + ",oldestTime:" + j8 + ",localTime:" + j2 + ",localUUID:" + this.f4058e);
                    if (TextUtils.isEmpty(str6)) {
                        d.b("ShareProcessManager", "not found other app(contains uuid) ");
                    } else if (z2) {
                        if (j8 > j2) {
                            d.b("ShareProcessManager", "jump time");
                        }
                        this.f4058e = str6;
                        cn.jiguang.ap.b.a(this.f4055a, str6, j8);
                    } else {
                        if (j2 != j8) {
                            d.b("ShareProcessManager", "the time exception");
                            cn.jiguang.ap.b.a(this.f4055a, this.f4058e, j2);
                        } else if (!this.f4058e.equals(str6)) {
                            d.b("ShareProcessManager", "same time but uuid is not same");
                            cn.jiguang.ap.b.a(this.f4055a, "", System.currentTimeMillis());
                        }
                        this.f4058e = str6;
                    }
                    d.b("ShareProcessManager", "use uuid:" + this.f4058e + ",uids:" + str5);
                    cn.jiguang.ap.b.a(this.f4055a, JConstants.SDK_TYPE, 30, 0, n.b(), 0L, cn.jiguang.av.b.a(cn.jiguang.d.a.d(this.f4055a), this.f4058e, this.f4057d));
                    z = false;
                    this.i = z;
                    d(this.f4055a);
                }
                str3 = "not found app by same idc";
            } else {
                str3 = "scan app list is empty";
            }
            d.b("ShareProcessManager", str3);
            this.i = false;
            d(this.f4055a);
        }
        d.b("ShareProcessManager", "not found uuid,create uuid");
        this.f4058e = UUID.randomUUID().toString();
        j2 = System.currentTimeMillis();
        d.b("ShareProcessManager", "save uuid and createtime to sp,uuid:" + this.f4058e + ",createtime:" + j2);
        cn.jiguang.ap.b.a(this.f4055a, this.f4058e, j2);
        z2 = true;
        c2 = c(this.f4055a);
        if (c2.isEmpty()) {
        }
        d.b("ShareProcessManager", str3);
        this.i = false;
        d(this.f4055a);
    }
}

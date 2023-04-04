package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.umeng.analytics.pro.ak;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ZIDManager {

    /* renamed from: c  reason: collision with root package name */
    public static ZIDManager f6970c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6971a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6972b = false;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IZIDCompletionCallback f6974b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f6973a = context;
            this.f6974b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = ZIDManager.a(ZIDManager.this, this.f6973a);
            if (TextUtils.isEmpty(a2)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f6974b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(NativeContentAd.ASSET_BODY, "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f6974b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6976a;

        public b(Context context) {
            this.f6976a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00b0 A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #0 {all -> 0x0108, blocks: (B:7:0x001a, B:9:0x0020, B:11:0x0027, B:14:0x0037, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x005d, B:25:0x0063, B:27:0x006d, B:29:0x0073, B:32:0x008d, B:34:0x0093, B:36:0x0099, B:39:0x00a0, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00b5, B:48:0x00c3, B:50:0x00d8, B:52:0x00eb, B:53:0x00ee, B:55:0x00f8, B:56:0x00fb, B:58:0x0105), top: B:62:0x001a }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00c3 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:7:0x001a, B:9:0x0020, B:11:0x0027, B:14:0x0037, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x005d, B:25:0x0063, B:27:0x006d, B:29:0x0073, B:32:0x008d, B:34:0x0093, B:36:0x0099, B:39:0x00a0, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00b5, B:48:0x00c3, B:50:0x00d8, B:52:0x00eb, B:53:0x00ee, B:55:0x00f8, B:56:0x00fb, B:58:0x0105), top: B:62:0x001a }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            SharedPreferences a2;
            String string;
            String str;
            String str2;
            String a3;
            SharedPreferences a4;
            SharedPreferences a5;
            SharedPreferences a6;
            SharedPreferences a7;
            ZIDManager zIDManager = ZIDManager.this;
            Context context = this.f6976a;
            if (zIDManager.f6972b) {
                return;
            }
            zIDManager.f6972b = true;
            JSONObject jSONObject = new JSONObject();
            String str3 = "";
            if (context != null) {
                try {
                    a2 = com.umeng.umzid.a.a(context);
                } catch (Throwable unused) {
                }
                if (a2 != null) {
                    string = a2.getString("zdata", null);
                    String id = Spy.getID();
                    jSONObject.put("zdata", id);
                    jSONObject.put("old_zdata", string);
                    if (context != null || (a7 = com.umeng.umzid.a.a(context)) == null) {
                        str = "";
                    } else {
                        str = a7.getString("oaid", "");
                        if (com.umeng.umzid.c.c(str)) {
                            str = com.umeng.umzid.c.a(str);
                        }
                    }
                    String c2 = com.umeng.umzid.c.c(context);
                    jSONObject.put("old_oaid", str);
                    jSONObject.put("oaid", c2);
                    if (context != null || (a6 = com.umeng.umzid.a.a(context)) == null) {
                        str2 = "";
                    } else {
                        str2 = a6.getString("mac", "");
                        if (com.umeng.umzid.c.c(str2)) {
                            str2 = com.umeng.umzid.c.a(str2);
                        }
                    }
                    String b2 = com.umeng.umzid.c.b(context);
                    jSONObject.put("mac", b2);
                    jSONObject.put("old_mac", str2);
                    zIDManager.a(context, jSONObject);
                    jSONObject.put("aaid", com.umeng.umzid.c.a(context));
                    jSONObject.put("uabc", (context != null || (a5 = com.umeng.umzid.a.a(context)) == null) ? "" : a5.getString("uabc", ""));
                    if (context != null && (a4 = com.umeng.umzid.a.a(context)) != null) {
                        str3 = a4.getString("resetToken", "");
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("resetToken", str3);
                    }
                    a3 = com.umeng.umzid.a.a("https://aaid.umeng.com/api/updateZdata", jSONObject.toString());
                    if (!TextUtils.isEmpty(a3)) {
                        JSONObject jSONObject2 = new JSONObject(a3);
                        if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                            com.umeng.umzid.c.f(context, id);
                            com.umeng.umzid.c.a(context, b2);
                            com.umeng.umzid.c.b(context, c2);
                            String optString = jSONObject2.optString("aaid");
                            if (!TextUtils.isEmpty(optString)) {
                                com.umeng.umzid.c.e(context, optString);
                            }
                            String string2 = jSONObject2.getString("uabc");
                            if (!TextUtils.isEmpty(string2)) {
                                com.umeng.umzid.c.d(context, string2);
                            }
                            String string3 = jSONObject2.getString("resetToken");
                            if (!TextUtils.isEmpty(string3)) {
                                com.umeng.umzid.c.c(context, string3);
                            }
                        }
                    }
                    zIDManager.f6972b = false;
                }
            }
            string = "";
            String id2 = Spy.getID();
            jSONObject.put("zdata", id2);
            jSONObject.put("old_zdata", string);
            if (context != null) {
            }
            str = "";
            String c22 = com.umeng.umzid.c.c(context);
            jSONObject.put("old_oaid", str);
            jSONObject.put("oaid", c22);
            if (context != null) {
            }
            str2 = "";
            String b22 = com.umeng.umzid.c.b(context);
            jSONObject.put("mac", b22);
            jSONObject.put("old_mac", str2);
            zIDManager.a(context, jSONObject);
            jSONObject.put("aaid", com.umeng.umzid.c.a(context));
            jSONObject.put("uabc", (context != null || (a5 = com.umeng.umzid.a.a(context)) == null) ? "" : a5.getString("uabc", ""));
            if (context != null) {
                str3 = a4.getString("resetToken", "");
            }
            if (!TextUtils.isEmpty(str3)) {
            }
            a3 = com.umeng.umzid.a.a("https://aaid.umeng.com/api/updateZdata", jSONObject.toString());
            if (!TextUtils.isEmpty(a3)) {
            }
            zIDManager.f6972b = false;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6978a;

        public c(Context context) {
            this.f6978a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f6978a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String str = null;
        if (!zIDManager.f6971a) {
            zIDManager.f6971a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put("zdata", id);
                String b2 = com.umeng.umzid.c.b(context);
                jSONObject.put("mac", b2);
                String c2 = com.umeng.umzid.c.c(context);
                jSONObject.put("oaid", c2);
                zIDManager.a(context, jSONObject);
                String a2 = com.umeng.umzid.a.a("https://aaid.umeng.com/api/postZdata", jSONObject.toString());
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        com.umeng.umzid.c.f(context, id);
                        com.umeng.umzid.c.a(context, b2);
                        com.umeng.umzid.c.b(context, c2);
                        str = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(str)) {
                            com.umeng.umzid.c.e(context, str);
                        }
                        String string = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string)) {
                            com.umeng.umzid.c.d(context, string);
                        }
                        String string2 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string2)) {
                            com.umeng.umzid.c.c(context, string2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.f6971a = false;
        }
        return str;
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            if (f6970c == null) {
                f6970c = new ZIDManager();
            }
            zIDManager = f6970c;
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.4.1";
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String a2 = com.umeng.umzid.c.a(applicationContext);
        if (TextUtils.isEmpty(a2)) {
            com.umeng.umzid.b.a(new c(applicationContext));
            return "";
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006d A[Catch: all -> 0x009c, TryCatch #1 {, blocks: (B:5:0x0005, B:8:0x000e, B:11:0x0016, B:14:0x001f, B:17:0x0027, B:19:0x002d, B:21:0x0033, B:23:0x0039, B:24:0x0042, B:26:0x0048, B:29:0x004f, B:31:0x0059, B:33:0x0065, B:35:0x006d, B:36:0x0075, B:38:0x007b, B:43:0x008d, B:32:0x005d), top: B:51:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:8:0x000e, B:11:0x0016, B:14:0x001f, B:17:0x0027, B:19:0x002d, B:21:0x0033, B:23:0x0039, B:24:0x0042, B:26:0x0048, B:29:0x004f, B:31:0x0059, B:33:0x0065, B:35:0x006d, B:36:0x0075, B:38:0x007b, B:43:0x008d, B:32:0x005d), top: B:51:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences a2;
        SharedPreferences a3;
        SharedPreferences.Editor edit;
        if (context == null) {
            if (iZIDCompletionCallback != null) {
                iZIDCompletionCallback.onFailure(NativeContentAd.ASSET_HEADLINE, "传入参数Context为null");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (iZIDCompletionCallback != null) {
                iZIDCompletionCallback.onFailure(NativeContentAd.ASSET_CALL_TO_ACTION, "传入参数appkey为空");
            }
        } else {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null && str != null && !TextUtils.isEmpty(str) && (a3 = com.umeng.umzid.a.a(applicationContext)) != null && (edit = a3.edit()) != null) {
                edit.putString("appkey", str).commit();
            }
            String a4 = com.umeng.umzid.c.a(applicationContext);
            if (a4 != null && !TextUtils.isEmpty(a4)) {
                com.umeng.umzid.b.a(new b(applicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(a4);
                }
                a2 = com.umeng.umzid.a.a(context);
                if (TextUtils.isEmpty(a2 != null ? a2.getString("uuid", "") : "")) {
                    String str2 = "";
                    SharedPreferences a5 = com.umeng.umzid.a.a(context);
                    try {
                        str2 = UUID.randomUUID().toString();
                    } catch (Throwable unused) {
                    }
                    if (a5 != null) {
                        a5.edit().putString("uuid", str2).commit();
                    }
                }
            }
            com.umeng.umzid.b.a(new a(applicationContext, iZIDCompletionCallback));
            a2 = com.umeng.umzid.a.a(context);
            if (TextUtils.isEmpty(a2 != null ? a2.getString("uuid", "") : "")) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(43:1|(2:2|3)|(2:8|(39:12|13|(1:123)(1:17)|(1:21)|22|(5:111|112|(2:119|120)|114|(33:116|25|26|27|(2:32|(28:36|37|38|39|40|41|(3:92|93|(5:95|96|(2:99|97)|100|101))|43|(1:45)(1:91)|46|(1:48)(1:90)|49|50|51|52|53|54|55|56|57|58|(1:62)|63|64|65|(2:70|(2:74|75))|77|78))|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(2:60|62)|63|64|65|(4:67|68|70|(3:72|74|75))|77|78))|24|25|26|27|(4:29|30|32|(29:34|36|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78))|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78))|125|13|(1:15)|123|(2:19|21)|22|(0)|24|25|26|27|(0)|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78) */
    /* JADX WARN: Can't wrap try/catch for region: R(44:1|2|3|(2:8|(39:12|13|(1:123)(1:17)|(1:21)|22|(5:111|112|(2:119|120)|114|(33:116|25|26|27|(2:32|(28:36|37|38|39|40|41|(3:92|93|(5:95|96|(2:99|97)|100|101))|43|(1:45)(1:91)|46|(1:48)(1:90)|49|50|51|52|53|54|55|56|57|58|(1:62)|63|64|65|(2:70|(2:74|75))|77|78))|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(2:60|62)|63|64|65|(4:67|68|70|(3:72|74|75))|77|78))|24|25|26|27|(4:29|30|32|(29:34|36|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78))|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78))|125|13|(1:15)|123|(2:19|21)|22|(0)|24|25|26|27|(0)|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x013f, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0187, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0188, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01aa, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ab, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c3, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c4, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject a(Context context, JSONObject jSONObject) {
        Object obj;
        long j;
        String externalStorageState;
        Locale locale;
        int rawOffset;
        Object obj2;
        String str;
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        SharedPreferences a2;
        Class<?> cls2;
        Method declaredMethod2;
        Object invoke2;
        Class<?> cls3;
        Method declaredMethod3;
        Object obj3 = "";
        jSONObject.putOpt("zdata_ver", Spy.getVersion());
        try {
            cls3 = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        } catch (Throwable unused) {
        }
        if (cls3 != null && (declaredMethod3 = cls3.getDeclaredMethod("getAndroidId", Context.class)) != null) {
            declaredMethod3.setAccessible(true);
            Object invoke3 = declaredMethod3.invoke(cls3, context);
            if (invoke3 != null && (invoke3 instanceof String)) {
                obj = (String) invoke3;
                jSONObject.putOpt("android_id", obj);
                j = 0;
                externalStorageState = Environment.getExternalStorageState();
                if ((!"mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && Build.VERSION.SDK_INT >= 9) {
                    j = Environment.getExternalStorageDirectory().getFreeSpace();
                }
                jSONObject.putOpt("storage", Long.valueOf(j));
                jSONObject.putOpt(ak.y, Build.VERSION.RELEASE);
                Object obj4 = null;
                if (context != null) {
                    try {
                        Configuration configuration = new Configuration();
                        configuration.setToDefaults();
                        Settings.System.getConfiguration(context.getContentResolver(), configuration);
                        locale = configuration.locale;
                    } catch (Throwable unused2) {
                        locale = null;
                    }
                    if (locale == null) {
                        try {
                            locale = Locale.getDefault();
                        } catch (Throwable unused3) {
                        }
                    }
                    Calendar calendar = Calendar.getInstance(locale);
                    if (calendar != null) {
                        rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
                        jSONObject.putOpt(ak.M, Integer.valueOf(rawOffset));
                        jSONObject.putOpt("model", Build.MODEL);
                        cls2 = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
                        if (cls2 != null && (declaredMethod2 = cls2.getDeclaredMethod("getImeiNew", Context.class)) != null) {
                            declaredMethod2.setAccessible(true);
                            invoke2 = declaredMethod2.invoke(cls2, context);
                            if (invoke2 != null && (invoke2 instanceof String)) {
                                obj2 = (String) invoke2;
                                jSONObject.putOpt("imei", obj2);
                                Method declaredMethod4 = Build.class.getDeclaredMethod("getString", String.class);
                                declaredMethod4.setAccessible(true);
                                str = declaredMethod4.invoke(null, "net.hostname").toString();
                                if (str != null) {
                                    try {
                                        if (!str.equalsIgnoreCase("")) {
                                            try {
                                                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                                                messageDigest.update(str.getBytes());
                                                byte[] digest = messageDigest.digest();
                                                StringBuffer stringBuffer = new StringBuffer();
                                                for (byte b2 : digest) {
                                                    stringBuffer.append(Integer.toHexString(b2 & 255));
                                                }
                                                str = stringBuffer.toString();
                                            } catch (Throwable unused4) {
                                                str = "";
                                            }
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                                jSONObject.putOpt("hostname", str);
                                jSONObject.putOpt("sdk_version", "1.4.1");
                                jSONObject.putOpt(ak.o, context == null ? null : context.getPackageName());
                                jSONObject.putOpt(ak.u, "Android");
                                SharedPreferences a3 = com.umeng.umzid.a.a(context);
                                jSONObject.putOpt("uuid", a3 != null ? a3.getString("uuid", "") : "");
                                jSONObject.putOpt("source_id", "umeng");
                                Object obj5 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                                jSONObject.putOpt("app_version", obj5);
                                Object obj6 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                                jSONObject.putOpt("app_name", obj6);
                                Object obj7 = context.getResources().getConfiguration().locale.getCountry();
                                jSONObject.putOpt(ak.O, obj7);
                                if (context != null && (a2 = com.umeng.umzid.a.a(context)) != null) {
                                    obj4 = a2.getString("appkey", null);
                                }
                                jSONObject.putOpt("appkey", obj4);
                                cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
                                if (cls != null && (declaredMethod = cls.getDeclaredMethod("getIdfa", Context.class)) != null) {
                                    declaredMethod.setAccessible(true);
                                    invoke = declaredMethod.invoke(cls, context);
                                    if (invoke != null && (invoke instanceof String)) {
                                        obj3 = (String) invoke;
                                    }
                                }
                                jSONObject.putOpt("gaid", obj3);
                                return jSONObject;
                            }
                        }
                        obj2 = "";
                        jSONObject.putOpt("imei", obj2);
                        Method declaredMethod42 = Build.class.getDeclaredMethod("getString", String.class);
                        declaredMethod42.setAccessible(true);
                        str = declaredMethod42.invoke(null, "net.hostname").toString();
                        if (str != null) {
                        }
                        jSONObject.putOpt("hostname", str);
                        jSONObject.putOpt("sdk_version", "1.4.1");
                        jSONObject.putOpt(ak.o, context == null ? null : context.getPackageName());
                        jSONObject.putOpt(ak.u, "Android");
                        SharedPreferences a32 = com.umeng.umzid.a.a(context);
                        jSONObject.putOpt("uuid", a32 != null ? a32.getString("uuid", "") : "");
                        jSONObject.putOpt("source_id", "umeng");
                        Object obj52 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        jSONObject.putOpt("app_version", obj52);
                        Object obj62 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                        jSONObject.putOpt("app_name", obj62);
                        Object obj72 = context.getResources().getConfiguration().locale.getCountry();
                        jSONObject.putOpt(ak.O, obj72);
                        if (context != null) {
                            obj4 = a2.getString("appkey", null);
                        }
                        jSONObject.putOpt("appkey", obj4);
                        cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
                        if (cls != null) {
                            declaredMethod.setAccessible(true);
                            invoke = declaredMethod.invoke(cls, context);
                            if (invoke != null) {
                                obj3 = (String) invoke;
                            }
                        }
                        jSONObject.putOpt("gaid", obj3);
                        return jSONObject;
                    }
                }
                rawOffset = 8;
                jSONObject.putOpt(ak.M, Integer.valueOf(rawOffset));
                jSONObject.putOpt("model", Build.MODEL);
                cls2 = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
                if (cls2 != null) {
                    declaredMethod2.setAccessible(true);
                    invoke2 = declaredMethod2.invoke(cls2, context);
                    if (invoke2 != null) {
                        obj2 = (String) invoke2;
                        jSONObject.putOpt("imei", obj2);
                        Method declaredMethod422 = Build.class.getDeclaredMethod("getString", String.class);
                        declaredMethod422.setAccessible(true);
                        str = declaredMethod422.invoke(null, "net.hostname").toString();
                        if (str != null) {
                        }
                        jSONObject.putOpt("hostname", str);
                        jSONObject.putOpt("sdk_version", "1.4.1");
                        jSONObject.putOpt(ak.o, context == null ? null : context.getPackageName());
                        jSONObject.putOpt(ak.u, "Android");
                        SharedPreferences a322 = com.umeng.umzid.a.a(context);
                        jSONObject.putOpt("uuid", a322 != null ? a322.getString("uuid", "") : "");
                        jSONObject.putOpt("source_id", "umeng");
                        Object obj522 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        jSONObject.putOpt("app_version", obj522);
                        Object obj622 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                        jSONObject.putOpt("app_name", obj622);
                        Object obj722 = context.getResources().getConfiguration().locale.getCountry();
                        jSONObject.putOpt(ak.O, obj722);
                        if (context != null) {
                        }
                        jSONObject.putOpt("appkey", obj4);
                        cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
                        if (cls != null) {
                        }
                        jSONObject.putOpt("gaid", obj3);
                        return jSONObject;
                    }
                }
                obj2 = "";
                jSONObject.putOpt("imei", obj2);
                Method declaredMethod4222 = Build.class.getDeclaredMethod("getString", String.class);
                declaredMethod4222.setAccessible(true);
                str = declaredMethod4222.invoke(null, "net.hostname").toString();
                if (str != null) {
                }
                jSONObject.putOpt("hostname", str);
                jSONObject.putOpt("sdk_version", "1.4.1");
                jSONObject.putOpt(ak.o, context == null ? null : context.getPackageName());
                jSONObject.putOpt(ak.u, "Android");
                SharedPreferences a3222 = com.umeng.umzid.a.a(context);
                jSONObject.putOpt("uuid", a3222 != null ? a3222.getString("uuid", "") : "");
                jSONObject.putOpt("source_id", "umeng");
                Object obj5222 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                jSONObject.putOpt("app_version", obj5222);
                Object obj6222 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                jSONObject.putOpt("app_name", obj6222);
                Object obj7222 = context.getResources().getConfiguration().locale.getCountry();
                jSONObject.putOpt(ak.O, obj7222);
                if (context != null) {
                }
                jSONObject.putOpt("appkey", obj4);
                cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
                if (cls != null) {
                }
                jSONObject.putOpt("gaid", obj3);
                return jSONObject;
            }
        }
        obj = "";
        jSONObject.putOpt("android_id", obj);
        j = 0;
        externalStorageState = Environment.getExternalStorageState();
        if (!"mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
            j = Environment.getExternalStorageDirectory().getFreeSpace();
        }
        jSONObject.putOpt("storage", Long.valueOf(j));
        jSONObject.putOpt(ak.y, Build.VERSION.RELEASE);
        Object obj42 = null;
        if (context != null) {
        }
        rawOffset = 8;
        jSONObject.putOpt(ak.M, Integer.valueOf(rawOffset));
        jSONObject.putOpt("model", Build.MODEL);
        cls2 = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        if (cls2 != null) {
        }
        obj2 = "";
        jSONObject.putOpt("imei", obj2);
        Method declaredMethod42222 = Build.class.getDeclaredMethod("getString", String.class);
        declaredMethod42222.setAccessible(true);
        str = declaredMethod42222.invoke(null, "net.hostname").toString();
        if (str != null) {
        }
        jSONObject.putOpt("hostname", str);
        jSONObject.putOpt("sdk_version", "1.4.1");
        jSONObject.putOpt(ak.o, context == null ? null : context.getPackageName());
        jSONObject.putOpt(ak.u, "Android");
        SharedPreferences a32222 = com.umeng.umzid.a.a(context);
        jSONObject.putOpt("uuid", a32222 != null ? a32222.getString("uuid", "") : "");
        jSONObject.putOpt("source_id", "umeng");
        Object obj52222 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        jSONObject.putOpt("app_version", obj52222);
        Object obj62222 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        jSONObject.putOpt("app_name", obj62222);
        Object obj72222 = context.getResources().getConfiguration().locale.getCountry();
        jSONObject.putOpt(ak.O, obj72222);
        if (context != null) {
        }
        jSONObject.putOpt("appkey", obj42);
        cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        if (cls != null) {
        }
        jSONObject.putOpt("gaid", obj3);
        return jSONObject;
    }
}

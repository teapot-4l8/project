package cn.jiguang.f;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.PushReceiver;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f4064a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f4065b = "";

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i;
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            cn.jiguang.an.d.f("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            int i2 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i2);
            componentInfoArr = i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        } catch (Throwable th) {
            cn.jiguang.an.d.g("AndroidUtil", "hasComponent error:" + th);
        }
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static ProviderInfo a(Context context, String str, String str2) {
        ProviderInfo[] providerInfoArr;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 8);
                if (packageInfo.providers != null && packageInfo.providers.length != 0) {
                    for (ProviderInfo providerInfo : packageInfo.providers) {
                        if (str2.equals(providerInfo.authority)) {
                            return providerInfo;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        cn.jiguang.f.a.f4064a = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        if (TextUtils.isEmpty(f4064a)) {
            try {
                Context appContext = JConstants.getAppContext(context);
                ActivityManager activityManager = appContext != null ? (ActivityManager) appContext.getSystemService("activity") : null;
                if (activityManager != null) {
                    int myPid = Process.myPid();
                    Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.an.d.g("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
            }
            return f4064a;
        }
        return f4064a;
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static List<String> a(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (resolveInfo.serviceInfo != null) {
                    String str2 = resolveInfo.serviceInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        boolean z = true;
                        if (!TextUtils.isEmpty(str) && packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) != 0) {
                            z = false;
                        }
                        if (z) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static List<String> a(Context context, List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!c(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static void a(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
        } catch (Throwable unused) {
            try {
                List<String> b2 = b(context, intent, (String) null);
                if (b2.isEmpty()) {
                    cn.jiguang.an.d.g("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                    return;
                }
                for (String str : b2) {
                    try {
                        Intent intent2 = (Intent) intent.clone();
                        intent2.setComponent(new ComponentName(context.getPackageName(), str));
                        context.sendBroadcast(intent2);
                    } catch (Exception e2) {
                        cn.jiguang.an.d.g("AndroidUtil", "sendBroadcast failed again:" + e2.getMessage() + ", action:" + intent.getAction());
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.an.d.g("AndroidUtil", "tryAgainSendBrocast failed:" + th.getMessage());
            }
        }
    }

    public static void a(Context context, String str, int i) {
        int i2;
        Notification notification;
        if (!m(context)) {
            cn.jiguang.an.d.b("AndroidUtil", "not debuggable");
        } else if (!a(context, PushReceiver.class)) {
            new Handler(Looper.getMainLooper()).post(new b(context, str));
        } else {
            cn.jiguang.an.d.b("AndroidUtil", "action:showPermanentNotification");
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction("noti_open_proxy");
            intent.addCategory(context.getPackageName());
            intent.putExtra("debug_notification", true);
            intent.putExtra("toastText", str);
            intent.putExtra(com.umeng.analytics.pro.d.y, -1);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            try {
                i2 = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 0).icon;
            } catch (Throwable th) {
                cn.jiguang.an.d.c("AndroidUtil", "failed to get application info and icon.", th);
                i2 = 17301586;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 11) {
                Notification.Builder when = new Notification.Builder(context.getApplicationContext()).setContentTitle("Jiguang提示：包名和AppKey不匹配").setContentText("请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段").setContentIntent(broadcast).setSmallIcon(i2).setTicker(str).setWhen(currentTimeMillis);
                if (Build.VERSION.SDK_INT >= 26) {
                    when.setChannelId("JPush_Notification");
                }
                notification = when.getNotification();
                notification.flags = 34;
            } else {
                Notification notification2 = new Notification(i2, str, currentTimeMillis);
                notification2.flags = 34;
                try {
                    h.a(notification2, "setLatestEventInfo", new Object[]{context, "Jiguang提示：包名和AppKey不匹配", "请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段", broadcast}, new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class});
                } catch (Exception unused) {
                }
                notification = notification2;
            }
            notificationManager.notify(str.hashCode(), notification);
        }
    }

    public static boolean a() {
        boolean z;
        try {
            z = Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            cn.jiguang.an.d.f("AndroidUtil", "isSdcardExist exception: " + th);
            z = false;
        }
        if (!z) {
            cn.jiguang.an.d.b("AndroidUtil", "SDCard is not mounted");
        }
        return z;
    }

    public static boolean a(Context context, Class<?> cls) {
        boolean z;
        boolean z2 = false;
        try {
            z = !context.getPackageManager().queryBroadcastReceivers(new Intent(context, cls), 0).isEmpty();
        } catch (Throwable unused) {
        }
        if (z) {
            return z;
        }
        try {
            if (a(context, context.getPackageName(), cls) != null) {
                z2 = true;
            }
        } catch (Throwable unused2) {
            z2 = z;
        }
        return z2;
    }

    public static ProviderInfo b(Context context, String str, Class<? extends ContentProvider> cls) {
        try {
            return context.getPackageManager().getProviderInfo(new ComponentName(str, cls.getName()), 65536);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        String str;
        try {
            str = Environment.getExternalStorageDirectory().getPath();
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
        } catch (Exception unused) {
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + "/data/";
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(f4065b)) {
            String packageName = context.getPackageName();
            f4065b = packageName;
            return packageName;
        }
        return f4065b;
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context, String str, String str2) {
        try {
            return (String) h.a(context.getClassLoader().loadClass("android.os.SystemProperties"), "get", new Object[]{str, str2}, new Class[]{String.class, String.class});
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (Exception unused) {
            return "";
        }
    }

    private static List<String> b(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null) {
                    String str2 = resolveInfo.activityInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        boolean z = true;
                        if (!TextUtils.isEmpty(null) && packageManager.checkPermission(null, resolveInfo.activityInfo.packageName) != 0) {
                            z = false;
                        }
                        if (z) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(Context context) {
        String str;
        if (context == null) {
            return -1;
        }
        Intent intent = null;
        try {
            intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), context.getPackageName() + cn.jiguang.a.a.f3639a, null);
        } catch (SecurityException unused) {
            str = "getChargedStatus SecurityException";
            cn.jiguang.an.d.f("AndroidUtil", str);
            if (intent == null) {
            }
        } catch (Exception e2) {
            str = "getChargedStatus unkown exception:" + e2.getMessage();
            cn.jiguang.an.d.f("AndroidUtil", str);
            if (intent == null) {
            }
        }
        if (intent == null) {
            return -1;
        }
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return intent.getIntExtra("plugged", -1);
        }
        return -1;
    }

    public static String c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Exception e2) {
            cn.jiguang.an.d.f("AndroidUtil", "getPhoneIp:");
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (((android.app.AppOpsManager) r4.getSystemService("appops")).noteProxyOpNoThrow(r5, r4.getPackageName()) == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context, String str) {
        boolean z = false;
        try {
        } catch (Throwable th) {
            cn.jiguang.an.d.f("AndroidUtil", "checkPermission error:" + th.getMessage());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.getApplicationInfo().targetSdkVersion >= 23) {
                if (context.checkSelfPermission(str) == 0) {
                }
                return z;
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (permissionToOp != null) {
            }
        }
        z = true;
        return z;
    }

    public static String d(Context context, String str) {
        String str2 = null;
        try {
        } catch (Exception e2) {
            cn.jiguang.an.d.h("AndroidUtil", e2.getMessage());
        }
        if (JConstants.isAndroidQ(context, false, "do not getImei")) {
            return "";
        }
        if (c(context, "android.permission.READ_PHONE_STATE")) {
            str2 = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        }
        return i.h(str2) ? str2 : str;
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (c(context, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static String e(Context context, String str) {
        try {
            return JConstants.isAndroidQ(context, false, "do not getImsi") ? "" : c(context, "android.permission.READ_PHONE_STATE") ? ((TelephonyManager) context.getSystemService("phone")).getSubscriberId() : str;
        } catch (Throwable th) {
            cn.jiguang.an.d.f("AndroidUtil", "getImsi failed:" + th.getMessage());
            return str;
        }
    }

    public static boolean e(Context context) {
        String str = context.getApplicationInfo().sourceDir;
        if (i.a(str)) {
            cn.jiguang.an.d.h("AndroidUtil", "Unexpected: cannot get pk installed path");
            return false;
        }
        cn.jiguang.an.d.b("AndroidUtil", "Current pk installed path: " + str);
        if (str.startsWith("/system/app/")) {
            return true;
        }
        if (str.startsWith("/data/app/")) {
            return false;
        }
        cn.jiguang.an.d.d("AndroidUtil", "NOTE: the pk does not installed in system/data. ");
        return false;
    }

    public static String f(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "0*0";
        }
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        return i + "*" + i2;
    }

    public static String f(Context context, String str) {
        String str2;
        if (cn.jiguang.d.a.i(context)) {
            String n = n(context);
            if (!i.i(n)) {
                n = o(context);
            }
            if (i.i(n)) {
                str = n;
            }
            str2 = "getWifiMac:" + str;
        } else {
            str2 = "[getWifiMac] lbs disabled";
        }
        cn.jiguang.an.d.b("AndroidUtil", str2);
        return str;
    }

    public static String g(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = "";
        }
        return i.h(str) ? str : "";
    }

    public static boolean g(Context context, String str) {
        if (i.a(str)) {
            return false;
        }
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static String h(Context context) {
        try {
            String f = f(context, "");
            if (f != null && !f.equals("")) {
                cn.jiguang.an.d.d("AndroidUtil", "MAC addr info---- " + f);
                return i.d(f.toLowerCase() + Build.MODEL);
            }
            return null;
        } catch (Exception e2) {
            cn.jiguang.an.d.b("AndroidUtil", "", e2);
            return null;
        }
    }

    public static boolean h(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            context.getPackageManager().getPermissionInfo(str, 128);
            return true;
        } catch (Throwable th) {
            cn.jiguang.an.d.g("AndroidUtil", "hasPermissionDefined error:" + th.getMessage());
            return false;
        }
    }

    public static boolean i(Context context) {
        String b2 = b(context, "ro.product.brand", "");
        cn.jiguang.an.d.b("AndroidUtil", "brand = " + b2);
        String b3 = b(context, "ro.miui.ui.version.name", "");
        if (TextUtils.isEmpty(b2) || !"Xiaomi".equals(b2) || TextUtils.isEmpty(b3)) {
            return true;
        }
        String b4 = b(context, "ro.build.version.incremental", "");
        if (TextUtils.isEmpty(b4) || !b4.startsWith("V7.1")) {
            return true;
        }
        cn.jiguang.an.d.f("AndroidUtil", "7.1 will not get wifi list");
        return false;
    }

    public static String j(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "Unknown";
            }
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (typeName == null) {
                return "Unknown";
            }
            if (i.a(subtypeName)) {
                return typeName;
            }
            return typeName + "," + subtypeName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "Unknown";
        }
    }

    public static String k(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null || !c(context, "android.permission.ACCESS_WIFI_STATE")) {
                return "";
            }
            String bssid = wifiManager.getConnectionInfo().getBSSID();
            if (bssid != null) {
                try {
                    if (bssid.startsWith("02:00:00:")) {
                        return "";
                    }
                } catch (Throwable unused) {
                }
                return bssid;
            }
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String l(Context context) {
        Object invoke;
        String str = null;
        int i = -1;
        if (context != null) {
            try {
                Object systemService = context.getApplicationContext().getSystemService("country_detector");
                if (systemService != null) {
                    Method declaredMethod = systemService.getClass().getDeclaredMethod("detectCountry", new Class[0]);
                    if (declaredMethod != null && (invoke = declaredMethod.invoke(systemService, new Object[0])) != null) {
                        String str2 = (String) invoke.getClass().getDeclaredMethod("getCountryIso", new Class[0]).invoke(invoke, new Object[0]);
                        try {
                            i = ((Integer) invoke.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(invoke, new Object[0])).intValue();
                            str = str2;
                        } catch (Throwable th) {
                            th = th;
                            str = str2;
                            cn.jiguang.an.d.h("AndroidUtil", "getCountryCode failed, error :" + th);
                            cn.jiguang.an.d.b("AndroidUtil", "get CountCode = " + str + " source = " + i);
                            if (i != 0) {
                            }
                        }
                    }
                } else {
                    cn.jiguang.an.d.b("AndroidUtil", "country_detector is null");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        cn.jiguang.an.d.b("AndroidUtil", "get CountCode = " + str + " source = " + i);
        return (i != 0 || i == 1) ? str : "";
    }

    private static boolean m(Context context) {
        try {
            cn.jiguang.an.d.b("AndroidUtil", "isDebug:" + ((context.getApplicationInfo().flags & 2) != 0));
            X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
            String[] strArr = {"CN=Android Debug", "O=Android", "C=US"};
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            boolean z = false;
            for (Signature signature : signatureArr) {
                try {
                    X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                    z = x509Certificate.getSubjectX500Principal().equals(x500Principal);
                    cn.jiguang.an.d.b("AndroidUtil", "debuggable :" + z);
                    if (z) {
                        break;
                    }
                    String str = null;
                    try {
                        str = x509Certificate.getSubjectX500Principal().getName();
                    } catch (Exception unused) {
                    }
                    cn.jiguang.an.d.b("AndroidUtil", "certName:" + str);
                    if (str != null && str.contains(strArr[0]) && str.contains(strArr[1]) && str.contains(strArr[2])) {
                        return true;
                    }
                } catch (Throwable unused2) {
                }
            }
            return z;
        } catch (Throwable unused3) {
            return false;
        }
    }

    private static String n(Context context) {
        String str = "";
        if (Build.VERSION.SDK_INT >= 23 || !c(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            str = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            cn.jiguang.an.d.b("AndroidUtil", "mac address from WifiManager:" + str);
            return str;
        } catch (Exception e2) {
            cn.jiguang.an.d.a("AndroidUtil", "get mac from wifiManager failed ", e2);
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        r3 = new java.lang.StringBuilder();
        r5 = r4.length;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r6 >= r5) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
        r3.append(java.lang.String.format(java.util.Locale.ENGLISH, "%02x:", java.lang.Byte.valueOf(r4[r6])));
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (r3.length() <= 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        r3.deleteCharAt(r3.length() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
        r2 = r3.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
        cn.jiguang.an.d.b("AndroidUtil", "mac address from NetworkInterface:" + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
        r3 = r12;
        r12 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0099, code lost:
        cn.jiguang.an.d.f("AndroidUtil", "get mac from NetworkInterface failed:" + r12.getMessage());
        r12 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String o(Context context) {
        String str;
        boolean z;
        boolean z2;
        byte[] hardwareAddress;
        try {
            z2 = c(context, "android.permission.ACCESS_WIFI_STATE") ? ((WifiManager) context.getApplicationContext().getSystemService("wifi")).isWifiEnabled() : false;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (true) {
                    if (!networkInterfaces.hasMoreElements()) {
                        str = "";
                        break;
                    }
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if ("wlan0".equalsIgnoreCase(nextElement.getName()) && (hardwareAddress = nextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                        break;
                    }
                }
            } catch (Exception e2) {
                z = z2;
                e = e2;
                str = "";
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
            z = false;
        }
        if (z2) {
            cn.jiguang.an.d.b("AndroidUtil", "mac address is dropped, which is " + str);
            return "";
        }
        return str;
    }
}

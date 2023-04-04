package cn.jpush.android.u;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.umeng.analytics.pro.bz;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f4487a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f4488b;

    public static int a(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        try {
            String[] split = str.split("[._]");
            String[] split2 = str2.split("[._]");
            if (split.length > split2.length) {
                split2 = (String[]) Arrays.copyOf(split2, split.length);
            } else if (split.length < split2.length) {
                split = (String[]) Arrays.copyOf(split, split2.length);
            }
            for (int i = 0; i < split.length; i++) {
                long parseLong = (TextUtils.isEmpty(split[i]) ? 0L : Long.parseLong(split[i])) - (TextUtils.isEmpty(split2[i]) ? 0L : Long.parseLong(split2[i]));
                if (parseLong > 0) {
                    return 1;
                }
                if (parseLong < 0) {
                    return -1;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return str.compareTo(str2);
        }
    }

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i;
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            int i2 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i2);
            componentInfoArr = i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        } catch (Throwable th) {
            Logger.ww("AndroidUtil", "hasComponent error:" + th.getMessage());
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

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            a(stringBuffer, b2);
        }
        return stringBuffer.toString();
    }

    public static void a(Context context, Intent intent, String str) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(action) || JPushInterface.ACTION_NOTIFICATION_OPENED.equals(action)) {
            List<String> b2 = b(context, intent, str);
            if (b2 == null || b2.isEmpty()) {
                Logger.ww("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str2 : b2) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str2));
                    if (TextUtils.isEmpty(str)) {
                        context.sendBroadcast(intent2);
                    } else {
                        context.sendBroadcast(intent2, str);
                    }
                } catch (Exception e2) {
                    Logger.ww("AndroidUtil", "sendBroadcast failed again:" + e2.getMessage() + ", action:" + intent.getAction());
                }
            }
        }
    }

    public static void a(WebSettings webSettings) {
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            webSettings.setDisplayZoomControls(false);
        }
        webSettings.setCacheMode(2);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
    }

    public static void a(WebView webView) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
        } catch (Throwable th) {
            Logger.e("AndroidUtil", "fixSecure failed, error:" + th);
        }
    }

    private static void a(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b2 & bz.m));
    }

    public static boolean a() {
        boolean z;
        try {
            z = Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "isSdcardExist exception: " + th);
            z = false;
        }
        if (!z) {
            Logger.d("AndroidUtil", "SDCard is not mounted");
        }
        return z;
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, Class<?> cls) {
        try {
            return !context.getPackageManager().queryIntentActivities(new Intent(context, cls), 0).isEmpty();
        } catch (Throwable th) {
            Logger.dd("AndroidUtil", "hasActivityResolves error:" + th.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.getApplicationInfo().targetSdkVersion < 23) {
                    String permissionToOp = AppOpsManager.permissionToOp(str);
                    if (permissionToOp != null) {
                        z = ((AppOpsManager) context.getSystemService("appops")).noteProxyOpNoThrow(permissionToOp, context.getPackageName()) == 0;
                    }
                    return z;
                } else if (context.checkSelfPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "checkPermission error:" + th.getMessage());
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        boolean matches = trim.matches("^[http|https]+://.*");
        if (!matches) {
            Logger.w("AndroidUtil", "Invalid url - " + trim);
        }
        return matches;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(f4487a)) {
            try {
                f4487a = context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0)).toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return f4487a;
        }
        return f4487a;
    }

    public static String b(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static List<String> b(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null) {
                    String str2 = resolveInfo.activityInfo.name;
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

    public static void b(Context context, String str) {
        try {
            Intent f = f(context);
            if (f != null) {
                if (!TextUtils.isEmpty(str)) {
                    f.putExtra("extra", str);
                }
                context.startActivity(f);
            }
        } catch (Throwable th) {
            Logger.dd("AndroidUtil", "startMainActivity error:" + th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        cn.jpush.android.u.a.f4488b = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        if (TextUtils.isEmpty(f4488b)) {
            try {
                Context appContext = JPushConstants.getAppContext(context);
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
                Logger.ww("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
            }
            return f4488b;
        }
        return f4488b;
    }

    public static boolean c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static void d(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String c2 = c(context);
                String packageName = context.getPackageName();
                if (c2 == null || packageName == null || packageName.equals(c2)) {
                    return;
                }
                WebView.setDataDirectorySuffix(c2);
                Logger.d("AndroidUtil", "setDataDirectorySuffix =" + c2);
            }
        } catch (Throwable th) {
            Logger.e("AndroidUtil", "fixWebViewProcess e:" + th);
        }
    }

    public static boolean d(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return !packageManager.queryIntentActivities(intent, 0).isEmpty();
        } catch (Throwable th) {
            Logger.dd("AndroidUtil", "hasActivityIntentFilter error:" + th.getMessage());
            return true;
        }
    }

    public static String e(Context context, String str) {
        return context.getPackageName() + "." + str;
    }

    public static void e(Context context) {
        b(context, null);
    }

    public static Intent f(Context context) {
        Throwable th;
        Intent intent;
        PackageManager packageManager;
        String packageName;
        try {
            packageManager = context.getPackageManager();
            packageName = context.getApplicationContext().getPackageName();
        } catch (Throwable th2) {
            th = th2;
            intent = null;
        }
        if (TextUtils.isEmpty(packageName)) {
            Logger.ww("AndroidUtil", "The package with the given name cannot be found!");
            return null;
        }
        intent = packageManager.getLaunchIntentForPackage(packageName);
        try {
        } catch (Throwable th3) {
            th = th3;
            Logger.w("AndroidUtil", "getLaunchIntent error:" + th.getMessage());
            return intent;
        }
        if (intent == null) {
            Logger.ww("AndroidUtil", "Can't get launch intent for this package!");
            return null;
        }
        intent.addFlags(Build.VERSION.SDK_INT >= 11 ? 268468224 : 268435456);
        return intent;
    }

    public static boolean g(Context context) {
        String str;
        StringBuilder sb;
        Class cls;
        Logger.dd("AndroidUtil", "action:checkValidManifest");
        if (a(context, PushActivity.class)) {
            if (!a(context, PopWinActivity.class)) {
                Logger.ww("AndroidUtil", "AndroidManifest.xml missing activity: " + PopWinActivity.class.getCanonicalName());
                Logger.ww("AndroidUtil", "You will unable to use pop-window rich push type.");
            }
            if (!d(context, "cn.jpush.android.ui.PushActivity")) {
                str = "AndroidManifest.xml missing required intent filter for PushActivity: cn.jpush.android.ui.PushActivity";
            } else if (!a(context, JNotifyActivity.class)) {
                sb = new StringBuilder();
                sb.append("AndroidManifest.xml missing required activity: ");
                cls = JNotifyActivity.class;
            } else if (!TextUtils.isEmpty(JPushConstants.getMessageReceiverClass(context))) {
                return true;
            } else {
                str = "AndroidManifest.xml missing required receiver: please custom receiver extends JPushMessageReceiver";
            }
            Logger.ee("AndroidUtil", str);
            return false;
        }
        sb = new StringBuilder();
        sb.append("AndroidManifest.xml missing required activity: ");
        cls = PushActivity.class;
        sb.append(cls.getCanonicalName());
        str = sb.toString();
        Logger.ee("AndroidUtil", str);
        return false;
    }

    public static boolean h(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Throwable th) {
            Logger.ww("AndroidUtil", "[isAppOnForeground] error:" + th.getMessage());
        }
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }
}

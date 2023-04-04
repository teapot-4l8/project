package cn.jiguang.ai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.service.DaemonService;
import cn.jpush.android.service.DownloadProvider;
import com.google.android.gms.ads.AdRequest;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f3706a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f3707b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f3708c = "Xiaomi".toLowerCase();

    private static Intent a(PackageManager packageManager, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DActivity");
            intent.addCategory(str);
            intent.setPackage(str);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            if (resolveActivity == null) {
                cn.jiguang.ad.a.d("JWakeComponentHelper", "getDActivity resolveInfo was null from:" + str);
                return null;
            }
            cn.jiguang.ad.a.a("JWakeComponentHelper", "target actvity name:" + resolveActivity.activityInfo.name + ", theme:" + resolveActivity.activityInfo.theme + ",exported:" + resolveActivity.activityInfo.exported);
            if (resolveActivity.activityInfo.exported && resolveActivity.activityInfo.enabled && "jpush.custom".equals(resolveActivity.activityInfo.taskAffinity)) {
                if (resolveActivity.activityInfo.theme != 16973840) {
                    cn.jiguang.ad.a.d("JWakeComponentHelper", resolveActivity.activityInfo.name + "activity theme must config as @android:style/Theme.Translucent.NoTitleBar");
                    return null;
                }
                intent.setComponent(new ComponentName(str, resolveActivity.activityInfo.name));
                cn.jiguang.ad.a.a("JWakeComponentHelper", "dIntent:" + intent);
                return intent;
            }
            cn.jiguang.ad.a.d("JWakeComponentHelper", "activity muse be exported and enabled, and taskAffinity must be jpush.custom");
            return null;
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWakeComponentHelper", "get deeplink activity error#" + th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cn.jiguang.ah.b a(Context context, PackageManager packageManager, String str, String str2) {
        StringBuilder sb;
        String message;
        if (packageManager != null && !TextUtils.isEmpty(str)) {
            try {
                int checkPermission = packageManager.checkPermission(str + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, str);
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    String a2 = cn.jiguang.am.a.a(context);
                    Intent intent = new Intent();
                    intent.setClassName(str, "cn.jpush.android.service.PushService");
                    boolean z = false;
                    List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                    if (queryIntentServices != null && queryIntentServices.size() != 0) {
                        z = true;
                    }
                    if (checkPermission == 0 && z && !TextUtils.isEmpty(a2) && a2.length() == 24) {
                        cn.jiguang.ah.b bVar = new cn.jiguang.ah.b(str, str2, applicationInfo.targetSdkVersion);
                        ComponentInfo a3 = cn.jiguang.f.a.a(context, str, DownloadProvider.class);
                        if (a3 instanceof ProviderInfo) {
                            ProviderInfo providerInfo = (ProviderInfo) a3;
                            if (providerInfo.exported && providerInfo.enabled && providerInfo.authority != null) {
                                if (TextUtils.equals(str + ".DownloadProvider", providerInfo.authority)) {
                                    bVar.f3704d = providerInfo.authority;
                                }
                            }
                        }
                        if (b(context) && !a(context)) {
                            bVar.f3705e = a(packageManager, str);
                        }
                        return bVar;
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                sb = new StringBuilder("checkWhetherToStart exception:");
                message = e2.toString();
                sb.append(message);
                cn.jiguang.ad.a.d("JWakeComponentHelper", sb.toString());
                return null;
            } catch (Throwable th) {
                sb = new StringBuilder("checkWhetherToStart throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.ad.a.d("JWakeComponentHelper", sb.toString());
                return null;
            }
        }
        return null;
    }

    public static void a(Context context, boolean z) {
        ServiceInfo serviceInfo;
        try {
            if (context == null) {
                cn.jiguang.ad.a.e("JWakeComponentHelper", "context is null, give up setComponentEnabled");
            } else {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                if (packageManager == null) {
                    cn.jiguang.ad.a.e("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                } else {
                    String packageName = context.getPackageName();
                    int i = z ? 1 : 2;
                    Intent intent = new Intent();
                    intent.setPackage(packageName);
                    intent.setAction("cn.jpush.android.intent.DaemonService");
                    List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, AdRequest.MAX_CONTENT_URL_LENGTH);
                    if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                        cn.jiguang.ad.a.d("JWakeComponentHelper", "cant't find DaemonService");
                    } else {
                        for (ResolveInfo resolveInfo : queryIntentServices) {
                            if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                                String str = serviceInfo.name;
                                if (TextUtils.isEmpty(str)) {
                                    continue;
                                } else {
                                    try {
                                        Class<?> cls = Class.forName(str);
                                        if (cls != null) {
                                            if (DaemonService.class.isAssignableFrom(cls)) {
                                                ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                                                cn.jiguang.ad.a.a("JWakeComponentHelper", componentName + " setComponentEnabledSetting newState: " + i);
                                                if (packageManager.getComponentEnabledSetting(componentName) == i) {
                                                    cn.jiguang.ad.a.a("JWakeComponentHelper", "DaemonService  enabled is :" + z + ", no need repeat set.");
                                                    break;
                                                }
                                                packageManager.setComponentEnabledSetting(componentName, i, 1);
                                            } else {
                                                cn.jiguang.ad.a.e("JWakeComponentHelper", "give up setting, as " + str + " is not extend from: " + DaemonService.class.getName());
                                            }
                                        }
                                    } catch (ClassNotFoundException unused) {
                                        cn.jiguang.ad.a.d("JWakeComponentHelper", "cant't find service class:" + str);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWakeComponentHelper", "setServiceEnabled throwable:" + th.getMessage());
        }
        try {
            if (context == null) {
                cn.jiguang.ad.a.e("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager2 = context.getApplicationContext().getPackageManager();
            if (packageManager2 == null) {
                cn.jiguang.ad.a.e("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            int i2 = z ? 1 : 2;
            ComponentName componentName2 = new ComponentName(context, DownloadProvider.class);
            if (packageManager2.getComponentEnabledSetting(componentName2) == i2) {
                cn.jiguang.ad.a.a("JWakeComponentHelper", componentName2.getClassName() + " enabled is :" + z + ", no need repeat set.");
                return;
            }
            cn.jiguang.ad.a.a("JWakeComponentHelper", componentName2 + " setDownloadProviderEnabledSetting newState: " + i2);
            packageManager2.setComponentEnabledSetting(componentName2, i2, 1);
        } catch (Throwable th2) {
            cn.jiguang.ad.a.d("JWakeComponentHelper", "setContentProviderEnabled throwable:" + th2.getMessage());
        }
    }

    private static boolean a() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(f3708c, str.toLowerCase());
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("JWakeComponentHelper", "get MANUFACTURER failed - error:" + th);
            return false;
        }
    }

    public static boolean a(Context context) {
        Boolean bool = f3707b;
        if (bool != null) {
            return bool.booleanValue();
        }
        f3707b = Boolean.valueOf(a());
        return f3707b.booleanValue();
    }

    private static boolean a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return !packageManager.queryIntentActivities(intent, 0).isEmpty();
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("JWakeComponentHelper", "hasActivityIntentFilter error:" + th.getMessage());
            return false;
        }
    }

    public static boolean b(Context context) {
        Boolean bool = f3706a;
        if (bool != null) {
            return bool.booleanValue();
        }
        f3706a = Boolean.valueOf(a(context, "cn.jpush.android.intent.DActivity"));
        return f3706a.booleanValue();
    }
}

package cn.jiguang.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import cn.jiguang.an.d;
import cn.jiguang.d.a;
import cn.jiguang.g.b;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class JCoreManager {
    private static final String TAG = "JCoreManager";
    private static final AtomicBoolean isInited = new AtomicBoolean();

    public static void addDispatchAction(String str, String str2) {
        ActionManager.getInstance().addAction(str, str2);
    }

    public static void changeLiveStatus(boolean z) {
    }

    public static Context getAppContext(Context context) {
        return JConstants.getAppContext(context);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        Object onEvent = JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 67, false, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static boolean getDebugMode() {
        return JConstants.DEBUG_MODE;
    }

    public static void init(Context context) {
        Context appContext = JConstants.getAppContext(context);
        if (appContext == null) {
            return;
        }
        JConstants.isCallInit.set(true);
        if (isInited.get()) {
            return;
        }
        isInited.set(true);
        a.a(appContext);
        JCoreInternalHelper.getInstance().onEvent(appContext, JConstants.SDK_TYPE, 10, true, "tcp_a1", null, new Object[0]);
    }

    public static void initCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 70, true, null, null, new Object[0]);
    }

    public static boolean isInternal() {
        return JConstants.INTERNAL_USE;
    }

    public static boolean isTestEnv() {
        return JConstants.isTestEnv();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x003e A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object onEvent(Context context, String str, int i, String str2, Bundle bundle, Object... objArr) {
        boolean z;
        if (i != 13 && i != 49 && i != 53 && i != 58 && i != 60 && i != 25 && i != 26 && i != 42 && i != 43 && i != 63 && i != 64) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        default:
                                            switch (i) {
                                                case 67:
                                                case 68:
                                                case 69:
                                                    break;
                                                default:
                                                    z = true;
                                                    break;
                                            }
                                        case 45:
                                        case 46:
                                        case 47:
                                            z = false;
                                            break;
                                    }
                                case 32:
                                case 33:
                                case 34:
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                            break;
                    }
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    break;
            }
            return onEvent(context, str, i, z, str2, bundle, objArr);
        }
        z = false;
        return onEvent(context, str, i, z, str2, bundle, objArr);
    }

    public static Object onEvent(Context context, String str, int i, boolean z, String str2, Bundle bundle, Object... objArr) {
        if (i != 18 && i != 13) {
            init(context);
        }
        return JCoreInternalHelper.getInstance().onEvent(context, str, i, z, str2, bundle, objArr);
    }

    public static void requestPermission(Context context) {
        String str;
        if (context == null) {
            str = "[requestPermission] context was null";
        } else if (!(context instanceof Activity)) {
            str = "[requestPermission] context must instanceof Activity";
        } else if (Build.VERSION.SDK_INT < 23) {
            str = "[requestPermission] android.os.Build.VERSION.SDK_INT<23";
        } else if (context.getApplicationInfo().targetSdkVersion >= 23) {
            if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
                return;
            }
            try {
                LinkedList linkedList = new LinkedList();
                linkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                linkedList.add("android.permission.READ_EXTERNAL_STORAGE");
                linkedList.add("android.permission.ACCESS_FINE_LOCATION");
                linkedList.add("android.permission.READ_PHONE_STATE");
                if (JConstants.isAndroidQ(context, false, "will request background location permission")) {
                    linkedList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                }
                List<String> a2 = cn.jiguang.f.a.a(context, linkedList);
                if (a2 != null && !a2.isEmpty()) {
                    d.a(TAG, "lackPermissions:" + a2);
                    Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, a2.toArray(new String[a2.size()]), 1);
                    return;
                }
                return;
            } catch (Exception e2) {
                d.g(TAG, "#unexcepted - requestPermission e:" + e2);
                return;
            }
        } else {
            str = "[requestPermission] app targetSdkVersion<23";
        }
        d.g(TAG, str);
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        JConstants.jAnalyticsAction = jAnalyticsAction;
    }

    public static void setDebugMode(boolean z) {
        JConstants.DEBUG_MODE = z;
    }

    public static void setLBSEnable(Context context, boolean z) {
        d.b(TAG, "action - setLBSEnable-control:" + z);
        if (!z) {
            try {
                b.a(context, cn.jiguang.g.a.y().a((cn.jiguang.g.a<Boolean>) false));
            } catch (Throwable unused) {
            }
        }
        onEvent(context, null, 27, null, null, Boolean.valueOf(z));
    }

    public static void setSDKConfigs(Context context, Bundle bundle) {
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 55, true, null, bundle, new Object[0]);
    }

    public static void stopCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 71, true, null, null, new Object[0]);
    }
}

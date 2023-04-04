package cn.jpush.android.local;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.u.a;
import java.util.Iterator;

/* loaded from: classes.dex */
public class JPushConstants {
    public static int BUILD_ID = 34;
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final int FORE_GROUND = 0;
    public static final int FORE_GROUND_NO = 1;
    public static final int FORE_GROUND_UNKNOWN = -1;
    public static final String HTTPS_PRE = "https://";
    public static final String HTTP_PRE = "http://";
    public static final boolean IG = false;
    public static String SDK_NAME = "";
    public static final String SDK_TYPE = "JPUSH";
    public static int SDK_VERSION_CODE = 356;
    public static String SDK_VERSION_NAME = "3.5.6";
    public static boolean SUPPORT_DY = true;
    private static final String TAG = "JPushConstants";
    public static boolean THIRD_ENABLE = true;
    private static final String USER_MESSAGE_RECEIVER_ACTION = "cn.jpush.android.intent.RECEIVE_MESSAGE";
    public static int isForeGround = -1;
    private static boolean isInitLife = false;
    private static Boolean isSameProcessWithJCommonService = null;
    private static boolean isTestAndroidQ = false;
    private static JPushMessageReceiver jPushMessageReceiver;
    public static Context mApplicationContext;
    private static String messageReceiverClass;
    private static String messageReceiverProcess;
    private static boolean tcpConnected;

    public static boolean canGetLbsInBackGround(Context context) {
        String str;
        if (isAndroidQ(context, true, "canGetLbsInBackGround")) {
            if (isForeGround != 1 || a.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                str = (isForeGround == -1 && !a.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) ? "app is unkonwn foreground stat and no android.permission.ACCESS_BACKGROUND_LOCATION" : "app is unkonwn foreground stat and no android.permission.ACCESS_BACKGROUND_LOCATION";
            } else {
                str = "app is not in foreground and no android.permission.ACCESS_BACKGROUND_LOCATION";
            }
            Logger.ww(TAG, str);
            return false;
        }
        return true;
    }

    public static void changeForegroudStat(Context context, boolean z) {
        Logger.d(TAG, "changeForegroudStat:" + z);
        isForeGround = !z ? 1 : 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", z);
        JCoreHelper.runActionWithService(context, SDK_TYPE, "change_foreground", bundle);
    }

    public static Context getAppContext(Context context) {
        if (mApplicationContext == null && context != null) {
            mApplicationContext = context.getApplicationContext();
        }
        return mApplicationContext;
    }

    public static String getMessageReceiverClass(Context context) {
        ComponentInfo a2;
        try {
        } catch (Throwable th) {
            Logger.d(TAG, "getUserServiceClass failed:" + th.getMessage());
        }
        if (messageReceiverClass != null) {
            return messageReceiverClass;
        }
        Intent intent = new Intent();
        intent.setAction(USER_MESSAGE_RECEIVER_ACTION);
        intent.setPackage(context.getPackageName());
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(intent, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            if (next.activityInfo != null) {
                String str = next.activityInfo.name;
                if (TextUtils.isEmpty(str)) {
                    continue;
                } else {
                    Class<?> cls = Class.forName(str);
                    if (JPushMessageReceiver.class.isAssignableFrom(cls)) {
                        messageReceiverClass = str;
                        messageReceiverProcess = next.activityInfo.processName;
                        Logger.ii(TAG, "found messageReceiverClass :" + messageReceiverClass + "at " + messageReceiverProcess + " by getCommonReceiverNames");
                        if (messageReceiverProcess != null && messageReceiverProcess.equals(a.c(context))) {
                            jPushMessageReceiver = (JPushMessageReceiver) cls.newInstance();
                        }
                    }
                }
            }
        }
        if (TextUtils.isEmpty(messageReceiverClass) && (a2 = a.a(context, context.getPackageName(), JPushMessageReceiver.class)) != null) {
            messageReceiverClass = a2.name;
            messageReceiverProcess = a2.processName;
            Logger.ii(TAG, "found messageReceiverClass :" + messageReceiverClass + "at " + messageReceiverProcess + " by getComponentInfo");
            try {
                if (messageReceiverProcess != null && messageReceiverProcess.equals(a.c(context))) {
                    jPushMessageReceiver = (JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(messageReceiverClass)) {
            messageReceiverClass = "";
        }
        if (TextUtils.isEmpty(messageReceiverProcess)) {
            messageReceiverProcess = "";
        }
        return messageReceiverClass;
    }

    public static JPushMessageReceiver getPushMessageReceiver(Context context) {
        getMessageReceiverClass(getAppContext(context));
        return jPushMessageReceiver;
    }

    public static void init(Context context) {
        initPageLifecycle(context);
    }

    private static void initPageLifecycle(Context context) {
        String str;
        Logger.d(TAG, "initPageLifecycle init");
        if (isInitLife) {
            return;
        }
        try {
            isInitLife = true;
            if (Build.VERSION.SDK_INT < 14 || !(context instanceof Application)) {
                return;
            }
            String c2 = a.c(context);
            String packageName = context.getPackageName();
            if (c2 == null || packageName == null || !context.getPackageName().equals(c2)) {
                str = "need not initPageLifecycle in other process :" + c2;
            } else {
                ((Application) context).registerActivityLifecycleCallbacks(new ActivityLifeCallBack());
                str = "initPageLifecycle in main process,packageName:" + packageName + ",currentProcessName:" + c2;
            }
            Logger.d(TAG, str);
        } catch (Throwable th) {
            Logger.ww(TAG, "registerActivityLifecycleCallbacks failed:" + th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
        if (r3.getApplicationInfo().targetSdkVersion <= 28) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isAndroidQ(Context context, boolean z, String str) {
        boolean z2 = true;
        if (!z) {
            z2 = isTestAndroidQ ? false : false;
        } else if (isTestAndroidQ) {
        }
        if (z2) {
            Logger.d(TAG, "is Android Q, msg: " + str);
        }
        return z2;
    }

    public static boolean isSameProcessWithJCommonService(Context context) {
        boolean z;
        try {
        } catch (Throwable th) {
            Logger.w(TAG, "call isSameProcessWithJCommonService failed:" + th.getMessage());
        }
        if (isSameProcessWithJCommonService != null) {
            return isSameProcessWithJCommonService.booleanValue();
        }
        if (messageReceiverProcess == null) {
            getMessageReceiverClass(context);
        }
        ComponentInfo a2 = a.a(context, context.getPackageName(), JCommonService.class);
        if (a2 != null) {
            if (a2.processName.equals(messageReceiverProcess)) {
                Logger.dd(TAG, "same process with JCommonService");
                z = true;
            } else {
                Logger.dd(TAG, "is not same process with JCommonService");
                z = false;
            }
            isSameProcessWithJCommonService = z;
            return isSameProcessWithJCommonService.booleanValue();
        }
        return false;
    }

    public static boolean isTcpConnected() {
        return tcpConnected;
    }

    public static void setTcpConnected(boolean z) {
        tcpConnected = z;
    }

    public static void testAndroidQ() {
    }
}

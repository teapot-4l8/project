package cn.jiguang.internal;

import android.content.Context;
import cn.jiguang.an.d;
import cn.jiguang.api.JAnalyticsAction;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class JConstants {
    public static final byte AES_CBC = 1;
    public static boolean AT_I = true;
    public static final String DATA_PROVIDER_SUFFIX = ".DataProvider";
    public static final long DAY = 86400000;
    public static boolean DEBUG_MODE = false;
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final long HOUR = 3600000;
    public static final String HTTPS_PRE = "https://";
    public static final String HTTP_PRE = "http://";
    public static boolean INTERNAL_USE = false;
    public static final boolean IS_FOR_GOOGLE_PLAY_USE = false;
    public static final boolean LOG_ENABLE = true;
    public static final int LOG_ENABLED_LEVEL = 2;
    public static final boolean LOG_FILE_ENABLE = true;
    public static final long MIN = 60000;
    public static final boolean REPORT_SUPPORT_HTTP = false;
    public static final boolean REPORT_USE_HTTPS = true;
    public static String SDK_NAME = "";
    public static final String SDK_TYPE = "JCore";
    public static int SDK_VERSION_INT = 228;
    public static final long SECOND = 1000;
    public static final byte SM4_CBC = 2;
    public static final boolean SUPPORT_DY = true;
    private static final String TAG = "JConstants";
    public static String TUU = "";
    public static final String USER_SERVICE_ACTION = "cn.jiguang.user.service.action";
    public static boolean isInstrumentationHookFailed = true;
    public static JAnalyticsAction jAnalyticsAction;
    public static int tcpSessionId;
    public static AtomicBoolean isCallInit = new AtomicBoolean();
    public static int DEFAULT_HEARTBEAT_INTERVAL = 285;
    public static int DEFAULT_ALARM_DELAY = 290;
    public static byte tcpAlgorithm = 1;
    private static boolean testEnv = false;
    public static String testCountry = "";
    private static boolean isTestAndroidQ = false;
    public static Context mApplicationContext = null;

    public static Context getAppContext(Context context) {
        if (mApplicationContext == null && context != null) {
            mApplicationContext = context.getApplicationContext();
        }
        return mApplicationContext;
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
            d.b(TAG, "is Android Q, msg: " + str);
        }
        return z2;
    }

    public static boolean isTestEnv() {
        return false;
    }

    public static void setTestEnv(boolean z) {
    }

    public static void testAndroidQ() {
        d.b(TAG, "call testAndroidQ");
        isTestAndroidQ = true;
    }
}

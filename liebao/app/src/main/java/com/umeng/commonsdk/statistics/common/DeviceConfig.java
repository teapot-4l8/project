package com.umeng.commonsdk.statistics.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.umeng.analytics.pro.ak;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    protected static final String LOG_TAG = DeviceConfig.class.getName();
    private static DeviceTypeEnum deviceTypeEnum = DeviceTypeEnum.DEFAULT;
    private static volatile String sWifiMac = "";
    private static volatile String sImei = "";
    private static volatile String sMeid = "";
    private static volatile String sImsi = "";
    private static volatile String sSerialNo = "";
    private static volatile String sAndroidID = "";
    private static volatile String sIDFA = "";
    private static volatile String sOAID = "";
    private static volatile String sSecondImei = "";
    private static volatile String sSimSerialNumber = "";
    private static volatile boolean sImeiOrMeidFlag = false;
    private static volatile boolean sSerialFlag = false;
    private static volatile boolean sSimSerialNumberFlag = false;
    private static volatile boolean sImsiFlag = false;
    private static volatile boolean sSecondImeiFlag = false;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0052, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImei = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 29 && sImeiOrMeidFlag) {
                return null;
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.g) && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                str = telephonyManager.getDeviceId();
            }
        } catch (Throwable th) {
            try {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w("No IMEI.", th);
                }
            } finally {
                if (Build.VERSION.SDK_INT >= 29) {
                    sImeiOrMeidFlag = true;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007e, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImei = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0080, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getImeiNew(Context context) {
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 29 && sImeiOrMeidFlag) {
                return null;
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.g) && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                        method.setAccessible(true);
                        str = (String) method.invoke(telephonyManager, new Object[0]);
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = telephonyManager.getDeviceId();
                    }
                } else {
                    str = telephonyManager.getDeviceId();
                }
            }
        } catch (Throwable th) {
            try {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w("No IMEI.", th);
                }
            } finally {
                if (Build.VERSION.SDK_INT >= 29) {
                    sImeiOrMeidFlag = true;
                }
            }
        }
    }

    public static String getAndroidId(Context context) {
        if (!TextUtils.isEmpty(sAndroidID)) {
            return sAndroidID;
        }
        String str = null;
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.i) || context == null) {
            return null;
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            sAndroidID = str;
            return str;
        } catch (Exception unused) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.w("can't read android id");
                return str;
            }
            return str;
        }
    }

    public static String getSerial() {
        return getSerialNo();
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0013 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x0001, B:5:0x0009, B:6:0x000d, B:8:0x0013, B:10:0x0025, B:12:0x0031, B:14:0x0037, B:17:0x003b, B:20:0x0046, B:21:0x005c, B:23:0x0062, B:24:0x006a), top: B:27:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getMacByJavaAPI() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if ("wlan0".equals(nextElement.getName()) || "eth0".equals(nextElement.getName())) {
                        byte[] hardwareAddress = nextElement.getHardwareAddress();
                        if (hardwareAddress != null && hardwareAddress.length != 0) {
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i = 0; i < length; i++) {
                                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            return sb.toString().toLowerCase(Locale.getDefault());
                        }
                        return null;
                    }
                    while (networkInterfaces.hasMoreElements()) {
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getMacShell() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
                String[] strArr = {"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
                for (int i = 0; i < 3; i++) {
                    String reaMac = reaMac(strArr[i]);
                    if (reaMac != null) {
                        return reaMac;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String reaMac(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            FileReader fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader, 1024);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                str2 = bufferedReader.readLine();
                try {
                    fileReader.close();
                } catch (Throwable unused) {
                }
                bufferedReader.close();
            } catch (Throwable th2) {
                th = th2;
                try {
                    fileReader.close();
                } catch (Throwable unused2) {
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable unused4) {
        }
        return str2;
    }

    public static String getCPU() {
        String str = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            str = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e2) {
            MLog.e(LOG_TAG, "Could not open file /proc/cpuinfo", e2);
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
    }

    public static String getDeviceId(Context context) {
        if (AnalyticsConstants.getDeviceType() == 2) {
            return getDeviceIdForBox(context);
        }
        return getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdType() {
        return deviceTypeEnum.getDeviceIdType();
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getMCCMNC(Context context) {
        if (context == null) {
            return null;
        }
        if (getImsi(context) == null) {
            return null;
        }
        int i = context.getResources().getConfiguration().mcc;
        int i2 = context.getResources().getConfiguration().mnc;
        if (i != 0) {
            String valueOf = String.valueOf(i2);
            if (i2 < 10) {
                valueOf = String.format("%02d", Integer.valueOf(i2));
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(i));
            stringBuffer.append(valueOf);
            return stringBuffer.toString();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImsiFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getImsi(Context context) {
        if (TextUtils.isEmpty(sImsi)) {
            String str = null;
            if (context == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 29 || !sImsiFlag) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.ai)) {
                    try {
                        if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                            str = telephonyManager.getSubscriberId();
                        }
                    } catch (Throwable unused) {
                    }
                }
                sImsi = str;
                return sImsi;
            }
            return null;
        }
        return sImsi;
    }

    public static String getMeid(Context context) {
        TelephonyManager telephonyManager;
        String str = null;
        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return null;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.aj)) {
            try {
                if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                    if (Build.VERSION.SDK_INT < 26) {
                        str = getIMEI(context);
                    } else {
                        str = meid(context);
                        if (TextUtils.isEmpty(str)) {
                            str = getIMEI(context);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
        return com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String meid(Context context) {
        if (TextUtils.isEmpty(sMeid)) {
            return sMeid;
        }
        String str = null;
        if ((Build.VERSION.SDK_INT >= 29 && sImeiOrMeidFlag) || context == null) {
            return null;
        }
        try {
            Object invoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null && (invoke instanceof String)) {
                str = (String) invoke;
            }
        } catch (Throwable th) {
            try {
                ULog.e("meid:" + th.getMessage());
            } finally {
                if (Build.VERSION.SDK_INT >= 29) {
                    sImeiOrMeidFlag = true;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumberFlag = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSimICCID(Context context) {
        if (!TextUtils.isEmpty(sSimSerialNumber)) {
            return sSimSerialNumber;
        }
        if (Build.VERSION.SDK_INT < 29 || !sSimSerialNumberFlag) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.am)) {
                if (context != null) {
                    try {
                        if (UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                sSimSerialNumber = telephonyManager.getSimSerialNumber();
                            } else {
                                if (Build.VERSION.SDK_INT >= 29) {
                                    sSimSerialNumberFlag = true;
                                }
                                return null;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return sSimSerialNumber;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImeiFlag = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSecondSimIMEi(Context context) {
        if (!TextUtils.isEmpty(sSecondImei)) {
            return sSecondImei;
        }
        if (Build.VERSION.SDK_INT < 29 || !sSecondImeiFlag) {
            if (context != null && FieldManager.allow(com.umeng.commonsdk.utils.b.al) && Build.VERSION.SDK_INT >= 23 && UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        Class<?> cls = telephonyManager.getClass();
                        if (((Integer) cls.getMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue() == 2) {
                            sSecondImei = (String) cls.getMethod("getDeviceId", Integer.TYPE).invoke(telephonyManager, 2);
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 29) {
                            sSecondImeiFlag = true;
                        }
                        return null;
                    }
                } catch (Throwable unused) {
                }
            }
            return sSecondImei;
        }
        return null;
    }

    public static String getRegisteredOperator(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) {
                return null;
            }
            return telephonyManager.getNetworkOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                return String.valueOf(i2) + "*" + String.valueOf(i);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            strArr[0] = "";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "";
            return strArr;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "2G/3G";
            strArr[1] = networkInfo2.getSubtypeName();
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: SocketException -> 0x0069, TryCatch #0 {SocketException -> 0x0069, blocks: (B:5:0x000e, B:7:0x0014, B:8:0x0026, B:10:0x002c, B:13:0x003a, B:15:0x003e, B:18:0x004a, B:19:0x004e, B:21:0x0054, B:23:0x0058, B:26:0x0064), top: B:36:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getIPAddress(Context context) {
        String str;
        String str2 = null;
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            str = null;
            while (!it.hasNext()) {
                try {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            InetAddress inetAddress = (InetAddress) it2.next();
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address) && !networkInterface.getDisplayName().contains("dummy") && str2 == null) {
                                str2 = inetAddress.getHostAddress();
                            }
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address) && !networkInterface.getDisplayName().contains("dummy") && str == null) {
                                str = inetAddress.getHostAddress();
                            }
                        }
                    }
                    if (!it.hasNext()) {
                    }
                } catch (SocketException unused) {
                    str2 = str;
                    str = str2;
                    str2 = "SocketException";
                    if (str2 == null) {
                    }
                }
            }
        } catch (SocketException unused2) {
        }
        return str2 == null ? str2 : str == null ? "null" : str;
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception unused) {
            return -100;
        }
    }

    public static boolean isWiFiAvailable(Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int getTimeZone(Context context) {
        if (context == null) {
            return 8;
        }
        try {
            Calendar calendar = Calendar.getInstance(getLocale(context));
            if (calendar != null) {
                return calendar.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Throwable th) {
            MLog.i(LOG_TAG, "error in getTimeZone", th);
        }
        return 8;
    }

    public static boolean isChineseAera(Context context) {
        String imprintProperty;
        if (context == null) {
            return false;
        }
        try {
            imprintProperty = UMEnvelopeBuild.imprintProperty(context, ak.O, "");
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(imprintProperty)) {
            return imprintProperty.equals("cn");
        }
        if (getImsi(context) == null) {
            String str = getLocaleInfo(context)[0];
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("cn")) {
                return true;
            }
        } else {
            int i = context.getResources().getConfiguration().mcc;
            if (i != 460 && i != 461) {
                if (i == 0) {
                    String str2 = getLocaleInfo(context)[0];
                    if (TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase("cn")) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = {"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    private static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return Locale.getDefault();
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Throwable unused) {
            MLog.e(LOG_TAG, "fail to read user config locale");
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String getMac(Context context) {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        String str = "";
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
            if (context == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT < 23) {
                str = getMacBySystemInterface(context);
            } else if (Build.VERSION.SDK_INT == 23) {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    if (AnalyticsConstants.CHECK_DEVICE) {
                        str = getMacShell();
                    } else {
                        str = getMacBySystemInterface(context);
                    }
                }
            } else {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    str = getMacBySystemInterface(context);
                }
            }
        }
        sWifiMac = str;
        return sWifiMac;
    }

    private static String getMacBySystemInterface(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    return wifiManager != null ? wifiManager.getConnectionInfo().getMacAddress() : "";
                } else if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                }
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = LOG_TAG;
                MLog.w(str, "Could not get mac address." + th.toString());
            }
            return "";
        }
    }

    public static int[] getResolutionArray(Context context) {
        int i;
        int i2;
        Method method;
        if (context == null) {
            return null;
        }
        int[] iArr = new int[2];
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                try {
                    Class<?> cls = Class.forName("android.view.Display");
                    if (cls != null && (method = cls.getMethod("getRealMetrics", DisplayMetrics.class)) != null) {
                        method.invoke(defaultDisplay, displayMetrics);
                        int i3 = displayMetrics.widthPixels;
                        int i4 = displayMetrics.heightPixels;
                        if (i3 > i4) {
                            iArr[0] = i4;
                            iArr[1] = i3;
                        } else {
                            iArr[0] = i3;
                            iArr[1] = i4;
                        }
                        iArr[0] = displayMetrics.widthPixels;
                        iArr[1] = displayMetrics.heightPixels;
                        return iArr;
                    }
                } catch (Throwable unused) {
                    return null;
                }
            } else {
                try {
                    DisplayMetrics displayMetrics2 = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics2);
                    if ((context.getApplicationInfo().flags & 8192) == 0) {
                        i = reflectMetrics(displayMetrics2, "noncompatWidthPixels");
                        i2 = reflectMetrics(displayMetrics2, "noncompatHeightPixels");
                    } else {
                        i = -1;
                        i2 = -1;
                    }
                    if (i == -1 || i2 == -1) {
                        i = displayMetrics2.widthPixels;
                        i2 = displayMetrics2.heightPixels;
                    }
                    if (i > i2) {
                        iArr[0] = i2;
                        iArr[1] = i;
                    } else {
                        iArr[0] = i;
                        iArr[1] = i2;
                    }
                    return iArr;
                } catch (Throwable unused2) {
                }
            }
        }
        return null;
    }

    private static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getPackageName(Context context) {
        if (context == null) {
            return null;
        }
        return context.getPackageName();
    }

    public static String getAppSHA1Key(Context context) {
        try {
            return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAppHashKey(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures;
            if (signatureArr.length > 0) {
                Signature signature = signatureArr[0];
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                return Base64.encodeToString(messageDigest.digest(), 0).trim();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return byte2HexFormatted(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static String getApplicationLable(Context context) {
        return context == null ? "" : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static String getAppName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.i(LOG_TAG, th);
                return null;
            }
            return null;
        }
    }

    public static String getDeviceIdForGeneral(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                String imei = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (TextUtils.isEmpty(imei)) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.w(LOG_TAG, "No IMEI.");
                    }
                    String macBySystemInterface = getMacBySystemInterface(context);
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                    if (TextUtils.isEmpty(macBySystemInterface)) {
                        if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                            macBySystemInterface = getAndroidId(context);
                            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str = LOG_TAG;
                                MLog.i(str, "getDeviceId, ANDROID_ID: " + macBySystemInterface);
                            }
                        }
                        if (TextUtils.isEmpty(macBySystemInterface)) {
                            String serialNo = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            return serialNo;
                        }
                        return macBySystemInterface;
                    }
                    return macBySystemInterface;
                }
                return imei;
            } else if (Build.VERSION.SDK_INT == 23) {
                String imei2 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (TextUtils.isEmpty(imei2)) {
                    String macByJavaAPI = getMacByJavaAPI();
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                    if (TextUtils.isEmpty(macByJavaAPI)) {
                        if (AnalyticsConstants.CHECK_DEVICE) {
                            macByJavaAPI = getMacShell();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                        } else {
                            macByJavaAPI = getMacBySystemInterface(context);
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                        }
                    }
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str2 = LOG_TAG;
                        MLog.i(str2, "getDeviceId, MAC: " + macByJavaAPI);
                    }
                    if (TextUtils.isEmpty(macByJavaAPI)) {
                        if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                            macByJavaAPI = getAndroidId(context);
                            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str3 = LOG_TAG;
                                MLog.i(str3, "getDeviceId, ANDROID_ID: " + macByJavaAPI);
                            }
                        }
                        if (TextUtils.isEmpty(macByJavaAPI)) {
                            String serialNo2 = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            return serialNo2;
                        }
                        return macByJavaAPI;
                    }
                    return macByJavaAPI;
                }
                return imei2;
            } else if (Build.VERSION.SDK_INT >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                if (TextUtils.isEmpty(oaid)) {
                    String idfa = getIdfa(context);
                    deviceTypeEnum = DeviceTypeEnum.IDFA;
                    if (TextUtils.isEmpty(idfa)) {
                        String androidId = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        if (TextUtils.isEmpty(androidId)) {
                            String serialNo3 = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            if (TextUtils.isEmpty(serialNo3)) {
                                String macByJavaAPI2 = getMacByJavaAPI();
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                                if (TextUtils.isEmpty(macByJavaAPI2)) {
                                    String macBySystemInterface2 = getMacBySystemInterface(context);
                                    deviceTypeEnum = DeviceTypeEnum.MAC;
                                    return macBySystemInterface2;
                                }
                                return macByJavaAPI2;
                            }
                            return serialNo3;
                        }
                        return androidId;
                    }
                    return idfa;
                }
                return oaid;
            } else {
                String imei3 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (TextUtils.isEmpty(imei3)) {
                    String serialNo4 = getSerialNo();
                    deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                    if (TextUtils.isEmpty(serialNo4)) {
                        if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                            serialNo4 = getAndroidId(context);
                            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str4 = LOG_TAG;
                                MLog.i(str4, "getDeviceId, ANDROID_ID: " + serialNo4);
                            }
                        }
                        if (TextUtils.isEmpty(serialNo4)) {
                            String macByJavaAPI3 = getMacByJavaAPI();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            if (TextUtils.isEmpty(macByJavaAPI3)) {
                                String macBySystemInterface3 = getMacBySystemInterface(context);
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                                if (AnalyticsConstants.UM_DEBUG) {
                                    String str5 = LOG_TAG;
                                    MLog.i(str5, "getDeviceId, MAC: " + macBySystemInterface3);
                                    return macBySystemInterface3;
                                }
                                return macBySystemInterface3;
                            }
                            return macByJavaAPI3;
                        }
                        return serialNo4;
                    }
                    return serialNo4;
                }
                return imei3;
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceIdForBox(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str2 = LOG_TAG;
                        MLog.i(str2, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    String macBySystemInterface = getMacBySystemInterface(context);
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str3 = LOG_TAG;
                        MLog.i(str3, "getDeviceId, MAC: " + macBySystemInterface);
                    }
                    if (TextUtils.isEmpty(macBySystemInterface)) {
                        String serialNo = getSerialNo();
                        deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                        if (TextUtils.isEmpty(serialNo)) {
                            String imei = getIMEI(context);
                            deviceTypeEnum = DeviceTypeEnum.IMEI;
                            return imei;
                        }
                        return serialNo;
                    }
                    return macBySystemInterface;
                }
                return str;
            } else if (Build.VERSION.SDK_INT == 23) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str4 = LOG_TAG;
                        MLog.i(str4, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    String macByJavaAPI = getMacByJavaAPI();
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                    if (TextUtils.isEmpty(macByJavaAPI)) {
                        if (AnalyticsConstants.CHECK_DEVICE) {
                            macByJavaAPI = getMacShell();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                        } else {
                            macByJavaAPI = getMacBySystemInterface(context);
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                        }
                    }
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str5 = LOG_TAG;
                        MLog.i(str5, "getDeviceId, MAC: " + macByJavaAPI);
                    }
                    if (TextUtils.isEmpty(macByJavaAPI)) {
                        String serialNo2 = getSerialNo();
                        deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                        if (TextUtils.isEmpty(serialNo2)) {
                            String imei2 = getIMEI(context);
                            deviceTypeEnum = DeviceTypeEnum.IMEI;
                            return imei2;
                        }
                        return serialNo2;
                    }
                    return macByJavaAPI;
                }
                return str;
            } else if (Build.VERSION.SDK_INT >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                if (TextUtils.isEmpty(oaid)) {
                    String idfa = getIdfa(context);
                    deviceTypeEnum = DeviceTypeEnum.IDFA;
                    if (TextUtils.isEmpty(idfa)) {
                        String androidId = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        if (TextUtils.isEmpty(androidId)) {
                            String serialNo3 = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            if (TextUtils.isEmpty(serialNo3)) {
                                String macByJavaAPI2 = getMacByJavaAPI();
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                                if (TextUtils.isEmpty(macByJavaAPI2)) {
                                    String macBySystemInterface2 = getMacBySystemInterface(context);
                                    deviceTypeEnum = DeviceTypeEnum.MAC;
                                    return macBySystemInterface2;
                                }
                                return macByJavaAPI2;
                            }
                            return serialNo3;
                        }
                        return androidId;
                    }
                    return idfa;
                }
                return oaid;
            } else {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str6 = LOG_TAG;
                        MLog.i(str6, "getDeviceId: ANDROID_ID: " + str);
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    String serialNo4 = getSerialNo();
                    deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                    if (TextUtils.isEmpty(serialNo4)) {
                        String imei3 = getIMEI(context);
                        deviceTypeEnum = DeviceTypeEnum.IMEI;
                        if (TextUtils.isEmpty(imei3)) {
                            String macByJavaAPI3 = getMacByJavaAPI();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            if (TextUtils.isEmpty(macByJavaAPI3)) {
                                String macBySystemInterface3 = getMacBySystemInterface(context);
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                                if (AnalyticsConstants.UM_DEBUG) {
                                    String str7 = LOG_TAG;
                                    MLog.i(str7, "getDeviceId, MAC: " + macBySystemInterface3);
                                    return macBySystemInterface3;
                                }
                                return macBySystemInterface3;
                            }
                            return macByJavaAPI3;
                        }
                        return imei3;
                    }
                    return serialNo4;
                }
                return str;
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getOaid(Context context) {
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(h.f6872a, 0);
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString(h.f6873b, "");
                    try {
                        sOAID = string;
                    } catch (Throwable unused) {
                    }
                    return string;
                }
                return "";
            } catch (Throwable unused2) {
                return "";
            }
        }
        return "";
    }

    public static String getIdfa(Context context) {
        if (!TextUtils.isEmpty(sIDFA)) {
            return sIDFA;
        }
        String str = "";
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.w)) {
                str = a.a(context);
                sIDFA = str;
                return str;
            }
            return "";
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getIMEI(Context context) {
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = "";
        if (Build.VERSION.SDK_INT < 29 || !sImeiOrMeidFlag) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.g)) {
                if (context == null) {
                    return "";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    try {
                        if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                            String deviceId = telephonyManager.getDeviceId();
                            try {
                                if (AnalyticsConstants.UM_DEBUG) {
                                    String str2 = LOG_TAG;
                                    MLog.i(str2, "getDeviceId, IMEI: " + deviceId);
                                }
                                str = deviceId;
                            } catch (Throwable th) {
                                th = th;
                                str = deviceId;
                                try {
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        MLog.w(LOG_TAG, "No IMEI.", th);
                                    }
                                } finally {
                                    if (Build.VERSION.SDK_INT >= 29) {
                                        sImeiOrMeidFlag = true;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            sImei = str;
            return sImei;
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sSerialFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getSerialNo() {
        String str;
        if (!TextUtils.isEmpty(sSerialNo)) {
            return sSerialNo;
        }
        String str2 = "";
        if (Build.VERSION.SDK_INT < 29 || !sSerialFlag) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.j)) {
                try {
                    if (Build.VERSION.SDK_INT >= 9) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            try {
                                Class<?> cls = Class.forName("android.os.Build");
                                str = (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
                            } catch (Throwable unused) {
                            }
                        } else {
                            str = Build.SERIAL;
                        }
                        str2 = str;
                    }
                    sSerialNo = str2;
                } catch (Throwable unused2) {
                }
            }
            if (AnalyticsConstants.UM_DEBUG) {
                String str3 = LOG_TAG;
                MLog.i(str3, "getDeviceId, serial no: " + str2);
            }
            return sSerialNo;
        }
        return "";
    }

    public static String getSubOSName(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            return TextUtils.isEmpty(property) ? isFlyMe() ? "Flyme" : isEmui(buildProp) ? "Emui" : !TextUtils.isEmpty(getYunOSVersion(buildProp)) ? "YunOS" : property : "MIUI";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (TextUtils.isEmpty(property)) {
                try {
                    if (isFlyMe()) {
                        property = getFlymeVersion(buildProp);
                    } else if (isEmui(buildProp)) {
                        property = getEmuiVersion(buildProp);
                    } else {
                        property = getYunOSVersion(buildProp);
                    }
                    return property;
                } catch (Throwable unused) {
                    return property;
                }
            }
            return property;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return property;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Properties getBuildProp() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            } catch (Throwable unused) {
            }
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (Throwable unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return properties;
            }
        } catch (Throwable unused3) {
        }
        return properties;
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean isEmui(Properties properties) {
        return properties.getProperty(KEY_EMUI_VERSION_CODE, null) != null;
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Throwable unused) {
            return "Phone";
        }
    }

    public static String getDBencryptID(Context context) {
        return UMUtils.genId();
    }

    public static Activity getGlobleActivity(Context context) {
        Activity activity = null;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    activity = (Activity) declaredField3.get(obj);
                }
            }
        } catch (Throwable unused) {
        }
        return activity;
    }

    public static boolean isHarmony(Context context) {
        try {
            return context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony");
        } catch (Throwable unused) {
            return false;
        }
    }
}

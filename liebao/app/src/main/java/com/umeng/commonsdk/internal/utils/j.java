package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: UMProbe.java */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6787a = "UM_PROBE_DATA";

    /* renamed from: b  reason: collision with root package name */
    public static final String f6788b = "_dsk_s";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6789c = "_thm_z";

    /* renamed from: d  reason: collision with root package name */
    public static final String f6790d = "_gdf_r";

    /* renamed from: e  reason: collision with root package name */
    private static Object f6791e = new Object();

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f6787a, 0);
            if (sharedPreferences != null) {
                JSONObject jSONObject = new JSONObject();
                synchronized (f6791e) {
                    jSONObject.put(f6788b, sharedPreferences.getString(f6788b, ""));
                    jSONObject.put(f6789c, sharedPreferences.getString(f6789c, ""));
                    jSONObject.put(f6790d, sharedPreferences.getString(f6790d, ""));
                }
                return jSONObject.toString();
            }
            return null;
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static void b(final Context context) {
        if (c(context)) {
            return;
        }
        final String[] strArr = {"unknown", "unknown", "unknown"};
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.j.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = j.c();
                    strArr[1] = j.a();
                    strArr[2] = j.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    j.b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f6787a, 0)) == null) {
            return;
        }
        synchronized (f6791e) {
            sharedPreferences.edit().putString(f6788b, strArr[0]).putString(f6789c, strArr[1]).putString(f6790d, strArr[2]).commit();
        }
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f6787a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f6788b, ""))) ? false : true;
    }

    public static int a(String str, String str2) {
        int i;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i = -1;
                break;
            } else if (readLine.contains(str2)) {
                i = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i;
        try {
            i = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i = -1;
        }
        return i > 0 ? "thermal_zone" : i < 0 ? "noper" : "unknown";
    }

    public static String b() {
        int i;
        try {
            i = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i = -1;
        }
        return i > 0 ? "goldfish" : i < 0 ? "noper" : "unknown";
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c() {
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/diskstats"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    str = "mtd";
                    if (readLine == null) {
                        str = "unknown";
                        break;
                    } else if (!readLine.contains("mmcblk")) {
                        if (!readLine.contains("sda")) {
                            if (readLine.contains("mtd")) {
                                break;
                            }
                        } else {
                            str = "sda";
                            break;
                        }
                    } else {
                        str = "mmcblk";
                        break;
                    }
                } catch (Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    str = "noper";
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    return str;
                }
            }
        } catch (Throwable unused2) {
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        }
        return str;
    }
}

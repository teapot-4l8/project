package cn.jiguang.u;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import cn.jiguang.f.i;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.umeng.analytics.pro.ak;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f4223a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f4224b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final FileFilter f4225c = new b();

    public static int a(String str) {
        if (i.a(str)) {
            return -1;
        }
        if (str.equalsIgnoreCase("ChinaTelecom")) {
            return 2;
        }
        if (str.equalsIgnoreCase("ChinaMobile")) {
            return 0;
        }
        return str.equalsIgnoreCase("ChinaUnicom") ? 1 : -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0063, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] == str.charAt(i3)) {
                            if (i3 == str.length() - 1) {
                                while (i2 < 1024 && bArr[i2] != 10) {
                                    if (bArr[i2] >= 48 && bArr[i2] <= 57) {
                                        int i4 = i2 + 1;
                                        while (i4 < 1024 && bArr[i4] >= 48 && bArr[i4] <= 57) {
                                            i4++;
                                        }
                                        return Integer.parseInt(new String(bArr, 0, i2, i4 - i2));
                                    }
                                    i2++;
                                }
                                return -1;
                            }
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    public static String a() {
        if (TextUtils.isEmpty(f4223a)) {
            f();
            return f4223a;
        }
        return f4223a;
    }

    public static String a(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "0*0";
        }
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        return i + "*" + i2;
    }

    public static String a(Context context, int i) {
        String str;
        if (i != 53) {
            return null;
        }
        try {
            String str2 = (String) cn.jiguang.g.b.b(context, new cn.jiguang.g.a("cn.jpush.preferences.v2", "n_udp_report_device_info", ""));
            if (TextUtils.isEmpty(str2)) {
                str = (String) cn.jiguang.g.b.b(context, new cn.jiguang.g.a("cn.jpush.preferences.v2", "udp_report_device_info", ""));
                if (!TextUtils.isEmpty(str)) {
                    a(context, str);
                }
            } else {
                str = new String(Base64.decode(str2, 2));
            }
            cn.jiguang.ad.a.a("JDeviceHelper", "read deviceinfo:" + str);
            if (TextUtils.isEmpty(str)) {
                str = e(context);
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            cn.jiguang.at.b.a();
            jSONObject2.put("rom_type", (int) cn.jiguang.at.b.a(context));
            cn.jiguang.at.b.a();
            jSONObject2.put("regid", cn.jiguang.at.b.b(context));
            jSONObject.put("rom_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cmd", 53);
            jSONObject3.put("content", jSONObject);
            return jSONObject3.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void a(Context context, String str) {
        cn.jiguang.g.b.a(context, new cn.jiguang.g.a("cn.jpush.preferences.v2", "n_udp_report_device_info", "").a((cn.jiguang.g.a) Base64.encodeToString(str.getBytes(), 2)));
        cn.jiguang.ad.a.a("JDeviceHelper", "save device info:" + str);
    }

    public static double b(Context context) {
        double pow;
        int i;
        Point point = new Point();
        boolean z = context instanceof Activity;
        if (z) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else if (Build.VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            pow = Math.pow(point.x / displayMetrics.xdpi, 2.0d);
            i = point.y;
        } else {
            pow = Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d);
            i = displayMetrics.heightPixels;
        }
        return Math.sqrt(pow + Math.pow(i / displayMetrics.ydpi, 2.0d));
    }

    private static long b(String str) {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 4096);
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
            } while (!readLine.contains(str));
            bufferedReader.close();
            return Integer.valueOf(readLine.split("\\s+")[1]).intValue();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(f4224b)) {
            f();
            return f4224b;
        }
        return f4224b;
    }

    public static long c() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static long c(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                activityManager.getProcessMemoryInfo(new int[]{0});
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem / 1024;
            }
        } catch (Throwable unused) {
        }
        return b("MemTotal");
    }

    public static int d() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f4225c).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static JSONArray d(Context context) {
        JSONObject a2;
        List<cn.jiguang.t.b> b2 = e.b(context.getApplicationContext());
        if (b2 != null) {
            JSONArray jSONArray = new JSONArray();
            for (cn.jiguang.t.b bVar : b2) {
                if (bVar != null && (a2 = bVar.a()) != null) {
                    jSONArray.put(a2);
                }
            }
            return jSONArray;
        }
        return null;
    }

    public static int e() {
        int i = -1;
        for (int i2 = 0; i2 < d(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (bArr[i3] >= 48 && bArr[i3] <= 57 && i3 < 128) {
                            i3++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                        if (valueOf.intValue() > i) {
                            i = valueOf.intValue();
                        }
                    } catch (Throwable unused) {
                    }
                    fileInputStream.close();
                }
            } catch (Throwable unused2) {
                return -1;
            }
        }
        if (i == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            int a2 = a("cpu MHz", fileInputStream2) * 1000;
            if (a2 > i) {
                i = a2;
            }
            fileInputStream2.close();
        }
        return i;
    }

    public static String e(Context context) {
        try {
            cn.jiguang.ay.a a2 = cn.jiguang.ay.a.a(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sim_slots", d(context));
            jSONObject.put("packagename", context.getPackageName());
            jSONObject.put("appkey", cn.jiguang.am.a.a(context));
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, 0);
            jSONObject.put("apkversion", a2.f4012a);
            jSONObject.put("systemversion", a2.f4013b);
            jSONObject.put("modelnumber", a2.f4014c);
            jSONObject.put("basebandversion", a2.f4015d);
            jSONObject.put("buildnumber", a2.f4016e);
            jSONObject.put("channel", a2.f);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PushSDKVer", cn.jiguang.o.i.a(0));
            jSONObject2.put("StatisticSDKVer", cn.jiguang.o.i.a(1));
            jSONObject2.put("ShareSDKVer", cn.jiguang.o.i.a(2));
            jSONObject2.put("CoreSDKVer", cn.jiguang.o.i.a(3));
            jSONObject2.put("SspSDKVer", cn.jiguang.o.i.a(4));
            jSONObject2.put("VerificationSDKVer", cn.jiguang.o.i.a(5));
            jSONObject.put("sdkver", jSONObject2);
            jSONObject.put("installation", a2.g);
            jSONObject.put(ak.z, a2.h);
            cn.jiguang.at.b.a();
            jSONObject.put("business", cn.jiguang.at.b.b());
            jSONObject.put("device_id_status", cn.jiguang.bb.b.f4041a);
            jSONObject.put("device_id", cn.jiguang.d.a.e(context));
            jSONObject.put("android_id", a2.i);
            jSONObject.put("mac_address", cn.jiguang.f.a.f(context, ""));
            jSONObject.put("serial_number", a2.j);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    private static void f() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (new File("/proc/cpuinfo").exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                String str = null;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.contains("Processor")) {
                        int indexOf = readLine.indexOf(":");
                        if (indexOf >= 0 && indexOf < readLine.length() - 1) {
                            str = readLine.substring(indexOf + 1).trim();
                        }
                        if (str != null && !stringBuffer.toString().contains(str)) {
                            stringBuffer.append(str);
                        }
                    }
                    if (readLine.contains("Hardware")) {
                        try {
                            String trim = readLine.substring(readLine.indexOf(":") + 1).trim();
                            if (!TextUtils.isEmpty(trim)) {
                                f4224b = trim;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Throwable unused2) {
        }
        f4223a = stringBuffer.toString();
    }
}

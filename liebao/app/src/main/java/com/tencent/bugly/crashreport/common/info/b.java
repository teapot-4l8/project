package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6011a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f6012b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f6013c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: d  reason: collision with root package name */
    private static String f6014d;

    /* renamed from: e  reason: collision with root package name */
    private static String f6015e;

    public static String d() {
        return "null";
    }

    public static String e() {
        return "null";
    }

    public static String f() {
        return "null";
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (x.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String a(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return str == null ? "null" : str.toLowerCase();
        } catch (Throwable th) {
            if (!x.a(th)) {
                x.a("Failed to get Android ID.", new Object[0]);
            }
            return str;
        }
    }

    public static String b(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getSimSerialNumber();
                return str == null ? "null" : str;
            }
            return "fail";
        } catch (Throwable unused) {
            x.a("Failed to get SIM serial number.", new Object[0]);
            return str;
        }
    }

    public static String g() {
        try {
            return Build.SERIAL;
        } catch (Throwable unused) {
            x.a("Failed to get hardware serial number.", new Object[0]);
            return "fail";
        }
    }

    private static boolean u() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (x.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        r0 = java.lang.System.getProperty("os.arch");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, boolean z) {
        String str = null;
        if (z) {
            try {
                String a2 = z.a(context, "ro.product.cpu.abilist");
                if (z.a(a2) || a2.equals("fail")) {
                    a2 = z.a(context, "ro.product.cpu.abi");
                }
                if (!z.a(a2) && !a2.equals("fail")) {
                    x.b(b.class, "ABI list: " + a2, new Object[0]);
                    str = a2.split(",")[0];
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return "fail";
            }
        }
        return str;
    }

    public static long h() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long i() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long j() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!x.a(e3)) {
                        e3.printStackTrace();
                    }
                }
                return parseLong;
            }
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                if (!x.a(e4)) {
                    e4.printStackTrace();
                }
            }
            try {
                fileReader.close();
                return -1L;
            } catch (IOException e5) {
                if (x.a(e5)) {
                    return -1L;
                }
                e5.printStackTrace();
                return -1L;
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        if (!x.a(e6)) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e7) {
                        if (x.a(e7)) {
                            return -2L;
                        }
                        e7.printStackTrace();
                        return -2L;
                    }
                }
                return -2L;
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        if (!x.a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e9) {
                        if (!x.a(e9)) {
                            e9.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    public static long k() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!x.a(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + 0;
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    if (!x.a(e4)) {
                        e4.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e5) {
                    if (!x.a(e5)) {
                        e5.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong2 = parseLong + (Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    if (!x.a(e6)) {
                        e6.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e7) {
                    if (!x.a(e7)) {
                        e7.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong3 = parseLong2 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
            try {
                bufferedReader.close();
            } catch (IOException e8) {
                if (!x.a(e8)) {
                    e8.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e9) {
                if (!x.a(e9)) {
                    e9.printStackTrace();
                }
            }
            return parseLong3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e10) {
                        if (!x.a(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e11) {
                        if (x.a(e11)) {
                            return -2L;
                        }
                        e11.printStackTrace();
                        return -2L;
                    }
                }
                return -2L;
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        if (!x.a(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e13) {
                        if (!x.a(e13)) {
                            e13.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    public static long l() {
        if (u()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (x.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static long m() {
        if (u()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (x.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static String n() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String o() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String c(Context context) {
        TelephonyManager telephonyManager;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "unknown";
            }
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDen";
                case 12:
                    return "EVDO_B";
                case 13:
                    return "LTE";
                case 14:
                    return "eHRPD";
                case 15:
                    return "HSPA+";
                default:
                    return "MOBILE(" + networkType + ")";
            }
        } catch (Exception e2) {
            if (x.a(e2)) {
                return "unknown";
            }
            e2.printStackTrace();
            return "unknown";
        }
    }

    public static String d(Context context) {
        String a2 = z.a(context, "ro.miui.ui.version.name");
        if (!z.a(a2) && !a2.equals("fail")) {
            return "XiaoMi/MIUI/" + a2;
        }
        String a3 = z.a(context, "ro.build.version.emui");
        if (!z.a(a3) && !a3.equals("fail")) {
            return "HuaWei/EMOTION/" + a3;
        }
        String a4 = z.a(context, "ro.lenovo.series");
        if (!z.a(a4) && !a4.equals("fail")) {
            String a5 = z.a(context, "ro.build.version.incremental");
            return "Lenovo/VIBE/" + a5;
        }
        String a6 = z.a(context, "ro.build.nubia.rom.name");
        if (!z.a(a6) && !a6.equals("fail")) {
            return "Zte/NUBIA/" + a6 + "_" + z.a(context, "ro.build.nubia.rom.code");
        }
        String a7 = z.a(context, "ro.meizu.product.model");
        if (!z.a(a7) && !a7.equals("fail")) {
            return "Meizu/FLYME/" + z.a(context, "ro.build.display.id");
        }
        String a8 = z.a(context, "ro.build.version.opporom");
        if (!z.a(a8) && !a8.equals("fail")) {
            return "Oppo/COLOROS/" + a8;
        }
        String a9 = z.a(context, "ro.vivo.os.build.display.id");
        if (!z.a(a9) && !a9.equals("fail")) {
            return "vivo/FUNTOUCH/" + a9;
        }
        String a10 = z.a(context, "ro.aa.romver");
        if (!z.a(a10) && !a10.equals("fail")) {
            return "htc/" + a10 + "/" + z.a(context, "ro.build.description");
        }
        String a11 = z.a(context, "ro.lewa.version");
        if (!z.a(a11) && !a11.equals("fail")) {
            return "tcl/" + a11 + "/" + z.a(context, "ro.build.display.id");
        }
        String a12 = z.a(context, "ro.gn.gnromvernumber");
        if (!z.a(a12) && !a12.equals("fail")) {
            return "amigo/" + a12 + "/" + z.a(context, "ro.build.display.id");
        }
        String a13 = z.a(context, "ro.build.tyd.kbstyle_version");
        if (!z.a(a13) && !a13.equals("fail")) {
            return "dido/" + a13;
        }
        return z.a(context, "ro.build.fingerprint") + "/" + z.a(context, "ro.build.rom.id");
    }

    public static String e(Context context) {
        return z.a(context, "ro.board.platform");
    }

    public static boolean p() {
        boolean z;
        String[] strArr = f6011a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (new File(strArr[i]).exists()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || z;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String q() {
        BufferedReader bufferedReader;
        try {
            StringBuilder sb = new StringBuilder();
            if (new File("/sys/block/mmcblk0/device/type").exists()) {
                bufferedReader = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/type"));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                } catch (Throwable unused) {
                    if (bufferedReader != null) {
                    }
                    return null;
                }
            } else {
                bufferedReader = null;
            }
            sb.append(",");
            if (new File("/sys/block/mmcblk0/device/name").exists()) {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/name"));
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        sb.append(readLine2);
                    }
                    bufferedReader2.close();
                    bufferedReader = bufferedReader2;
                } catch (Throwable unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            x.a(e2);
                        }
                    }
                    return null;
                }
            }
            sb.append(",");
            if (new File("/sys/block/mmcblk0/device/cid").exists()) {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/cid"));
                try {
                    String readLine3 = bufferedReader3.readLine();
                    if (readLine3 != null) {
                        sb.append(readLine3);
                    }
                    bufferedReader = bufferedReader3;
                } catch (Throwable unused3) {
                    bufferedReader = bufferedReader3;
                    if (bufferedReader != null) {
                    }
                    return null;
                }
            }
            String sb2 = sb.toString();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    x.a(e3);
                }
            }
            return sb2;
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static String f(Context context) {
        StringBuilder sb = new StringBuilder();
        String a2 = z.a(context, "ro.genymotion.version");
        if (a2 != null) {
            sb.append("ro.genymotion.version");
            sb.append("|");
            sb.append(a2);
            sb.append("\n");
        }
        String a3 = z.a(context, "androVM.vbox_dpi");
        if (a3 != null) {
            sb.append("androVM.vbox_dpi");
            sb.append("|");
            sb.append(a3);
            sb.append("\n");
        }
        String a4 = z.a(context, "qemu.sf.fake_camera");
        if (a4 != null) {
            sb.append("qemu.sf.fake_camera");
            sb.append("|");
            sb.append(a4);
        }
        return sb.toString();
    }

    public static String g(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        StringBuilder sb = new StringBuilder();
        if (f6014d == null) {
            f6014d = z.a(context, "ro.secure");
        }
        if (f6014d != null) {
            sb.append("ro.secure");
            sb.append("|");
            sb.append(f6014d);
            sb.append("\n");
        }
        if (f6015e == null) {
            f6015e = z.a(context, "ro.debuggable");
        }
        if (f6015e != null) {
            sb.append("ro.debuggable");
            sb.append("|");
            sb.append(f6015e);
            sb.append("\n");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        x.a(th);
                        return sb.toString();
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                x.a(e2);
                            }
                        }
                    }
                }
            } while (!readLine.startsWith("TracerPid:"));
            if (readLine != null) {
                String trim = readLine.substring(10).trim();
                sb.append("tracer_pid");
                sb.append("|");
                sb.append(trim);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                x.a(e3);
            }
            return sb2;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a7 A[Catch: IOException -> 0x00ab, TRY_LEAVE, TryCatch #4 {IOException -> 0x00ab, blocks: (B:35:0x00a7, B:32:0x00a0), top: B:50:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String r() {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                if (new File("/sys/class/power_supply/ac/online").exists()) {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/sys/class/power_supply/ac/online"));
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append("ac_online");
                            sb.append("|");
                            sb.append(readLine);
                        }
                        bufferedReader2.close();
                        bufferedReader = bufferedReader2;
                    } catch (Throwable unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb.toString();
                    }
                }
                sb.append("\n");
                if (new File("/sys/class/power_supply/usb/online").exists()) {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader("/sys/class/power_supply/usb/online"));
                    try {
                        String readLine2 = bufferedReader3.readLine();
                        if (readLine2 != null) {
                            sb.append("usb_online");
                            sb.append("|");
                            sb.append(readLine2);
                        }
                        bufferedReader3.close();
                        bufferedReader = bufferedReader3;
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader3;
                        if (bufferedReader != null) {
                        }
                        return sb.toString();
                    }
                }
                sb.append("\n");
                if (new File("/sys/class/power_supply/battery/capacity").exists()) {
                    BufferedReader bufferedReader4 = new BufferedReader(new FileReader("/sys/class/power_supply/battery/capacity"));
                    try {
                        String readLine3 = bufferedReader4.readLine();
                        if (readLine3 != null) {
                            sb.append("battery_capacity");
                            sb.append("|");
                            sb.append(readLine3);
                        }
                        bufferedReader4.close();
                        bufferedReader = bufferedReader4;
                    } catch (Throwable unused3) {
                        bufferedReader = bufferedReader4;
                        if (bufferedReader != null) {
                        }
                        return sb.toString();
                    }
                }
            } catch (Throwable unused4) {
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e2) {
            x.a(e2);
        }
        return sb.toString();
    }

    public static String h(Context context) {
        StringBuilder sb = new StringBuilder();
        String a2 = z.a(context, "gsm.sim.state");
        if (a2 != null) {
            sb.append("gsm.sim.state");
            sb.append("|");
            sb.append(a2);
        }
        sb.append("\n");
        String a3 = z.a(context, "gsm.sim.state2");
        if (a3 != null) {
            sb.append("gsm.sim.state2");
            sb.append("|");
            sb.append(a3);
        }
        return sb.toString();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0030 -> B:34:0x0041). Please submit an issue!!! */
    public static long s() {
        BufferedReader bufferedReader;
        float f = 0.0f;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/uptime"));
            } catch (Throwable unused) {
            }
        } catch (IOException e2) {
            x.a(e2);
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                f = ((float) (System.currentTimeMillis() / 1000)) - Float.parseFloat(readLine.split(" ")[0]);
            }
            bufferedReader.close();
        } catch (Throwable unused2) {
            bufferedReader2 = bufferedReader;
            try {
                x.a("Failed to get boot time of device.", new Object[0]);
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return f;
            } catch (Throwable th) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        x.a(e3);
                    }
                }
                throw th;
            }
        }
        return f;
    }

    public static boolean i(Context context) {
        int i;
        if (k(context) == null) {
            ArrayList arrayList = new ArrayList();
            while (i < f6013c.length) {
                String[] strArr = f6013c;
                if (i == 0) {
                    i = new File(strArr[i]).exists() ? i + 1 : 0;
                    arrayList.add(Integer.valueOf(i));
                } else {
                    if (!new File(strArr[i]).exists()) {
                    }
                    arrayList.add(Integer.valueOf(i));
                }
            }
            return (arrayList.isEmpty() ? null : arrayList.toString()) != null;
        }
        return true;
    }

    private static String k(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = f6012b;
            if (i >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i], 1);
                arrayList.add(Integer.valueOf(i));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static boolean j(Context context) {
        return (((l(context) | w()) | x()) | v()) > 0;
    }

    private static int v() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    private static int l(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i = 1;
        } catch (Exception unused) {
            i = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i | 2;
        } catch (Exception unused2) {
            return i;
        }
    }

    private static int w() {
        StackTraceElement[] stackTrace;
        try {
            throw new Exception("detect hook");
        } catch (Exception e2) {
            int i = 0;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                    i |= 32;
                }
            }
            return i;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b7: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:51:0x00b7 */
    private static int x() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        IOException e2;
        UnsupportedEncodingException e3;
        FileNotFoundException e4;
        int i = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    HashSet hashSet = new HashSet();
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                            }
                        } catch (FileNotFoundException e5) {
                            e4 = e5;
                            e4.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i;
                        } catch (UnsupportedEncodingException e6) {
                            e3 = e6;
                            e3.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i;
                        } catch (IOException e7) {
                            e2 = e7;
                            e2.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i;
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (((String) next).toLowerCase().contains("xposed")) {
                            i |= 64;
                        }
                        if (((String) next).contains("com.saurik.substrate")) {
                            i |= 128;
                        }
                    }
                    bufferedReader2.close();
                } catch (FileNotFoundException e8) {
                    bufferedReader2 = null;
                    e4 = e8;
                } catch (UnsupportedEncodingException e9) {
                    bufferedReader2 = null;
                    e3 = e9;
                } catch (IOException e10) {
                    bufferedReader2 = null;
                    e2 = e10;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader3 = bufferedReader;
        }
    }

    public static boolean t() {
        double maxMemory = Runtime.getRuntime().maxMemory();
        Double.isNaN(maxMemory);
        float f = (float) (maxMemory / 1048576.0d);
        double d2 = Runtime.getRuntime().totalMemory();
        Double.isNaN(d2);
        float f2 = (float) (d2 / 1048576.0d);
        float f3 = f - f2;
        x.c("maxMemory : %f", Float.valueOf(f));
        x.c("totalMemory : %f", Float.valueOf(f2));
        x.c("freeMemory : %f", Float.valueOf(f3));
        return f3 < 10.0f;
    }
}

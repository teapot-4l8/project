package MyUtil.EnvUtils;


import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeviceUtils {

//    static {
//        System.loadLibrary("enc");
//    }

    public static boolean isDeviceRooted1() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    public static boolean isDeviceRooted2() {
        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su" };
        for (String path : paths) {
            if (new File(path).exists()) {
                return true;
            }
        }
        return false;
    }
    // 这个方法检测的是厂商的开发测试机 刷机包刷到这种才会有test-keys
    public static boolean isDeviceRooted3() {
        String buildTags = Build.TAGS;
        if (buildTags != null && buildTags.contains("test-keys")) {
            return true;
        }
        return false;
    }

    public static boolean isBootloaderUnlocked1() {
        String bootloader = Build.BOOTLOADER;
        if (bootloader != null && bootloader.toLowerCase().contains("unlocked")) {
            return true;
        }
        return false;
    }

    public static boolean isBootloaderUnlocked2() {
        try {
            Process process = Runtime.getRuntime().exec("getprop ro.boot.flash.locked");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            return line.equals("0");
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isEmulator() {
        String product = Build.PRODUCT;
        return product != null && product.equals("sdk");
    }

    public static boolean isXposedInstalled() {
        String xposedBridgePath = "/data/data/de.robv.android.xposed.installer/bin/XposedBridge.jar";
        return new File(xposedBridgePath).exists();
    }

    public static boolean isLSposedInstalled() {
        String lsposedBridgePath = "/data/adb/lspd";
        return new File(lsposedBridgePath).exists();
    }

    public static boolean proxyDetector(Context context) {
        int port;
        String str;
        if (Build.VERSION.SDK_INT >= 14) {
            str = System.getProperty("http.proxyHost");
            if (str == null) {
                str = "";
            }
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                property = "-1";
            }
            port = Integer.parseInt(property);
        } else {
            String host = Proxy.getHost(context);
            Log.e((String) host, "Proxy.getHost(context)");
            port = Proxy.getPort(context);
            str = host;
        }
        return (TextUtils.isEmpty(str) || port == -1) ? false : true;
    }

    public static boolean MagiskExisted() {
        String magiskAppPath = "/sbin/magisk";
        return new File(magiskAppPath).exists();
    }

    public static boolean KernelSU() {
        String kernelSUAppPath = "/sbin/kernelsu";
        return new File(kernelSUAppPath).exists();
    }
}
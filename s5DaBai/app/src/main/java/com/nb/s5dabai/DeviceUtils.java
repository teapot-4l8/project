package com.nb.s5dabai;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

class DeviceUtils {
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
        String buildTags = android.os.Build.TAGS;
        if (buildTags != null && buildTags.contains("test-keys")) {
            return true;
        }
        return false;
    }


    public static boolean isBootloaderUnlocked1() {
        String bootloader = android.os.Build.BOOTLOADER;
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
        String product = android.os.Build.PRODUCT;
        return product != null && product.equals("sdk");
    }

    public static boolean isXposedInstalled() {
        String xposedBridgePath = "/data/data/de.robv.android.xposed.installer/bin/XposedBridge.jar";
        return new File(xposedBridgePath).exists();
    }

        
}
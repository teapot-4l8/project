package com.speed.speed_library.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class DeviceUtils {
    // 不知道为什么MT重新签名后会把so给搞回原来的
    public static native String AntiRoot();

    public static native String aaxx(Context context);

    public static native String ddmm(Context context);

    public static boolean a() {
        try {
            if (new File("/system/bin/su").exists() && a("/system/bin/su")) {
                return true;
            }
            if (new File("/system/xbin/su").exists()) {
                return a("/system/xbin/su");
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        Process process = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                process = runtime.exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        if (process != null) {
                            process.destroy();
                        }
                        return true;
                    }
                }
                if (process == null) {
                    return false;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (process == null) {
                    return false;
                }
            }
            process.destroy();
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    static {
        System.loadLibrary("myapplication");
    }
}

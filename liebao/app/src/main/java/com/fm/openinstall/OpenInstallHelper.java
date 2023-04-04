package com.fm.openinstall;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import b.a.a.a;
import b.a.a.c;
import b.a.k.d;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class OpenInstallHelper {
    private OpenInstallHelper() {
    }

    public static String checkGaid(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (d.f3261a) {
                d.c("不能在主线程调用", new Object[0]);
            }
            return null;
        }
        a.C0064a a2 = b.a.a.a.a(context.getApplicationContext());
        if (a2 == null) {
            return null;
        }
        return a2.a();
    }

    public static String checkOaid(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            c cVar = new c();
            cVar.a(context.getApplicationContext());
            return cVar.a();
        } else if (d.f3261a) {
            d.c("不能在主线程调用", new Object[0]);
            return null;
        } else {
            return null;
        }
    }

    public static boolean checkYYB(Intent intent) {
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.getBoolean("openinstall_intent", false)) {
                return false;
            }
            String string = extras.getString(b.a.k.c.f3256a);
            if (b.a.k.c.f3257b.equalsIgnoreCase(string) || b.a.k.c.f3258c.equalsIgnoreCase(string)) {
                return true;
            }
        }
        String action = intent.getAction();
        Set<String> categories = intent.getCategories();
        return action == null || categories == null || !action.equals("android.intent.action.MAIN") || !categories.contains("android.intent.category.LAUNCHER");
    }

    public static boolean isMainProcess(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return context.getApplicationInfo().packageName.equals(runningAppProcessInfo.processName);
            }
        }
        return false;
    }

    public static boolean isValidIntent(Intent intent) {
        Uri data;
        if (intent != null && (data = intent.getData()) != null && data.getHost() != null) {
            for (String str : b.a.h.a.c().split("\\|")) {
                if (data.getHost().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}

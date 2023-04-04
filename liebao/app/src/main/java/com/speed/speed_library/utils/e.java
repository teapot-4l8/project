package com.speed.speed_library.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: FileUtil.java */
/* loaded from: classes2.dex */
public class e {
    public static String a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            sb.delete(0, sb.length());
        }
        return sb.toString().trim();
    }

    public static synchronized String a(Context context) {
        String str;
        synchronized (e.class) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "dsd";
            }
        }
        return str;
    }

    public static synchronized int b(Context context) {
        int i;
        synchronized (e.class) {
            try {
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return i;
    }
}

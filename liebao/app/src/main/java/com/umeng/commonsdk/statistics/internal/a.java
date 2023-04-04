package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.ak;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: HeaderHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f6881a;

    /* renamed from: b  reason: collision with root package name */
    private String f6882b;

    /* renamed from: c  reason: collision with root package name */
    private String f6883c;

    private a() {
        this.f6882b = null;
        this.f6883c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeaderHelper.java */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0170a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f6884a = new a();

        private C0170a() {
        }
    }

    public static a a(Context context) {
        if (f6881a == null && context != null) {
            f6881a = context.getApplicationContext();
        }
        return C0170a.f6884a;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ak.av);
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ak.aH);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ak.aD);
    }

    public void d(String str) {
        String substring = str.substring(0, str.indexOf(95));
        f(substring);
        e(substring);
    }

    private void e(String str) {
        try {
            String replaceAll = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/");
            this.f6882b = replaceAll + "/Android/" + Build.DISPLAY + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + " " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f6881a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f6881a, th);
        }
    }

    private void f(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(ak.aP);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith("=")) {
                        substring = substring.replace("=", "");
                    }
                    sb.append(substring);
                }
            }
            this.f6883c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f6881a, th);
        }
    }

    public String a() {
        return this.f6883c;
    }

    public String b() {
        return this.f6882b;
    }
}

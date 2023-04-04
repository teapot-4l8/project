package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class Bugly {
    public static final String SDK_IS_DEV = "false";

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5953a = false;
    public static Context applicationContext = null;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f5954b = {"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};

    /* renamed from: c  reason: collision with root package name */
    private static String[] f5955c = {"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static Boolean isDev;

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        String[] strArr;
        synchronized (Bugly.class) {
            if (f5953a) {
                return;
            }
            f5953a = true;
            Context a2 = z.a(context);
            applicationContext = a2;
            if (a2 == null) {
                Log.e(x.f6265a, "init arg 'context' should not be null!");
                return;
            }
            if (isDev()) {
                f5954b = f5955c;
            }
            for (String str2 : f5954b) {
                if (str2.equals("BuglyCrashModule")) {
                    b.a(CrashModule.getInstance());
                } else if (!str2.equals("BuglyBetaModule") && !str2.equals("BuglyRqdModule")) {
                    str2.equals("BuglyFeedbackModule");
                }
            }
            b.f5967a = enable;
            b.a(applicationContext, str, z, buglyStrategy);
        }
    }

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
            if (b2 == null) {
                return null;
            }
            if (TextUtils.isEmpty(b2.m)) {
                p a2 = p.a();
                if (a2 == null) {
                    return b2.m;
                }
                Map<String, byte[]> a3 = a2.a(556, (o) null, true);
                if (a3 != null && (bArr = a3.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return b2.m;
        }
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = Boolean.valueOf(Boolean.parseBoolean(SDK_IS_DEV.replace("@", "")));
        }
        return isDev.booleanValue();
    }
}

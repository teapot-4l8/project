package com.c.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;

/* compiled from: WalleChannelReader.java */
/* loaded from: classes.dex */
public final class g {
    public static String a(Context context) {
        return a(context, null);
    }

    public static String a(Context context, String str) {
        b b2 = b(context);
        return b2 == null ? str : b2.a();
    }

    public static b b(Context context) {
        String c2 = c(context);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        return c.a(new File(c2));
    }

    private static String c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }
}

package com.speed.speed_library.business.update.fullupdate;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;

/* compiled from: FullUpdateUtils.java */
/* loaded from: classes2.dex */
public class d {
    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException e2) {
            throw new AssertionError(e2);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Activity b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}

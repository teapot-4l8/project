package b.a.k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* loaded from: classes.dex */
public class f {
    private static Object a(Context context, String str) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.get(str);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String a(Context context) {
        Object a2 = a(context, "com.openinstall.APP_KEY");
        if (a2 != null) {
            try {
                return String.valueOf(a2);
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public static boolean b(Context context) {
        Object a2 = a(context, "com.openinstall.ENCRYPT");
        if (a2 != null) {
            try {
                return Boolean.parseBoolean(String.valueOf(a2));
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }
}

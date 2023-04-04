package androidx.core.content.a;

import android.content.pm.PackageInfo;
import android.os.Build;

/* compiled from: PackageInfoCompat.java */
/* loaded from: classes.dex */
public final class a {
    public static long a(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return packageInfo.versionCode;
    }
}

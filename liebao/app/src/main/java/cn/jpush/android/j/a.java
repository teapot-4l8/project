package cn.jpush.android.j;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.i.b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f4368a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f4369b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final String f4370c = "".toLowerCase();

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i;
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str)) {
            b.d("AndroidUtils", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            int i2 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i2);
            componentInfoArr = i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        } catch (Throwable th) {
            b.e("AndroidUtils", "hasComponent error:" + th);
        }
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static boolean a(Context context) {
        String str;
        if (context == null) {
            str = "context was null";
        } else {
            String str2 = null;
            try {
                str2 = Build.MANUFACTURER;
                b.a("AndroidUtils", "MANUFACTURER:" + str2);
            } catch (Throwable th) {
                b.e("AndroidUtils", "get MANUFACTURER failed - error:" + th);
            }
            if (!TextUtils.isEmpty(str2)) {
                return TextUtils.isEmpty(f4370c) || TextUtils.equals(f4370c, str2.toLowerCase());
            }
            str = "MANUFACTURER was empty";
        }
        b.e("AndroidUtils", str);
        return false;
    }
}

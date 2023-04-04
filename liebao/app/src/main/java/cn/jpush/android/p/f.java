package cn.jpush.android.p;

import android.content.Context;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class f {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("jpush_notification_icon", "drawable", context.getPackageName());
        if (identifier == 0) {
            try {
                identifier = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).icon;
                Logger.i("ResourceHelper", "JPush.mPackageInconId == 0 ?, get icon from application info.");
                return identifier;
            } catch (Throwable th) {
                Logger.ee("ResourceHelper", "failed to get application info and icon.", th);
                return identifier;
            }
        }
        return identifier;
    }
}

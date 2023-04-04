package cn.jpush.android.t;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class b {
    public static d a(Context context, String str, String str2) {
        return d.a(context, str, str2);
    }

    private static void a(Context context, d dVar) {
        Intent b2 = 2 == dVar.R ? cn.jpush.android.p.b.b(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : cn.jpush.android.p.b.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar);
        if (b2 != null) {
            b2.addFlags(268435456);
            context.getApplicationContext().startActivity(b2);
        }
    }

    private static void a(Context context, d dVar, String str, int i) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageArrived");
        dVar.f4313d = i;
        cn.jpush.android.p.b.a(context, "cn.jpush.android.intent.NOTIFICATION_ARRIVED", dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.f4312c, str, dVar.W, 1018, context);
    }

    public static void a(Context context, String str, String str2, int i, byte b2, boolean z) {
        String str3;
        if (context == null) {
            str3 = "context was null";
        } else if (TextUtils.isEmpty(str)) {
            str3 = "content was null";
        } else {
            Logger.v("PluginPlatformsNotificationHelper", "message content:" + str);
            d a2 = a(context, str, str2);
            Logger.v("PluginPlatformsNotificationHelper", "entity:" + a2);
            if (a2 == null) {
                str3 = "entity was null";
            } else if (!TextUtils.isEmpty(a2.f4312c)) {
                a2.W = b2;
                if (z) {
                    b(context, a2, str2, i);
                    return;
                } else {
                    a(context, a2, str2, i);
                    return;
                }
            } else {
                str3 = "message id was empty";
            }
        }
        Logger.ww("PluginPlatformsNotificationHelper", str3);
    }

    private static void b(Context context, d dVar, String str, int i) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageClick");
        dVar.f4313d = i;
        if (dVar.M) {
            a(context, dVar);
            return;
        }
        cn.jpush.android.p.b.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.f4312c, str, dVar.W, 1000, context);
    }
}

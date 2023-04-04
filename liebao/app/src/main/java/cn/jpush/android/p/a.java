package cn.jpush.android.p;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.util.Locale;

/* loaded from: classes.dex */
public class a {

    /* renamed from: cn.jpush.android.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0080a {

        /* renamed from: a  reason: collision with root package name */
        public String f4413a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f4414b;

        /* renamed from: c  reason: collision with root package name */
        public int f4415c;

        /* renamed from: d  reason: collision with root package name */
        public int f4416d;

        /* renamed from: e  reason: collision with root package name */
        public int f4417e;
        public String f;
        public Uri g;
        public boolean h;

        public C0080a(String str, CharSequence charSequence, int i, int i2, String str2) {
            this.f4413a = str;
            this.f4414b = charSequence;
            this.f4415c = i;
            this.f4417e = i2;
            this.f = str2;
        }
    }

    private static int a(int i) {
        if (i != -2) {
            if (i != -1) {
                return (i == 1 || i == 2) ? 4 : 3;
            }
            return 2;
        }
        return 1;
    }

    private static NotificationChannel a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && !TextUtils.isEmpty(str)) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
                if (notificationChannel != null) {
                    Logger.dd("ChannelHelper", "channel has created: " + str);
                    return notificationChannel;
                }
                Logger.dd("ChannelHelper", "not found channed id from user set,will use sdk default channel ID");
            }
        } catch (Throwable th) {
            Logger.e("ChannelHelper", "config channelID error,will use sdk default channel ID:" + th);
        }
        return null;
    }

    private static String a(Context context, int i) {
        boolean z;
        String str;
        String str2 = i != -2 ? i != -1 ? (i == 1 || i == 2) ? "HIGH" : "DEFAULT" : "LOW" : "MIN";
        String str3 = "";
        try {
            String str4 = "jg_channel_name_p_" + str2.toLowerCase();
            int identifier = context.getResources().getIdentifier(str4, "string", context.getPackageName());
            if (identifier != 0) {
                str3 = context.getResources().getString(identifier);
                str = "found " + str3 + " from resource by name:" + str4;
            } else {
                str = "not found string value from resource by name:" + str4;
            }
            Logger.dd("ChannelHelper", str);
        } catch (Throwable th) {
            Logger.ww("ChannelHelper", "get resource channel ID failed:" + th.getMessage());
        }
        if (TextUtils.isEmpty(str3)) {
            try {
                z = Locale.getDefault().getLanguage().contains("zh");
            } catch (Throwable th2) {
                Logger.ww("ChannelHelper", "get language failed:" + th2.getMessage());
                z = true;
            }
            if (i == -2 || i == -1) {
                return z ? "不重要" : "LOW";
            } else if (i == 1 || i == 2) {
                return z ? "重要" : "HIGH";
            } else {
                return z ? "普通" : "NORMAL";
            }
        }
        return str3;
    }

    private static String a(Context context, int i, int i2) {
        int a2 = a(i);
        String str = "JPush_" + a2 + "_" + i2;
        String a3 = a(context, i);
        Logger.d("ChannelHelper", "channelId:" + str + ",channelName:" + a3);
        return a(context, str, a3, a2, i2, null) ? str : "";
    }

    private static String a(C0080a c0080a) {
        String str = "JPush_" + c0080a.f4416d + "_" + c0080a.f4417e;
        if (c0080a.g != null) {
            return str + "_" + c0080a.f;
        }
        return str;
    }

    public static void a(Context context) {
        a(context, -1, 0);
        a(context, 0, 7);
    }

    public static void a(Context context, Notification.Builder builder, String str, CharSequence charSequence, int i, int i2, String str2) {
        C0080a c0080a = new C0080a(str, charSequence, i, i2, str2);
        a(context, c0080a);
        b.a(builder, c0080a);
    }

    public static void a(Context context, Notification notification, String str, CharSequence charSequence, int i, int i2, String str2) {
        C0080a c0080a = new C0080a(str, charSequence, i, i2, str2);
        a(context, c0080a);
        b.a(notification, c0080a);
    }

    public static void a(Context context, C0080a c0080a) {
        NotificationChannel a2;
        NotificationChannel a3;
        if (b.d(context)) {
            Logger.d("ChannelHelper", "in silence push time,change defaults to 0");
            c0080a.f4413a = "";
            c0080a.f4417e = 0;
            c0080a.f = null;
        } else if (Build.VERSION.SDK_INT >= 26 && (a2 = a(context, c0080a.f4413a)) != null) {
            c0080a.f4413a = a2.getId();
            c0080a.f4414b = a2.getName();
            c0080a.f4416d = a2.getImportance();
            c0080a.f4415c = b(c0080a.f4416d);
            c0080a.g = a2.getSound();
            if (c0080a.g != null) {
                c0080a.f = c0080a.g.getPath();
            }
            c0080a.h = true;
            return;
        }
        if (c0080a.f4415c == -2 || c0080a.f4415c == -1) {
            c0080a.f4417e = 0;
            c0080a.f = null;
        } else if (c0080a.f4415c >= 0 && c0080a.f4417e == 0 && TextUtils.isEmpty(c0080a.f)) {
            c0080a.f4415c = -1;
        }
        c0080a.f4417e &= 7;
        if (c0080a.f4415c == 2) {
            c0080a.f4415c = 1;
        }
        c0080a.f4416d = a(c0080a.f4415c);
        c0080a.f4415c = b(c0080a.f4416d);
        c0080a.g = b.a(context, c0080a.f);
        if (c0080a.g != null) {
            c0080a.f4417e &= -2;
        } else {
            c0080a.f = null;
        }
        if (TextUtils.isEmpty(c0080a.f4413a)) {
            c0080a.f4413a = a(c0080a);
            if (Build.VERSION.SDK_INT >= 26 && (a3 = a(context, c0080a.f4413a)) != null) {
                c0080a.f4413a = a3.getId();
                c0080a.f4414b = a3.getName();
                c0080a.h = true;
                return;
            }
        }
        if (TextUtils.isEmpty(c0080a.f4414b)) {
            c0080a.f4414b = a(context, c0080a.f4415c);
        }
        Logger.d("ChannelHelper", "create channelId:" + c0080a.f4413a + ",channelName:" + ((Object) c0080a.f4414b) + " soundUri:" + c0080a.g);
        c0080a.h = a(context, c0080a.f4413a, c0080a.f4414b, c0080a.f4416d, c0080a.f4417e, c0080a.g);
    }

    private static boolean a(Context context, String str, CharSequence charSequence, int i, int i2, Uri uri) {
        if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26) {
            Logger.d("ChannelHelper", "sdkversion < 26, no need use notificationChannel!");
            return false;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager == null) {
                Logger.ee("ChannelHelper", "NotificationManager is null!");
                return false;
            }
            Logger.dd("ChannelHelper", "prepare NotificationChannel, channelId=" + str + "");
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel != null) {
                notificationChannel.setName(charSequence);
                notificationManager.createNotificationChannel(notificationChannel);
                return true;
            }
            NotificationChannel notificationChannel2 = new NotificationChannel(str, charSequence, i);
            if (Build.VERSION.SDK_INT < 28 || notificationManager.getNotificationChannelGroup("JIGUANG_CHANNEL_GROUP") == null) {
                notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("JIGUANG_CHANNEL_GROUP", cn.jpush.android.u.a.b(context)));
            }
            notificationChannel2.setGroup("JIGUANG_CHANNEL_GROUP");
            notificationChannel2.enableLights((i2 & 4) != 0);
            notificationChannel2.enableVibration((i2 & 2) != 0);
            if (uri != null) {
                notificationChannel2.setSound(uri, null);
            } else {
                if (!((i2 & 1) != 0)) {
                    notificationChannel2.setSound(null, null);
                }
            }
            notificationManager.createNotificationChannel(notificationChannel2);
            return true;
        } catch (Throwable th) {
            Logger.ee("ChannelHelper", "new NotificationChannel fail:" + th);
            return false;
        }
    }

    private static int b(int i) {
        if (i != 1) {
            if (i != 2) {
                return (i == 4 || i == 5) ? 1 : 0;
            }
            return -1;
        }
        return -2;
    }
}

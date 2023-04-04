package cn.jpush.android.p;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.PushNotificationBuilder;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.h;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.p.a;
import cn.jpush.android.p.d;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.UUID;
import java.util.zip.Adler32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f4418a;

    /* loaded from: classes.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f4419a;

        /* renamed from: b  reason: collision with root package name */
        private cn.jpush.android.d.d f4420b;

        public a(Context context, cn.jpush.android.d.d dVar) {
            this.f4419a = context;
            this.f4420b = dVar;
        }

        public static void a(Context context, cn.jpush.android.d.d dVar) {
            b.j(context, dVar);
            if (dVar.R != 0 && dVar.R != 4) {
                b.i(context, dVar);
                return;
            }
            cn.jpush.android.helper.c.a(dVar.f4312c, 995, context);
            b.h(context, dVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long b2 = cn.jpush.android.u.b.b(this.f4420b.aj);
                long b3 = cn.jpush.android.u.b.b(this.f4420b.ak);
                if (b2 > 0 && b2 == b3) {
                    Logger.ww("NotificationHelper", "the beginTime == endTime,not deal this notification");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (b3 > 0) {
                    if (b3 < b2) {
                        Logger.e("NotificationHelper", "illegal argument, endTime earlier than beginTime");
                        return;
                    } else if (b3 < currentTimeMillis) {
                        Logger.w("NotificationHelper", this.f4420b.f4312c + " already end");
                        cn.jpush.android.helper.c.a(this.f4420b.f4312c, 1034, this.f4419a);
                        return;
                    }
                }
                if (b2 >= currentTimeMillis) {
                    d.a().a(this.f4419a, new d.a(b2, this.f4420b));
                    cn.jpush.android.helper.c.a(this.f4420b.f4312c, 1035, this.f4419a);
                    return;
                }
                a(this.f4419a, this.f4420b);
                if (b3 > 0) {
                    d.a().a(this.f4419a, new d.a(b3, b.a(this.f4420b)));
                }
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "run NotifyAction failed:" + th.getMessage());
            }
        }
    }

    private static int a(int i) {
        if (i != 0) {
            if (i != 1) {
                return i != 2 ? 1 : 32;
            }
            return 16;
        }
        return 1;
    }

    public static int a(cn.jpush.android.d.d dVar) {
        return a(TextUtils.isEmpty(dVar.f) ? dVar.f4312c : dVar.f);
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "action:getNotificationID - empty messageId");
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            Logger.w("NotificationHelper", "Ths msgId is not a integer");
            Adler32 adler32 = new Adler32();
            adler32.update(str.getBytes());
            int value = (int) adler32.getValue();
            return value < 0 ? Math.abs(value) : value;
        }
    }

    static Notification a(Notification.Builder builder) {
        try {
            return Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "Build notification error:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Notification a(Context context, cn.jpush.android.d.d dVar, RemoteViews remoteViews, boolean z, c cVar, c cVar2) {
        StringBuilder sb;
        String str;
        a.C0080a c0080a = new a.C0080a(dVar.D, "", dVar.z, dVar.C, dVar.ai);
        cn.jpush.android.p.a.a(context, c0080a);
        if (Build.VERSION.SDK_INT < 11) {
            Notification notification = new Notification(f.a(context), dVar.u, System.currentTimeMillis());
            a(notification, c0080a);
            if (dVar.s == null) {
                dVar.s = context.getApplicationInfo().name;
            }
            if (remoteViews != null) {
                notification.contentView = remoteViews;
            } else {
                a(notification, context, dVar.s, dVar.u, (PendingIntent) null);
            }
            return notification;
        }
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(dVar.s).setContentText(dVar.u).setTicker(dVar.u);
        if (z && Build.VERSION.SDK_INT >= 20) {
            builder.setGroupSummary(false);
            builder.setGroup("group");
        }
        if (z) {
            builder.setSmallIcon(17170445);
            if (h.b() == -1) {
                int a2 = cVar2.a();
                if (a2 == 102) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        builder.setLargeIcon((Icon) cVar2.b());
                    }
                } else if (a2 == 100) {
                    builder.setLargeIcon(cVar2.c());
                } else {
                    Logger.d("NotificationHelper", "not set large icon");
                }
            }
        } else {
            a(JPushConstants.mApplicationContext, builder, cVar, cVar2);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            builder.setShowWhen(true);
        }
        a(builder, c0080a);
        if (Build.VERSION.SDK_INT >= 16) {
            if (remoteViews == null) {
                if (dVar.v == 1 && !TextUtils.isEmpty(dVar.w)) {
                    Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                    bigTextStyle.bigText(dVar.w);
                    builder.setStyle(bigTextStyle);
                }
                if (dVar.v == 2 && !TextUtils.isEmpty(dVar.y)) {
                    Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                    try {
                        TreeMap treeMap = new TreeMap();
                        JSONObject jSONObject = new JSONObject(dVar.y);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            treeMap.put(next, jSONObject.optString(next));
                        }
                        for (String str2 : treeMap.values()) {
                            inboxStyle.addLine(str2);
                        }
                        inboxStyle.setSummaryText(" + " + jSONObject.length() + " new messages");
                    } catch (Throwable th) {
                        Logger.ee("NotificationHelper", "Set inbox style error: " + th.getMessage());
                    }
                    builder.setStyle(inboxStyle);
                }
                if (dVar.v == 3 && !TextUtils.isEmpty(dVar.x)) {
                    Logger.i("NotificationHelper", "Set notification BPS with picture path:" + dVar.x);
                    try {
                        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                        bigPictureStyle.bigPicture(BitmapFactory.decodeFile(dVar.x));
                        builder.setStyle(bigPictureStyle);
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        sb = new StringBuilder();
                        str = "Create bitmap failed caused by OutOfMemoryError.error:";
                        sb.append(str);
                        sb.append(e);
                        Logger.ww("NotificationHelper", sb.toString());
                        if (!TextUtils.isEmpty(dVar.A)) {
                            builder.setCategory(dVar.A);
                        }
                        if (remoteViews != null) {
                        }
                        return a(builder);
                    } catch (Throwable th2) {
                        e = th2;
                        sb = new StringBuilder();
                        str = "Create big picture style failed. error:";
                        sb.append(str);
                        sb.append(e);
                        Logger.ww("NotificationHelper", sb.toString());
                        if (!TextUtils.isEmpty(dVar.A)) {
                        }
                        if (remoteViews != null) {
                        }
                        return a(builder);
                    }
                }
            }
            if (!TextUtils.isEmpty(dVar.A) && Build.VERSION.SDK_INT >= 21) {
                builder.setCategory(dVar.A);
            }
        }
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        }
        return a(builder);
    }

    public static Intent a(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PushActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        if (!cn.jpush.android.u.a.h(context) && Build.VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        return intent;
    }

    public static Uri a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (context.getResources().getIdentifier(str, "raw", context.getPackageName()) == 0) {
                Logger.d("NotificationHelper", "not found sound=" + str);
                return null;
            }
            Uri parse = Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
            StringBuilder sb = new StringBuilder();
            sb.append("found sound uri=");
            sb.append(parse);
            Logger.d("NotificationHelper", sb.toString());
            return parse;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "find sound e:" + th);
            return null;
        }
    }

    private static PushNotificationBuilder a(Context context, NotificationMessage notificationMessage) {
        try {
            Class<?> cls = Class.forName("cn.jpush.android.support.JPushSupport");
            return (PushNotificationBuilder) cls.getDeclaredMethod("getNotificationBuilder", Context.class, NotificationMessage.class).invoke(cls, context, notificationMessage);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static cn.jpush.android.d.d a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("msg_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return cn.jpush.android.d.d.a(stringExtra);
    }

    public static c a(Context context, String str, String str2, String str3, String str4) {
        Icon b2;
        c cVar = new c();
        String str5 = "";
        int i = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                Logger.d("NotificationHelper", "source is empty,need not diy small icon");
            } else if (!TextUtils.isEmpty(str3)) {
                if (cn.jpush.android.u.a.a(str3)) {
                    str5 = f(JPushConstants.mApplicationContext, str3);
                } else {
                    i = JPushConstants.mApplicationContext.getResources().getIdentifier(str3, "drawable", JPushConstants.mApplicationContext.getPackageName());
                }
            }
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "load small icon failed:" + th.getMessage());
        }
        if (!TextUtils.isEmpty(str5)) {
            try {
                Bitmap decodeFile = cn.jpush.android.u.c.a(str5) ? BitmapFactory.decodeFile(str5) : null;
                if (decodeFile != null) {
                    Logger.d("NotificationHelper", "set small icon with path bitmap:" + decodeFile);
                    cVar.a(100);
                    cVar.a(decodeFile);
                    return cVar;
                }
                Logger.d("NotificationHelper", "not set small icon by bitmap");
                if (Build.VERSION.SDK_INT >= 23 && (b2 = b(str5)) != null) {
                    Logger.d("NotificationHelper", "set small icon success by path:" + str5);
                    cVar.a(102);
                    cVar.a(b2);
                    return cVar;
                }
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with sdcard path");
            }
        }
        if (i != 0) {
            cVar.a(101);
            cVar.b(i);
            Logger.d("NotificationHelper", "set small icon success by resId:" + i + ",resName:" + str3);
            return cVar;
        } else if (TextUtils.isEmpty(str2) || str2.equals(context.getPackageName())) {
            int a2 = f.a(context);
            if (a2 == 0) {
                cVar.c(972);
                return cVar;
            }
            cVar.a(101);
            cVar.b(a2);
            Logger.d("NotificationHelper", "set small icon success by mine icon resId:" + a2);
            return cVar;
        } else {
            try {
                if (!cn.jpush.android.u.a.c(context, str2)) {
                    Logger.w("NotificationHelper", "targetApp ：" + str2 + " is not install,will give up notify the msg");
                    cVar.c(993);
                    return cVar;
                }
                Bitmap e2 = e(context, str2);
                if (e2 == null) {
                    Logger.w("NotificationHelper", "not found targetApp small icon bitmap,will give up notify the msg");
                    cVar.c(972);
                    return cVar;
                }
                cVar.a(100);
                cVar.a(e2);
                Logger.d("NotificationHelper", "set small icon success by targetAppBitmap");
                return cVar;
            } catch (Throwable th2) {
                Logger.w("NotificationHelper", "set small icon by targetApp icon bitmap failed:" + th2.getMessage());
                cVar.c(972);
                return cVar;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x049d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0387  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object a(Context context, cn.jpush.android.d.d dVar, c cVar, c cVar2) {
        int i;
        String str;
        String str2;
        int i2;
        int i3;
        String str3;
        int i4;
        String str4;
        boolean z;
        boolean z2;
        int a2;
        boolean z3;
        String str5;
        boolean z4;
        JSONObject jSONObject;
        if (Build.VERSION.SDK_INT >= 11) {
            cn.jpush.android.helper.e.a(JPushConstants.mApplicationContext);
        }
        Context appContext = JPushConstants.getAppContext(context);
        int identifier = appContext.getResources().getIdentifier("push_notification", "layout", appContext.getPackageName());
        Logger.d("NotificationHelper", "layoutId:" + identifier);
        if (identifier <= 0) {
            return null;
        }
        int identifier2 = appContext.getResources().getIdentifier(ak.aE, "id", appContext.getPackageName());
        int identifier3 = appContext.getResources().getIdentifier("v21", "id", appContext.getPackageName());
        Logger.d("NotificationHelper", "targetVersion:" + Build.VERSION.SDK_INT + ",vId:" + identifier2 + ",v21Id:" + identifier3);
        if (Build.VERSION.SDK_INT < 29 || identifier3 > 0) {
            boolean z5 = Build.VERSION.SDK_INT < 21 || identifier3 <= 0;
            int identifier4 = appContext.getResources().getIdentifier("push_root_view", "id", appContext.getPackageName());
            int b2 = h.b();
            int identifier5 = appContext.getResources().getIdentifier("push_notification_style_default", "id", appContext.getPackageName());
            if (b2 != 0) {
                i = appContext.getResources().getIdentifier("push_notification_style_" + b2, "id", appContext.getPackageName());
                if (i <= 0) {
                    Logger.ww("NotificationHelper", "not found push_notification_style_" + b2 + " in layout");
                    return null;
                }
            } else {
                i = 0;
            }
            if (b2 == 0) {
                str = "";
            } else {
                str = "style_" + b2 + "_";
            }
            int identifier6 = appContext.getResources().getIdentifier("push_notification_" + str + "title", "id", appContext.getPackageName());
            Resources resources = appContext.getResources();
            StringBuilder sb = new StringBuilder();
            sb.append("push_notification_");
            sb.append(str);
            String str6 = "";
            sb.append("content");
            int identifier7 = resources.getIdentifier(sb.toString(), "id", appContext.getPackageName());
            int identifier8 = appContext.getResources().getIdentifier("push_notification_" + str + "big_icon", "id", appContext.getPackageName());
            int identifier9 = appContext.getResources().getIdentifier("push_notification_" + str + "date", "id", appContext.getPackageName());
            int identifier10 = appContext.getResources().getIdentifier("push_notification_content_one_line", "id", appContext.getPackageName());
            boolean z6 = z5;
            int identifier11 = appContext.getResources().getIdentifier("push_notification_sub_title", "id", appContext.getPackageName());
            int i5 = i;
            int identifier12 = appContext.getResources().getIdentifier("push_notification_dot", "id", appContext.getPackageName());
            int identifier13 = appContext.getResources().getIdentifier("push_notification_small_icon", "id", appContext.getPackageName());
            if (b2 == 0) {
                str2 = "NotificationHelper";
                Logger.d(str2, "buildDiyLayout layoutId:" + identifier + ",defaultStyleId:" + identifier5 + ",largeId:" + identifier8 + ",appNameId:" + identifier6 + ",contentId:" + identifier7 + ",smallId:" + identifier13 + ",dateId:" + identifier9 + ",dotId:" + identifier12 + ",titleId:" + identifier11 + ",oneLinecontentId:" + identifier10);
                if (identifier <= 0 || identifier4 <= 0 || identifier5 <= 0 || identifier6 <= 0 || identifier7 <= 0 || identifier8 <= 0 || identifier13 <= 0 || identifier9 <= 0 || identifier12 <= 0 || identifier11 <= 0 || identifier10 <= 0) {
                    Logger.ww(str2, "not found valid push_notification in layout");
                    return null;
                }
                i2 = identifier13;
                i3 = i5;
            } else {
                str2 = "NotificationHelper";
                i2 = identifier13;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("buildDiyLayout layoutId:");
                sb2.append(identifier);
                sb2.append(",useStyleId:");
                i3 = i5;
                sb2.append(i3);
                sb2.append(",appNameId:");
                sb2.append(identifier6);
                sb2.append(",contentId:");
                sb2.append(identifier7);
                sb2.append(",largeId:");
                sb2.append(identifier8);
                sb2.append(",dateId:");
                sb2.append(identifier9);
                Logger.d(str2, sb2.toString());
                if (identifier <= 0 || identifier4 <= 0 || i3 <= 0 || identifier6 <= 0 || identifier7 <= 0 || identifier8 <= 0 || identifier9 <= 0) {
                    Logger.ww(str2, "not found valid push_notification in layout");
                    return null;
                }
            }
            RemoteViews remoteViews = new RemoteViews(appContext.getPackageName(), identifier);
            if (z6) {
                try {
                    int a3 = cn.jpush.android.helper.e.a();
                    int b3 = cn.jpush.android.helper.e.b();
                    remoteViews.setTextColor(identifier6, a3);
                    if (b2 == 0) {
                        remoteViews.setTextColor(identifier9, b3);
                        remoteViews.setTextColor(identifier12, a3);
                        remoteViews.setTextColor(identifier11, a3);
                    } else {
                        remoteViews.setTextColor(identifier9, b3);
                    }
                    remoteViews.setTextColor(identifier10, b3);
                    remoteViews.setTextColor(identifier7, b3);
                } catch (Throwable th) {
                    Logger.d(str2, "set diy color error:" + th.getMessage());
                }
            }
            float d2 = cn.jpush.android.helper.e.d();
            if (d2 != -1.0f && Build.VERSION.SDK_INT >= 16) {
                remoteViews.setTextViewTextSize(identifier7, 0, d2);
                remoteViews.setTextViewTextSize(identifier10, 0, d2);
            }
            String str7 = dVar.t;
            try {
                jSONObject = new JSONObject(dVar.B);
                str3 = jSONObject.optString("ssp_appname");
            } catch (Throwable unused) {
            }
            try {
                i4 = jSONObject.optInt("ssp_use_title");
            } catch (Throwable unused2) {
                str6 = str3;
                str3 = str6;
                i4 = 0;
                if (TextUtils.isEmpty(str7)) {
                    str7 = str3;
                }
                if (b2 != 0) {
                }
                remoteViews.setTextViewText(identifier7, dVar.u);
                remoteViews.setTextViewText(identifier9, new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(System.currentTimeMillis())));
                Logger.d(str2, "notificationStyle:" + b2 + ",noUseLargeIcon:" + z2);
                if (b2 != 0) {
                }
                a2 = cVar.a();
                if (a2 != 102) {
                }
                if (z2) {
                }
            }
            if (TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str3)) {
                str7 = str3;
            }
            if (b2 != 0) {
                remoteViews.setViewVisibility(identifier5, 0);
                if (TextUtils.isEmpty(str7)) {
                    remoteViews.setTextViewText(identifier6, dVar.s);
                    remoteViews.setViewVisibility(identifier11, 8);
                    z2 = false;
                } else if (appContext.getApplicationInfo().targetSdkVersion >= 24) {
                    remoteViews.setTextViewText(identifier6, str7);
                    remoteViews.setTextViewText(identifier11, dVar.s);
                    z2 = false;
                    remoteViews.setViewVisibility(identifier11, 0);
                    if (h.c()) {
                        remoteViews.setViewVisibility(identifier7, 8);
                        remoteViews.setTextViewText(identifier10, dVar.u);
                        remoteViews.setViewVisibility(identifier10, 0);
                    }
                    float c2 = cn.jpush.android.helper.e.c();
                    if (c2 != -1.0f && Build.VERSION.SDK_INT >= 16) {
                        remoteViews.setTextViewTextSize(identifier11, 0, c2);
                    }
                } else {
                    z2 = false;
                    remoteViews.setTextViewText(identifier6, dVar.s);
                    remoteViews.setViewVisibility(identifier11, 8);
                }
            } else {
                remoteViews.setViewVisibility(identifier5, 8);
                remoteViews.setViewVisibility(i3, 0);
                if (TextUtils.isEmpty(str7) || i4 == 1) {
                    str4 = dVar.s;
                    z = false;
                } else {
                    str4 = str7;
                    z = true;
                }
                remoteViews.setTextViewText(identifier6, str4);
                float c3 = cn.jpush.android.helper.e.c();
                if (c3 != -1.0f && Build.VERSION.SDK_INT >= 16) {
                    remoteViews.setTextViewTextSize(identifier6, 0, c3);
                }
                z2 = z;
            }
            remoteViews.setTextViewText(identifier7, dVar.u);
            remoteViews.setTextViewText(identifier9, new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(System.currentTimeMillis())));
            Logger.d(str2, "notificationStyle:" + b2 + ",noUseLargeIcon:" + z2);
            if (b2 != 0 || z2) {
                a2 = cVar.a();
                if (a2 != 102) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (b2 == 0) {
                            remoteViews.setImageViewIcon(i2, (Icon) cVar.b());
                        }
                        if (z2) {
                            remoteViews.setImageViewIcon(identifier8, (Icon) cVar.b());
                        }
                        str5 = "diy set small icon by icon obj";
                        Logger.d(str2, str5);
                        z4 = true;
                        if (!z4) {
                            cn.jpush.android.helper.c.a(dVar.f4312c, 972, appContext);
                            return 1;
                        }
                    }
                    z4 = false;
                    if (!z4) {
                    }
                } else {
                    int i6 = i2;
                    if (a2 == 100) {
                        if (b2 == 0) {
                            remoteViews.setImageViewBitmap(i6, cVar.c());
                        }
                        if (z2) {
                            remoteViews.setImageViewBitmap(identifier8, cVar.c());
                        }
                        str5 = "diy set small icon by bitmap";
                        Logger.d(str2, str5);
                        z4 = true;
                        if (!z4) {
                        }
                    } else {
                        if (a2 == 101) {
                            try {
                                appContext.getResources().getDrawable(cVar.d());
                                z3 = true;
                            } catch (Throwable unused3) {
                                Logger.w(str2, "diy resource not found with local app");
                                z3 = false;
                            }
                            if (z3) {
                                Logger.d(str2, "diy set small icon by local resId:" + cVar.d());
                                if (b2 == 0) {
                                    remoteViews.setImageViewResource(i6, cVar.d());
                                }
                                if (z2) {
                                    remoteViews.setImageViewResource(identifier8, cVar.d());
                                }
                                z4 = true;
                                if (!z4) {
                                }
                            }
                        }
                        z4 = false;
                        if (!z4) {
                        }
                    }
                }
            }
            if (z2) {
                int a4 = cVar2.a();
                if (a4 == 102) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        remoteViews.setImageViewIcon(identifier8, (Icon) cVar2.b());
                    }
                } else if (a4 == 100) {
                    remoteViews.setImageViewBitmap(identifier8, cVar2.c());
                } else {
                    Logger.d(str2, "diy not set large icon");
                    if (b2 == 1) {
                        cn.jpush.android.helper.c.a(dVar.f4312c, 973, appContext);
                        return 2;
                    }
                }
                return remoteViews;
            }
            return remoteViews;
        }
        return null;
    }

    private static String a(Context context, String str, String str2) {
        if (!str.endsWith(".jpg") && !str.endsWith(".png")) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String str3 = cn.jpush.android.u.c.c(context, str2) + (str2 + str.substring(str.lastIndexOf(".")));
        Logger.i("NotificationHelper", "Big picture notification resource path: " + str3);
        byte[] a2 = cn.jpush.android.o.a.a(str, 5, 5000L, 4);
        return (a2 == null || !cn.jpush.android.u.c.a(str3, a2)) ? "" : str3;
    }

    public static void a(Notification.Builder builder, a.C0080a c0080a) {
        if (c0080a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26 && c0080a.h) {
                    Logger.d("NotificationHelper", "setChannelId =" + c0080a.f4413a);
                    builder.setChannelId(c0080a.f4413a);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    builder.setPriority(c0080a.f4415c);
                    builder.setDefaults(c0080a.f4417e);
                    builder.setSound(c0080a.g);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Notification notification, Context context, String str, String str2, PendingIntent pendingIntent) {
        try {
            Class.forName("android.app.Notification").getDeclaredMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, str, str2, pendingIntent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Notification notification, a.C0080a c0080a) {
        if (c0080a != null) {
            try {
                if (Build.VERSION.SDK_INT < 16) {
                    notification.defaults = c0080a.f4417e;
                    notification.sound = c0080a.g;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        while (true) {
            Integer valueOf = Integer.valueOf(e.a());
            if (valueOf.intValue() == 0) {
                return;
            }
            c(context, valueOf.intValue());
        }
    }

    public static void a(Context context, int i) {
        int a2;
        if (!e.b(i)) {
            e.a(i);
        }
        Logger.d("NotificationHelper", "queueSize:" + e.b() + ",max num:" + cn.jpush.android.cache.a.h(context));
        if (e.b() <= cn.jpush.android.cache.a.h(context) || (a2 = e.a()) == 0) {
            return;
        }
        c(context, a2);
    }

    public static void a(Context context, int i, int i2, String str) {
        a(context, i, i2, str, (Bundle) null);
    }

    public static void a(Context context, int i, int i2, String str, Bundle bundle) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(context, messageReceiverClass);
            intent.setAction(cn.jpush.android.u.a.e(context, "cmd_msg"));
            intent.putExtra("cmd", i);
            intent.putExtra(JThirdPlatFormInterface.KEY_CODE, i2);
            intent.putExtra("message", str);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (JPushConstants.getPushMessageReceiver(context) != null) {
                cn.jpush.android.helper.a.a(JPushConstants.getPushMessageReceiver(context), context, intent);
            } else {
                context.sendBroadcast(intent);
            }
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "sendCmdMsgToUser failed:" + th.getMessage());
        }
    }

    public static void a(Context context, int i, boolean z) {
        try {
            boolean z2 = true;
            if (e(context) != 1) {
                z2 = false;
            }
            Logger.d("NotificationHelper", "[checkNotificationSettings] new state:" + z2 + ",last state:" + f4418a + ",soucre:" + i + ",isFocre:" + z);
            if (f4418a != null && z2 == f4418a.booleanValue() && !z) {
                Logger.d("NotificationHelper", "[checkNotificationSettings] no change");
                return;
            }
            f4418a = Boolean.valueOf(z2);
            JPushMessageReceiver pushMessageReceiver = JPushConstants.getPushMessageReceiver(context);
            if (pushMessageReceiver != null) {
                pushMessageReceiver.onNotificationSettingsCheck(context, f4418a.booleanValue(), i);
                return;
            }
            Intent intent = new Intent(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
            intent.setAction("on_noti_settings_check");
            intent.putExtra("isOn", f4418a);
            intent.putExtra("source", i);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "checkNotificationSettings e:" + th);
        }
    }

    public static void a(Context context, cn.jpush.android.d.d dVar) {
        Logger.d("NotificationHelper", "[processMessage] pushEntity:" + dVar);
        if (dVar.S == 0) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 12, null, null, new a(context, dVar));
            return;
        }
        Logger.d("NotificationHelper", "Unexpected: unknown show  mode - " + dVar.S);
    }

    public static void a(Context context, Integer num, Notification notification) {
        if (num == null) {
            return;
        }
        Key<Integer> BadgeCurNum = Key.BadgeCurNum();
        int intValue = ((Integer) Sp.get(context, BadgeCurNum)).intValue();
        if (intValue < 0) {
            intValue = 0;
        }
        if (num.intValue() != 0) {
            if (num.intValue() + intValue < 0) {
                num = Integer.valueOf(-intValue);
            }
            intValue += num.intValue();
            Sp.set(context, BadgeCurNum.set(Integer.valueOf(intValue)));
        }
        Logger.d("NotificationHelper", "curNum：" + intValue + ",addNum:" + num);
        a(context, notification, num.intValue(), intValue);
    }

    public static void a(Context context, String str, cn.jpush.android.d.d dVar, Intent intent) {
        try {
            Intent intent2 = new Intent(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
            if (intent != null) {
                String string = intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA);
                if (!TextUtils.isEmpty(string)) {
                    intent2.putExtra(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA, string);
                }
            }
            intent2.setAction(str);
            if (dVar != null) {
                intent2.putExtra("msg_data", dVar.c());
            }
            if (JPushConstants.getPushMessageReceiver(context) != null) {
                if (str.equals(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION_PROXY)) {
                    intent2.setAction(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
                    JPushConstants.getPushMessageReceiver(context).onMultiActionClicked(context, intent2);
                    return;
                }
                NotificationMessage b2 = dVar.b();
                if (TextUtils.isEmpty(b2.appkey)) {
                    b2.appkey = JCoreHelper.getAppKey(context);
                }
                if (str.equals("cn.jpush.android.intent.NOTIFICATION_ARRIVED")) {
                    JPushConstants.getPushMessageReceiver(context).onNotifyMessageArrived(context, b2);
                    return;
                } else if (str.equals("cn.jpush.android.intent.NOTIFICATION_DISMISS")) {
                    JPushConstants.getPushMessageReceiver(context).onNotifyMessageDismiss(context, b2);
                    return;
                } else if (str.equals(JPushInterface.ACTION_NOTIFICATION_OPENED)) {
                    JPushConstants.getPushMessageReceiver(context).onNotifyMessageOpened(context, b2);
                    return;
                }
            }
            context.sendBroadcast(intent2);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "sendToUserReceiver failed:" + th.getMessage());
        }
    }

    public static void a(Context context, List<String> list) {
        try {
            JSONArray b2 = b(context);
            JSONArray jSONArray = new JSONArray();
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < b2.length(); i++) {
                JSONObject jSONObject = b2.getJSONObject(i);
                String string = jSONObject.getString("id");
                if (list != null && list.remove(string)) {
                    jSONObject.put("time", currentTimeMillis);
                }
                if (currentTimeMillis < jSONObject.getLong("time") + 86400000) {
                    jSONArray.put(jSONObject);
                }
            }
            if (list != null) {
                for (String str : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("time", currentTimeMillis);
                    jSONObject2.put("id", str);
                    jSONArray.put(jSONObject2);
                }
            }
            String jSONArray2 = jSONArray.length() > 0 ? jSONArray.toString() : null;
            Logger.d("NotificationHelper", "saveString=" + jSONArray2);
            Sp.set(context, Key.NotiCancel().set(jSONArray2));
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "save NotiCancel e:" + th);
        }
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                Logger.i("NotificationHelper", "get EMUI version is:" + str);
                return cn.jpush.android.u.a.a(str.toLowerCase().replace("emotionui_", ""), "8.0") >= 0;
            }
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " getEmuiVersion wrong error:" + th);
        }
        return false;
    }

    private static boolean a(Notification notification, int i) {
        if (notification != null) {
            try {
                Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean a(Context context, Notification.Builder builder, c cVar, c cVar2) {
        boolean z;
        boolean z2;
        int a2 = cVar.a();
        if (a2 != 102 || Build.VERSION.SDK_INT < 23) {
            z = false;
        } else {
            builder.setSmallIcon((Icon) cVar.b());
            z = true;
        }
        if (!z && a2 == 100 && Build.VERSION.SDK_INT >= 23) {
            builder.setSmallIcon(Icon.createWithBitmap(cVar.c()));
            z = true;
        }
        if (!z && a2 == 101) {
            try {
                context.getResources().getDrawable(cVar.d());
                z2 = true;
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with local app");
                z2 = false;
            }
            if (z2) {
                Logger.d("NotificationHelper", "set small icon by local resId:" + cVar.d());
                builder.setSmallIcon(Integer.valueOf(cVar.d()).intValue());
                z = true;
            }
        }
        if (z) {
            int a3 = cVar2.a();
            if (a3 == 102) {
                if (Build.VERSION.SDK_INT >= 23) {
                    builder.setLargeIcon((Icon) cVar2.b());
                }
            } else if (a3 == 100) {
                builder.setLargeIcon(cVar2.c());
            } else {
                Logger.d("NotificationHelper", "not set large icon");
            }
            return true;
        }
        return false;
    }

    public static boolean a(Context context, Notification notification, int i, int i2) {
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            return a(notification, i);
        }
        if (!a()) {
            Logger.d("NotificationHelper", "not support");
            return false;
        } else if (i2 == 0 || i != 0) {
            return d(context, i2);
        } else {
            return false;
        }
    }

    public static Intent b(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PopWinActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    private static Icon b(String str) {
        try {
            if (new File(str).exists()) {
                return Icon.createWithFilePath(str);
            }
            Logger.w("NotificationHelper", "icon file doesn't exist, path=" + str);
            return null;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "createIcon err:" + th);
            return null;
        }
    }

    public static NotificationMessage b(Context context, Intent intent) {
        NotificationMessage b2 = a(context, intent).b();
        if (TextUtils.isEmpty(b2.appkey)) {
            b2.appkey = JCoreHelper.getAppKey(context);
        }
        return b2;
    }

    public static c b(Context context, String str) {
        c cVar = new c();
        Object c2 = c(context, str);
        if (c2 == null) {
            cVar.c(973);
            return cVar;
        }
        if (Build.VERSION.SDK_INT >= 23 && (c2 instanceof Icon)) {
            cVar.a(102);
            cVar.a(c2);
        } else if (!(c2 instanceof Bitmap)) {
            cVar.c(973);
            return cVar;
        } else {
            cVar.a(100);
            cVar.a((Bitmap) c2);
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray b(Context context) {
        JSONArray jSONArray;
        String str = (String) Sp.get(context, Key.NotiCancel());
        if (!TextUtils.isEmpty(str)) {
            try {
                Logger.d("NotificationHelper", "read=" + str);
                jSONArray = new JSONArray(str);
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "read NotiCancel e:" + th);
            }
            return jSONArray == null ? jSONArray : new JSONArray();
        }
        jSONArray = null;
        if (jSONArray == null) {
        }
    }

    public static void b(Context context, int i) {
        if (i <= 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            Integer valueOf = Integer.valueOf(e.a());
            if (valueOf.intValue() != 0) {
                c(context, valueOf.intValue());
            }
        }
    }

    public static void b(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            c(context, a(dVar));
        }
    }

    private static Intent c(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, JNotifyActivity.class);
        intent.setFlags(1073741824);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009e A[Catch: all -> 0x00eb, TryCatch #1 {all -> 0x00eb, blocks: (B:17:0x0055, B:18:0x006e, B:27:0x009e, B:30:0x00a6, B:31:0x00bb, B:41:0x00e4, B:32:0x00bf, B:34:0x00c5, B:36:0x00cb, B:19:0x0072, B:21:0x0078, B:23:0x0083), top: B:50:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object c(Context context, String str) {
        Bitmap bitmap;
        String str2;
        String str3;
        Icon icon;
        String str4;
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "large icon is empty");
            return null;
        }
        String str5 = "";
        int i = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (cn.jpush.android.u.a.a(str)) {
                    str5 = f(JPushConstants.mApplicationContext, str);
                } else {
                    i = JPushConstants.mApplicationContext.getResources().getIdentifier(str, "drawable", JPushConstants.mApplicationContext.getPackageName());
                }
            }
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "load large icon failed:" + th.getMessage());
        }
        try {
            if (i != 0) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), i);
                str2 = "set large icon with res bitmap:" + i;
            } else if (TextUtils.isEmpty(str5) || !new File(str5).exists()) {
                bitmap = null;
                if (bitmap == null) {
                    return bitmap;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    if (i != 0) {
                        icon = Icon.createWithResource(context, i);
                        str4 = "set large icon with res:" + i;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            icon = null;
                        } else {
                            icon = b(str5);
                            if (icon != null) {
                                str4 = "set large icon with path:" + str5;
                            }
                        }
                        if (icon == null) {
                            return icon;
                        }
                        str3 = "not set large icon";
                    }
                    Logger.d("NotificationHelper", str4);
                    if (icon == null) {
                    }
                } else {
                    str3 = "not set large icon by bitmap";
                }
                Logger.d("NotificationHelper", str3);
                return null;
            } else {
                bitmap = BitmapFactory.decodeFile(str5);
                str2 = "set large icon with path bitmap:" + str5;
            }
            Logger.d("NotificationHelper", str2);
            if (bitmap == null) {
            }
        } catch (Throwable th2) {
            Logger.w("NotificationHelper", "setLargeIcon failed:" + th2.getMessage());
            return null;
        }
    }

    public static void c(Context context, int i) {
        try {
            Logger.d("NotificationHelper", "action:cleanNotification - notificationId:" + i);
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "cancelNotification failed:" + th.getMessage());
        }
    }

    public static boolean c(Context context) {
        try {
            if (!cn.jpush.android.cache.a.e(context)) {
                Logger.ii("NotificationHelper", "Notification was disabled by JPushInterface.setPushTime !");
                return false;
            }
            String f = cn.jpush.android.cache.a.f(context);
            if (TextUtils.isEmpty(f)) {
                Logger.i("NotificationHelper", "no time limited");
                return true;
            }
            Logger.i("NotificationHelper", "push time is ：" + f);
            String[] split = f.split("_");
            String str = split[0];
            String str2 = split[1];
            char[] charArray = str.toCharArray();
            String[] split2 = str2.split("\\^");
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(7);
            int i2 = calendar.get(11);
            for (char c2 : charArray) {
                if (i == Integer.valueOf(String.valueOf(c2)).intValue() + 1) {
                    int intValue = Integer.valueOf(split2[0]).intValue();
                    int intValue2 = Integer.valueOf(split2[1]).intValue();
                    if (i2 >= intValue && i2 <= intValue2) {
                        return true;
                    }
                }
            }
            Logger.ii("NotificationHelper", "Current time is out of the push time - " + f);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean c(Context context, cn.jpush.android.d.d dVar) {
        try {
            JSONArray b2 = b(context);
            if (b2 != null && b2.length() != 0) {
                JSONArray jSONArray = new JSONArray();
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = false;
                for (int i = 0; i < b2.length(); i++) {
                    JSONObject jSONObject = b2.getJSONObject(i);
                    if (currentTimeMillis < jSONObject.getLong("time") + 86400000) {
                        jSONArray.put(jSONObject);
                        if (!z) {
                            String string = jSONObject.getString("id");
                            if (!TextUtils.isEmpty(dVar.f4312c) && dVar.f4312c.equals(string)) {
                                cn.jpush.android.helper.c.a(dVar.f4312c, 1032, context);
                            } else if (!TextUtils.isEmpty(dVar.f) && dVar.f.equals(string)) {
                                cn.jpush.android.helper.c.a(dVar.f4312c, 1033, context);
                            }
                            z = true;
                        }
                    }
                }
                if (jSONArray.length() != b2.length()) {
                    String jSONArray2 = jSONArray.length() > 0 ? jSONArray.toString() : null;
                    Logger.d("NotificationHelper", "saveString when check=" + jSONArray2);
                    Sp.set(context, Key.NotiCancel().set(jSONArray2));
                }
                return z;
            }
            return false;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "isAlreadyCancel e:" + th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x012d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(Context context, cn.jpush.android.d.d dVar) {
        String str;
        String str2;
        if (dVar == null || TextUtils.isEmpty(dVar.H) || !(TextUtils.isEmpty(dVar.E) || dVar.E.equals("ssp"))) {
            Logger.d("NotificationHelper", "is not deep link notification");
            return 0;
        }
        if (TextUtils.isEmpty(dVar.E) && TextUtils.isEmpty(dVar.K)) {
            Logger.d("NotificationHelper", "source is empty and targetPkgName is empty,will use mine pkgname replace targetPkgName");
            dVar.K = context.getPackageName();
        }
        try {
            Logger.d("NotificationHelper", "open deeplink notification,source:" + dVar.E + ",targetPkg:" + dVar.K);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "url failed:" + th.getMessage());
        }
        if (TextUtils.isEmpty(dVar.K)) {
            if (g(context, dVar.H)) {
                str2 = dVar.f4312c;
                cn.jpush.android.helper.c.a(str2, 976, context);
                return TextUtils.isEmpty(dVar.E) ? 1 : 2;
            }
            str = dVar.f4312c;
            cn.jpush.android.helper.c.a(str, 977, context);
            if (TextUtils.isEmpty(dVar.E)) {
            }
        } else if (!cn.jpush.android.u.a.c(context, dVar.K)) {
            cn.jpush.android.helper.c.a(dVar.f4312c, 988, context);
            Logger.d("NotificationHelper", "app not installed,fail_handle_type:" + dVar.I + ",fail_handle_url:" + dVar.J);
            int i = dVar.I;
            if (i == 0) {
                Intent f = cn.jpush.android.u.a.f(context);
                if (f != null) {
                    context.startActivity(f);
                }
            } else if (i == 1 || i == 2) {
                if (TextUtils.isEmpty(dVar.J)) {
                    Logger.d("NotificationHelper", "fail_handle_url is empty");
                } else if (g(context, dVar.J)) {
                    cn.jpush.android.helper.c.a(dVar.f4312c, 978, context);
                } else {
                    cn.jpush.android.helper.c.a(dVar.f4312c, 979, context);
                }
            }
            if (TextUtils.isEmpty(dVar.E)) {
            }
        } else if (g(context, dVar.H)) {
            str2 = dVar.f4312c;
            cn.jpush.android.helper.c.a(str2, 976, context);
            if (TextUtils.isEmpty(dVar.E)) {
            }
        } else {
            str = dVar.f4312c;
            cn.jpush.android.helper.c.a(str, 977, context);
            if (TextUtils.isEmpty(dVar.E)) {
            }
        }
    }

    public static String d(Context context, String str) {
        if (!str.endsWith(".jpg") && !str.endsWith(".png") && !str.endsWith(".jpeg")) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String b2 = cn.jpush.android.u.a.b(str);
        if (TextUtils.isEmpty(b2)) {
            b2 = UUID.randomUUID().toString();
        }
        String str2 = cn.jpush.android.u.c.c(context, "noti_res") + (b2 + str.substring(str.lastIndexOf(".")));
        Logger.i("NotificationHelper", "picture notification resource path: " + str2);
        if (!new File(str2).exists()) {
            byte[] a2 = cn.jpush.android.o.a.a(str, 2);
            return (a2 == null || !cn.jpush.android.u.c.a(str2, a2)) ? "" : str2;
        }
        Logger.d("NotificationHelper", "need not download again with same url:" + str);
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
        if (r8 <= 23) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
        if (r8 < r6) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bf, code lost:
        if (r7 >= r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c3, code lost:
        if (r7 <= r2) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context) {
        String g = cn.jpush.android.cache.a.g(context);
        if (TextUtils.isEmpty(g)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(g);
            int optInt = jSONObject.optInt("startHour", -1);
            int optInt2 = jSONObject.optInt("startMins", -1);
            int optInt3 = jSONObject.optInt("endHour", -1);
            int optInt4 = jSONObject.optInt("endtMins", -1);
            if (optInt >= 0 && optInt2 >= 0 && optInt3 >= 0 && optInt4 >= 0 && optInt2 <= 59 && optInt4 <= 59 && optInt3 <= 23 && optInt <= 23) {
                Calendar calendar = Calendar.getInstance();
                int i = calendar.get(11);
                int i2 = calendar.get(12);
                Logger.v("NotificationHelper", "nowHour:" + i + ", nowMin:" + i2 + ", startHour:" + optInt + ", startMin:" + optInt2 + ", endHour:" + optInt3 + ", endMin:" + optInt4);
                if (optInt < optInt3) {
                    if ((i <= optInt || i >= optInt3) && ((i != optInt || i2 < optInt2) && (i != optInt3 || i2 > optInt4))) {
                        return false;
                    }
                } else if (optInt == optInt3) {
                    if (optInt2 >= optInt4) {
                        if (i == optInt && i2 > optInt4 && i2 < optInt2) {
                            return false;
                        }
                    } else if (i != optInt || i2 < optInt2 || i2 > optInt4) {
                        return false;
                    }
                } else if (optInt > optInt3) {
                    if (i > optInt) {
                    }
                    if (i >= 0) {
                    }
                    if (i == optInt) {
                    }
                    if (i == optInt3) {
                    }
                }
                Logger.ii("NotificationHelper", "Current time is in the range of silence time - " + optInt + ":" + optInt2 + " ~ " + optInt3 + ":" + optInt4);
                return true;
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    private static boolean d(Context context, int i) {
        try {
            Logger.d("NotificationHelper", "【setEMUIBadge】number：" + i);
            if (Build.VERSION.SDK_INT >= 11) {
                Bundle bundle = new Bundle();
                bundle.putString("package", context.getPackageName());
                bundle.putString("class", i(context));
                bundle.putInt("badgenumber", i);
                context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
                return true;
            }
            return false;
        } catch (Exception e2) {
            Logger.e("NotificationHelper", "e: " + e2);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    public static int e(Context context) {
        StringBuilder sb;
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    boolean areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                    Logger.d("NotificationHelper", "from NotificationManager enable=" + areNotificationsEnabled);
                    return areNotificationsEnabled ? 1 : 0;
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                sb = new StringBuilder();
                str = "isNotificationEnabled e:";
            }
        } else {
            ?? r4 = 1;
            if (Build.VERSION.SDK_INT < 19) {
                Logger.d("NotificationHelper", "below 19 return true");
                return 1;
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() != 0) {
                    r4 = 0;
                }
                Logger.d("NotificationHelper", "from AppOpsManager enable=" + ((boolean) r4));
                return r4;
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
                str = "appOps check e:";
            }
        }
        sb.append(str);
        sb.append(th);
        Logger.w("NotificationHelper", sb.toString());
        return -1;
    }

    public static synchronized Bitmap e(Context context, String str) {
        Bitmap bitmap;
        synchronized (b.class) {
            try {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                bitmap = ((BitmapDrawable) packageManager.getApplicationIcon(packageManager.getApplicationInfo(str, 0))).getBitmap();
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "getTargetAppBitmap failed:" + th.getMessage());
                return null;
            }
        }
        return bitmap;
    }

    private static String f(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            if (cn.jpush.android.u.a.a()) {
                String d2 = d(context, str);
                if (!TextUtils.isEmpty(d2)) {
                    return d2;
                }
                str2 = "Get network picture failed.";
            } else {
                str2 = "SDCard is not mounted,need not download pic";
            }
            Logger.ww("NotificationHelper", str2);
            return null;
        }
        return null;
    }

    public static boolean f(Context context) {
        String str;
        int i;
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            if (Build.VERSION.SDK_INT < 26) {
                if (Build.VERSION.SDK_INT >= 21) {
                    intent.putExtra("app_package", context.getPackageName());
                    str = "app_uid";
                    i = context.getApplicationInfo().uid;
                }
                intent.setFlags(268435456);
                context.startActivity(intent);
                return true;
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            str = "android.provider.extra.CHANNEL_ID";
            i = context.getApplicationInfo().uid;
            intent.putExtra(str, i);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean g(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean g(Context context, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "link uri is empty");
            return false;
        }
        try {
            if (str.startsWith("http")) {
                z = h(context, str);
            } else {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setFlags(268435456);
                context.startActivity(parseUri);
                z = true;
            }
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "[handleSSP] start fail uri error:" + th.getMessage());
        }
        return z;
    }

    private static String h(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (resolveActivity == null) {
                resolveActivity = packageManager.resolveActivity(intent, 0);
            }
            if (resolveActivity != null) {
                return resolveActivity.activityInfo.name;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0336  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(Context context, cn.jpush.android.d.d dVar) {
        boolean z;
        boolean z2;
        Notification notification;
        String str;
        boolean z3;
        String str2;
        int i;
        JCoreHelper.triggerSceneCheck(context);
        boolean z4 = true;
        try {
            if (TextUtils.isEmpty(dVar.E)) {
                z = false;
                z2 = false;
            } else if (!dVar.E.equals("ssp")) {
                Logger.d("NotificationHelper", "source:" + dVar.E);
                cn.jpush.android.helper.c.a(dVar.f4312c, 975, context);
                return;
            } else if (h.a()) {
                Logger.d("NotificationHelper", "the device is in black list");
                cn.jpush.android.helper.c.a(dVar.f4312c, 974, context);
                return;
            } else {
                if (TextUtils.isEmpty(dVar.K)) {
                    if (TextUtils.isEmpty(dVar.H) || !dVar.H.startsWith("http")) {
                        Logger.d("NotificationHelper", "deeplink is empty or not a http/https url");
                        cn.jpush.android.helper.c.a(dVar.f4312c, 985, context);
                        return;
                    }
                } else if (!cn.jpush.android.u.a.c(context, dVar.K)) {
                    if (dVar.I != 0 && dVar.I != 2) {
                        cn.jpush.android.helper.c.a(dVar.f4312c, 980, context);
                    }
                    Logger.d("NotificationHelper", "targetPkgname:" + dVar.K + " not installed and failed type:" + dVar.I + ",need not show notification");
                    cn.jpush.android.helper.c.a(dVar.f4312c, 981, context);
                    return;
                }
                try {
                    boolean z5 = dVar.L == 1001;
                    if (!z5) {
                        cn.jpush.android.helper.c.a(dVar.f4312c, 1050, context);
                        return;
                    } else {
                        z = z5;
                        z2 = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (!z4) {
                        a(context, 1000, 0, th.getMessage());
                    }
                    Logger.e("NotificationHelper", "showNotification failed:" + th.getMessage());
                }
            }
            try {
                if (TextUtils.isEmpty(dVar.u)) {
                    if (z) {
                        cn.jpush.android.helper.c.a(dVar.f4312c, 1051, context);
                        return;
                    }
                    a(context, "cn.jpush.android.intent.NOTIFICATION_ARRIVED", dVar, (Intent) null);
                    Logger.w("NotificationHelper", "notificationContent is empty");
                    return;
                }
                String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
                NotificationMessage b2 = dVar.b();
                String str3 = "";
                c a2 = a(JPushConstants.mApplicationContext, dVar.E, dVar.K, dVar.F, dVar.f4312c);
                if (a2.e() != 0) {
                    cn.jpush.android.helper.c.a(dVar.f4312c, a2.e(), context);
                    Logger.ww("NotificationHelper", "build small icon failed,will not notify this notification");
                    return;
                }
                c b3 = b(JPushConstants.mApplicationContext, dVar.G);
                if (z) {
                    long j = 0;
                    try {
                        JSONObject jSONObject = new JSONObject(dVar.B);
                        i = jSONObject.optInt("ssp_msgcount_limit", 0);
                        try {
                            long optLong = jSONObject.optLong("ssp_msg_gap", 0L);
                            if (i > 0) {
                                try {
                                    Logger.d("NotificationHelper", "setSSPLimitCount:" + i);
                                } catch (Throwable unused) {
                                }
                            }
                            if (optLong > 0) {
                                j = 1000 * optLong;
                                Logger.d("NotificationHelper", "setSSPLimitInterval:" + j);
                                optLong = j;
                            }
                            j = optLong;
                        } catch (Throwable unused2) {
                        }
                    } catch (Throwable unused3) {
                        i = 0;
                    }
                    int a3 = h.a(context, i, j);
                    if (a3 == -2) {
                        cn.jpush.android.helper.c.a(dVar.f4312c, 1053, context);
                        return;
                    } else if (a3 == -1) {
                        cn.jpush.android.helper.c.a(dVar.f4312c, 1052, context);
                        return;
                    } else {
                        dVar.X = 0;
                        if (h.b() == -1) {
                            notification = a(context, dVar, null, z, a2, b3);
                        } else {
                            Object a4 = a(context, dVar, a2, b3);
                            if (a4 == null) {
                                cn.jpush.android.helper.c.a(dVar.f4312c, 983, context);
                                return;
                            } else if (!(a4 instanceof RemoteViews)) {
                                return;
                            } else {
                                notification = a(context, dVar, (RemoteViews) a4, z, a2, b3);
                            }
                        }
                        Logger.d("NotificationHelper", "source is :" + dVar.E + ",use DefaultPushNotificationBuilder");
                        str = "";
                        z3 = true;
                    }
                } else {
                    notification = !TextUtils.isEmpty(messageReceiverClass) ? ((JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance()).getNotification(context, b2) : null;
                    if (notification == null) {
                        PushNotificationBuilder a5 = a(context, b2);
                        if (a5 != null) {
                            notification = a5.buildNotification(context, b2);
                            str3 = a5.getDeveloperArg0();
                        }
                        if (notification == null) {
                            notification = a(context, dVar, null, z, a2, b3);
                            str = str3;
                            z3 = false;
                        }
                    }
                    str = str3;
                    z3 = false;
                }
                int a6 = a(dVar);
                dVar.f4313d = a6;
                dVar.ah = str;
                notification.contentIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), dVar.M ? 2 == dVar.R ? b(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : c(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar), 1073741824);
                if (!z) {
                    notification.deleteIntent = PendingIntent.getActivity(context, (int) (System.currentTimeMillis() + 1), c(context, "cn.jpush.android.intent.NOTIFICATION_DISMISS", dVar), 1073741824);
                }
                if (dVar.k == 1) {
                    dVar.r = 1;
                }
                if (z) {
                    notification.flags = 17;
                } else {
                    notification.flags = a(dVar.r) | 1;
                }
                if (d(context)) {
                    notification.defaults = 0;
                }
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    Logger.dd("NotificationHelper", "notify: id=" + a6 + " messageId=" + dVar.f4312c + " overmessageid=" + dVar.f);
                    a(context, dVar.X, notification);
                    notificationManager.notify(a6, notification);
                    if (z3) {
                        h.a(context);
                    }
                } else {
                    Logger.w("NotificationHelper", "NotificationManager is null");
                }
                if (dVar.k == 1) {
                    str2 = "local notification not offer to notification queue";
                } else if (dVar.W == 0) {
                    if (!z) {
                        a(context, a6);
                    }
                    if (e(context) == 0) {
                        cn.jpush.android.helper.c.a(dVar.f4312c, 1036, context);
                    }
                    cn.jpush.android.helper.c.a(dVar.f4312c, 1018, context);
                    if (z && dVar.W == 0) {
                        a(context, "cn.jpush.android.intent.NOTIFICATION_ARRIVED", dVar, (Intent) null);
                        return;
                    } else {
                        Logger.d("NotificationHelper", "custom deep link need not send receiver to user");
                    }
                } else {
                    str2 = "Third notification:" + ((int) dVar.W);
                }
                Logger.d("NotificationHelper", str2);
                if (z) {
                }
                Logger.d("NotificationHelper", "custom deep link need not send receiver to user");
            } catch (Throwable th2) {
                th = th2;
                z4 = z2;
                if (!z4) {
                }
                Logger.e("NotificationHelper", "showNotification failed:" + th.getMessage());
            }
        } catch (Throwable th3) {
            th = th3;
            z4 = false;
        }
    }

    private static boolean h(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "link uri is empty");
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            context.startActivity(intent);
        } catch (Throwable unused) {
            Logger.d("NotificationHelper", "start default browser failed");
            try {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setFlags(268435456);
                context.startActivity(parseUri);
            } catch (Throwable th) {
                Logger.d("NotificationHelper", "[openWebUri] start fail uri error:" + th.getMessage());
                return false;
            }
        }
        return true;
    }

    private static String i(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null && launchIntentForPackage.getComponent() != null) {
                return launchIntentForPackage.getComponent().getClassName();
            }
        } catch (Throwable unused) {
        }
        return h(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Context context, cn.jpush.android.d.d dVar) {
        String str;
        boolean z;
        String str2 = dVar.f4312c;
        String str3 = dVar.N;
        str = "";
        if (TextUtils.isEmpty(str3)) {
            Logger.w("NotificationHelper", "Show url is Empty! Give up to download!");
            z = false;
        } else {
            String a2 = cn.jpush.android.o.a.a(str3, 5, 5000L);
            boolean isEmpty = TextUtils.isEmpty(a2);
            str = isEmpty ? "" : a2;
            z = !isEmpty;
        }
        String c2 = cn.jpush.android.u.c.c(context, str2);
        if (!z) {
            Logger.w("NotificationHelper", "NOTE: failed to download html page. Give up this.");
            cn.jpush.android.helper.c.a(str2, 1014, context);
            cn.jpush.android.helper.c.a(str2, 1021, null, context);
            return;
        }
        String str4 = c2 + str2 + ".html";
        String substring = str3.substring(0, str3.lastIndexOf("/") + 1);
        if (dVar.T.isEmpty()) {
            dVar.P = dVar.N;
        } else if (!g.a(dVar.T, context, substring, str2, true)) {
            Logger.d("NotificationHelper", "Loads rich push resources failed, webView will open url!");
            cn.jpush.android.helper.c.a(str2, 1014, context);
            h(context, dVar);
            return;
        } else {
            Logger.d("NotificationHelper", "Loads rich push resources succeed, webView will open cache!");
            if (!cn.jpush.android.u.c.b(str4, str.replaceAll("img src=\"" + substring, "img src=\"" + c2))) {
                cn.jpush.android.helper.c.a(str2, 1014, context);
                return;
            }
            dVar.P = "file://" + str4;
            cn.jpush.android.helper.c.a(str2, 995, context);
        }
        h(context, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Context context, cn.jpush.android.d.d dVar) {
        String a2;
        String str;
        String str2 = dVar.x;
        dVar.x = "";
        if (dVar.v != 3 || TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.startsWith("http://") || str2.startsWith("https://")) {
            a2 = a(context, str2, dVar.f4312c);
            if (TextUtils.isEmpty(a2)) {
                str = "Get network picture failed, show basic notification only.";
                Logger.ww("NotificationHelper", str);
                return;
            }
            dVar.x = a2;
        }
        a2 = cn.jpush.android.u.c.d(context, str2);
        if (TextUtils.isEmpty(a2)) {
            str = "Get developer picture failed, show basic notification only.";
            Logger.ww("NotificationHelper", str);
            return;
        }
        dVar.x = a2;
    }
}

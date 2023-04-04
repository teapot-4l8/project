package cn.jpush.android.api;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.p.a;
import cn.jpush.android.p.b;
import cn.jpush.android.p.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DefaultPushNotificationBuilder implements PushNotificationBuilder {
    public static final int NOTI_STYLE_BIG_PICTURE = 3;
    public static final int NOTI_STYLE_BIG_TEXT = 1;
    public static final int NOTI_STYLE_INBOX = 2;
    private static final String TAG = "DefaultPushNotificationBuilder";
    protected Context context;
    private NotificationMessage notificationMessage;

    RemoteViews buildContentView(String str, String str2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014e  */
    @Override // cn.jpush.android.api.PushNotificationBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Notification buildNotification(Context context, NotificationMessage notificationMessage) {
        String str;
        String str2;
        this.context = context;
        this.notificationMessage = notificationMessage;
        HashMap hashMap = new HashMap();
        if (notificationMessage != null) {
            Logger.d(TAG, "notificationContent:" + notificationMessage.notificationContent + "\nnotificationTitle" + notificationMessage.notificationTitle + "\nnotificationStyle:" + notificationMessage.notificationStyle + "\nnotificationPriority:" + notificationMessage.notificationPriority + "\nnotificationBigText:" + notificationMessage.notificationBigText + "\nnotificationBigPicPath:" + notificationMessage.notificationBigPicPath + "\nnotificationInbox:" + notificationMessage.notificationInbox + "\nnotificationCategory:" + notificationMessage.notificationCategory + "\nnotificationAlertType:" + notificationMessage.notificationAlertType + "\nnotificationSmallIcon:" + notificationMessage.notificationSmallIcon + "\nnotificationLargeIcon:" + notificationMessage.notificationLargeIcon + "\nextraJson:" + notificationMessage.notificationExtras);
            hashMap.put(JPushInterface.EXTRA_MSG_ID, notificationMessage.msgId);
            hashMap.put(JPushInterface.EXTRA_ALERT, notificationMessage.notificationContent);
            StringBuilder sb = new StringBuilder();
            sb.append(notificationMessage.notificationAlertType);
            sb.append("");
            hashMap.put(JPushInterface.EXTRA_ALERT_TYPE, sb.toString());
            if (!TextUtils.isEmpty(notificationMessage.notificationTitle)) {
                hashMap.put(JPushInterface.EXTRA_NOTIFICATION_TITLE, notificationMessage.notificationTitle);
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationExtras)) {
                hashMap.put(JPushInterface.EXTRA_EXTRA, notificationMessage.notificationExtras);
            }
            if (notificationMessage.notificationStyle == 1 && !TextUtils.isEmpty(notificationMessage.notificationBigText)) {
                str = notificationMessage.notificationBigText;
                str2 = JPushInterface.EXTRA_BIG_TEXT;
            } else if (notificationMessage.notificationStyle != 2 || TextUtils.isEmpty(notificationMessage.notificationInbox)) {
                if (notificationMessage.notificationStyle == 3 && !TextUtils.isEmpty(notificationMessage.notificationBigPicPath)) {
                    str = notificationMessage.notificationBigPicPath;
                    str2 = JPushInterface.EXTRA_BIG_PIC_PATH;
                }
                if (notificationMessage.notificationPriority != 0) {
                    hashMap.put(JPushInterface.EXTRA_NOTI_PRIORITY, notificationMessage.notificationPriority + "");
                }
                if (!TextUtils.isEmpty(notificationMessage.notificationCategory)) {
                    hashMap.put(JPushInterface.EXTRA_NOTI_CATEGORY, notificationMessage.notificationCategory);
                }
                if (!TextUtils.isEmpty(notificationMessage.notificationSmallIcon)) {
                    hashMap.put(JPushInterface.EXTRA_NOTIFICATION_SMALL_ICON, notificationMessage.notificationSmallIcon);
                }
                if (!TextUtils.isEmpty(notificationMessage.notificationLargeIcon)) {
                    hashMap.put(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON, notificationMessage.notificationSmallIcon);
                }
            } else {
                str = notificationMessage.notificationInbox;
                str2 = JPushInterface.EXTRA_INBOX;
            }
            hashMap.put(str2, str);
            if (notificationMessage.notificationPriority != 0) {
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationCategory)) {
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationSmallIcon)) {
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationLargeIcon)) {
            }
        }
        return buildNotification(hashMap);
    }

    @Override // cn.jpush.android.api.PushNotificationBuilder
    public Notification buildNotification(Map<String, String> map) {
        String str;
        int i;
        Context context = this.context;
        if (context == null) {
            Logger.w(TAG, "Can't find valid context when build notification.");
            return null;
        }
        try {
            str = context.getApplicationInfo().loadLabel(this.context.getPackageManager()).toString();
        } catch (Throwable unused) {
            str = null;
        }
        if (map.containsKey(JPushInterface.EXTRA_MSG_ID)) {
            map.get(JPushInterface.EXTRA_MSG_ID);
        }
        String str2 = map.containsKey(JPushInterface.EXTRA_ALERT) ? map.get(JPushInterface.EXTRA_ALERT) : "";
        if (TextUtils.isEmpty(str2)) {
            Logger.ww(TAG, "No notification content to show. Give up.");
            return null;
        }
        if (map.containsKey(JPushInterface.EXTRA_NOTIFICATION_SMALL_ICON)) {
            map.get(JPushInterface.EXTRA_NOTIFICATION_SMALL_ICON);
        }
        String str3 = map.containsKey(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON) ? map.get(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON) : "";
        if (map.containsKey(JPushInterface.EXTRA_NOTIFICATION_TITLE)) {
            str = map.get(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        }
        String str4 = map.containsKey(JPushInterface.EXTRA_BIG_TEXT) ? map.get(JPushInterface.EXTRA_BIG_TEXT) : "";
        String str5 = map.containsKey(JPushInterface.EXTRA_INBOX) ? map.get(JPushInterface.EXTRA_INBOX) : "";
        int parseInt = map.containsKey(JPushInterface.EXTRA_NOTI_PRIORITY) ? Integer.parseInt(map.get(JPushInterface.EXTRA_NOTI_PRIORITY)) : 0;
        String str6 = map.containsKey(JPushInterface.EXTRA_NOTI_CATEGORY) ? map.get(JPushInterface.EXTRA_NOTI_CATEGORY) : "";
        String str7 = map.containsKey(JPushInterface.EXTRA_BIG_PIC_PATH) ? map.get(JPushInterface.EXTRA_BIG_PIC_PATH) : "";
        int parseInt2 = map.containsKey(JPushInterface.EXTRA_ALERT_TYPE) ? Integer.parseInt(map.get(JPushInterface.EXTRA_ALERT_TYPE)) : -1;
        int i2 = (parseInt2 < -1 || parseInt2 > 7) ? -1 : parseInt2;
        RemoteViews buildContentView = buildContentView(str2, str);
        if (Build.VERSION.SDK_INT < 11) {
            Notification notification = new Notification(f.a(this.context), str2, System.currentTimeMillis());
            resetNotificationParams(notification);
            notification.defaults = i2;
            if (buildContentView != null) {
                notification.contentView = buildContentView;
            } else {
                b.a(notification, this.context, str, str2, (PendingIntent) null);
            }
            return notification;
        }
        Notification.Builder builder = new Notification.Builder(this.context);
        builder.setContentTitle(str).setContentText(str2).setTicker(str2);
        int a2 = f.a(this.context);
        if (a2 != 0) {
            Logger.dd(TAG, "setSmallIcon with resId:" + a2);
        } else {
            Logger.ww(TAG, "not found small icon in your app,will setSmallIcon with android.R.color.transparent ");
            a2 = 17170445;
        }
        builder.setSmallIcon(a2);
        Object c2 = b.c(this.context, str3);
        if (Build.VERSION.SDK_INT >= 23) {
            if (c2 instanceof Icon) {
                builder.setLargeIcon((Icon) c2);
            }
        } else if (c2 instanceof Bitmap) {
            builder.setLargeIcon((Bitmap) c2);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            builder.setShowWhen(true);
        }
        Context context2 = this.context;
        NotificationMessage notificationMessage = this.notificationMessage;
        String str8 = notificationMessage != null ? notificationMessage.notificationChannelId : "";
        int i3 = i2;
        String str9 = str7;
        a.a(context2, builder, str8, "", parseInt, i3, (String) null);
        if (Build.VERSION.SDK_INT >= 16) {
            if (buildContentView == null) {
                if (!TextUtils.isEmpty(str4)) {
                    Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                    bigTextStyle.bigText(str4);
                    builder.setStyle(bigTextStyle);
                }
                if (!TextUtils.isEmpty(str5)) {
                    Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                    try {
                        TreeMap treeMap = new TreeMap();
                        JSONObject jSONObject = new JSONObject(str5);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            treeMap.put(next, jSONObject.optString(next));
                        }
                        for (String str10 : treeMap.values()) {
                            inboxStyle.addLine(str10);
                        }
                        inboxStyle.setSummaryText(" + " + jSONObject.length() + " new messages");
                    } catch (Throwable th) {
                        Logger.ee(TAG, "Set inbox style error: " + th.getMessage());
                    }
                    builder.setStyle(inboxStyle);
                }
                if (!TextUtils.isEmpty(str9)) {
                    Logger.i(TAG, "Set notification BPS with picture path:" + str9);
                    try {
                        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                        bigPictureStyle.bigPicture(BitmapFactory.decodeFile(str9));
                        builder.setStyle(bigPictureStyle);
                    } catch (Throwable unused2) {
                        Logger.ww(TAG, "Create big picture style failed.");
                    }
                }
            }
            if (parseInt != 0) {
                if (parseInt == 1) {
                    builder.setPriority(1);
                } else {
                    int i4 = 2;
                    if (parseInt != 2) {
                        if (parseInt != -1) {
                            i4 = -2;
                            i = parseInt != -2 ? 0 : -1;
                        }
                        builder.setPriority(i);
                    }
                    builder.setPriority(i4);
                }
            }
            if (!TextUtils.isEmpty(str6) && Build.VERSION.SDK_INT >= 21) {
                builder.setCategory(str6);
            }
        }
        if (buildContentView != null) {
            builder.setContent(buildContentView);
        } else {
            Logger.i(TAG, " Use default notification view! ");
        }
        builder.setDefaults(i3);
        return getNotification(builder);
    }

    @Override // cn.jpush.android.api.PushNotificationBuilder
    public String getDeveloperArg0() {
        return null;
    }

    Notification getNotification(Notification.Builder builder) {
        try {
            return Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        } catch (Throwable th) {
            Logger.ww(TAG, "Build notification error:", th);
            return null;
        }
    }

    void resetNotificationParams(Notification notification) {
    }

    public String toString() {
        return "";
    }
}

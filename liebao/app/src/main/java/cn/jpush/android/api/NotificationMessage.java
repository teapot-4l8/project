package cn.jpush.android.api;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NotificationMessage {
    public String _webPagePath;
    public String appId;
    public String appkey;
    public Context context;
    public String developerArg0;
    public boolean isRichPush;
    public String msgId;
    public int notificationAlertType;
    public String notificationBigPicPath;
    public String notificationBigText;
    public int notificationBuilderId;
    public String notificationCategory;
    public String notificationChannelId;
    public String notificationContent;
    public String notificationExtras;
    public int notificationId;
    public String notificationInbox;
    public String notificationLargeIcon;
    public int notificationPriority;
    public String notificationSmallIcon;
    public int notificationStyle;
    public String notificationTitle;
    public int notificationType;
    public int richType;
    public int platform = 0;
    public ArrayList<String> showResourceList = new ArrayList<>();

    public String toString() {
        return "NotificationMessage{notificationId=" + this.notificationId + ", msgId='" + this.msgId + "', appkey='" + this.appkey + "', notificationContent='" + this.notificationContent + "', notificationAlertType=" + this.notificationAlertType + ", notificationTitle='" + this.notificationTitle + "', notificationSmallIcon='" + this.notificationSmallIcon + "', notificationLargeIcon='" + this.notificationLargeIcon + "', notificationExtras='" + this.notificationExtras + "', notificationStyle=" + this.notificationStyle + ", notificationBuilderId=" + this.notificationBuilderId + ", notificationBigText='" + this.notificationBigText + "', notificationBigPicPath='" + this.notificationBigPicPath + "', notificationInbox='" + this.notificationInbox + "', notificationPriority=" + this.notificationPriority + ", notificationCategory='" + this.notificationCategory + "', developerArg0='" + this.developerArg0 + "', platform=" + this.platform + ", notificationChannelId='" + this.notificationChannelId + "', notificationType=" + this.notificationType + '}';
    }
}

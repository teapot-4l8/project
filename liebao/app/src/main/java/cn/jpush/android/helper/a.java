package cn.jpush.android.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4344a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f4345b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.jpush.android.helper.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0079a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Context f4347b;

        /* renamed from: c  reason: collision with root package name */
        private JPushMessageReceiver f4348c;

        /* renamed from: d  reason: collision with root package name */
        private Intent f4349d;

        public RunnableC0079a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
            this.f4347b = context;
            this.f4348c = jPushMessageReceiver;
            this.f4349d = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f4349d == null) {
                    Logger.w("JMessageReceiverHelper", "intent was null");
                    return;
                }
                String action = this.f4349d.getAction();
                Logger.d("JMessageReceiverHelper", "do receiver action :" + action);
                if (action == null) {
                    Logger.w("JMessageReceiverHelper", "unsupport action type");
                } else if (action.equals("cn.jpush.android.intent.RECEIVE_MESSAGE")) {
                    int intExtra = this.f4349d.getIntExtra("message_type", -1);
                    JPushMessage jPushMessage = null;
                    if (1 == intExtra || 2 == intExtra) {
                        jPushMessage = cn.jpush.android.s.c.a().a(this.f4347b, this.f4349d);
                    }
                    Logger.d("JMessageReceiverHelper", "messageType:" + intExtra + ",jPushMessage:" + jPushMessage);
                    if (jPushMessage == null) {
                        Logger.w("JMessageReceiverHelper", "parse tagalias message failed");
                    } else if (intExtra == 1) {
                        if (jPushMessage.isTagCheckOperator()) {
                            this.f4348c.onCheckTagOperatorResult(this.f4347b, jPushMessage);
                        } else {
                            this.f4348c.onTagOperatorResult(this.f4347b, jPushMessage);
                        }
                    } else if (intExtra == 2) {
                        this.f4348c.onAliasOperatorResult(this.f4347b, jPushMessage);
                    } else {
                        Logger.w("JMessageReceiverHelper", "unsupport message type");
                    }
                } else if (action.equals("mobile_result")) {
                    this.f4348c.onMobileNumberOperatorResult(this.f4347b, d.a().a(this.f4347b, this.f4349d));
                } else if (action.equals(cn.jpush.android.u.a.e(this.f4347b, "custom_msg"))) {
                    this.f4348c.onMessage(this.f4347b, cn.jpush.android.d.b.a(this.f4349d));
                } else if (action.equals(cn.jpush.android.u.a.e(this.f4347b, "cmd_msg"))) {
                    a.a(this.f4348c, this.f4347b, this.f4349d);
                } else if (action.equals("cn.jpush.android.intent.NOTIFICATION_ARRIVED")) {
                    this.f4348c.onNotifyMessageArrived(this.f4347b, cn.jpush.android.p.b.b(this.f4347b, this.f4349d));
                } else if (action.equals(JPushInterface.ACTION_NOTIFICATION_OPENED)) {
                    this.f4348c.onNotifyMessageOpened(this.f4347b, cn.jpush.android.p.b.b(this.f4347b, this.f4349d));
                } else if (action.equals("cn.jpush.android.intent.NOTIFICATION_DISMISS")) {
                    this.f4348c.onNotifyMessageDismiss(this.f4347b, cn.jpush.android.p.b.b(this.f4347b, this.f4349d));
                } else if (JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION_PROXY.equals(this.f4349d.getAction())) {
                    Intent intent = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
                    if (this.f4349d.getExtras() != null) {
                        intent.putExtras(this.f4349d.getExtras());
                    }
                    this.f4348c.onMultiActionClicked(this.f4347b, intent);
                } else if (!"on_noti_settings_check".equals(action)) {
                    Logger.w("JMessageReceiverHelper", "unsupport action type");
                } else {
                    this.f4348c.onNotificationSettingsCheck(this.f4347b, this.f4349d.getBooleanExtra("isOn", false), this.f4349d.getIntExtra("source", 0));
                }
            } catch (Throwable th) {
                Logger.ww("JMessageReceiverHelper", "MessageReceiver run failed:" + th.getMessage());
            }
        }
    }

    private a() {
        try {
            HandlerThread handlerThread = new HandlerThread("MessageReceiver");
            handlerThread.start();
            this.f4345b = new Handler(handlerThread.getLooper());
        } catch (Throwable th) {
            Logger.w("JMessageReceiverHelper", "create handler failed,error:" + th);
            this.f4345b = new Handler();
        }
    }

    public static a a() {
        if (f4344a == null) {
            synchronized (a.class) {
                if (f4344a == null) {
                    f4344a = new a();
                }
            }
        }
        return f4344a;
    }

    public static void a(Context context, Intent intent) {
        Logger.i("JMessageReceiverHelper", "Click notification action with extra: " + intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA));
        try {
            Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
            intent2.putExtras(intent.getExtras());
            intent2.addCategory(context.getPackageName());
            intent2.setPackage(context.getPackageName());
            context.sendBroadcast(intent2, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        } catch (Throwable th) {
            Logger.ww("JMessageReceiverHelper", "Click notification sendBroadcast :" + th.getMessage());
        }
    }

    public static void a(Context context, CustomMessage customMessage) {
        if (context == null || customMessage == null) {
            Logger.dd("JMessageReceiverHelper", "Send custom message to app failed, param is invalid!");
            return;
        }
        Logger.dd("JMessageReceiverHelper", "not found user push message,use old action to user");
        Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
        intent.putExtra(JPushInterface.EXTRA_APP_KEY, customMessage.senderId);
        intent.putExtra(JPushInterface.EXTRA_MESSAGE, customMessage.message);
        intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, customMessage.contentType);
        intent.putExtra(JPushInterface.EXTRA_TITLE, customMessage.title);
        intent.putExtra(JPushInterface.EXTRA_EXTRA, customMessage.extra);
        intent.putExtra(JPushInterface.EXTRA_MSG_ID, customMessage.messageId);
        intent.addCategory(customMessage.appId);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent, String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
        Logger.i("JMessageReceiverHelper", "Send broadcast to app: " + String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7 A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:58:0x0131, B:60:0x0136, B:62:0x013a, B:64:0x0142, B:65:0x0151, B:67:0x0155, B:69:0x015d, B:70:0x016e, B:72:0x0174, B:74:0x0182, B:75:0x0186, B:77:0x0190, B:78:0x0193, B:79:0x0197, B:80:0x01a0, B:81:0x01a9, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:91:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5 A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:58:0x0131, B:60:0x0136, B:62:0x013a, B:64:0x0142, B:65:0x0151, B:67:0x0155, B:69:0x015d, B:70:0x016e, B:72:0x0174, B:74:0x0182, B:75:0x0186, B:77:0x0190, B:78:0x0193, B:79:0x0197, B:80:0x01a0, B:81:0x01a9, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:91:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0104 A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:58:0x0131, B:60:0x0136, B:62:0x013a, B:64:0x0142, B:65:0x0151, B:67:0x0155, B:69:0x015d, B:70:0x016e, B:72:0x0174, B:74:0x0182, B:75:0x0186, B:77:0x0190, B:78:0x0193, B:79:0x0197, B:80:0x01a0, B:81:0x01a9, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:91:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0113 A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:58:0x0131, B:60:0x0136, B:62:0x013a, B:64:0x0142, B:65:0x0151, B:67:0x0155, B:69:0x015d, B:70:0x016e, B:72:0x0174, B:74:0x0182, B:75:0x0186, B:77:0x0190, B:78:0x0193, B:79:0x0197, B:80:0x01a0, B:81:0x01a9, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:91:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0122 A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:58:0x0131, B:60:0x0136, B:62:0x013a, B:64:0x0142, B:65:0x0151, B:67:0x0155, B:69:0x015d, B:70:0x016e, B:72:0x0174, B:74:0x0182, B:75:0x0186, B:77:0x0190, B:78:0x0193, B:79:0x0197, B:80:0x01a0, B:81:0x01a9, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:91:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012d A[Catch: all -> 0x01cd, TryCatch #1 {all -> 0x01cd, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:58:0x0131, B:60:0x0136, B:62:0x013a, B:64:0x0142, B:65:0x0151, B:67:0x0155, B:69:0x015d, B:70:0x016e, B:72:0x0174, B:74:0x0182, B:75:0x0186, B:77:0x0190, B:78:0x0193, B:79:0x0197, B:80:0x01a0, B:81:0x01a9, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:91:0x0047 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, NotificationMessage notificationMessage, String str) {
        String str2;
        String str3;
        if (context == null || notificationMessage == null || TextUtils.isEmpty(str)) {
            Logger.dd("JMessageReceiverHelper", "Send broad cast to app failed,the params are incorrect!");
            return;
        }
        Intent intent = new Intent(str);
        try {
            if (str.equals(JPushInterface.ACTION_NOTIFICATION_OPENED)) {
                List<String> b2 = cn.jpush.android.u.a.b(context, intent, notificationMessage.appId + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
                if (b2 == null || b2.isEmpty()) {
                    Logger.dd("JMessageReceiverHelper", "not found receiver by action:cn.jpush.android.intent.NOTIFICATION_OPENED,will start main activity");
                    cn.jpush.android.u.a.e(context);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Logger.dd("JMessageReceiverHelper", "Send push received broadcast to developer defined receiver");
            Bundle bundle = new Bundle();
            bundle.putString(JPushInterface.EXTRA_MSG_ID, notificationMessage.msgId);
            bundle.putInt(JPushInterface.EXTRA_NOTIFICATION_ID, notificationMessage.notificationId);
            bundle.putString(JPushInterface.EXTRA_ALERT, notificationMessage.notificationContent);
            bundle.putString(JPushInterface.EXTRA_ALERT_TYPE, notificationMessage.notificationAlertType + "");
            if (!TextUtils.isEmpty(notificationMessage.notificationTitle)) {
                bundle.putString(JPushInterface.EXTRA_NOTIFICATION_TITLE, notificationMessage.notificationTitle);
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationExtras)) {
                bundle.putString(JPushInterface.EXTRA_EXTRA, notificationMessage.notificationExtras);
            }
            if (notificationMessage.notificationStyle == 1 && !TextUtils.isEmpty(notificationMessage.notificationBigText)) {
                str2 = JPushInterface.EXTRA_BIG_TEXT;
                str3 = notificationMessage.notificationBigText;
            } else if (notificationMessage.notificationStyle != 2 || TextUtils.isEmpty(notificationMessage.notificationInbox)) {
                if (notificationMessage.notificationStyle == 3 && !TextUtils.isEmpty(notificationMessage.notificationBigPicPath)) {
                    str2 = JPushInterface.EXTRA_BIG_PIC_PATH;
                    str3 = notificationMessage.notificationBigPicPath;
                }
                if (notificationMessage.notificationPriority != 0) {
                    bundle.putString(JPushInterface.EXTRA_NOTI_PRIORITY, notificationMessage.notificationPriority + "");
                }
                if (!TextUtils.isEmpty(notificationMessage.notificationCategory)) {
                    bundle.putString(JPushInterface.EXTRA_NOTI_CATEGORY, notificationMessage.notificationCategory);
                }
                if (!TextUtils.isEmpty(notificationMessage.notificationSmallIcon)) {
                    bundle.putString(JPushInterface.EXTRA_NOTIFICATION_SMALL_ICON, notificationMessage.notificationSmallIcon);
                }
                if (!TextUtils.isEmpty(notificationMessage.notificationLargeIcon)) {
                    bundle.putString(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON, notificationMessage.notificationLargeIcon);
                }
                if (!TextUtils.isEmpty(notificationMessage.developerArg0)) {
                    intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_DEVELOPER_ARG0, notificationMessage.developerArg0);
                }
                if (notificationMessage.isRichPush) {
                    if (notificationMessage.richType != 0 && notificationMessage.richType != 4 && notificationMessage._webPagePath != null && notificationMessage._webPagePath.startsWith("file://")) {
                        notificationMessage._webPagePath = notificationMessage._webPagePath.replaceFirst("file://", "");
                        intent.putExtra(JPushInterface.EXTRA_RICHPUSH_HTML_PATH, notificationMessage._webPagePath);
                    }
                    if (notificationMessage.showResourceList != null && notificationMessage.showResourceList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        String c2 = cn.jpush.android.u.c.c(context, notificationMessage.msgId);
                        Iterator<String> it = notificationMessage.showResourceList.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next.startsWith("http://")) {
                                next = cn.jpush.android.u.c.b(next);
                            }
                            if (TextUtils.isEmpty(sb.toString())) {
                                sb.append(c2);
                            } else {
                                sb.append(",");
                                sb.append(c2);
                            }
                            sb.append(next);
                        }
                        intent.putExtra(JPushInterface.EXTRA_RICHPUSH_HTML_RES, sb.toString());
                    }
                }
                intent.putExtras(bundle);
                intent.addCategory(notificationMessage.appId);
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent, notificationMessage.appId + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
            } else {
                str2 = JPushInterface.EXTRA_INBOX;
                str3 = notificationMessage.notificationInbox;
            }
            bundle.putString(str2, str3);
            if (notificationMessage.notificationPriority != 0) {
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationCategory)) {
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationSmallIcon)) {
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationLargeIcon)) {
            }
            if (!TextUtils.isEmpty(notificationMessage.developerArg0)) {
            }
            if (notificationMessage.isRichPush) {
            }
            intent.putExtras(bundle);
            intent.addCategory(notificationMessage.appId);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, notificationMessage.appId + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        } catch (Throwable th) {
            Logger.ww("JMessageReceiverHelper", "sendNotificationReceivedBroadcast error:" + th.getMessage());
            cn.jpush.android.u.a.a(context, intent, notificationMessage.appId + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        }
    }

    public static void a(JPushMessageReceiver jPushMessageReceiver, Context context, Intent intent) {
        CmdMessage cmdMessage;
        try {
            int intExtra = intent.getIntExtra(JThirdPlatFormInterface.KEY_CODE, -2);
            int intExtra2 = intent.getIntExtra("cmd", -2);
            String stringExtra = intent.getStringExtra("message");
            Bundle extras = intent.getExtras();
            if (intExtra2 == -1) {
                jPushMessageReceiver.onConnected(context, false);
                return;
            }
            if (intExtra2 == 0) {
                if (intExtra == 0) {
                    jPushMessageReceiver.onRegister(context, stringExtra);
                    return;
                }
                cmdMessage = new CmdMessage(intExtra2, intExtra, stringExtra, extras);
            } else if (intExtra2 == 1) {
                jPushMessageReceiver.onConnected(context, true);
                return;
            } else if (intExtra2 != 10000) {
                return;
            } else {
                cmdMessage = new CmdMessage(intExtra2, intExtra, stringExtra, extras);
            }
            jPushMessageReceiver.onCommandResult(context, cmdMessage);
        } catch (Throwable th) {
            Logger.e("JMessageReceiverHelper", "callCmdMessage failed:" + th.getMessage());
        }
    }

    public void a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        this.f4345b.post(new RunnableC0079a(context, jPushMessageReceiver, intent));
    }
}

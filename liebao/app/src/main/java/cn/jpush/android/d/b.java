package cn.jpush.android.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static CustomMessage a(Intent intent) {
        String stringExtra;
        JSONObject jSONObject;
        CustomMessage customMessage;
        CustomMessage customMessage2 = null;
        try {
            String stringExtra2 = intent.getStringExtra(JThirdPlatFormInterface.KEY_DATA);
            stringExtra = intent.getStringExtra("msgid");
            jSONObject = new JSONObject(stringExtra2);
            customMessage = new CustomMessage();
        } catch (Throwable th) {
            th = th;
        }
        try {
            customMessage.messageId = stringExtra;
            customMessage.appId = intent.getStringExtra("appId");
            customMessage.senderId = intent.getStringExtra("senderId");
            customMessage.message = jSONObject.optString("message", "");
            customMessage.contentType = jSONObject.optString("content_type", "");
            customMessage.title = jSONObject.optString("title", "");
            customMessage.extra = jSONObject.optString("extras", "");
            return customMessage;
        } catch (Throwable th2) {
            th = th2;
            customMessage2 = customMessage;
            Logger.w("MessageHelper", "processMessage failed:" + th.getMessage());
            return customMessage2;
        }
    }

    private static cn.jpush.android.b.b a(d dVar) {
        try {
            cn.jpush.android.b.b a2 = cn.jpush.android.b.b.a(new JSONObject(dVar.g).optJSONObject("geofence"));
            if (a2 != null) {
                a2.t = dVar;
                return a2;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(Context context, int i, long j, long j2) {
        JCoreHelper.sendData(context, JPushConstants.SDK_TYPE, 4, 2, j2, cn.jpush.android.r.b.a(0, (byte) i, j));
    }

    public static void a(Context context, int i, String str, String str2, String str3, long j, byte b2) {
        if (!str2.equals(context.getPackageName())) {
            Logger.e("MessageHelper", "msg appId is not mine pkgname,appid:" + str2 + ",pkgname:" + context.getPackageName());
            return;
        }
        Logger.d("MessageHelper", "action:receivedPushMessage msgId = " + j);
        d a2 = d.a(str, str2, str3, j);
        if (a2 == null || c.a(context, a2.a()) || cn.jpush.android.p.b.c(context, a2)) {
            return;
        }
        a2.W = b2;
        cn.jpush.android.b.b a3 = a(a2);
        if (a3 == null || TextUtils.isEmpty(a3.f4285a)) {
            a(context, a2);
        } else {
            cn.jpush.android.b.d.a(context).a(a3);
        }
    }

    public static void a(Context context, d dVar) {
        Logger.d("MessageHelper", "processBasicEntity type:" + dVar.f4314e);
        dVar.f4314e = dVar.i ? dVar.h == 4 ? 3 : 1 : 2;
        if ((dVar.f4314e & 2) != 0) {
            Logger.d("MessageHelper", "processBasicEntity user-defined message.");
            if (TextUtils.isEmpty(dVar.l) && TextUtils.isEmpty(dVar.o)) {
                Logger.ww("MessageHelper", "no message or extra send to user");
            } else {
                b(context, dVar);
            }
        }
        if ((dVar.f4314e & 1) != 0) {
            Logger.d("MessageHelper", "processBasicEntity notification");
            if (cn.jpush.android.cache.a.c(context)) {
                Logger.i("MessageHelper", "Service is stoped, give up all the message");
                return;
            }
            dVar.a(context);
            if (cn.jpush.android.p.b.c(context)) {
                cn.jpush.android.p.b.a(context, dVar);
                return;
            }
            cn.jpush.android.helper.c.a(dVar.f4312c, 986, context);
            Logger.ii("MessageHelper", "push is invalidPushTime，Intercept the message");
        }
    }

    public static void a(Context context, cn.jpush.android.r.c cVar) {
        a(context, cVar.a(), cVar.b(), cVar.getRid());
        long b2 = cVar.b();
        int a2 = cVar.a();
        String c2 = cVar.c();
        Logger.d("MessageHelper", "msgType = " + a2 + ", msgId = " + b2);
        StringBuilder sb = new StringBuilder();
        sb.append("msgContent: \n");
        sb.append(c2);
        Logger.v("MessageHelper", sb.toString());
        Logger.d("MessageHelper", "msgContent size:" + c2.getBytes().length);
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(c2));
        try {
            String readLine = lineNumberReader.readLine();
            String readLine2 = lineNumberReader.readLine();
            if (readLine == null) {
                Logger.e("MessageHelper", "NO appId");
            } else if (readLine2 == null) {
                Logger.e("MessageHelper", "NO senderId");
            } else {
                int length = readLine.length() + readLine2.length() + 2;
                if (c2.length() <= length + 1) {
                    Logger.d("MessageHelper", "No msgContent");
                    return;
                }
                String substring = c2.substring(length);
                if (!readLine2.equals(JCoreHelper.getAppKey(context))) {
                    Logger.e("MessageHelper", "msg senderId is not mine appkey,senderId:" + readLine2 + ",appkey:" + JCoreHelper.getAppKey(context));
                    return;
                }
                Logger.v("MessageHelper", "Message Fields - appId:" + readLine + ", senderId:" + readLine2 + ", msgContent:" + substring);
                if (a2 != 0 && a2 != 2) {
                    if (a2 == 20) {
                        cn.jpush.android.s.a.a(context, substring, 0, -1L);
                        return;
                    } else if (a2 != 100 && a2 != 101) {
                        Logger.ww("MessageHelper", "unkown msg type");
                        return;
                    }
                }
                a(context, a2, substring, readLine, readLine2, b2, (byte) 0);
            }
        } catch (Throwable th) {
            Logger.e("MessageHelper", "Parse msgContent failed", th);
        }
    }

    public static void b(Context context, d dVar) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.dd("MessageHelper", "not found user push message,use old action to user");
                Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
                intent.putExtra(JPushInterface.EXTRA_APP_KEY, dVar.f4311b);
                intent.putExtra(JPushInterface.EXTRA_MESSAGE, dVar.l);
                intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, dVar.m);
                intent.putExtra(JPushInterface.EXTRA_TITLE, dVar.n);
                intent.putExtra(JPushInterface.EXTRA_EXTRA, dVar.o);
                intent.putExtra(JPushInterface.EXTRA_MSG_ID, dVar.f4312c);
                intent.addCategory(dVar.f4310a);
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent, String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", dVar.f4310a));
                Logger.i("MessageHelper", "Send broadcast to app: " + String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", dVar.f4310a));
            } else {
                Intent intent2 = new Intent(context, Class.forName(messageReceiverClass));
                intent2.setAction(cn.jpush.android.u.a.e(context, "custom_msg"));
                intent2.putExtra(JThirdPlatFormInterface.KEY_DATA, dVar.g);
                intent2.putExtra("msgid", dVar.f4312c);
                intent2.putExtra("appId", dVar.f4310a);
                intent2.putExtra("senderId", dVar.f4311b);
                if (JPushConstants.getPushMessageReceiver(context) != null) {
                    JPushConstants.getPushMessageReceiver(context).onMessage(context, a(intent2));
                } else {
                    context.sendBroadcast(intent2);
                }
            }
            if (dVar.W != 0) {
                cn.jpush.android.helper.c.a(dVar.f4312c, "", dVar.W, 1018, context);
            } else {
                cn.jpush.android.helper.c.a(dVar.f4312c, 1018, context);
            }
        } catch (Throwable th) {
            Logger.e("MessageHelper", "sendBroadcastToApp error:" + th.getMessage());
        }
    }
}

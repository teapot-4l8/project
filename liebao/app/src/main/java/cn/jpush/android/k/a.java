package cn.jpush.android.k;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.d;
import cn.jpush.android.local.JPushAction;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.local.JPushResponse;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.p.e;
import cn.jpush.android.r.c;
import cn.jpush.android.s.b;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.service.SchedulerReceiver;
import com.umeng.analytics.pro.ak;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends JPushAction {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f4371a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f4372b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4373c;

    private static JSONObject a(ByteBuffer byteBuffer) {
        try {
            byteBuffer.getLong();
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            String str = new String(bArr, "UTF-8");
            Logger.d("JPushActionImpl", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e2) {
            Logger.w("JPushActionImpl", "parseBundle2Json exception:" + e2.getMessage());
            return null;
        }
    }

    private static void a(Context context, int i, long j) {
        if (i != 10) {
            switch (i) {
                case 26:
                    d.a().a(context, j, JPushInterface.ErrorCode.TIMEOUT);
                    return;
                case 27:
                    cn.jpush.android.t.a.a().b(context, j);
                    return;
                case 28:
                case 29:
                    break;
                default:
                    return;
            }
        }
        cn.jpush.android.s.a.a(context, b.a().a(j), JPushInterface.ErrorCode.TIMEOUT, j);
    }

    private static void a(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setMaxNotificationNum] bundle is bull");
            return;
        }
        int i = bundle.getInt("num");
        Logger.dd("JPushActionImpl", "action:setMaxNotificationNum :" + i);
        int b2 = e.b();
        Logger.v("JPushActionImpl", "number in queue: " + b2);
        if (i < b2) {
            int i2 = b2 - i;
            Logger.v("JPushActionImpl", "decreaseNotification:" + i2);
            cn.jpush.android.p.b.b(context, i2);
        }
        cn.jpush.android.cache.a.b(context, i);
    }

    private static void a(Context context, JPushResponse jPushResponse) {
        Logger.dd("JPushActionImpl", "action:handleMsg:" + jPushResponse);
        int cmd = jPushResponse.getCmd();
        if (cmd == 3) {
            c cVar = new c(jPushResponse);
            if (cn.jpush.android.cache.a.c(context)) {
                Logger.d("JPushActionImpl", "JPush was stoped");
                if (cVar.a() != 20) {
                    return;
                }
            }
            cn.jpush.android.d.b.a(context, cVar);
            return;
        }
        if (cmd != 10) {
            switch (cmd) {
                case 25:
                    JSONObject a2 = a(jPushResponse.getBody());
                    if (a2 != null) {
                        switch (a2.optInt("cmd")) {
                            case 56:
                                cn.jpush.android.b.d.a(context).a(a2);
                                return;
                            case 57:
                                cn.jpush.android.m.b.a().a(context, a2);
                                return;
                            case 58:
                            default:
                                Logger.d("JPushActionImpl", "Unknown command for ctrl");
                                return;
                            case 59:
                                a(context, a2);
                                return;
                            case 60:
                                cn.jpush.android.p.b.a(context, 2, true);
                                return;
                        }
                    }
                    return;
                case 26:
                    cn.jpush.android.r.a aVar = new cn.jpush.android.r.a(jPushResponse);
                    d.a().a(context, aVar.getRquestId(), aVar.a());
                    return;
                case 27:
                    cn.jpush.android.r.a aVar2 = new cn.jpush.android.r.a(jPushResponse);
                    if (aVar2.a() == 0) {
                        cn.jpush.android.t.a.a().a(context, jPushResponse.getRquestId());
                        return;
                    } else {
                        cn.jpush.android.t.a.a().a(context, jPushResponse.getRquestId(), aVar2.a());
                        return;
                    }
                case 28:
                case 29:
                    break;
                default:
                    Logger.w("JPushActionImpl", "Unknown command for parsing inbound.");
                    return;
            }
        }
        cn.jpush.android.s.a.a(context, new cn.jpush.android.r.e(jPushResponse).a(), jPushResponse.getCmd() != 28 ? 2 : 1, jPushResponse.getRquestId());
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.getJSONObject("content").optString("ids");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            String[] split = optString.split(",");
            LinkedList linkedList = new LinkedList();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    cn.jpush.android.p.b.c(context, cn.jpush.android.p.b.a(str));
                    linkedList.add(str);
                }
            }
            cn.jpush.android.p.b.a(context, linkedList);
        } catch (Throwable th) {
            Logger.w("JPushActionImpl", "dealCancelNotification e:" + th);
        }
    }

    private boolean a(Context context) {
        Boolean bool = this.f4371a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            Logger.ww("JPushActionImpl", "context is null");
            return false;
        }
        this.f4373c = context.getApplicationContext();
        Boolean valueOf = Boolean.valueOf(cn.jpush.android.u.a.g(context));
        this.f4371a = valueOf;
        return valueOf.booleanValue();
    }

    private void b(Context context) {
        Logger.d("JPushActionImpl", "serviceInit...");
        try {
            if (this.f4372b != null) {
                return;
            }
            int i = 1;
            this.f4372b = true;
            int i2 = 2;
            if (JPushConstants.SUPPORT_DY && JConstants.SDK_VERSION_INT >= 220) {
                JCoreHelper.updateDy(context, 2);
            }
            cn.jpush.android.p.b.a(context, 0, true);
            c(context);
            Logger.d("JPushActionImpl", "google:false");
            int i3 = !TextUtils.isEmpty(JPushConstants.SDK_NAME) ? 2 : 0;
            if (JConstants.SDK_VERSION_INT < 220) {
                i = 0;
            }
            if (cn.jpush.android.l.a.f4374a == JPushConstants.SDK_VERSION_CODE) {
                i2 = i;
            }
            Logger.d("JPushActionImpl", "custom:" + i3 + ",dynamic:" + i2);
            cn.jpush.android.p.d.a().a(context, null);
            JCoreHelper.reportSdkType(context, "push", i3, i2, cn.jpush.android.l.a.f4374a);
            if (JPushConstants.canGetLbsInBackGround(context)) {
                cn.jpush.android.b.d.a(context).a();
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setSilenceTime] bundle is bull");
            return;
        }
        String string = bundle.getString("time");
        Logger.dd("JPushActionImpl", "action:setSilenceTime pushTime:" + string);
        cn.jpush.android.cache.a.c(context, string);
    }

    private void c(Context context) {
        try {
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("update", Context.class).invoke(null, context);
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setPushTime] bundle is bull");
            return;
        }
        cn.jpush.android.cache.a.a(context, true);
        String string = bundle.getString("time");
        if (!Pattern.compile("([0-6]{0,7})_((([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3]))|(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])-)+(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])))").matcher(string).matches()) {
            Logger.ee("JPushActionImpl", "Invalid time format - " + string);
            return;
        }
        String f = cn.jpush.android.cache.a.f(context);
        if (string.equals(f)) {
            Logger.dd("JPushActionImpl", "Already SetPushTime, give up - " + f);
            return;
        }
        Logger.dd("JPushActionImpl", "action:setPushTime pushTime:" + string);
        cn.jpush.android.cache.a.b(context, string);
    }

    @Override // cn.jpush.android.local.JPushAction
    public Object beforLogin(Context context, String str, int i, String str2) {
        String str3;
        a(context);
        if (context == null) {
            str3 = "context was null";
        } else if (!TextUtils.isEmpty(str2)) {
            if ("platformtype".equals(str2)) {
                if (i >= 16) {
                    return Byte.valueOf(cn.jpush.android.t.c.a().e(context));
                }
            } else if ("platformregid".equals(str2)) {
                return cn.jpush.android.t.c.a().f(context);
            }
            return null;
        } else {
            str3 = " filed name was empty";
        }
        Logger.e("JPushActionImpl", str3);
        return null;
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPopWinActivity(Context context) {
        return new cn.jpush.android.ui.b();
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPushActivity(Context context) {
        return new cn.jpush.android.ui.c();
    }

    @Override // cn.jpush.android.local.JPushAction
    public String getSdkVersion(String str) {
        return cn.jpush.android.l.a.f4375b;
    }

    @Override // cn.jpush.android.local.JPushAction
    public Object handleAction(Context context, String str, Object obj) {
        String str2;
        int i;
        Logger.d("JPushActionImpl", "handleAction:" + str);
        try {
        } catch (Throwable th) {
            Logger.e("JPushActionImpl", "handleAction failed:" + th.getMessage());
        }
        if (a(context)) {
            if (context == null) {
                context = this.f4373c;
            }
            Context context2 = context;
            if (TextUtils.isEmpty(str)) {
                Logger.w("JPushActionImpl", "action is empty");
                return null;
            }
            Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
            if (str.equals("init")) {
                b(context2);
            } else if (str.equals("resume")) {
                cn.jpush.android.cache.a.a(context2, 0);
                JCoreManager.onEvent(context2, JPushConstants.SDK_TYPE, 1, null, null, new Object[0]);
            } else if (str.equals("stop")) {
                Logger.dd("JPushActionImpl", "The service is stopped, it will give up all the actions until you call resumePush method to resume the service");
                cn.jpush.android.cache.a.a(context2, 1);
                JCoreManager.onEvent(context2, JPushConstants.SDK_TYPE, 0, null, null, new Object[0]);
            } else if (str.equals("clear_all_notify")) {
                cn.jpush.android.p.b.a(context2);
            } else if (str.equals("disable_push")) {
                cn.jpush.android.cache.a.a(context2, false);
            } else if (str.equals("geo_interval")) {
                if (bundle != null) {
                    long j = bundle.getLong(ak.aT, -1L);
                    if (j != -1) {
                        cn.jpush.android.b.d.a(context2).a(j);
                    }
                }
            } else if (str.equals("max_num")) {
                a(context2, bundle);
            } else if (str.equals("set_mobile")) {
                d.a().a(context2, bundle);
            } else if (str.equals("pushtime")) {
                c(context2, bundle);
            } else if (str.equals("silenceTime")) {
                b(context2, bundle);
            } else if (str.equals("geo_fence_max_num")) {
                if (bundle != null && (i = bundle.getInt("num", -1)) > 0) {
                    cn.jpush.android.b.d.a(context2).a(i);
                }
            } else if (str.equals("enable_lbs")) {
                if (bundle != null) {
                    boolean z = bundle.getBoolean("enable", true);
                    cn.jpush.android.cache.a.b(context2, z);
                    if (z) {
                        Logger.dd("JPushActionImpl", "lbs is enabled");
                        cn.jpush.android.b.d.a(context2).a();
                    } else {
                        Logger.dd("JPushActionImpl", "lbs is disabled,stop geo");
                        cn.jpush.android.b.d.a(context2).b();
                    }
                }
            } else if (str.equals("third_enable")) {
                if (bundle != null) {
                    boolean z2 = bundle.getBoolean("enable", true);
                    boolean a2 = cn.jpush.android.l.a.a();
                    if (context2.getPackageName().equals(cn.jpush.android.u.a.c(context2))) {
                        str2 = "third enable:" + z2;
                    } else {
                        str2 = "third enable:" + z2 + ",last :" + a2;
                    }
                    Logger.dd("JPushActionImpl", str2);
                    try {
                        JPushConstants.THIRD_ENABLE = z2;
                    } catch (Throwable unused) {
                    }
                    if (z2) {
                        cn.jpush.android.t.c.a().i(context2);
                    } else {
                        cn.jpush.android.t.c.a().g(context2);
                    }
                }
            } else if (str.equals("delete_geo_fence")) {
                if (bundle != null) {
                    String string = bundle.getString("id");
                    if (!TextUtils.isEmpty(string)) {
                        cn.jpush.android.b.d.a(context2).a(string);
                    }
                }
            } else if (str.equals("set_badge")) {
                if (bundle != null) {
                    int i2 = bundle.getInt("num");
                    Sp.set(context2, Key.BadgeCurNum().set(Integer.valueOf(i2)));
                    cn.jpush.android.p.b.a(context2, (Notification) null, i2, i2);
                }
            } else if (str.equals(JThirdPlatFormInterface.KEY_MSG)) {
                if (obj instanceof JPushResponse) {
                    a(context2, (JPushResponse) obj);
                }
            } else if (str.equals("msg_time_out")) {
                if (bundle != null) {
                    a(context2, bundle.getInt("cmd", -1), bundle.getLong("rid", -1L));
                }
            } else if (str.equals("tagalis")) {
                cn.jpush.android.s.a.a(context2, bundle);
            } else if (str.equals("add_local_notify")) {
                if (bundle != null) {
                    cn.jpush.android.n.a.a(context2).a(context2, (JPushLocalNotification) bundle.getSerializable("local_notify"));
                }
            } else if (str.equals("rm_local_notify")) {
                if (bundle != null) {
                    cn.jpush.android.n.a.a(context2).a(context2, bundle.getLong("local_notify_ID"));
                }
            } else if (str.equals("clear_local_notify")) {
                cn.jpush.android.n.a.a(context2).b(context2);
            } else if (str.equals("show_local_notify")) {
                if (cn.jpush.android.cache.a.c(context2)) {
                    Logger.dd("JPushActionImpl", "push has stoped");
                } else if (bundle != null) {
                    String string2 = bundle.getString("local_notify_msg");
                    if (TextUtils.isEmpty(string2)) {
                        Logger.d("JPushActionImpl", "local message is empty");
                    } else {
                        cn.jpush.android.d.d a3 = cn.jpush.android.d.d.a(string2, context2.getPackageName(), JCoreHelper.getAppKey(context2), 0L);
                        if (a3 != null) {
                            a3.a(context2);
                            cn.jpush.android.p.b.a(context2, a3);
                        }
                    }
                }
            } else if (str.equals("set_custom_notify")) {
                if (bundle != null) {
                    int i3 = bundle.getInt("buidler_id", -1);
                    String string3 = bundle.getString("buidler_string");
                    Logger.d("JPushActionImpl", "builderId:" + i3 + ",buildString:" + string3);
                    if (i3 >= 0 && !TextUtils.isEmpty(string3)) {
                        cn.jpush.android.cache.a.a(context2, i3 + "", string3);
                    }
                }
            } else if ("third_push_upload_regid".equals(str)) {
                if (bundle != null) {
                    cn.jpush.android.t.c.a().a(context2, bundle);
                }
            } else if (JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_ON_MESSAGING.equals(str)) {
                String string4 = bundle.getString("appId");
                String string5 = bundle.getString("senderId");
                String string6 = bundle.getString("JMessageExtra");
                byte b2 = bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM);
                Logger.d("JPushActionImpl", "appId:" + string4 + ",senderId:" + string5 + ",JMessageExtra:" + string6);
                if (TextUtils.isEmpty(string6)) {
                    return null;
                }
                cn.jpush.android.d.b.a(context2, 2, string6, TextUtils.isEmpty(string4) ? context2.getPackageName() : string4, TextUtils.isEmpty(string5) ? JCoreHelper.getAppKey(context2) : string5, 0L, b2);
            } else if ("change_foreground".equals(str)) {
                if (bundle != null) {
                    boolean z3 = bundle.getBoolean("foreground");
                    if (JPushConstants.isForeGround == -1 && z3) {
                        Logger.d("JPushActionImpl", "first in foreground");
                        cn.jpush.android.b.d.a(context2).a();
                    }
                    JPushConstants.isForeGround = z3 ? 0 : 1;
                    Logger.d("JPushActionImpl", "change foregroud:" + JPushConstants.isForeGround);
                    if (z3) {
                        cn.jpush.android.p.b.a(context2, 1, false);
                    }
                }
            } else if ("jcore_on_event".equals(str)) {
                if (bundle != null) {
                    int i4 = bundle.getInt(com.umeng.analytics.pro.d.y);
                    int i5 = bundle.getInt(JThirdPlatFormInterface.KEY_CODE);
                    String string7 = bundle.getString(JThirdPlatFormInterface.KEY_MSG);
                    if (i4 != -1 && i4 != 0 && i4 != 1) {
                        if (i4 == 19) {
                            cn.jpush.android.n.a.a(context2).d(context2);
                        }
                    }
                    cn.jpush.android.p.b.a(context2, i4, i5, string7);
                    if (i4 == 1) {
                        JPushConstants.setTcpConnected(true);
                        cn.jpush.android.t.c.a().h(context2);
                    } else if (i4 == -1) {
                        JPushConstants.setTcpConnected(false);
                    }
                }
            } else if ("handle_msg".equals(str)) {
                if (obj instanceof Intent) {
                    Intent intent = (Intent) obj;
                    String action = intent.getAction();
                    Logger.dd("JPushActionImpl", "handle third message:" + action);
                    if (JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID.equals(action)) {
                        cn.jpush.android.t.c.a().b(context2, intent != null ? intent.getExtras() : new Bundle());
                    }
                }
            } else if ("third_init".equals(str)) {
                cn.jpush.android.t.c.a().b(context2);
            } else if ("third_resume".equals(str)) {
                cn.jpush.android.t.c.a().c(context2);
            } else if ("third_stop".equals(str)) {
                cn.jpush.android.t.c.a().d(context2);
            } else if ("third_action".equals(str)) {
                if (bundle != null) {
                    cn.jpush.android.t.c.a().a(context2, bundle.getString("third_key_action"), bundle);
                }
            } else if (SchedulerReceiver.DELAY_NOTIFY.equals(str)) {
                cn.jpush.android.p.d.a().a(context2, null);
            }
            return null;
        }
        return null;
    }

    @Override // cn.jpush.android.local.JPushAction
    public void handleNotificationIntent(Context context, Intent intent) {
        cn.jpush.android.d.d a2 = cn.jpush.android.p.b.a(context, intent);
        Logger.i("JPushActionImpl", "handleNotificationIntent:" + a2);
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()) && a2.k != 1) {
            if (a2.W == 0) {
                cn.jpush.android.helper.c.a(a2.f4312c, 1000, context);
            } else {
                JPushInterface.reportNotificationOpened(context, a2.f4312c, a2.W);
            }
            if (cn.jpush.android.p.b.d(context, a2) == 2) {
                return;
            }
        }
        cn.jpush.android.p.b.a(context, intent.getAction(), a2, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        cn.jpush.android.helper.a.a().a(context.getApplicationContext(), jPushMessageReceiver, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMessage(Context context, CustomMessage customMessage) {
        cn.jpush.android.helper.a.a(context, customMessage);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMultiAction(Context context, Intent intent) {
        cn.jpush.android.helper.a.a(context, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_RECEIVED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_OPENED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onTagAliasResponse(Context context, long j, int i, Intent intent) {
        cn.jpush.android.s.c.a().a(context.getApplicationContext(), j, i, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void setAliasAndTags(Context context, String str, Set<String> set, CallBackParams callBackParams) {
        cn.jpush.android.s.a.a(context, str, set, callBackParams);
    }
}

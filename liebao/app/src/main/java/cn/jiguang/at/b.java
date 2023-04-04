package cn.jiguang.at;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JPushInterface;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f3925b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f3926c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, JDispatchAction> f3924a = new HashMap<>();

    private b() {
        HashMap<String, String> actionMap = ActionManager.getActionMap();
        if (actionMap instanceof HashMap) {
            StringBuilder sb = new StringBuilder("actiom map size:");
            HashMap<String, String> hashMap = actionMap;
            sb.append(hashMap.size());
            cn.jiguang.an.d.b("DispatchActionManager", sb.toString());
            a(hashMap);
            b(JConstants.SDK_TYPE, cn.jiguang.c.a.class.getCanonicalName());
        }
    }

    public static byte a(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 23, "platformtype");
                if (beforLogin instanceof Byte) {
                    return ((Byte) beforLogin).byteValue();
                }
            }
        }
        return (byte) 0;
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        return (Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8) + Integer.parseInt(split[2]);
    }

    public static b a() {
        if (f3925b == null) {
            synchronized (f3926c) {
                if (f3925b == null) {
                    f3925b = new b();
                }
            }
        }
        return f3925b;
    }

    public static String a(String str, String str2) {
        String str3;
        JDispatchAction jDispatchAction = f3924a.get(str);
        if (jDispatchAction != null) {
            String sdkVersion = jDispatchAction.getSdkVersion(str);
            if (!TextUtils.isEmpty(sdkVersion)) {
                return sdkVersion;
            }
            str3 = str + " sdk action sdkversion:" + sdkVersion;
        } else {
            str3 = str + " sdk action is null";
        }
        cn.jiguang.an.d.a("DispatchActionManager", str3);
        return str2;
    }

    public static void a(Context context, cn.jiguang.av.c cVar, ByteBuffer byteBuffer) {
        if (cVar == null) {
            cn.jiguang.an.d.f("DispatchActionManager", "Action - dispatchMessage unexcepted - head was null");
            return;
        }
        c b2 = n.a().b(cVar.f3987e);
        if (b2 == null) {
            for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && value.isSupportedCMD(entry.getKey(), cVar.f3985c)) {
                    value.dispatchMessage(context, entry.getKey(), cVar.f3985c, cVar.f3984b, cVar.f3987e, -1L, byteBuffer);
                }
            }
            return;
        }
        cn.jiguang.an.d.b("DispatchActionManager", "dispacth msg with reuqest :" + b2);
        JDispatchAction jDispatchAction = f3924a.get(b2.f3929c);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchMessage(context, b2.f3929c, cVar.f3985c, cVar.f3984b, cVar.f3987e, b2.f3928b, byteBuffer);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("rid", cVar.f3987e);
        h.a().a(context, "tcp_a7", bundle);
    }

    public static void a(Context context, String str, long j, int i) {
        if (TextUtils.isEmpty(str) || !str.equals(JConstants.SDK_TYPE)) {
            JDispatchAction jDispatchAction = f3924a.get(str);
            if (jDispatchAction != null) {
                jDispatchAction.dispatchTimeOutMessage(context, str, j, i);
                return;
            }
            cn.jiguang.an.d.f("DispatchActionManager", "not found dispatch action by sdktype:" + str);
        } else if (i == 26) {
            p.a().a(j);
        } else if (i == 30 || i == 32) {
            cn.jiguang.e.a.a().a(context, i);
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            cn.jiguang.an.d.g("DispatchActionManager", "run action bundle is null");
        } else if (TextUtils.isEmpty(str)) {
            cn.jiguang.an.d.g("DispatchActionManager", "run action sdktype is empty");
        } else {
            if (JConstants.SDK_TYPE.contains(str)) {
                str = JConstants.SDK_TYPE;
            }
            JDispatchAction jDispatchAction = f3924a.get(str);
            if (jDispatchAction != null) {
                jDispatchAction.onActionRun(context, str, bundle.getString("internal_action"), bundle);
                return;
            }
            cn.jiguang.an.d.g("DispatchActionManager", "dispacth action is null by sdktype:" + str);
        }
    }

    private void a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            cn.jiguang.an.d.f("DispatchActionManager", "init map is empty");
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            b(entry.getKey(), entry.getValue());
        }
    }

    public static boolean a(int i) {
        for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                try {
                    cn.jiguang.an.d.c("DispatchActionManager", "isAllowAction actionType:0,sdktype:" + entry.getKey() + ",action:" + value.checkAction(entry.getKey(), 0));
                    if (!value.checkAction(entry.getKey(), 0)) {
                        return false;
                    }
                } catch (Throwable th) {
                    cn.jiguang.an.d.f("DispatchActionManager", "isAllowAction error:" + th.getMessage());
                }
            }
        }
        return true;
    }

    public static String b(int i) {
        for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && value.getRegPriority(entry.getKey()) == i) {
                return value.getSdkVersion(entry.getKey());
            }
        }
        return "";
    }

    public static String b(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 23, "platformregid");
                if (beforLogin instanceof String) {
                    return (String) beforLogin;
                }
            }
        }
        return "";
    }

    public static short b() {
        short regFlag;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (regFlag = value.getRegFlag(entry.getKey())) != 0) {
                s = (short) (s | regFlag);
            }
        }
        return s;
    }

    private static void b(String str, String str2) {
        cn.jiguang.an.d.b("DispatchActionManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (f3924a.containsKey(str)) {
            cn.jiguang.an.d.b("DispatchActionManager", "has same type action");
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (!(newInstance instanceof JDispatchAction)) {
                cn.jiguang.an.d.f("DispatchActionManager", "this action is not a JDispatchAction,please check and extends JDispatchAction");
                return;
            }
            f3924a.put(str, (JDispatchAction) newInstance);
            cn.jiguang.an.d.b("DispatchActionManager", "action init:" + newInstance.getClass().getName());
        } catch (Throwable th) {
            cn.jiguang.an.d.g("DispatchActionManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public static short c() {
        short loginFlag;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (loginFlag = value.getLoginFlag(entry.getKey())) != 0) {
                s = (short) (s | loginFlag);
            }
        }
        return s;
    }

    public static String d() {
        StringBuilder sb;
        JDispatchAction value;
        short s = 3;
        for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
            short regPriority = entry.getValue().getRegPriority(entry.getKey());
            if (s < regPriority) {
                s = regPriority;
            }
        }
        cn.jiguang.an.d.b("DispatchActionManager", "max reg priority:" + ((int) s));
        String str = "";
        for (int i = 0; i <= s; i++) {
            if (i == 3) {
                sb = new StringBuilder();
                sb.append(str);
                str = cn.jiguang.a.a.f3640b;
            } else {
                Iterator<Map.Entry<String, JDispatchAction>> it = f3924a.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, JDispatchAction> next = it.next();
                    if (next.getValue().getRegPriority(next.getKey()) == i) {
                        str = str + value.getSdkVersion(next.getKey());
                        break;
                    }
                }
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append("|");
            str = sb.toString();
        }
        return str.substring(0, str.length() - 1);
    }

    public static String e() {
        JDispatchAction value;
        String str = a(cn.jiguang.a.a.f3640b) + "|";
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
            short logPriority = entry.getValue().getLogPriority(entry.getKey());
            if (s < logPriority) {
                s = logPriority;
            }
        }
        cn.jiguang.an.d.b("DispatchActionManager", "max login priority:" + ((int) s));
        for (int i = 1; i <= s; i++) {
            Iterator<Map.Entry<String, JDispatchAction>> it = f3924a.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, JDispatchAction> next = it.next();
                    if (next.getValue().getLogPriority(next.getKey()) == i) {
                        str = str + a(value.getSdkVersion(next.getKey()));
                        break;
                    }
                }
            }
            str = str + "|";
        }
        return str.substring(0, str.length() - 1);
    }

    public final void a(Context context, int i, int i2, String str) {
        for (Map.Entry<String, JDispatchAction> entry : f3924a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                value.onEvent(context, entry.getKey(), i, i2, str);
            }
        }
        Intent intent = null;
        try {
            if (i == 0 && i2 == 0) {
                intent = new Intent(JPushInterface.ACTION_REGISTRATION_ID);
                intent.putExtra(JPushInterface.EXTRA_REGISTRATION_ID, str);
            } else if (i == -1 || i == 1) {
                intent = new Intent(JPushInterface.ACTION_CONNECTION_CHANGE);
                if (i == -1) {
                    intent.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                } else {
                    intent.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, true);
                }
            }
            if (intent != null) {
                String packageName = context.getPackageName();
                intent.addCategory(packageName);
                intent.setPackage(packageName);
                cn.jiguang.f.a.a(context, intent);
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.f("DispatchActionManager", "sendToOldPushUser failed:" + th.getMessage());
        }
    }
}

package cn.jiguang.c;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.am.c;
import cn.jiguang.am.e;
import cn.jiguang.an.d;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.ao.k;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.at.h;
import cn.jiguang.f.i;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreHelperAction;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b extends JCoreHelperAction {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4044a = false;

    private static Bundle a(Context context, int i, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            if (i == 4096) {
                if (bundle != null) {
                    cn.jiguang.am.a.a(context, cn.jiguang.am.a.a(bundle, "arg1"));
                }
                return bundle2;
            } else if (i == 4098) {
                JCoreManager.init(context);
                return bundle2;
            } else {
                if (i == 36865 && JCoreManager.isInternal()) {
                    JConstants.testAndroidQ();
                }
                return null;
            }
        } catch (Throwable th) {
            d.h("JCoreHelper", "si e:" + th);
            return null;
        }
    }

    public static Object a(Context context) {
        return cn.jiguang.at.d.a(context, "deviceinfo", null);
    }

    private static void a(Context context, String str, Bundle bundle, String str2) {
        if (bundle != null) {
            bundle.putString(ak.u, str);
            cn.jiguang.a.a.a(context, str2, bundle);
        }
    }

    public static void a(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        d.c("JCoreHelper", "runActionWithService action:" + str2);
        bundle.putString(ak.u, str);
        bundle.putString("internal_action", str2);
        cn.jiguang.a.a.a(context, "a3", bundle);
    }

    public static Pair<String, Integer> b(Context context) {
        return cn.jiguang.am.a.c(context);
    }

    private static boolean c(Context context) {
        try {
            Bundle a2 = e.a().a(context, "INTERNAL_API", "isTcpLoggedIn", null, c.a(context));
            return (a2 == null || !a2.containsKey("state")) ? h.a().d() : a2.getBoolean("state");
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public final Bundle directHandle(Context context, String str, String str2, Bundle bundle) {
        e.a();
        return e.b(context, str, str2, bundle);
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public final Object onCommonMethod(Context context, String str, Object obj) {
        return cn.jiguang.at.d.a(context, str, obj);
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public final Object onEvent(Context context, String str, int i, String str2, Bundle bundle, Object... objArr) {
        Context appContext;
        boolean z;
        Bundle bundle2;
        String str3;
        Object obj;
        Bundle bundle3;
        String str4;
        Bundle bundle4;
        String str5;
        Bundle bundle5;
        Class<?> cls;
        Method declaredMethod;
        Boolean bool;
        boolean z2;
        String str6;
        Boolean bool2;
        try {
            appContext = JConstants.getAppContext(context);
            z = false;
        } catch (Throwable th) {
            d.f("JCoreHelper", "onEvent:" + th);
            return null;
        }
        switch (i) {
            case 0:
                bundle2 = new Bundle();
                bundle2.putString(ak.u, str);
                str3 = "tcp_a8";
                cn.jiguang.a.a.a(appContext, str3, bundle2);
                return null;
            case 1:
                bundle2 = new Bundle();
                bundle2.putString(ak.u, str);
                str3 = "tcp_a9";
                cn.jiguang.a.a.a(appContext, str3, bundle2);
                return null;
            case 2:
                cn.jiguang.a.a.b(appContext, str2, bundle);
                return null;
            case 3:
                a(appContext, str, str2, bundle);
                return null;
            case 4:
                return cn.jiguang.d.a.b(appContext);
            case 5:
                return cn.jiguang.d.a.c(appContext);
            case 6:
                return cn.jiguang.am.a.b(appContext);
            case 7:
                return cn.jiguang.am.a.a(appContext);
            case 8:
                return cn.jiguang.d.a.e(appContext);
            case 9:
                cn.jiguang.am.a.a(appContext, str2);
                return null;
            case 10:
                cn.jiguang.a.a.a(appContext, str2, bundle);
                return null;
            case 11:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                    return null;
                }
                cn.jiguang.ba.a.a(str2, (Runnable) objArr[0]);
                return null;
            case 12:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                    return null;
                }
                cn.jiguang.ba.a.a("ASYNC", (Runnable) objArr[0]);
                return null;
            case 13:
            case 32:
            case 33:
            case 52:
            default:
                return null;
            case 14:
                obj = (objArr == null || objArr.length <= 0) ? null : objArr[0];
                k.a(appContext, str, obj);
                return null;
            case 15:
                if (objArr == null || objArr.length <= 1 || !(objArr[1] instanceof ReportCallBack)) {
                    return null;
                }
                k.a(appContext, (JSONObject) objArr[0], (ReportCallBack) objArr[1]);
                return null;
            case 16:
                bundle3 = bundle;
                str4 = "tcp_a3";
                a(appContext, str, bundle3, str4);
                return null;
            case 17:
                bundle3 = bundle;
                str4 = "tcp_a5";
                a(appContext, str, bundle3, str4);
                return null;
            case 18:
                if (objArr == null || objArr.length <= 2) {
                    return null;
                }
                if (objArr.length > 3 && (objArr[3] instanceof Throwable)) {
                    Throwable th2 = (Throwable) objArr[3];
                }
                cn.jiguang.an.a.a(str, str2, ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[0]).intValue(), (String) objArr[2]);
                return null;
            case 19:
                return (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) ? Long.valueOf(cn.jiguang.d.b.a(appContext, System.currentTimeMillis())) : Long.valueOf(cn.jiguang.d.b.a(appContext, ((Long) objArr[0]).longValue()));
            case 20:
                return Long.valueOf(cn.jiguang.d.a.d(appContext));
            case 21:
                return Boolean.valueOf(cn.jiguang.d.b.a(appContext));
            case 22:
                cn.jiguang.g.b.a(appContext, cn.jiguang.g.a.m().a((cn.jiguang.g.a<String>) str2));
                return null;
            case 23:
                if (JConstants.INTERNAL_USE) {
                    JConstants.testCountry = str2;
                    return null;
                }
                return null;
            case 24:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Integer)) {
                    return null;
                }
                new Bundle().putInt("cmd", ((Integer) objArr[0]).intValue());
                a(appContext, JConstants.SDK_TYPE, "old_cmd", (Bundle) null);
                return null;
            case 25:
                return Integer.valueOf(cn.jiguang.a.a.f3641c);
            case 26:
                if (objArr != null && objArr.length > 1 && (objArr[0] instanceof JSONObject) && (objArr[1] == null || (objArr[1] instanceof String))) {
                    return cn.jiguang.d.a.a(appContext, (JSONObject) objArr[0], (String) objArr[1]);
                }
                if (objArr == null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                    bundle4 = new Bundle();
                    bundle4.putBoolean("enable", ((Boolean) objArr[0]).booleanValue());
                    str5 = "lbsenable";
                    a(appContext, JConstants.SDK_TYPE, str5, bundle4);
                    return null;
                }
                return null;
            case 27:
                return objArr == null ? null : null;
            case 28:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) {
                    return null;
                }
                bundle4 = new Bundle();
                bundle4.putLong("forenry", ((Long) objArr[0]).longValue());
                str5 = "lbsforenry";
                a(appContext, JConstants.SDK_TYPE, str5, bundle4);
                return null;
            case 29:
                if (objArr != null) {
                    if ((objArr.length > 0) && (objArr[0] instanceof Integer)) {
                        bundle5 = new Bundle();
                        bundle5.putInt("scence", ((Integer) objArr[0]).intValue());
                        a(appContext, JConstants.SDK_TYPE, "notification_state", bundle5);
                        return null;
                    }
                    return null;
                }
                return null;
            case 30:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Integer)) {
                    return null;
                }
                return a(appContext, ((Integer) objArr[0]).intValue(), bundle);
            case 31:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Intent)) {
                    return null;
                }
                ActionManager.getInstance().handleMessage(appContext, str, objArr[0]);
                Intent intent = (Intent) objArr[0];
                cn.jiguang.at.d.a(appContext, "get_receiver", intent);
                String action = intent.getAction();
                if (action == null) {
                    str6 = "onReceive empty action";
                } else if (action.equals("android.intent.action.USER_PRESENT")) {
                    d.d("JCoreHelper", "onReceiveandroid.intent.action.USER_PRESENT");
                    cn.jiguang.a.a.a(appContext, true, 0L);
                    return null;
                } else if (!action.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {
                    if (!action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") && !action.equals("android.os.action.POWER_SAVE_MODE_CHANGED")) {
                        if (action.equals("noti_open_proxy") && intent.getBooleanExtra("debug_notification", false)) {
                            String stringExtra = intent.getStringExtra("toastText");
                            if (TextUtils.isEmpty(stringExtra)) {
                                return null;
                            }
                            Toast makeText = Toast.makeText(appContext, stringExtra, 0);
                            try {
                                View view = makeText.getView();
                                if (view instanceof LinearLayout) {
                                    View childAt = ((LinearLayout) view).getChildAt(0);
                                    if (childAt instanceof TextView) {
                                        TextView textView = (TextView) childAt;
                                        if (!i.a(stringExtra)) {
                                            textView.setText(stringExtra);
                                        }
                                        textView.setTextSize(13.0f);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            makeText.show();
                            return null;
                        }
                        return null;
                    }
                    PowerManager powerManager = (PowerManager) appContext.getSystemService("power");
                    if (powerManager == null || (cls = Class.forName("android.os.PowerManager")) == null) {
                        return null;
                    }
                    if (action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) {
                        Method declaredMethod2 = cls.getDeclaredMethod("isDeviceIdleMode", new Class[0]);
                        if (declaredMethod2 != null) {
                            bool = (Boolean) declaredMethod2.invoke(powerManager, new Object[0]);
                            z2 = bool.booleanValue();
                        }
                        z2 = true;
                    } else {
                        if (action.equals("android.os.action.POWER_SAVE_MODE_CHANGED") && (declaredMethod = cls.getDeclaredMethod("isPowerSaveMode", new Class[0])) != null) {
                            bool = (Boolean) declaredMethod.invoke(powerManager, new Object[0]);
                            z2 = bool.booleanValue();
                        }
                        z2 = true;
                    }
                    if (z2) {
                        return null;
                    }
                    d.b("JCoreHelper", "doze or powersave mode exit.");
                    cn.jiguang.a.a.a(appContext, true, 0L);
                    return null;
                } else {
                    NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo != null) {
                        d.b("JCoreHelper", "Connection state changed to - " + networkInfo.toString());
                        if (2 != networkInfo.getType() && 3 != networkInfo.getType()) {
                            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                            Bundle extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            if (booleanExtra) {
                                d.b("JCoreHelper", "No any network is connected");
                                extras.putBoolean("connected", false);
                            } else if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                                d.b("JCoreHelper", "Network is connected.");
                                extras.putBoolean("connected", true);
                            } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                                d.b("JCoreHelper", "Network is disconnected.");
                                extras.putBoolean("connected", false);
                            } else {
                                d.b("JCoreHelper", "other network state - " + networkInfo.getState() + ". Do nothing.");
                            }
                            cn.jiguang.a.a.a(appContext, "tcp_a15", extras);
                            return null;
                        }
                        d.b("JCoreHelper", "MMS or SUPL network state change, to do nothing!");
                        return null;
                    }
                    str6 = "Not found networkInfo";
                }
                d.f("JCoreHelper", str6);
                return null;
            case 34:
                return cn.jiguang.d.a.f(appContext);
            case 35:
                if (objArr != null && objArr.length > 2 && (objArr[0] instanceof Long) && (objArr[1] instanceof String) && (objArr[2] instanceof String)) {
                    cn.jiguang.g.b.a(appContext, cn.jiguang.g.a.c().a((cn.jiguang.g.a<Long>) Long.valueOf(((Long) objArr[0]).longValue())), cn.jiguang.g.a.e().a((cn.jiguang.g.a<String>) ((String) objArr[1])), cn.jiguang.g.a.d().a((cn.jiguang.g.a<String>) ((String) objArr[2])));
                    return null;
                }
                return null;
            case 36:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                    return null;
                }
                cn.jiguang.bb.b.a(appContext, (String) objArr[0]);
                return null;
            case 37:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) {
                    return null;
                }
                cn.jiguang.d.b.b(appContext, ((Long) objArr[0]).longValue());
                return null;
            case 38:
                cn.jiguang.g.b.a(appContext, "cn.jiguang.sdk.user.profile");
                return null;
            case 39:
                k.a(appContext, objArr != null ? objArr[0] : null);
                return null;
            case 40:
                if (objArr == null || objArr.length <= 1 || !(objArr[0] instanceof Boolean) || !(objArr[1] instanceof Long)) {
                    return null;
                }
                cn.jiguang.a.a.a(appContext, ((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue());
                return null;
            case 41:
                if (objArr == null || objArr.length <= 1 || !(objArr[0] instanceof String) || !(objArr[1] instanceof JSONObject)) {
                    return null;
                }
                return Boolean.valueOf(k.a(appContext, (String) objArr[0], (JSONObject) objArr[1]));
            case 42:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                    return null;
                }
                return cn.jiguang.d.a.a(appContext, (String) objArr[0]);
            case 43:
                return ActionManager.getActionMap();
            case 44:
                if (objArr == null || objArr.length <= 1 || !(objArr[0] instanceof String) || !(objArr[1] instanceof Long)) {
                    return null;
                }
                cn.jiguang.g.b.a(appContext, cn.jiguang.g.a.i().a((cn.jiguang.g.a<String>) ((String) objArr[0])), cn.jiguang.g.a.j().a((cn.jiguang.g.a<Long>) Long.valueOf(((Long) objArr[1]).longValue())));
                return null;
            case 45:
                return cn.jiguang.d.a.g(appContext);
            case 46:
                return Integer.valueOf(cn.jiguang.d.a.h(appContext));
            case 47:
                return Integer.valueOf(cn.jiguang.d.a.j(appContext));
            case 48:
                cn.jiguang.ao.d.a(appContext);
                return null;
            case 49:
                return true;
            case 50:
                bundle3 = bundle;
                str4 = "tcp_a4";
                a(appContext, str, bundle3, str4);
                return null;
            case 51:
                if (objArr != null && objArr.length == 1 && (objArr[0] instanceof Integer)) {
                    cn.jiguang.g.b.a(appContext, cn.jiguang.g.a.f().a((cn.jiguang.g.a<Integer>) Integer.valueOf(((Integer) objArr[0]).intValue())));
                    return null;
                }
                return null;
            case 53:
                return Boolean.valueOf(cn.jiguang.am.b.a().d());
            case 54:
                if (objArr == null || objArr.length <= 2) {
                    return null;
                }
                int intValue = ((Integer) objArr[1]).intValue();
                int intValue2 = ((Integer) objArr[2]).intValue();
                Bundle bundle6 = new Bundle();
                bundle6.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, (String) objArr[0]);
                bundle6.putInt("custom", intValue);
                bundle6.putInt("dynamic", intValue2);
                cn.jiguang.at.d.a(appContext, "set_sdktype_info", bundle6);
                return null;
            case 55:
                if (bundle != null && !bundle.isEmpty()) {
                    try {
                        d.b("JCoreHelper", "setSDKConfigs");
                        int i2 = 86400;
                        try {
                            int i3 = bundle.getInt("heartbeat_interval", JConstants.DEFAULT_HEARTBEAT_INTERVAL);
                            if (i3 < 30) {
                                i3 = 30;
                            } else if (i3 > 86400) {
                                i3 = 86400;
                            }
                            JConstants.DEFAULT_HEARTBEAT_INTERVAL = i3;
                            d.b("JCoreHelper", "set heartbeat interval=" + i3);
                        } catch (Throwable unused2) {
                        }
                        try {
                            int i4 = bundle.getInt("alarm_delay", JConstants.DEFAULT_ALARM_DELAY);
                            if (i4 <= 86400) {
                                i2 = i4;
                            }
                            if (i2 < JConstants.DEFAULT_HEARTBEAT_INTERVAL + 5) {
                                i2 = JConstants.DEFAULT_HEARTBEAT_INTERVAL + 5;
                            }
                            JConstants.DEFAULT_ALARM_DELAY = i2;
                            d.b("JCoreHelper", "set alarm delay=" + i2);
                        } catch (Throwable unused3) {
                        }
                        byte b2 = (byte) bundle.getInt("tcp_algorithm", -1);
                        if (b2 >= 0) {
                            JConstants.tcpAlgorithm = b2;
                            d.b("JCoreHelper", "set tcp algorithm=" + ((int) b2));
                        }
                        if (bundle.containsKey("tcp_report")) {
                            k.f3788b = bundle.getBoolean("tcp_report");
                        }
                        int i5 = bundle.getInt("ipv_config", -1);
                        cn.jiguang.au.c.a(i5);
                        if (i5 != 2 && i5 != 3) {
                            if (i5 == 0 || i5 == 1) {
                                k.f3789c = true;
                                return null;
                            }
                            return null;
                        }
                        k.f3789c = false;
                        return null;
                    } catch (Throwable unused4) {
                        return null;
                    }
                }
                return null;
            case 56:
                if ("resume".equals(str2)) {
                    if (JConstants.isInstrumentationHookFailed) {
                        PushSA.getInstance().onResume(appContext);
                        return null;
                    }
                    return null;
                } else if ("pause".equals(str2)) {
                    if (JConstants.isInstrumentationHookFailed) {
                        PushSA.getInstance().onPause(appContext);
                        return null;
                    }
                    return null;
                } else if ("kill".equals(str2)) {
                    PushSA.getInstance().onKillProcess(appContext);
                    return null;
                } else if ("enable".equals(str2)) {
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Boolean)) {
                        return null;
                    }
                    PushSA.getInstance().setStatEnable(((Boolean) objArr[0]).booleanValue());
                    return null;
                } else if ("s_timeout".equals(str2)) {
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) {
                        return null;
                    }
                    PushSA.getInstance().setInterval(((Long) objArr[0]).longValue());
                    return null;
                } else if ("f_resume".equals(str2)) {
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                        return null;
                    }
                    PushSA.getInstance().onFragmentResume(appContext, (String) objArr[0]);
                    return null;
                } else if (!"f_pause".equals(str2) || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                    return null;
                } else {
                    PushSA.getInstance().onFragmentPause(appContext, (String) objArr[0]);
                    return null;
                }
            case 57:
                if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Integer)) {
                    return null;
                }
                d.b("JCoreHelper", "SET_SHARE_PROCESS_STATE state:" + objArr[0]);
                cn.jiguang.g.b.a(appContext, cn.jiguang.g.a.k().a((cn.jiguang.g.a<Integer>) Integer.valueOf(((Integer) objArr[0]).intValue())));
                return null;
            case 58:
                return Boolean.valueOf(cn.jiguang.d.a.i(appContext));
            case 59:
                bundle3 = bundle;
                str4 = "tcp_a20";
                a(appContext, str, bundle3, str4);
                return null;
            case 60:
                String str7 = "unknown msg";
                if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                    z = ((Boolean) objArr[0]).booleanValue();
                }
                if (objArr != null && objArr.length > 1 && (objArr[1] instanceof String)) {
                    str7 = (String) objArr[1];
                }
                return Boolean.valueOf(JConstants.isAndroidQ(appContext, z, str7));
            case 61:
                if (objArr == null || objArr.length <= 6) {
                    return null;
                }
                k.a(appContext, ((Integer) objArr[0]).intValue(), (JSONObject) objArr[1], (byte[]) objArr[2], ((Integer) objArr[3]).intValue(), (File) objArr[4], (Set) objArr[5], (ReportCallBack) objArr[6]);
                return null;
            case 62:
                if (objArr == null || objArr.length <= 0) {
                    return null;
                }
                e.a().a(appContext, (String) objArr[0], str2, bundle);
                return null;
            case 63:
                if (objArr == null || objArr.length <= 1) {
                    return null;
                }
                return e.a().a(appContext, (String) objArr[0], str2, bundle, (String) objArr[1]);
            case 64:
                if (objArr != null && objArr.length == 1 && (objArr[0] instanceof Integer)) {
                    return cn.jiguang.dy.b.b(appContext, ((Integer) objArr[0]).intValue());
                }
                return null;
            case 65:
                if (objArr != null && objArr.length == 1 && (objArr[0] instanceof Integer)) {
                    cn.jiguang.dy.b.a();
                    cn.jiguang.dy.b.a(appContext, ((Integer) objArr[0]).intValue(), "");
                    return null;
                }
                return null;
            case 66:
                if (objArr == null || objArr.length <= 0 || (bool2 = (Boolean) objArr[0]) == null) {
                    return null;
                }
                boolean booleanValue = bool2.booleanValue();
                d.b("JCoreHelper", "changeForegroudStat:" + booleanValue);
                this.f4044a = booleanValue;
                Bundle bundle7 = new Bundle();
                bundle7.putBoolean("foreground", this.f4044a);
                cn.jiguang.a.a.a(appContext, "a4", bundle7);
                if (!bool2.booleanValue()) {
                    obj = null;
                    k.a(appContext, (Object) null);
                    k.a(appContext, str, obj);
                    return null;
                }
                cn.jiguang.a.a.a(appContext, false, 0L);
                bundle5 = new Bundle();
                bundle5.putInt("scence", 1);
                a(appContext, JConstants.SDK_TYPE, "notification_state", bundle5);
                return null;
            case 67:
                return Boolean.valueOf(c(appContext));
            case 68:
                return cn.jiguang.at.d.a(appContext, "deviceinfo", null);
            case 69:
                if (objArr != null && objArr.length == 1 && (objArr[0] instanceof Integer)) {
                    cn.jiguang.dy.b.a();
                    cn.jiguang.dy.b.a(appContext, ((Integer) objArr[0]).intValue());
                    return null;
                }
                return null;
            case 70:
                cn.jiguang.b.a a2 = cn.jiguang.b.a.a();
                if (a2.f4037a) {
                    return null;
                }
                a2.f4037a = true;
                d.b("JPushCrashHandler", "init caughtException");
                cn.jiguang.g.b.a(JConstants.getAppContext(appContext), cn.jiguang.g.a.b().a((cn.jiguang.g.a<Boolean>) true));
                return null;
            case 71:
                cn.jiguang.b.a a3 = cn.jiguang.b.a.a();
                if (a3.f4037a) {
                    d.b("JPushCrashHandler", "stop caughtException");
                    a3.f4037a = false;
                    cn.jiguang.g.b.a(JConstants.getAppContext(appContext), cn.jiguang.g.a.b().a((cn.jiguang.g.a<Boolean>) false));
                    return null;
                }
                return null;
            case 72:
                if (objArr != null && objArr.length == 4 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer) && (objArr[2] instanceof Integer)) {
                    int intValue3 = ((Integer) objArr[1]).intValue();
                    int intValue4 = ((Integer) objArr[2]).intValue();
                    int intValue5 = ((Integer) objArr[3]).intValue();
                    Bundle bundle8 = new Bundle();
                    bundle8.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, (String) objArr[0]);
                    bundle8.putInt("custom", intValue3);
                    bundle8.putInt("dynamic", intValue4);
                    bundle8.putInt("sdk_v", intValue5);
                    cn.jiguang.at.d.a(appContext, "set_sdktype_info", bundle8);
                    return null;
                }
                return null;
        }
    }
}

package cn.jiguang.am;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.at.h;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f3748a;

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, String> f3749b = new HashMap();

    private e() {
    }

    private static Bundle a(String str, String str2, Bundle bundle, String str3) {
        String str4 = str + "." + str2;
        try {
            IDataShare dataShare = DataShare.getInstance(str3);
            if (dataShare == null) {
                cn.jiguang.an.d.b("JMessenger", str3 + "'s aidl not found, " + str4);
                return null;
            }
            cn.jiguang.an.d.b("JMessenger", "sendByAidl, " + str4);
            if ("INTERNAL_API".equals(str)) {
                return dataShare.execute(str, str2, bundle);
            }
            dataShare.onAction(str, str2, bundle);
            return new Bundle();
        } catch (Throwable th) {
            cn.jiguang.an.d.f("JMessenger", "sendByAidl, " + str4 + ", e=" + th);
            return null;
        }
    }

    public static e a() {
        if (f3748a == null) {
            synchronized (e.class) {
                if (f3748a == null) {
                    f3748a = new e();
                }
            }
        }
        return f3748a;
    }

    private static boolean a(Context context, Class cls, String str, Bundle bundle) {
        Intent intent;
        if (cls == null) {
            return false;
        }
        String str2 = cls.getName() + "." + str;
        try {
            intent = new Intent();
            intent.setClass(context, cls);
            intent.setAction(str);
            intent.setPackage(context.getPackageName());
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.f("JMessenger", "sendByComponent, " + str2 + " e=" + th);
        }
        if (BroadcastReceiver.class.isAssignableFrom(cls)) {
            context.sendBroadcast(intent);
            cn.jiguang.an.d.b("JMessenger", "sendByReceiver, " + str2);
            return true;
        }
        if (Service.class.isAssignableFrom(cls)) {
            if (context.startService(intent) != null) {
                cn.jiguang.an.d.b("JMessenger", "sendByService, " + str2);
                return true;
            }
            cn.jiguang.an.d.f("JMessenger", "startService, " + str2 + ", can't find component");
        }
        return false;
    }

    public static Bundle b(Context context, String str, String str2, Bundle bundle) {
        try {
            cn.jiguang.an.d.b("JMessenger", "directHandle, " + str + "." + str2);
            if ("INTERNAL_API".equals(str)) {
                if (str2.equals("isTcpLoggedIn")) {
                    boolean d2 = h.a().d();
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("state", d2);
                    return bundle2;
                }
                cn.jiguang.an.d.h("JMessenger", "directHandle, not support " + str + "." + str2);
                return null;
            }
            Class<?> cls = Class.forName(str);
            if (!BroadcastReceiver.class.isAssignableFrom(cls) && !Service.class.isAssignableFrom(cls)) {
                cn.jiguang.an.d.h("JMessenger", "directHandle, not support " + str + "." + str2);
                return null;
            } else if (JCommonService.class.isAssignableFrom(cls)) {
                cn.jiguang.an.d.b("JMessenger", "JCommonService handle succeed," + str + "." + str2);
                JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 2, true, str2, bundle, new Object[0]);
                return new Bundle();
            } else {
                Intent intent = new Intent(str2);
                intent.setClass(context, cls);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                intent.setPackage(context.getPackageName());
                intent.addCategory(context.getPackageName());
                if (PushReceiver.class.isAssignableFrom(cls)) {
                    cn.jiguang.an.d.b("JMessenger", "PushReceiver handle succeed," + str + "." + str2);
                    ActionManager.getInstance().handleMessage(context, bundle != null ? bundle.getString("sdktype") : null, intent);
                } else if (BroadcastReceiver.class.isAssignableFrom(cls)) {
                    cn.jiguang.an.d.b("JMessenger", "Receiver onReceive," + str + "." + str2);
                    ((BroadcastReceiver) cls.newInstance()).onReceive(context, intent);
                } else {
                    cn.jiguang.an.d.b("JMessenger", "Service onStartCommand," + str + "." + str2);
                    ((Service) cls.newInstance()).onStartCommand(intent, 0, 0);
                }
                return new Bundle();
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.h("JMessenger", "directHandle e:" + th);
            return null;
        }
    }

    private static Bundle b(Context context, String str, String str2, Bundle bundle, String str3) {
        Map<String, String> map;
        String str4 = str + "." + str2;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                String str5 = f3749b.get(str3);
                if (TextUtils.isEmpty(str5)) {
                    String str6 = context.getPackageName() + JConstants.DATA_PROVIDER_SUFFIX;
                    ProviderInfo a2 = cn.jiguang.f.a.a(context, context.getPackageName(), str6);
                    if (str3.equals(a2 != null ? a2.processName : null)) {
                        str5 = "content://" + str6 + "/";
                        map = f3749b;
                    } else {
                        String str7 = context.getPackageName() + ".DownloadProvider";
                        ProviderInfo a3 = cn.jiguang.f.a.a(context, context.getPackageName(), str7);
                        if (str3.equals(a3 != null ? a3.processName : null)) {
                            str5 = "content://" + str7 + "/";
                            map = f3749b;
                        } else {
                            str5 = "";
                        }
                    }
                    map.put(str3, str5);
                }
                if (!TextUtils.isEmpty(str5)) {
                    Uri parse = Uri.parse(str5);
                    cn.jiguang.an.d.b("JMessenger", "sendByProvider, uri=" + str5 + ", " + str4);
                    return context.getContentResolver().call(parse, str, str2, bundle);
                }
                cn.jiguang.an.d.b("JMessenger", "uri is null, check provider config");
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.f("JMessenger", "provider call:" + th);
        }
        return null;
    }

    public final Bundle a(Context context, String str, String str2, Bundle bundle, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String a2 = cn.jiguang.f.a.a(context);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        if (a2.equals(str3)) {
            return b(context, str, str2, bundle);
        }
        Bundle a3 = a(str, str2, bundle, str3);
        if (a3 != null) {
            return a3;
        }
        Bundle b2 = b(context, str, str2, bundle, str3);
        if (b2 != null) {
            return b2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[Catch: all -> 0x0067, TRY_LEAVE, TryCatch #0 {all -> 0x0067, blocks: (B:18:0x0058, B:21:0x0060), top: B:28:0x0058 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, String str, String str2, Bundle bundle) {
        Class<?> cls;
        String str3;
        String str4 = str + "." + str2;
        String str5 = null;
        try {
            cls = Class.forName(str);
        } catch (Throwable th) {
            th = th;
            cls = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            cn.jiguang.an.d.b("JMessenger", str4 + " meet e:" + th);
            str3 = str5;
            Class<?> cls2 = cls;
            try {
                if (a(context, str, str2, bundle, str3) != null) {
                }
            } catch (Throwable th3) {
                cn.jiguang.an.d.f("JMessenger", "send, " + str4 + " meet e:" + th3);
            }
        }
        if (Service.class.isAssignableFrom(cls)) {
            str3 = cn.jiguang.f.a.a(context, str);
            Class<?> cls22 = cls;
            if (a(context, str, str2, bundle, str3) != null) {
                return true;
            }
            if (a(context, cls22, str2, bundle)) {
                return true;
            }
            cn.jiguang.an.d.h("JMessenger", "send all failed, " + str4);
            return false;
        }
        if (BroadcastReceiver.class.isAssignableFrom(cls)) {
            str5 = cn.jiguang.f.a.b(context, str);
        }
        str3 = str5;
        Class<?> cls222 = cls;
        if (a(context, str, str2, bundle, str3) != null) {
        }
    }
}

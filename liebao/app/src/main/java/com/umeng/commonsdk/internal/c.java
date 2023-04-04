package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.SelfChecker;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.commonsdk.vchannel.Sender;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: UMInternalDataProtocol.java */
/* loaded from: classes2.dex */
public class c implements UMLogDataProtocol {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6755a = "um_policy_grant";

    /* renamed from: b  reason: collision with root package name */
    public static final String f6756b = "preInitInvokedFlag";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6757c = "policyGrantInvokedFlag";

    /* renamed from: d  reason: collision with root package name */
    public static final String f6758d = "policyGrantResult";
    private static int f = 1;
    private static final String g = "info";
    private static final String h = "stat";
    private static Class<?> i = null;
    private static Method j = null;
    private static Method k = null;
    private static Method l = null;
    private static boolean m = false;

    /* renamed from: e  reason: collision with root package name */
    private Context f6759e;

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    static {
        c();
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.ZIDManager");
            if (cls != null) {
                i = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    j = declaredMethod;
                }
                Method declaredMethod2 = i.getDeclaredMethod("getZID", Context.class);
                if (declaredMethod2 != null) {
                    k = declaredMethod2;
                }
                Method declaredMethod3 = i.getDeclaredMethod("getSDKVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    l = declaredMethod3;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String a() {
        Method method;
        Class<?> cls = i;
        if (cls == null || (method = j) == null || k == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            return invoke != null ? (String) k.invoke(invoke, this.f6759e) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b() {
        Method method;
        Class<?> cls = i;
        if (cls == null || (method = j) == null || l == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            return invoke != null ? (String) l.invoke(invoke, new Object[0]) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public c(Context context) {
        if (context != null) {
            this.f6759e = context.getApplicationContext();
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put("app_version", UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(ak.x, "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader != null && buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        am a2 = am.a(this.f6759e);
        an a3 = a2.a(ao.f6394c);
        if (a3 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a3.f6387a;
                String str2 = a3.f6388b;
                JSONObject a4 = new com.umeng.commonsdk.statistics.b().a(this.f6759e.getApplicationContext(), new JSONObject(a3.f6389c), new JSONObject(a3.f6390d), a3.f6391e, str2, a3.f);
                if (a4 != null && a4.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                }
                a2.a(ao.f6394c, str);
                a2.b();
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(final Context context) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.f6872a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = aa.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a2) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.f6874c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(h.f6873b, a2);
                        edit2.commit();
                    }
                    if (Build.VERSION.SDK_INT > 28) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String a2 = aa.a(applicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a2);
                }
            }
        }).start();
    }

    private static void c(final Context context) {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.G) || Build.VERSION.SDK_INT <= 28) {
            return;
        }
        a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
            @Override // com.umeng.commonsdk.listener.OnGetOaidListener
            public void onGetOaid(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.f6872a, 0);
                    if (sharedPreferences == null || sharedPreferences.getString(h.f6873b, "").equalsIgnoreCase(str)) {
                        return;
                    }
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(h.f6873b, str);
                    edit.commit();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void e() {
        if (!m) {
            if (!FieldManager.allow(com.umeng.commonsdk.utils.b.G) || Build.VERSION.SDK_INT <= 28) {
                return;
            }
            m = true;
            a(this.f6759e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            SharedPreferences sharedPreferences = c.this.f6759e.getSharedPreferences(h.f6872a, 0);
                            if (sharedPreferences != null) {
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString(h.f6873b, str);
                                edit.commit();
                            }
                        } catch (Throwable unused) {
                        }
                        UMWorkDispatch.sendEvent(c.this.f6759e, a.w, b.a(c.this.f6759e).a(), null);
                        return;
                    }
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                }
            });
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
        } else {
            m = false;
        }
    }

    private void f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.G) || Build.VERSION.SDK_INT <= 28) {
            return;
        }
        m = true;
        UMConfigureImpl.registerInterruptFlag();
        UMConfigureImpl.init(this.f6759e);
        f++;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
        UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
            @Override // com.umeng.commonsdk.utils.onMessageSendListener
            public void onMessageSend() {
                if (c.this.f6759e != null) {
                    UMWorkDispatch.sendEvent(c.this.f6759e, a.x, b.a(c.this.f6759e).a(), null);
                }
                UMConfigureImpl.removeMessageSendListener(this);
            }
        });
        b(this.f6759e);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x019a A[Catch: all -> 0x0333, TryCatch #0 {all -> 0x0333, blocks: (B:5:0x001d, B:9:0x004d, B:15:0x0065, B:17:0x007f, B:19:0x0085, B:20:0x0095, B:22:0x00be, B:25:0x00c8, B:27:0x00cc, B:29:0x00de, B:41:0x0156, B:43:0x016d, B:45:0x0178, B:48:0x017f, B:50:0x0185, B:52:0x0190, B:57:0x019a, B:59:0x01a0, B:60:0x01ac, B:61:0x01b3), top: B:99:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b3 A[Catch: all -> 0x0333, TRY_LEAVE, TryCatch #0 {all -> 0x0333, blocks: (B:5:0x001d, B:9:0x004d, B:15:0x0065, B:17:0x007f, B:19:0x0085, B:20:0x0095, B:22:0x00be, B:25:0x00c8, B:27:0x00cc, B:29:0x00de, B:41:0x0156, B:43:0x016d, B:45:0x0178, B:48:0x017f, B:50:0x0185, B:52:0x0190, B:57:0x019a, B:59:0x01a0, B:60:0x01ac, B:61:0x01b3), top: B:99:0x0018 }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void workEvent(Object obj, int i2) {
        SharedPreferences.Editor edit;
        boolean z = true;
        boolean z2 = false;
        ULog.i("walle", "[internal] workEvent");
        try {
            switch (i2) {
                case a.f /* 32769 */:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    Class<?> cls = Class.forName("com.umeng.commonsdk.internal.UMInternalManagerAgent");
                    if (cls != null) {
                        cls.getMethod("sendInternalEnvelopeByStateful2", Context.class).invoke(cls, this.f6759e);
                        return;
                    }
                    return;
                case a.g /* 32770 */:
                case a.i /* 32772 */:
                case a.j /* 32773 */:
                case 32778:
                case 32780:
                case a.f6751q /* 32782 */:
                case a.r /* 32783 */:
                case 32789:
                case 32794:
                case 32795:
                case 32796:
                case 32797:
                case 32798:
                case 32799:
                default:
                    return;
                case a.h /* 32771 */:
                    ULog.i("walle", "[internal] workEvent cache battery, event is " + obj.toString());
                    Class<?> cls2 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                    if (cls2 != null) {
                        cls2.getMethod("saveBattery", Context.class, String.class).invoke(cls2, this.f6759e, (String) obj);
                        return;
                    }
                    return;
                case a.k /* 32774 */:
                    Class<?> cls3 = Class.forName("com.umeng.commonsdk.internal.utils.ApplicationLayerUtilAgent");
                    if (cls3 != null) {
                        cls3.getMethod("wifiChange", Context.class).invoke(cls3, this.f6759e);
                        return;
                    }
                    return;
                case a.l /* 32775 */:
                    Class<?> cls4 = Class.forName("com.umeng.commonsdk.internal.utils.InfoPreferenceAgent");
                    if (cls4 != null) {
                        cls4.getMethod("saveUA", Context.class, String.class).invoke(cls4, this.f6759e, (String) obj);
                        return;
                    }
                    return;
                case a.m /* 32776 */:
                    SharedPreferences sharedPreferences = this.f6759e.getApplicationContext().getSharedPreferences(g, 0);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putString(h, (String) obj).commit();
                        return;
                    }
                    return;
                case a.n /* 32777 */:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ak.aM, a.f6750e);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ak.au, new JSONObject());
                    JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.f6759e, jSONObject, jSONObject2);
                    if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                        return;
                    }
                    ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                    return;
                case a.o /* 32779 */:
                    Sender.handleEvent(this.f6759e, (com.umeng.commonsdk.vchannel.b) obj);
                    return;
                case a.p /* 32781 */:
                    if (!UMFrUtils.hasEnvelopeFile(this.f6759e, UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文");
                        a(this.f6759e);
                        return;
                    }
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文信封文件已存在，尝试发送之!");
                    return;
                case a.s /* 32784 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文流程，接收到云控配置加载成功通知(成功收到零号报文应答)。");
                    f();
                    f--;
                    g();
                    return;
                case a.t /* 32785 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]接收到消费二级缓存数据通知.");
                    if (am.a(this.f6759e).c()) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]已消费完毕,二级缓存数据库为空.");
                        return;
                    }
                    d();
                    if (UMWorkDispatch.eventHasExist(a.t)) {
                        return;
                    }
                    Context context = this.f6759e;
                    UMWorkDispatch.sendEvent(context, a.t, b.a(context).a(), null);
                    return;
                case a.u /* 32786 */:
                    UMCrashManager.buildEnvelope(this.f6759e, obj);
                    return;
                case a.v /* 32787 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查动作。");
                    String a2 = com.umeng.commonsdk.stateless.d.a(this.f6759e, false);
                    String a3 = com.umeng.commonsdk.stateless.d.a(this.f6759e, true);
                    if (!TextUtils.isEmpty(a2)) {
                        File file = new File(a2);
                        if (file.exists() && file.isDirectory()) {
                            z2 = true;
                        }
                    }
                    if (!TextUtils.isEmpty(a3)) {
                        File file2 = new File(a3);
                        if (file2.exists() && file2.isDirectory()) {
                            if (!z) {
                                if (!com.umeng.commonsdk.stateless.b.a()) {
                                    new com.umeng.commonsdk.stateless.b(this.f6759e);
                                    com.umeng.commonsdk.stateless.b.b();
                                    return;
                                }
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，Sender已创建，不需要处理。");
                                return;
                            }
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。");
                            return;
                        }
                    }
                    z = z2;
                    if (!z) {
                    }
                    break;
                case a.w /* 32788 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新，触发 伪冷启动。");
                    com.umeng.commonsdk.statistics.b.a();
                    e();
                    if (FieldManager.allow(com.umeng.commonsdk.utils.b.E) && !UMWorkDispatch.eventHasExist()) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 前台计数器功能 打开，触发 5秒周期检查机制");
                        Context context2 = this.f6759e;
                        UMWorkDispatch.sendEventEx(context2, o.a.C, CoreProtocol.getInstance(context2), null, 5000L);
                    }
                    if (FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 FirstResume功能 打开，触发 trigger");
                        l.a(this.f6759e).b(this.f6759e);
                        return;
                    }
                    return;
                case a.x /* 32790 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 成功接收到(OAID)读取结束通知。");
                    f--;
                    g();
                    return;
                case a.y /* 32791 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 正常冷启动流程，接收到云控配置加载成功通知。");
                    c(this.f6759e);
                    com.umeng.commonsdk.a.a(this.f6759e);
                    d(this.f6759e);
                    return;
                case a.z /* 32792 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存隐私授权结果.");
                    if (obj instanceof Integer) {
                        int intValue = ((Integer) obj).intValue();
                        SharedPreferences sharedPreferences2 = this.f6759e.getApplicationContext().getSharedPreferences(f6755a, 0);
                        if (sharedPreferences2 != null) {
                            sharedPreferences2.edit().putInt("policyGrantResult", intValue).commit();
                            return;
                        }
                        return;
                    }
                    return;
                case a.A /* 32793 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存preInit执行结果及授权API是否调用结果.");
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject3 = (JSONObject) obj;
                        if (jSONObject3.has(a.G)) {
                            int i3 = jSONObject3.getInt(a.G);
                            int i4 = jSONObject3.getInt(a.H);
                            int i5 = jSONObject3.getInt("policyGrantResult");
                            SharedPreferences sharedPreferences3 = this.f6759e.getApplicationContext().getSharedPreferences(f6755a, 0);
                            if (sharedPreferences3 != null && (edit = sharedPreferences3.edit()) != null) {
                                edit.putInt(f6756b, i3);
                                edit.putInt(f6757c, i4);
                                edit.putInt("policyGrantResult", i5);
                                edit.commit();
                            }
                            File filesDir = this.f6759e.getFilesDir();
                            File file3 = new File(filesDir.getAbsolutePath() + File.separator + ao.m);
                            if (file3.exists()) {
                                return;
                            }
                            file3.createNewFile();
                            return;
                        }
                        return;
                    }
                    return;
                case a.B /* 32800 */:
                    File filesDir2 = this.f6759e.getFilesDir();
                    File file4 = new File(filesDir2.getAbsolutePath() + File.separator + ao.m);
                    if (file4.exists()) {
                        file4.delete();
                        return;
                    }
                    return;
                case a.C /* 32801 */:
                    SelfChecker.doCheck(this.f6759e);
                    return;
            }
        } catch (Throwable unused) {
        }
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private void d(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a2 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a2.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a2, new Object[0])) == null || (declaredMethod = a2.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private void g() {
        if (f <= 0) {
            h();
            d(this.f6759e);
        }
    }

    private static void e(Context context) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir.getAbsolutePath() + File.separator + ao.l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f6759e)) {
            e(this.f6759e);
            com.umeng.commonsdk.a.a(this.f6759e);
            Context context = this.f6759e;
            UMWorkDispatch.sendEvent(context, o.a.x, CoreProtocol.getInstance(context), null);
            Context context2 = this.f6759e;
            UMWorkDispatch.sendEvent(context2, a.t, b.a(context2).a(), null);
        }
    }
}

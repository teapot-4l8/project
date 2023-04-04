package cn.jpush.android.t;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.PushReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    private static c f4472e;

    /* renamed from: a  reason: collision with root package name */
    private List<JThirdPlatFormInterface> f4473a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f4474c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4475d;

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, Byte> f4471b = new HashMap();
    private static final Object f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        String f4482a;

        /* renamed from: b  reason: collision with root package name */
        int f4483b;

        /* renamed from: c  reason: collision with root package name */
        String f4484c;

        /* renamed from: d  reason: collision with root package name */
        byte f4485d;

        a() {
        }

        public String toString() {
            return "ThirdMessage{msgid='" + this.f4482a + "', notiId=" + this.f4483b + ", content='" + this.f4484c + "', platform=" + ((int) this.f4485d) + '}';
        }
    }

    static {
        f4471b.put("cn.jpush.android.thirdpush.meizu.MeizuPushManager", (byte) 3);
        f4471b.put("cn.jpush.android.thirdpush.xiaomi.XMPushManager", (byte) 1);
        f4471b.put("cn.jpush.android.thirdpush.huawei.HWPushManager", (byte) 2);
        f4471b.put("cn.jpush.android.thirdpush.fcm.FCMPushManager", (byte) 8);
        f4471b.put("cn.jpush.android.thridpush.oppo.OPushManager", (byte) 4);
        f4471b.put("cn.jpush.android.thirdpush.vivo.VivoPushManager", (byte) 5);
        f4471b.put(cn.jpush.android.asus.b.class.getName(), (byte) 6);
    }

    private c() {
        this.f4474c = null;
        this.f4474c = Executors.newSingleThreadExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a a(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            aVar = new a();
            aVar.f4484c = bundle.getString(JThirdPlatFormInterface.KEY_DATA);
            aVar.f4482a = bundle.getString(JThirdPlatFormInterface.KEY_MSG_ID);
            aVar.f4483b = bundle.getInt(JThirdPlatFormInterface.KEY_NOTI_ID, 0);
            aVar.f4485d = bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) -1).byteValue();
        } else {
            aVar = null;
        }
        Logger.d("ThirdPushManager", "parse third messgae:" + aVar);
        return aVar;
    }

    public static c a() {
        if (f4472e == null) {
            synchronized (f) {
                if (f4472e == null) {
                    f4472e = new c();
                }
            }
        }
        return f4472e;
    }

    private void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface) {
        if (jThirdPlatFormInterface == null || !jThirdPlatFormInterface.isNeedClearToken(context)) {
            return;
        }
        byte romType = jThirdPlatFormInterface.getRomType(context);
        Sp.set(context, Key.ThirdPush_RegUpload(romType).set(false));
        Sp.set(context, Key.ThirdPush_RegID(romType).set(null));
    }

    private void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface, String str) {
        Logger.d("ThirdPushManager", "sendBroadCastToUploadToken:" + str);
        String token = jThirdPlatFormInterface.getToken(context);
        if (!TextUtils.isEmpty(token)) {
            b(context, jThirdPlatFormInterface.getRomType(context), token);
            return;
        }
        try {
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction(str);
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", JPushConstants.SDK_TYPE);
            bundle.putByte(JThirdPlatFormInterface.KEY_PLATFORM, jThirdPlatFormInterface.getRomType(context));
            intent.putExtras(bundle);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "send " + str + " failed:" + th);
        }
    }

    private void b(Context context, byte b2, String str) {
        Logger.ii("ThirdPushManager", "[uploadInService] regid:" + str + ",romtype:" + ((int) b2));
        a(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
            if (jThirdPlatFormInterface.getRomType(context) == b2) {
                a(context, jThirdPlatFormInterface);
                if (b(context, (int) b2, str)) {
                    c(context, b2, str);
                }
            }
        }
    }

    private boolean b(Context context, int i, String str) {
        String str2;
        byte b2 = (byte) i;
        if (!((Boolean) Sp.get(context, Key.ThirdPush_RegUpload(b2))).booleanValue()) {
            str2 = "need upload -- last upload failed or never upload success";
        } else if (TextUtils.equals((String) Sp.get(context, Key.ThirdPush_RegID(b2)), str)) {
            Logger.ii("ThirdPushManager", "need not upload regId");
            return false;
        } else {
            str2 = "need upload -- regId changed";
        }
        Logger.ii("ThirdPushManager", str2);
        return true;
    }

    private void c(Context context, byte b2, String str) {
        Logger.d("ThirdPushManager", "sendUpdateRegIDRequest, WhichPlatform:" + ((int) b2) + ",regID:" + str);
        Sp.set(context, Key.ThirdPush_RegUpload(b2).set(false));
        Sp.set(context, Key.ThirdPush_RegID(b2).set(str));
        cn.jpush.android.t.a.a().a(context, b2, str);
    }

    private void j(Context context) {
        Object newInstance;
        Logger.d("ThirdPushManager", "[loadThirdPush]");
        for (Map.Entry<String, Byte> entry : f4471b.entrySet()) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass(entry.getKey());
                if (loadClass != null && (newInstance = loadClass.newInstance()) != null && (newInstance instanceof JThirdPlatFormInterface)) {
                    ((JThirdPlatFormInterface) newInstance).init(context);
                    if (((JThirdPlatFormInterface) newInstance).isSupport(context)) {
                        this.f4473a.add((JThirdPlatFormInterface) newInstance);
                    } else {
                        Byte value = entry.getValue();
                        Sp.set(context, Key.ThirdPush_RegID(value.byteValue()).set(null));
                        Sp.set(context, Key.ThirdPush_RegUpload(value.byteValue()).set(false));
                    }
                }
            } catch (Throwable th) {
                Byte value2 = entry.getValue();
                Sp.set(context, Key.ThirdPush_RegID(value2.byteValue()).set(null));
                Sp.set(context, Key.ThirdPush_RegUpload(value2.byteValue()).set(false));
                if ((th instanceof RuntimeException) && th.getMessage().contains("Please check") && JCoreManager.getDebugMode()) {
                    new Thread(new Runnable() { // from class: cn.jpush.android.t.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new RuntimeException(th);
                        }
                    }).start();
                }
                Logger.w("ThirdPushManager", "loadThirdPush error:" + th.getMessage());
            }
        }
        if (Build.VERSION.SDK_INT < 26 || this.f4473a.isEmpty()) {
            return;
        }
        cn.jpush.android.p.a.a(context);
    }

    public synchronized void a(Context context) {
        if (this.f4475d) {
            return;
        }
        if (context == null) {
            return;
        }
        try {
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("loadByJPush", Context.class).invoke(null, context);
        } catch (Throwable unused) {
        }
        j(context);
        this.f4475d = true;
    }

    public void a(Context context, byte b2, String str) {
        if (cn.jpush.android.l.a.a()) {
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            if (context == null) {
                Logger.e("ThirdPushManager", "context was null");
                return;
            }
            Logger.ii("ThirdPushManager", "uploadRegID regid:" + str);
            a(context);
            Bundle bundle = new Bundle();
            bundle.putString(JThirdPlatFormInterface.KEY_TOKEN, str);
            bundle.putByte(JThirdPlatFormInterface.KEY_PLATFORM, b2);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "third_push_upload_regid", bundle);
        }
    }

    public void a(Context context, int i, String str) {
        try {
            Logger.dd("ThirdPushManager", "[callBackTokenToUser] platform:" + i + ",token:" + str);
            Bundle bundle = new Bundle();
            bundle.putInt(JThirdPlatFormInterface.KEY_PLATFORM, i);
            bundle.putString(JThirdPlatFormInterface.KEY_TOKEN, str);
            cn.jpush.android.p.b.a(context, 10000, 0, "", bundle);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "callBackTokenToUser failed:" + th.getMessage());
        }
    }

    public void a(Context context, Bundle bundle) {
        if (context == null) {
            context = JPushConstants.mApplicationContext;
        }
        if (context == null) {
            Logger.e("ThirdPushManager", "context was null");
        } else if (bundle == null) {
            Logger.ww("ThirdPushManager", "bundle is null");
        } else {
            b(context, bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) 0).byteValue(), bundle.getString(JThirdPlatFormInterface.KEY_TOKEN));
        }
    }

    public void a(final Context context, final String str, final Bundle bundle) {
        try {
            Logger.dd("ThirdPushManager", "doAction,action:" + str + ",bundle:" + bundle + ",enable:" + cn.jpush.android.l.a.a());
            if (cn.jpush.android.l.a.a()) {
                this.f4474c.execute(new Runnable() { // from class: cn.jpush.android.t.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED)) {
                                    a a2 = c.this.a(bundle);
                                    if (a2 != null) {
                                        b.a(context, a2.f4484c, a2.f4482a, a2.f4483b, a2.f4485d, false);
                                    }
                                } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED)) {
                                    a a3 = c.this.a(bundle);
                                    if (a3 != null) {
                                        b.a(context, a3.f4484c, a3.f4482a, a3.f4483b, a3.f4485d, true);
                                    }
                                } else if (!str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW) && str.equals(JThirdPlatFormInterface.ACTION_REGISTER_TOKEN) && bundle != null) {
                                    String string = bundle.getString(JThirdPlatFormInterface.KEY_TOKEN);
                                    c.this.a(context, bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) -1).byteValue(), string);
                                }
                            }
                        } catch (Throwable th) {
                            Logger.ww("ThirdPushManager", "doAction failed internal:" + th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "doAction failed:" + th.getMessage());
        }
    }

    public void b(Context context) {
        if (cn.jpush.android.l.a.a()) {
            a(context);
            if (JPushInterface.isPushStopped(context.getApplicationContext())) {
                Logger.d("ThirdPushManager", "push has close");
                return;
            }
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
                try {
                    jThirdPlatFormInterface.register(context);
                } catch (Throwable th) {
                    Logger.ww("ThirdPushManager", "Third push register failed#", th);
                }
            }
        }
    }

    public void b(Context context, Bundle bundle) {
        if (!cn.jpush.android.l.a.a()) {
            Logger.dd("ThirdPushManager", "[refreshToken] third disabled");
            return;
        }
        a(context);
        byte byteValue = bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) -1).byteValue();
        if (byteValue <= 0) {
            Logger.w("ThirdPushManager", "refreshToken romtype is <= 0");
            return;
        }
        Logger.dd("ThirdPushManager", "[refreshToken] romType: " + ((int) byteValue));
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
            if (jThirdPlatFormInterface.getRomType(context) == byteValue) {
                String token = jThirdPlatFormInterface.getToken(context);
                if (TextUtils.isEmpty(token)) {
                    jThirdPlatFormInterface.register(context);
                } else {
                    a(context, byteValue, token);
                }
            }
        }
    }

    public void c(Context context) {
        if (cn.jpush.android.l.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
                jThirdPlatFormInterface.resumePush(context);
            }
        }
    }

    public void d(Context context) {
        if (cn.jpush.android.l.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
                jThirdPlatFormInterface.stopPush(context);
            }
        }
    }

    public byte e(Context context) {
        int i;
        byte b2 = 0;
        if (cn.jpush.android.l.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
                byte romType = jThirdPlatFormInterface.getRomType(context);
                b2 = (byte) (b2 | romType);
                byte b3 = romType;
                String str = (String) Sp.get(context, Key.ThirdPush_RegID(b3));
                boolean booleanValue = ((Boolean) Sp.get(context, Key.ThirdPush_RegUpload(b3))).booleanValue();
                if (jThirdPlatFormInterface.getRomType(context) == 8) {
                    b2 = (byte) (b2 | 8);
                    if (booleanValue && !TextUtils.isEmpty(str)) {
                        i = b2 | 32;
                        b2 = (byte) i;
                    }
                } else {
                    if (jThirdPlatFormInterface.getRomType(context) == 2) {
                        b2 = (byte) (b2 | 64);
                    }
                    if (!booleanValue || TextUtils.isEmpty(str)) {
                        i = b2 | 128;
                        b2 = (byte) i;
                    }
                }
            }
            Logger.d("ThirdPushManager", "getRomType,romType:" + ((int) b2));
            return b2;
        }
        return (byte) 0;
    }

    public String f(Context context) {
        if (cn.jpush.android.l.a.a()) {
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
                if (jThirdPlatFormInterface.getRomType(context) != 8) {
                    return (String) Sp.get(context, Key.ThirdPush_RegID(jThirdPlatFormInterface.getRomType(context)));
                }
            }
            return null;
        }
        return null;
    }

    public void g(Context context) {
        try {
            if (this.f4473a != null && !this.f4473a.isEmpty()) {
                for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
                    c(context, jThirdPlatFormInterface.getRomType(context), null);
                }
                return;
            }
            if (f4471b != null) {
                for (Byte b2 : f4471b.values()) {
                    Sp.set(context, Key.ThirdPush_RegUpload(b2.byteValue()).set(false));
                    Sp.set(context, Key.ThirdPush_RegID(b2.byteValue()).set(null));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void h(Context context) {
        if (cn.jpush.android.l.a.a()) {
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            if (context == null) {
                Logger.e("ThirdPushManager", "context was null");
                return;
            }
            a(context);
            Logger.ii("ThirdPushManager", "uploadRegIdAfterLogin");
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
                a(context, jThirdPlatFormInterface, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
            }
        }
    }

    public void i(Context context) {
        Logger.dd("ThirdPushManager", "reRegisterInPushReceiver");
        a(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f4473a) {
            a(context, jThirdPlatFormInterface, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
        }
    }
}

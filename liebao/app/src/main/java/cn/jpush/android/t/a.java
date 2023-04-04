package cn.jpush.android.t;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.g;
import cn.jpush.android.local.JPushConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f4464b;

    /* renamed from: a  reason: collision with root package name */
    private Map<Byte, C0081a> f4465a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.jpush.android.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0081a {

        /* renamed from: a  reason: collision with root package name */
        public byte f4466a;

        /* renamed from: b  reason: collision with root package name */
        public String f4467b;

        /* renamed from: c  reason: collision with root package name */
        public long f4468c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f4469d;

        /* renamed from: e  reason: collision with root package name */
        public int f4470e = 0;

        public C0081a(byte b2, String str, long j, byte[] bArr) {
            this.f4466a = b2;
            this.f4467b = str;
            this.f4468c = j;
            this.f4469d = bArr;
        }

        public String toString() {
            return "PluginPlatformRegIDBean{pluginPlatformType=" + ((int) this.f4466a) + ", regid='" + this.f4467b + "', rid=" + this.f4468c + ", retryCount=" + this.f4470e + '}';
        }
    }

    private a() {
    }

    private C0081a a(long j) {
        for (Map.Entry<Byte, C0081a> entry : this.f4465a.entrySet()) {
            if (entry.getValue().f4468c == j) {
                return entry.getValue();
            }
        }
        Logger.d("PluginPlatformRidUpdate", "can not find uploadBean by rid");
        return null;
    }

    public static a a() {
        if (f4464b == null) {
            synchronized (a.class) {
                if (f4464b == null) {
                    f4464b = new a();
                }
            }
        }
        return f4464b;
    }

    private synchronized void a(Context context, C0081a c0081a) {
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 27, 1, c0081a.f4468c, 10000L, c0081a.f4469d);
    }

    private void b(Context context, byte b2, String str) {
        long a2 = g.a();
        Logger.v("PluginPlatformRidUpdate", "sendUpdateRidInfo regid:" + str + ",rid:" + a2 + ",whichPlatform:" + ((int) b2));
        C0081a c0081a = new C0081a(b2, str, a2, cn.jpush.android.r.b.a(str, b2));
        this.f4465a.put(Byte.valueOf(b2), c0081a);
        a(context, c0081a);
    }

    public synchronized void a(Context context, byte b2, String str) {
        if (b2 == 0) {
            Logger.w("PluginPlatformRidUpdate", "unknown plugin platform type");
        } else if (!JPushConstants.isTcpConnected()) {
            Logger.d("PluginPlatformRidUpdate", "tcp disconnected");
        } else if (this.f4465a.containsKey(Byte.valueOf(b2)) && TextUtils.equals(this.f4465a.get(Byte.valueOf(b2)).f4467b, str)) {
            Logger.d("PluginPlatformRidUpdate", "same regid request, drop it");
        } else {
            b(context, b2, str);
        }
    }

    public void a(Context context, long j) {
        C0081a a2 = a(j);
        Logger.ii("PluginPlatformRidUpdate", "onUpdateRidSuccess rid:" + j + " ,pluginPlatformRegIDBean:" + a2);
        if (a2 != null) {
            Sp.set(context, Key.ThirdPush_RegID(a2.f4466a).set(a2.f4467b));
            Sp.set(context, Key.ThirdPush_RegUpload(a2.f4466a).set(true));
            this.f4465a.remove(Byte.valueOf(a2.f4466a));
            c.a().a(context, (int) a2.f4466a, a2.f4467b);
        }
    }

    public void a(Context context, long j, int i) {
        C0081a a2 = a(j);
        Logger.ii("PluginPlatformRidUpdate", "onUpdateRidFailed rid:" + j + ",errorCode:" + i + " ,pluginPlatformRegIDBean:" + a2);
        if (a2 != null) {
            if (a2.f4470e < 3) {
                a2.f4470e++;
                a(context, a2);
                return;
            }
            Logger.d("PluginPlatformRidUpdate", "updateRegId failed");
            this.f4465a.remove(Byte.valueOf(a2.f4466a));
        }
    }

    public void b(Context context, long j) {
        C0081a a2 = a(j);
        Logger.ii("PluginPlatformRidUpdate", "onUpdateRidTimeout rid:" + j + " ,pluginPlatformRegIDBean:" + a2);
        if (a2 != null) {
            if (a2.f4470e < 3) {
                a2.f4470e++;
                a(context, a2);
                return;
            }
            Logger.d("PluginPlatformRidUpdate", "updateRegId failed by timeout");
            this.f4465a.remove(Byte.valueOf(a2.f4466a));
        }
    }
}

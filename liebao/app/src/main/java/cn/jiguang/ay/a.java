package cn.jiguang.ay;

import android.content.Context;
import android.os.Build;
import cn.jiguang.internal.JConstants;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a {
    private static volatile a s;
    private static final Object t = new Object();
    private static String u;

    /* renamed from: a  reason: collision with root package name */
    public String f4012a;

    /* renamed from: b  reason: collision with root package name */
    public String f4013b;

    /* renamed from: c  reason: collision with root package name */
    public String f4014c;

    /* renamed from: d  reason: collision with root package name */
    public String f4015d;

    /* renamed from: e  reason: collision with root package name */
    public String f4016e;
    public String f;
    public int g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    /* renamed from: q  reason: collision with root package name */
    public String f4017q;
    private transient AtomicBoolean r;

    private a(Context context) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.r = atomicBoolean;
        if (atomicBoolean.get() || context == null) {
            return;
        }
        this.f4013b = a(Build.VERSION.RELEASE) + "," + Build.VERSION.SDK_INT;
        this.f4014c = a(Build.MODEL);
        this.f4015d = cn.jiguang.f.a.b(context, "gsm.version.baseband", "baseband");
        this.f4016e = a(Build.DEVICE);
        this.k = a(Build.PRODUCT);
        this.l = a(Build.MANUFACTURER);
        this.m = a(Build.FINGERPRINT);
        this.n = a(Build.BRAND);
        this.f4012a = b(context);
        this.o = cn.jiguang.am.a.a(context);
        this.f = cn.jiguang.am.a.b(context);
        this.g = cn.jiguang.f.a.e(context) ? 1 : 0;
        this.h = cn.jiguang.f.a.f(context);
        this.i = cn.jiguang.f.a.g(context);
        this.j = JConstants.isAndroidQ(context, false, "won't get serial") ? " " : Build.SERIAL;
        this.p = cn.jiguang.f.a.e(context, "");
        Object a2 = cn.jiguang.at.d.a(context, "get_imei", null);
        if (a2 instanceof String) {
            this.f4017q = (String) a2;
        }
        this.r.set(true);
    }

    public static a a(Context context) {
        if (s == null) {
            synchronized (t) {
                if (s == null) {
                    s = new a(context);
                }
            }
        }
        return s;
    }

    private static String a(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    private static String b(Context context) {
        if (u == null) {
            try {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                if (str.length() > 30) {
                    str = str.substring(0, 30);
                }
                u = str;
            } catch (Throwable unused) {
                cn.jiguang.an.d.c("DeviceInfo", "NO versionName defined in manifest.");
            }
        }
        String str2 = u;
        return str2 == null ? "" : str2;
    }
}

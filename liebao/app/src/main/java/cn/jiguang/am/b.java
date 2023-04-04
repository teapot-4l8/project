package cn.jiguang.am;

/* loaded from: classes.dex */
public final class b {
    private static volatile b i;
    private static final Object j = new Object();

    /* renamed from: a  reason: collision with root package name */
    private boolean f3735a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3736b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3737c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3738d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3739e;
    private boolean f;
    private boolean g;
    private boolean h;

    private b() {
        this.f3735a = false;
        this.f3736b = false;
        this.f3737c = false;
        this.f3738d = false;
        this.f3739e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.f3735a = e();
        this.f3736b = f();
        this.f3737c = g();
        this.f3738d = h();
        this.f3739e = i();
        this.f = k();
        this.g = j();
        this.h = l();
    }

    public static b a() {
        if (i == null) {
            synchronized (j) {
                if (i == null) {
                    i = new b();
                }
            }
        }
        return i;
    }

    private static boolean e() {
        boolean z;
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            z = true;
        } catch (ClassNotFoundException e2) {
            cn.jiguang.an.d.a("JClientsHelper", "isPluginJpushSDK:" + e2.getMessage());
            z = false;
        }
        cn.jiguang.an.d.a("JClientsHelper", "isPluginJpushSDK:" + z);
        return z;
    }

    private static boolean f() {
        boolean z;
        try {
            Class.forName("cn.jpush.im.android.api.JMessageClient");
            z = true;
        } catch (ClassNotFoundException e2) {
            cn.jiguang.an.d.a("JClientsHelper", "isPluginJMessageSDK:" + e2.getMessage());
            z = false;
        }
        cn.jiguang.an.d.a("JClientsHelper", "isPluginJMessageSDK:" + z);
        return z;
    }

    private static boolean g() {
        boolean z;
        try {
            Class.forName("cn.jiguang.analytics.android.api.JAnalyticsInterface");
            z = true;
        } catch (ClassNotFoundException e2) {
            cn.jiguang.an.d.a("JClientsHelper", "isPluginJanalyticsSDK:" + e2.getMessage());
            z = false;
        }
        cn.jiguang.an.d.a("JClientsHelper", "isPluginJanalyticsSDK:" + z);
        return z;
    }

    private static boolean h() {
        boolean z;
        try {
            Class.forName("cn.jiguang.share.android.api.JShareInterface");
            z = true;
        } catch (ClassNotFoundException e2) {
            cn.jiguang.an.d.a("JClientsHelper", "isPluginJshareSDK:" + e2.getMessage());
            z = false;
        }
        cn.jiguang.an.d.a("JClientsHelper", "isPluginJshareSDK:" + z);
        return z;
    }

    private static boolean i() {
        boolean z;
        try {
            Class.forName("cn.jiguang.adsdk.api.JSSPInterface");
            z = true;
        } catch (ClassNotFoundException e2) {
            cn.jiguang.an.d.a("JClientsHelper", "isPluginJSspSDK:" + e2.getMessage());
            z = false;
        }
        cn.jiguang.an.d.a("JClientsHelper", "isPluginJSspSDK:" + z);
        return z;
    }

    private static boolean j() {
        boolean z;
        try {
            Class.forName("cn.jiguang.h.a");
            z = true;
        } catch (ClassNotFoundException e2) {
            cn.jiguang.an.d.a("JClientsHelper", "isPluginJCommonSDK:" + e2.getMessage());
            z = false;
        }
        cn.jiguang.an.d.a("JClientsHelper", "isPluginJCommonSDK:" + z);
        return z;
    }

    private static boolean k() {
        boolean z;
        try {
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            z = true;
        } catch (ClassNotFoundException e2) {
            cn.jiguang.an.d.a("JClientsHelper", "isPluginJVerificationSDK:" + e2.getMessage());
            z = false;
        }
        cn.jiguang.an.d.a("JClientsHelper", "isPluginJVerificationSDK:" + z);
        return z;
    }

    private static boolean l() {
        boolean z;
        try {
            Class.forName("cn.jiguang.jmlinksdk.core.JMlinkInterfaceImpl");
            z = true;
        } catch (ClassNotFoundException e2) {
            cn.jiguang.an.d.a("JClientsHelper", "isPluginJMLinkSDK:" + e2.getMessage());
            z = false;
        }
        cn.jiguang.an.d.a("JClientsHelper", "isPluginJMLinkSDK:" + z);
        return z;
    }

    public final boolean b() {
        return this.f3736b;
    }

    public final boolean c() {
        return this.f3735a;
    }

    public final boolean d() {
        return this.f3736b || this.f3735a;
    }
}

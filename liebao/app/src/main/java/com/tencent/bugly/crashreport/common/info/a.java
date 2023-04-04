package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class a {
    private static a ah;
    public boolean B;
    public SharedPreferences G;
    private final Context H;
    private String I;
    private String J;
    private String K;
    private String aa;

    /* renamed from: c  reason: collision with root package name */
    public String f6007c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6008d;
    public final String g;
    public final String h;
    public final String i;
    public long j;
    public String k;
    public String l;
    public String m;
    public List<String> p;
    public boolean v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6009e = true;
    public String f = "3.1.9";
    private String L = "unknown";
    private String M = "unknown";
    private String N = "";
    private String O = null;
    private String P = null;
    private String Q = null;
    private String R = null;
    private long S = -1;
    private long T = -1;
    private long U = -1;
    private String V = null;
    private String W = null;
    private Map<String, PlugInBean> X = null;
    private boolean Y = true;
    private String Z = null;
    private Boolean ab = null;
    private String ac = null;
    private String ad = null;
    private String ae = null;
    public String n = null;
    public String o = null;
    private Map<String, PlugInBean> af = null;
    private Map<String, PlugInBean> ag = null;
    private int ai = -1;
    private int aj = -1;
    private Map<String, String> ak = new HashMap();
    private Map<String, String> al = new HashMap();
    private Map<String, String> am = new HashMap();
    private boolean an = true;

    /* renamed from: q  reason: collision with root package name */
    public String f6010q = "unknown";
    public long r = 0;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public boolean A = false;
    private Boolean ao = null;
    private Boolean ap = null;
    public HashMap<String, String> C = new HashMap<>();
    private String aq = null;
    private String ar = null;
    private String as = null;
    private String at = null;
    private String au = null;
    public boolean D = true;
    public List<String> E = new ArrayList();
    public com.tencent.bugly.crashreport.a F = null;
    private final Object av = new Object();
    private final Object aw = new Object();
    private final Object ax = new Object();
    private final Object ay = new Object();
    private final Object az = new Object();
    private final Object aA = new Object();
    private final Object aB = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final long f6005a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public final byte f6006b = 1;

    private a(Context context) {
        this.k = null;
        this.l = null;
        this.aa = null;
        this.m = null;
        this.p = null;
        this.v = false;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = "";
        this.B = false;
        this.H = z.a(context);
        PackageInfo b2 = AppInfo.b(context);
        if (b2 != null) {
            try {
                String str = b2.versionName;
                this.k = str;
                this.w = str;
                this.x = Integer.toString(b2.versionCode);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f6007c = AppInfo.a(context);
        this.f6008d = AppInfo.a(Process.myPid());
        this.g = b.o();
        this.h = b.a();
        this.l = AppInfo.c(context);
        this.i = "Android " + b.b() + ",level " + b.c();
        Map<String, String> d2 = AppInfo.d(context);
        if (d2 != null) {
            try {
                this.p = AppInfo.a(d2);
                String str2 = d2.get("BUGLY_APPID");
                if (str2 != null) {
                    this.aa = str2;
                    c("APP_ID", str2);
                }
                String str3 = d2.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.k = str3;
                }
                String str4 = d2.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.m = str4;
                }
                String str5 = d2.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.v = str5.equalsIgnoreCase("true");
                }
                String str6 = d2.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.y = str6;
                }
                String str7 = d2.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    Integer.parseInt(str7);
                }
                String str8 = d2.get("BUGLY_AREA");
                if (str8 != null) {
                    this.z = str8;
                }
            } catch (Throwable th2) {
                if (!x.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.B = true;
                x.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (com.tencent.bugly.b.f5969c) {
                th3.printStackTrace();
            }
        }
        this.G = z.a("BUGLY_COMMON_VALUES", context);
        x.c("com info create end", new Object[0]);
    }

    public final boolean a() {
        return this.an;
    }

    public final void a(boolean z) {
        this.an = z;
        com.tencent.bugly.crashreport.a aVar = this.F;
        if (aVar != null) {
            aVar.setNativeIsAppForeground(z);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (ah == null) {
                ah = new a(context);
            }
            aVar = ah;
        }
        return aVar;
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            aVar = ah;
        }
        return aVar;
    }

    public final String c() {
        return this.f;
    }

    public final void d() {
        synchronized (this.av) {
            this.I = UUID.randomUUID().toString();
        }
    }

    public final String e() {
        String str;
        synchronized (this.av) {
            if (this.I == null) {
                synchronized (this.av) {
                    this.I = UUID.randomUUID().toString();
                }
            }
            str = this.I;
        }
        return str;
    }

    public final String f() {
        if (z.a((String) null)) {
            return this.aa;
        }
        return null;
    }

    public final void a(String str) {
        this.aa = str;
        c("APP_ID", str);
    }

    public final String g() {
        String str;
        synchronized (this.aA) {
            str = this.L;
        }
        return str;
    }

    public final void b(String str) {
        synchronized (this.aA) {
            if (str == null) {
                str = "10000";
            }
            this.L = str;
        }
    }

    public final void b(boolean z) {
        this.Y = z;
    }

    public final String h() {
        String str = this.K;
        if (str != null) {
            return str;
        }
        String n = n();
        this.K = n;
        return n;
    }

    public final void c(String str) {
        this.K = str;
        synchronized (this.aB) {
            this.al.put("E8", str);
        }
    }

    public final synchronized String i() {
        return this.M;
    }

    public final synchronized void d(String str) {
        this.M = str;
    }

    public final synchronized String j() {
        return this.N;
    }

    public final synchronized void e(String str) {
        this.N = str;
    }

    public final String k() {
        if (this.Y) {
            if (this.O == null) {
                this.O = b.d();
            }
            return this.O;
        }
        return "";
    }

    public final String l() {
        if (this.Y) {
            String str = this.P;
            if (str == null || !str.contains(":")) {
                this.P = b.f();
            }
            return this.P;
        }
        return "";
    }

    public final String m() {
        if (this.Y) {
            if (this.Q == null) {
                this.Q = b.e();
            }
            return this.Q;
        }
        return "";
    }

    public final String n() {
        if (this.Y) {
            if (this.R == null) {
                this.R = b.a(this.H);
            }
            return this.R;
        }
        return "";
    }

    public final long o() {
        if (this.S <= 0) {
            this.S = b.h();
        }
        return this.S;
    }

    public final long p() {
        if (this.T <= 0) {
            this.T = b.j();
        }
        return this.T;
    }

    public final long q() {
        if (this.U <= 0) {
            this.U = b.l();
        }
        return this.U;
    }

    public final String r() {
        if (this.V == null) {
            this.V = b.a(this.H, true);
        }
        return this.V;
    }

    public final String s() {
        if (this.W == null) {
            this.W = b.e(this.H);
        }
        return this.W;
    }

    public final void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.aw) {
            this.C.put(str, str2);
        }
    }

    public final String t() {
        try {
            Map<String, ?> all = this.H.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.aw) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        this.C.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        } catch (Throwable th) {
            x.a(th);
        }
        if (this.C.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.C.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(",");
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        c("SDK_INFO", sb.toString());
        return sb.toString();
    }

    public final String u() {
        if (this.au == null) {
            this.au = AppInfo.e(this.H);
        }
        return this.au;
    }

    public final synchronized Map<String, PlugInBean> v() {
        return null;
    }

    public final String w() {
        if (this.Z == null) {
            this.Z = b.n();
        }
        return this.Z;
    }

    public final Boolean x() {
        if (this.ab == null) {
            this.ab = Boolean.valueOf(b.p());
        }
        return this.ab;
    }

    public final String y() {
        if (this.ac == null) {
            String str = b.d(this.H);
            this.ac = str;
            x.a("ROM ID: %s", str);
        }
        return this.ac;
    }

    public final String z() {
        if (this.ad == null) {
            String str = b.b(this.H);
            this.ad = str;
            x.a("SIM serial number: %s", str);
        }
        return this.ad;
    }

    public final String A() {
        if (this.ae == null) {
            String str = b.g();
            this.ae = str;
            x.a("Hardware serial number: %s", str);
        }
        return this.ae;
    }

    public final Map<String, String> B() {
        synchronized (this.ax) {
            if (this.ak.size() <= 0) {
                return null;
            }
            return new HashMap(this.ak);
        }
    }

    public final String f(String str) {
        String remove;
        if (z.a(str)) {
            x.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.ax) {
            remove = this.ak.remove(str);
        }
        return remove;
    }

    public final void C() {
        synchronized (this.ax) {
            this.ak.clear();
        }
    }

    public final String g(String str) {
        String str2;
        if (z.a(str)) {
            x.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.ax) {
            str2 = this.ak.get(str);
        }
        return str2;
    }

    public final void b(String str, String str2) {
        if (z.a(str) || z.a(str2)) {
            x.d("key&value should not be empty %s %s", str, str2);
            return;
        }
        synchronized (this.ax) {
            this.ak.put(str, str2);
        }
    }

    public final int D() {
        int size;
        synchronized (this.ax) {
            size = this.ak.size();
        }
        return size;
    }

    public final Set<String> E() {
        Set<String> keySet;
        synchronized (this.ax) {
            keySet = this.ak.keySet();
        }
        return keySet;
    }

    public final Map<String, String> F() {
        synchronized (this.aB) {
            if (this.al.size() <= 0) {
                return null;
            }
            return new HashMap(this.al);
        }
    }

    public final void c(String str, String str2) {
        if (z.a(str) || z.a(str2)) {
            x.d("server key&value should not be empty %s %s", str, str2);
            return;
        }
        synchronized (this.ay) {
            this.am.put(str, str2);
        }
    }

    public final Map<String, String> G() {
        synchronized (this.ay) {
            if (this.am.size() <= 0) {
                return null;
            }
            return new HashMap(this.am);
        }
    }

    public final void a(int i) {
        synchronized (this.az) {
            int i2 = this.ai;
            if (i2 != i) {
                this.ai = i;
                x.a("user scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.ai));
            }
        }
    }

    public final int H() {
        int i;
        synchronized (this.az) {
            i = this.ai;
        }
        return i;
    }

    public final void b(int i) {
        int i2 = this.aj;
        if (i2 != 24096) {
            this.aj = 24096;
            x.a("server scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.aj));
        }
    }

    public final int I() {
        return this.aj;
    }

    public final synchronized Map<String, PlugInBean> J() {
        return null;
    }

    public static int K() {
        return b.c();
    }

    public final String L() {
        if (this.aq == null) {
            this.aq = b.q();
        }
        return this.aq;
    }

    public final String M() {
        if (this.ar == null) {
            this.ar = b.f(this.H);
        }
        return this.ar;
    }

    public final String N() {
        if (this.as == null) {
            this.as = b.g(this.H);
        }
        return this.as;
    }

    public final String O() {
        return b.r();
    }

    public final String P() {
        if (this.at == null) {
            this.at = b.h(this.H);
        }
        return this.at;
    }

    public final long Q() {
        return b.s();
    }

    public final boolean R() {
        if (this.ao == null) {
            this.ao = Boolean.valueOf(b.i(this.H));
            x.a("Is it a virtual machine? " + this.ao, new Object[0]);
        }
        return this.ao.booleanValue();
    }

    public final boolean S() {
        if (this.ap == null) {
            this.ap = Boolean.valueOf(b.j(this.H));
            x.a("Does it has hook frame? " + this.ap, new Object[0]);
        }
        return this.ap.booleanValue();
    }

    public final String T() {
        if (this.J == null) {
            this.J = AppInfo.g(this.H);
            x.a("Beacon channel " + this.J, new Object[0]);
        }
        return this.J;
    }
}

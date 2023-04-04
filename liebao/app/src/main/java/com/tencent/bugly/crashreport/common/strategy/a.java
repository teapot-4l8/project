package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f6022a = 1000;

    /* renamed from: b  reason: collision with root package name */
    private static a f6023b;
    private static String h;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.tencent.bugly.a> f6024c;
    private Context g;
    private StrategyBean f = null;

    /* renamed from: e  reason: collision with root package name */
    private final StrategyBean f6026e = new StrategyBean();

    /* renamed from: d  reason: collision with root package name */
    private final w f6025d = w.a();

    private a(Context context, List<com.tencent.bugly.a> list) {
        this.g = context;
        this.f6024c = list;
    }

    public static synchronized a a(Context context, List<com.tencent.bugly.a> list) {
        a aVar;
        synchronized (a.class) {
            if (f6023b == null) {
                f6023b = new a(context, list);
            }
            aVar = f6023b;
        }
        return aVar;
    }

    public final void a(long j) {
        this.f6025d.a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Map<String, byte[]> a2 = p.a().a(a.f6022a, (o) null, true);
                    if (a2 != null) {
                        byte[] bArr = a2.get("device");
                        byte[] bArr2 = a2.get("gateway");
                        if (bArr != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.g).e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.g).d(new String(bArr2));
                        }
                    }
                    a.this.f = a.d();
                    if (a.this.f != null) {
                        if (!z.a(a.h) && z.c(a.h)) {
                            a.this.f.r = a.h;
                            a.this.f.s = a.h;
                        } else if (com.tencent.bugly.crashreport.common.info.a.b() == null || !"oversea".equals(com.tencent.bugly.crashreport.common.info.a.b().z)) {
                            if (TextUtils.isEmpty(a.this.f.r)) {
                                a.this.f.r = StrategyBean.f6017b;
                            }
                            if (TextUtils.isEmpty(a.this.f.s)) {
                                a.this.f.s = StrategyBean.f6018c;
                            }
                        } else if ("http://android.bugly.qq.com/rqd/async".equals(a.this.f.s) || "http://aexception.bugly.qq.com:8012/rqd/async".equals(a.this.f.s) || TextUtils.isEmpty(a.this.f.s)) {
                            a.this.f.r = StrategyBean.f6017b;
                            a.this.f.s = StrategyBean.f6018c;
                        }
                    }
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
                a aVar = a.this;
                aVar.a(aVar.f, false);
            }
        }, j);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            aVar = f6023b;
        }
        return aVar;
    }

    public final synchronized boolean b() {
        return this.f != null;
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f;
        if (strategyBean != null) {
            if (!z.c(strategyBean.r)) {
                this.f.r = StrategyBean.f6017b;
            }
            if (!z.c(this.f.s)) {
                this.f.s = StrategyBean.f6018c;
            }
            return this.f;
        }
        if (!z.a(h) && z.c(h)) {
            this.f6026e.r = h;
            this.f6026e.s = h;
        }
        return this.f6026e;
    }

    protected final void a(StrategyBean strategyBean, boolean z) {
        x.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.f6024c) {
            try {
                x.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (z.a(str) || !z.c(str)) {
            x.d("URL user set is invalid.", new Object[0]);
        } else {
            h = str;
        }
    }

    public final void a(as asVar) {
        if (asVar == null) {
            return;
        }
        if (this.f == null || asVar.h != this.f.p) {
            StrategyBean strategyBean = new StrategyBean();
            strategyBean.g = asVar.f6174a;
            strategyBean.i = asVar.f6176c;
            strategyBean.h = asVar.f6175b;
            if (z.a(h) || !z.c(h)) {
                if (z.c(asVar.f6177d)) {
                    x.c("[Strategy] Upload url changes to %s", asVar.f6177d);
                    strategyBean.r = asVar.f6177d;
                }
                if (z.c(asVar.f6178e)) {
                    x.c("[Strategy] Exception upload url changes to %s", asVar.f6178e);
                    strategyBean.s = asVar.f6178e;
                }
            }
            if (asVar.f != null && !z.a(asVar.f.f6172a)) {
                strategyBean.u = asVar.f.f6172a;
            }
            if (asVar.h != 0) {
                strategyBean.p = asVar.h;
            }
            if (asVar.g != null && asVar.g.size() > 0) {
                strategyBean.v = asVar.g;
                String str = asVar.g.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean.j = true;
                } else {
                    strategyBean.j = false;
                }
                String str2 = asVar.g.get("B3");
                if (str2 != null) {
                    strategyBean.y = Long.valueOf(str2).longValue();
                }
                strategyBean.f6021q = asVar.i;
                strategyBean.x = asVar.i;
                String str3 = asVar.g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean.w = parseInt;
                        }
                    } catch (Exception e2) {
                        if (!x.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = asVar.g.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean.l = true;
                } else {
                    strategyBean.l = false;
                }
            }
            x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.g), Boolean.valueOf(strategyBean.i), Boolean.valueOf(strategyBean.h), Boolean.valueOf(strategyBean.j), Boolean.valueOf(strategyBean.k), Boolean.valueOf(strategyBean.n), Boolean.valueOf(strategyBean.o), Long.valueOf(strategyBean.f6021q), Boolean.valueOf(strategyBean.l), Long.valueOf(strategyBean.p));
            this.f = strategyBean;
            if (!z.c(asVar.f6177d)) {
                x.c("[Strategy] download url is null", new Object[0]);
                this.f.r = "";
            }
            if (!z.c(asVar.f6178e)) {
                x.c("[Strategy] download crashurl is null", new Object[0]);
                this.f.s = "";
            }
            p.a().b(2);
            r rVar = new r();
            rVar.f6235b = 2;
            rVar.f6234a = strategyBean.f6020e;
            rVar.f6238e = strategyBean.f;
            rVar.g = z.a(strategyBean);
            p.a().a(rVar);
            a(strategyBean, true);
        }
    }

    public static StrategyBean d() {
        List<r> a2 = p.a().a(2);
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        r rVar = a2.get(0);
        if (rVar.g != null) {
            return (StrategyBean) z.a(rVar.g, StrategyBean.CREATOR);
        }
        return null;
    }
}

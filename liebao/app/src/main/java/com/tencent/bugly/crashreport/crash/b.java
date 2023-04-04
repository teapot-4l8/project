package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f6067a;

    /* renamed from: b  reason: collision with root package name */
    private Context f6068b;

    /* renamed from: c  reason: collision with root package name */
    private u f6069c;

    /* renamed from: d  reason: collision with root package name */
    private p f6070d;

    /* renamed from: e  reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.strategy.a f6071e;
    private o f;
    private BuglyStrategy.a g;

    public b(int i, Context context, u uVar, p pVar, com.tencent.bugly.crashreport.common.strategy.a aVar, BuglyStrategy.a aVar2, o oVar) {
        f6067a = i;
        this.f6068b = context;
        this.f6069c = uVar;
        this.f6070d = pVar;
        this.f6071e = aVar;
        this.g = aVar2;
        this.f = oVar;
    }

    private static List<a> a(List<a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            if (aVar.f6044d && aVar.f6042b <= currentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private CrashDetailBean a(List<a> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> b2;
        String[] split;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (a aVar : list) {
            if (aVar.f6045e) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0 && (b2 = b(arrayList)) != null && b2.size() > 0) {
            Collections.sort(b2);
            for (int i = 0; i < b2.size(); i++) {
                CrashDetailBean crashDetailBean3 = b2.get(i);
                if (i == 0) {
                    crashDetailBean2 = crashDetailBean3;
                } else if (crashDetailBean3.s != null && (split = crashDetailBean3.s.split("\n")) != null) {
                    for (String str : split) {
                        if (!crashDetailBean2.s.contains(str)) {
                            crashDetailBean2.t++;
                            crashDetailBean2.s += str + "\n";
                        }
                    }
                }
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (a aVar2 : list) {
            if (!aVar2.f6045e && !aVar2.f6044d) {
                String str2 = crashDetailBean2.s;
                StringBuilder sb = new StringBuilder();
                sb.append(aVar2.f6042b);
                if (!str2.contains(sb.toString())) {
                    crashDetailBean2.t++;
                    crashDetailBean2.s += aVar2.f6042b + "\n";
                }
            }
        }
        if (crashDetailBean2.r != crashDetailBean.r) {
            String str3 = crashDetailBean2.s;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.r);
            if (!str3.contains(sb2.toString())) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean2;
    }

    public final boolean a(CrashDetailBean crashDetailBean) {
        return b(crashDetailBean);
    }

    public final boolean b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return true;
        }
        if (c.n != null && !c.n.isEmpty()) {
            x.c("Crash filter for crash stack is: %s", c.n);
            if (crashDetailBean.f6040q.contains(c.n)) {
                x.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (c.o != null && !c.o.isEmpty()) {
            x.c("Crash regular filter for crash stack is: %s", c.o);
            if (Pattern.compile(c.o).matcher(crashDetailBean.f6040q).find()) {
                x.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f6036b != 2) {
            r rVar = new r();
            rVar.f6235b = 1;
            rVar.f6236c = crashDetailBean.A;
            rVar.f6237d = crashDetailBean.B;
            rVar.f6238e = crashDetailBean.r;
            this.f6070d.b(1);
            this.f6070d.a(rVar);
            x.b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            x.b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<a> b2 = b();
        ArrayList arrayList = null;
        if (b2 != null && b2.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(a(b2));
            b2.removeAll(arrayList);
            if (b2.size() > 20) {
                StringBuilder sb = new StringBuilder();
                sb.append("_id in ");
                sb.append("(");
                sb.append("SELECT _id");
                sb.append(" FROM t_cr");
                sb.append(" order by _id");
                sb.append(" limit 5");
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                try {
                    x.c("deleted first record %s data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb2, (String[]) null, (o) null, true)));
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            if (!com.tencent.bugly.b.f5969c && c.f6077d) {
                boolean z = false;
                for (a aVar : b2) {
                    if (crashDetailBean.u.equals(aVar.f6043c)) {
                        if (aVar.f6045e) {
                            z = true;
                        }
                        arrayList2.add(aVar);
                    }
                }
                if (z || arrayList2.size() >= c.f6076c) {
                    x.a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean a2 = a(arrayList2, crashDetailBean);
                    for (a aVar2 : arrayList2) {
                        if (aVar2.f6041a != a2.f6035a) {
                            arrayList.add(aVar2);
                        }
                    }
                    e(a2);
                    c(arrayList);
                    x.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        e(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        x.b("[crash] save crash success", new Object[0]);
        return false;
    }

    public final List<CrashDetailBean> a() {
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (c2 == null) {
            x.d("have not synced remote!", new Object[0]);
            return null;
        } else if (!c2.g) {
            x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b2 = z.b();
            List<a> b3 = b();
            x.c("Size of crash list loaded from DB: %s", Integer.valueOf(b3.size()));
            if (b3 == null || b3.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a(b3));
            b3.removeAll(arrayList);
            Iterator<a> it = b3.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f6042b < b2 - c.g) {
                    it.remove();
                    arrayList.add(next);
                } else if (next.f6044d) {
                    if (next.f6042b >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!next.f6045e) {
                        it.remove();
                        arrayList.add(next);
                    }
                } else if (next.f >= 3 && next.f6042b < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                c(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            List<CrashDetailBean> b4 = b(b3);
            if (b4 != null && b4.size() > 0) {
                String str = com.tencent.bugly.crashreport.common.info.a.b().k;
                Iterator<CrashDetailBean> it2 = b4.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f)) {
                        it2.remove();
                        arrayList2.add(next2);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                d(arrayList2);
            }
            return b4;
        }
    }

    public final void c(CrashDetailBean crashDetailBean) {
        int i = crashDetailBean.f6036b;
        if (i != 0) {
            if (i != 1) {
                if (i == 3 && !c.a().p()) {
                    return;
                }
            } else if (!c.a().o()) {
                return;
            }
        } else if (!c.a().o()) {
            return;
        }
        if (this.f != null) {
            x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            int i2 = crashDetailBean.f6036b;
        }
    }

    public final void a(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (c.l) {
            x.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z, crashDetailBean.f6036b == 7, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7 A[Catch: all -> 0x00e9, TryCatch #0 {all -> 0x00e9, blocks: (B:20:0x0041, B:22:0x0047, B:24:0x004c, B:26:0x0053, B:28:0x0058, B:32:0x0064, B:35:0x006e, B:39:0x0077, B:40:0x0087, B:42:0x008d, B:45:0x00a7, B:47:0x00af, B:49:0x00b5, B:51:0x00bd, B:53:0x00c5, B:55:0x00cd, B:57:0x00d4, B:58:0x00e0, B:43:0x009d, B:27:0x0056, B:23:0x004a), top: B:65:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af A[Catch: all -> 0x00e9, TryCatch #0 {all -> 0x00e9, blocks: (B:20:0x0041, B:22:0x0047, B:24:0x004c, B:26:0x0053, B:28:0x0058, B:32:0x0064, B:35:0x006e, B:39:0x0077, B:40:0x0087, B:42:0x008d, B:45:0x00a7, B:47:0x00af, B:49:0x00b5, B:51:0x00bd, B:53:0x00c5, B:55:0x00cd, B:57:0x00d4, B:58:0x00e0, B:43:0x009d, B:27:0x0056, B:23:0x004a), top: B:65:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(final List<CrashDetailBean> list, long j, boolean z, boolean z2, boolean z3) {
        u uVar;
        ao aoVar;
        if (!com.tencent.bugly.crashreport.common.info.a.a(this.f6068b).f6009e || (uVar = this.f6069c) == null) {
            return;
        }
        if (!z3 && !uVar.b(c.f6074a)) {
            return;
        }
        StrategyBean c2 = this.f6071e.c();
        if (!c2.g) {
            x.d("remote report is disable!", new Object[0]);
            x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
        } else if (list != null && list.size() != 0) {
            try {
                String str = this.f6069c.f6243a ? c2.s : c2.t;
                String str2 = this.f6069c.f6243a ? StrategyBean.f6018c : StrategyBean.f6016a;
                int i = this.f6069c.f6243a ? 830 : 630;
                Context context = this.f6068b;
                com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
                if (context != null && list != null && list.size() != 0 && b2 != null) {
                    aoVar = new ao();
                    aoVar.f6160a = new ArrayList<>();
                    for (CrashDetailBean crashDetailBean : list) {
                        aoVar.f6160a.add(a(context, crashDetailBean, b2));
                    }
                    if (aoVar != null) {
                        x.d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] a2 = com.tencent.bugly.proguard.a.a((k) aoVar);
                    if (a2 == null) {
                        x.d("send encode fail!", new Object[0]);
                        return;
                    }
                    ap a3 = com.tencent.bugly.proguard.a.a(this.f6068b, i, a2);
                    if (a3 == null) {
                        x.d("request package is null.", new Object[0]);
                        return;
                    }
                    t tVar = new t() { // from class: com.tencent.bugly.crashreport.crash.b.1
                        @Override // com.tencent.bugly.proguard.t
                        public final void a(boolean z4) {
                            b.a(z4, list);
                        }
                    };
                    if (z) {
                        this.f6069c.a(f6067a, a3, str, str2, tVar, j, z2);
                        return;
                    } else {
                        this.f6069c.a(f6067a, a3, str, str2, tVar, false);
                        return;
                    }
                }
                x.d("enEXPPkg args == null!", new Object[0]);
                aoVar = null;
                if (aoVar != null) {
                }
            } catch (Throwable th) {
                x.e("req cr error %s", th.toString());
                if (x.b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    public static void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            x.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                x.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f6037c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.f6038d), Boolean.valueOf(crashDetailBean.j));
                crashDetailBean.l++;
                crashDetailBean.f6038d = z;
                x.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f6037c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.f6038d), Boolean.valueOf(crashDetailBean.j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                c.a().a(crashDetailBean2);
            }
            x.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        x.b("[crash] upload fail.", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00af A[Catch: all -> 0x01f0, TryCatch #0 {all -> 0x01f0, blocks: (B:10:0x000e, B:11:0x0011, B:35:0x0062, B:37:0x0071, B:39:0x0087, B:46:0x00af, B:48:0x00b5, B:49:0x00c8, B:51:0x00ce, B:53:0x00e0, B:55:0x00ee, B:56:0x0101, B:58:0x010d, B:60:0x0119, B:62:0x0150, B:61:0x013e, B:63:0x016a, B:65:0x0175, B:69:0x019a, B:71:0x019e, B:73:0x01a1, B:74:0x01bb, B:75:0x01c9, B:77:0x01cd, B:79:0x01e8, B:66:0x0183, B:68:0x0187, B:40:0x0092, B:42:0x0096, B:14:0x0017, B:17:0x0023, B:20:0x002f, B:23:0x003b, B:27:0x0049, B:31:0x0056), top: B:86:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce A[Catch: all -> 0x01f0, TryCatch #0 {all -> 0x01f0, blocks: (B:10:0x000e, B:11:0x0011, B:35:0x0062, B:37:0x0071, B:39:0x0087, B:46:0x00af, B:48:0x00b5, B:49:0x00c8, B:51:0x00ce, B:53:0x00e0, B:55:0x00ee, B:56:0x0101, B:58:0x010d, B:60:0x0119, B:62:0x0150, B:61:0x013e, B:63:0x016a, B:65:0x0175, B:69:0x019a, B:71:0x019e, B:73:0x01a1, B:74:0x01bb, B:75:0x01c9, B:77:0x01cd, B:79:0x01e8, B:66:0x0183, B:68:0x0187, B:40:0x0092, B:42:0x0096, B:14:0x0017, B:17:0x0023, B:20:0x002f, B:23:0x003b, B:27:0x0049, B:31:0x0056), top: B:86:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0175 A[Catch: all -> 0x01f0, TryCatch #0 {all -> 0x01f0, blocks: (B:10:0x000e, B:11:0x0011, B:35:0x0062, B:37:0x0071, B:39:0x0087, B:46:0x00af, B:48:0x00b5, B:49:0x00c8, B:51:0x00ce, B:53:0x00e0, B:55:0x00ee, B:56:0x0101, B:58:0x010d, B:60:0x0119, B:62:0x0150, B:61:0x013e, B:63:0x016a, B:65:0x0175, B:69:0x019a, B:71:0x019e, B:73:0x01a1, B:74:0x01bb, B:75:0x01c9, B:77:0x01cd, B:79:0x01e8, B:66:0x0183, B:68:0x0187, B:40:0x0092, B:42:0x0096, B:14:0x0017, B:17:0x0023, B:20:0x002f, B:23:0x003b, B:27:0x0049, B:31:0x0056), top: B:86:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0183 A[Catch: all -> 0x01f0, TryCatch #0 {all -> 0x01f0, blocks: (B:10:0x000e, B:11:0x0011, B:35:0x0062, B:37:0x0071, B:39:0x0087, B:46:0x00af, B:48:0x00b5, B:49:0x00c8, B:51:0x00ce, B:53:0x00e0, B:55:0x00ee, B:56:0x0101, B:58:0x010d, B:60:0x0119, B:62:0x0150, B:61:0x013e, B:63:0x016a, B:65:0x0175, B:69:0x019a, B:71:0x019e, B:73:0x01a1, B:74:0x01bb, B:75:0x01c9, B:77:0x01cd, B:79:0x01e8, B:66:0x0183, B:68:0x0187, B:40:0x0092, B:42:0x0096, B:14:0x0017, B:17:0x0023, B:20:0x002f, B:23:0x003b, B:27:0x0049, B:31:0x0056), top: B:86:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019e A[Catch: all -> 0x01f0, TryCatch #0 {all -> 0x01f0, blocks: (B:10:0x000e, B:11:0x0011, B:35:0x0062, B:37:0x0071, B:39:0x0087, B:46:0x00af, B:48:0x00b5, B:49:0x00c8, B:51:0x00ce, B:53:0x00e0, B:55:0x00ee, B:56:0x0101, B:58:0x010d, B:60:0x0119, B:62:0x0150, B:61:0x013e, B:63:0x016a, B:65:0x0175, B:69:0x019a, B:71:0x019e, B:73:0x01a1, B:74:0x01bb, B:75:0x01c9, B:77:0x01cd, B:79:0x01e8, B:66:0x0183, B:68:0x0187, B:40:0x0092, B:42:0x0096, B:14:0x0017, B:17:0x0023, B:20:0x002f, B:23:0x003b, B:27:0x0049, B:31:0x0056), top: B:86:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cd A[Catch: all -> 0x01f0, TryCatch #0 {all -> 0x01f0, blocks: (B:10:0x000e, B:11:0x0011, B:35:0x0062, B:37:0x0071, B:39:0x0087, B:46:0x00af, B:48:0x00b5, B:49:0x00c8, B:51:0x00ce, B:53:0x00e0, B:55:0x00ee, B:56:0x0101, B:58:0x010d, B:60:0x0119, B:62:0x0150, B:61:0x013e, B:63:0x016a, B:65:0x0175, B:69:0x019a, B:71:0x019e, B:73:0x01a1, B:74:0x01bb, B:75:0x01c9, B:77:0x01cd, B:79:0x01e8, B:66:0x0183, B:68:0x0187, B:40:0x0092, B:42:0x0096, B:14:0x0017, B:17:0x0023, B:20:0x002f, B:23:0x003b, B:27:0x0049, B:31:0x0056), top: B:86:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(CrashDetailBean crashDetailBean) {
        int i;
        Map<String, String> onCrashHandleStart;
        String str;
        if (crashDetailBean == null) {
            return;
        }
        if (this.g == null && this.f == null) {
            return;
        }
        try {
            switch (crashDetailBean.f6036b) {
                case 0:
                    if (c.a().o()) {
                        i = 0;
                        break;
                    } else {
                        return;
                    }
                case 1:
                    if (c.a().o()) {
                        i = 2;
                        break;
                    } else {
                        return;
                    }
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 4;
                    if (!c.a().p()) {
                        return;
                    }
                    break;
                case 4:
                    i = 3;
                    if (!c.a().q()) {
                        return;
                    }
                    break;
                case 5:
                    i = 5;
                    if (!c.a().r()) {
                        return;
                    }
                    break;
                case 6:
                    i = 6;
                    if (!c.a().s()) {
                        return;
                    }
                    break;
                case 7:
                    i = 7;
                    break;
                default:
                    return;
            }
            int i2 = crashDetailBean.f6036b;
            String str2 = crashDetailBean.n;
            String str3 = crashDetailBean.p;
            String str4 = crashDetailBean.f6040q;
            long j = crashDetailBean.r;
            byte[] bArr = null;
            if (this.f != null) {
                x.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                x.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                String b2 = this.f.b();
                if (b2 != null) {
                    onCrashHandleStart = new HashMap<>(1);
                    onCrashHandleStart.put("userData", b2);
                    if (onCrashHandleStart != null && onCrashHandleStart.size() > 0) {
                        crashDetailBean.O = new LinkedHashMap(onCrashHandleStart.size());
                        for (Map.Entry<String, String> entry : onCrashHandleStart.entrySet()) {
                            if (!z.a(entry.getKey())) {
                                String key = entry.getKey();
                                if (key.length() > 100) {
                                    key = key.substring(0, 100);
                                    x.d("setted key length is over limit %d substring to %s", 100, key);
                                }
                                if (!z.a(entry.getValue()) && entry.getValue().length() > 30000) {
                                    str = entry.getValue().substring(entry.getValue().length() - BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                                    x.d("setted %s value length is over limit %d substring", key, Integer.valueOf((int) BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                                } else {
                                    str = entry.getValue();
                                }
                                crashDetailBean.O.put(key, str);
                                x.a("add setted key %s value size:%d", key, Integer.valueOf(str.length()));
                            }
                        }
                    }
                    x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                    if (this.f == null) {
                        x.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                        bArr = this.f.a();
                    } else if (this.g != null) {
                        x.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                        bArr = this.g.onCrashHandleStart2GetExtraDatas(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.f6040q);
                    }
                    crashDetailBean.T = bArr;
                    if (bArr != null) {
                        if (bArr.length > 30000) {
                            x.d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArr.length), Integer.valueOf((int) BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                            crashDetailBean.T = Arrays.copyOf(bArr, (int) BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        }
                        x.a("add extra bytes %d ", Integer.valueOf(bArr.length));
                    }
                    if (this.f == null) {
                        x.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                        o oVar = this.f;
                        String str5 = crashDetailBean.o;
                        String str6 = crashDetailBean.m;
                        String str7 = crashDetailBean.f6039e;
                        String str8 = crashDetailBean.f6037c;
                        String str9 = crashDetailBean.A;
                        String str10 = crashDetailBean.B;
                        if (oVar.c()) {
                            return;
                        }
                        x.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
                        return;
                    }
                    return;
                }
                onCrashHandleStart = null;
                if (onCrashHandleStart != null) {
                    crashDetailBean.O = new LinkedHashMap(onCrashHandleStart.size());
                    while (r6.hasNext()) {
                    }
                }
                x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                if (this.f == null) {
                }
                crashDetailBean.T = bArr;
                if (bArr != null) {
                }
                if (this.f == null) {
                }
            } else {
                if (this.g != null) {
                    x.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                    onCrashHandleStart = this.g.onCrashHandleStart(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.f6040q);
                    if (onCrashHandleStart != null) {
                    }
                    x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                    if (this.f == null) {
                    }
                    crashDetailBean.T = bArr;
                    if (bArr != null) {
                    }
                    if (this.f == null) {
                    }
                }
                onCrashHandleStart = null;
                if (onCrashHandleStart != null) {
                }
                x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                if (this.f == null) {
                }
                crashDetailBean.T = bArr;
                if (bArr != null) {
                }
                if (this.f == null) {
                }
            }
        } catch (Throwable th) {
            x.d("crash handle callback something wrong! %s", th.getClass().getName());
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f6035a > 0) {
                contentValues.put(com.umeng.analytics.pro.ao.f6395d, Long.valueOf(crashDetailBean.f6035a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            int i = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f6038d ? 1 : 0));
            if (!crashDetailBean.j) {
                i = 0;
            }
            contentValues.put("_me", Integer.valueOf(i));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", z.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.ao.f6395d));
            CrashDetailBean crashDetailBean = (CrashDetailBean) z.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f6035a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void e(CrashDetailBean crashDetailBean) {
        ContentValues f;
        if (crashDetailBean == null || (f = f(crashDetailBean)) == null) {
            return;
        }
        long a2 = p.a().a("t_cr", f, (o) null, true);
        if (a2 >= 0) {
            x.c("insert %s success!", "t_cr");
            crashDetailBean.f6035a = a2;
        }
    }

    private List<CrashDetailBean> b(List<a> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        for (a aVar : list) {
            sb.append(aVar.f6041a);
            sb.append(",");
        }
        if (sb.toString().contains(",")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        }
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            cursor = p.a().a("t_cr", null, sb2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append("_id in ");
                sb.append("(");
                int i = 0;
                while (cursor.moveToNext()) {
                    CrashDetailBean a2 = a(cursor);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        sb.append(cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.ao.f6395d)));
                        sb.append(",");
                        i++;
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb3 = sb.toString();
                if (i > 0) {
                    x.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb3, (String[]) null, (o) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static a b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.f6041a = cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.ao.f6395d));
            aVar.f6042b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.f6043c = cursor.getString(cursor.getColumnIndex("_s1"));
            aVar.f6044d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            aVar.f6045e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            aVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private List<a> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a2 = p.a().a("t_cr", new String[]{com.umeng.analytics.pro.ao.f6395d, "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("_id in ");
                sb.append("(");
                int i = 0;
                while (a2.moveToNext()) {
                    a b2 = b(a2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    } else {
                        sb.append(a2.getLong(a2.getColumnIndex(com.umeng.analytics.pro.ao.f6395d)));
                        sb.append(",");
                        i++;
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                if (i > 0) {
                    x.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb2, (String[]) null, (o) null, true)));
                }
                if (a2 != null) {
                    a2.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = a2;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void c(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        for (a aVar : list) {
            sb.append(aVar.f6041a);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            x.c("deleted %s data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb3, (String[]) null, (o) null, true)));
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or _id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.f6035a);
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    sb2 = sb2.substring(4);
                }
                sb.setLength(0);
                x.c("deleted %s data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb2, (String[]) null, (o) null, true)));
            } catch (Throwable th) {
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    private static an a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        am a2;
        am a3;
        am amVar;
        if (context == null || crashDetailBean == null || aVar == null) {
            x.d("enExp args == null", new Object[0]);
            return null;
        }
        an anVar = new an();
        switch (crashDetailBean.f6036b) {
            case 0:
                anVar.f6153a = crashDetailBean.j ? "200" : "100";
                break;
            case 1:
                anVar.f6153a = crashDetailBean.j ? "201" : "101";
                break;
            case 2:
                anVar.f6153a = crashDetailBean.j ? "202" : "102";
                break;
            case 3:
                anVar.f6153a = crashDetailBean.j ? "203" : "103";
                break;
            case 4:
                anVar.f6153a = crashDetailBean.j ? "204" : "104";
                break;
            case 5:
                anVar.f6153a = crashDetailBean.j ? "207" : "107";
                break;
            case 6:
                anVar.f6153a = crashDetailBean.j ? "206" : "106";
                break;
            case 7:
                anVar.f6153a = crashDetailBean.j ? "208" : "108";
                break;
            default:
                x.e("crash type error! %d", Integer.valueOf(crashDetailBean.f6036b));
                break;
        }
        anVar.f6154b = crashDetailBean.r;
        anVar.f6155c = crashDetailBean.n;
        anVar.f6156d = crashDetailBean.o;
        anVar.f6157e = crashDetailBean.p;
        anVar.g = crashDetailBean.f6040q;
        anVar.h = crashDetailBean.z;
        anVar.i = crashDetailBean.f6037c;
        anVar.j = null;
        anVar.l = crashDetailBean.m;
        anVar.m = crashDetailBean.f6039e;
        anVar.f = crashDetailBean.B;
        anVar.t = com.tencent.bugly.crashreport.common.info.a.b().i();
        anVar.n = null;
        if (crashDetailBean.i != null && crashDetailBean.i.size() > 0) {
            anVar.o = new ArrayList<>();
            for (Map.Entry<String, PlugInBean> entry : crashDetailBean.i.entrySet()) {
                ak akVar = new ak();
                akVar.f6141a = entry.getValue().f6002a;
                akVar.f6143c = entry.getValue().f6004c;
                akVar.f6144d = entry.getValue().f6003b;
                akVar.f6142b = aVar.r();
                anVar.o.add(akVar);
            }
        }
        if (crashDetailBean.h != null && crashDetailBean.h.size() > 0) {
            anVar.p = new ArrayList<>();
            for (Map.Entry<String, PlugInBean> entry2 : crashDetailBean.h.entrySet()) {
                ak akVar2 = new ak();
                akVar2.f6141a = entry2.getValue().f6002a;
                akVar2.f6143c = entry2.getValue().f6004c;
                akVar2.f6144d = entry2.getValue().f6003b;
                anVar.p.add(akVar2);
            }
        }
        if (crashDetailBean.j) {
            anVar.k = crashDetailBean.t;
            if (crashDetailBean.s != null && crashDetailBean.s.length() > 0) {
                if (anVar.f6158q == null) {
                    anVar.f6158q = new ArrayList<>();
                }
                try {
                    anVar.f6158q.add(new am((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    anVar.f6158q = null;
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(anVar.k);
            objArr[1] = Integer.valueOf(anVar.f6158q != null ? anVar.f6158q.size() : 0);
            x.c("crashcount:%d sz:%d", objArr);
        }
        if (crashDetailBean.w != null) {
            if (anVar.f6158q == null) {
                anVar.f6158q = new ArrayList<>();
            }
            try {
                anVar.f6158q.add(new am((byte) 1, "log.txt", crashDetailBean.w.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                anVar.f6158q = null;
            }
        }
        if (crashDetailBean.x != null) {
            if (anVar.f6158q == null) {
                anVar.f6158q = new ArrayList<>();
            }
            try {
                anVar.f6158q.add(new am((byte) 1, "jniLog.txt", crashDetailBean.x.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                anVar.f6158q = null;
            }
        }
        if (!z.a(crashDetailBean.U)) {
            if (anVar.f6158q == null) {
                anVar.f6158q = new ArrayList<>();
            }
            try {
                amVar = new am((byte) 1, "crashInfos.txt", crashDetailBean.U.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
                amVar = null;
            }
            if (amVar != null) {
                x.c("attach crash infos", new Object[0]);
                anVar.f6158q.add(amVar);
            }
        }
        if (crashDetailBean.V != null) {
            if (anVar.f6158q == null) {
                anVar.f6158q = new ArrayList<>();
            }
            am a4 = a("backupRecord.zip", context, crashDetailBean.V);
            if (a4 != null) {
                x.c("attach backup record", new Object[0]);
                anVar.f6158q.add(a4);
            }
        }
        if (crashDetailBean.y != null && crashDetailBean.y.length > 0) {
            am amVar2 = new am((byte) 2, "buglylog.zip", crashDetailBean.y);
            x.c("attach user log", new Object[0]);
            if (anVar.f6158q == null) {
                anVar.f6158q = new ArrayList<>();
            }
            anVar.f6158q.add(amVar2);
        }
        if (crashDetailBean.f6036b == 3) {
            if (anVar.f6158q == null) {
                anVar.f6158q = new ArrayList<>();
            }
            x.c("crashBean.userDatas:%s", crashDetailBean.O);
            if (crashDetailBean.O != null && crashDetailBean.O.containsKey("BUGLY_CR_01")) {
                try {
                    if (!TextUtils.isEmpty(crashDetailBean.O.get("BUGLY_CR_01"))) {
                        anVar.f6158q.add(new am((byte) 1, "anrMessage.txt", crashDetailBean.O.get("BUGLY_CR_01").getBytes("utf-8")));
                        x.c("attach anr message", new Object[0]);
                    }
                } catch (UnsupportedEncodingException e6) {
                    e6.printStackTrace();
                    anVar.f6158q = null;
                }
                crashDetailBean.O.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.v != null && (a3 = a("trace.zip", context, crashDetailBean.v)) != null) {
                x.c("attach traces", new Object[0]);
                anVar.f6158q.add(a3);
            }
        }
        if (crashDetailBean.f6036b == 1) {
            if (anVar.f6158q == null) {
                anVar.f6158q = new ArrayList<>();
            }
            if (crashDetailBean.v != null && (a2 = a("tomb.zip", context, crashDetailBean.v)) != null) {
                x.c("attach tombs", new Object[0]);
                anVar.f6158q.add(a2);
            }
        }
        if (aVar.E != null && !aVar.E.isEmpty()) {
            if (anVar.f6158q == null) {
                anVar.f6158q = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            for (String str : aVar.E) {
                sb.append(str);
            }
            try {
                anVar.f6158q.add(new am((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                x.c("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e7) {
                e7.printStackTrace();
            }
        }
        if (crashDetailBean.T != null && crashDetailBean.T.length > 0) {
            if (anVar.f6158q == null) {
                anVar.f6158q = new ArrayList<>();
            }
            anVar.f6158q.add(new am((byte) 1, "userExtraByteData", crashDetailBean.T));
            x.c("attach extraData", new Object[0]);
        }
        anVar.r = new HashMap();
        Map<String, String> map = anVar.r;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(crashDetailBean.C);
        map.put("A9", sb2.toString());
        Map<String, String> map2 = anVar.r;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(crashDetailBean.D);
        map2.put("A11", sb3.toString());
        Map<String, String> map3 = anVar.r;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(crashDetailBean.E);
        map3.put("A10", sb4.toString());
        anVar.r.put("A23", crashDetailBean.f);
        anVar.r.put("A7", aVar.g);
        anVar.r.put("A6", aVar.s());
        anVar.r.put("A5", aVar.r());
        anVar.r.put("A22", aVar.h());
        Map<String, String> map4 = anVar.r;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(crashDetailBean.G);
        map4.put("A2", sb5.toString());
        Map<String, String> map5 = anVar.r;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(crashDetailBean.F);
        map5.put("A1", sb6.toString());
        anVar.r.put("A24", aVar.i);
        Map<String, String> map6 = anVar.r;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(crashDetailBean.H);
        map6.put("A17", sb7.toString());
        anVar.r.put("A3", aVar.k());
        anVar.r.put("A16", aVar.m());
        anVar.r.put("A25", aVar.n());
        anVar.r.put("A14", aVar.l());
        anVar.r.put("A15", aVar.w());
        Map<String, String> map7 = anVar.r;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(aVar.x());
        map7.put("A13", sb8.toString());
        anVar.r.put("A34", crashDetailBean.A);
        if (aVar.y != null) {
            anVar.r.put("productIdentify", aVar.y);
        }
        try {
            anVar.r.put("A26", URLEncoder.encode(crashDetailBean.I, "utf-8"));
        } catch (UnsupportedEncodingException e8) {
            e8.printStackTrace();
        }
        if (crashDetailBean.f6036b == 1) {
            anVar.r.put("A27", crashDetailBean.K);
            anVar.r.put("A28", crashDetailBean.J);
            Map<String, String> map8 = anVar.r;
            StringBuilder sb9 = new StringBuilder();
            sb9.append(crashDetailBean.k);
            map8.put("A29", sb9.toString());
        }
        anVar.r.put("A30", crashDetailBean.L);
        Map<String, String> map9 = anVar.r;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(crashDetailBean.M);
        map9.put("A18", sb10.toString());
        Map<String, String> map10 = anVar.r;
        StringBuilder sb11 = new StringBuilder();
        sb11.append(!crashDetailBean.N);
        map10.put("A36", sb11.toString());
        Map<String, String> map11 = anVar.r;
        StringBuilder sb12 = new StringBuilder();
        sb12.append(aVar.r);
        map11.put("F02", sb12.toString());
        Map<String, String> map12 = anVar.r;
        StringBuilder sb13 = new StringBuilder();
        sb13.append(aVar.s);
        map12.put("F03", sb13.toString());
        anVar.r.put("F04", aVar.e());
        Map<String, String> map13 = anVar.r;
        StringBuilder sb14 = new StringBuilder();
        sb14.append(aVar.t);
        map13.put("F05", sb14.toString());
        anVar.r.put("F06", aVar.f6010q);
        anVar.r.put("F08", aVar.w);
        anVar.r.put("F09", aVar.x);
        Map<String, String> map14 = anVar.r;
        StringBuilder sb15 = new StringBuilder();
        sb15.append(aVar.u);
        map14.put("F10", sb15.toString());
        if (crashDetailBean.P >= 0) {
            Map<String, String> map15 = anVar.r;
            StringBuilder sb16 = new StringBuilder();
            sb16.append(crashDetailBean.P);
            map15.put("C01", sb16.toString());
        }
        if (crashDetailBean.Q >= 0) {
            Map<String, String> map16 = anVar.r;
            StringBuilder sb17 = new StringBuilder();
            sb17.append(crashDetailBean.Q);
            map16.put("C02", sb17.toString());
        }
        if (crashDetailBean.R != null && crashDetailBean.R.size() > 0) {
            for (Map.Entry<String, String> entry3 : crashDetailBean.R.entrySet()) {
                anVar.r.put("C03_" + entry3.getKey(), entry3.getValue());
            }
        }
        if (crashDetailBean.S != null && crashDetailBean.S.size() > 0) {
            for (Map.Entry<String, String> entry4 : crashDetailBean.S.entrySet()) {
                anVar.r.put("C04_" + entry4.getKey(), entry4.getValue());
            }
        }
        anVar.s = null;
        if (crashDetailBean.O != null && crashDetailBean.O.size() > 0) {
            anVar.s = crashDetailBean.O;
            x.a("setted message size %d", Integer.valueOf(anVar.s.size()));
        }
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.n;
        objArr2[1] = crashDetailBean.f6037c;
        objArr2[2] = aVar.e();
        objArr2[3] = Long.valueOf((crashDetailBean.r - crashDetailBean.M) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.k);
        objArr2[5] = Boolean.valueOf(crashDetailBean.N);
        objArr2[6] = Boolean.valueOf(crashDetailBean.j);
        objArr2[7] = Boolean.valueOf(crashDetailBean.f6036b == 1);
        objArr2[8] = Integer.valueOf(crashDetailBean.t);
        objArr2[9] = crashDetailBean.s;
        objArr2[10] = Boolean.valueOf(crashDetailBean.f6038d);
        objArr2[11] = Integer.valueOf(anVar.r.size());
        x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
        return anVar;
    }

    private static am a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            x.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        x.c("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!z.a(file, file2, 5000)) {
            x.d("zip fail!", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file2);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            x.c("read bytes :%d", Integer.valueOf(byteArray.length));
            am amVar = new am((byte) 2, file2.getName(), byteArray);
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                if (!x.a(e2)) {
                    e2.printStackTrace();
                }
            }
            if (file2.exists()) {
                x.c("del tmp", new Object[0]);
                file2.delete();
            }
            return amVar;
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        if (!x.a(e3)) {
                            e3.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    x.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return null;
            } catch (Throwable th3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        if (!x.a(e4)) {
                            e4.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    x.c("del tmp", new Object[0]);
                    file2.delete();
                }
                throw th3;
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
        if (b2 == null) {
            return;
        }
        x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        x.e("# PKG NAME: %s", b2.f6007c);
        x.e("# APP VER: %s", b2.k);
        x.e("# SDK VER: %s", b2.f);
        x.e("# LAUNCH TIME: %s", z.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().f6005a)));
        x.e("# CRASH TYPE: %s", str);
        x.e("# CRASH TIME: %s", str2);
        x.e("# CRASH PROCESS: %s", str3);
        x.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            x.e("# REPORT ID: %s", crashDetailBean.f6037c);
            Object[] objArr = new Object[2];
            objArr[0] = b2.h;
            objArr[1] = b2.x().booleanValue() ? "ROOTED" : "UNROOT";
            x.e("# CRASH DEVICE: %s %s", objArr);
            x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!z.a(crashDetailBean.K)) {
                x.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.K, crashDetailBean.J);
            } else if (crashDetailBean.f6036b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.O == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.O.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                x.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!z.a(str5)) {
            x.e("# CRASH STACK: ", new Object[0]);
            x.e(str5, new Object[0]);
        }
        x.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}

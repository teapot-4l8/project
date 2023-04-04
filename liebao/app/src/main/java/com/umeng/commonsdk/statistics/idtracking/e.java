package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: IdTracker.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final long f6861a = 86400000;

    /* renamed from: b  reason: collision with root package name */
    public static e f6862b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final String f6863c = "umeng_it.cache";
    private static Object j = new Object();

    /* renamed from: d  reason: collision with root package name */
    private File f6864d;
    private long f;
    private a i;

    /* renamed from: e  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f6865e = null;
    private Set<com.umeng.commonsdk.statistics.idtracking.a> h = new HashSet();
    private long g = 86400000;

    public String d() {
        return null;
    }

    public static synchronized void a() {
        synchronized (e.class) {
            if (f6862b != null) {
                f6862b.e();
                f6862b = null;
            }
        }
    }

    e(Context context) {
        this.i = null;
        this.f6864d = new File(context.getFilesDir(), f6863c);
        a aVar = new a(context);
        this.i = aVar;
        aVar.b();
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f6862b == null) {
                e eVar2 = new e(context);
                f6862b = eVar2;
                eVar2.a(new f(context));
                f6862b.a(new b(context));
                f6862b.a(new j(context));
                f6862b.a(new d(context));
                f6862b.a(new c(context));
                f6862b.a(new g(context));
                f6862b.a(new i());
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
                    f6862b.a(new h(context));
                }
                f6862b.f();
            }
            eVar = f6862b;
        }
        return eVar;
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.i.a(aVar.b())) {
            return this.h.add(aVar);
        }
        if (AnalyticsConstants.UM_DEBUG) {
            MLog.w("invalid domain: " + aVar.b());
            return false;
        }
        return false;
    }

    public void a(long j2) {
        this.g = j2;
    }

    public synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f >= this.g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                if (aVar.c() && aVar.a()) {
                    z = true;
                    if (!aVar.c()) {
                        this.i.b(aVar.b());
                    }
                }
            }
            if (z) {
                h();
                this.i.a();
                g();
            }
            this.f = currentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f6865e;
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    hashMap.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(hashMap);
        synchronized (this) {
            this.f6865e = cVar;
        }
    }

    public synchronized void e() {
        if (f6862b == null) {
            return;
        }
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.f6865e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i = i();
        if (i == null) {
            return;
        }
        a(i);
        ArrayList<com.umeng.commonsdk.statistics.idtracking.a> arrayList = new ArrayList(this.h.size());
        synchronized (this) {
            this.f6865e = i;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                aVar.a(this.f6865e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            for (com.umeng.commonsdk.statistics.idtracking.a aVar2 : arrayList) {
                this.h.remove(aVar2);
            }
            h();
        }
    }

    public synchronized void g() {
        if (this.f6865e != null) {
            b(this.f6865e);
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (j) {
            if (this.f6864d.exists()) {
                try {
                    fileInputStream = new FileInputStream(this.f6864d);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new aw().a(cVar, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Throwable th3) {
                        th = th3;
                        HelperUtils.safeClose(fileInputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    HelperUtils.safeClose(fileInputStream);
                    return null;
                }
            }
            return null;
        }
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        if (cVar == null || cVar.f6920a == null) {
            return;
        }
        if (cVar.f6920a.containsKey("mac") && !FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
            cVar.f6920a.remove("mac");
        }
        if (cVar.f6920a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.b.g)) {
            cVar.f6920a.remove("imei");
        }
        if (cVar.f6920a.containsKey("android_id") && !FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
            cVar.f6920a.remove("android_id");
        }
        if (cVar.f6920a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.b.j)) {
            cVar.f6920a.remove("serial");
        }
        if (cVar.f6920a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.b.w)) {
            cVar.f6920a.remove("idfa");
        }
        if (!cVar.f6920a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            return;
        }
        cVar.f6920a.remove("oaid");
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a2;
        synchronized (j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a2 = new bc().a(cVar);
                    }
                    if (a2 != null) {
                        HelperUtils.writeFile(this.f6864d, a2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* compiled from: IdTracker.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f6866a;

        /* renamed from: b  reason: collision with root package name */
        private Set<String> f6867b = new HashSet();

        public a(Context context) {
            this.f6866a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f6867b.contains(str);
        }

        public synchronized void b(String str) {
            this.f6867b.add(str);
        }

        public void c(String str) {
            this.f6867b.remove(str);
        }

        public synchronized void a() {
            if (!this.f6867b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.f6867b) {
                    sb.append(str);
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f6866a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f6866a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f6867b.add(str);
                    }
                }
            }
        }
    }
}

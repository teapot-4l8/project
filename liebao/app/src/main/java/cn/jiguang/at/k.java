package cn.jiguang.at;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.api.ReportCallBack;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    private static k f3949a;

    /* renamed from: e */
    private static int f3950e;

    /* renamed from: b */
    private final AtomicBoolean f3951b = new AtomicBoolean(false);

    /* renamed from: c */
    private final Map<cn.jiguang.ar.h, Pair<Integer, cn.jiguang.aw.a>> f3952c = new ConcurrentHashMap();

    /* renamed from: d */
    private final Map<cn.jiguang.ar.h, ConcurrentHashMap<Integer, m>> f3953d = new ConcurrentHashMap();
    private Map<String, Set<cn.jiguang.ar.h>> f = new HashMap();

    private k() {
    }

    private static synchronized int a(Context context) {
        int intValue;
        synchronized (k.class) {
            Integer num = (Integer) cn.jiguang.g.b.b(context, cn.jiguang.g.a.H());
            if (num == null) {
                num = Integer.valueOf(Math.abs(new SecureRandom().nextInt(10000)));
            }
            Integer valueOf = Integer.valueOf((num.intValue() + 1) % 10000);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.H().a((cn.jiguang.g.a<Integer>) valueOf));
            intValue = valueOf.intValue();
        }
        return intValue;
    }

    public static k a() {
        if (f3949a == null) {
            synchronized (k.class) {
                if (f3949a == null) {
                    f3949a = new k();
                }
            }
        }
        return f3949a;
    }

    public static m a(Context context, JSONObject jSONObject, byte[] bArr, int i, File file, Set<String> set, ReportCallBack reportCallBack) {
        m mVar = new m();
        mVar.f3958b = jSONObject;
        mVar.f3957a = i;
        mVar.f3959c = bArr;
        mVar.f3960d = file;
        mVar.f3961e = set;
        mVar.f = a(context);
        mVar.j = reportCallBack;
        return mVar;
    }

    public m a(cn.jiguang.ar.h hVar, int i) {
        ConcurrentHashMap<Integer, m> concurrentHashMap;
        if (hVar == null || (concurrentHashMap = this.f3953d.get(hVar)) == null) {
            return null;
        }
        m mVar = concurrentHashMap.get(Integer.valueOf(i));
        concurrentHashMap.remove(Integer.valueOf(i));
        return mVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x00d7, code lost:
        if (r7.f.containsKey(r1) == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00fe A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Set<cn.jiguang.ar.h> a(Context context, Set<String> set) {
        Set<cn.jiguang.ar.h> set2;
        Map<String, Set<cn.jiguang.ar.h>> map = this.f;
        if (map == null || map.isEmpty()) {
            String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.Q());
            if (!TextUtils.isEmpty(str)) {
                try {
                    a(new JSONObject(str));
                } catch (JSONException unused) {
                }
            }
        }
        if (set != null && !set.isEmpty()) {
            Set<cn.jiguang.ar.h> set3 = null;
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    char c2 = 65535;
                    switch (next.hashCode()) {
                        case -1245458676:
                            if (next.equals(PushSA.REPORT_ACTIVE_LAUNCH)) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case -1177318867:
                            if (next.equals("account")) {
                                c2 = '\n';
                                break;
                            }
                            break;
                        case -1091230153:
                            if (next.equals("android_awake_target2")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case -1051289244:
                            if (next.equals(com.umeng.analytics.pro.d.L)) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case -1039745817:
                            if (next.equals("normal")) {
                                c2 = 11;
                                break;
                            }
                            break;
                        case -820729752:
                            if (next.equals(PushSA.REPORT_ACTIVE_TERMINATE)) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case -693746763:
                            if (next.equals("android_awake")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -31313123:
                            if (next.equals("android_awake2")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 93223301:
                            if (next.equals("awake")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 907150721:
                            if (next.equals("detach_account")) {
                                c2 = '\t';
                                break;
                            }
                            break;
                        case 1350272347:
                            if (next.equals("android_awake_target")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 1973539834:
                            if (next.equals("identify_account")) {
                                c2 = '\b';
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            next = "awake";
                            break;
                        case 5:
                        case 6:
                        case 7:
                            next = com.umeng.analytics.pro.d.L;
                            break;
                        case '\b':
                        case '\t':
                        case '\n':
                            next = "account";
                            break;
                        case 11:
                            next = "normal";
                            break;
                    }
                    set2 = this.f.get(next);
                    if (set2 != null && !set2.isEmpty()) {
                        if (set3 != null) {
                            set3 = set2;
                        } else {
                            set3.retainAll(set2);
                        }
                        if (set3.isEmpty()) {
                        }
                    }
                }
                next = "normal";
                set2 = this.f.get(next);
                if (set2 != null) {
                    if (set3 != null) {
                    }
                    if (set3.isEmpty()) {
                    }
                }
            }
            return set3;
        }
        return this.f.get("normal");
    }

    private void a(Context context, int i, cn.jiguang.aw.a aVar, cn.jiguang.ar.h hVar, m mVar) {
        byte[] bArr;
        byte[] bArr2 = mVar.f3959c;
        int i2 = mVar.f3957a;
        int i3 = mVar.f;
        if (bArr2 == null || bArr2.length == 0 || bArr2.length > 30683) {
            bArr = null;
        } else {
            cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(bArr2.length + 37);
            bVar.b(0);
            bVar.a(1);
            b.a();
            bVar.a(b.b());
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
            bVar.b(longValue);
            String e2 = cn.jiguang.f.i.e((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.e()));
            String a2 = cn.jiguang.f.i.a(bArr2);
            byte[] c2 = cn.jiguang.f.i.c(longValue + e2 + a2);
            if (c2 == null) {
                c2 = new byte[16];
            } else if (c2.length != 16) {
                byte[] bArr3 = new byte[16];
                System.arraycopy(bArr2, 0, bArr3, 0, Math.min(c2.length, 16));
                c2 = bArr3;
            }
            bVar.a(c2);
            bVar.a(i2);
            bVar.b(i3);
            bVar.a(bArr2);
            bVar.b(bVar.a(), 0);
            bArr = bVar.b();
        }
        if (bArr == null || bArr.length == 0) {
            cn.jiguang.an.d.b("TcpReporter", "package data failed, give up, data=" + mVar);
            a(context, mVar, -1);
            return;
        }
        cn.jiguang.an.d.b("TcpReporter", "send tcp data, len=" + bArr.length + ", data=" + mVar);
        mVar.i = true;
        aVar.a(bArr);
        cn.jiguang.ax.b.a().b(60000 + i, 31000L, new l(context, hVar));
        cn.jiguang.ax.b.a().b(mVar.f + 50000, 15000L, new l(context, mVar));
    }

    public void a(Context context, cn.jiguang.ar.h hVar, int i) {
        int i2;
        StringBuilder sb;
        Pair<Integer, cn.jiguang.aw.a> remove = this.f3952c.remove(hVar);
        if (remove != null) {
            i2 = ((Integer) remove.first).intValue();
            cn.jiguang.f.k.a((Closeable) remove.second);
        } else {
            i2 = 0;
        }
        ConcurrentHashMap<Integer, m> remove2 = this.f3953d.remove(hVar);
        if (i == 0 && !cn.jiguang.f.a.d(context)) {
            i = -2;
        }
        if (remove2 == null || remove2.size() <= 0) {
            if (i2 > 0) {
                cn.jiguang.an.d.b("TcpReporter", "socket(" + i2 + ") at " + hVar + " is disconnected, no task left");
                return;
            }
            return;
        }
        if (i == 0) {
            sb = new StringBuilder("socket(");
            sb.append(i2);
            sb.append(") at ");
            sb.append(hVar);
            sb.append(" is disconnected, go on send waiting request");
        } else {
            sb = new StringBuilder("socket(");
            sb.append(i2);
            sb.append(") at ");
            sb.append(hVar);
            sb.append(" is disconnected, finish waiting request, code=");
            sb.append(i);
        }
        cn.jiguang.an.d.b("TcpReporter", sb.toString());
        for (m mVar : remove2.values()) {
            if (mVar != null) {
                cn.jiguang.ax.b.a().b(mVar.f + 50000);
                if (i == 0) {
                    a(context, mVar);
                } else {
                    l lVar = new l(context, 3, mVar);
                    lVar.f = i;
                    cn.jiguang.ap.b.a(lVar);
                }
            }
        }
    }

    private synchronized void a(Context context, cn.jiguang.ar.h hVar, m mVar) {
        Pair<Integer, cn.jiguang.aw.a> pair = this.f3952c.get(hVar);
        cn.jiguang.aw.a aVar = pair != null ? (cn.jiguang.aw.a) pair.second : null;
        if (aVar == null) {
            this.f3952c.put(hVar, new Pair<>(Integer.valueOf(b()), new cn.jiguang.aw.b(30720, 19)));
            cn.jiguang.ap.b.a("TCP_REPORT", new l(context, 1, hVar));
            return;
        }
        if (aVar.a()) {
            a(context, ((Integer) pair.first).intValue(), aVar, hVar, mVar);
        }
    }

    private void a(Context context, m mVar, int i) {
        ConcurrentHashMap<Integer, m> concurrentHashMap;
        if (mVar.g != null && (concurrentHashMap = this.f3953d.get(mVar.g)) != null) {
            concurrentHashMap.remove(Integer.valueOf(mVar.f));
        }
        cn.jiguang.ax.b.a().b(mVar.f + 50000);
        l lVar = new l(context, 3, mVar);
        lVar.f = i;
        cn.jiguang.ap.b.a(lVar);
    }

    public static /* synthetic */ void a(k kVar, Context context, cn.jiguang.ar.h hVar) {
        cn.jiguang.aw.a aVar;
        byte b2;
        if (hVar == null) {
            return;
        }
        try {
            Pair<Integer, cn.jiguang.aw.a> pair = kVar.f3952c.get(hVar);
            if (pair != null && (aVar = (cn.jiguang.aw.a) pair.second) != null && !aVar.a()) {
                cn.jiguang.an.d.b("TcpReporter", "start tcp socket(" + pair.first + "):" + hVar);
                if (aVar.a(hVar.f3820a, hVar.f3821b) != 0) {
                    kVar.a(context, hVar, 0);
                } else {
                    cn.jiguang.ap.b.a(new l(context, 2, hVar));
                    l lVar = new l(context, hVar);
                    while (!kVar.f3951b.get()) {
                        try {
                            ByteBuffer a2 = aVar.a(0);
                            try {
                                cn.jiguang.an.d.b("TcpReporter", "Received bytes - len:" + a2.array().length);
                                b2 = a2.get(2);
                            } catch (Throwable th) {
                                cn.jiguang.an.d.f("TcpReporter", "tcp reporter onReceive err:" + th);
                            }
                            if (b2 != 1 && b2 != 0) {
                                cn.jiguang.an.d.f("TcpReporter", "wrong version");
                                cn.jiguang.ax.b.a().b(((Integer) pair.first).intValue() + 60000, 31000L, lVar);
                            }
                            short s = a2.getShort(15);
                            short s2 = a2.getShort(17);
                            cn.jiguang.an.d.b("TcpReporter", "onResult seqId=" + ((int) s) + " code=" + ((int) s2));
                            cn.jiguang.ax.b.a().b(50000 + s);
                            m a3 = kVar.a(hVar, s);
                            if (a3 != null) {
                                if (s2 == 0) {
                                    l lVar2 = new l(context, 3, a3);
                                    lVar2.f = s2;
                                    cn.jiguang.ap.b.a(lVar2);
                                } else if (s2 == 401) {
                                    kVar.a(context, hVar, s2);
                                } else {
                                    kVar.a(context, a3);
                                }
                            }
                            cn.jiguang.ax.b.a().b(((Integer) pair.first).intValue() + 60000, 31000L, lVar);
                        } catch (e e2) {
                            if (e2.f3932a != -997) {
                                cn.jiguang.an.d.f("TcpReporter", "recv failed with error:" + e2);
                            }
                        }
                    }
                }
                kVar.a(context, hVar, 0);
                if (kVar.f3951b.get()) {
                    cn.jiguang.an.d.f("TcpReporter", "Break receiving by wantStop");
                } else {
                    cn.jiguang.an.d.f("TcpReporter", "disconnected");
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.an.d.a("TcpReporter", "socket exception", th2);
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject.length() == 0) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        cn.jiguang.ar.h a2 = cn.jiguang.ar.h.a(optJSONArray.getString(i));
                        if (a2 != null && a2.a()) {
                            linkedHashSet.add(a2);
                        }
                    }
                }
                hashMap.put(next, linkedHashSet);
            }
            if (hashMap.isEmpty()) {
                return;
            }
            this.f = hashMap;
        } catch (JSONException unused) {
        }
    }

    private static synchronized int b() {
        int i;
        synchronized (k.class) {
            i = (f3950e + 1) % 10000;
            f3950e = i;
        }
        return i;
    }

    public static /* synthetic */ void b(k kVar, Context context, cn.jiguang.ar.h hVar) {
        cn.jiguang.aw.a aVar;
        cn.jiguang.an.d.b("TcpReporter", "socket at " + hVar + " is connected, deal with waiting request");
        ConcurrentHashMap<Integer, m> concurrentHashMap = kVar.f3953d.get(hVar);
        Pair<Integer, cn.jiguang.aw.a> pair = kVar.f3952c.get(hVar);
        if (pair != null) {
            if (concurrentHashMap != null && (aVar = (cn.jiguang.aw.a) pair.second) != null && aVar.a()) {
                for (m mVar : concurrentHashMap.values()) {
                    if (mVar != null && !mVar.i) {
                        kVar.a(context, ((Integer) pair.first).intValue(), aVar, hVar, mVar);
                    }
                }
            }
            cn.jiguang.ax.b.a().b(((Integer) pair.first).intValue() + 60000, 31000L, new l(context, hVar));
        }
    }

    public final void a(Context context, m mVar) {
        try {
            boolean z = mVar.h == null;
            if (z) {
                cn.jiguang.ax.b.a().a(context);
                Set<String> set = mVar.f3961e;
                LinkedHashSet<cn.jiguang.ar.h> linkedHashSet = new LinkedHashSet<>();
                cn.jiguang.ar.h a2 = cn.jiguang.ar.h.a(cn.jiguang.aq.a.d());
                if (a2 == null || !a2.a()) {
                    Set<cn.jiguang.ar.h> a3 = a(context, set);
                    if (a3 != null) {
                        for (cn.jiguang.ar.h hVar : a3) {
                            if (hVar != null && hVar.a()) {
                                linkedHashSet.add(hVar);
                            }
                        }
                    }
                } else {
                    linkedHashSet.add(a2);
                }
                cn.jiguang.an.d.b("TcpReporter", "tcp report find urls=" + linkedHashSet);
                mVar.h = linkedHashSet;
                cn.jiguang.an.d.b("TcpReporter", "tcp report begin=" + mVar);
            }
            if (!cn.jiguang.f.a.d(context)) {
                a(context, mVar, -2);
                return;
            }
            if (mVar.h != null && !mVar.h.isEmpty()) {
                cn.jiguang.ar.h hVar2 = null;
                Iterator<cn.jiguang.ar.h> it = this.f3952c.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cn.jiguang.ar.h next = it.next();
                    if (mVar.h.contains(next)) {
                        cn.jiguang.an.d.b("TcpReporter", "use exist ipPort=" + next);
                        hVar2 = next;
                        break;
                    }
                }
                if (hVar2 == null) {
                    hVar2 = mVar.h.iterator().next();
                    cn.jiguang.an.d.b("TcpReporter", "use next ipPort=" + hVar2);
                }
                mVar.g = hVar2;
                mVar.h.remove(hVar2);
                if (z) {
                    cn.jiguang.ax.b.a().b(mVar.f + 50000, 15000L, new l(context, mVar));
                }
                ConcurrentHashMap<Integer, m> concurrentHashMap = this.f3953d.get(hVar2);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.f3953d.put(hVar2, concurrentHashMap);
                }
                mVar.i = false;
                concurrentHashMap.put(Integer.valueOf(mVar.f), mVar);
                a(context, hVar2, mVar);
                return;
            }
            a(context, mVar, -1);
        } catch (Throwable th) {
            cn.jiguang.an.d.f("TcpReporter", "tcp upload e:" + th);
        }
    }
}

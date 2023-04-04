package cn.jiguang.as;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static volatile m f3911a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3912b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private long f3913c = 86400000;

    /* renamed from: d  reason: collision with root package name */
    private long f3914d = 1800000;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Pair<LinkedHashSet<cn.jiguang.ar.h>, Long>> f3915e = new HashMap();

    private m() {
    }

    public static m a() {
        if (f3911a == null) {
            synchronized (f3912b) {
                if (f3911a == null) {
                    f3911a = new m();
                }
            }
        }
        return f3911a;
    }

    public static LinkedHashSet<cn.jiguang.ar.h> a(String str) {
        String[] a2;
        f fVar;
        j a3;
        i[] a4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] b2 = f.a(j.a(h.a(h.a(str), h.f3894a), 33, 1)).b(65535);
            cn.jiguang.an.d.b("SRVLoader", "srv host:" + str);
            LinkedHashSet<cn.jiguang.ar.h> linkedHashSet = new LinkedHashSet<>();
            try {
                a2 = l.b().a();
            } catch (Throwable th) {
                cn.jiguang.an.d.g("SRVLoader", "Get default ports error with Exception:" + th);
            }
            if (a2 != null && a2.length != 0) {
                LinkedHashSet<InetAddress> linkedHashSet2 = new LinkedHashSet();
                cn.jiguang.au.a a5 = cn.jiguang.au.a.a();
                int length = a2.length;
                int i = 0;
                while (i < length) {
                    int i2 = i;
                    InetAddress[] a6 = a5.a(null, a2[i], 3000L, false);
                    InetAddress inetAddress = (a6 == null || a6.length <= 0) ? null : a6[0];
                    if (inetAddress != null) {
                        linkedHashSet2.add(inetAddress);
                    }
                    i = i2 + 1;
                }
                for (InetAddress inetAddress2 : linkedHashSet2) {
                    try {
                        fVar = new f(q.a(null, new InetSocketAddress(inetAddress2, 53), b2, System.currentTimeMillis() + 1000));
                        a3 = fVar.a();
                    } catch (IOException e2) {
                        cn.jiguang.an.d.f("SRVLoader", "tcp send to " + inetAddress2.getHostAddress() + " err:" + e2);
                    }
                    if (a3 == null) {
                        break;
                    }
                    for (i iVar : fVar.a(1)) {
                        if (iVar.b().e() == a3.e() && iVar.b().d() == a3.c() && iVar.b().b().equals(a3.b())) {
                            Iterator a7 = iVar.a();
                            while (a7.hasNext()) {
                                o oVar = (o) a7.next();
                                if (oVar.h() > 0) {
                                    String hVar = oVar.i().toString();
                                    if (!TextUtils.isEmpty(hVar)) {
                                        if (hVar.endsWith(".")) {
                                            hVar = hVar.substring(0, hVar.length() - 1);
                                        }
                                        cn.jiguang.ar.h hVar2 = new cn.jiguang.ar.h(hVar, oVar.h());
                                        if (hVar2.a()) {
                                            linkedHashSet.add(hVar2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return linkedHashSet;
            }
            return linkedHashSet;
        } catch (IOException e3) {
            cn.jiguang.an.d.f("SRVLoader", "can't srv, create query:" + e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(m mVar, String str, Pair pair) {
        if (pair.first == null || ((LinkedHashSet) pair.first).size() <= 0 || pair.second == null) {
            return;
        }
        mVar.f3915e.put(str, pair);
        StringBuilder sb = new StringBuilder();
        Iterator it = ((LinkedHashSet) pair.first).iterator();
        while (it.hasNext()) {
            sb.append(((cn.jiguang.ar.h) it.next()).toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        cn.jiguang.g.b.a((Context) null, cn.jiguang.g.a.d(str).a((cn.jiguang.g.a<String>) sb.toString()), cn.jiguang.g.a.e(str).a((cn.jiguang.g.a<Long>) pair.second));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|(1:66)(1:11)|(1:13)(1:65)|14|(4:16|(2:18|(4:20|(3:22|(2:26|27)|28)|31|32))(1:63)|33|(8:35|(1:37)|38|(4:40|(1:61)(1:44)|45|(1:47))(1:62)|48|49|50|(2:56|57)(2:54|55)))|64|(0)(0)|48|49|50|(1:52)|56|57) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00eb, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ec, code lost:
        cn.jiguang.an.d.f("SRVLoader", "run futureTask e:" + r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LinkedHashSet<cn.jiguang.ar.h> a(String str, long j) {
        Pair pair;
        LinkedHashSet<cn.jiguang.ar.h> linkedHashSet;
        LinkedHashSet<cn.jiguang.ar.h> linkedHashSet2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long j2 = this.f3913c;
        long j3 = this.f3914d;
        Pair<LinkedHashSet<cn.jiguang.ar.h>, Long> pair2 = this.f3915e.get(str);
        boolean z = pair2 == null || pair2.first == null || ((LinkedHashSet) pair2.first).size() == 0;
        long longValue = ((Long) (z ? cn.jiguang.g.b.a((Context) null, cn.jiguang.g.a.e(str)) : pair2.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= j2 + longValue) {
            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
            if (z) {
                String str2 = (String) cn.jiguang.g.b.a((Context) null, cn.jiguang.g.a.d(str));
                if (!TextUtils.isEmpty(str2)) {
                    for (String str3 : str2.split(",")) {
                        cn.jiguang.ar.h a2 = cn.jiguang.ar.h.a(str3);
                        if (a2 != null && a2.a()) {
                            linkedHashSet3.add(a2);
                        }
                    }
                    this.f3915e.put(str, new Pair<>(linkedHashSet3, Long.valueOf(System.currentTimeMillis())));
                }
            } else {
                linkedHashSet3 = (LinkedHashSet) pair2.first;
            }
            if (!linkedHashSet3.isEmpty()) {
                pair = new Pair(linkedHashSet3, Boolean.valueOf(currentTimeMillis > longValue + j3));
                if (pair == null) {
                    linkedHashSet = (pair.first == null || ((LinkedHashSet) pair.first).size() <= 0) ? null : (LinkedHashSet) pair.first;
                    if (!((Boolean) pair.second).booleanValue()) {
                        return linkedHashSet;
                    }
                } else {
                    linkedHashSet = null;
                }
                FutureTask futureTask = new FutureTask(new n(str, this));
                cn.jiguang.ap.b.a(futureTask);
                linkedHashSet2 = (LinkedHashSet) futureTask.get(10000L, TimeUnit.MILLISECONDS);
                if (linkedHashSet2 != null || linkedHashSet2.size() <= 0) {
                    cn.jiguang.an.d.b("SRVLoader", "use cache=" + linkedHashSet);
                    return linkedHashSet;
                }
                cn.jiguang.an.d.b("SRVLoader", "use resolved result=" + linkedHashSet2);
                return linkedHashSet2;
            }
        }
        pair = null;
        if (pair == null) {
        }
        FutureTask futureTask2 = new FutureTask(new n(str, this));
        cn.jiguang.ap.b.a(futureTask2);
        linkedHashSet2 = (LinkedHashSet) futureTask2.get(10000L, TimeUnit.MILLISECONDS);
        if (linkedHashSet2 != null) {
        }
        cn.jiguang.an.d.b("SRVLoader", "use cache=" + linkedHashSet);
        return linkedHashSet;
    }
}

package cn.jiguang.au;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.an.d;
import cn.jiguang.f.i;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f3971a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3972b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private long f3973c = 36000000;

    /* renamed from: d  reason: collision with root package name */
    private long f3974d = 900000;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Pair<InetAddress[], Long>> f3975e = new HashMap();

    private a() {
    }

    public static a a() {
        if (f3971a == null) {
            synchronized (f3972b) {
                if (f3971a == null) {
                    f3971a = new a();
                }
            }
        }
        return f3971a;
    }

    private static InetAddress a(String str) {
        if (i.f(str) || i.g(str)) {
            try {
                return InetAddress.getByName(str);
            } catch (UnknownHostException e2) {
                d.f("DNSLoader", "dns resolve failed:" + e2);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InetAddress[] a(Context context, String str, long j, boolean z) {
        Pair pair;
        InetAddress[] inetAddressArr;
        InetAddress[] inetAddressArr2;
        StringBuilder sb;
        String arrays;
        InetAddress[] inetAddressArr3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        InetAddress a2 = a(str);
        if (a2 != null) {
            return new InetAddress[]{a2};
        }
        long j2 = this.f3973c;
        long j3 = this.f3974d;
        Pair<InetAddress[], Long> pair2 = this.f3975e.get(str);
        boolean z2 = pair2 == null || pair2.first == null;
        long longValue = ((Long) (z2 ? cn.jiguang.g.b.a(context, cn.jiguang.g.a.c(str)) : pair2.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= j2 + longValue) {
            if (z2) {
                String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.b(str));
                if (TextUtils.isEmpty(str2)) {
                    inetAddressArr3 = null;
                } else {
                    String[] split = str2.split(",");
                    LinkedList linkedList = new LinkedList();
                    for (String str3 : split) {
                        InetAddress a3 = a(str3);
                        if (a3 != null) {
                            linkedList.add(a3);
                        }
                    }
                    inetAddressArr3 = linkedList.isEmpty() ? null : (InetAddress[]) linkedList.toArray(new InetAddress[0]);
                }
                if (inetAddressArr3 != null) {
                    this.f3975e.put(str, new Pair<>(inetAddressArr3, Long.valueOf(longValue)));
                }
            } else {
                inetAddressArr3 = (InetAddress[]) pair2.first;
            }
            if (inetAddressArr3 != null) {
                pair = new Pair(inetAddressArr3, Boolean.valueOf(currentTimeMillis > longValue + j3));
                if (pair == null) {
                    inetAddressArr = pair.first != null ? (InetAddress[]) pair.first : null;
                    if (!((Boolean) pair.second).booleanValue()) {
                        if (z) {
                            cn.jiguang.ap.b.a(new FutureTask(new b(context, str, this)));
                        }
                        sb = new StringBuilder("use cache=");
                        arrays = Arrays.toString(inetAddressArr);
                        sb.append(arrays);
                        d.b("DNSLoader", sb.toString());
                        return inetAddressArr;
                    }
                } else {
                    inetAddressArr = null;
                }
                FutureTask futureTask = new FutureTask(new b(context, str, this));
                cn.jiguang.ap.b.a(futureTask);
                if (j != 0) {
                    sb = new StringBuilder("use cache=");
                } else {
                    try {
                        d.b("DNSLoader", "waiting dns for " + str);
                        inetAddressArr2 = (InetAddress[]) futureTask.get(j, TimeUnit.MILLISECONDS);
                    } catch (Throwable th) {
                        d.f("DNSLoader", "run futureTask e:" + th);
                        inetAddressArr2 = null;
                    }
                    if (inetAddressArr2 != null) {
                        d.b("DNSLoader", "use resolved result=" + Arrays.toString(inetAddressArr2));
                        return inetAddressArr2;
                    }
                    sb = new StringBuilder("use cache=");
                }
                arrays = Arrays.toString(inetAddressArr);
                sb.append(arrays);
                d.b("DNSLoader", sb.toString());
                return inetAddressArr;
            }
        }
        pair = null;
        if (pair == null) {
        }
        FutureTask futureTask2 = new FutureTask(new b(context, str, this));
        cn.jiguang.ap.b.a(futureTask2);
        if (j != 0) {
        }
        arrays = Arrays.toString(inetAddressArr);
        sb.append(arrays);
        d.b("DNSLoader", sb.toString());
        return inetAddressArr;
    }
}

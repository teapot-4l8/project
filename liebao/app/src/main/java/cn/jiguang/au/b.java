package cn.jiguang.au;

import android.content.Context;
import android.util.Pair;
import cn.jiguang.an.d;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Callable<InetAddress[]> {

    /* renamed from: a  reason: collision with root package name */
    private Context f3976a;

    /* renamed from: b  reason: collision with root package name */
    private String f3977b;

    /* renamed from: c  reason: collision with root package name */
    private a f3978c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, a aVar) {
        this.f3976a = context;
        this.f3977b = str;
        this.f3978c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InetAddress[] call() {
        InetAddress[] inetAddressArr;
        Map map;
        boolean z;
        try {
            inetAddressArr = InetAddress.getAllByName(this.f3977b);
        } catch (UnknownHostException e2) {
            d.f("DNSLoader", "dns resolve failed:" + e2);
            inetAddressArr = null;
        }
        if (inetAddressArr == null || inetAddressArr.length <= 0) {
            return inetAddressArr;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        for (InetAddress inetAddress : inetAddressArr) {
            if (i < 3 && (inetAddress instanceof Inet4Address)) {
                i++;
            } else if (i2 >= 3 || !(inetAddress instanceof Inet6Address)) {
                z = false;
                if (z) {
                    arrayList.add(inetAddress);
                    sb.append(inetAddress.getHostAddress());
                    sb.append(",");
                }
                if (i != 3 && i2 == 3) {
                    break;
                }
            } else {
                i2++;
            }
            z = true;
            if (z) {
            }
            if (i != 3) {
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        InetAddress[] inetAddressArr2 = (InetAddress[]) arrayList.toArray(new InetAddress[0]);
        long currentTimeMillis = System.currentTimeMillis();
        d.b("DNSLoader", "update dns cache url=" + this.f3977b + " resolved=" + Arrays.toString(inetAddressArr2));
        map = this.f3978c.f3975e;
        map.put(this.f3977b, new Pair(inetAddressArr2, Long.valueOf(currentTimeMillis)));
        try {
            sb.deleteCharAt(sb.length() - 1);
            cn.jiguang.g.b.a(this.f3976a, cn.jiguang.g.a.b(this.f3977b).a((cn.jiguang.g.a<String>) sb.toString()), cn.jiguang.g.a.c(this.f3977b).a((cn.jiguang.g.a<Long>) Long.valueOf(currentTimeMillis)));
            return inetAddressArr2;
        } catch (Throwable unused) {
            return inetAddressArr2;
        }
    }
}

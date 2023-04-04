package a.a.a.c.d;

import a.a.a.c.c;
import a.a.a.c.d;
import a.a.a.e.e;
import a.a.a.e.f;
import a.a.a.e.h;
import android.net.TrafficStats;

/* compiled from: HttpHelper.java */
/* loaded from: classes.dex */
public class b {
    public static void a() {
        long a2 = h.a();
        e eVar = new e(a.a.a.a.a().e());
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        a a3 = eVar.a();
        int a4 = h.a(a2);
        a3.c((((int) (TrafficStats.getTotalRxBytes() - totalRxBytes)) / a4) * 8);
        a3.a(a4);
        eVar.b();
        a3.b(h.a(a2));
        f.a("Http is end");
        d.a(c.HTTP, a3.a());
    }
}

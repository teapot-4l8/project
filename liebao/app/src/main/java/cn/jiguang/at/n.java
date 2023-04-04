package cn.jiguang.at;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile n f3962a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3963b = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static long f3964e = 1;

    /* renamed from: d  reason: collision with root package name */
    private cn.jiguang.ax.a f3966d = new o(this);

    /* renamed from: c  reason: collision with root package name */
    private Map<Long, c> f3965c = new HashMap();

    private n() {
    }

    public static n a() {
        if (f3962a == null) {
            synchronized (f3963b) {
                if (f3962a == null) {
                    f3962a = new n();
                }
            }
        }
        return f3962a;
    }

    private static byte[] a(Context context, c cVar) {
        return cn.jiguang.av.b.a(context, cVar.f3930d, cVar.f3931e, cVar.f, cVar.g, 0L);
    }

    public static long b() {
        long j = f3964e + 1;
        f3964e = j;
        if (j >= 2147483647L) {
            f3964e = 1L;
        }
        return f3964e;
    }

    public final void a(long j) {
        c remove = this.f3965c.remove(Long.valueOf(j));
        if (remove != null) {
            if (remove.j) {
                cn.jiguang.ax.b.a().b((int) (j + 100000));
            }
            cn.jiguang.an.d.b("TcpRequestManager", "handle reponse :" + remove);
        }
    }

    public final void a(Context context) {
        if (this.f3965c.isEmpty()) {
            cn.jiguang.an.d.b("TcpRequestManager", "no cache request");
            return;
        }
        for (Map.Entry<Long, c> entry : this.f3965c.entrySet()) {
            if (entry.getValue().j) {
                long nanoTime = System.nanoTime() - entry.getValue().h;
                if (entry.getValue().i - nanoTime >= 10000) {
                    entry.getValue().f3927a++;
                    cn.jiguang.an.d.b("TcpRequestManager", "send again:" + entry.getValue());
                    h.a().c().c().a(a(context, entry.getValue()));
                } else {
                    cn.jiguang.an.d.b("TcpRequestManager", "shoud not send again by 10000ms,hasRequestTime:" + nanoTime + ",timeout:" + entry.getValue().i);
                }
            }
        }
    }

    public final void a(Context context, long j) {
        c remove = this.f3965c.remove(Long.valueOf(j));
        if (remove == null) {
            cn.jiguang.an.d.f("TcpRequestManager", "not found requst by rid:" + j);
            return;
        }
        cn.jiguang.an.d.b("TcpRequestManager", "request time out:" + remove);
        b.a();
        b.a(context, remove.f3929c, remove.f3928b, remove.f3930d);
    }

    public final void a(Context context, long j, int i, int i2, byte[] bArr, String str) {
        long b2 = cn.jiguang.ar.c.b(context);
        if (this.f3965c.containsKey(Long.valueOf(b2))) {
            cn.jiguang.an.d.g("TcpRequestManager", "Generator same rid,not do this msg");
            return;
        }
        c cVar = new c(j, str, i, i2, b2, 0L, bArr);
        if (h.a().d()) {
            h.a().c().c().a(a(context, cVar));
        }
        this.f3965c.put(Long.valueOf(b2), cVar);
    }

    public final void a(Context context, long j, int i, int i2, byte[] bArr, String str, long j2) {
        long j3;
        if (i == 10) {
            j3 = j;
        } else {
            long b2 = cn.jiguang.ar.c.b(context);
            cn.jiguang.an.d.b("TcpRequestManager", "Generator new rid:" + b2);
            if (this.f3965c.containsKey(Long.valueOf(b2))) {
                cn.jiguang.an.d.g("TcpRequestManager", "Generator same rid,not do this msg");
                return;
            }
            j3 = b2;
        }
        long j4 = j2 <= 0 ? 10000L : j2;
        long j5 = j4;
        c cVar = new c(j, str, i, i2, j3, j4, bArr);
        if (h.a().d()) {
            h.a().c().c().a(a(context, cVar));
        }
        cVar.h = System.nanoTime();
        this.f3965c.put(Long.valueOf(j3), cVar);
        cn.jiguang.ax.b.a().b((int) (j3 + 100000), j5, this.f3966d);
    }

    public final c b(long j) {
        return this.f3965c.get(Long.valueOf(j));
    }
}

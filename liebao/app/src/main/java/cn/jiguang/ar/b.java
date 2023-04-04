package cn.jiguang.ar;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class b implements Callable<cn.jiguang.aw.a> {

    /* renamed from: a  reason: collision with root package name */
    private final l f3807a;

    /* renamed from: b  reason: collision with root package name */
    private final r f3808b;

    /* renamed from: c  reason: collision with root package name */
    private final g f3809c;

    /* renamed from: d  reason: collision with root package name */
    private final i f3810d;

    public b(l lVar, r rVar, g gVar, i iVar) {
        this.f3808b = rVar;
        this.f3807a = lVar;
        this.f3809c = gVar;
        this.f3810d = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public cn.jiguang.aw.a call() {
        boolean z;
        try {
            if (this.f3809c != null) {
                h a2 = this.f3809c.a(this.f3807a.a());
                if (this.f3808b.a()) {
                    return null;
                }
                if (this.f3810d != null && !this.f3810d.f3823a) {
                    if (a2 == null) {
                        return null;
                    }
                    if (!TextUtils.isEmpty(cn.jiguang.aq.a.f3804c)) {
                        a2.f3820a = cn.jiguang.aq.a.f3804c;
                        a2.f3822c = InetAddress.getByName(cn.jiguang.aq.a.f3804c);
                    }
                    if (cn.jiguang.aq.a.f3805d > 0) {
                        a2.f3821b = cn.jiguang.aq.a.f3805d;
                    }
                    cn.jiguang.an.d.c("ConnTask", "Open connection with ip=" + a2.f3822c + ", port:" + a2.f3821b);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    cn.jiguang.aw.b bVar = new cn.jiguang.aw.b(8128, 20);
                    int a3 = bVar.a(a2.f3820a, a2.f3821b);
                    if (this.f3808b.a()) {
                        cn.jiguang.f.k.a(bVar);
                        return null;
                    } else if (this.f3810d.f3823a) {
                        this.f3808b.a(new cn.jiguang.at.e(-991, null));
                        cn.jiguang.f.k.a(bVar);
                        return null;
                    } else if (a3 != 0) {
                        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                        this.f3807a.a(2, a2.f3820a, a2.f3821b, cn.jiguang.d.b.b(this.f3807a.f3835a), uptimeMillis2, a3);
                        cn.jiguang.an.d.d("ConnTask", "Failed(" + a3 + ") to open connection - ip:" + a2.f3822c + ", port:" + a2.f3821b + ", cost:" + uptimeMillis2);
                        e.a(this.f3807a.f3835a, a2, -1, uptimeMillis2);
                        cn.jiguang.f.k.a(bVar);
                        return null;
                    } else {
                        if (!(a2.f3822c instanceof Inet4Address) && !cn.jiguang.f.i.f(a2.f3820a)) {
                            z = false;
                            cn.jiguang.g.b.a(this.f3807a.f3835a, cn.jiguang.g.a.c(z).a((cn.jiguang.g.a<String>) a2.toString()));
                            cn.jiguang.an.d.e("ConnTask", "Succeed to open connection - ip:" + a2.f3822c + ", port:" + a2.f3821b);
                            this.f3808b.a(bVar);
                            e.a(this.f3807a.f3835a, a2, 1, 0L);
                            return bVar;
                        }
                        z = true;
                        cn.jiguang.g.b.a(this.f3807a.f3835a, cn.jiguang.g.a.c(z).a((cn.jiguang.g.a<String>) a2.toString()));
                        cn.jiguang.an.d.e("ConnTask", "Succeed to open connection - ip:" + a2.f3822c + ", port:" + a2.f3821b);
                        this.f3808b.a(bVar);
                        e.a(this.f3807a.f3835a, a2, 1, 0L);
                        return bVar;
                    }
                }
                this.f3808b.a(new cn.jiguang.at.e(-991, null));
                return null;
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.f("ConnTask", "run e:" + th);
        }
        return null;
    }
}

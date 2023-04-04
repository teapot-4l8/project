package b.a.f;

import android.net.Uri;
import b.a.h.a.b;
import com.umeng.analytics.pro.ak;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Uri f3171a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3172b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, Uri uri) {
        this.f3172b = aVar;
        this.f3171a = uri;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public b.a.h.a.b call() {
        b.a.h.a.b bVar;
        b.a.h.a.b a2;
        if (!this.f3172b.f3181d.a()) {
            String c2 = this.f3172b.h.c();
            b.a.h.a.b bVar2 = new b.a.h.a.b(b.a.ERROR, -12);
            bVar2.b("初始化时错误：" + c2);
            return bVar2;
        }
        Uri uri = this.f3171a;
        if (uri != null) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null || pathSegments.size() <= 0) {
                bVar = new b.a.h.a.b(b.a.SUCCESS, 1);
            } else if (pathSegments.get(0).equalsIgnoreCase(ak.aF)) {
                if (pathSegments.size() <= 1) {
                    b.a.h.a.b bVar3 = new b.a.h.a.b(b.a.SUCCESS, 1);
                    bVar3.c("");
                    return bVar3;
                }
                String a3 = b.a.k.b.a(pathSegments.get(1), 8);
                b.a.h.a.b bVar4 = new b.a.h.a.b(b.a.SUCCESS, 1);
                bVar4.c(a3);
                return bVar4;
            } else if (pathSegments.get(0).equalsIgnoreCase("h")) {
                b.a.h.a.d dVar = new b.a.h.a.d(this.f3172b.g);
                dVar.a("waU", this.f3171a.toString());
                a2 = b.a.h.a.a.a(true).a(this.f3172b.a(false, "decode-wakeup-url"), this.f3172b.f(), dVar);
            } else {
                bVar = new b.a.h.a.b(b.a.SUCCESS, 1);
            }
            bVar.b("The wakeup parameter is invalid");
            return bVar;
        }
        b.a.b.c b2 = this.f3172b.j.b();
        this.f3172b.j.c();
        b.a.h.a.d dVar2 = new b.a.h.a.d(this.f3172b.g);
        dVar2.a("md", this.f3172b.i.f());
        dVar2.a("bI", this.f3172b.i.g());
        dVar2.a("buiD", this.f3172b.i.h());
        dVar2.a("bd", this.f3172b.i.i());
        dVar2.a(this.f3172b.i.o());
        if (b2 != null) {
            if (b2.c(2)) {
                dVar2.a("pbH", b2.b());
            }
            if (b2.c(1)) {
                dVar2.a("pbT", b2.a());
            }
        }
        a2 = b.a.h.a.a.a(true).a(this.f3172b.a(false, "decode-wakeup-url"), this.f3172b.f(), dVar2);
        this.f3172b.a(a2.e());
        return a2;
    }
}

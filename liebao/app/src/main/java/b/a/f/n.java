package b.a.f;

import b.a.h.a.b;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f3176a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3177b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, long j) {
        this.f3177b = aVar;
        this.f3176a = j;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public b.a.h.a.b call() {
        if (this.f3177b.f3181d.a(this.f3176a)) {
            String b2 = this.f3177b.h.b();
            b.a.h.a.b bVar = new b.a.h.a.b(b.a.SUCCESS, 0);
            bVar.c(b2);
            this.f3177b.a(bVar.e());
            return bVar;
        }
        String c2 = this.f3177b.h.c();
        b.a.h.a.b bVar2 = new b.a.h.a.b(b.a.ERROR, -12);
        bVar2.b("初始化时错误：" + c2);
        return bVar2;
    }
}

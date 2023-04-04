package b.a.f;

import android.text.TextUtils;
import b.a.h.a.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f3160a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f3160a.f3181d.a()) {
            String c2 = this.f3160a.h.c();
            if (b.a.k.d.f3261a) {
                b.a.k.d.a("初始化时错误：" + c2, new Object[0]);
            }
        } else if (!this.f3160a.f3182e.f()) {
            if (b.a.k.d.f3261a) {
                b.a.k.d.a("registerStatsEnabled is disable", new Object[0]);
            }
        } else {
            b.a.h.a.b a2 = b.a.h.a.a.a(true).a(this.f3160a.a(true, "stats/register"), this.f3160a.f(), new b.a.h.a.d(this.f3160a.g));
            this.f3160a.a(a2.e());
            if (a2.a() != b.a.SUCCESS) {
                if (b.a.k.d.f3261a) {
                    b.a.k.d.c("statRegister fail : %s", a2.c());
                    return;
                }
                return;
            }
            if (b.a.k.d.f3261a) {
                b.a.k.d.a("statRegister success : %s", a2.d());
            }
            if (TextUtils.isEmpty(a2.c()) || !b.a.k.d.f3261a) {
                return;
            }
            b.a.k.d.b("statRegister warning : %s", a2.c());
        }
    }
}

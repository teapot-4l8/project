package b.a.f;

import android.net.Uri;
import android.text.TextUtils;
import b.a.h.a.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Uri f3158a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3159b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Uri uri) {
        this.f3159b = aVar;
        this.f3158a = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f3159b.f3181d.a()) {
            String c2 = this.f3159b.h.c();
            if (b.a.k.d.f3261a) {
                b.a.k.d.a("初始化时错误：" + c2, new Object[0]);
            }
        } else if (!this.f3159b.f3182e.b()) {
            if (b.a.k.d.f3261a) {
                b.a.k.d.a("wakeupStatsEnabled is disable", new Object[0]);
            }
        } else {
            b.a.h.a.d dVar = new b.a.h.a.d(this.f3159b.g);
            Uri uri = this.f3158a;
            if (uri != null) {
                dVar.a("ul", uri.toString());
            }
            b.a.h.a.b a2 = b.a.h.a.a.a(true).a(this.f3159b.a(true, "stats/wakeup"), this.f3159b.f(), dVar);
            this.f3159b.a(a2.e());
            if (a2.a() != b.a.SUCCESS) {
                if (b.a.k.d.f3261a) {
                    b.a.k.d.c("statWakeup fail : %s", a2.c());
                    return;
                }
                return;
            }
            if (b.a.k.d.f3261a) {
                b.a.k.d.a("statWakeup success : %s", a2.d());
            }
            if (TextUtils.isEmpty(a2.c()) || !b.a.k.d.f3261a) {
                return;
            }
            b.a.k.d.b("statWakeup warning : %s", a2.c());
        }
    }
}

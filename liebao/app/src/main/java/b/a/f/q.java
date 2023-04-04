package b.a.f;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import b.a.h.a.b;
import com.fm.openinstall.Configuration;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class q extends o {
    private final b.a.k.e n;
    private final b.a.e.d o;
    private long p;

    /* renamed from: q  reason: collision with root package name */
    private int f3186q;

    public q(Context context, Looper looper, b.a.b bVar, b.a.f fVar, b.a.c.b bVar2, Configuration configuration) {
        super(context, looper, bVar, fVar, bVar2, configuration);
        this.n = b.a.k.e.a("StatsHandler");
        this.f3186q = 0;
        this.o = new b.a.e.d(context);
        this.p = fVar.f();
    }

    private boolean b(b.a.e.a aVar) {
        if (aVar.b() == 2 && !this.f3182e.e()) {
            if (b.a.k.d.f3261a) {
                b.a.k.d.b("eventStatsEnabled is false", new Object[0]);
            }
            return false;
        } else if (aVar.b() == 1 && !this.f3182e.e()) {
            if (b.a.k.d.f3261a) {
                b.a.k.d.b("eventStatsEnabled is false", new Object[0]);
            }
            return false;
        } else if (aVar.b() != 0 || this.f3182e.f()) {
            return true;
        } else {
            if (b.a.k.d.f3261a) {
                b.a.k.d.b("registerStatsEnabled is false", new Object[0]);
            }
            return false;
        }
    }

    private boolean b(boolean z) {
        if (z) {
            if (!this.f3182e.e() && !this.f3182e.f()) {
                this.o.d();
                return false;
            } else if (!this.o.b()) {
                return false;
            }
        }
        if (this.f3182e.g() == null) {
            return false;
        }
        return this.f3182e.g().longValue() * 1000 < System.currentTimeMillis() - this.p;
    }

    private void c(b.a.e.a aVar) {
        boolean c2;
        if (b(aVar)) {
            this.o.c();
            this.o.a(aVar.toString());
            c2 = aVar.c();
        } else {
            c2 = false;
        }
        a(c2);
    }

    private void g() {
        this.f3186q = 0;
    }

    private void h() {
        int i = this.f3186q;
        if (i < 100) {
            this.f3186q = i + 1;
        }
    }

    private boolean i() {
        return this.f3186q < 10;
    }

    private void j() {
        if (!this.f3181d.a()) {
            this.h.c();
            return;
        }
        b.a.h.a.b a2 = b.a.h.a.a.a(false).a(a(true, "stats/events"), f(), this.o.e());
        a(a2.e());
        this.p = System.currentTimeMillis();
        if (a2.a() != b.a.SUCCESS) {
            if (b.a.k.d.f3261a) {
                b.a.k.d.c("statEvents fail : %s", a2.c());
            }
            h();
            if (this.o.a()) {
                this.o.d();
                return;
            }
            return;
        }
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("statEvents success : %s", a2.d());
        }
        if (!TextUtils.isEmpty(a2.c()) && b.a.k.d.f3261a) {
            b.a.k.d.b("statEvents warning : %s", a2.c());
        }
        g();
        this.o.d();
        this.h.a(this.p);
    }

    @Override // b.a.f.o
    protected ThreadPoolExecutor a() {
        return null;
    }

    @Override // b.a.f.o
    protected ThreadPoolExecutor b() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.f.o
    public void c() {
        super.c();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 21) {
            c((b.a.e.a) ((p) message.obj).a());
            return;
        }
        if (message.what == 22) {
            if (!((Boolean) ((p) message.obj).a()).booleanValue() && !b(false)) {
                return;
            }
        } else if (message.what != 23) {
            if (message.what == 0) {
                c();
                return;
            }
            return;
        } else if (!b(true) || !i()) {
            return;
        }
        j();
    }
}

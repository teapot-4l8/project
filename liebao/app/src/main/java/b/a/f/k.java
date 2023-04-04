package b.a.f;

import android.util.Pair;
import b.a.a.a;
import b.a.h.a.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3170a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.f3170a = aVar;
    }

    private long a(int i) {
        if (i < 3) {
            return 1L;
        }
        if (i < 8) {
            return 10L;
        }
        return i < 18 ? 30L : 60L;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0294  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        b.a.g gVar;
        String gaid;
        String oaid;
        b.a.g gVar2;
        b.a.b.c a2;
        int i;
        b.a.h.a.b a3;
        b.a.b bVar;
        b.a.c cVar;
        b.a.a.c cVar2;
        b.a.a.c cVar3;
        b.a.c b2 = this.f3170a.f3181d.b();
        if (b2 == null && (b2 = this.f3170a.h.a(this.f3170a.f)) == b.a.c.f3111a) {
            b2 = this.f3170a.h.a();
            this.f3170a.h.a(this.f3170a.f, b2);
        }
        if (b2 == b.a.c.f3111a) {
            this.f3170a.h.g();
        }
        if (b2 != b.a.c.f3111a && b2 != b.a.c.f3114d && b2 != b.a.c.f3115e) {
            this.f3170a.f3182e.a(this.f3170a.h.d());
            this.f3170a.f3181d.a(b2);
            this.f3170a.f3182e.i();
            return;
        }
        this.f3170a.f3181d.a(b.a.c.f3112b);
        gVar = this.f3170a.p;
        gVar.a(this.f3170a.f3180c);
        if (this.f3170a.l.isAdEnabled() && this.f3170a.l.getOaid() == null) {
            cVar3 = this.f3170a.o;
            cVar3.a(this.f3170a.f3180c);
        }
        b.a.h.a.d dVar = new b.a.h.a.d(this.f3170a.g);
        dVar.a("md", this.f3170a.i.f());
        dVar.a("bI", this.f3170a.i.g());
        dVar.a("buiD", this.f3170a.i.h());
        dVar.a("bd", this.f3170a.i.i());
        if (!this.f3170a.l.isImeiDisabled()) {
            Pair k = this.f3170a.i.k();
            dVar.a("im", (String) k.first);
            dVar.a("im2", (String) k.second);
        }
        dVar.a(this.f3170a.i.o());
        boolean a4 = b.a.d.c.a().a(this.f3170a.f3180c);
        if (a4 && b.a.k.d.f3261a) {
            b.a.k.d.a("check device is emulator", new Object[0]);
        }
        dVar.a("si", String.valueOf(a4));
        if (!this.f3170a.l.isAdEnabled() || this.f3170a.l.getGaid() != null) {
            if (this.f3170a.l.getGaid() != null) {
                if (b.a.k.d.f3261a) {
                    b.a.k.d.a("传入的 gaid 为 " + this.f3170a.l.getGaid(), new Object[0]);
                }
                gaid = this.f3170a.l.getGaid();
            }
            if (this.f3170a.l.isAdEnabled() || this.f3170a.l.getOaid() != null) {
                if (this.f3170a.l.getOaid() != null) {
                    if (b.a.k.d.f3261a) {
                        b.a.k.d.a("传入的 oaid 为 " + this.f3170a.l.getOaid(), new Object[0]);
                    }
                    oaid = this.f3170a.l.getOaid();
                }
                gVar2 = this.f3170a.p;
                dVar.a("gR", gVar2.a());
                b.a.b.c b3 = this.f3170a.j.b();
                this.f3170a.j.c();
                a2 = this.f3170a.a(b3);
                if (a2 != null) {
                    if (a2.c(2)) {
                        dVar.a("pbH", a2.b());
                    }
                    if (a2.c(1)) {
                        dVar.a("pbT", a2.a());
                    }
                }
                dVar.a("aI", this.f3170a.i.a());
                i = 0;
                do {
                    a3 = b.a.h.a.a.a(false).a(this.f3170a.a(false, "init"), this.f3170a.f(), dVar);
                    try {
                        this.f3170a.f3181d.b(a(i));
                    } catch (InterruptedException unused) {
                    }
                    i++;
                } while (a3.a() == b.a.FAIL);
                this.f3170a.a(a3.e());
                if (a3.a() == b.a.SUCCESS) {
                    this.f3170a.h.b(a3.d());
                    this.f3170a.h.c(a3.c());
                    bVar = this.f3170a.f3181d;
                    cVar = b.a.c.f3113c;
                } else if (a3.a() != b.a.ERROR) {
                    if (a3.a() == b.a.FAIL) {
                        this.f3170a.h.c(a3.c());
                        bVar = this.f3170a.f3181d;
                        cVar = b.a.c.f3114d;
                    }
                    this.f3170a.f3181d.c();
                    this.f3170a.h.a(this.f3170a.f, this.f3170a.f3181d.b());
                } else {
                    this.f3170a.h.c(a3.c());
                    bVar = this.f3170a.f3181d;
                    cVar = b.a.c.f3115e;
                }
                bVar.a(cVar);
                this.f3170a.f3181d.c();
                this.f3170a.h.a(this.f3170a.f, this.f3170a.f3181d.b());
            }
            cVar2 = this.f3170a.o;
            oaid = cVar2.a();
            dVar.a("oa", oaid);
            gVar2 = this.f3170a.p;
            dVar.a("gR", gVar2.a());
            b.a.b.c b32 = this.f3170a.j.b();
            this.f3170a.j.c();
            a2 = this.f3170a.a(b32);
            if (a2 != null) {
            }
            dVar.a("aI", this.f3170a.i.a());
            i = 0;
            do {
                a3 = b.a.h.a.a.a(false).a(this.f3170a.a(false, "init"), this.f3170a.f(), dVar);
                this.f3170a.f3181d.b(a(i));
                i++;
            } while (a3.a() == b.a.FAIL);
            this.f3170a.a(a3.e());
            if (a3.a() == b.a.SUCCESS) {
            }
            bVar.a(cVar);
            this.f3170a.f3181d.c();
            this.f3170a.h.a(this.f3170a.f, this.f3170a.f3181d.b());
        }
        a.C0064a a5 = b.a.a.a.a(this.f3170a.f3180c);
        gaid = a5 == null ? "" : a5.a();
        dVar.a("ga", gaid);
        if (this.f3170a.l.isAdEnabled()) {
        }
        if (this.f3170a.l.getOaid() != null) {
        }
        gVar2 = this.f3170a.p;
        dVar.a("gR", gVar2.a());
        b.a.b.c b322 = this.f3170a.j.b();
        this.f3170a.j.c();
        a2 = this.f3170a.a(b322);
        if (a2 != null) {
        }
        dVar.a("aI", this.f3170a.i.a());
        i = 0;
        do {
            a3 = b.a.h.a.a.a(false).a(this.f3170a.a(false, "init"), this.f3170a.f(), dVar);
            this.f3170a.f3181d.b(a(i));
            i++;
        } while (a3.a() == b.a.FAIL);
        this.f3170a.a(a3.e());
        if (a3.a() == b.a.SUCCESS) {
        }
        bVar.a(cVar);
        this.f3170a.f3181d.c();
        this.f3170a.h.a(this.f3170a.f, this.f3170a.f3181d.b());
    }
}

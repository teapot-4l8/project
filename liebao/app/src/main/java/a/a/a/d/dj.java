package a.a.a.d;

import a.a.a.d.ct;
import java.io.IOException;
import java.io.PrintStream;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ZoneTransferIn.java */
/* loaded from: classes.dex */
public class dj {

    /* renamed from: a  reason: collision with root package name */
    private bj f288a;

    /* renamed from: b  reason: collision with root package name */
    private int f289b;

    /* renamed from: c  reason: collision with root package name */
    private int f290c;

    /* renamed from: d  reason: collision with root package name */
    private long f291d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f292e;
    private c f;
    private SocketAddress g;
    private SocketAddress h;
    private cq i;
    private ct j;
    private ct.a k;
    private long l = 900000;
    private int m;
    private long n;
    private long o;
    private bx p;

    /* renamed from: q  reason: collision with root package name */
    private int f293q;

    /* compiled from: ZoneTransferIn.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void a(bx bxVar);

        void b();

        void b(bx bxVar);

        void c(bx bxVar);
    }

    /* compiled from: ZoneTransferIn.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f296a;

        /* renamed from: b  reason: collision with root package name */
        public long f297b;

        /* renamed from: c  reason: collision with root package name */
        public List<bx> f298c;

        /* renamed from: d  reason: collision with root package name */
        public List<bx> f299d;

        private b() {
            this.f298c = new ArrayList();
            this.f299d = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ZoneTransferIn.java */
    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private List<bx> f294a;

        /* renamed from: b  reason: collision with root package name */
        private List<b> f295b;

        private a() {
        }

        @Override // a.a.a.d.dj.c
        public void a() {
            this.f294a = new ArrayList();
        }

        @Override // a.a.a.d.dj.c
        public void b() {
            this.f295b = new ArrayList();
        }

        @Override // a.a.a.d.dj.c
        public void a(bx bxVar) {
            b bVar = new b();
            bVar.f299d.add(bxVar);
            bVar.f296a = dj.b(bxVar);
            this.f295b.add(bVar);
        }

        @Override // a.a.a.d.dj.c
        public void b(bx bxVar) {
            List<b> list = this.f295b;
            b bVar = list.get(list.size() - 1);
            bVar.f298c.add(bxVar);
            bVar.f297b = dj.b(bxVar);
        }

        @Override // a.a.a.d.dj.c
        public void c(bx bxVar) {
            List<b> list = this.f295b;
            if (list != null) {
                b bVar = list.get(list.size() - 1);
                if (bVar.f298c.size() > 0) {
                    bVar.f298c.add(bxVar);
                    return;
                } else {
                    bVar.f299d.add(bxVar);
                    return;
                }
            }
            this.f294a.add(bxVar);
        }
    }

    private dj() {
    }

    private dj(bj bjVar, int i, long j, boolean z, SocketAddress socketAddress, ct ctVar) {
        this.h = socketAddress;
        this.j = ctVar;
        if (bjVar.a()) {
            this.f288a = bjVar;
        } else {
            try {
                this.f288a = bj.a(bjVar, bj.f178a);
            } catch (bk unused) {
                throw new IllegalArgumentException("ZoneTransferIn: name too long");
            }
        }
        this.f289b = i;
        this.f290c = 1;
        this.f291d = j;
        this.f292e = z;
        this.m = 0;
    }

    public static dj a(bj bjVar, SocketAddress socketAddress, ct ctVar) {
        return new dj(bjVar, 252, 0L, false, socketAddress, ctVar);
    }

    public void a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout cannot be negative");
        }
        this.l = i * 1000;
    }

    public void a(SocketAddress socketAddress) {
        this.g = socketAddress;
    }

    private void c() {
        cq cqVar = new cq(System.currentTimeMillis() + this.l);
        this.i = cqVar;
        SocketAddress socketAddress = this.g;
        if (socketAddress != null) {
            cqVar.a(socketAddress);
        }
        this.i.b(this.h);
    }

    private void d() {
        bx a2 = bx.a(this.f288a, this.f289b, this.f290c);
        ax axVar = new ax();
        axVar.a().d(0);
        axVar.a(a2, 0);
        if (this.f289b == 251) {
            axVar.a(new cg(this.f288a, this.f290c, 0L, bj.f178a, bj.f178a, this.f291d, 0L, 0L, 0L, 0L), 2);
        }
        ct ctVar = this.j;
        if (ctVar != null) {
            ctVar.a(axVar, (cu) null);
            this.k = new ct.a(this.j, axVar.c());
        }
        this.i.a(axVar.c(65535));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(bx bxVar) {
        return ((cg) bxVar).e();
    }

    private void a(String str) {
        if (bo.b("verbose")) {
            PrintStream printStream = System.out;
            printStream.println(this.f288a + ": " + str);
        }
    }

    private void b(String str) {
        throw new di(str);
    }

    private void e() {
        if (!this.f292e) {
            b("server doesn't support IXFR");
        }
        a("falling back to AXFR");
        this.f289b = 252;
        this.m = 0;
    }

    private void c(bx bxVar) {
        int k = bxVar.k();
        switch (this.m) {
            case 0:
                if (k != 6) {
                    b("missing initial SOA");
                }
                this.p = bxVar;
                long b2 = b(bxVar);
                this.n = b2;
                if (this.f289b == 251 && cl.a(b2, this.f291d) <= 0) {
                    a("up to date");
                    this.m = 7;
                    return;
                }
                this.m = 1;
                return;
            case 1:
                if (this.f289b == 251 && k == 6 && b(bxVar) == this.f291d) {
                    this.f293q = 251;
                    this.f.b();
                    a("got incremental response");
                    this.m = 2;
                } else {
                    this.f293q = 252;
                    this.f.a();
                    this.f.c(this.p);
                    a("got nonincremental response");
                    this.m = 6;
                }
                c(bxVar);
                return;
            case 2:
                this.f.a(bxVar);
                this.m = 3;
                return;
            case 3:
                if (k == 6) {
                    this.o = b(bxVar);
                    this.m = 4;
                    c(bxVar);
                    return;
                }
                this.f.c(bxVar);
                return;
            case 4:
                this.f.b(bxVar);
                this.m = 5;
                return;
            case 5:
                if (k == 6) {
                    long b3 = b(bxVar);
                    if (b3 == this.n) {
                        this.m = 7;
                        return;
                    } else if (b3 != this.o) {
                        b("IXFR out of sync: expected serial " + this.o + " , got " + b3);
                    } else {
                        this.m = 2;
                        c(bxVar);
                        return;
                    }
                }
                this.f.c(bxVar);
                return;
            case 6:
                if (k != 1 || bxVar.l() == this.f290c) {
                    this.f.c(bxVar);
                    if (k == 6) {
                        this.m = 7;
                        return;
                    }
                    return;
                }
                return;
            case 7:
                b("extra data");
                return;
            default:
                b("invalid state");
                return;
        }
    }

    private void f() {
        try {
            if (this.i != null) {
                this.i.a();
            }
        } catch (IOException unused) {
        }
    }

    private ax a(byte[] bArr) {
        try {
            return new ax(bArr);
        } catch (IOException e2) {
            if (e2 instanceof dg) {
                throw ((dg) e2);
            }
            throw new dg("Error parsing message");
        }
    }

    private void g() {
        d();
        while (this.m != 7) {
            byte[] b2 = this.i.b();
            ax a2 = a(b2);
            if (a2.a().c() == 0 && this.k != null) {
                a2.c();
                if (this.k.a(a2, b2) != 0) {
                    b("TSIG failure");
                }
            }
            bx[] a3 = a2.a(1);
            if (this.m == 0) {
                int g = a2.g();
                if (g != 0) {
                    if (this.f289b == 251 && g == 4) {
                        e();
                        g();
                        return;
                    }
                    b(bw.a(g));
                }
                bx b3 = a2.b();
                if (b3 != null && b3.k() != this.f289b) {
                    b("invalid question section");
                }
                if (a3.length == 0 && this.f289b == 251) {
                    e();
                    g();
                    return;
                }
            }
            for (bx bxVar : a3) {
                c(bxVar);
            }
            if (this.m == 7 && this.k != null && !a2.e()) {
                b("last message must be signed");
            }
        }
    }

    public void a(c cVar) {
        this.f = cVar;
        try {
            c();
            g();
        } finally {
            f();
        }
    }

    public List a() {
        a aVar = new a();
        a(aVar);
        return aVar.f294a != null ? aVar.f294a : aVar.f295b;
    }

    private a h() {
        c cVar = this.f;
        if (cVar instanceof a) {
            return (a) cVar;
        }
        throw new IllegalArgumentException("ZoneTransferIn used callback interface");
    }

    public List b() {
        return h().f294a;
    }
}

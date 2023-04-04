package a.a.a.d;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lookup.java */
/* loaded from: classes.dex */
public final class ap {
    private static final bj[] C = new bj[0];

    /* renamed from: a  reason: collision with root package name */
    private static ca f139a;

    /* renamed from: b  reason: collision with root package name */
    private static bj[] f140b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<Integer, l> f141c;

    /* renamed from: d  reason: collision with root package name */
    private static int f142d;
    private boolean A;
    private boolean B;

    /* renamed from: e  reason: collision with root package name */
    private ca f143e;
    private bj[] f;
    private l g;
    private boolean h;
    private int i;
    private bj j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private boolean p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f144q;
    private List<bj> r;
    private bx[] s;
    private int t;
    private String u;
    private boolean v;
    private boolean w;
    private String x;
    private boolean y;
    private boolean z;

    static {
        a();
    }

    public static synchronized void a() {
        synchronized (ap.class) {
            try {
                f139a = new z();
                f140b = cb.j().h();
                f141c = new HashMap();
                f142d = cb.j().i();
            } catch (UnknownHostException unused) {
                throw new RuntimeException("Failed to initialize resolver");
            }
        }
    }

    public static synchronized ca b() {
        ca caVar;
        synchronized (ap.class) {
            caVar = f139a;
        }
        return caVar;
    }

    public static synchronized l a(int i) {
        l lVar;
        synchronized (ap.class) {
            p.a(i);
            lVar = f141c.get(Integer.valueOf(i));
            if (lVar == null) {
                lVar = new l(i);
                f141c.put(Integer.valueOf(i), lVar);
            }
        }
        return lVar;
    }

    public static synchronized bj[] c() {
        bj[] bjVarArr;
        synchronized (ap.class) {
            bjVarArr = f140b;
        }
        return bjVarArr;
    }

    private void h() {
        this.n = 0;
        this.o = false;
        this.p = false;
        this.f144q = false;
        this.r = null;
        this.s = null;
        this.t = -1;
        this.u = null;
        this.v = false;
        this.w = false;
        this.x = null;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        if (this.h) {
            this.g.a();
        }
    }

    public ap(bj bjVar, int i, int i2) {
        cz.a(i);
        p.a(i2);
        if (!cz.d(i) && i != 255) {
            throw new IllegalArgumentException("Cannot query for meta-types other than ANY");
        }
        this.j = bjVar;
        this.k = i;
        this.l = i2;
        synchronized (ap.class) {
            this.f143e = b();
            this.f = c();
            this.g = a(i2);
        }
        this.i = 3;
        this.m = bo.b("verbose");
        this.t = -1;
    }

    public ap(String str) {
        this(bj.a(str), 1, 1);
    }

    public void a(ca caVar) {
        this.f143e = caVar;
    }

    private void a(bj bjVar, bj bjVar2) {
        this.o = true;
        this.w = false;
        this.y = false;
        this.z = false;
        this.v = false;
        this.B = false;
        int i = this.n + 1;
        this.n = i;
        if (i >= 10 || bjVar.equals(bjVar2)) {
            this.t = 1;
            this.u = "CNAME loop";
            this.p = true;
            return;
        }
        if (this.r == null) {
            this.r = new ArrayList();
        }
        this.r.add(bjVar2);
        a(bjVar);
    }

    private void a(bj bjVar, cm cmVar) {
        if (cmVar.f()) {
            List<bu<?>> g = cmVar.g();
            ArrayList arrayList = new ArrayList();
            for (bu<?> buVar : g) {
                arrayList.addAll(buVar.c());
            }
            this.t = 0;
            this.s = (bx[]) arrayList.toArray(new bx[0]);
            this.p = true;
        } else if (cmVar.a()) {
            this.v = true;
            this.f144q = true;
            if (this.n > 0) {
                this.t = 3;
                this.p = true;
            }
        } else if (cmVar.b()) {
            this.t = 4;
            this.s = null;
            this.p = true;
        } else if (cmVar.d()) {
            a(cmVar.h().g_(), bjVar);
        } else if (cmVar.e()) {
            try {
                a(bjVar.a(cmVar.i()), bjVar);
            } catch (bk unused) {
                this.t = 1;
                this.u = "Invalid DNAME target";
                this.p = true;
            }
        } else if (cmVar.c()) {
            this.B = true;
        }
    }

    private void a(bj bjVar) {
        cm b2 = this.g.b(bjVar, this.k, this.i);
        if (this.m) {
            PrintStream printStream = System.err;
            printStream.println("lookup " + bjVar + " " + cz.b(this.k));
            System.err.println(b2);
        }
        a(bjVar, b2);
        if (this.p || this.f144q) {
            return;
        }
        ax a2 = ax.a(bx.a(bjVar, this.k, this.l));
        try {
            ax a3 = this.f143e.a(a2);
            int c2 = a3.a().c();
            if (c2 != 0 && c2 != 3) {
                this.w = true;
                this.x = bw.a(c2);
            } else if (!a2.b().equals(a3.b())) {
                this.w = true;
                this.x = "response does not match query";
            } else {
                cm a4 = this.g.a(a3);
                if (a4 == null) {
                    a4 = this.g.b(bjVar, this.k, this.i);
                }
                if (this.m) {
                    PrintStream printStream2 = System.err;
                    printStream2.println("queried " + bjVar + " " + cz.b(this.k));
                    System.err.println(a4);
                }
                a(bjVar, a4);
            }
        } catch (IOException e2) {
            if (e2 instanceof InterruptedIOException) {
                this.z = true;
            } else {
                this.y = true;
            }
        }
    }

    private void b(bj bjVar, bj bjVar2) {
        this.f144q = false;
        if (bjVar2 != null) {
            try {
                bjVar = bj.a(bjVar, bjVar2);
            } catch (bk unused) {
                this.A = true;
                return;
            }
        }
        a(bjVar);
    }

    public bx[] d() {
        if (this.p) {
            h();
        }
        if (this.j.a()) {
            b(this.j, null);
        } else if (this.f == null) {
            b(this.j, bj.f178a);
        } else {
            if (this.j.c() > f142d) {
                b(this.j, bj.f178a);
            }
            if (this.p) {
                return this.s;
            }
            for (bj bjVar : this.f) {
                b(this.j, bjVar);
                if (this.p) {
                    return this.s;
                }
                if (this.o) {
                    break;
                }
            }
        }
        if (!this.p) {
            if (this.w) {
                this.t = 2;
                this.u = this.x;
                this.p = true;
            } else if (this.z) {
                this.t = 2;
                this.u = "timed out";
                this.p = true;
            } else if (this.y) {
                this.t = 2;
                this.u = "network error";
                this.p = true;
            } else if (this.v) {
                this.t = 3;
                this.p = true;
            } else if (this.B) {
                this.t = 1;
                this.u = "referral";
                this.p = true;
            } else if (this.A) {
                this.t = 1;
                this.u = "name too long";
                this.p = true;
            }
        }
        return this.s;
    }

    private void i() {
        if (!this.p || this.t == -1) {
            StringBuilder sb = new StringBuilder("Lookup of " + this.j + " ");
            int i = this.l;
            if (i != 1) {
                sb.append(p.b(i));
                sb.append(" ");
            }
            sb.append(cz.b(this.k));
            sb.append(" isn't done");
            throw new IllegalStateException(sb.toString());
        }
    }

    public bx[] e() {
        i();
        return this.s;
    }

    public int f() {
        i();
        return this.t;
    }

    public String g() {
        i();
        String str = this.u;
        if (str != null) {
            return str;
        }
        int i = this.t;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return "type not found";
                        }
                        throw new IllegalStateException("unknown result");
                    }
                    return "host not found";
                }
                return "try again";
            }
            return "unrecoverable error";
        }
        return "successful";
    }
}

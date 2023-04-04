package a.a.a.c;

import a.a.a.e.f;
import java.util.LinkedList;
import java.util.List;

/* compiled from: HttpFactory.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private List<c> f36a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private int f37b;

    public void a() {
        if (a.a.a.a.a().e() == null) {
            f.b("Please init HttpModelHelper first");
            return;
        }
        for (c cVar : this.f36a) {
            switch (AnonymousClass1.f38a[cVar.ordinal()]) {
                case 1:
                    f.a("Index is start");
                    try {
                        a.a.a.c.e.b.a();
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        break;
                    }
                case 2:
                    f.a("Net is start");
                    try {
                        a.a.a.c.g.b.a();
                        break;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        break;
                    }
                case 3:
                    f.a("Ping is start");
                    try {
                        a.a.a.c.h.b.a();
                        break;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        break;
                    }
                case 4:
                    f.a("Http is start");
                    try {
                        a.a.a.c.d.b.a();
                        break;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        break;
                    }
                case 5:
                    f.a("Host is start");
                    try {
                        a.a.a.c.c.b.a();
                        break;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        break;
                    }
                case 6:
                    f.a("PortScan is start");
                    try {
                        a.a.a.c.i.b.a();
                        break;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        break;
                    }
                case 7:
                    f.a("MtuScan is start");
                    try {
                        a.a.a.c.f.b.a();
                        break;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        break;
                    }
                case 8:
                    f.a("TraceRoute is start");
                    try {
                        a.a.a.c.j.b.a();
                        break;
                    } catch (Exception e9) {
                        e9.printStackTrace();
                        break;
                    }
                case 9:
                    f.a("NsLookup is start");
                    try {
                        a.a.a.c.b.b.a();
                        break;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        break;
                    }
            }
        }
        this.f36a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpFactory.java */
    /* renamed from: a.a.a.c.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f38a;

        static {
            int[] iArr = new int[c.values().length];
            f38a = iArr;
            try {
                iArr[c.INDEX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38a[c.NET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38a[c.PING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38a[c.HTTP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38a[c.HOST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38a[c.PORT_SCAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38a[c.MTU_SCAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f38a[c.TRACE_ROUTE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f38a[c.NSLOOKUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public int b() {
        return this.f37b;
    }

    public a c() {
        this.f36a.add(c.INDEX);
        this.f36a.add(c.PING);
        this.f36a.add(c.NET);
        this.f36a.add(c.TRACE_ROUTE);
        this.f36a.add(c.NSLOOKUP);
        this.f36a.add(c.HTTP);
        this.f36a.add(c.HOST);
        this.f36a.add(c.MTU_SCAN);
        this.f36a.add(c.PORT_SCAN);
        return this;
    }

    public a.a.a.a d() {
        this.f37b = this.f36a.size();
        return a.a.a.a.a();
    }
}

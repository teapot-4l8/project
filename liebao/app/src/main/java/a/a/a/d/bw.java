package a.a.a.d;

/* compiled from: Rcode.java */
/* loaded from: classes.dex */
public final class bw {

    /* renamed from: a  reason: collision with root package name */
    private static ay f196a = new ay("DNS Rcode", 2);

    /* renamed from: b  reason: collision with root package name */
    private static ay f197b = new ay("TSIG rcode", 2);

    static {
        f196a.b(4095);
        f196a.a("RESERVED");
        f196a.a(true);
        f196a.a(0, "NOERROR");
        f196a.a(1, "FORMERR");
        f196a.a(2, "SERVFAIL");
        f196a.a(3, "NXDOMAIN");
        f196a.a(4, "NOTIMP");
        f196a.b(4, "NOTIMPL");
        f196a.a(5, "REFUSED");
        f196a.a(6, "YXDOMAIN");
        f196a.a(7, "YXRRSET");
        f196a.a(8, "NXRRSET");
        f196a.a(9, "NOTAUTH");
        f196a.a(10, "NOTZONE");
        f196a.a(16, "BADVERS");
        f197b.b(65535);
        f197b.a("RESERVED");
        f197b.a(true);
        f197b.a(f196a);
        f197b.a(16, "BADSIG");
        f197b.a(17, "BADKEY");
        f197b.a(18, "BADTIME");
        f197b.a(19, "BADMODE");
    }

    public static String a(int i) {
        return f196a.c(i);
    }

    public static String b(int i) {
        return f197b.c(i);
    }
}

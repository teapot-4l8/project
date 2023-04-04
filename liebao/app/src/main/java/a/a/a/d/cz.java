package a.a.a.d;

import java.util.HashMap;

/* compiled from: Type.java */
/* loaded from: classes.dex */
public final class cz {

    /* renamed from: a  reason: collision with root package name */
    private static a f267a;

    public static boolean d(int i) {
        if (i != 41) {
            switch (i) {
                case 249:
                case 250:
                case 251:
                case 252:
                case 253:
                case 254:
                case 255:
                    return false;
                default:
                    return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Type.java */
    /* loaded from: classes.dex */
    public static class a extends ay {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<Integer, bx> f268a;

        public a() {
            super("Type", 2);
            a("TYPE");
            this.f268a = new HashMap<>();
        }

        public void a(int i, String str, bx bxVar) {
            super.a(i, str);
            this.f268a.put(Integer.valueOf(i), bxVar);
        }

        @Override // a.a.a.d.ay
        public void a(int i) {
            cz.a(i);
        }

        public bx d(int i) {
            a(i);
            return this.f268a.get(Integer.valueOf(i));
        }
    }

    static {
        a aVar = new a();
        f267a = aVar;
        aVar.a(1, "A", new e());
        f267a.a(2, "NS", new bg());
        f267a.a(3, "MD", new ar());
        f267a.a(4, "MF", new as());
        f267a.a(5, "CNAME", new k());
        f267a.a(6, "SOA", new cg());
        f267a.a(7, "MB", new aq());
        f267a.a(8, "MG", new at());
        f267a.a(9, "MR", new av());
        f267a.a(10, "NULL", new bh());
        f267a.a(11, "WKS", new df());
        f267a.a(12, "PTR", new bp());
        f267a.a(13, "HINFO", new ae());
        f267a.a(14, "MINFO", new au());
        f267a.a(15, "MX", new aw());
        f267a.a(16, "TXT", new cx());
        f267a.a(17, "RP", new bs());
        f267a.a(18, "AFSDB", new c());
        f267a.a(19, "X25", new dh());
        f267a.a(20, "ISDN", new ah());
        f267a.a(21, "RT", new bv());
        f267a.a(22, "NSAP", new ba());
        f267a.a(23, "NSAP-PTR", new bb());
        f267a.a(24, "SIG", new ce());
        f267a.a(25, "KEY", new am());
        f267a.a(26, "PX", new bq());
        f267a.a(27, "GPOS", new ac());
        f267a.a(28, "AAAA", new b());
        f267a.a(29, "LOC", new ao());
        f267a.a(30, "NXT", new bi());
        f267a.a(31, "EID");
        f267a.a(32, "NIMLOC");
        f267a.a(33, "SRV", new ci());
        f267a.a(34, "ATMA");
        f267a.a(35, "NAPTR", new az());
        f267a.a(36, "KX", new an());
        f267a.a(37, "CERT", new j());
        f267a.a(38, "A6", new a.a.a.d.a());
        f267a.a(39, "DNAME", new s());
        f267a.a(41, "OPT", new bm());
        f267a.a(42, "APL", new d());
        f267a.a(43, "DS", new w());
        f267a.a(44, "SSHFP", new cj());
        f267a.a(45, "IPSECKEY", new ag());
        f267a.a(46, "RRSIG", new bt());
        f267a.a(47, "NSEC", new be());
        f267a.a(48, "DNSKEY", new u());
        f267a.a(49, "DHCID", new q());
        f267a.a(50, "NSEC3", new bd());
        f267a.a(51, "NSEC3PARAM", new bc());
        f267a.a(52, "TLSA", new cs());
        f267a.a(53, "SMIMEA", new cf());
        f267a.a(60, "CDNSKEY", new h());
        f267a.a(59, "CDS", new i());
        f267a.a(61, "OPENPGPKEY", new bl());
        f267a.a(99, "SPF", new ch());
        f267a.a(249, "TKEY", new cr());
        f267a.a(250, "TSIG", new cu());
        f267a.a(251, "IXFR");
        f267a.a(252, "AXFR");
        f267a.a(253, "MAILB");
        f267a.a(254, "MAILA");
        f267a.a(255, "ANY");
        f267a.a(256, "URI", new de());
        f267a.a(257, "CAA", new g());
        f267a.a(com.umeng.commonsdk.internal.a.f, "DLV", new r());
    }

    public static void a(int i) {
        if (i < 0 || i > 65535) {
            throw new ak(i);
        }
    }

    public static String b(int i) {
        return f267a.c(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bx c(int i) {
        return f267a.d(i);
    }
}

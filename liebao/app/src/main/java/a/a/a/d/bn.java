package a.a.a.d;

/* compiled from: Opcode.java */
/* loaded from: classes.dex */
public final class bn {

    /* renamed from: a  reason: collision with root package name */
    private static ay f185a;

    static {
        ay ayVar = new ay("DNS Opcode", 2);
        f185a = ayVar;
        ayVar.b(15);
        f185a.a("RESERVED");
        f185a.a(true);
        f185a.a(0, "QUERY");
        f185a.a(1, "IQUERY");
        f185a.a(2, "STATUS");
        f185a.a(4, "NOTIFY");
        f185a.a(5, "UPDATE");
    }

    public static String a(int i) {
        return f185a.c(i);
    }
}

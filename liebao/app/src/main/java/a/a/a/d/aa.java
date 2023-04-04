package a.a.a.d;

/* compiled from: Flags.java */
/* loaded from: classes.dex */
public final class aa {

    /* renamed from: a  reason: collision with root package name */
    private static ay f109a;

    static {
        ay ayVar = new ay("DNS Header Flag", 3);
        f109a = ayVar;
        ayVar.b(15);
        f109a.a("FLAG");
        f109a.a(true);
        f109a.a(0, "qr");
        f109a.a(5, "aa");
        f109a.a(6, "tc");
        f109a.a(7, "rd");
        f109a.a(8, "ra");
        f109a.a(10, com.umeng.analytics.pro.ak.aw);
        f109a.a(11, "cd");
    }

    public static String a(int i) {
        return f109a.c(i);
    }

    public static boolean b(int i) {
        f109a.a(i);
        return (i < 1 || i > 4) && i < 12;
    }
}

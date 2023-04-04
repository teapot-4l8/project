package a.a.a.d;

/* compiled from: DClass.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static ay f331a;

    /* compiled from: DClass.java */
    /* loaded from: classes.dex */
    private static class a extends ay {
        public a() {
            super("DClass", 2);
            a("CLASS");
        }

        @Override // a.a.a.d.ay
        public void a(int i) {
            p.a(i);
        }
    }

    static {
        a aVar = new a();
        f331a = aVar;
        aVar.a(1, "IN");
        f331a.a(3, "CH");
        f331a.b(3, "CHAOS");
        f331a.a(4, "HS");
        f331a.b(4, "HESIOD");
        f331a.a(254, "NONE");
        f331a.a(255, "ANY");
    }

    public static void a(int i) {
        if (i < 0 || i > 65535) {
            throw new ai(i);
        }
    }

    public static String b(int i) {
        return f331a.c(i);
    }
}

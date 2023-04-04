package kotlin.f;

/* compiled from: Ranges.kt */
/* loaded from: classes2.dex */
public final class c extends kotlin.f.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f7179b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static final c f7180c = new c(1, 0);

    public c(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer f() {
        return Integer.valueOf(a());
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    @Override // kotlin.f.a
    public boolean e() {
        return a() > b();
    }

    @Override // kotlin.f.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!e() || !((c) obj).e()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.f.a
    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.f.a
    public String toString() {
        return a() + ".." + b();
    }

    /* compiled from: Ranges.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.d.b.g gVar) {
            this();
        }

        public final c a() {
            return c.f7180c;
        }
    }
}

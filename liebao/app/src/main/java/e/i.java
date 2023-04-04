package e;

/* compiled from: HttpException.java */
/* loaded from: classes2.dex */
public class i extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final int f7047a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7048b;

    /* renamed from: c  reason: collision with root package name */
    private final transient r<?> f7049c;

    private static String a(r<?> rVar) {
        u.a(rVar, "response == null");
        return "HTTP " + rVar.a() + " " + rVar.b();
    }

    public i(r<?> rVar) {
        super(a(rVar));
        this.f7047a = rVar.a();
        this.f7048b = rVar.b();
        this.f7049c = rVar;
    }
}

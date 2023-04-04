package androidx.work.impl.b;

/* compiled from: WorkNameDao_Impl.java */
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.room.j f2860a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c f2861b;

    public i(androidx.room.j jVar) {
        this.f2860a = jVar;
        this.f2861b = new androidx.room.c<g>(jVar) { // from class: androidx.work.impl.b.i.1
            @Override // androidx.room.n
            public String a() {
                return "INSERT OR IGNORE INTO `WorkName`(`name`,`work_spec_id`) VALUES (?,?)";
            }

            @Override // androidx.room.c
            public void a(androidx.e.a.f fVar, g gVar) {
                if (gVar.f2858a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, gVar.f2858a);
                }
                if (gVar.f2859b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, gVar.f2859b);
                }
            }
        };
    }

    @Override // androidx.work.impl.b.h
    public void a(g gVar) {
        this.f2860a.f();
        this.f2860a.g();
        try {
            this.f2861b.a((androidx.room.c) gVar);
            this.f2860a.j();
        } finally {
            this.f2860a.h();
        }
    }
}

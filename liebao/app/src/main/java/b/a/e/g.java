package b.a.e;

/* loaded from: classes.dex */
class g extends b {

    /* renamed from: a  reason: collision with root package name */
    long f3149a = 0;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f3150b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.f3150b = eVar;
    }

    @Override // b.a.e.b
    public void a(long j) {
        this.f3149a = j;
    }

    @Override // b.a.e.b
    public void b(long j) {
        this.f3150b.a((j - this.f3149a) / 1000);
    }
}

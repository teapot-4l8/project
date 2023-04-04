package b.a.j;

/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b.a.h.a.b f3249a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3250b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, b.a.h.a.b bVar2) {
        this.f3250b = bVar;
        this.f3249a = bVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.f3250b.f3246c;
        aVar.a(this.f3249a);
    }
}

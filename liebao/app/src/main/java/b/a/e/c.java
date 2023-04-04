package b.a.e;

/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3141a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        z = this.f3141a.f3139c;
        if (z) {
            z2 = this.f3141a.f3140d;
            if (z2) {
                this.f3141a.f3139c = false;
                this.f3141a.b(System.currentTimeMillis());
            }
        }
    }
}

package org.greenrobot.eventbus;

/* compiled from: PendingPostQueue.java */
/* loaded from: classes2.dex */
final class k {

    /* renamed from: a  reason: collision with root package name */
    private j f7821a;

    /* renamed from: b  reason: collision with root package name */
    private j f7822b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(j jVar) {
        try {
            if (jVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.f7822b != null) {
                this.f7822b.f7820c = jVar;
                this.f7822b = jVar;
            } else if (this.f7821a == null) {
                this.f7822b = jVar;
                this.f7821a = jVar;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized j a() {
        j jVar;
        jVar = this.f7821a;
        if (this.f7821a != null) {
            j jVar2 = this.f7821a.f7820c;
            this.f7821a = jVar2;
            if (jVar2 == null) {
                this.f7822b = null;
            }
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized j a(int i) {
        if (this.f7821a == null) {
            wait(i);
        }
        return a();
    }
}

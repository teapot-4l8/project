package org.greenrobot.eventbus;

/* compiled from: Subscription.java */
/* loaded from: classes2.dex */
final class q {

    /* renamed from: a  reason: collision with root package name */
    final Object f7842a;

    /* renamed from: b  reason: collision with root package name */
    final o f7843b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f7844c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Object obj, o oVar) {
        this.f7842a = obj;
        this.f7843b = oVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            return this.f7842a == qVar.f7842a && this.f7843b.equals(qVar.f7843b);
        }
        return false;
    }

    public int hashCode() {
        return this.f7842a.hashCode() + this.f7843b.f.hashCode();
    }
}

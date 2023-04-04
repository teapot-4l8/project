package org.greenrobot.eventbus;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncPoster.java */
/* loaded from: classes2.dex */
public class a implements Runnable, l {

    /* renamed from: a  reason: collision with root package name */
    private final k f7785a = new k();

    /* renamed from: b  reason: collision with root package name */
    private final c f7786b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.f7786b = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        this.f7785a.a(j.a(qVar, obj));
        this.f7786b.b().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        j a2 = this.f7785a.a();
        if (a2 == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f7786b.a(a2);
    }
}

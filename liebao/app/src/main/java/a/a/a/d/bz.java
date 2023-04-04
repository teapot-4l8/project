package a.a.a.d;

/* compiled from: ResolveThread.java */
/* loaded from: classes.dex */
class bz extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private ax f199a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f200b;

    /* renamed from: c  reason: collision with root package name */
    private cc f201c;

    /* renamed from: d  reason: collision with root package name */
    private ca f202d;

    public bz(ca caVar, ax axVar, Integer num, cc ccVar) {
        this.f202d = caVar;
        this.f199a = axVar;
        this.f200b = num;
        this.f201c = ccVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.f201c.a(this.f200b, this.f202d.a(this.f199a));
        } catch (Exception e2) {
            this.f201c.a(this.f200b, e2);
        }
    }
}

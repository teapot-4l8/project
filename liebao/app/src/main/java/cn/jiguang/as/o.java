package cn.jiguang.as;

/* loaded from: classes.dex */
public final class o extends j {

    /* renamed from: e  reason: collision with root package name */
    private int f3918e;
    private int f;
    private int g;
    private h h;

    @Override // cn.jiguang.as.j
    final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f3918e + " ");
        stringBuffer.append(this.f + " ");
        stringBuffer.append(this.g + " ");
        stringBuffer.append(this.h);
        return stringBuffer.toString();
    }

    @Override // cn.jiguang.as.j
    final void a(c cVar) {
        this.f3918e = cVar.g();
        this.f = cVar.g();
        this.g = cVar.g();
        this.h = new h(cVar);
    }

    @Override // cn.jiguang.as.j
    final void a(d dVar, boolean z) {
        dVar.c(this.f3918e);
        dVar.c(this.f);
        dVar.c(this.g);
        this.h.a(dVar, (a) null, true);
    }

    public final int h() {
        return this.g;
    }

    public final h i() {
        return this.h;
    }
}

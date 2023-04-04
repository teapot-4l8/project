package androidx.constraintlayout.a.a;

/* compiled from: ResolutionDimension.java */
/* loaded from: classes.dex */
public class n extends o {

    /* renamed from: a  reason: collision with root package name */
    float f1312a = 0.0f;

    @Override // androidx.constraintlayout.a.a.o
    public void b() {
        super.b();
        this.f1312a = 0.0f;
    }

    public void a(int i) {
        if (this.i == 0 || this.f1312a != i) {
            this.f1312a = i;
            if (this.i == 1) {
                e();
            }
            f();
        }
    }

    public void c() {
        this.i = 2;
    }
}

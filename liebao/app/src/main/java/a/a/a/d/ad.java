package a.a.a.d;

/* compiled from: GenericEDNSOption.java */
/* loaded from: classes.dex */
public class ad extends x {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f115a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(int i) {
        super(i);
    }

    @Override // a.a.a.d.x
    void a(t tVar) {
        this.f115a = tVar.j();
    }

    @Override // a.a.a.d.x
    void a(v vVar) {
        vVar.a(this.f115a);
    }

    @Override // a.a.a.d.x
    String a() {
        return "<" + a.a.a.d.a.a.a(this.f115a) + ">";
    }
}

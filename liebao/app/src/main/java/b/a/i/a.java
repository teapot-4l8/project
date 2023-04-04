package b.a.i;

/* loaded from: classes.dex */
public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final f f3232a;

    /* renamed from: b  reason: collision with root package name */
    private final e f3233b;

    public a(e eVar, f fVar) {
        this.f3232a = fVar;
        this.f3233b = eVar;
    }

    public a(f fVar) {
        this(null, fVar);
    }

    public f a() {
        return this.f3232a;
    }

    public void a(byte[] bArr) {
        e eVar = this.f3233b;
        if (eVar != null) {
            eVar.a(bArr);
        } else {
            this.f3232a.a(bArr);
        }
    }

    public e b() {
        return this.f3233b;
    }

    public byte[] c() {
        e eVar = this.f3233b;
        return eVar != null ? eVar.d() : this.f3232a.g;
    }

    /* renamed from: d */
    public a clone() {
        e eVar = this.f3233b;
        return new a(eVar == null ? null : eVar.clone(), this.f3232a.clone());
    }
}

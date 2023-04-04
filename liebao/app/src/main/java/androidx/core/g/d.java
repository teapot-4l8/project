package androidx.core.g;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f1595a;

    /* renamed from: b  reason: collision with root package name */
    public final S f1596b;

    public d(F f, S s) {
        this.f1595a = f;
        this.f1596b = s;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return c.a(dVar.f1595a, this.f1595a) && c.a(dVar.f1596b, this.f1596b);
        }
        return false;
    }

    public int hashCode() {
        F f = this.f1595a;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f1596b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1595a) + " " + String.valueOf(this.f1596b) + "}";
    }
}

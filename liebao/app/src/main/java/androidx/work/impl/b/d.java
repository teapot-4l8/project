package androidx.work.impl.b;

/* compiled from: SystemIdInfo.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f2851a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2852b;

    public d(String str, int i) {
        this.f2851a = str;
        this.f2852b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f2852b != dVar.f2852b) {
            return false;
        }
        return this.f2851a.equals(dVar.f2851a);
    }

    public int hashCode() {
        return (this.f2851a.hashCode() * 31) + this.f2852b;
    }
}

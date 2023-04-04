package androidx.core.h;

/* compiled from: DisplayCutoutCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1708a;

    private c(Object obj) {
        this.f1708a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        Object obj2 = this.f1708a;
        if (obj2 == null) {
            return cVar.f1708a == null;
        }
        return obj2.equals(cVar.f1708a);
    }

    public int hashCode() {
        Object obj = this.f1708a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f1708a + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new c(obj);
    }
}

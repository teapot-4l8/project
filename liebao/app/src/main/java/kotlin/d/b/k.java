package kotlin.d.b;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* compiled from: PropertyReference.java */
/* loaded from: classes2.dex */
public abstract class k extends c implements KProperty {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.d.b.c
    /* renamed from: g */
    public KProperty d() {
        return (KProperty) super.d();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return d().isLateinit();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return d().isConst();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return e().equals(kVar.e()) && getName().equals(kVar.getName()) && f().equals(kVar.f()) && i.a(b(), kVar.b());
        } else if (obj instanceof KProperty) {
            return obj.equals(c());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((e().hashCode() * 31) + getName().hashCode()) * 31) + f().hashCode();
    }

    public String toString() {
        KCallable c2 = c();
        if (c2 != this) {
            return c2.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}

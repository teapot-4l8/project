package com.trello.rxlifecycle3;

import b.b.e;
import b.b.f;
import b.b.g;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: LifecycleTransformer.java */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class b<T> implements g<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final e<?> f6301a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e<?> eVar) {
        com.trello.rxlifecycle3.b.a.a(eVar, "observable == null");
        this.f6301a = eVar;
    }

    @Override // b.b.g
    public f<T> a(e<T> eVar) {
        return eVar.b((f) this.f6301a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f6301a.equals(((b) obj).f6301a);
    }

    public int hashCode() {
        return this.f6301a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.f6301a + '}';
    }
}

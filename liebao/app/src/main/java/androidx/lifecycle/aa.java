package androidx.lifecycle;

import java.util.HashMap;

/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, x> f1997a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, x xVar) {
        x put = this.f1997a.put(str, xVar);
        if (put != null) {
            put.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final x a(String str) {
        return this.f1997a.get(str);
    }

    public final void a() {
        for (x xVar : this.f1997a.values()) {
            xVar.d();
        }
        this.f1997a.clear();
    }
}

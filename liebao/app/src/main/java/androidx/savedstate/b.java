package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.h;

/* compiled from: SavedStateRegistryController.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final c f2493a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2494b = new a();

    private b(c cVar) {
        this.f2493a = cVar;
    }

    public a a() {
        return this.f2494b;
    }

    public void a(Bundle bundle) {
        h lifecycle = this.f2493a.getLifecycle();
        if (lifecycle.a() != h.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.f2493a));
        this.f2494b.a(lifecycle, bundle);
    }

    public void b(Bundle bundle) {
        this.f2494b.a(bundle);
    }

    public static b a(c cVar) {
        return new b(cVar);
    }
}

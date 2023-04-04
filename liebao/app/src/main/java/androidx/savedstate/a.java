package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import java.util.Map;

/* compiled from: SavedStateRegistry.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private Bundle f2491c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2492d;

    /* renamed from: b  reason: collision with root package name */
    private androidx.a.a.b.b<String, b> f2490b = new androidx.a.a.b.b<>();

    /* renamed from: a  reason: collision with root package name */
    boolean f2489a = true;

    /* compiled from: SavedStateRegistry.java */
    /* renamed from: androidx.savedstate.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a {
        void a(c cVar);
    }

    /* compiled from: SavedStateRegistry.java */
    /* loaded from: classes.dex */
    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (!this.f2492d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f2491c;
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle(str);
            this.f2491c.remove(str);
            if (this.f2491c.isEmpty()) {
                this.f2491c = null;
            }
            return bundle2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar, Bundle bundle) {
        if (this.f2492d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f2491c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        hVar.a(new g() { // from class: androidx.savedstate.SavedStateRegistry$1
            @Override // androidx.lifecycle.j
            public void onStateChanged(l lVar, h.a aVar) {
                if (aVar == h.a.ON_START) {
                    a.this.f2489a = true;
                } else if (aVar == h.a.ON_STOP) {
                    a.this.f2489a = false;
                }
            }
        });
        this.f2492d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2491c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        androidx.a.a.b.b<String, b>.d c2 = this.f2490b.c();
        while (c2.hasNext()) {
            Map.Entry next = c2.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}

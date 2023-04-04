package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1994a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a f1995b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1994a = obj;
        this.f1995b = b.f1998a.b(this.f1994a.getClass());
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, h.a aVar) {
        this.f1995b.a(lVar, aVar, this.f1994a);
    }
}

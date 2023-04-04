package androidx.lifecycle;

import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements j {

    /* renamed from: a  reason: collision with root package name */
    private final f f1996a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(f fVar) {
        this.f1996a = fVar;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, h.a aVar) {
        this.f1996a.a(lVar, aVar, false, null);
        this.f1996a.a(lVar, aVar, true, null);
    }
}

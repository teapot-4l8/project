package androidx.lifecycle;

import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements j {

    /* renamed from: a  reason: collision with root package name */
    private final f[] f1978a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.f1978a = fVarArr;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, h.a aVar) {
        q qVar = new q();
        for (f fVar : this.f1978a) {
            fVar.a(lVar, aVar, false, qVar);
        }
        for (f fVar2 : this.f1978a) {
            fVar2.a(lVar, aVar, true, qVar);
        }
    }
}

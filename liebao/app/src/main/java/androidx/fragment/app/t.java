package androidx.fragment.app;

import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentViewLifecycleOwner.java */
/* loaded from: classes.dex */
public class t implements androidx.lifecycle.l {

    /* renamed from: a  reason: collision with root package name */
    private androidx.lifecycle.m f1977a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f1977a == null) {
            this.f1977a = new androidx.lifecycle.m(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f1977a != null;
    }

    @Override // androidx.lifecycle.l
    public androidx.lifecycle.h getLifecycle() {
        a();
        return this.f1977a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h.a aVar) {
        this.f1977a.a(aVar);
    }
}

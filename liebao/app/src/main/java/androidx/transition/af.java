package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
class af implements ag {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f2516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ViewGroup viewGroup) {
        this.f2516a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.am
    public void a(Drawable drawable) {
        this.f2516a.add(drawable);
    }

    @Override // androidx.transition.am
    public void b(Drawable drawable) {
        this.f2516a.remove(drawable);
    }

    @Override // androidx.transition.ag
    public void a(View view) {
        this.f2516a.add(view);
    }

    @Override // androidx.transition.ag
    public void b(View view) {
        this.f2516a.remove(view);
    }
}

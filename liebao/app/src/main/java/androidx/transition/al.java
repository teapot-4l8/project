package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18.java */
/* loaded from: classes.dex */
class al implements am {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f2530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(View view) {
        this.f2530a = view.getOverlay();
    }

    @Override // androidx.transition.am
    public void a(Drawable drawable) {
        this.f2530a.add(drawable);
    }

    @Override // androidx.transition.am
    public void b(Drawable drawable) {
        this.f2530a.remove(drawable);
    }
}

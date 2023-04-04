package androidx.core.h;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
public final class t implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f1731a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f1732b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f1733c;

    private t(View view, Runnable runnable) {
        this.f1731a = view;
        this.f1732b = view.getViewTreeObserver();
        this.f1733c = runnable;
    }

    public static t a(View view, Runnable runnable) {
        if (view != null) {
            if (runnable == null) {
                throw new NullPointerException("runnable == null");
            }
            t tVar = new t(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(tVar);
            view.addOnAttachStateChangeListener(tVar);
            return tVar;
        }
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.f1733c.run();
        return true;
    }

    public void a() {
        if (this.f1732b.isAlive()) {
            this.f1732b.removeOnPreDrawListener(this);
        } else {
            this.f1731a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1731a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f1732b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}

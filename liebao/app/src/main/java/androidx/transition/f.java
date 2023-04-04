package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Fade.java */
/* loaded from: classes.dex */
public class f extends as {
    public f(int i) {
        a(i);
    }

    public f() {
    }

    @Override // androidx.transition.as, androidx.transition.w
    public void captureStartValues(ac acVar) {
        super.captureStartValues(acVar);
        acVar.f2509a.put("android:fade:transitionAlpha", Float.valueOf(an.c(acVar.f2510b)));
    }

    private Animator a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        an.a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, an.f2531a, f2);
        ofFloat.addListener(new a(view));
        addListener(new x() { // from class: androidx.transition.f.1
            @Override // androidx.transition.x, androidx.transition.w.d
            public void b(w wVar) {
                an.a(view, 1.0f);
                an.e(view);
                wVar.removeListener(this);
            }
        });
        return ofFloat;
    }

    @Override // androidx.transition.as
    public Animator a(ViewGroup viewGroup, View view, ac acVar, ac acVar2) {
        float a2 = a(acVar, 0.0f);
        return a(view, a2 != 1.0f ? a2 : 0.0f, 1.0f);
    }

    @Override // androidx.transition.as
    public Animator b(ViewGroup viewGroup, View view, ac acVar, ac acVar2) {
        an.d(view);
        return a(view, a(acVar, 1.0f), 0.0f);
    }

    private static float a(ac acVar, float f) {
        Float f2;
        return (acVar == null || (f2 = (Float) acVar.f2509a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Fade.java */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f2619a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2620b = false;

        a(View view) {
            this.f2619a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (androidx.core.h.w.u(this.f2619a) && this.f2619a.getLayerType() == 0) {
                this.f2620b = true;
                this.f2619a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            an.a(this.f2619a, 1.0f);
            if (this.f2620b) {
                this.f2619a.setLayerType(0, null);
            }
        }
    }
}

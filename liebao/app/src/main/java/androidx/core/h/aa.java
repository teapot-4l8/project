package androidx.core.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class aa {

    /* renamed from: a  reason: collision with root package name */
    Runnable f1676a = null;

    /* renamed from: b  reason: collision with root package name */
    Runnable f1677b = null;

    /* renamed from: c  reason: collision with root package name */
    int f1678c = -1;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<View> f1679d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(View view) {
        this.f1679d = new WeakReference<>(view);
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class a implements ab {

        /* renamed from: a  reason: collision with root package name */
        aa f1686a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1687b;

        a(aa aaVar) {
            this.f1686a = aaVar;
        }

        @Override // androidx.core.h.ab
        public void a(View view) {
            this.f1687b = false;
            if (this.f1686a.f1678c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f1686a.f1676a != null) {
                Runnable runnable = this.f1686a.f1676a;
                this.f1686a.f1676a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ab abVar = tag instanceof ab ? (ab) tag : null;
            if (abVar != null) {
                abVar.a(view);
            }
        }

        @Override // androidx.core.h.ab
        public void b(View view) {
            if (this.f1686a.f1678c > -1) {
                view.setLayerType(this.f1686a.f1678c, null);
                this.f1686a.f1678c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f1687b) {
                if (this.f1686a.f1677b != null) {
                    Runnable runnable = this.f1686a.f1677b;
                    this.f1686a.f1677b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                ab abVar = tag instanceof ab ? (ab) tag : null;
                if (abVar != null) {
                    abVar.b(view);
                }
                this.f1687b = true;
            }
        }

        @Override // androidx.core.h.ab
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            ab abVar = tag instanceof ab ? (ab) tag : null;
            if (abVar != null) {
                abVar.c(view);
            }
        }
    }

    public aa a(long j) {
        View view = this.f1679d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public aa a(float f) {
        View view = this.f1679d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public aa b(float f) {
        View view = this.f1679d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public long a() {
        View view = this.f1679d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public aa a(Interpolator interpolator) {
        View view = this.f1679d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public aa b(long j) {
        View view = this.f1679d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = this.f1679d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = this.f1679d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public aa a(ab abVar) {
        View view = this.f1679d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, abVar);
            } else {
                view.setTag(2113929216, abVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(final View view, final ab abVar) {
        if (abVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.h.aa.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    abVar.c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    abVar.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    abVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public aa a(final ad adVar) {
        final View view = this.f1679d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(adVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.h.aa.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    adVar.a(view);
                }
            } : null);
        }
        return this;
    }
}

package com.lxj.xpopup.a;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: ShadowBgAnimator.java */
/* loaded from: classes.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public ArgbEvaluator f5384c;

    /* renamed from: d  reason: collision with root package name */
    public int f5385d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5386e;

    public e(View view) {
        super(view);
        this.f5384c = new ArgbEvaluator();
        this.f5385d = 0;
        this.f5386e = false;
    }

    public e() {
        this.f5384c = new ArgbEvaluator();
        this.f5385d = 0;
        this.f5386e = false;
    }

    @Override // com.lxj.xpopup.a.b
    public void a() {
        this.f5373a.setBackgroundColor(this.f5385d);
    }

    @Override // com.lxj.xpopup.a.b
    public void b() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f5384c, Integer.valueOf(this.f5385d), Integer.valueOf(com.lxj.xpopup.a.a()));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lxj.xpopup.a.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.f5373a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.setInterpolator(new androidx.d.a.a.b());
        ofObject.setDuration(this.f5386e ? 0L : com.lxj.xpopup.a.b()).start();
    }

    @Override // com.lxj.xpopup.a.b
    public void c() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f5384c, Integer.valueOf(com.lxj.xpopup.a.a()), Integer.valueOf(this.f5385d));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lxj.xpopup.a.e.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.f5373a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.setInterpolator(new androidx.d.a.a.b());
        ofObject.setDuration(this.f5386e ? 0L : com.lxj.xpopup.a.b()).start();
    }

    public int a(float f) {
        return ((Integer) this.f5384c.evaluate(f, Integer.valueOf(this.f5385d), Integer.valueOf(com.lxj.xpopup.a.a()))).intValue();
    }
}

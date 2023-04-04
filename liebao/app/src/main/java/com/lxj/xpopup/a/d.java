package com.lxj.xpopup.a;

import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: ScrollScaleAnimator.java */
/* loaded from: classes.dex */
public class d extends b {

    /* renamed from: c  reason: collision with root package name */
    public boolean f5377c;

    /* renamed from: d  reason: collision with root package name */
    private FloatEvaluator f5378d;

    /* renamed from: e  reason: collision with root package name */
    private IntEvaluator f5379e;
    private int f;
    private int g;
    private float h;
    private float i;

    public d(View view, com.lxj.xpopup.c.c cVar) {
        super(view, cVar);
        this.f5378d = new FloatEvaluator();
        this.f5379e = new IntEvaluator();
        this.h = 0.2f;
        this.i = 0.0f;
        this.f5377c = false;
    }

    @Override // com.lxj.xpopup.a.b
    public void a() {
        this.f5373a.setAlpha(this.h);
        this.f5373a.setScaleX(this.i);
        if (!this.f5377c) {
            this.f5373a.setScaleY(this.i);
        }
        this.f5373a.post(new Runnable() { // from class: com.lxj.xpopup.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.d();
                d.this.f5373a.scrollTo(d.this.f, d.this.g);
                if (d.this.f5373a.getBackground() != null) {
                    d.this.f5373a.getBackground().setAlpha(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScrollScaleAnimator.java */
    /* renamed from: com.lxj.xpopup.a.d$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5383a;

        static {
            int[] iArr = new int[com.lxj.xpopup.c.c.values().length];
            f5383a = iArr;
            try {
                iArr[com.lxj.xpopup.c.c.ScrollAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5383a[com.lxj.xpopup.c.c.ScrollAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5383a[com.lxj.xpopup.c.c.ScrollAlphaFromTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5383a[com.lxj.xpopup.c.c.ScrollAlphaFromRightTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5383a[com.lxj.xpopup.c.c.ScrollAlphaFromRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5383a[com.lxj.xpopup.c.c.ScrollAlphaFromRightBottom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5383a[com.lxj.xpopup.c.c.ScrollAlphaFromBottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5383a[com.lxj.xpopup.c.c.ScrollAlphaFromLeftBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        switch (AnonymousClass4.f5383a[this.f5374b.ordinal()]) {
            case 1:
                this.f5373a.setPivotX(0.0f);
                this.f5373a.setPivotY(this.f5373a.getMeasuredHeight() / 2);
                this.f = this.f5373a.getMeasuredWidth();
                this.g = 0;
                return;
            case 2:
                this.f5373a.setPivotX(0.0f);
                this.f5373a.setPivotY(0.0f);
                this.f = this.f5373a.getMeasuredWidth();
                this.g = this.f5373a.getMeasuredHeight();
                return;
            case 3:
                this.f5373a.setPivotX(this.f5373a.getMeasuredWidth() / 2);
                this.f5373a.setPivotY(0.0f);
                this.g = this.f5373a.getMeasuredHeight();
                return;
            case 4:
                this.f5373a.setPivotX(this.f5373a.getMeasuredWidth());
                this.f5373a.setPivotY(0.0f);
                this.f = -this.f5373a.getMeasuredWidth();
                this.g = this.f5373a.getMeasuredHeight();
                return;
            case 5:
                this.f5373a.setPivotX(this.f5373a.getMeasuredWidth());
                this.f5373a.setPivotY(this.f5373a.getMeasuredHeight() / 2);
                this.f = -this.f5373a.getMeasuredWidth();
                return;
            case 6:
                this.f5373a.setPivotX(this.f5373a.getMeasuredWidth());
                this.f5373a.setPivotY(this.f5373a.getMeasuredHeight());
                this.f = -this.f5373a.getMeasuredWidth();
                this.g = -this.f5373a.getMeasuredHeight();
                return;
            case 7:
                this.f5373a.setPivotX(this.f5373a.getMeasuredWidth() / 2);
                this.f5373a.setPivotY(this.f5373a.getMeasuredHeight());
                this.g = -this.f5373a.getMeasuredHeight();
                return;
            case 8:
                this.f5373a.setPivotX(0.0f);
                this.f5373a.setPivotY(this.f5373a.getMeasuredHeight());
                this.f = this.f5373a.getMeasuredWidth();
                this.g = -this.f5373a.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    @Override // com.lxj.xpopup.a.b
    public void b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lxj.xpopup.a.d.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view = d.this.f5373a;
                FloatEvaluator floatEvaluator = d.this.f5378d;
                Float valueOf = Float.valueOf(d.this.h);
                Float valueOf2 = Float.valueOf(1.0f);
                view.setAlpha(floatEvaluator.evaluate(animatedFraction, (Number) valueOf, (Number) valueOf2).floatValue());
                d.this.f5373a.scrollTo(d.this.f5379e.evaluate(animatedFraction, Integer.valueOf(d.this.f), (Integer) 0).intValue(), d.this.f5379e.evaluate(animatedFraction, Integer.valueOf(d.this.g), (Integer) 0).intValue());
                float floatValue = d.this.f5378d.evaluate(animatedFraction, (Number) Float.valueOf(d.this.i), (Number) valueOf2).floatValue();
                d.this.f5373a.setScaleX(floatValue);
                if (!d.this.f5377c) {
                    d.this.f5373a.setScaleY(floatValue);
                }
                if (animatedFraction < 0.9f || d.this.f5373a.getBackground() == null) {
                    return;
                }
                d.this.f5373a.getBackground().setAlpha((int) (((animatedFraction - 0.9f) / 0.1f) * 255.0f));
            }
        });
        ofFloat.setDuration(com.lxj.xpopup.a.b()).setInterpolator(new androidx.d.a.a.b());
        ofFloat.start();
    }

    @Override // com.lxj.xpopup.a.b
    public void c() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lxj.xpopup.a.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view = d.this.f5373a;
                FloatEvaluator floatEvaluator = d.this.f5378d;
                Float valueOf = Float.valueOf(1.0f);
                view.setAlpha(floatEvaluator.evaluate(animatedFraction, (Number) valueOf, (Number) Float.valueOf(d.this.h)).floatValue());
                d.this.f5373a.scrollTo(d.this.f5379e.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(d.this.f)).intValue(), d.this.f5379e.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(d.this.g)).intValue());
                float floatValue = d.this.f5378d.evaluate(animatedFraction, (Number) valueOf, (Number) Float.valueOf(d.this.i)).floatValue();
                d.this.f5373a.setScaleX(floatValue);
                if (!d.this.f5377c) {
                    d.this.f5373a.setScaleY(floatValue);
                }
                if (d.this.f5373a.getBackground() != null) {
                    d.this.f5373a.getBackground().setAlpha((int) (animatedFraction * 255.0f));
                }
            }
        });
        ofFloat.setDuration(com.lxj.xpopup.a.b()).setInterpolator(new androidx.d.a.a.b());
        ofFloat.start();
    }
}

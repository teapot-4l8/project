package com.lxj.xpopup.a;

import android.view.View;

/* compiled from: TranslateAlphaAnimator.java */
/* loaded from: classes.dex */
public class f extends b {

    /* renamed from: c  reason: collision with root package name */
    private float f5389c;

    /* renamed from: d  reason: collision with root package name */
    private float f5390d;

    /* renamed from: e  reason: collision with root package name */
    private float f5391e;
    private float f;

    public f(View view, com.lxj.xpopup.c.c cVar) {
        super(view, cVar);
    }

    @Override // com.lxj.xpopup.a.b
    public void a() {
        this.f5391e = this.f5373a.getTranslationX();
        this.f = this.f5373a.getTranslationY();
        this.f5373a.setAlpha(0.0f);
        d();
        this.f5389c = this.f5373a.getTranslationX();
        this.f5390d = this.f5373a.getTranslationY();
    }

    private void d() {
        int a2 = com.lxj.xpopup.g.c.a(this.f5373a.getContext()) / 2;
        int measuredWidth = this.f5373a.getMeasuredWidth() / 2;
        int b2 = com.lxj.xpopup.g.c.b(this.f5373a.getContext()) / 2;
        int measuredHeight = this.f5373a.getMeasuredHeight() / 2;
        int i = AnonymousClass1.f5392a[this.f5374b.ordinal()];
        if (i == 1) {
            this.f5373a.setTranslationX(-this.f5373a.getMeasuredWidth());
        } else if (i == 2) {
            this.f5373a.setTranslationY(-this.f5373a.getMeasuredHeight());
        } else if (i == 3) {
            this.f5373a.setTranslationX(this.f5373a.getMeasuredWidth());
        } else if (i != 4) {
        } else {
            this.f5373a.setTranslationY(this.f5373a.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranslateAlphaAnimator.java */
    /* renamed from: com.lxj.xpopup.a.f$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5392a;

        static {
            int[] iArr = new int[com.lxj.xpopup.c.c.values().length];
            f5392a = iArr;
            try {
                iArr[com.lxj.xpopup.c.c.TranslateAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5392a[com.lxj.xpopup.c.c.TranslateAlphaFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5392a[com.lxj.xpopup.c.c.TranslateAlphaFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5392a[com.lxj.xpopup.c.c.TranslateAlphaFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.lxj.xpopup.a.b
    public void b() {
        this.f5373a.animate().translationX(this.f5391e).translationY(this.f).alpha(1.0f).setInterpolator(new androidx.d.a.a.b()).setDuration(com.lxj.xpopup.a.b()).start();
    }

    @Override // com.lxj.xpopup.a.b
    public void c() {
        this.f5373a.animate().translationX(this.f5389c).translationY(this.f5390d).alpha(0.0f).setInterpolator(new androidx.d.a.a.b()).setDuration(com.lxj.xpopup.a.b()).start();
    }
}

package com.lxj.xpopup.a;

import android.view.View;

/* compiled from: TranslateAnimator.java */
/* loaded from: classes.dex */
public class g extends b {

    /* renamed from: c  reason: collision with root package name */
    private float f5393c;

    /* renamed from: d  reason: collision with root package name */
    private float f5394d;

    /* renamed from: e  reason: collision with root package name */
    private int f5395e;
    private int f;
    private float g;
    private float h;
    private boolean i;

    public g(View view, com.lxj.xpopup.c.c cVar) {
        super(view, cVar);
        this.i = false;
    }

    @Override // com.lxj.xpopup.a.b
    public void a() {
        if (!this.i) {
            this.g = this.f5373a.getTranslationX();
            this.h = this.f5373a.getTranslationY();
            this.i = true;
        }
        d();
        this.f5393c = this.f5373a.getTranslationX();
        this.f5394d = this.f5373a.getTranslationY();
        this.f5395e = this.f5373a.getMeasuredWidth();
        this.f = this.f5373a.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranslateAnimator.java */
    /* renamed from: com.lxj.xpopup.a.g$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5396a;

        static {
            int[] iArr = new int[com.lxj.xpopup.c.c.values().length];
            f5396a = iArr;
            try {
                iArr[com.lxj.xpopup.c.c.TranslateFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5396a[com.lxj.xpopup.c.c.TranslateFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5396a[com.lxj.xpopup.c.c.TranslateFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5396a[com.lxj.xpopup.c.c.TranslateFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void d() {
        int i = AnonymousClass1.f5396a[this.f5374b.ordinal()];
        if (i == 1) {
            this.f5373a.setTranslationX(-this.f5373a.getRight());
        } else if (i == 2) {
            this.f5373a.setTranslationY(-this.f5373a.getBottom());
        } else if (i == 3) {
            this.f5373a.setTranslationX(((View) this.f5373a.getParent()).getMeasuredWidth() - this.f5373a.getLeft());
        } else if (i != 4) {
        } else {
            this.f5373a.setTranslationY(((View) this.f5373a.getParent()).getMeasuredHeight() - this.f5373a.getTop());
        }
    }

    @Override // com.lxj.xpopup.a.b
    public void b() {
        this.f5373a.animate().translationX(this.g).translationY(this.h).setInterpolator(new androidx.d.a.a.b()).setDuration(com.lxj.xpopup.a.b()).start();
    }

    @Override // com.lxj.xpopup.a.b
    public void c() {
        int i = AnonymousClass1.f5396a[this.f5374b.ordinal()];
        if (i == 1) {
            this.f5393c -= this.f5373a.getMeasuredWidth() - this.f5395e;
        } else if (i == 2) {
            this.f5394d -= this.f5373a.getMeasuredHeight() - this.f;
        } else if (i == 3) {
            this.f5393c += this.f5373a.getMeasuredWidth() - this.f5395e;
        } else if (i == 4) {
            this.f5394d += this.f5373a.getMeasuredHeight() - this.f;
        }
        this.f5373a.animate().translationX(this.f5393c).translationY(this.f5394d).setInterpolator(new androidx.d.a.a.b()).setDuration(com.lxj.xpopup.a.b()).start();
    }
}

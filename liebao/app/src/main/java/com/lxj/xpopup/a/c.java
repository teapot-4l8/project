package com.lxj.xpopup.a;

import android.view.View;
import android.view.animation.OvershootInterpolator;

/* compiled from: ScaleAlphaAnimator.java */
/* loaded from: classes.dex */
public class c extends b {
    public c(View view, com.lxj.xpopup.c.c cVar) {
        super(view, cVar);
    }

    @Override // com.lxj.xpopup.a.b
    public void a() {
        this.f5373a.setScaleX(0.0f);
        this.f5373a.setScaleY(0.0f);
        this.f5373a.setAlpha(0.0f);
        this.f5373a.post(new Runnable() { // from class: com.lxj.xpopup.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScaleAlphaAnimator.java */
    /* renamed from: com.lxj.xpopup.a.c$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5376a;

        static {
            int[] iArr = new int[com.lxj.xpopup.c.c.values().length];
            f5376a = iArr;
            try {
                iArr[com.lxj.xpopup.c.c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5376a[com.lxj.xpopup.c.c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5376a[com.lxj.xpopup.c.c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5376a[com.lxj.xpopup.c.c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5376a[com.lxj.xpopup.c.c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i = AnonymousClass2.f5376a[this.f5374b.ordinal()];
        if (i == 1) {
            this.f5373a.setPivotX(this.f5373a.getMeasuredWidth() / 2);
            this.f5373a.setPivotY(this.f5373a.getMeasuredHeight() / 2);
        } else if (i == 2) {
            this.f5373a.setPivotX(0.0f);
            this.f5373a.setPivotY(0.0f);
        } else if (i == 3) {
            this.f5373a.setPivotX(this.f5373a.getMeasuredWidth());
            this.f5373a.setPivotY(0.0f);
        } else if (i == 4) {
            this.f5373a.setPivotX(0.0f);
            this.f5373a.setPivotY(this.f5373a.getMeasuredHeight());
        } else if (i != 5) {
        } else {
            this.f5373a.setPivotX(this.f5373a.getMeasuredWidth());
            this.f5373a.setPivotY(this.f5373a.getMeasuredHeight());
        }
    }

    @Override // com.lxj.xpopup.a.b
    public void b() {
        this.f5373a.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(com.lxj.xpopup.a.b()).setInterpolator(new OvershootInterpolator(1.0f)).start();
    }

    @Override // com.lxj.xpopup.a.b
    public void c() {
        this.f5373a.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(com.lxj.xpopup.a.b()).setInterpolator(new androidx.d.a.a.b()).start();
    }
}

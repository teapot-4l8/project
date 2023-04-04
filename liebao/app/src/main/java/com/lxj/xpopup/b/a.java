package com.lxj.xpopup.b;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewGroup;
import com.lxj.xpopup.R;
import com.lxj.xpopup.widget.PartShadowContainer;

/* compiled from: AttachPopupView.java */
/* loaded from: classes.dex */
public abstract class a extends b {

    /* renamed from: a  reason: collision with root package name */
    protected int f5397a;

    /* renamed from: b  reason: collision with root package name */
    protected int f5398b;

    /* renamed from: c  reason: collision with root package name */
    protected PartShadowContainer f5399c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5400d;

    /* renamed from: e  reason: collision with root package name */
    boolean f5401e;
    protected int f;
    float g;
    float h;
    float i;
    float j;

    protected Drawable getPopupBackground() {
        return null;
    }

    @Override // com.lxj.xpopup.b.b
    protected int getPopupLayoutId() {
        return R.layout._xpopup_attach_popup_view;
    }

    @Override // com.lxj.xpopup.b.b
    protected void a() {
        super.a();
        if (this.k.a() == null && this.k.j == null) {
            throw new IllegalArgumentException("atView() or touchPoint must not be null for AttachPopupView ！");
        }
        this.f5397a = this.k.t == 0 ? com.lxj.xpopup.g.c.a(getContext(), 4.0f) : this.k.t;
        this.f5398b = this.k.s == 0 ? com.lxj.xpopup.g.c.a(getContext(), 0.0f) : this.k.s;
        this.f5399c.setTranslationX(this.k.s);
        this.f5399c.setTranslationY(this.k.t);
        if (!this.k.f5446e.booleanValue()) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (getPopupBackground() == null) {
                    this.f5399c.setBackgroundColor(-1);
                } else {
                    this.f5399c.setBackgroundDrawable(getPopupBackground());
                }
                this.f5399c.setElevation(com.lxj.xpopup.g.c.a(getContext(), 10.0f));
            } else if (getPopupImplView().getBackground() == null) {
                int i = this.f5398b;
                int i2 = this.f;
                this.f5398b = i - i2;
                this.f5397a -= i2;
                this.f5399c.setBackgroundResource(R.drawable._xpopup_shadow);
            } else {
                this.f5399c.setBackgroundDrawable(getPopupBackground());
            }
        }
        com.lxj.xpopup.g.c.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), new Runnable() { // from class: com.lxj.xpopup.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.b();
            }
        });
    }

    protected void b() {
        if (this.k.j != null) {
            this.j = Math.max(this.k.j.x - getPopupContentView().getMeasuredWidth(), 0.0f);
            if (this.k.j.y + ((float) getPopupContentView().getMeasuredHeight()) > this.i) {
                this.f5400d = this.k.j.y > ((float) (com.lxj.xpopup.g.c.b(getContext()) / 2));
            } else {
                this.f5400d = false;
            }
            this.f5401e = this.k.j.x < ((float) (com.lxj.xpopup.g.c.a(getContext()) / 2));
            if (c()) {
                if (getPopupContentView().getMeasuredHeight() > this.k.j.y) {
                    ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
                    layoutParams.height = (int) (this.k.j.y - com.lxj.xpopup.g.c.a());
                    getPopupContentView().setLayoutParams(layoutParams);
                }
            } else if (getPopupContentView().getMeasuredHeight() + this.k.j.y > com.lxj.xpopup.g.c.b(getContext())) {
                ViewGroup.LayoutParams layoutParams2 = getPopupContentView().getLayoutParams();
                layoutParams2.height = (int) (com.lxj.xpopup.g.c.b(getContext()) - this.k.j.y);
                getPopupContentView().setLayoutParams(layoutParams2);
            }
            getPopupContentView().post(new Runnable() { // from class: com.lxj.xpopup.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.g = (aVar.f5401e ? a.this.k.j.x : a.this.j) + (a.this.f5401e ? a.this.f5398b : -a.this.f5398b);
                    if (a.this.k.v) {
                        if (a.this.f5401e) {
                            a.this.g -= a.this.getPopupContentView().getMeasuredWidth() / 2.0f;
                        } else {
                            a.this.g += a.this.getPopupContentView().getMeasuredWidth() / 2.0f;
                        }
                    }
                    if (a.this.c()) {
                        a aVar2 = a.this;
                        aVar2.h = (aVar2.k.j.y - a.this.getPopupContentView().getMeasuredHeight()) - a.this.f5397a;
                    } else {
                        a aVar3 = a.this;
                        aVar3.h = aVar3.k.j.y + a.this.f5397a;
                    }
                    a.this.getPopupContentView().setTranslationX(a.this.g);
                    a.this.getPopupContentView().setTranslationY(a.this.h);
                }
            });
            return;
        }
        int[] iArr = new int[2];
        this.k.a().getLocationOnScreen(iArr);
        final Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.k.a().getMeasuredWidth(), iArr[1] + this.k.a().getMeasuredHeight());
        this.j = Math.max(rect.right - getPopupContentView().getMeasuredWidth(), 0);
        int i = (rect.left + rect.right) / 2;
        if (((float) (rect.bottom + getPopupContentView().getMeasuredHeight())) > this.i) {
            this.f5400d = (rect.top + rect.bottom) / 2 > com.lxj.xpopup.g.c.b(getContext()) / 2;
        } else {
            this.f5400d = false;
        }
        this.f5401e = i < com.lxj.xpopup.g.c.a(getContext()) / 2;
        if (c()) {
            if (getPopupContentView().getMeasuredHeight() > rect.top) {
                ViewGroup.LayoutParams layoutParams3 = getPopupContentView().getLayoutParams();
                layoutParams3.height = rect.top - com.lxj.xpopup.g.c.a();
                getPopupContentView().setLayoutParams(layoutParams3);
            }
        } else if (getPopupContentView().getMeasuredHeight() + rect.bottom > com.lxj.xpopup.g.c.b(getContext())) {
            ViewGroup.LayoutParams layoutParams4 = getPopupContentView().getLayoutParams();
            layoutParams4.height = com.lxj.xpopup.g.c.b(getContext()) - rect.bottom;
            getPopupContentView().setLayoutParams(layoutParams4);
        }
        getPopupContentView().post(new Runnable() { // from class: com.lxj.xpopup.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.g = (aVar.f5401e ? rect.left : a.this.j) + (a.this.f5401e ? a.this.f5398b : -a.this.f5398b);
                if (a.this.k.v) {
                    if (a.this.f5401e) {
                        a.this.g += (rect.width() - a.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    } else {
                        a.this.g -= (rect.width() - a.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    }
                }
                if (a.this.c()) {
                    a.this.h = (rect.top - a.this.getPopupContentView().getMeasuredHeight()) - a.this.f5397a;
                } else {
                    a.this.h = rect.bottom + a.this.f5397a;
                }
                a.this.getPopupContentView().setTranslationX(a.this.g);
                a.this.getPopupContentView().setTranslationY(a.this.h);
            }
        });
    }

    protected boolean c() {
        return (this.f5400d || this.k.f5447q == com.lxj.xpopup.c.d.Top) && this.k.f5447q != com.lxj.xpopup.c.d.Bottom;
    }

    @Override // com.lxj.xpopup.b.b
    protected com.lxj.xpopup.a.b getPopupAnimator() {
        if (c()) {
            if (this.f5401e) {
                return new com.lxj.xpopup.a.d(getPopupContentView(), com.lxj.xpopup.c.c.ScrollAlphaFromLeftBottom);
            }
            return new com.lxj.xpopup.a.d(getPopupContentView(), com.lxj.xpopup.c.c.ScrollAlphaFromRightBottom);
        } else if (this.f5401e) {
            return new com.lxj.xpopup.a.d(getPopupContentView(), com.lxj.xpopup.c.c.ScrollAlphaFromLeftTop);
        } else {
            return new com.lxj.xpopup.a.d(getPopupContentView(), com.lxj.xpopup.c.c.ScrollAlphaFromRightTop);
        }
    }
}

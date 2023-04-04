package com.lxj.xpopup.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lxj.xpopup.R;
import com.lxj.xpopup.widget.SmartDragLayout;

/* compiled from: BottomPopupView.java */
/* loaded from: classes.dex */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    protected SmartDragLayout f5421a;

    @Override // com.lxj.xpopup.b.b
    protected int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.b.b
    protected int getPopupLayoutId() {
        return R.layout._xpopup_bottom_popup_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public void a() {
        super.a();
        this.f5421a = (SmartDragLayout) findViewById(R.id.bottomPopupContainer);
        this.f5421a.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f5421a, false));
        this.f5421a.enableDrag(this.k.u.booleanValue());
        this.f5421a.dismissOnTouchOutside(this.k.f5444c.booleanValue());
        this.f5421a.hasShadowBg(this.k.f5446e.booleanValue());
        getPopupImplView().setTranslationX(this.k.s);
        getPopupImplView().setTranslationY(this.k.t);
        com.lxj.xpopup.g.c.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight());
        this.f5421a.setOnCloseListener(new SmartDragLayout.OnCloseListener() { // from class: com.lxj.xpopup.b.c.1
            @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
            public void onClose() {
                c.this.o();
            }

            @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
            public void onOpen() {
                c.super.g();
            }
        });
        this.f5421a.setOnClickListener(new View.OnClickListener() { // from class: com.lxj.xpopup.b.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public void g() {
        if (this.k.u.booleanValue()) {
            return;
        }
        super.g();
    }

    @Override // com.lxj.xpopup.b.b
    public void l() {
        if (this.k.u.booleanValue()) {
            this.f5421a.open();
        } else {
            super.l();
        }
    }

    @Override // com.lxj.xpopup.b.b
    public void m() {
        if (this.k.u.booleanValue()) {
            this.f5421a.close();
        } else {
            super.m();
        }
    }

    @Override // com.lxj.xpopup.b.b
    public int getAnimationDuration() {
        if (this.k.u.booleanValue()) {
            return 0;
        }
        return super.getAnimationDuration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public com.lxj.xpopup.a.b getPopupAnimator() {
        if (this.k.u.booleanValue()) {
            return null;
        }
        return super.getPopupAnimator();
    }

    @Override // com.lxj.xpopup.b.b
    public void n() {
        if (this.k.u.booleanValue()) {
            if (this.n == com.lxj.xpopup.c.e.Dismissing) {
                return;
            }
            this.n = com.lxj.xpopup.c.e.Dismissing;
            if (this.k.m.booleanValue()) {
                com.lxj.xpopup.g.b.b(this);
            }
            clearFocus();
            this.f5421a.close();
            return;
        }
        super.n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public int getMaxWidth() {
        return this.k.k == 0 ? com.lxj.xpopup.g.c.a(getContext()) : this.k.k;
    }

    @Override // com.lxj.xpopup.b.b
    protected View getTargetSizeView() {
        return getPopupImplView();
    }
}

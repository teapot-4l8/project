package com.lxj.xpopup.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lxj.xpopup.R;

/* compiled from: CenterPopupView.java */
/* loaded from: classes.dex */
public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    protected FrameLayout f5424a;

    @Override // com.lxj.xpopup.b.b
    protected int getImplLayoutId() {
        return 0;
    }

    public d(Context context) {
        super(context);
        this.f5424a = (FrameLayout) findViewById(R.id.centerPopupContainer);
    }

    @Override // com.lxj.xpopup.b.b
    protected int getPopupLayoutId() {
        return R.layout._xpopup_center_popup_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public void a() {
        super.a();
        View inflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f5424a, false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 17;
        this.f5424a.addView(inflate, layoutParams);
        getPopupContentView().setTranslationX(this.k.s);
        getPopupContentView().setTranslationY(this.k.t);
        com.lxj.xpopup.g.c.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setTranslationY(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public int getMaxWidth() {
        return this.k.k == 0 ? (int) (com.lxj.xpopup.g.c.a(getContext()) * 0.86f) : this.k.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public com.lxj.xpopup.a.b getPopupAnimator() {
        return new com.lxj.xpopup.a.c(getPopupContentView(), com.lxj.xpopup.c.c.ScaleAlphaFromCenter);
    }
}

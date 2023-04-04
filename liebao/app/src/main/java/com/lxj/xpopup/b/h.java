package com.lxj.xpopup.b;

import android.view.ViewGroup;
import com.lxj.xpopup.R;
import com.lxj.xpopup.widget.PartShadowContainer;

/* compiled from: PositionPopupView.java */
/* loaded from: classes.dex */
public class h extends b {

    /* renamed from: a  reason: collision with root package name */
    PartShadowContainer f5448a;

    @Override // com.lxj.xpopup.b.b
    protected int getPopupLayoutId() {
        return R.layout._xpopup_attach_popup_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public void a() {
        super.a();
        com.lxj.xpopup.g.c.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), new Runnable() { // from class: com.lxj.xpopup.b.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.k.v) {
                    h.this.f5448a.setTranslationX((com.lxj.xpopup.g.c.a(h.this.getContext()) - h.this.f5448a.getMeasuredWidth()) / 2.0f);
                } else {
                    h.this.f5448a.setTranslationX(h.this.k.s);
                }
                h.this.f5448a.setTranslationY(h.this.k.t);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public com.lxj.xpopup.a.b getPopupAnimator() {
        return new com.lxj.xpopup.a.d(getPopupContentView(), com.lxj.xpopup.c.c.ScaleAlphaFromCenter);
    }
}

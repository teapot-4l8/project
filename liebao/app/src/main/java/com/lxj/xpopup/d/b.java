package com.lxj.xpopup.d;

import android.view.MotionEvent;
import com.lxj.xpopup.a.g;
import com.lxj.xpopup.c.c;

/* compiled from: PartShadowPopupView.java */
/* loaded from: classes.dex */
public abstract class b extends com.lxj.xpopup.b.a {
    @Override // com.lxj.xpopup.b.b, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.k.f5444c.booleanValue()) {
            n();
        }
        return !this.k.f5444c.booleanValue();
    }

    @Override // com.lxj.xpopup.b.a, com.lxj.xpopup.b.b
    protected com.lxj.xpopup.a.b getPopupAnimator() {
        return new g(getPopupImplView(), this.f5400d ? c.TranslateFromBottom : c.TranslateFromTop);
    }
}

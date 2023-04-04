package com.lxj.xpopup.b;

import android.view.View;
import com.lxj.xpopup.R;

/* compiled from: DrawerPopupView.java */
/* loaded from: classes.dex */
public abstract class e extends b {
    @Override // com.lxj.xpopup.b.b
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.lxj.xpopup.b.b
    protected int getPopupLayoutId() {
        return R.layout._xpopup_drawer_popup_view;
    }

    @Override // com.lxj.xpopup.b.b
    protected View getTargetSizeView() {
        return getPopupImplView();
    }
}

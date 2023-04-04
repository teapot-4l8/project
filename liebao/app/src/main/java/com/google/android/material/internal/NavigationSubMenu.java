package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.r;

/* loaded from: classes.dex */
public class NavigationSubMenu extends r {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, i iVar) {
        super(context, navigationMenu, iVar);
    }

    @Override // androidx.appcompat.view.menu.g
    public void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        ((g) getParentMenu()).onItemsChanged(z);
    }
}

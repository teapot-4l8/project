package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* compiled from: MenuPresenter.java */
/* loaded from: classes.dex */
public interface m {

    /* compiled from: MenuPresenter.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(g gVar, boolean z);

        boolean a(g gVar);
    }

    boolean collapseItemActionView(g gVar, i iVar);

    boolean expandItemActionView(g gVar, i iVar);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, g gVar);

    void onCloseMenu(g gVar, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(r rVar);

    void setCallback(a aVar);

    void updateMenuView(boolean z);
}

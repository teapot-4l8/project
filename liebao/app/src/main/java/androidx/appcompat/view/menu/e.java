package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter.java */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener, m {

    /* renamed from: a  reason: collision with root package name */
    Context f777a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f778b;

    /* renamed from: c  reason: collision with root package name */
    g f779c;

    /* renamed from: d  reason: collision with root package name */
    ExpandedMenuView f780d;

    /* renamed from: e  reason: collision with root package name */
    int f781e;
    int f;
    int g;
    a h;
    private m.a i;
    private int j;

    @Override // androidx.appcompat.view.menu.m
    public boolean collapseItemActionView(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean expandItemActionView(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean flagActionItems() {
        return false;
    }

    public e(Context context, int i) {
        this(i, 0);
        this.f777a = context;
        this.f778b = LayoutInflater.from(context);
    }

    public e(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    @Override // androidx.appcompat.view.menu.m
    public void initForMenu(Context context, g gVar) {
        if (this.f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f);
            this.f777a = contextThemeWrapper;
            this.f778b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f777a != null) {
            this.f777a = context;
            if (this.f778b == null) {
                this.f778b = LayoutInflater.from(context);
            }
        }
        this.f779c = gVar;
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public n a(ViewGroup viewGroup) {
        if (this.f780d == null) {
            this.f780d = (ExpandedMenuView) this.f778b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.f780d.setAdapter((ListAdapter) this.h);
            this.f780d.setOnItemClickListener(this);
        }
        return this.f780d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    @Override // androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void setCallback(m.a aVar) {
        this.i = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean onSubMenuSelected(r rVar) {
        if (rVar.hasVisibleItems()) {
            new h(rVar).a((IBinder) null);
            m.a aVar = this.i;
            if (aVar != null) {
                aVar.a(rVar);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void onCloseMenu(g gVar, boolean z) {
        m.a aVar = this.i;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f779c.performItemAction(this.h.getItem(i), this, 0);
    }

    public void a(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f780d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void b(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f780d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.j;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable onSaveInstanceState() {
        if (this.f780d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        a(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.m
    public void onRestoreInstanceState(Parcelable parcelable) {
        b((Bundle) parcelable);
    }

    /* compiled from: ListMenuPresenter.java */
    /* loaded from: classes.dex */
    private class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f783b = -1;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public a() {
            a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f779c.getNonActionItems().size() - e.this.f781e;
            return this.f783b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: a */
        public i getItem(int i) {
            ArrayList<i> nonActionItems = e.this.f779c.getNonActionItems();
            int i2 = i + e.this.f781e;
            int i3 = this.f783b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = e.this.f778b.inflate(e.this.g, viewGroup, false);
            }
            ((n.a) view).initialize(getItem(i), 0);
            return view;
        }

        void a() {
            i expandedItem = e.this.f779c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<i> nonActionItems = e.this.f779c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f783b = i;
                        return;
                    }
                }
            }
            this.f783b = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
}

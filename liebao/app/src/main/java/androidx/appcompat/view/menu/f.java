package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    g f784a;

    /* renamed from: b  reason: collision with root package name */
    private int f785b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f786c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f787d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f788e;
    private final int f;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.f787d = z;
        this.f788e = layoutInflater;
        this.f784a = gVar;
        this.f = i;
        b();
    }

    public void a(boolean z) {
        this.f786c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> nonActionItems = this.f787d ? this.f784a.getNonActionItems() : this.f784a.getVisibleItems();
        if (this.f785b < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    public g a() {
        return this.f784a;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public i getItem(int i) {
        ArrayList<i> nonActionItems = this.f787d ? this.f784a.getNonActionItems() : this.f784a.getVisibleItems();
        int i2 = this.f785b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return nonActionItems.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f788e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f784a.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f786c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i), 0);
        return view;
    }

    void b() {
        i expandedItem = this.f784a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<i> nonActionItems = this.f784a.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.f785b = i;
                    return;
                }
            }
        }
        this.f785b = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
